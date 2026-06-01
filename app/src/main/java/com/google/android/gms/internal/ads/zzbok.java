package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbok extends zzbam implements zzbol {
    public zzbok() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        zzboo zzbomVar;
        if (i2 == 3) {
            com.google.android.gms.ads.internal.client.zzed zzedVarZzb = zzb();
            parcel2.writeNoException();
            zzban.zze(parcel2, zzedVarZzb);
            return true;
        }
        if (i2 == 4) {
            zzc();
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 5) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbomVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbomVar = iInterfaceQueryLocalInterface instanceof zzboo ? (zzboo) iInterfaceQueryLocalInterface : new zzbom(strongBinder);
            }
            zzban.zzh(parcel);
            zzd(iObjectWrapperAsInterface, zzbomVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 6) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzban.zzh(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 7) {
            return false;
        }
        zzbif zzbifVarZzf = zzf();
        parcel2.writeNoException();
        zzban.zze(parcel2, zzbifVarZzf);
        return true;
    }
}
