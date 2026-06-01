package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcv extends zzbl implements zzcx {
    public zzcv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final void zze() throws RemoteException {
        zzd(2, zza());
    }
}
