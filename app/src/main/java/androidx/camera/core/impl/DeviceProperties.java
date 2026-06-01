package androidx.camera.core.impl;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceProperties {
    public static DeviceProperties create() {
        return create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();

    public static DeviceProperties create(String str, String str2, int i2) {
        return new AutoValue_DeviceProperties(str, str2, i2);
    }
}
