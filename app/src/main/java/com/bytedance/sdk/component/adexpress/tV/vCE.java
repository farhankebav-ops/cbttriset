package com.bytedance.sdk.component.adexpress.tV;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    public static boolean IlO(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean MY(String str) {
        return com.bytedance.sdk.component.adexpress.tV.MY() && IlO(str);
    }
}
