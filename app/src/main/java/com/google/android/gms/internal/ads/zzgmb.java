package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgmb implements Serializable {
    public static zzgmb zzc() {
        return zzglk.zza;
    }

    public static zzgmb zzd(Object obj) {
        return obj == null ? zzglk.zza : new zzgmi(obj);
    }

    public abstract Object zza(Object obj);

    public abstract zzgmb zzb(zzglu zzgluVar);
}
