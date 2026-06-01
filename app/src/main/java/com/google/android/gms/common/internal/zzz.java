package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzz extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
    public zzz() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            int i9 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) com.google.android.gms.internal.common.zzc.zzb(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzf(parcel);
            onPostInitComplete(i9, strongBinder, bundle);
        } else if (i2 == 2) {
            int i10 = parcel.readInt();
            Bundle bundle2 = (Bundle) com.google.android.gms.internal.common.zzc.zzb(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzf(parcel);
            zzb(i10, bundle2);
        } else {
            if (i2 != 3) {
                return false;
            }
            int i11 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) com.google.android.gms.internal.common.zzc.zzb(parcel, zzj.CREATOR);
            com.google.android.gms.internal.common.zzc.zzf(parcel);
            zzc(i11, strongBinder2, zzjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
