package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgjd {
    private final zzfzn zza;
    private final zzfxa zzb;

    public zzgjd(zzfxa zzfxaVar, zzfzn zzfznVar) {
        this.zza = zzfznVar;
        this.zzb = zzfxaVar;
    }

    public final zzgjb zza(int i2) {
        return new zzgjb(i2, this.zzb, this.zza);
    }

    public final void zzb(int i2) {
        this.zza.zzb(i2 - 1, -1L, null, null);
    }

    public final void zzc(int i2, String str) {
        this.zza.zzb(i2 - 1, -1L, null, str);
    }

    public final void zzd(int i2, Throwable th) {
        this.zza.zzb(i2 - 1, -1L, th, null);
    }

    public final j2.q zze(int i2, j2.q qVar) {
        zzgjb zzgjbVarZza = zza(i2);
        zzgjbVarZza.zza();
        zzgui.zzr(qVar, new zzgjc(this, zzgjbVarZza), zzguz.zza());
        return qVar;
    }

    public final void zzf(int i2, Runnable runnable) {
        try {
            zza(i2).zza();
            runnable.run();
        } finally {
        }
    }
}
