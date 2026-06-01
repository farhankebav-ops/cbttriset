package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbxw extends zzbal implements IInterface {
    public zzbxw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbxv zzbxvVar, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbxvVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdf(2, parcelZza);
    }
}
