package androidx.camera.core.streamsharing;

import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ForwardingCameraControl;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import j2.q;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VirtualCameraControl extends ForwardingCameraControl {
    private static final int DEFAULT_JPEG_QUALITY = 100;
    private static final int DEFAULT_ROTATION_DEGREES = 0;
    private final StreamSharing.Control mStreamSharingControl;

    public VirtualCameraControl(CameraControlInternal cameraControlInternal, StreamSharing.Control control) {
        super(cameraControlInternal);
        this.mStreamSharingControl = control;
    }

    private int getJpegQuality(CaptureConfig captureConfig) {
        Integer num = (Integer) captureConfig.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_JPEG_QUALITY, 100);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    private int getRotationDegrees(CaptureConfig captureConfig) {
        Integer num = (Integer) captureConfig.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_ROTATION, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q lambda$submitStillCaptureRequests$0(q qVar, CameraCapturePipeline cameraCapturePipeline) throws Exception {
        return ((CameraCapturePipeline) qVar.get()).invokePreCapture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ q lambda$submitStillCaptureRequests$1(List list, Void r42) throws Exception {
        return this.mStreamSharingControl.jpegSnapshot(getJpegQuality((CaptureConfig) list.get(0)), getRotationDegrees((CaptureConfig) list.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q lambda$submitStillCaptureRequests$2(q qVar, Void r1) throws Exception {
        return ((CameraCapturePipeline) qVar.get()).invokePostCapture();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    public q submitStillCaptureRequests(final List<CaptureConfig> list, int i2, int i8) {
        Preconditions.checkArgument(list.size() == 1, "Only support one capture config.");
        final q cameraCapturePipelineAsync = getCameraCapturePipelineAsync(i2, 1);
        final int i9 = 0;
        final int i10 = 1;
        return Futures.allAsList(Collections.singletonList(FutureChain.from(cameraCapturePipelineAsync).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.streamsharing.c
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final q apply(Object obj) {
                switch (i9) {
                    case 0:
                        return VirtualCameraControl.lambda$submitStillCaptureRequests$0(cameraCapturePipelineAsync, (CameraCapturePipeline) obj);
                    default:
                        return VirtualCameraControl.lambda$submitStillCaptureRequests$2(cameraCapturePipelineAsync, (Void) obj);
                }
            }
        }, CameraXExecutors.directExecutor()).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.streamsharing.d
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final q apply(Object obj) {
                return this.f3748a.lambda$submitStillCaptureRequests$1(list, (Void) obj);
            }
        }, CameraXExecutors.directExecutor()).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.streamsharing.c
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final q apply(Object obj) {
                switch (i10) {
                    case 0:
                        return VirtualCameraControl.lambda$submitStillCaptureRequests$0(cameraCapturePipelineAsync, (CameraCapturePipeline) obj);
                    default:
                        return VirtualCameraControl.lambda$submitStillCaptureRequests$2(cameraCapturePipelineAsync, (Void) obj);
                }
            }
        }, CameraXExecutors.directExecutor())));
    }
}
