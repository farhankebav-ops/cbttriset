package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcvo implements com.google.android.gms.ads.internal.client.zza {
    private final zzcvs zza;
    private final zzfgn zzb;

    public zzcvo(zzcvs zzcvsVar, zzfgn zzfgnVar) {
        this.zza = zzcvsVar;
        this.zzb = zzfgnVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zza(this.zzb.zzg);
    }
}
