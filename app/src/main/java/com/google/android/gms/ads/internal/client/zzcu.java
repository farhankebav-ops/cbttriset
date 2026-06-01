package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcu extends zzbam implements zzcv {
    public zzcu() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            zze zzeVar = (zze) zzban.zzb(parcel, zze.CREATOR);
            zzban.zzh(parcel);
            zzb(zzeVar);
        } else if (i2 == 2) {
            zzc();
        } else if (i2 == 3) {
            zzd();
        } else if (i2 == 4) {
            zze();
        } else {
            if (i2 != 5) {
                return false;
            }
            zzf();
        }
        parcel2.writeNoException();
        return true;
    }
}
