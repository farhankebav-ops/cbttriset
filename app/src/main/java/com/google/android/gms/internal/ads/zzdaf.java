package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdaf implements zzifh {
    private final zzifq zza;

    private zzdaf(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdaf zzc(zzifq zzifqVar) {
        return new zzdaf(zzifqVar);
    }

    public static zzdae zzd(Set set) {
        return new zzdae(set);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdae zzb() {
        return new zzdae(((zzift) this.zza).zzb());
    }
}
