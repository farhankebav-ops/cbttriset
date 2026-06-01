package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzua implements zzvf, zzrv {
    final /* synthetic */ zzuc zza;
    private final Object zzb;
    private zzve zzc;
    private zzru zzd;

    public zzua(zzuc zzucVar, Object obj) {
        Objects.requireNonNull(zzucVar);
        this.zza = zzucVar;
        this.zzc = zzucVar.zzf(null);
        this.zzd = zzucVar.zzh(null);
        this.zzb = obj;
    }

    private final boolean zzf(int i2, @Nullable zzuu zzuuVar) {
        zzuu zzuuVarZzx;
        if (zzuuVar != null) {
            zzuuVarZzx = this.zza.zzx(this.zzb, zzuuVar);
            if (zzuuVarZzx == null) {
                return false;
            }
        } else {
            zzuuVarZzx = null;
        }
        zzuc zzucVar = this.zza;
        zzucVar.zzw(this.zzb, 0);
        zzve zzveVar = this.zzc;
        int i8 = zzveVar.zza;
        if (!Objects.equals(zzveVar.zzb, zzuuVarZzx)) {
            this.zzc = zzucVar.zzg(0, zzuuVarZzx);
        }
        zzru zzruVar = this.zzd;
        int i9 = zzruVar.zza;
        if (Objects.equals(zzruVar.zzb, zzuuVarZzx)) {
            return true;
        }
        this.zzd = zzucVar.zzi(0, zzuuVarZzx);
        return true;
    }

    private final zzuq zzg(zzuq zzuqVar, @Nullable zzuu zzuuVar) {
        zzuc zzucVar = this.zza;
        Object obj = this.zzb;
        zzucVar.zzy(obj, zzuqVar.zzc, zzuuVar);
        zzucVar.zzy(obj, zzuqVar.zzd, zzuuVar);
        return zzuqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcT(int i2, @Nullable zzuu zzuuVar, zzul zzulVar, zzuq zzuqVar, int i8) {
        if (zzf(0, zzuuVar)) {
            zzve zzveVar = this.zzc;
            zzg(zzuqVar, zzuuVar);
            zzveVar.zzd(zzulVar, zzuqVar, i8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcU(int i2, @Nullable zzuu zzuuVar, zzul zzulVar, zzuq zzuqVar) {
        if (zzf(0, zzuuVar)) {
            zzve zzveVar = this.zzc;
            zzg(zzuqVar, zzuuVar);
            zzveVar.zze(zzulVar, zzuqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcV(int i2, @Nullable zzuu zzuuVar, zzul zzulVar, zzuq zzuqVar) {
        if (zzf(0, zzuuVar)) {
            zzve zzveVar = this.zzc;
            zzg(zzuqVar, zzuuVar);
            zzveVar.zzf(zzulVar, zzuqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcW(int i2, @Nullable zzuu zzuuVar, zzul zzulVar, zzuq zzuqVar, IOException iOException, boolean z2) {
        if (zzf(0, zzuuVar)) {
            zzve zzveVar = this.zzc;
            zzg(zzuqVar, zzuuVar);
            zzveVar.zzg(zzulVar, zzuqVar, iOException, z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcX(int i2, @Nullable zzuu zzuuVar, zzuq zzuqVar) {
        if (zzf(0, zzuuVar)) {
            zzve zzveVar = this.zzc;
            zzg(zzuqVar, zzuuVar);
            zzveVar.zzh(zzuqVar);
        }
    }
}
