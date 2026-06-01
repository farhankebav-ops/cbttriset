package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhzd {
    private static final zzhzd zza = new zzhzd(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhzd(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzhzd zza() {
        return zza;
    }

    public static zzhzd zzb() {
        return new zzhzd();
    }

    public static zzhzd zzc(zzhzd zzhzdVar, zzhzd zzhzdVar2) {
        int i2 = zzhzdVar.zzb + zzhzdVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhzdVar.zzc, i2);
        System.arraycopy(zzhzdVar2.zzc, 0, iArrCopyOf, zzhzdVar.zzb, zzhzdVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhzdVar.zzd, i2);
        System.arraycopy(zzhzdVar2.zzd, 0, objArrCopyOf, zzhzdVar.zzb, zzhzdVar2.zzb);
        return new zzhzd(i2, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzn(int i2) {
        int[] iArr = this.zzc;
        if (i2 > iArr.length) {
            int i8 = this.zzb;
            int i9 = (i8 / 2) + i8;
            if (i9 >= i2) {
                i2 = i9;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i2);
            this.zzd = Arrays.copyOf(this.zzd, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhzd)) {
            return false;
        }
        zzhzd zzhzdVar = (zzhzd) obj;
        int i2 = this.zzb;
        if (i2 == zzhzdVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhzdVar.zzc;
            int i8 = 0;
            while (true) {
                if (i8 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhzdVar.zzd;
                    int i9 = this.zzb;
                    for (int i10 = 0; i10 < i9; i10++) {
                        if (objArr[i10].equals(objArr2[i10])) {
                        }
                    }
                    return true;
                }
                if (iArr[i8] != iArr2[i8]) {
                    break;
                }
                i8++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        int i8 = i2 + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i9 = 17;
        for (int i10 = 0; i10 < i2; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        int i11 = ((i8 * 31) + i9) * 31;
        Object[] objArr = this.zzd;
        int i12 = this.zzb;
        for (int i13 = 0; i13 < i12; i13++) {
            iHashCode = (iHashCode * 31) + objArr[i13].hashCode();
        }
        return i11 + iHashCode;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzhzr zzhzrVar) throws IOException {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhzrVar.zzv(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzg(zzhzr zzhzrVar) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i8 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i9 = i8 & 7;
                int i10 = i8 >>> 3;
                if (i9 == 0) {
                    zzhzrVar.zzc(i10, ((Long) obj).longValue());
                } else if (i9 == 1) {
                    zzhzrVar.zzj(i10, ((Long) obj).longValue());
                } else if (i9 == 2) {
                    zzhzrVar.zzn(i10, (zzhvi) obj);
                } else if (i9 == 3) {
                    zzhzrVar.zzt(i10);
                    ((zzhzd) obj).zzg(zzhzrVar);
                    zzhzrVar.zzu(i10);
                } else {
                    if (i9 != 5) {
                        throw new RuntimeException(new zzhxc("Protocol message tag had invalid wire type."));
                    }
                    zzhzrVar.zzk(i10, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iB = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            int i9 = this.zzc[i8] >>> 3;
            zzhvi zzhviVar = (zzhvi) this.zzd[i8];
            int iZzA = zzhvt.zzA(8);
            int iZzA2 = zzhvt.zzA(i9) + zzhvt.zzA(16);
            int iZzA3 = zzhvt.zzA(24);
            int iZzc = zzhviVar.zzc();
            iB = a1.a.b(iZzA + iZzA, iZzA2, com.google.android.gms.ads.internal.client.a.b(iZzc, iZzc, iZzA3), iB);
        }
        this.zze = iB;
        return iB;
    }

    public final int zzi() {
        int iZzA;
        int iZzB;
        int iZzA2;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iZzA3 = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            int i9 = this.zzc[i8];
            int i10 = i9 >>> 3;
            int i11 = i9 & 7;
            if (i11 != 0) {
                if (i11 == 1) {
                    ((Long) this.zzd[i8]).getClass();
                    iZzA2 = zzhvt.zzA(i10 << 3) + 8;
                } else if (i11 == 2) {
                    int i12 = i10 << 3;
                    zzhvi zzhviVar = (zzhvi) this.zzd[i8];
                    int iZzA4 = zzhvt.zzA(i12);
                    int iZzc = zzhviVar.zzc();
                    iZzA3 = zzhvt.zzA(iZzc) + iZzc + iZzA4 + iZzA3;
                } else if (i11 == 3) {
                    int iZzA5 = zzhvt.zzA(i10 << 3);
                    iZzA = iZzA5 + iZzA5;
                    iZzB = ((zzhzd) this.zzd[i8]).zzi();
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException(new zzhxc("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i8]).getClass();
                    iZzA2 = zzhvt.zzA(i10 << 3) + 4;
                }
                iZzA3 = iZzA2 + iZzA3;
            } else {
                int i13 = i10 << 3;
                long jLongValue = ((Long) this.zzd[i8]).longValue();
                iZzA = zzhvt.zzA(i13);
                iZzB = zzhvt.zzB(jLongValue);
            }
            iZzA3 = iZzB + iZzA + iZzA3;
        }
        this.zze = iZzA3;
        return iZzA3;
    }

    public final void zzj(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzhyb.zzb(sb, i2, String.valueOf(this.zzc[i8] >>> 3), this.zzd[i8]);
        }
    }

    public final void zzk(int i2, Object obj) {
        zze();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i8 = this.zzb;
        iArr[i8] = i2;
        this.zzd[i8] = obj;
        this.zzb = i8 + 1;
    }

    public final boolean zzl(int i2, zzhvn zzhvnVar) throws IOException {
        int iZza;
        zze();
        int i8 = i2 & 7;
        if (i8 == 0) {
            zzk(i2, Long.valueOf(zzhvnVar.zzg()));
            return true;
        }
        if (i8 == 1) {
            zzk(i2, Long.valueOf(zzhvnVar.zzi()));
            return true;
        }
        if (i8 == 2) {
            zzk(i2, zzhvnVar.zzn());
            return true;
        }
        if (i8 != 3) {
            if (i8 == 4) {
                zzhvnVar.zzI();
                return false;
            }
            if (i8 != 5) {
                throw new zzhxc("Protocol message tag had invalid wire type.");
            }
            zzk(i2, Integer.valueOf(zzhvnVar.zzj()));
            return true;
        }
        zzhzd zzhzdVar = new zzhzd();
        do {
            iZza = zzhvnVar.zza();
            if (iZza == 0) {
                break;
            }
        } while (zzhzdVar.zzl(iZza, zzhvnVar));
        zzhvnVar.zzb(4 | ((i2 >>> 3) << 3));
        zzk(i2, zzhzdVar);
        return true;
    }

    public final zzhzd zzm(zzhzd zzhzdVar) {
        if (zzhzdVar.equals(zza)) {
            return this;
        }
        zze();
        int i2 = this.zzb + zzhzdVar.zzb;
        zzn(i2);
        System.arraycopy(zzhzdVar.zzc, 0, this.zzc, this.zzb, zzhzdVar.zzb);
        System.arraycopy(zzhzdVar.zzd, 0, this.zzd, this.zzb, zzhzdVar.zzb);
        this.zzb = i2;
        return this;
    }

    private zzhzd() {
        this(0, new int[8], new Object[8], true);
    }
}
