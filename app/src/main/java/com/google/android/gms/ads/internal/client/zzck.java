package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbrj;
import com.google.android.gms.internal.ads.zzbyo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzck extends IInterface {
    void zze(List list, zzce zzceVar) throws RemoteException;

    boolean zzf(String str) throws RemoteException;

    @Nullable
    zzbyo zzg(String str) throws RemoteException;

    boolean zzh(String str) throws RemoteException;

    @Nullable
    zzbcn zzi(String str) throws RemoteException;

    boolean zzj(String str) throws RemoteException;

    @Nullable
    zzbx zzk(String str) throws RemoteException;

    void zzl(zzbrj zzbrjVar) throws RemoteException;

    boolean zzm(String str, zzft zzftVar, @Nullable zzch zzchVar) throws RemoteException;

    boolean zzn(int i2, String str) throws RemoteException;

    @Nullable
    zzbx zzo(String str) throws RemoteException;

    @Nullable
    zzbcn zzp(String str) throws RemoteException;

    @Nullable
    zzbyo zzq(String str) throws RemoteException;

    @Nullable
    zzft zzr(int i2, String str) throws RemoteException;

    Bundle zzs(int i2) throws RemoteException;

    int zzt(int i2, String str) throws RemoteException;

    boolean zzu(int i2, String str) throws RemoteException;

    void zzv(int i2) throws RemoteException;
}
