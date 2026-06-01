package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zaj extends com.google.android.gms.internal.base.zab implements zak {
    public zaj() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        int i9 = parcel.readInt();
        com.google.android.gms.internal.base.zac.zab(parcel);
        zab(i9);
        return true;
    }
}
