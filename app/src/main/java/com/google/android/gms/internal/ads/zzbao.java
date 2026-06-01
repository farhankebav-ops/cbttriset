package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbao extends zzbal implements zzbaq {
    public zzbao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zze(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString("GMA_SDK");
        zzdf(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzf() throws RemoteException {
        zzdf(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzg(int[] iArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzh(byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzi(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(0);
        zzdf(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzj(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzdf(7, parcelZza);
    }
}
