package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbym extends zzbal implements zzbyo {
    public zzbym(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzmVar);
        zzban.zze(parcelZza, zzbyvVar);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzmVar);
        zzban.zze(parcelZza, zzbyvVar);
        zzdf(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zze(zzbyr zzbyrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbyrVar);
        zzdf(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzf(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzdqVar);
        zzdf(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final Bundle zzg() throws RemoteException {
        Parcel parcelZzde = zzde(9, zza());
        Bundle bundle = (Bundle) zzban.zzb(parcelZzde, Bundle.CREATOR);
        parcelZzde.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzh(zzbzc zzbzcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbzcVar);
        zzdf(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final boolean zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final String zzj() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzk(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final zzbyl zzl() throws RemoteException {
        zzbyl zzbyjVar;
        Parcel parcelZzde = zzde(11, zza());
        IBinder strongBinder = parcelZzde.readStrongBinder();
        if (strongBinder == null) {
            zzbyjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbyjVar = iInterfaceQueryLocalInterface instanceof zzbyl ? (zzbyl) iInterfaceQueryLocalInterface : new zzbyj(strongBinder);
        }
        parcelZzde.recycle();
        return zzbyjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final com.google.android.gms.ads.internal.client.zzea zzm() throws RemoteException {
        Parcel parcelZzde = zzde(12, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final String zzn() throws RemoteException {
        Parcel parcelZzde = zzde(16, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzo(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzdtVar);
        zzdf(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzp(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = zzban.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzdf(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final long zzq() throws RemoteException {
        Parcel parcelZzde = zzde(17, zza());
        long j = parcelZzde.readLong();
        parcelZzde.recycle();
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzr(long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdf(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzs(zzbyw zzbywVar) throws RemoteException {
        throw null;
    }
}
