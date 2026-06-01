package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbim extends IInterface {
    void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzc(String str) throws RemoteException;

    void zzd(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdG(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdH(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdI(@Nullable zzbif zzbifVar) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, int i2) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;
}
