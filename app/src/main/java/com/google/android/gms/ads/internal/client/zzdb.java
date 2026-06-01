package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrj;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzdb extends IInterface {
    void zze() throws RemoteException;

    void zzf(float f4) throws RemoteException;

    void zzg(String str) throws RemoteException;

    void zzh(boolean z2) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzj(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    float zzk() throws RemoteException;

    boolean zzl() throws RemoteException;

    String zzm() throws RemoteException;

    void zzn(@Nullable String str) throws RemoteException;

    void zzo(zzbrj zzbrjVar) throws RemoteException;

    void zzp(zzbod zzbodVar) throws RemoteException;

    List zzq() throws RemoteException;

    void zzr(zzfv zzfvVar) throws RemoteException;

    void zzs() throws RemoteException;

    void zzt(zzdn zzdnVar) throws RemoteException;

    void zzu(boolean z2) throws RemoteException;

    void zzv(String str) throws RemoteException;
}
