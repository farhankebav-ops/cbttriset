package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceRequest {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    private final CameraInternal mCamera;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRate;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final boolean mIsPrimary;
    private final Object mLock;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final j2.q mSessionStatusFuture;
    private final int mSessionType;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final j2.q mSurfaceFuture;
    private final CallbackToFutureAdapter.Completer<Void> mSurfaceRecreationCompleter;

    @GuardedBy("mLock")
    private TransformationInfo mTransformationInfo;

    @GuardedBy("mLock")
    private Executor mTransformationInfoExecutor;

    @GuardedBy("mLock")
    private TransformationInfoListener mTransformationInfoListener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class RequestCancelledException extends RuntimeException {
        public RequestCancelledException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ResultCode {
        }

        public static Result of(int i2, Surface surface) {
            return new AutoValue_SurfaceRequest_Result(i2, surface);
        }

        public abstract int getResultCode();

        public abstract Surface getSurface();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class TransformationInfo {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static TransformationInfo of(Rect rect, int i2, int i8, boolean z2, Matrix matrix, boolean z7) {
            return new AutoValue_SurfaceRequest_TransformationInfo(rect, i2, i8, z2, matrix, z7);
        }

        public abstract Rect getCropRect();

        public abstract int getRotationDegrees();

        public abstract Matrix getSensorToBufferTransform();

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract int getTargetRotation();

        public abstract boolean hasCameraTransform();

        public abstract boolean isMirroring();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(TransformationInfo transformationInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceRequest(Size size, CameraInternal cameraInternal, Runnable runnable) {
        this(size, cameraInternal, DynamicRange.SDR, FRAME_RATE_RANGE_UNSPECIFIED, runnable);
    }

    private CallbackToFutureAdapter.Completer<Void> initialSurfaceRecreationCompleter(Executor executor, final Runnable runnable) {
        AtomicReference atomicReference = new AtomicReference(null);
        Futures.addCallback(CallbackToFutureAdapter.getFuture(new l(1, this, atomicReference)), new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.5
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
                runnable.run();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }
        }, executor);
        return (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$initialSurfaceRecreationCompleter$7(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "SurfaceRequest-surface-recreation(" + hashCode() + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-cancellation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$1(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-status";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$2(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-Surface";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        this.mSurfaceFuture.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$provideSurface$4(Consumer consumer, Surface surface) {
        consumer.accept(Result.of(2, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$provideSurface$5(Consumer consumer, Surface surface) {
        consumer.accept(Result.of(3, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$provideSurface$6(Consumer consumer, Surface surface) {
        consumer.accept(Result.of(4, surface));
    }

    public void addRequestCancellationListener(Executor executor, Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    public void clearTransformationInfoListener() {
        synchronized (this.mLock) {
            this.mTransformationInfoListener = null;
            this.mTransformationInfoExecutor = null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera() {
        return this.mCamera;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public DynamicRange getDynamicRange() {
        return this.mDynamicRange;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Range<Integer> getExpectedFrameRate() {
        return this.mExpectedFrameRate;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getSessionType() {
        return this.mSessionType;
    }

    public boolean invalidate() {
        willNotProvideSurface();
        return this.mSurfaceRecreationCompleter.set(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isPrimary() {
        return this.mIsPrimary;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isServiced() {
        return this.mSurfaceFuture.isDone();
    }

    public void provideSurface(final Surface surface, Executor executor, final Consumer<Result> consumer) {
        if (!surface.isValid()) {
            final int i2 = 0;
            executor.execute(new Runnable() { // from class: androidx.camera.core.h0
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            SurfaceRequest.lambda$provideSurface$4(consumer, surface);
                            break;
                        case 1:
                            SurfaceRequest.lambda$provideSurface$5(consumer, surface);
                            break;
                        default:
                            SurfaceRequest.lambda$provideSurface$6(consumer, surface);
                            break;
                    }
                }
            });
            return;
        }
        if (this.mSurfaceCompleter.set(surface) || this.mSurfaceFuture.isCancelled()) {
            Futures.addCallback(this.mSessionStatusFuture, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.4
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    Preconditions.checkState(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
                    consumer.accept(Result.of(1, surface));
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r32) {
                    consumer.accept(Result.of(0, surface));
                }
            }, executor);
            return;
        }
        Preconditions.checkState(this.mSurfaceFuture.isDone());
        try {
            this.mSurfaceFuture.get();
            final int i8 = 1;
            executor.execute(new Runnable() { // from class: androidx.camera.core.h0
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i8) {
                        case 0:
                            SurfaceRequest.lambda$provideSurface$4(consumer, surface);
                            break;
                        case 1:
                            SurfaceRequest.lambda$provideSurface$5(consumer, surface);
                            break;
                        default:
                            SurfaceRequest.lambda$provideSurface$6(consumer, surface);
                            break;
                    }
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            final int i9 = 2;
            executor.execute(new Runnable() { // from class: androidx.camera.core.h0
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i9) {
                        case 0:
                            SurfaceRequest.lambda$provideSurface$4(consumer, surface);
                            break;
                        case 1:
                            SurfaceRequest.lambda$provideSurface$5(consumer, surface);
                            break;
                        default:
                            SurfaceRequest.lambda$provideSurface$6(consumer, surface);
                            break;
                    }
                }
            });
        }
    }

    public void setTransformationInfoListener(Executor executor, TransformationInfoListener transformationInfoListener) {
        TransformationInfo transformationInfo;
        synchronized (this.mLock) {
            this.mTransformationInfoListener = transformationInfoListener;
            this.mTransformationInfoExecutor = executor;
            transformationInfo = this.mTransformationInfo;
        }
        if (transformationInfo != null) {
            executor.execute(new g0(transformationInfoListener, transformationInfo, 1));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateTransformationInfo(TransformationInfo transformationInfo) {
        TransformationInfoListener transformationInfoListener;
        Executor executor;
        synchronized (this.mLock) {
            this.mTransformationInfo = transformationInfo;
            transformationInfoListener = this.mTransformationInfoListener;
            executor = this.mTransformationInfoExecutor;
        }
        if (transformationInfoListener == null || executor == null) {
            return;
        }
        executor.execute(new g0(transformationInfoListener, transformationInfo, 0));
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceRequest(Size size, CameraInternal cameraInternal, DynamicRange dynamicRange, Range<Integer> range, Runnable runnable) {
        this(size, cameraInternal, true, dynamicRange, 0, range, runnable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceRequest(Size size, CameraInternal cameraInternal, boolean z2, DynamicRange dynamicRange, int i2, Range<Integer> range, Runnable runnable) {
        this.mLock = new Object();
        this.mResolution = size;
        this.mCamera = cameraInternal;
        this.mIsPrimary = z2;
        Preconditions.checkArgument(dynamicRange.isFullySpecified(), "SurfaceRequest's DynamicRange must always be fully specified.");
        this.mDynamicRange = dynamicRange;
        this.mSessionType = i2;
        this.mExpectedFrameRate = range;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + C2300e4.i.e;
        final AtomicReference atomicReference = new AtomicReference(null);
        final int i8 = 0;
        final j2.q future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.i0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i8) {
                    case 0:
                        return SurfaceRequest.lambda$new$0(atomicReference, str, completer);
                    case 1:
                        return SurfaceRequest.lambda$new$1(atomicReference, str, completer);
                    default:
                        return SurfaceRequest.lambda$new$2(atomicReference, str, completer);
                }
            }
        });
        final CallbackToFutureAdapter.Completer<Void> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
        this.mRequestCancellationCompleter = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        final int i9 = 1;
        j2.q future2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.i0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer2) {
                switch (i9) {
                    case 0:
                        return SurfaceRequest.lambda$new$0(atomicReference2, str, completer2);
                    case 1:
                        return SurfaceRequest.lambda$new$1(atomicReference2, str, completer2);
                    default:
                        return SurfaceRequest.lambda$new$2(atomicReference2, str, completer2);
                }
            }
        });
        this.mSessionStatusFuture = future2;
        Futures.addCallback(future2, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof RequestCancelledException) {
                    Preconditions.checkState(future.cancel(false));
                } else {
                    Preconditions.checkState(completer.set(null));
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r22) {
                Preconditions.checkState(completer.set(null));
            }
        }, CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        final int i10 = 2;
        j2.q future3 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.i0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer22) {
                switch (i10) {
                    case 0:
                        return SurfaceRequest.lambda$new$0(atomicReference3, str, completer22);
                    case 1:
                        return SurfaceRequest.lambda$new$1(atomicReference3, str, completer22);
                    default:
                        return SurfaceRequest.lambda$new$2(atomicReference3, str, completer22);
                }
            }
        });
        this.mSurfaceFuture = future3;
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference3.get());
        DeferrableSurface deferrableSurface = new DeferrableSurface(size, 34) { // from class: androidx.camera.core.SurfaceRequest.2
            @Override // androidx.camera.core.impl.DeferrableSurface
            public j2.q provideSurface() {
                return SurfaceRequest.this.mSurfaceFuture;
            }
        };
        this.mInternalDeferrableSurface = deferrableSurface;
        final j2.q terminationFuture = deferrableSurface.getTerminationFuture();
        Futures.addCallback(future3, new FutureCallback<Surface>() { // from class: androidx.camera.core.SurfaceRequest.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof CancellationException) {
                    Preconditions.checkState(completer2.setException(new RequestCancelledException(a1.a.r(new StringBuilder(), str, " cancelled."), th)));
                } else {
                    completer2.set(null);
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Surface surface) {
                Futures.propagate(terminationFuture, completer2);
            }
        }, CameraXExecutors.directExecutor());
        terminationFuture.addListener(new f(this, 3), CameraXExecutors.directExecutor());
        this.mSurfaceRecreationCompleter = initialSurfaceRecreationCompleter(CameraXExecutors.directExecutor(), runnable);
    }
}
