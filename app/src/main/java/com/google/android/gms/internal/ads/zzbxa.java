package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbxa extends zzbam implements zzbxb {
    public zzbxa() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzban.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzban.zzh(parcel);
            zze(parcelFileDescriptor);
        } else if (i2 == 2) {
            com.google.android.gms.ads.internal.util.zzba zzbaVar = (com.google.android.gms.ads.internal.util.zzba) zzban.zzb(parcel, com.google.android.gms.ads.internal.util.zzba.CREATOR);
            zzban.zzh(parcel);
            zzf(zzbaVar);
        } else {
            if (i2 != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzban.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzbxj zzbxjVar = (zzbxj) zzban.zzb(parcel, zzbxj.CREATOR);
            zzban.zzh(parcel);
            zzg(parcelFileDescriptor2, zzbxjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
