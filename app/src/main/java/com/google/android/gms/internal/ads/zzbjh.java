package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjh extends zzbal implements zzbjj {
    public zzbjh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zze(zzbiz zzbizVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbizVar);
        zzdf(1, parcelZza);
    }
}
