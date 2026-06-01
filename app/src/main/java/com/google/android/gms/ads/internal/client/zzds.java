package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzds extends zzbam implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzdt zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return iInterfaceQueryLocalInterface instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface : new zzdr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            zzt zztVar = (zzt) zzban.zzb(parcel, zzt.CREATOR);
            zzban.zzh(parcel);
            zze(zztVar);
            parcel2.writeNoException();
        } else {
            if (i2 != 2) {
                return false;
            }
            boolean zZzf = zzf();
            parcel2.writeNoException();
            int i9 = zzban.zza;
            parcel2.writeInt(zZzf ? 1 : 0);
        }
        return true;
    }
}
