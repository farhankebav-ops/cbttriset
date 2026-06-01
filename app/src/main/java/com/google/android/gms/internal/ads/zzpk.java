package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpk {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzpk zza(boolean z2) {
        this.zza = true;
        return this;
    }

    public final zzpk zzb(boolean z2) {
        this.zzb = z2;
        return this;
    }

    public final zzpk zzc(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzpl zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzpl(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }

    public final /* synthetic */ boolean zze() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzf() {
        return this.zzb;
    }

    public final /* synthetic */ boolean zzg() {
        return this.zzc;
    }
}
