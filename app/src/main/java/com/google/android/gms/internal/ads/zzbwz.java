package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwz extends zzbal implements zzbxb {
    public zzbwz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zze(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, parcelFileDescriptor);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzf(com.google.android.gms.ads.internal.util.zzba zzbaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbaVar);
        zzdf(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxj zzbxjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, parcelFileDescriptor);
        zzban.zzc(parcelZza, zzbxjVar);
        zzdf(3, parcelZza);
    }
}
