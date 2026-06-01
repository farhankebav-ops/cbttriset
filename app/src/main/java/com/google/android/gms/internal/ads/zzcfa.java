package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcfa implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ int zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ zzcfe zzj;

    public zzcfa(zzcfe zzcfeVar, String str, String str2, int i2, int i8, long j, long j3, boolean z2, int i9, int i10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        this.zzd = i8;
        this.zze = j;
        this.zzf = j3;
        this.zzg = z2;
        this.zzh = i9;
        this.zzi = i10;
        Objects.requireNonNull(zzcfeVar);
        this.zzj = zzcfeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap mapU = androidx.camera.core.processing.util.a.u(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        mapU.put("src", this.zza);
        mapU.put("cachedSrc", this.zzb);
        mapU.put("bytesLoaded", Integer.toString(this.zzc));
        mapU.put("totalBytes", Integer.toString(this.zzd));
        mapU.put("bufferedDuration", Long.toString(this.zze));
        mapU.put("totalDuration", Long.toString(this.zzf));
        mapU.put("cacheReady", true != this.zzg ? "0" : "1");
        mapU.put("playerCount", Integer.toString(this.zzh));
        mapU.put("playerPreparedCount", Integer.toString(this.zzi));
        this.zzj.zzw("onPrecacheEvent", mapU);
    }
}
