package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafa implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzafa(int i2, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.zza = i2;
        this.zzb = i9;
        this.zzc = i10;
        this.zzd = i11;
        this.zze = i12;
        this.zzf = i13;
    }

    public static zzafa zzb(zzeg zzegVar) {
        int iZzC = zzegVar.zzC();
        zzegVar.zzk(12);
        int iZzC2 = zzegVar.zzC();
        int iZzC3 = zzegVar.zzC();
        int iZzC4 = zzegVar.zzC();
        zzegVar.zzk(4);
        int iZzC5 = zzegVar.zzC();
        int iZzC6 = zzegVar.zzC();
        zzegVar.zzk(4);
        return new zzafa(iZzC, iZzC2, iZzC3, iZzC4, iZzC5, iZzC6, zzegVar.zzC());
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return 1752331379;
    }

    public final int zzc() {
        int i2 = this.zza;
        if (i2 == 1935960438) {
            return 2;
        }
        if (i2 == 1935963489) {
            return 1;
        }
        if (i2 == 1937012852) {
            return 3;
        }
        zzdt.zzc("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i2))));
        return -1;
    }

    public final long zzd() {
        return zzep.zzt(this.zzd, ((long) this.zzb) * 1000000, this.zzc, RoundingMode.DOWN);
    }
}
