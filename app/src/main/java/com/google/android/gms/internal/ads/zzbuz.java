package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbuz extends zzbal implements zzbvb {
    public zzbuz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zze(Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, intent);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzf(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzg() throws RemoteException {
        zzdf(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzi(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzban.zzc(parcelZza, zzaVar);
        zzdf(6, parcelZza);
    }
}
