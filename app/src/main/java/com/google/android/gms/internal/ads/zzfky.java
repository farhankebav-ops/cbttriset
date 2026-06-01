package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfky implements zzdga, zzcze, zzdge {
    private final zzflm zza;
    private final zzflc zzb;

    public zzfky(Context context, zzflm zzflmVar) {
        this.zza = zzflmVar;
        this.zzb = r.a(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zza() {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            zzflm zzflmVar = this.zza;
            zzflc zzflcVar = this.zzb;
            zzflcVar.zzd(true);
            zzflmVar.zza(zzflcVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzh() {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            zzflm zzflmVar = this.zza;
            zzflc zzflcVar = this.zzb;
            zzflcVar.zzk(zzeVar.zza().toString());
            zzflcVar.zzd(false);
            zzflmVar.zza(zzflcVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzg() {
    }
}
