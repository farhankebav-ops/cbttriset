package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbvi extends IInterface {
    void zzH(int i2, String[] strArr, int[] iArr) throws RemoteException;

    void zze() throws RemoteException;

    void zzf() throws RemoteException;

    boolean zzg() throws RemoteException;

    void zzh(@Nullable Bundle bundle) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj() throws RemoteException;

    void zzk() throws RemoteException;

    void zzl() throws RemoteException;

    void zzm(int i2, int i8, Intent intent) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzo(Bundle bundle) throws RemoteException;

    void zzp() throws RemoteException;

    void zzq() throws RemoteException;

    void zzs() throws RemoteException;
}
