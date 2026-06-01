package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcez implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ long zzg;
    final /* synthetic */ boolean zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ int zzj;
    final /* synthetic */ zzcfe zzk;

    public zzcez(zzcfe zzcfeVar, String str, String str2, long j, long j3, long j8, long j9, long j10, boolean z2, int i2, int i8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = j8;
        this.zzf = j9;
        this.zzg = j10;
        this.zzh = z2;
        this.zzi = i2;
        this.zzj = i8;
        Objects.requireNonNull(zzcfeVar);
        this.zzk = zzcfeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap mapU = androidx.camera.core.processing.util.a.u(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        mapU.put("src", this.zza);
        mapU.put("cachedSrc", this.zzb);
        mapU.put("bufferedDuration", Long.toString(this.zzc));
        mapU.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue()) {
            mapU.put("qoeLoadedBytes", Long.toString(this.zze));
            mapU.put("qoeCachedBytes", Long.toString(this.zzf));
            mapU.put("totalBytes", Long.toString(this.zzg));
            mapU.put("reportTime", Long.toString(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
        }
        mapU.put("cacheReady", true != this.zzh ? "0" : "1");
        mapU.put("playerCount", Integer.toString(this.zzi));
        mapU.put("playerPreparedCount", Integer.toString(this.zzj));
        this.zzk.zzw("onPrecacheEvent", mapU);
    }
}
