package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdxb extends com.google.android.gms.ads.internal.client.zzbj {
    final /* synthetic */ zzdwv zza;
    final /* synthetic */ zzdxc zzb;

    public zzdxb(zzdxc zzdxcVar, zzdwv zzdwvVar) {
        this.zza = zzdwvVar;
        Objects.requireNonNull(zzdxcVar);
        this.zzb = zzdxcVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() throws RemoteException {
        this.zza.zzi(this.zzb.zzd());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc(int i2) throws RemoteException {
        this.zza.zzf(this.zzb.zzd(), i2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        this.zza.zzf(this.zzb.zzd(), zzeVar.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf() throws RemoteException {
        this.zza.zze(this.zzb.zzd());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() throws RemoteException {
        this.zza.zzg(this.zzb.zzd());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() throws RemoteException {
        this.zza.zzh(this.zzb.zzd());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
    }
}
