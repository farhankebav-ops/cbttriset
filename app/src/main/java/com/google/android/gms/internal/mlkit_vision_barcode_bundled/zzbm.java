package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbm extends zzb implements zzbn {
    public zzbm() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 == 1) {
            zzd();
            parcel2.writeNoException();
        } else if (i2 == 2) {
            zzf();
            parcel2.writeNoException();
        } else if (i2 == 3) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
            zzc.zzb(parcel);
            List listZzb = zzb(iObjectWrapperAsInterface, zzccVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzb);
        } else if (i2 == 4) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar2 = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
            zzbc zzbcVar = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
            zzc.zzb(parcel);
            List listZzc = zzc(iObjectWrapperAsInterface2, zzccVar2, zzbcVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzc);
        } else {
            if (i2 != 5) {
                return false;
            }
            zzbe zzbeVar = (zzbe) zzc.zza(parcel, zzbe.CREATOR);
            zzc.zzb(parcel);
            zze(zzbeVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
