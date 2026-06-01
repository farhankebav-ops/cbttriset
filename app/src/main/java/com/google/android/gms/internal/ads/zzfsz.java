package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfsz extends zzbal implements IInterface {
    public zzfsz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfsx zze(zzfsv zzfsvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzfsvVar);
        Parcel parcelZzde = zzde(1, parcelZza);
        zzfsx zzfsxVar = (zzfsx) zzban.zzb(parcelZzde, zzfsx.CREATOR);
        parcelZzde.recycle();
        return zzfsxVar;
    }

    public final void zzf(zzfss zzfssVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzfssVar);
        zzdf(2, parcelZza);
    }

    public final zzftg zzg(zzfte zzfteVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzfteVar);
        Parcel parcelZzde = zzde(3, parcelZza);
        zzftg zzftgVar = (zzftg) zzban.zzb(parcelZzde, zzftg.CREATOR);
        parcelZzde.recycle();
        return zzftgVar;
    }
}
