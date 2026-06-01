package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbtk extends zzbam implements zzbtl {
    public zzbtk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            String string = parcel.readString();
            zzban.zzh(parcel);
            zze(string);
        } else if (i2 == 2) {
            String string2 = parcel.readString();
            zzban.zzh(parcel);
            zzf(string2);
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzban.zzh(parcel);
            zzg(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
