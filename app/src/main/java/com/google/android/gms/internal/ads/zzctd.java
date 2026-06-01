package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzctd implements zzdac, zzbau, zzddq {
    private final zzffu zza;
    private final zzczg zzb;
    private final zzdal zzc;
    private final zzdbh zzf;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();
    private final AtomicBoolean zzg = new AtomicBoolean();

    public zzctd(zzffu zzffuVar, zzczg zzczgVar, zzdal zzdalVar, zzdbh zzdbhVar) {
        this.zza = zzffuVar;
        this.zzb = zzczgVar;
        this.zzc = zzdalVar;
        this.zzf = zzdbhVar;
    }

    private final void zzd() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void zzdL() {
        if (this.zza.zze == 4) {
            zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzdo(zzbat zzbatVar) {
        int i2 = this.zza.zze;
        if (i2 == 1) {
            if (zzbatVar.zzj) {
                zzd();
            }
        } else if (i2 == 4 && zzbatVar.zzj && this.zzg.compareAndSet(false, true)) {
            this.zzf.zza();
        }
        if (zzbatVar.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final synchronized void zzg() {
        int i2 = this.zza.zze;
        if (i2 == 1 || i2 == 4) {
            return;
        }
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void zzdM() {
    }
}
