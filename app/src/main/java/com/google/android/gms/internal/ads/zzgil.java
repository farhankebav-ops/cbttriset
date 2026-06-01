package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgil extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzgin zza;

    public zzgil(zzgin zzginVar) {
        Objects.requireNonNull(zzginVar);
        this.zza = zzginVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        zzgin zzginVar = this.zza;
        synchronized (zzginVar) {
            zzginVar.zzf(networkCapabilities);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        zzgin zzginVar = this.zza;
        synchronized (zzginVar) {
            zzginVar.zzf(null);
        }
    }
}
