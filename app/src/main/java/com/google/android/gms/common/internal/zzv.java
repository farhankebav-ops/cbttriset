package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzv extends com.google.android.gms.internal.common.zza implements zzx {
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() throws RemoteException {
        return a.e(zzB(1, zza()));
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() throws RemoteException {
        Parcel parcelZzB = zzB(2, zza());
        int i2 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i2;
    }
}
