package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpz {

    @Nullable
    private final Handler zza;

    @Nullable
    private final zzqa zzb;

    public zzpz(@Nullable Handler handler, @Nullable zzqa zzqaVar) {
        this.zza = zzqaVar == null ? null : handler;
        this.zzb = zzqaVar;
    }

    public final void zza(final zzhs zzhsVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(zzhsVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(str, j, j3);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, @Nullable final zzht zzhtVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(zzvVar, zzhtVar);
                }
            });
        }
    }

    public final void zzd(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(j);
                }
            });
        }
    }

    public final void zze(final int i2, final long j, final long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(i2, j, j3);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzps
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(str);
                }
            });
        }
    }

    public final void zzg(final zzhs zzhsVar) {
        zzhsVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(zzhsVar);
                }
            });
        }
    }

    public final void zzh(final boolean z2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(z2);
                }
            });
        }
    }

    public final void zzi(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(exc);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzw(exc);
                }
            });
        }
    }

    public final void zzk(final zzqb zzqbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx(zzqbVar);
                }
            });
        }
    }

    public final void zzl(final zzqb zzqbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzy(zzqbVar);
                }
            });
        }
    }

    public final void zzm(final int i2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(i2);
                }
            });
        }
    }

    public final /* synthetic */ void zzn(zzhs zzhsVar) {
        String str = zzep.zza;
        this.zzb.zzk(zzhsVar);
    }

    public final /* synthetic */ void zzo(String str, long j, long j3) {
        String str2 = zzep.zza;
        this.zzb.zzl(str, j, j3);
    }

    public final /* synthetic */ void zzp(zzv zzvVar, zzht zzhtVar) {
        String str = zzep.zza;
        this.zzb.zzm(zzvVar, zzhtVar);
    }

    public final /* synthetic */ void zzq(long j) {
        String str = zzep.zza;
        this.zzb.zzn(j);
    }

    public final /* synthetic */ void zzr(int i2, long j, long j3) {
        String str = zzep.zza;
        this.zzb.zzo(i2, j, j3);
    }

    public final /* synthetic */ void zzs(String str) {
        String str2 = zzep.zza;
        this.zzb.zzp(str);
    }

    public final /* synthetic */ void zzt(zzhs zzhsVar) {
        zzhsVar.zza();
        String str = zzep.zza;
        this.zzb.zzq(zzhsVar);
    }

    public final /* synthetic */ void zzu(boolean z2) {
        String str = zzep.zza;
        this.zzb.zzr(z2);
    }

    public final /* synthetic */ void zzv(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzs(exc);
    }

    public final /* synthetic */ void zzw(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzt(exc);
    }

    public final /* synthetic */ void zzx(zzqb zzqbVar) {
        String str = zzep.zza;
        this.zzb.zzu(zzqbVar);
    }

    public final /* synthetic */ void zzy(zzqb zzqbVar) {
        String str = zzep.zza;
        this.zzb.zzv(zzqbVar);
    }

    public final /* synthetic */ void zzz(int i2) {
        String str = zzep.zza;
        this.zzb.zzw(i2);
    }
}
