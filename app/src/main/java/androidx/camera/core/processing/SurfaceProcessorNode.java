package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.MainThread;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";
    final CameraInternal mCameraInternal;
    private In mInput;
    private Out mOutput;
    final SurfaceProcessorInternal mSurfaceProcessor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class In {
        public static In of(SurfaceEdge surfaceEdge, List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }

        public abstract List<OutConfig> getOutConfigs();

        public abstract SurfaceEdge getSurfaceEdge();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(CameraInternal cameraInternal, SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createAndSendSurfaceOutput, reason: merged with bridge method [inline-methods] */
    public void lambda$sendSurfaceOutputs$0(SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        final SurfaceEdge value = entry.getValue();
        Futures.addCallback(value.createSurfaceOutputFuture(entry.getKey().getFormat(), SurfaceOutput.CameraInputInfo.of(surfaceEdge.getStreamSpec().getResolution(), entry.getKey().getCropRect(), surfaceEdge.hasCameraTransform() ? this.mCameraInternal : null, entry.getKey().getRotationDegrees(), entry.getKey().isMirroring()), null), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (value.getTargets() == 2 && (th instanceof CancellationException)) {
                    Logger.d(SurfaceProcessorNode.TAG, "Downstream VideoCapture failed to provide Surface.");
                    return;
                }
                Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface. Target: " + TargetUtils.getHumanReadableName(value.getTargets()), th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            Iterator<SurfaceEdge> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).isMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    private void sendSurfaceOutputs(SurfaceEdge surfaceEdge, Map<OutConfig, SurfaceEdge> map) {
        for (Map.Entry<OutConfig, SurfaceEdge> entry : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, entry);
            entry.getValue().addOnInvalidatedListener(new c(this, surfaceEdge, entry, 2));
        }
    }

    private void sendSurfaceRequest(SurfaceEdge surfaceEdge) {
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceEdge.createSurfaceRequest(this.mCameraInternal));
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge surfaceEdge, OutConfig outConfig) {
        Rect rectSizeToRect;
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean zIsMirroring = outConfig.isMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, zIsMirroring);
        matrix.postConcat(rectToRect);
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        if (outConfig.shouldRespectInputCropRect()) {
            Preconditions.checkArgument(outConfig.getCropRect().contains(surfaceEdge.getCropRect()), "Output crop rect " + outConfig.getCropRect() + " must contain input crop rect " + surfaceEdge.getCropRect());
            rectSizeToRect = new Rect();
            RectF rectF = new RectF(surfaceEdge.getCropRect());
            rectToRect.mapRect(rectF);
            rectF.round(rectSizeToRect);
        } else {
            rectSizeToRect = TransformUtils.sizeToRect(outConfig.getSize());
        }
        return new SurfaceEdge(outConfig.getTargets(), outConfig.getFormat(), surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build(), matrix, false, rectSizeToRect, surfaceEdge.getRotationDegrees() - rotationDegrees, -1, surfaceEdge.isMirroring() != zIsMirroring);
    }

    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        Threads.runOnMain(new b(this, 4));
    }

    public void setUpRotationUpdates(SurfaceEdge surfaceEdge, final Map<OutConfig, SurfaceEdge> map) {
        surfaceEdge.addTransformationUpdateListener(new Consumer() { // from class: androidx.camera.core.processing.r
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                SurfaceProcessorNode.lambda$setUpRotationUpdates$1(map, (SurfaceRequest.TransformationInfo) obj);
            }
        });
    }

    @Override // androidx.camera.core.processing.Node
    @MainThread
    public Out transform(In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig outConfig : in.getOutConfigs()) {
            this.mOutput.put(outConfig, transformSingleOutput(surfaceEdge, outConfig));
        }
        sendSurfaceRequest(surfaceEdge);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        setUpRotationUpdates(surfaceEdge, this.mOutput);
        return this.mOutput;
    }
}
