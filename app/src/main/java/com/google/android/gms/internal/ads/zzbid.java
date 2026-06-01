package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbid extends zzbal implements zzbif {
    public zzbid(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zze() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        float f4 = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final IObjectWrapper zzg() throws RemoteException {
        return com.google.android.gms.ads.internal.client.a.e(zzde(4, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zzh() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        float f4 = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zzi() throws RemoteException {
        Parcel parcelZzde = zzde(6, zza());
        float f4 = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final com.google.android.gms.ads.internal.client.zzed zzj() throws RemoteException {
        Parcel parcelZzde = zzde(7, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzde = zzde(8, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzde = zzde(10, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final void zzm(zzbjq zzbjqVar) throws RemoteException {
        throw null;
    }
}
