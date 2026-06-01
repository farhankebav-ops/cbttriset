package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaoe {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzaoe(int i2, int i8, int i9) {
        this.zza = i2 != Integer.MIN_VALUE ? a1.a.q(new StringBuilder(String.valueOf(i2).length() + 1), "/", i2) : "";
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public final void zza() {
        int i2 = this.zzd;
        int i8 = i2 == Integer.MIN_VALUE ? this.zzb : i2 + this.zzc;
        this.zzd = i8;
        String str = this.zza;
        this.zze = androidx.camera.core.processing.util.a.m(new StringBuilder(str.length() + String.valueOf(i8).length()), str, i8);
    }

    public final int zzb() {
        zzd();
        return this.zzd;
    }

    public final String zzc() {
        zzd();
        return this.zze;
    }
}
