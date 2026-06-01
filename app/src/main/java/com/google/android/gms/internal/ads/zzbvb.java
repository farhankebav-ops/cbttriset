package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbvb extends IInterface {
    void zze(Intent intent) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    void zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzi(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws RemoteException;
}
