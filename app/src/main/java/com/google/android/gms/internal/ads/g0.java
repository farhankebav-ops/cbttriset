package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class g0 {
    public static long a(zzln zzlnVar, long j, long j3) {
        if (zzlnVar.zze() != 1) {
            return WorkRequest.MIN_BACKOFF_MILLIS;
        }
        if (zzlnVar.zzY() || zzlnVar.zzZ()) {
            return 1000000L;
        }
        return WorkRequest.MIN_BACKOFF_MILLIS;
    }

    public static boolean b(zzln zzlnVar, long j) {
        return false;
    }

    public static void d(zzln zzlnVar) {
    }

    public static void e(zzln zzlnVar) {
    }

    public static void c(zzln zzlnVar, float f4, float f8) {
    }
}
