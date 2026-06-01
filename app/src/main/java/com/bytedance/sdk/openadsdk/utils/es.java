package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    public static void IlO() {
        Context contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        if (contextIlO != null && com.bytedance.sdk.component.utils.ea.tV()) {
            String packageName = contextIlO.getPackageName();
            int i2 = contextIlO.getApplicationInfo().targetSdkVersion;
            try {
                String[] strArr = contextIlO.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                List<String> listMY = MY();
                for (String str : strArr) {
                    if (str != null) {
                        listMY.remove(str);
                    }
                }
                if (listMY.isEmpty()) {
                    return;
                }
                for (String str2 : listMY) {
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static List<String> MY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
