package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmw {

    @Nullable
    private static zzmw zza;

    private zzmw() {
    }

    public static synchronized zzmw zza() {
        try {
            if (zza == null) {
                zza = new zzmw();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public static final boolean zzb() {
        return zzmv.zza("mlkit-dev-profiling");
    }
}
