package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i2, @NonNull IBinder iBinder, @NonNull Bundle bundle) throws RemoteException;

    void zzb(int i2, @NonNull Bundle bundle) throws RemoteException;

    void zzc(int i2, IBinder iBinder, zzj zzjVar) throws RemoteException;
}
