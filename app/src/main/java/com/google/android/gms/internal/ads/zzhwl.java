package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhwl implements zzhwc {
    final int zza;
    final zzhzp zzb;
    final boolean zzc;
    final boolean zzd;

    public zzhwl(zzhwt zzhwtVar, int i2, zzhzp zzhzpVar, boolean z2, boolean z7) {
        this.zza = i2;
        this.zzb = zzhzpVar;
        this.zzc = z2;
        this.zzd = z7;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzhwl) obj).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final zzhzp zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final zzhzq zzc() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final boolean zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final boolean zze() {
        return this.zzd;
    }
}
