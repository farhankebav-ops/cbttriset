package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzenw extends com.google.android.gms.ads.internal.client.zzbp {
    private final zzepe zza;

    public zzenw(Context context, zzcjn zzcjnVar, zzfgm zzfgmVar, zzdma zzdmaVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        zzepg zzepgVar = new zzepg(zzdmaVar, zzcjnVar.zzD());
        zzepgVar.zza(zzbkVar);
        this.zza = new zzepe(new zzepq(zzcjnVar, context, zzepgVar, zzfgmVar), zzfgmVar.zzh());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zze(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        this.zza.zzb(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzf() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized boolean zzg() throws RemoteException {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzh() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, int i2) throws RemoteException {
        this.zza.zzb(zzmVar, i2);
    }
}
