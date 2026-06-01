package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbie extends zzbam implements zzbif {
    public zzbie() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final boolean zzdi(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        zzbjq zzbjqVar;
        switch (i2) {
            case 2:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzban.zzh(parcel);
                zzf(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzg = zzg();
                parcel2.writeNoException();
                zzban.zze(parcel2, iObjectWrapperZzg);
                return true;
            case 5:
                float fZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzh);
                return true;
            case 6:
                float fZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzi);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzj = zzj();
                parcel2.writeNoException();
                zzban.zze(parcel2, zzedVarZzj);
                return true;
            case 8:
                boolean zZzk = zzk();
                parcel2.writeNoException();
                int i9 = zzban.zza;
                parcel2.writeInt(zZzk ? 1 : 0);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbjqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzbjqVar = iInterfaceQueryLocalInterface instanceof zzbjq ? (zzbjq) iInterfaceQueryLocalInterface : new zzbjq(strongBinder);
                }
                zzban.zzh(parcel);
                zzm(zzbjqVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                int i10 = zzban.zza;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
