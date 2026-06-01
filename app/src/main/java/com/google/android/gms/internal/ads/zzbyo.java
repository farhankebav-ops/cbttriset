package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbyo extends IInterface {
    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException;

    void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException;

    void zze(zzbyr zzbyrVar) throws RemoteException;

    void zzf(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException;

    Bundle zzg() throws RemoteException;

    void zzh(zzbzc zzbzcVar) throws RemoteException;

    boolean zzi() throws RemoteException;

    String zzj() throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException;

    zzbyl zzl() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzm() throws RemoteException;

    @Nullable
    String zzn() throws RemoteException;

    void zzo(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException;

    void zzp(boolean z2) throws RemoteException;

    long zzq() throws RemoteException;

    void zzr(long j) throws RemoteException;

    void zzs(zzbyw zzbywVar) throws RemoteException;
}
