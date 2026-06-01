package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbik extends zzbal implements zzbim {
    public zzbik(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final IObjectWrapper zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return com.google.android.gms.ads.internal.client.a.e(zzde(2, parcelZza));
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzdG(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzdH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzdI(zzbif zzbifVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbifVar);
        zzdf(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zze() throws RemoteException {
        zzdf(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzf(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i2);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbim
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(6, parcelZza);
    }
}
