package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbig extends zzbal implements zzbii {
    public zzbig(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final IObjectWrapper zzb() throws RemoteException {
        return com.google.android.gms.ads.internal.client.a.e(zzde(1, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final Uri zzc() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        Uri uri = (Uri) zzban.zzb(parcelZzde, Uri.CREATOR);
        parcelZzde.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final double zzd() throws RemoteException {
        Parcel parcelZzde = zzde(3, zza());
        double d8 = parcelZzde.readDouble();
        parcelZzde.recycle();
        return d8;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zze() throws RemoteException {
        Parcel parcelZzde = zzde(4, zza());
        int i2 = parcelZzde.readInt();
        parcelZzde.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zzf() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        int i2 = parcelZzde.readInt();
        parcelZzde.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final Map zzg() throws RemoteException {
        Parcel parcelZzde = zzde(6, zza());
        HashMap mapZzg = zzban.zzg(parcelZzde);
        parcelZzde.recycle();
        return mapZzg;
    }
}
