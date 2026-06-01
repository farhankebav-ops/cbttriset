package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import a1.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgt {
    private static final zzgt zza = new zzgt(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgt(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzgt zzc() {
        return zza;
    }

    public static zzgt zze(zzgt zzgtVar, zzgt zzgtVar2) {
        int i2 = zzgtVar.zzb + zzgtVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzgtVar.zzc, i2);
        System.arraycopy(zzgtVar2.zzc, 0, iArrCopyOf, zzgtVar.zzb, zzgtVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzgtVar.zzd, i2);
        System.arraycopy(zzgtVar2.zzd, 0, objArrCopyOf, zzgtVar.zzb, zzgtVar2.zzb);
        return new zzgt(i2, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzgt zzf() {
        return new zzgt(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i2) {
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
        if (obj == null || !(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgtVar = (zzgt) obj;
        int i2 = this.zzb;
        if (i2 == zzgtVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgtVar.zzc;
            int i8 = 0;
            while (true) {
                if (i8 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgtVar.zzd;
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

    public final int zza() {
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
                    iZzA2 = zzdn.zzA(i10 << 3) + 8;
                } else if (i11 == 2) {
                    int i12 = i10 << 3;
                    zzdf zzdfVar = (zzdf) this.zzd[i8];
                    int iZzA4 = zzdn.zzA(i12);
                    int iZzd = zzdfVar.zzd();
                    iZzA3 = zzdn.zzA(iZzd) + iZzd + iZzA4 + iZzA3;
                } else if (i11 == 3) {
                    int iZzA5 = zzdn.zzA(i10 << 3);
                    iZzA = iZzA5 + iZzA5;
                    iZzB = ((zzgt) this.zzd[i8]).zza();
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i8]).getClass();
                    iZzA2 = zzdn.zzA(i10 << 3) + 4;
                }
                iZzA3 = iZzA2 + iZzA3;
            } else {
                int i13 = i10 << 3;
                long jLongValue = ((Long) this.zzd[i8]).longValue();
                iZzA = zzdn.zzA(i13);
                iZzB = zzdn.zzB(jLongValue);
            }
            iZzA3 = iZzB + iZzA + iZzA3;
        }
        this.zze = iZzA3;
        return iZzA3;
    }

    public final int zzb() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iB = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            int i9 = this.zzc[i8] >>> 3;
            zzdf zzdfVar = (zzdf) this.zzd[i8];
            int iZzA = zzdn.zzA(8);
            int iZzA2 = zzdn.zzA(i9) + zzdn.zzA(16);
            int iZzA3 = zzdn.zzA(24);
            int iZzd = zzdfVar.zzd();
            iB = a.b(iZzA + iZzA, iZzA2, com.google.android.gms.ads.internal.client.a.C(iZzd, iZzd, iZzA3), iB);
        }
        this.zze = iB;
        return iB;
    }

    public final zzgt zzd(zzgt zzgtVar) {
        if (zzgtVar.equals(zza)) {
            return this;
        }
        zzg();
        int i2 = this.zzb + zzgtVar.zzb;
        zzm(i2);
        System.arraycopy(zzgtVar.zzc, 0, this.zzc, this.zzb, zzgtVar.zzb);
        System.arraycopy(zzgtVar.zzd, 0, this.zzd, this.zzb, zzgtVar.zzb);
        this.zzb = i2;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzfo.zzb(sb, i2, String.valueOf(this.zzc[i8] >>> 3), this.zzd[i8]);
        }
    }

    public final void zzj(int i2, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i8 = this.zzb;
        iArr[i8] = i2;
        this.zzd[i8] = obj;
        this.zzb = i8 + 1;
    }

    public final void zzk(zzhh zzhhVar) throws IOException {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhhVar.zzw(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzl(zzhh zzhhVar) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i8 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i9 = i8 & 7;
                int i10 = i8 >>> 3;
                if (i9 == 0) {
                    zzhhVar.zzt(i10, ((Long) obj).longValue());
                } else if (i9 == 1) {
                    zzhhVar.zzm(i10, ((Long) obj).longValue());
                } else if (i9 == 2) {
                    zzhhVar.zzd(i10, (zzdf) obj);
                } else if (i9 == 3) {
                    zzhhVar.zzF(i10);
                    ((zzgt) obj).zzl(zzhhVar);
                    zzhhVar.zzh(i10);
                } else {
                    if (i9 != 5) {
                        throw new RuntimeException(new zzeq("Protocol message tag had invalid wire type."));
                    }
                    zzhhVar.zzk(i10, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzgt() {
        this(0, new int[8], new Object[8], true);
    }
}
