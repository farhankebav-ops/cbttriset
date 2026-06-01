package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabr {

    @Nullable
    private final Handler zza;

    @Nullable
    private final zzabs zzb;

    public zzabr(@Nullable Handler handler, @Nullable zzabs zzabsVar) {
        if (zzabsVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzabsVar;
    }

    public final void zza(final zzhs zzhsVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzk(zzhsVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzl(str, j, j3);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, @Nullable final zzht zzhtVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(zzvVar, zzhtVar);
                }
            });
        }
    }

    public final void zzd(final int i2, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(i2, j);
                }
            });
        }
    }

    public final void zze(final long j, final int i2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(j, i2);
                }
            });
        }
    }

    public final void zzf(final zzbv zzbvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(zzbvVar);
                }
            });
        }
    }

    public final void zzg(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzh(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(str);
                }
            });
        }
    }

    public final void zzi(final zzhs zzhsVar) {
        zzhsVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(zzhsVar);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(exc);
                }
            });
        }
    }

    public final /* synthetic */ void zzk(zzhs zzhsVar) {
        String str = zzep.zza;
        this.zzb.zza(zzhsVar);
    }

    public final /* synthetic */ void zzl(String str, long j, long j3) {
        String str2 = zzep.zza;
        this.zzb.zzb(str, j, j3);
    }

    public final /* synthetic */ void zzm(zzv zzvVar, zzht zzhtVar) {
        String str = zzep.zza;
        this.zzb.zzc(zzvVar, zzhtVar);
    }

    public final /* synthetic */ void zzn(int i2, long j) {
        String str = zzep.zza;
        this.zzb.zzd(i2, j);
    }

    public final /* synthetic */ void zzo(long j, int i2) {
        String str = zzep.zza;
        this.zzb.zzi(j, i2);
    }

    public final /* synthetic */ void zzp(zzbv zzbvVar) {
        String str = zzep.zza;
        this.zzb.zze(zzbvVar);
    }

    public final /* synthetic */ void zzq(Object obj, long j) {
        String str = zzep.zza;
        this.zzb.zzf(obj, j);
    }

    public final /* synthetic */ void zzr(String str) {
        String str2 = zzep.zza;
        this.zzb.zzg(str);
    }

    public final /* synthetic */ void zzs(zzhs zzhsVar) {
        zzhsVar.zza();
        String str = zzep.zza;
        this.zzb.zzh(zzhsVar);
    }

    public final /* synthetic */ void zzt(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzj(exc);
    }
}
