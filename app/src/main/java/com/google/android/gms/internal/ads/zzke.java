package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzke {
    public zzlf zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    private boolean zze;

    public zzke(zzlf zzlfVar) {
        this.zza = zzlfVar;
    }

    public final void zza(int i2) {
        this.zze = 1 == ((this.zze ? 1 : 0) | i2);
        this.zzb += i2;
    }

    public final void zzb(zzlf zzlfVar) {
        this.zze |= this.zza != zzlfVar;
        this.zza = zzlfVar;
    }

    public final void zzc(int i2) {
        if (this.zzc && this.zzd != 5) {
            zzgmd.zza(i2 == 5);
            return;
        }
        this.zze = true;
        this.zzc = true;
        this.zzd = i2;
    }

    public final /* synthetic */ boolean zzd() {
        return this.zze;
    }
}
