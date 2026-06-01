package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class OOq {
    private static volatile String IlO;

    public static String IlO() {
        if (!TextUtils.isEmpty(IlO)) {
            return IlO;
        }
        String str = Build.MODEL;
        IlO = str;
        return str;
    }
}
