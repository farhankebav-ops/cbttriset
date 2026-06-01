package androidx.camera.core;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.RetryPolicy;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraPresenceProvider;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.QuirkSettingsLoader;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.StreamSpecsCalculator;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalRetryPolicy.class})
@MainThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CameraX {
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    private final CameraPresenceProvider mCameraPresenceProvider;
    final CameraRepository mCameraRepository;
    private CameraUseCaseAdapterProvider mCameraUseCaseAdapterProvider;
    private final CameraXConfig mCameraXConfig;
    private final int mConfigImplType;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private final j2.q mInitInternalFuture;

    @GuardedBy("mInitializeLock")
    private InternalInitState mInitState;
    private final Object mInitializeLock;
    private final Integer mMinLogLevel;
    private final RetryPolicy mRetryPolicy;
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;

    @GuardedBy("mInitializeLock")
    private j2.q mShutdownInternalFuture;
    private StreamSpecsCalculator mStreamSpecsCalculator;
    private CameraDeviceSurfaceManager mSurfaceManager;
    private static final Object MIN_LOG_LEVEL_LOCK = new Object();

    @GuardedBy("MIN_LOG_LEVEL_LOCK")
    private static final SparseArray<Integer> sMinLogLevelReferenceCountMap = new SparseArray<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraX(Context context, CameraXConfig.Provider provider) {
        this(context, provider, new QuirkSettingsLoader());
    }

    private static void decreaseMinLogLevelReference(Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            try {
                if (num == null) {
                    return;
                }
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                int iIntValue = sparseArray.get(num.intValue()).intValue() - 1;
                if (iIntValue == 0) {
                    sparseArray.remove(num.intValue());
                } else {
                    sparseArray.put(num.intValue(), Integer.valueOf(iIntValue));
                }
                updateOrResetMinLogLevel();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static CameraXConfig.Provider getConfigProvider(Context context) {
        ComponentCallbacks2 applicationFromContext = ContextUtil.getApplicationFromContext(context);
        if (applicationFromContext instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) applicationFromContext;
        }
        try {
            Context applicationContext = ContextUtil.getApplicationContext(context);
            Bundle bundle = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, (Class<?>) MetadataHolderService.class), 640).metaData;
            String string = bundle != null ? bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (CameraXConfig.Provider) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
            }
            Logger.e(TAG, "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (ClassNotFoundException e4) {
            e = e4;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (IllegalAccessException e8) {
            e = e8;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InstantiationException e9) {
            e = e9;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NoSuchMethodException e10) {
            e = e10;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NullPointerException e11) {
            e = e11;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InvocationTargetException e12) {
            e = e12;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    private static void increaseMinLogLevelReference(Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            try {
                if (num == null) {
                    return;
                }
                Preconditions.checkArgumentInRange(num.intValue(), 3, 6, "minLogLevel");
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + sparseArray.get(num.intValue()).intValue() : 1));
                updateOrResetMinLogLevel();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void initAndRetryRecursively(Executor executor, long j, int i2, Context context, CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new k(this, context, executor, i2, completer, j));
    }

    private j2.q initInternal(Context context) {
        j2.q future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new l(0, this, context));
        }
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAndRetryRecursively$1(Executor executor, long j, int i2, Context context, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(executor, j, i2 + 1, context, completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016d A[Catch: all -> 0x0079, TryCatch #3 {all -> 0x0079, blocks: (B:3:0x0014, B:5:0x001c, B:7:0x0038, B:9:0x0055, B:11:0x0070, B:20:0x0085, B:21:0x00ae, B:23:0x00b4, B:24:0x00c4, B:26:0x00e7, B:27:0x00ea, B:30:0x00f4, B:31:0x0100, B:32:0x0101, B:33:0x010d, B:34:0x010e, B:35:0x011a, B:36:0x011b, B:40:0x0139, B:41:0x016d, B:42:0x016f, B:45:0x0175, B:47:0x017b, B:48:0x0182, B:50:0x0186, B:51:0x01b2, B:53:0x01b6, B:54:0x01ba, B:59:0x01c8, B:43:0x0170, B:44:0x0174), top: B:64:0x0014, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void lambda$initAndRetryRecursively$2(android.content.Context r17, java.util.concurrent.Executor r18, int r19, androidx.concurrent.futures.CallbackToFutureAdapter.Completer r20, long r21) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.lambda$initAndRetryRecursively$2(android.content.Context, java.util.concurrent.Executor, int, androidx.concurrent.futures.CallbackToFutureAdapter$Completer, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$initInternal$0(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), 1, context, completer);
        return "CameraX initInternal";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdownInternal$3(CallbackToFutureAdapter.Completer completer) {
        this.mCameraFactory.shutdown();
        if (this.mSchedulerThread != null) {
            Executor executor = this.mCameraExecutor;
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).deinit();
            }
            this.mSchedulerThread.quit();
        }
        completer.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$shutdownInternal$4(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraPresenceProvider.shutdown();
        this.mCameraRepository.deinit().addListener(new a(1, this, completer), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    private void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = InternalInitState.INITIALIZED;
        }
    }

    private j2.q shutdownInternal() {
        synchronized (this.mInitializeLock) {
            try {
                this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);
                int iOrdinal = this.mInitState.ordinal();
                if (iOrdinal == 0) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    return Futures.immediateFuture(null);
                }
                if (iOrdinal == 1) {
                    throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
                }
                if (iOrdinal == 2 || iOrdinal == 3) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    decreaseMinLogLevelReference(this.mMinLogLevel);
                    this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new m(this));
                }
                return this.mShutdownInternalFuture;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void traceExecutionState(RetryPolicy.ExecutionState executionState) {
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:CameraProvider-RetryStatus", executionState != null ? executionState.getStatus() : -1);
        }
    }

    @GuardedBy("MIN_LOG_LEVEL_LOCK")
    private static void updateOrResetMinLogLevel() {
        SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
        if (sparseArray.size() == 0) {
            Logger.resetMinLogLevel();
            return;
        }
        if (sparseArray.get(3) != null) {
            Logger.setMinLogLevel(3);
            return;
        }
        if (sparseArray.get(4) != null) {
            Logger.setMinLogLevel(4);
        } else if (sparseArray.get(5) != null) {
            Logger.setMinLogLevel(5);
        } else if (sparseArray.get(6) != null) {
            Logger.setMinLogLevel(6);
        }
    }

    private static void updateQuirkSettings(Context context, QuirkSettings quirkSettings, Function<Context, QuirkSettings> function) {
        if (quirkSettings != null) {
            Logger.d(TAG, "QuirkSettings from CameraXConfig: " + quirkSettings);
        } else {
            quirkSettings = function.apply(context);
            Logger.d(TAG, "QuirkSettings from app metadata: " + quirkSettings);
        }
        if (quirkSettings == null) {
            quirkSettings = QuirkSettingsHolder.DEFAULT;
            Logger.d(TAG, "QuirkSettings by default: " + quirkSettings);
        }
        QuirkSettingsHolder.instance().set(quirkSettings);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraPresenceProvider getCameraAvailabilityProvider() {
        return this.mCameraPresenceProvider;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public CameraUseCaseAdapterProvider getCameraUseCaseAdapterProvider() {
        CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider = this.mCameraUseCaseAdapterProvider;
        if (cameraUseCaseAdapterProvider != null) {
            return cameraUseCaseAdapterProvider;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getConfigImplType() {
        return this.mConfigImplType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public j2.q getInitializeFuture() {
        return this.mInitInternalFuture;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpecsCalculator getStreamSpecsCalculator() {
        StreamSpecsCalculator streamSpecsCalculator = this.mStreamSpecsCalculator;
        if (streamSpecsCalculator != null) {
            return streamSpecsCalculator;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public boolean isInitialized() {
        boolean z2;
        synchronized (this.mInitializeLock) {
            z2 = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public j2.q shutdown() {
        return shutdownInternal();
    }

    @VisibleForTesting
    public CameraX(Context context, CameraXConfig.Provider provider, Function<Context, QuirkSettings> function) {
        this.mCameraRepository = new CameraRepository();
        this.mInitializeLock = new Object();
        this.mInitState = InternalInitState.UNINITIALIZED;
        this.mShutdownInternalFuture = Futures.immediateFuture(null);
        if (provider != null) {
            this.mCameraXConfig = provider.getCameraXConfig();
        } else {
            CameraXConfig.Provider configProvider = getConfigProvider(context);
            if (configProvider == null) {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
            this.mCameraXConfig = configProvider.getCameraXConfig();
        }
        updateQuirkSettings(context, this.mCameraXConfig.getQuirkSettings(), function);
        this.mConfigImplType = this.mCameraXConfig.getConfigImplType();
        Executor cameraExecutor = this.mCameraXConfig.getCameraExecutor(null);
        Handler schedulerHandler = this.mCameraXConfig.getSchedulerHandler(null);
        cameraExecutor = cameraExecutor == null ? new CameraExecutor() : cameraExecutor;
        this.mCameraExecutor = cameraExecutor;
        if (schedulerHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = HandlerCompat.createAsync(handlerThread.getLooper());
        } else {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = schedulerHandler;
        }
        CameraXConfig cameraXConfig = this.mCameraXConfig;
        Config.Option<Integer> option = CameraXConfig.OPTION_MIN_LOGGING_LEVEL;
        cameraXConfig.getClass();
        Integer num = (Integer) androidx.camera.core.impl.w.g(cameraXConfig, option, null);
        this.mMinLogLevel = num;
        increaseMinLogLevelReference(num);
        this.mRetryPolicy = new RetryPolicy.Builder(this.mCameraXConfig.getCameraProviderInitRetryPolicy()).build();
        this.mCameraPresenceProvider = new CameraPresenceProvider(cameraExecutor);
        this.mInitInternalFuture = initInternal(context);
    }
}
