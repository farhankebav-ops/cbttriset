package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbo extends zzbl implements zzbq {
    public zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbq
    public final Bundle zze(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        Parcel parcelZzP = zzP(1, parcelZza);
        Bundle bundle2 = (Bundle) zzbn.zzb(parcelZzP, Bundle.CREATOR);
        parcelZzP.recycle();
        return bundle2;
    }
}
