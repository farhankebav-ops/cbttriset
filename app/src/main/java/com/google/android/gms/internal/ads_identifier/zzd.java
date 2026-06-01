package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zza implements zzf {
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final String zzc() throws RemoteException {
        Parcel parcelZzb = zzb(1, zza());
        String string = parcelZzb.readString();
        parcelZzb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zzd() throws RemoteException {
        Parcel parcelZzb = zzb(6, zza());
        boolean zZza = zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zze(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = zzc.zza;
        parcelZza.writeInt(1);
        Parcel parcelZzb = zzb(2, parcelZza);
        boolean zZza = zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }
}
