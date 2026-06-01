package androidx.camera.core.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static Class a(TargetConfig targetConfig) {
        return (Class) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }

    public static Class b(TargetConfig targetConfig, Class cls) {
        return (Class) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
    }

    public static String c(TargetConfig targetConfig) {
        return (String) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    public static String d(TargetConfig targetConfig, String str) {
        return (String) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }
}
