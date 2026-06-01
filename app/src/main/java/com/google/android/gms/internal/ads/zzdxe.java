package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdxe extends zzbyu {
    final /* synthetic */ zzdxg zza;

    public zzdxe(zzdxg zzdxgVar) {
        Objects.requireNonNull(zzdxgVar);
        this.zza = zzdxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zze() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzk(zzdxgVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzf(int i2) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzl(zzdxgVar.zzd(), i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzl(zzdxgVar.zzd(), zzeVar.zza);
    }
}
