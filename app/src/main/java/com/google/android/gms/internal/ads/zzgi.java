package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgi implements zzga {

    @Nullable
    private zzgz zzb;

    @Nullable
    private String zzc;
    private boolean zzf;
    private final zzgt zza = new zzgt();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzgi zzb(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzgi zzc(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzgi zzd(int i2) {
        this.zze = i2;
        return this;
    }

    public final zzgi zze(boolean z2) {
        this.zzf = true;
        return this;
    }

    public final zzgi zzf(@Nullable zzgz zzgzVar) {
        this.zzb = zzgzVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzga
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgm zza() {
        zzgm zzgmVar = new zzgm(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzgz zzgzVar = this.zzb;
        if (zzgzVar != null) {
            zzgmVar.zze(zzgzVar);
        }
        return zzgmVar;
    }
}
