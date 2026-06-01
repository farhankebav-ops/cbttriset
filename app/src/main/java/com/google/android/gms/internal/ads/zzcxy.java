package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxy implements zzifh {
    private final zzcxx zza;
    private final zzifq zzb;

    private zzcxy(zzcxx zzcxxVar, zzifq zzifqVar) {
        this.zza = zzcxxVar;
        this.zzb = zzifqVar;
    }

    public static zzcxy zza(zzcxx zzcxxVar, zzifq zzifqVar) {
        return new zzcxy(zzcxxVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzg((String) this.zzb.zzb());
    }
}
