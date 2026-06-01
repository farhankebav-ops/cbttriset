package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class LowLightBoostControl {
    static final int DEFAULT_LLB_STATE = -1;
    private static final String TAG = "LowLightBoostControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;

    @VisibleForTesting
    final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener;
    CallbackToFutureAdapter.Completer<Void> mEnableLlbCompleter;
    private final Executor mExecutor;
    private boolean mIsActive;
    private final boolean mIsLowLightBoostSupported;
    private final MutableLiveData<Integer> mLowLightBoostState;
    boolean mTargetLlbEnabled;
    private final AtomicInteger mLowLightBoostStateAtomic = new AtomicInteger(-1);
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mLowLightBoostDisabledByUseCaseSessionConfig = false;

    public LowLightBoostControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        boolean zCheckLowLightBoostAvailability = checkLowLightBoostAvailability(cameraCharacteristicsCompat);
        this.mIsLowLightBoostSupported = zCheckLowLightBoostAvailability;
        this.mLowLightBoostState = new MutableLiveData<>(-1);
        s0 s0Var = new s0(this, 0);
        this.mCaptureResultListener = s0Var;
        if (zCheckLowLightBoostAvailability) {
            camera2CameraControlImpl.addCaptureResultListener(s0Var);
        }
    }

    public static boolean checkLowLightBoostAvailability(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        int[] iArr;
        if (Build.VERSION.SDK_INT > 34 && (iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) != null) {
            for (int i2 : iArr) {
                if (i2 == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$enableLowLightBoost$2(boolean z2, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new k0(this, completer, z2));
        return "enableLowLightBoost: " + z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(TotalCaptureResult totalCaptureResult) {
        Integer num;
        if (this.mEnableLlbCompleter != null) {
            Integer num2 = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.CONTROL_AE_MODE);
            if (num2 != null) {
                if ((num2.intValue() == 6) == this.mTargetLlbEnabled) {
                    this.mEnableLlbCompleter.set(null);
                    this.mEnableLlbCompleter = null;
                    if (Build.VERSION.SDK_INT >= 35) {
                        setLiveDataValue(this.mLowLightBoostState, num.intValue());
                    }
                }
            }
        } else if (Build.VERSION.SDK_INT >= 35 && this.mTargetLlbEnabled && (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_LOW_LIGHT_BOOST_STATE)) != null) {
            setLiveDataValue(this.mLowLightBoostState, num.intValue());
        }
        return false;
    }

    private void setLiveDataValue(MutableLiveData<Integer> mutableLiveData, int i2) {
        if (this.mLowLightBoostStateAtomic.getAndSet(i2) != i2) {
            if (Threads.isMainThread()) {
                mutableLiveData.setValue(Integer.valueOf(i2));
            } else {
                mutableLiveData.postValue(Integer.valueOf(i2));
            }
        }
    }

    public j2.q enableLowLightBoost(boolean z2) {
        if (this.mIsLowLightBoostSupported) {
            setLiveDataValue(this.mLowLightBoostState, z2 ? 0 : -1);
            return CallbackToFutureAdapter.getFuture(new i0(this, z2, 1));
        }
        Logger.d(TAG, "Unable to enable low-light boost due to it is not supported.");
        return Futures.immediateFailedFuture(new IllegalStateException("Low-light boost is not supported"));
    }

    /* JADX INFO: renamed from: enableLowLightBoostInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$enableLowLightBoost$1(CallbackToFutureAdapter.Completer<Void> completer, boolean z2) {
        synchronized (this.mLock) {
            try {
                if (this.mLowLightBoostDisabledByUseCaseSessionConfig) {
                    setLiveDataValue(this.mLowLightBoostState, -1);
                    if (completer != null) {
                        completer.setException(new IllegalStateException("Low-light boost is disabled when expected frame rate range exceeds 30 or HDR 10-bit is on."));
                    }
                } else {
                    if (!this.mIsActive) {
                        setLiveDataValue(this.mLowLightBoostState, -1);
                        if (completer != null) {
                            a1.a.B("Camera is not active.", completer);
                            return;
                        }
                        return;
                    }
                    this.mTargetLlbEnabled = z2;
                    this.mCamera2CameraControlImpl.enableLowLightBoostInternal(z2);
                    setLiveDataValue(this.mLowLightBoostState, z2 ? 0 : -1);
                    CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableLlbCompleter;
                    if (completer2 != null) {
                        a1.a.B("There is a new enableLowLightBoost being set", completer2);
                    }
                    this.mEnableLlbCompleter = completer;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public LiveData<Integer> getLowLightBoostState() {
        return this.mLowLightBoostState;
    }

    public boolean isLowLightBoostDisabledByUseCaseSessionConfig() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mLowLightBoostDisabledByUseCaseSessionConfig;
        }
        return z2;
    }

    public boolean isLowLightBoostSupported() {
        return this.mIsLowLightBoostSupported;
    }

    public void setActive(boolean z2) {
        if (this.mIsActive == z2) {
            return;
        }
        this.mIsActive = z2;
        if (z2) {
            return;
        }
        if (this.mTargetLlbEnabled) {
            this.mTargetLlbEnabled = false;
            this.mCamera2CameraControlImpl.enableLowLightBoostInternal(false);
            setLiveDataValue(this.mLowLightBoostState, -1);
        }
        CallbackToFutureAdapter.Completer<Void> completer = this.mEnableLlbCompleter;
        if (completer != null) {
            a1.a.B("Camera is not active.", completer);
            this.mEnableLlbCompleter = null;
        }
    }

    public void setLowLightBoostDisabledByUseCaseSessionConfig(boolean z2) {
        synchronized (this.mLock) {
            try {
                this.mLowLightBoostDisabledByUseCaseSessionConfig = z2;
                if (z2) {
                    if (this.mTargetLlbEnabled) {
                        this.mTargetLlbEnabled = false;
                        this.mCamera2CameraControlImpl.enableLowLightBoostInternal(false);
                        setLiveDataValue(this.mLowLightBoostState, -1);
                        CallbackToFutureAdapter.Completer<Void> completer = this.mEnableLlbCompleter;
                        if (completer != null) {
                            completer.setException(new IllegalStateException("Low-light boost is disabled when expected frame rate range exceeds 30 or HDR 10-bit is on."));
                            this.mEnableLlbCompleter = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
