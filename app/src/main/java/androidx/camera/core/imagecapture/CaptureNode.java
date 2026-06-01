package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class CaptureNode implements Node<In, ProcessingNode.In> {

    @VisibleForTesting
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    private In mInputEdge;
    private ProcessingNode.In mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderForPostview;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;
    SafeCloseImageReaderProxy mSecondarySafeCloseImageReaderProxy;
    ProcessingRequest mCurrentRequest = null;
    private NoMetadataImageReader mNoMetadataImageReader = null;

    /* JADX INFO: renamed from: androidx.camera.core.imagecapture.CaptureNode$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 extends CameraCaptureCallback {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptureProcessProgressed$1(int i2) {
            ProcessingRequest processingRequest = CaptureNode.this.mCurrentRequest;
            if (processingRequest != null) {
                processingRequest.onCaptureProcessProgressed(i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptureStarted$0() {
            ProcessingRequest processingRequest = CaptureNode.this.mCurrentRequest;
            if (processingRequest != null) {
                processingRequest.onCaptureStarted();
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureProcessProgressed(int i2, int i8) {
            CameraXExecutors.mainThreadExecutor().execute(new d(this, i8, 0));
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int i2) {
            CameraXExecutors.mainThreadExecutor().execute(new j(this, 2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.imagecapture.CaptureNode.In.1
        };
        private DeferrableSurface mPostviewSurface = null;
        private CameraCaptureCallback mSecondaryCameraCaptureCallback;
        private DeferrableSurface mSecondarySurface;
        private DeferrableSurface mSurface;

        public static In of(Size size, int i2, List<Integer> list, boolean z2, ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i2, list, z2, imageReaderProxyProvider, null, new Edge(), new Edge());
        }

        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        public abstract Edge<TakePictureManager.CaptureError> getErrorEdge();

        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract List<Integer> getOutputFormats();

        public abstract PostviewSettings getPostviewSettings();

        public DeferrableSurface getPostviewSurface() {
            return this.mPostviewSurface;
        }

        public abstract Edge<ProcessingRequest> getRequestEdge();

        public CameraCaptureCallback getSecondaryCameraCaptureCallback() {
            return this.mSecondaryCameraCaptureCallback;
        }

        public DeferrableSurface getSecondarySurface() {
            return this.mSecondarySurface;
        }

        public abstract Size getSize();

        public DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        public abstract boolean isVirtualCamera();

        public void setCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setPostviewSurface(Surface surface, Size size, int i2) {
            this.mPostviewSurface = new ImmediateSurface(surface, size, i2);
        }

        public void setSecondaryCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mSecondaryCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setSecondarySurface(Surface surface) {
            Preconditions.checkState(this.mSecondarySurface == null, "The secondary surface is already set.");
            this.mSecondarySurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        public void setSurface(Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        public static In of(Size size, int i2, List<Integer> list, boolean z2, ImageReaderProxyProvider imageReaderProxyProvider, PostviewSettings postviewSettings) {
            return new AutoValue_CaptureNode_In(size, i2, list, z2, imageReaderProxyProvider, postviewSettings, new Edge(), new Edge());
        }
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider imageReaderProxyProvider, int i2, int i8, int i9) {
        return imageReaderProxyProvider != null ? imageReaderProxyProvider.newInstance(i2, i8, i9, 4, 0L) : ImageReaderProxys.createIsolatedReader(i2, i8, i9, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseInputResources$4(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseInputResources$5(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnImageAvailableListener$2(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                onImageProxyAvailable(imageProxyAcquireLatestImage);
                return;
            }
            ProcessingRequest processingRequest = this.mCurrentRequest;
            if (processingRequest != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", null)));
            }
        } catch (IllegalStateException e) {
            ProcessingRequest processingRequest2 = this.mCurrentRequest;
            if (processingRequest2 != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest2.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        this.mNoMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                propagatePostviewImage(imageProxyAcquireLatestImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire latest image of postview", e);
        }
    }

    @MainThread
    private void matchAndPropagateImage(ImageProxy imageProxy) {
        ProcessingRequest processingRequest;
        ProcessingRequest processingRequest2;
        Threads.checkMainThread();
        ProcessingNode.In in = this.mOutputEdge;
        Objects.requireNonNull(in);
        in.getEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
        ProcessingRequest processingRequest3 = this.mCurrentRequest;
        In in2 = this.mInputEdge;
        boolean z2 = in2 != null && in2.getOutputFormats().size() > 1;
        if (z2 && (processingRequest2 = this.mCurrentRequest) != null) {
            processingRequest2.getTakePictureRequest().markFormatProcessStatusInSimultaneousCapture(imageProxy.getFormat(), true);
        }
        if (!z2 || ((processingRequest = this.mCurrentRequest) != null && processingRequest.getTakePictureRequest().isFormatProcessedInSimultaneousCapture())) {
            this.mCurrentRequest = null;
        }
        processingRequest3.onImageCaptured();
    }

    private void propagatePostviewImage(ImageProxy imageProxy) {
        if (this.mCurrentRequest == null) {
            Logger.w(TAG, "Postview image is closed due to request completed or aborted");
            imageProxy.close();
        } else {
            ProcessingNode.In in = this.mOutputEdge;
            Objects.requireNonNull(in);
            in.getPostviewEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
        }
    }

    private void releaseInputResources(In in, final SafeCloseImageReaderProxy safeCloseImageReaderProxy, final SafeCloseImageReaderProxy safeCloseImageReaderProxy2, final SafeCloseImageReaderProxy safeCloseImageReaderProxy3) {
        in.getSurface().close();
        final int i2 = 0;
        in.getSurface().getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.c
            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        safeCloseImageReaderProxy.safeClose();
                        break;
                    case 1:
                        CaptureNode.lambda$releaseInputResources$4(safeCloseImageReaderProxy);
                        break;
                    default:
                        CaptureNode.lambda$releaseInputResources$5(safeCloseImageReaderProxy);
                        break;
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
        if (in.getPostviewSurface() != null) {
            in.getPostviewSurface().close();
            final int i8 = 1;
            in.getPostviewSurface().getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.c
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i8) {
                        case 0:
                            safeCloseImageReaderProxy3.safeClose();
                            break;
                        case 1:
                            CaptureNode.lambda$releaseInputResources$4(safeCloseImageReaderProxy3);
                            break;
                        default:
                            CaptureNode.lambda$releaseInputResources$5(safeCloseImageReaderProxy3);
                            break;
                    }
                }
            }, CameraXExecutors.mainThreadExecutor());
        }
        if (in.getOutputFormats().size() <= 1 || in.getSecondarySurface() == null) {
            return;
        }
        in.getSecondarySurface().close();
        final int i9 = 2;
        in.getSecondarySurface().getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.c
            @Override // java.lang.Runnable
            public final void run() {
                switch (i9) {
                    case 0:
                        safeCloseImageReaderProxy2.safeClose();
                        break;
                    case 1:
                        CaptureNode.lambda$releaseInputResources$4(safeCloseImageReaderProxy2);
                        break;
                    default:
                        CaptureNode.lambda$releaseInputResources$5(safeCloseImageReaderProxy2);
                        break;
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    private void setOnImageAvailableListener(ImageReaderProxy imageReaderProxy) {
        imageReaderProxy.setOnImageAvailableListener(new b(this, 1), CameraXExecutors.mainThreadExecutor());
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    @VisibleForTesting
    public In getInputEdge() {
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        return in;
    }

    @VisibleForTesting
    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        return safeCloseImageReaderProxy;
    }

    @MainThread
    @VisibleForTesting
    public void onImageProxyAvailable(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.w(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
            return;
        }
        if (((Integer) imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey())) != null) {
            matchAndPropagateImage(imageProxy);
        } else {
            Logger.w(TAG, "Discarding ImageProxy which was acquired for aborted request");
            imageProxy.close();
        }
    }

    @MainThread
    @VisibleForTesting
    public void onRequestAvailable(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        Preconditions.checkState(processingRequest.getStageIds().size() == 1, "only one capture stage is supported.");
        Preconditions.checkState(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        this.mCurrentRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Threads.checkMainThread();
                if (processingRequest == CaptureNode.this.mCurrentRequest) {
                    Logger.w(CaptureNode.TAG, "request aborted, id=" + CaptureNode.this.mCurrentRequest.getRequestId());
                    if (CaptureNode.this.mNoMetadataImageReader != null) {
                        CaptureNode.this.mNoMetadataImageReader.clearProcessingRequest();
                    }
                    CaptureNode.this.mCurrentRequest = null;
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    @MainThread
    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy, this.mSecondarySafeCloseImageReaderProxy, this.mSafeCloseImageReaderForPostview);
    }

    @MainThread
    public void sendCaptureError(TakePictureManager.CaptureError captureError) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest == null || processingRequest.getRequestId() != captureError.getRequestId()) {
            return;
        }
        this.mCurrentRequest.onCaptureFailure(captureError.getImageCaptureException());
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    @Override // androidx.camera.core.processing.Node
    public ProcessingNode.In transform(In in) {
        Consumer<ProcessingRequest> consumer;
        ImageReaderProxy imageReaderProxy;
        MetadataImageReader metadataImageReader;
        ImageReaderProxy imageReaderProxy2;
        final int i2 = 0;
        final int i8 = 1;
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        int inputFormat = in.getInputFormat();
        boolean zIsVirtualCamera = in.isVirtualCamera();
        CameraCaptureCallback anonymousClass1 = new AnonymousClass1();
        boolean z2 = in.getOutputFormats().size() > 1;
        final int i9 = 2;
        CameraCaptureCallback cameraCaptureCallbackCreateComboCallback = null;
        if (zIsVirtualCamera || in.getImageReaderProxyProvider() != null) {
            NoMetadataImageReader noMetadataImageReader = new NoMetadataImageReader(createImageReaderProxy(in.getImageReaderProxyProvider(), size.getWidth(), size.getHeight(), inputFormat));
            this.mNoMetadataImageReader = noMetadataImageReader;
            consumer = new Consumer(this) { // from class: androidx.camera.core.imagecapture.a

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CaptureNode f3584b;

                {
                    this.f3584b = this;
                }

                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    switch (i8) {
                        case 0:
                            this.f3584b.onRequestAvailable((ProcessingRequest) obj);
                            break;
                        case 1:
                            this.f3584b.lambda$transform$0((ProcessingRequest) obj);
                            break;
                        default:
                            this.f3584b.sendCaptureError((TakePictureManager.CaptureError) obj);
                            break;
                    }
                }
            };
            imageReaderProxy = noMetadataImageReader;
            metadataImageReader = null;
        } else {
            if (z2) {
                MetadataImageReader metadataImageReader2 = new MetadataImageReader(size.getWidth(), size.getHeight(), 256, 4);
                CameraCaptureCallback cameraCaptureCallbackCreateComboCallback2 = CameraCaptureCallbacks.createComboCallback(anonymousClass1, metadataImageReader2.getCameraCaptureCallback());
                metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), 32, 4);
                CameraCaptureCallback[] cameraCaptureCallbackArr = {anonymousClass1, metadataImageReader.getCameraCaptureCallback()};
                anonymousClass1 = cameraCaptureCallbackCreateComboCallback2;
                cameraCaptureCallbackCreateComboCallback = CameraCaptureCallbacks.createComboCallback(cameraCaptureCallbackArr);
                imageReaderProxy2 = metadataImageReader2;
            } else {
                MetadataImageReader metadataImageReader3 = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
                anonymousClass1 = CameraCaptureCallbacks.createComboCallback(anonymousClass1, metadataImageReader3.getCameraCaptureCallback());
                imageReaderProxy2 = metadataImageReader3;
                metadataImageReader = null;
            }
            consumer = new Consumer(this) { // from class: androidx.camera.core.imagecapture.a

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CaptureNode f3584b;

                {
                    this.f3584b = this;
                }

                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    switch (i2) {
                        case 0:
                            this.f3584b.onRequestAvailable((ProcessingRequest) obj);
                            break;
                        case 1:
                            this.f3584b.lambda$transform$0((ProcessingRequest) obj);
                            break;
                        default:
                            this.f3584b.sendCaptureError((TakePictureManager.CaptureError) obj);
                            break;
                    }
                }
            };
            imageReaderProxy = imageReaderProxy2;
        }
        in.setCameraCaptureCallback(anonymousClass1);
        if (z2 && cameraCaptureCallbackCreateComboCallback != null) {
            in.setSecondaryCameraCaptureCallback(cameraCaptureCallbackCreateComboCallback);
        }
        Surface surface = imageReaderProxy.getSurface();
        Objects.requireNonNull(surface);
        in.setSurface(surface);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(imageReaderProxy);
        setOnImageAvailableListener(imageReaderProxy);
        PostviewSettings postviewSettings = in.getPostviewSettings();
        if (postviewSettings != null) {
            ImageReaderProxy imageReaderProxyCreateImageReaderProxy = createImageReaderProxy(in.getImageReaderProxyProvider(), postviewSettings.getResolution().getWidth(), postviewSettings.getResolution().getHeight(), postviewSettings.getInputFormat());
            imageReaderProxyCreateImageReaderProxy.setOnImageAvailableListener(new b(this, i2), CameraXExecutors.mainThreadExecutor());
            this.mSafeCloseImageReaderForPostview = new SafeCloseImageReaderProxy(imageReaderProxyCreateImageReaderProxy);
            in.setPostviewSurface(imageReaderProxyCreateImageReaderProxy.getSurface(), postviewSettings.getResolution(), postviewSettings.getInputFormat());
        }
        if (z2 && metadataImageReader != null) {
            in.setSecondarySurface(metadataImageReader.getSurface());
            this.mSecondarySafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(metadataImageReader);
            setOnImageAvailableListener(metadataImageReader);
        }
        in.getRequestEdge().setListener(consumer);
        in.getErrorEdge().setListener(new Consumer(this) { // from class: androidx.camera.core.imagecapture.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CaptureNode f3584b;

            {
                this.f3584b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i9) {
                    case 0:
                        this.f3584b.onRequestAvailable((ProcessingRequest) obj);
                        break;
                    case 1:
                        this.f3584b.lambda$transform$0((ProcessingRequest) obj);
                        break;
                    default:
                        this.f3584b.sendCaptureError((TakePictureManager.CaptureError) obj);
                        break;
                }
            }
        });
        ProcessingNode.In inOf = ProcessingNode.In.of(in.getInputFormat(), in.getOutputFormats());
        this.mOutputEdge = inOf;
        return inOf;
    }
}
