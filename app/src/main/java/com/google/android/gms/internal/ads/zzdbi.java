package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdbi implements zzifh {
    private final zzifq zza;

    private zzdbi(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdbi zza(zzifq zzifqVar) {
        return new zzdbi(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdbh(((zzift) this.zza).zzb());
    }
}
