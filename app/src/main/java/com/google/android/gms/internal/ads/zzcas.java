package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzcas extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzcaw zzcawVar, zzcap zzcapVar) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzi(zzbwa zzbwaVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;
}
