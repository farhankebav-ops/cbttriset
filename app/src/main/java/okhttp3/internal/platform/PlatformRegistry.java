package okhttp3.internal.platform;

import a1.a;
import android.content.Context;
import android.os.Build;
import okhttp3.internal.platform.android.AndroidLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformRegistry {
    public static final PlatformRegistry INSTANCE = new PlatformRegistry();

    private PlatformRegistry() {
    }

    public final Platform findPlatform() {
        AndroidLog.INSTANCE.enable();
        Platform platformBuildIfSupported = Android10Platform.Companion.buildIfSupported();
        if (platformBuildIfSupported == null) {
            platformBuildIfSupported = AndroidPlatform.Companion.buildIfSupported();
        }
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        throw new IllegalStateException(a.g(Build.VERSION.SDK_INT, "Expected Android API level 21+ but was "));
    }

    public final Context getApplicationContext() {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            return contextAwarePlatform.getApplicationContext();
        }
        return null;
    }

    public final boolean isAndroid() {
        return true;
    }

    public final void setApplicationContext(Context context) {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(context);
        }
    }
}
