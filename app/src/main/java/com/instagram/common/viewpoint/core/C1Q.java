package com.instagram.common.viewpoint.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C1Q extends Binder {
    public static final int A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static AbstractC0621Am<Bundle> A00(IBinder iBinder) {
        C03971h c03971hA01 = AbstractC0621Am.A01();
        int i2 = 0;
        int i8 = 1;
        while (i8 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i2);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i8 = parcelObtain2.readInt();
                        if (i8 == 1) {
                            c03971hA01.A04((Bundle) C3M.A01(parcelObtain2.readBundle()));
                            i2++;
                        }
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
        return c03971hA01.A05();
    }

    static {
        A00 = AbstractC04664a.A02 >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }
}
