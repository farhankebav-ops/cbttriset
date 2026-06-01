package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgiz implements zzgia, zzfzj {
    static final String[] zza = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    private final Context zzb;
    private final ExecutorService zzc;
    private final String[] zzd;
    private long zze = 0;
    private long zzf = 0;
    private long zzg = -1;
    private boolean zzh = false;

    public zzgiz(Context context, zzfxa zzfxaVar, ExecutorService executorService, String[] strArr) {
        this.zzb = context;
        this.zzc = executorService;
        this.zzd = strArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final j2.q zza() {
        return Build.VERSION.SDK_INT < 30 ? zzgui.zzb() : zzgui.zze(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgiy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf();
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzb(Map map) {
        long j;
        long j3;
        zze();
        synchronized (this) {
            try {
                j = this.zzh ? this.zzf - this.zze : -1L;
            } finally {
            }
        }
        map.put("vs", Long.valueOf(j));
        synchronized (this) {
            j3 = this.zzg;
            this.zzg = -1L;
        }
        map.put("vf", Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzc(Map map, Context context, View view) {
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzd(Map map) {
        zze();
    }

    public final void zze() {
        synchronized (this) {
            try {
                if (this.zzh) {
                    this.zzf = System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzf() {
        zzgix zzgixVar = new zzgix(this);
        try {
            Object systemService = this.zzb.getSystemService("appops");
            if (systemService == null) {
                throw null;
            }
            ((AppOpsManager) systemService).startWatchingActive(this.zzd, this.zzc, zzgixVar);
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void zzg(long j) {
        this.zze = j;
    }

    public final /* synthetic */ long zzh() {
        return this.zzf;
    }

    public final /* synthetic */ void zzi(long j) {
        this.zzg = j;
    }

    public final /* synthetic */ void zzj(boolean z2) {
        this.zzh = z2;
    }
}
