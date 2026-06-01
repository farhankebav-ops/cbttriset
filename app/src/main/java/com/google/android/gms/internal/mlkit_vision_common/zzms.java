package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzms {

    @Nullable
    private static zzmr zza;

    public static synchronized zzmj zza(zzme zzmeVar) {
        try {
            if (zza == null) {
                zza = new zzmr(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzmj) zza.get(zzmeVar);
    }

    public static synchronized zzmj zzb(String str) {
        return zza(zzme.zzd("vision-common").zzd());
    }
}
