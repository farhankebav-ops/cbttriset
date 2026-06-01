package androidx.camera.extensions;

import android.content.Context;
import android.util.Range;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.h;
import androidx.camera.extensions.impl.InitializerImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import j2.q;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionsManager {
    private static final Object EXTENSIONS_LOCK = new Object();
    private static final String TAG = "ExtensionsManager";

    @GuardedBy("EXTENSIONS_LOCK")
    private static q sDeinitializeFuture;

    @GuardedBy("EXTENSIONS_LOCK")
    private static ExtensionsManager sExtensionsManager;

    @GuardedBy("EXTENSIONS_LOCK")
    private static q sInitializeFuture;
    private final ExtensionsAvailability mExtensionsAvailability;
    private final ExtensionsInfo mExtensionsInfo;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    private ExtensionsManager(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider, Context context) {
        this.mExtensionsAvailability = extensionsAvailability;
        this.mExtensionsInfo = new ExtensionsInfo(cameraProvider, context);
    }

    public static q getInstanceAsync(Context context, CameraProvider cameraProvider) {
        return getInstanceAsync(context, cameraProvider, ClientVersion.getCurrentVersion());
    }

    public static ExtensionsManager getOrCreateExtensionsManager(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider, Context context) {
        synchronized (EXTENSIONS_LOCK) {
            try {
                ExtensionsManager extensionsManager = sExtensionsManager;
                if (extensionsManager != null) {
                    return extensionsManager;
                }
                ExtensionsManager extensionsManager2 = new ExtensionsManager(extensionsAvailability, cameraProvider, context);
                sExtensionsManager = extensionsManager2;
                return extensionsManager2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getInstanceAsync$0(ClientVersion clientVersion, final Context context, final CameraProvider cameraProvider, final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            InitializerImpl.init(clientVersion.toVersionString(), context, new InitializerImpl.OnExtensionsInitializedCallback() { // from class: androidx.camera.extensions.ExtensionsManager.1
                public void onFailure(int i2) {
                    Logger.e(ExtensionsManager.TAG, "Failed to initialize extensions");
                    completer.set(ExtensionsManager.getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING, cameraProvider, context));
                }

                public void onSuccess() {
                    Logger.d(ExtensionsManager.TAG, "Successfully initialized extensions");
                    completer.set(ExtensionsManager.getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_AVAILABLE, cameraProvider, context));
                }
            }, CameraXExecutors.directExecutor());
            return "Initialize extensions";
        } catch (AbstractMethodError e) {
            e = e;
            Logger.e(TAG, "Failed to initialize extensions. Some classes or methods are missed in the vendor library. " + e);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION, cameraProvider, context));
            return "Initialize extensions";
        } catch (NoClassDefFoundError e4) {
            e = e4;
            Logger.e(TAG, "Failed to initialize extensions. Some classes or methods are missed in the vendor library. " + e);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION, cameraProvider, context));
            return "Initialize extensions";
        } catch (NoSuchMethodError e8) {
            e = e8;
            Logger.e(TAG, "Failed to initialize extensions. Some classes or methods are missed in the vendor library. " + e);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION, cameraProvider, context));
            return "Initialize extensions";
        } catch (RuntimeException e9) {
            Logger.e(TAG, "Failed to initialize extensions. Something wents wrong when initializing the vendor library. " + e9);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING, cameraProvider, context));
            return "Initialize extensions";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$shutdown$1(final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            InitializerImpl.deinit(new InitializerImpl.OnExtensionsDeinitializedCallback() { // from class: androidx.camera.extensions.ExtensionsManager.2
                public void onFailure(int i2) {
                    completer.setException(new Exception("Failed to deinitialize extensions."));
                }

                public void onSuccess() {
                    completer.set(null);
                }
            }, CameraXExecutors.directExecutor());
            return null;
        } catch (NoClassDefFoundError | NoSuchMethodError e) {
            completer.setException(e);
            return null;
        }
    }

    public CameraExtensionsControl getCameraExtensionsControl(CameraControl cameraControl) {
        return CameraExtensionsControls.from(cameraControl);
    }

    public CameraExtensionsInfo getCameraExtensionsInfo(CameraInfo cameraInfo) {
        return CameraExtensionsInfos.from(cameraInfo);
    }

    public Range<Long> getEstimatedCaptureLatencyRange(CameraSelector cameraSelector, int i2) {
        if (i2 == 0 || this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return null;
        }
        return this.mExtensionsInfo.getEstimatedCaptureLatencyRange(cameraSelector, i2, null);
    }

    public CameraSelector getExtensionEnabledCameraSelector(CameraSelector cameraSelector, int i2) {
        if (i2 == 0) {
            return cameraSelector;
        }
        if (this.mExtensionsAvailability == ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return this.mExtensionsInfo.getExtensionCameraSelectorAndInjectCameraConfig(cameraSelector, i2);
        }
        throw new IllegalArgumentException("This device doesn't support extensions function! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
    }

    @VisibleForTesting
    public ExtensionsAvailability getExtensionsAvailability() {
        return this.mExtensionsAvailability;
    }

    public boolean isExtensionAvailable(CameraSelector cameraSelector, int i2) {
        if (i2 == 0) {
            return true;
        }
        if (this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.mExtensionsInfo.isExtensionAvailable(cameraSelector, i2);
    }

    public boolean isImageAnalysisSupported(CameraSelector cameraSelector, int i2) {
        if (i2 == 0) {
            return true;
        }
        if (this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.mExtensionsInfo.isImageAnalysisSupported(cameraSelector, i2);
    }

    @VisibleForTesting
    public void setVendorExtenderFactory(VendorExtenderFactory vendorExtenderFactory) {
        this.mExtensionsInfo.setVendorExtenderFactory(vendorExtenderFactory);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public q shutdown() {
        synchronized (EXTENSIONS_LOCK) {
            try {
                if (ExtensionVersion.getRuntimeVersion() == null) {
                    sInitializeFuture = null;
                    sExtensionsManager = null;
                    ExtensionVersion.injectInstance(null);
                    return Futures.immediateFuture(null);
                }
                ExtensionVersion.injectInstance(null);
                q qVar = sInitializeFuture;
                if (qVar == null) {
                    return Futures.immediateFuture(null);
                }
                q qVar2 = sDeinitializeFuture;
                if (qVar2 != null) {
                    return qVar2;
                }
                try {
                    qVar.get();
                    sInitializeFuture = null;
                    ExtensionsAvailability extensionsAvailability = sExtensionsManager.mExtensionsAvailability;
                    sExtensionsManager = null;
                    if (extensionsAvailability == ExtensionsAvailability.LIBRARY_AVAILABLE) {
                        ExtendedCameraConfigProviderStore.clear();
                        sDeinitializeFuture = CallbackToFutureAdapter.getFuture(new c(this));
                    } else {
                        sDeinitializeFuture = Futures.immediateFuture(null);
                    }
                    return sDeinitializeFuture;
                } catch (InterruptedException e) {
                    e = e;
                    q qVarImmediateFailedFuture = Futures.immediateFailedFuture(e);
                    sDeinitializeFuture = qVarImmediateFailedFuture;
                    return qVarImmediateFailedFuture;
                } catch (ExecutionException e4) {
                    e = e4;
                    q qVarImmediateFailedFuture2 = Futures.immediateFailedFuture(e);
                    sDeinitializeFuture = qVarImmediateFailedFuture2;
                    return qVarImmediateFailedFuture2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public static q getInstanceAsync(Context context, CameraProvider cameraProvider, String str) {
        ClientVersion clientVersion = new ClientVersion(str);
        ClientVersion.setCurrentVersion(clientVersion);
        return getInstanceAsync(context, cameraProvider, clientVersion);
    }

    public static q getInstanceAsync(Context context, CameraProvider cameraProvider, ClientVersion clientVersion) {
        synchronized (EXTENSIONS_LOCK) {
            try {
                q qVar = sDeinitializeFuture;
                if (qVar != null && !qVar.isDone()) {
                    throw new IllegalStateException("Not yet done deinitializing extensions");
                }
                sDeinitializeFuture = null;
                Context applicationContext = ContextUtil.getApplicationContext(context);
                if (ExtensionVersion.getRuntimeVersion() == null) {
                    return Futures.immediateFuture(getOrCreateExtensionsManager(ExtensionsAvailability.NONE, cameraProvider, applicationContext));
                }
                Version version = Version.VERSION_1_0;
                if (!ClientVersion.isMaximumCompatibleVersion(version) && !ExtensionVersion.isMaximumCompatibleVersion(version)) {
                    if (sInitializeFuture == null) {
                        sInitializeFuture = CallbackToFutureAdapter.getFuture(new h(clientVersion, applicationContext, cameraProvider, 2));
                    }
                    return sInitializeFuture;
                }
                return Futures.immediateFuture(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_AVAILABLE, cameraProvider, applicationContext));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
