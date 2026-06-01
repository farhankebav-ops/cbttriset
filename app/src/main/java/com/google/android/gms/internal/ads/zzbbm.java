package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbbm implements Runnable {
    final /* synthetic */ zzbbn zza;

    public zzbbm(zzbbn zzbbnVar) {
        Objects.requireNonNull(zzbbnVar);
        this.zza = zzbbnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbn zzbbnVar = this.zza;
        synchronized (zzbbnVar.zzf()) {
            if (zzbbnVar.zzg().get() && zzbbnVar.zzh()) {
                zzbbnVar.zzg().set(false);
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App went background");
                Iterator it = zzbbnVar.zzi().iterator();
                while (it.hasNext()) {
                    try {
                        ((zzbbo) it.next()).zza(false);
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                    }
                }
            } else {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App is still foreground");
            }
        }
    }
}
