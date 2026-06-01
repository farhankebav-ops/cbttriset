package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbp extends zzbam implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            zzm zzmVar = (zzm) zzban.zzb(parcel, zzm.CREATOR);
            zzban.zzh(parcel);
            zze(zzmVar);
            parcel2.writeNoException();
        } else if (i2 == 2) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else if (i2 == 3) {
            boolean zZzg = zzg();
            parcel2.writeNoException();
            int i9 = zzban.zza;
            parcel2.writeInt(zZzg ? 1 : 0);
        } else if (i2 == 4) {
            String strZzh = zzh();
            parcel2.writeNoException();
            parcel2.writeString(strZzh);
        } else {
            if (i2 != 5) {
                return false;
            }
            zzm zzmVar2 = (zzm) zzban.zzb(parcel, zzm.CREATOR);
            int i10 = parcel.readInt();
            zzban.zzh(parcel);
            zzi(zzmVar2, i10);
            parcel2.writeNoException();
        }
        return true;
    }
}
