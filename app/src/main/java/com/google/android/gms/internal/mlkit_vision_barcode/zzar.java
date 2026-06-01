package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzar {
    private static final zzbb zza;

    static {
        zzbb zzaqVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzaqVar = new zzap();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzaqVar = new zzaq();
        }
        zza = zzaqVar;
    }

    public static zzbb zza() {
        return zza;
    }
}
