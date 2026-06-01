package androidx.camera.extensions.internal;

import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.extensions.impl.ExtensionVersionImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ExtensionVersion {
    private static final String TAG = "ExtenderVersion";
    private static volatile ExtensionVersion sExtensionVersion;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class DefaultExtenderVersioning extends ExtensionVersion {
        @Override // androidx.camera.extensions.internal.ExtensionVersion
        public Version getVersionObject() {
            return null;
        }

        @Override // androidx.camera.extensions.internal.ExtensionVersion
        public boolean isAdvancedExtenderSupportedInternal() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class VendorExtenderVersioning extends ExtensionVersion {
        private static ExtensionVersionImpl sImpl;
        private Version mRuntimeVersion;

        public VendorExtenderVersioning() {
            if (sImpl == null) {
                sImpl = new ExtensionVersionImpl();
            }
            Version version = Version.parse(sImpl.checkApiVersion(ClientVersion.getCurrentVersion().toVersionString()));
            if (version != null && ClientVersion.getCurrentVersion().getVersion().getMajor() == version.getMajor()) {
                this.mRuntimeVersion = version;
            }
            Logger.d(ExtensionVersion.TAG, "Selected vendor runtime: " + this.mRuntimeVersion);
        }

        @Override // androidx.camera.extensions.internal.ExtensionVersion
        public Version getVersionObject() {
            return this.mRuntimeVersion;
        }

        @Override // androidx.camera.extensions.internal.ExtensionVersion
        public boolean isAdvancedExtenderSupportedInternal() {
            try {
                return sImpl.isAdvancedExtenderImplemented();
            } catch (NoSuchMethodError unused) {
                return false;
            }
        }
    }

    private static ExtensionVersion getInstance() {
        if (sExtensionVersion != null) {
            return sExtensionVersion;
        }
        synchronized (ExtensionVersion.class) {
            if (sExtensionVersion == null) {
                try {
                    sExtensionVersion = new VendorExtenderVersioning();
                } catch (NoClassDefFoundError unused) {
                    Logger.d(TAG, "No versioning extender found. Falling back to default.");
                    sExtensionVersion = new DefaultExtenderVersioning();
                }
            }
        }
        return sExtensionVersion;
    }

    public static Version getRuntimeVersion() {
        return getInstance().getVersionObject();
    }

    @VisibleForTesting
    public static void injectInstance(ExtensionVersion extensionVersion) {
        sExtensionVersion = extensionVersion;
    }

    public static boolean isAdvancedExtenderSupported() {
        return getInstance().isAdvancedExtenderSupportedInternal();
    }

    public static boolean isExtensionVersionSupported() {
        return getInstance().getVersionObject() != null;
    }

    public static boolean isMaximumCompatibleVersion(Version version) {
        return getRuntimeVersion().compareTo(version.getMajor(), version.getMinor()) <= 0;
    }

    public static boolean isMinimumCompatibleVersion(Version version) {
        return getRuntimeVersion().compareTo(version.getMajor(), version.getMinor()) >= 0;
    }

    public abstract Version getVersionObject();

    public abstract boolean isAdvancedExtenderSupportedInternal();
}
