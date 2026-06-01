package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwv extends zzbal implements zzbwx {
    public zzbwv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zze(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzf(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzg(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzh(String str, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzi(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdf(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzj(zzbwt zzbwtVar, zzbxc zzbxcVar) throws RemoteException {
        throw null;
    }
}
