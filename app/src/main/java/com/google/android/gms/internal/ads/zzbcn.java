package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbcn extends IInterface {
    com.google.android.gms.ads.internal.client.zzbx zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbcu zzbcuVar) throws RemoteException;

    @Nullable
    com.google.android.gms.ads.internal.client.zzea zzg() throws RemoteException;

    void zzh(boolean z2) throws RemoteException;

    void zzi(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException;

    @Nullable
    String zzj() throws RemoteException;

    long zzk() throws RemoteException;

    void zzl(long j) throws RemoteException;
}
