package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzbii extends IInterface {
    IObjectWrapper zzb() throws RemoteException;

    Uri zzc() throws RemoteException;

    double zzd() throws RemoteException;

    int zze() throws RemoteException;

    int zzf() throws RemoteException;

    @Nullable
    Map zzg() throws RemoteException;
}
