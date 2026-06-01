package com.google.android.gms.internal.base;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zan {
    @ChecksSdkIntAtLeast(api = 33)
    public static boolean zaa() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
