package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbop extends zzbal implements zzbor {
    public zzbop(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbor
    public final void zze(zzbol zzbolVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbolVar);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbor
    public final void zzf(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzdf(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbor
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzeVar);
        zzdf(3, parcelZza);
    }
}
