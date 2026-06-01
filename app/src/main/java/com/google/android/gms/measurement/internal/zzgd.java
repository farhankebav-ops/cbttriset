package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgd extends com.google.android.gms.internal.measurement.zzbm implements zzge {
    public zzgd() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzoh.CREATOR);
        com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
        zze(arrayListCreateTypedArrayList);
        return true;
    }
}
