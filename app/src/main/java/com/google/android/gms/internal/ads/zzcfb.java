package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcfb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzcfe zzd;

    public zzcfb(zzcfe zzcfeVar, String str, String str2, int i2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        Objects.requireNonNull(zzcfeVar);
        this.zzd = zzcfeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap mapU = androidx.camera.core.processing.util.a.u(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        mapU.put("src", this.zza);
        mapU.put("cachedSrc", this.zzb);
        mapU.put("totalBytes", Integer.toString(this.zzc));
        this.zzd.zzw("onPrecacheEvent", mapU);
    }
}
