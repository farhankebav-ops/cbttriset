package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhz extends zzbal implements zzbib {
    public zzbhz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final String zzb() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbib
    public final List zzc() throws RemoteException {
        Parcel parcelZzde = zzde(3, zza());
        ArrayList arrayListZzf = zzban.zzf(parcelZzde);
        parcelZzde.recycle();
        return arrayListZzf;
    }
}
