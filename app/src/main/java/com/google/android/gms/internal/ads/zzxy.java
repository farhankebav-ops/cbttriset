package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxy extends zzya implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    public zzxy(int i2, zzbg zzbgVar, int i8, zzxt zzxtVar, int i9, @Nullable String str, @Nullable String str2) {
        int iZzj;
        super(i2, zzbgVar, i8);
        int i10 = 0;
        this.zzf = h0.c(i9, false);
        int i11 = this.zzd.zze;
        int i12 = zzxtVar.zzC;
        this.zzg = 1 == (i11 & 1);
        this.zzh = (i11 & 2) != 0;
        zzgpe zzgpeVarZzj = str2 != null ? zzgpe.zzj(str2) : zzxtVar.zzy.isEmpty() ? zzgpe.zzj("") : zzxtVar.zzy;
        int i13 = 0;
        while (true) {
            if (i13 >= zzgpeVarZzj.size()) {
                iZzj = 0;
                i13 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzyi.zzj(this.zzd, (String) zzgpeVarZzj.get(i13), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        this.zzi = i13;
        this.zzj = iZzj;
        int iZzm = zzyi.zzm(this.zzd.zzf, str2 != null ? 1088 : 0);
        this.zzk = iZzm;
        zzv zzvVar = this.zzd;
        this.zzn = (1088 & zzvVar.zzf) != 0;
        int iZzn = zzyi.zzn(zzvVar, zzxtVar.zzz);
        this.zzl = iZzn;
        int iZzj2 = zzyi.zzj(this.zzd, str, zzyi.zzi(str) == null);
        this.zzm = iZzj2;
        boolean z2 = iZzj > 0 || (zzxtVar.zzy.isEmpty() && iZzm > 0) || ((zzxtVar.zzy.isEmpty() && iZzn != Integer.MAX_VALUE) || this.zzg || (this.zzh && iZzj2 > 0));
        if (h0.c(i9, zzxtVar.zzV) && z2) {
            i10 = 1;
        }
        this.zze = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxy zzxyVar) {
        zzgot zzgotVarZza = zzgot.zzg().zzd(this.zzf, zzxyVar.zzf).zza(Integer.valueOf(this.zzi), Integer.valueOf(zzxyVar.zzi), zzgqy.zzb().zza());
        int i2 = this.zzj;
        zzgot zzgotVarZzb = zzgotVarZza.zzb(i2, zzxyVar.zzj);
        int i8 = this.zzk;
        zzgot zzgotVarZzb2 = zzgotVarZzb.zzb(i8, zzxyVar.zzk).zza(Integer.valueOf(this.zzl), Integer.valueOf(zzxyVar.zzl), zzgqy.zzb().zza()).zzd(this.zzg, zzxyVar.zzg).zza(Boolean.valueOf(this.zzh), Boolean.valueOf(zzxyVar.zzh), i2 == 0 ? zzgqy.zzb() : zzgqy.zzb().zza()).zzb(this.zzm, zzxyVar.zzm);
        if (i8 == 0) {
            zzgotVarZzb2 = zzgotVarZzb2.zzc(this.zzn, zzxyVar.zzn);
        }
        return zzgotVarZzb2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        return false;
    }
}
