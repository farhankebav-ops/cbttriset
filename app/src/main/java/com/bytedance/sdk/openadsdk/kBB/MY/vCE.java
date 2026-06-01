package com.bytedance.sdk.openadsdk.kBB.MY;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.dY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    public static boolean IlO(View view, int i2) {
        return IlO(view, false, i2);
    }

    public static boolean IlO(View view, boolean z2, int i2) {
        if (view == null) {
            return false;
        }
        return dY.IlO(view, z2 ? 30 : 50, i2, false);
    }
}
