package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsb {
    public static final boolean zza;

    static {
        boolean z2 = false;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
            }
        }
        zza = z2;
    }
}
