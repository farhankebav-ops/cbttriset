package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasl {
    public int zza;
    public zzasg zzb;
    public zzaru zzc;
    public zzarx zzd;

    public zzasl() {
        this(new zzarx(1));
    }

    private final long zzg() throws zzask, zzasi {
        int i2 = ((((~1246322141) & 272302173) | 1841378864) + ((1246322141 & 825937997) | 658822930)) - (-1823634633);
        int i8 = 1600766768 % 649830540;
        int i9 = ((((~680326130) & 1378702392) | 3315809) + ((680326130 & 1913472410) | 739293607)) - 2048099035;
        int i10 = 1743768897 % 152059765;
        int i11 = ((((~973294814) & 1252035530) | 51191353) + ((973294814 & 1755616710) | 889459732)) - 1494176168;
        int i12 = 1861701682 % 1196748250;
        int i13 = ((((~29116548) & 174422021) | 84710160) + ((29116548 & (-1973327347)) | (-1266641286))) - (-1891729929);
        int i14 = 2091729405 % 1207774949;
        int i15 = ((((~80201211) & 1629524354) | 38778411) + ((80201211 & 1977746312) | 382371455)) - 1921480783;
        int i16 = 1050760512 % 184320788;
        int i17 = 0;
        long j = 0;
        while (i17 < (i2 ^ i8)) {
            try {
                zzaru zzaruVar = this.zzc;
                zzasg zzasgVar = this.zzb;
                int i18 = i2;
                int i19 = this.zza;
                int i20 = i8;
                this.zza = i19 + 1;
                byte bZza = zzaruVar.zza(zzasgVar, i19);
                int i21 = i11 ^ i12;
                j |= ((long) ((i9 ^ i10) & bZza)) << i17;
                if (i17 == i21) {
                    if (bZza > 1) {
                        throw new zzasi();
                    }
                    i17 = i21;
                }
                if ((bZza & (i13 ^ i14)) == 0) {
                    return (j >>> 1) ^ (-(1 & j));
                }
                i17 += i15 ^ i16;
                i2 = i18;
                i8 = i20;
            } catch (IndexOutOfBoundsException e) {
                throw new zzask(e);
            }
        }
        throw new zzasi();
    }

    private static final void zzh(long j) throws zzasj {
        long[] jArr = {141540322, 456640674, 1141397064, 993500330, 1614820873, 3337980909L, 410218731, 1716462158, 477127367};
        long j3 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        if (j % (((((((~j3) & j8) | j9) + ((j3 & j10) | j11)) - j12) + jArr[6]) ^ (jArr[7] % 477127367)) != 0) {
            throw new zzasj();
        }
    }

    public final void zza(long j) throws zzask, zzasj {
        long[] jArr = {2139842053, 728564241, 750932242, 1403848321, 1892818418, 4558981222L, 1919655804, 1856374729, 899334107};
        long j3 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        zzh(j);
        long j15 = j / (((((((~j3) & j8) | j9) + ((j3 & j10) | j11)) - j12) + j13) ^ (j14 % 899334107));
        if (j15 < 0 || j15 > this.zzb.zza.length) {
            throw new zzask();
        }
        this.zza = (int) j15;
    }

    public final long zzb() {
        long[] jArr = {491705403, 818579170, 1201981453, 810223590, 1243973916, 3701563257L, 554701476, 1889947178, 1780695788};
        long j = jArr[0];
        long j3 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        return ((long) this.zza) * (((((((~j) & j3) | j8) + ((j & j9) | j10)) - j11) + jArr[6]) ^ (jArr[7] % 1780695788));
    }

    public final long zzc() throws zzask {
        try {
            zzaru zzaruVar = this.zzc;
            zzasg zzasgVar = this.zzb;
            this.zza = this.zza + 1;
            return zzaruVar.zza(zzasgVar, r2);
        } catch (IndexOutOfBoundsException e) {
            throw new zzask(e);
        }
    }

    public final int zzd() throws zzask {
        int i2 = ((((~413360099) & 1621678468) | 84323740) + ((413360099 & 1621644360) | 385888249)) - 1513564466;
        int i8 = 1609416931 % 1031126087;
        int i9 = ((((~978587665) & 1228171537) | 1025392332) + ((978587665 & 1075859857) | 983056096)) - (-1589113644);
        int i10 = 1723578341 % 672563970;
        int i11 = ((((~1163384280) & 546336857) | 505597090) + ((1163384280 & 546323033) | 358992768)) - 1346988633;
        int i12 = 1124734562 % 530406424;
        int i13 = ((((~217161528) & 116398273) | 202500381) + ((217161528 & 316821712) | 269928733)) - 410012058;
        int i14 = 529302443 % 418646579;
        try {
            zzaru zzaruVar = this.zzc;
            zzasg zzasgVar = this.zzb;
            int i15 = this.zza;
            this.zza = i15 + 1;
            int i16 = i2 ^ i8;
            int iZza = zzaruVar.zza(zzasgVar, i15) & i16;
            zzaru zzaruVar2 = this.zzc;
            zzasg zzasgVar2 = this.zzb;
            int i17 = this.zza;
            this.zza = i17 + 1;
            int iZza2 = iZza | ((zzaruVar2.zza(zzasgVar2, i17) & i16) << (i9 ^ i10));
            zzaru zzaruVar3 = this.zzc;
            zzasg zzasgVar3 = this.zzb;
            int i18 = this.zza;
            this.zza = i18 + 1;
            int iZza3 = iZza2 | ((i16 & zzaruVar3.zza(zzasgVar3, i18)) << (i11 ^ i12));
            zzaru zzaruVar4 = this.zzc;
            zzasg zzasgVar4 = this.zzb;
            int i19 = this.zza;
            this.zza = i19 + 1;
            return iZza3 | (zzaruVar4.zza(zzasgVar4, i19) << (i13 ^ i14));
        } catch (IndexOutOfBoundsException e) {
            throw new zzask(e);
        }
    }

    public final long zze() throws zzask, zzasi {
        return zzg();
    }

    public final zzasg zzf(long j) throws zzask, zzasj {
        int[] iArr = {1667674495, 1502201381, 1197125461, 478240810, 622476187, -1652496091, 840440151, 1203013321, 774318984};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        zzh(zzb() + j);
        int i15 = this.zza;
        long j3 = i15;
        zzasg zzasgVar = this.zzb;
        long j8 = (j >> ((i14 % 774318984) ^ iC)) + j3;
        if (j8 > zzasgVar.zza.length || j8 < j3) {
            throw new zzask();
        }
        try {
            int i16 = (int) j8;
            zzasg zzasgVarZzb = this.zzc.zzb(zzasgVar, i15, i16);
            this.zza = i16;
            return zzasgVarZzb;
        } catch (IndexOutOfBoundsException e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }

    public zzasl(zzarx zzarxVar) {
        this(zzasg.zzb, 0, new zzarv());
        this.zzd = zzarxVar;
    }

    private zzasl(zzasg zzasgVar, int i2, zzaru zzaruVar) {
        this.zzb = zzasgVar;
        this.zza = i2;
        this.zzc = zzaruVar;
    }

    public zzasl(zzasg zzasgVar, int i2, zzaru zzaruVar, zzarx zzarxVar) {
        this(zzasgVar, i2, zzaruVar);
        this.zzd = zzarxVar;
    }
}
