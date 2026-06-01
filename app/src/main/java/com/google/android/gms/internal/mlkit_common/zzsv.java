package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsv {

    @Nullable
    private static zzsv zza;

    private zzsv() {
    }

    public static synchronized zzsv zza() {
        try {
            if (zza == null) {
                zza = new zzsv();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public static void zzb() {
        zzsu.zza();
    }
}
