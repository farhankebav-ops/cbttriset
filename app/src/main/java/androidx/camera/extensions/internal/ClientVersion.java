package androidx.camera.extensions.internal;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientVersion {
    private static ClientVersion sCurrent = new ClientVersion("1.5.0");
    private final Version mVersion;

    public ClientVersion(String str) {
        this.mVersion = Version.parse(str);
    }

    public static ClientVersion getCurrentVersion() {
        return sCurrent;
    }

    public static boolean isMaximumCompatibleVersion(Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) <= 0;
    }

    public static boolean isMinimumCompatibleVersion(Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) >= 0;
    }

    @VisibleForTesting
    public static void setCurrentVersion(ClientVersion clientVersion) {
        sCurrent = clientVersion;
    }

    public Version getVersion() {
        return this.mVersion;
    }

    public String toVersionString() {
        return this.mVersion.toString();
    }
}
