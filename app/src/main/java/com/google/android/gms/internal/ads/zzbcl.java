package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcl extends zzbal implements zzbcn {
    public zzbcl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final com.google.android.gms.ads.internal.client.zzbx zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzf(IObjectWrapper iObjectWrapper, zzbcu zzbcuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzban.zze(parcelZza, zzbcuVar);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final com.google.android.gms.ads.internal.client.zzea zzg() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzh(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = zzban.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzdf(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzi(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzdtVar);
        zzdf(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final String zzj() throws RemoteException {
        Parcel parcelZzde = zzde(8, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final long zzk() throws RemoteException {
        Parcel parcelZzde = zzde(9, zza());
        long j = parcelZzde.readLong();
        parcelZzde.recycle();
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzl(long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdf(10, parcelZza);
    }
}
