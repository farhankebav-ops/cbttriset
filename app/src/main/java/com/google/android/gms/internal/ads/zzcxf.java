package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxf implements zzcyo, zzdga, zzddq, zzcze, zzbau {
    private final zzczg zza;
    private final zzdbh zzb;
    private final zzffu zzc;
    private final ScheduledExecutorService zzd;
    private final Executor zze;
    private ScheduledFuture zzg;

    @Nullable
    private final String zzi;
    private final zzgvb zzf = zzgvb.zze();
    private final AtomicBoolean zzh = new AtomicBoolean();

    public zzcxf(zzczg zzczgVar, zzffu zzffuVar, ScheduledExecutorService scheduledExecutorService, Executor executor, @Nullable String str, zzdbh zzdbhVar) {
        this.zza = zzczgVar;
        this.zzc = zzffuVar;
        this.zzd = scheduledExecutorService;
        this.zze = executor;
        this.zzi = str;
        this.zzb = zzdbhVar;
    }

    private final boolean zzl() {
        return this.zzi.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final synchronized void zzdL() {
        if (this.zzc.zze == 4) {
            this.zza.zza();
            return;
        }
        zzgvb zzgvbVar = this.zzf;
        if (zzgvbVar.isDone()) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzg;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzgvbVar.zza(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzdo(zzbat zzbatVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmx)).booleanValue() && zzl() && zzbatVar.zzj && this.zzh.compareAndSet(false, true) && this.zzc.zze != 3) {
            com.google.android.gms.ads.internal.util.zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdy() {
        zzffu zzffuVar = this.zzc;
        if (zzffuVar.zze == 3) {
            return;
        }
        int i2 = zzffuVar.zzY;
        if (i2 == 0 || i2 == 1) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmx)).booleanValue() && zzl()) {
                return;
            }
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzg() {
        zzffu zzffuVar = this.zzc;
        int i2 = zzffuVar.zze;
        if (i2 == 3) {
            return;
        }
        if (i2 == 4) {
            this.zzb.zza();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbN)).booleanValue() && zzffuVar.zzY == 2) {
            int i8 = zzffuVar.zzq;
            if (i8 == 0) {
                this.zza.zza();
            } else {
                zzgui.zzr(this.zzf, new zzcxd(this), this.zze);
                this.zzg = this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcxe
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzi();
                    }
                }, i8, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final /* synthetic */ void zzi() {
        synchronized (this) {
            try {
                zzgvb zzgvbVar = this.zzf;
                if (zzgvbVar.isDone()) {
                    return;
                }
                zzgvbVar.zza(Boolean.TRUE);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final synchronized void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            zzgvb zzgvbVar = this.zzf;
            if (zzgvbVar.isDone()) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzgvbVar.zzb(new Exception());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ zzczg zzk() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void zzdM() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdO() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdx() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzd(zzbxv zzbxvVar, String str, String str2) {
    }
}
