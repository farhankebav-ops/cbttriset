package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaiq {
    public final zzaem zza;
    public zzaji zzd;
    public zzail zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzv zzj;
    private boolean zzm;
    public final zzajh zzb = new zzajh();
    public final zzeg zzc = new zzeg();
    private final zzeg zzk = new zzeg(1);
    private final zzeg zzl = new zzeg();

    public zzaiq(zzaem zzaemVar, zzaji zzajiVar, zzail zzailVar, zzv zzvVar) {
        this.zza = zzaemVar;
        this.zzd = zzajiVar;
        this.zze = zzailVar;
        this.zzj = zzvVar;
        zza(zzajiVar, zzailVar);
    }

    public final void zza(zzaji zzajiVar, zzail zzailVar) {
        this.zzd = zzajiVar;
        this.zze = zzailVar;
        this.zza.zzu(this.zzj);
        zzc();
    }

    public final void zzb(zzq zzqVar) {
        zzajf zzajfVar = this.zzd.zza;
        zzail zzailVar = this.zzb.zza;
        String str = zzep.zza;
        zzajg zzajgVarZza = zzajfVar.zza(zzailVar.zza);
        zzq zzqVarZzb = zzqVar.zzb(zzajgVarZza != null ? zzajgVarZza.zzb : null);
        zzt zztVarZza = this.zzj.zza();
        zztVarZza.zzq(zzqVarZzb);
        this.zza.zzu(zztVarZza.zzM());
    }

    public final void zzc() {
        zzajh zzajhVar = this.zzb;
        zzajhVar.zzd = 0;
        zzajhVar.zzp = 0L;
        zzajhVar.zzq = false;
        zzajhVar.zzk = false;
        zzajhVar.zzo = false;
        zzajhVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final long zzd() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzajh zzajhVar = this.zzb;
        return zzajhVar.zzi[this.zzf];
    }

    public final long zze() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final int zzf() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzg() {
        int i2 = !this.zzm ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzj() != null ? i2 | BasicMeasure.EXACTLY : i2;
    }

    public final boolean zzh() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i2 = this.zzg + 1;
        this.zzg = i2;
        int[] iArr = this.zzb.zzg;
        int i8 = this.zzh;
        if (i2 != iArr[i8]) {
            return true;
        }
        this.zzh = i8 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzi(int i2, int i8) {
        zzeg zzegVar;
        zzajg zzajgVarZzj = zzj();
        if (zzajgVarZzj == null) {
            return 0;
        }
        int i9 = zzajgVarZzj.zzd;
        if (i9 != 0) {
            zzegVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzajgVarZzj.zze;
            String str = zzep.zza;
            zzeg zzegVar2 = this.zzl;
            int length = bArr.length;
            zzegVar2.zzb(bArr, length);
            zzegVar = zzegVar2;
            i9 = length;
        }
        zzajh zzajhVar = this.zzb;
        boolean zZzb = zzajhVar.zzb(this.zzf);
        boolean z2 = zZzb || i8 != 0;
        zzeg zzegVar3 = this.zzk;
        zzegVar3.zzi()[0] = (byte) ((true != z2 ? 0 : 128) | i9);
        zzegVar3.zzh(0);
        zzaem zzaemVar = this.zza;
        zzaemVar.zzw(zzegVar3, 1, 1);
        zzaemVar.zzw(zzegVar, i9, 1);
        if (!z2) {
            return i9 + 1;
        }
        if (!zZzb) {
            zzeg zzegVar4 = this.zzc;
            zzegVar4.zza(8);
            byte[] bArrZzi = zzegVar4.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 1;
            bArrZzi[2] = 0;
            bArrZzi[3] = (byte) i8;
            bArrZzi[4] = (byte) ((i2 >> 24) & 255);
            bArrZzi[5] = (byte) ((i2 >> 16) & 255);
            bArrZzi[6] = (byte) ((i2 >> 8) & 255);
            bArrZzi[7] = (byte) (i2 & 255);
            zzaemVar.zzw(zzegVar4, 8, 1);
            return i9 + 9;
        }
        int i10 = i9 + 1;
        zzeg zzegVar5 = zzajhVar.zzn;
        int iZzt = zzegVar5.zzt();
        zzegVar5.zzk(-2);
        int i11 = (iZzt * 6) + 2;
        if (i8 != 0) {
            zzeg zzegVar6 = this.zzc;
            zzegVar6.zza(i11);
            byte[] bArrZzi2 = zzegVar6.zzi();
            zzegVar5.zzm(bArrZzi2, 0, i11);
            int i12 = (((bArrZzi2[2] & 255) << 8) | (bArrZzi2[3] & 255)) + i8;
            bArrZzi2[2] = (byte) ((i12 >> 8) & 255);
            bArrZzi2[3] = (byte) (i12 & 255);
            zzegVar5 = zzegVar6;
        }
        zzaemVar.zzw(zzegVar5, i11, 1);
        return i10 + i11;
    }

    @Nullable
    public final zzajg zzj() {
        if (!this.zzm) {
            return null;
        }
        zzajh zzajhVar = this.zzb;
        zzail zzailVar = zzajhVar.zza;
        String str = zzep.zza;
        int i2 = zzailVar.zza;
        zzajg zzajgVarZza = zzajhVar.zzm;
        if (zzajgVarZza == null) {
            zzajgVarZza = this.zzd.zza.zza(i2);
        }
        if (zzajgVarZza == null || !zzajgVarZza.zza) {
            return null;
        }
        return zzajgVarZza;
    }

    public final /* synthetic */ boolean zzk() {
        return this.zzm;
    }

    public final /* synthetic */ void zzl(boolean z2) {
        this.zzm = true;
    }
}
