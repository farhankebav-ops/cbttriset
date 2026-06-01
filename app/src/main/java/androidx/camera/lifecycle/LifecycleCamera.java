package androidx.camera.lifecycle;

import a3.c;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.LegacySessionConfig;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalSessionConfig.class})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@VisibleForTesting(otherwise = 3)
public final class LifecycleCamera implements LifecycleObserver, Camera {
    private final CameraUseCaseAdapter mCameraUseCaseAdapter;

    @GuardedBy("mLock")
    private final LifecycleOwner mLifecycleOwner;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private volatile boolean mIsActive = false;

    @GuardedBy("mLock")
    private boolean mSuspended = false;

    @GuardedBy("mLock")
    private boolean mReleased = false;

    @GuardedBy("mLock")
    private SessionConfig mBoundSessionConfig = null;

    public LifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mCameraUseCaseAdapter = cameraUseCaseAdapter;
        if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.attachUseCases();
        } else {
            cameraUseCaseAdapter.detachUseCases();
        }
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bind$0(ResolvedFeatureGroup resolvedFeatureGroup, SessionConfig sessionConfig) {
        HashSet hashSet = new HashSet();
        if (resolvedFeatureGroup != null) {
            hashSet.addAll(resolvedFeatureGroup.getFeatures());
        }
        sessionConfig.getFeatureSelectionListener().accept(hashSet);
    }

    public void bind(SessionConfig sessionConfig) throws CameraUseCaseAdapter.CameraException {
        synchronized (this.mLock) {
            try {
                if (this.mBoundSessionConfig == null) {
                    this.mBoundSessionConfig = sessionConfig;
                } else if (sessionConfig.isLegacy()) {
                    if (!this.mBoundSessionConfig.isLegacy()) {
                        throw new IllegalStateException("Cannot bind use cases when a SessionConfig is already bound to this LifecycleOwner. Please unbind first");
                    }
                    ArrayList arrayList = new ArrayList(this.mBoundSessionConfig.getUseCases());
                    arrayList.addAll(sessionConfig.getUseCases());
                    this.mBoundSessionConfig = new LegacySessionConfig(arrayList, sessionConfig.getViewPort(), sessionConfig.getEffects());
                } else {
                    if (this.mBoundSessionConfig.isLegacy()) {
                        throw new IllegalStateException("Cannot bind the SessionConfig when use cases are bound to this LifecycleOwner already. Please unbind first");
                    }
                    this.mBoundSessionConfig = sessionConfig;
                    CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
                    cameraUseCaseAdapter.removeUseCases(cameraUseCaseAdapter.getUseCases());
                }
                this.mCameraUseCaseAdapter.setViewPort(sessionConfig.getViewPort());
                this.mCameraUseCaseAdapter.setEffects(sessionConfig.getEffects());
                this.mCameraUseCaseAdapter.setSessionType(sessionConfig.getSessionType());
                this.mCameraUseCaseAdapter.setFrameRate(sessionConfig.getFrameRateRange());
                ResolvedFeatureGroup resolvedFeatureGroupResolveFeatureGroup = ResolvedFeatureGroup.resolveFeatureGroup(sessionConfig, (CameraInfoInternal) getCameraInfo());
                sessionConfig.getFeatureSelectionListenerExecutor().execute(new c(5, resolvedFeatureGroupResolveFeatureGroup, sessionConfig));
                this.mCameraUseCaseAdapter.addUseCases(sessionConfig.getUseCases(), resolvedFeatureGroupResolveFeatureGroup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SessionConfig getBoundSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mLock) {
            sessionConfig = this.mBoundSessionConfig;
        }
        return sessionConfig;
    }

    @Override // androidx.camera.core.Camera
    public CameraControl getCameraControl() {
        return this.mCameraUseCaseAdapter.getCameraControl();
    }

    @Override // androidx.camera.core.Camera
    public CameraInfo getCameraInfo() {
        return this.mCameraUseCaseAdapter.getCameraInfo();
    }

    public CameraUseCaseAdapter getCameraUseCaseAdapter() {
        return this.mCameraUseCaseAdapter;
    }

    @Override // androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        return this.mCameraUseCaseAdapter.getExtendedConfig();
    }

    public LifecycleOwner getLifecycleOwner() {
        LifecycleOwner lifecycleOwner;
        synchronized (this.mLock) {
            lifecycleOwner = this.mLifecycleOwner;
        }
        return lifecycleOwner;
    }

    public CameraInfo getSecondaryCameraInfo() {
        return this.mCameraUseCaseAdapter.getSecondaryCameraInfo();
    }

    public List<UseCase> getUseCases() {
        List<UseCase> listUnmodifiableList;
        synchronized (this.mLock) {
            listUnmodifiableList = Collections.unmodifiableList(this.mCameraUseCaseAdapter.getUseCases());
        }
        return listUnmodifiableList;
    }

    public boolean isActive() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mIsActive;
        }
        return z2;
    }

    public boolean isBound(UseCase useCase) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCameraUseCaseAdapter.getUseCases().contains(useCase);
        }
        return zContains;
    }

    public boolean isLegacySessionConfigBound() {
        boolean zIsLegacy;
        synchronized (this.mLock) {
            SessionConfig sessionConfig = this.mBoundSessionConfig;
            zIsLegacy = sessionConfig == null ? false : sessionConfig.isLegacy();
        }
        return zIsLegacy;
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return androidx.camera.core.c.b(this, useCaseArr);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return androidx.camera.core.c.c(this, useCaseArr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
            cameraUseCaseAdapter.removeUseCases(cameraUseCaseAdapter.getUseCases());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mCameraUseCaseAdapter.setActiveResumingMode(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mCameraUseCaseAdapter.setActiveResumingMode(true);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                if (!this.mSuspended && !this.mReleased) {
                    this.mCameraUseCaseAdapter.attachUseCases();
                    this.mIsActive = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                if (!this.mSuspended && !this.mReleased) {
                    this.mCameraUseCaseAdapter.detachUseCases();
                    this.mIsActive = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void release() {
        synchronized (this.mLock) {
            this.mReleased = true;
            this.mIsActive = false;
            this.mLifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    public void suspend() {
        synchronized (this.mLock) {
            try {
                if (this.mSuspended) {
                    return;
                }
                onStop(this.mLifecycleOwner);
                this.mSuspended = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unbind(SessionConfig sessionConfig) {
        synchronized (this.mLock) {
            try {
                SessionConfig sessionConfig2 = this.mBoundSessionConfig;
                if (sessionConfig2 != null && sessionConfig2.isLegacy() == sessionConfig.isLegacy()) {
                    LegacySessionConfig legacySessionConfig = null;
                    if (this.mBoundSessionConfig.isLegacy() || sessionConfig.isLegacy()) {
                        if (this.mBoundSessionConfig.isLegacy() && sessionConfig.isLegacy()) {
                            ArrayList arrayList = new ArrayList(this.mBoundSessionConfig.getUseCases());
                            arrayList.removeAll(sessionConfig.getUseCases());
                            if (!arrayList.isEmpty()) {
                                legacySessionConfig = new LegacySessionConfig(arrayList, this.mBoundSessionConfig.getViewPort(), this.mBoundSessionConfig.getEffects());
                            }
                            this.mBoundSessionConfig = legacySessionConfig;
                        }
                    } else if (this.mBoundSessionConfig != sessionConfig) {
                        return;
                    } else {
                        this.mBoundSessionConfig = null;
                    }
                    ArrayList arrayList2 = new ArrayList(sessionConfig.getUseCases());
                    arrayList2.retainAll(this.mCameraUseCaseAdapter.getUseCases());
                    this.mCameraUseCaseAdapter.removeUseCases(arrayList2);
                }
            } finally {
            }
        }
    }

    public void unbindAll() {
        synchronized (this.mLock) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
            cameraUseCaseAdapter.removeUseCases(cameraUseCaseAdapter.getUseCases());
            this.mBoundSessionConfig = null;
        }
    }

    public void unsuspend() {
        synchronized (this.mLock) {
            try {
                if (this.mSuspended) {
                    this.mSuspended = false;
                    if (this.mLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        onStart(this.mLifecycleOwner);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(boolean z2, UseCase... useCaseArr) {
        return this.mCameraUseCaseAdapter.isUseCasesCombinationSupported(z2, useCaseArr);
    }

    public boolean isBound(SessionConfig sessionConfig) {
        boolean z2 = true;
        Preconditions.checkState(!sessionConfig.isLegacy());
        synchronized (this.mLock) {
            if (this.mBoundSessionConfig != sessionConfig) {
                z2 = false;
            }
        }
        return z2;
    }
}
