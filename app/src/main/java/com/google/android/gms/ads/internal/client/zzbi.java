package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbi extends zzbal implements zzbk {
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() throws RemoteException {
        zzdf(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzdf(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzd(zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzeVar);
        zzdf(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze() throws RemoteException {
        zzdf(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf() throws RemoteException {
        zzdf(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() throws RemoteException {
        zzdf(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() throws RemoteException {
        zzdf(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() throws RemoteException {
        zzdf(9, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() throws RemoteException {
        zzdf(7, zza());
    }
}
