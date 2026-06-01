package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzclk {
    private zzcjp zza;
    private zzcmh zzb;
    private zzfkw zzc;
    private zzcmu zzd;
    private zzfhq zze;

    private zzclk() {
        throw null;
    }

    public final zzclk zza(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
        return this;
    }

    public final zzclk zzb(zzcmh zzcmhVar) {
        this.zzb = zzcmhVar;
        return this;
    }

    public final zzcjn zzc() {
        zzifp.zzc(this.zza, zzcjp.class);
        zzifp.zzc(this.zzb, zzcmh.class);
        if (this.zzc == null) {
            this.zzc = new zzfkw();
        }
        if (this.zzd == null) {
            this.zzd = new zzcmu();
        }
        if (this.zze == null) {
            this.zze = new zzfhq();
        }
        return new zzckz(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public /* synthetic */ zzclk(byte[] bArr) {
    }
}
