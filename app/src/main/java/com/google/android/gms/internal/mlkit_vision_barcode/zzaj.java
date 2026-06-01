package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaj extends zza implements IInterface {
    public zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(3, zza());
    }

    public final zzu[] zze(IObjectWrapper iObjectWrapper, zzan zzanVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iObjectWrapper);
        zzc.zza(parcelZza, zzanVar);
        Parcel parcelZzb = zzb(1, parcelZza);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }

    public final zzu[] zzf(IObjectWrapper iObjectWrapper, zzan zzanVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iObjectWrapper);
        zzc.zza(parcelZza, zzanVar);
        Parcel parcelZzb = zzb(2, parcelZza);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }
}
