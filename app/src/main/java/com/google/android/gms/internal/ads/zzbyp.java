package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbyp extends zzbal implements zzbyr {
    public zzbyp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zze() throws RemoteException {
        zzdf(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzf() throws RemoteException {
        zzdf(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzg(zzbyl zzbylVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbylVar);
        zzdf(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzh(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzeVar);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzj() throws RemoteException {
        zzdf(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzk() throws RemoteException {
        zzdf(7, zza());
    }
}
