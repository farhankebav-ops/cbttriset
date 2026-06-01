package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class TorchControl {
    static final int DEFAULT_TORCH_STATE = 0;
    static final int OFF = 0;
    static final int ON = 1;
    private static final String TAG = "TorchControl";
    static final int USED_AS_FLASH = 2;
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private int mDefaultTorchStrength;
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    private boolean mIsTorchStrengthSupported;
    boolean mTargetTorchEnabled;
    private int mTargetTorchStrength;
    private final MutableLiveData<Integer> mTorchState;
    private final MutableLiveData<Integer> mTorchStrength;
    private CallbackToFutureAdapter.Completer<Void> mTorchStrengthCompleter;

    public TorchControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        Objects.requireNonNull(cameraCharacteristicsCompat);
        boolean zIsFlashAvailable = FlashAvailabilityChecker.isFlashAvailable(new v(cameraCharacteristicsCompat, 8));
        this.mHasFlashUnit = zIsFlashAvailable;
        boolean zIsTorchStrengthLevelSupported = cameraCharacteristicsCompat.isTorchStrengthLevelSupported();
        this.mIsTorchStrengthSupported = zIsTorchStrengthLevelSupported;
        int defaultTorchStrengthLevel = (zIsFlashAvailable && zIsTorchStrengthLevelSupported) ? cameraCharacteristicsCompat.getDefaultTorchStrengthLevel() : 0;
        this.mDefaultTorchStrength = defaultTorchStrengthLevel;
        this.mTargetTorchStrength = defaultTorchStrengthLevel;
        this.mTorchState = new MutableLiveData<>(0);
        this.mTorchStrength = new MutableLiveData<>(Integer.valueOf(this.mDefaultTorchStrength));
        camera2CameraControlImpl.addCaptureResultListener(new s0(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$enableTorch$2(int i2, boolean z2, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new c1(this, completer, i2, 1));
        return "enableTorch: " + z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(TotalCaptureResult totalCaptureResult) {
        Integer num;
        if (this.mEnableTorchCompleter != null) {
            Integer num2 = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if ((num2 != null && num2.intValue() == 2) == this.mTargetTorchEnabled) {
                this.mEnableTorchCompleter.set(null);
                this.mEnableTorchCompleter = null;
            }
        }
        if (this.mIsTorchStrengthSupported && Build.VERSION.SDK_INT >= 35 && this.mTorchStrengthCompleter != null && (num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STRENGTH_LEVEL)) != null && num.intValue() == this.mTargetTorchStrength) {
            this.mTorchStrengthCompleter.set(null);
            this.mTorchStrengthCompleter = null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setTorchStrengthLevel$4(int i2, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new c1(this, completer, i2, 0));
        return "setTorchStrength: " + i2;
    }

    private <T> void setLiveDataValue(MutableLiveData<T> mutableLiveData, T t3) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t3);
        } else {
            mutableLiveData.postValue(t3);
        }
    }

    private void setTorchState(int i2) {
        setLiveDataValue(this.mTorchState, Integer.valueOf(i2 != 1 ? 0 : 1));
    }

    public j2.q enableTorch(final boolean z2) {
        if (!this.mHasFlashUnit) {
            Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        setTorchState(z2 ? 1 : 0);
        final int i2 = z2 ? 1 : 0;
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.b1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f3368a.lambda$enableTorch$2(i2, z2, completer);
            }
        });
    }

    /* JADX INFO: renamed from: enableTorchInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$enableTorch$1(CallbackToFutureAdapter.Completer<Void> completer, int i2) {
        if (!this.mHasFlashUnit) {
            if (completer != null) {
                completer.setException(new IllegalStateException("No flash unit"));
                return;
            }
            return;
        }
        if (!this.mIsActive) {
            setTorchState(0);
            if (completer != null) {
                a1.a.B("Camera is not active.", completer);
                return;
            }
            return;
        }
        if (this.mCamera2CameraControlImpl.isLowLightBoostOn()) {
            if (completer != null) {
                completer.setException(new IllegalStateException("Torch can not be enabled when low-light boost is on!"));
                return;
            }
            return;
        }
        this.mTargetTorchEnabled = i2 != 0;
        this.mCamera2CameraControlImpl.enableTorchInternal(i2);
        setTorchState(i2);
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
        if (completer2 != null) {
            a1.a.B("There is a new enableTorch being set", completer2);
        }
        this.mEnableTorchCompleter = completer;
    }

    public void forceUpdateTorchStateToOff() {
        if (this.mTargetTorchEnabled) {
            this.mTargetTorchEnabled = false;
            setTorchState(0);
        }
    }

    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    public LiveData<Integer> getTorchStrengthLevel() {
        return this.mTorchStrength;
    }

    public void setActive(boolean z2) {
        if (this.mIsActive == z2) {
            return;
        }
        this.mIsActive = z2;
        if (z2) {
            return;
        }
        if (this.mTargetTorchEnabled) {
            this.mTargetTorchEnabled = false;
            this.mTargetTorchStrength = this.mDefaultTorchStrength;
            this.mCamera2CameraControlImpl.enableTorchInternal(0);
            setTorchState(0);
            setLiveDataValue(this.mTorchStrength, Integer.valueOf(this.mDefaultTorchStrength));
        }
        CallbackToFutureAdapter.Completer<Void> completer = this.mEnableTorchCompleter;
        if (completer != null) {
            a1.a.B("Camera is not active.", completer);
            this.mEnableTorchCompleter = null;
        }
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mTorchStrengthCompleter;
        if (completer2 != null) {
            a1.a.B("Camera is not active.", completer2);
            this.mTorchStrengthCompleter = null;
        }
    }

    public j2.q setTorchStrengthLevel(@IntRange(from = 1) int i2) {
        if (!this.mIsTorchStrengthSupported) {
            return Futures.immediateFailedFuture(new UnsupportedOperationException("Setting torch strength is not supported on the device."));
        }
        setLiveDataValue(this.mTorchStrength, Integer.valueOf(i2));
        return CallbackToFutureAdapter.getFuture(new a1(this, i2, 0));
    }

    /* JADX INFO: renamed from: setTorchStrengthLevelInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setTorchStrengthLevel$3(CallbackToFutureAdapter.Completer<Void> completer, @IntRange(from = 1) int i2) {
        if (!this.mIsTorchStrengthSupported) {
            if (completer != null) {
                completer.setException(new UnsupportedOperationException("Setting torch strength is not supported on the device."));
                return;
            }
            return;
        }
        if (!this.mIsActive) {
            if (completer != null) {
                a1.a.B("Camera is not active.", completer);
                return;
            }
            return;
        }
        this.mTargetTorchStrength = i2;
        this.mCamera2CameraControlImpl.setTorchStrengthLevelInternal(i2);
        if (!this.mCamera2CameraControlImpl.isTorchOn() && completer != null) {
            completer.set(null);
            return;
        }
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mTorchStrengthCompleter;
        if (completer2 != null) {
            a1.a.B("There is a new torch strength being set.", completer2);
        }
        this.mTorchStrengthCompleter = completer;
    }
}
