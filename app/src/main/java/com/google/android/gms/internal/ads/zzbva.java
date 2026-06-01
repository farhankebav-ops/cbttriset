package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbva extends zzbam implements zzbvb {
    public zzbva() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbvb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return iInterfaceQueryLocalInterface instanceof zzbvb ? (zzbvb) iInterfaceQueryLocalInterface : new zzbuz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        switch (i2) {
            case 1:
                Intent intent = (Intent) zzban.zzb(parcel, Intent.CREATOR);
                zzban.zzh(parcel);
                zze(intent);
                break;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzban.zzh(parcel);
                zzf(iObjectWrapperAsInterface, string, string2);
                break;
            case 3:
                zzg();
                break;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzban.zzh(parcel);
                zzh(iObjectWrapperAsInterface2);
                break;
            case 5:
                String[] strArrCreateStringArray = parcel.createStringArray();
                int[] iArrCreateIntArray = parcel.createIntArray();
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzban.zzh(parcel);
                zzi(strArrCreateStringArray, iArrCreateIntArray, iObjectWrapperAsInterface3);
                break;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzban.zzb(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
                zzban.zzh(parcel);
                zzj(iObjectWrapperAsInterface4, zzaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
