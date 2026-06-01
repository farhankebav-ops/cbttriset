package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzduk implements zzfkt {
    private final Map zza;
    private final zzbdt zzb;

    public zzduk(zzbdt zzbdtVar, Map map) {
        this.zza = map;
        this.zzb = zzbdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdQ(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdR(zzfkm zzfkmVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdS(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdP(zzfkm zzfkmVar, String str) {
    }
}
