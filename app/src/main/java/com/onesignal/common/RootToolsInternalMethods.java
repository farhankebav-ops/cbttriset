package com.onesignal.common;

import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RootToolsInternalMethods {
    public static final RootToolsInternalMethods INSTANCE = new RootToolsInternalMethods();

    private RootToolsInternalMethods() {
    }

    public final boolean isRooted() {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i2 = 0; i2 < 8; i2++) {
            try {
                if (new File(strArr[i2] + AndroidStaticDeviceInfoDataSource.BINARY_SU).exists()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
