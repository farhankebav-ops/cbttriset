package com.google.android.gms.internal.measurement;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzoj zza() {
        return zza;
    }

    public static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    public static zzoj zzc(zzoj zzojVar, zzoj zzojVar2) {
        int i2 = zzojVar.zzb + zzojVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzojVar.zzc, i2);
        System.arraycopy(zzojVar2.zzc, 0, iArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzojVar.zzd, i2);
        System.arraycopy(zzojVar2.zzd, 0, objArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        return new zzoj(i2, iArrCopyOf, objArrCopyOf, true);
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
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        int i2 = this.zzb;
        if (i2 == zzojVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzojVar.zzc;
            int i8 = 0;
            while (true) {
                if (i8 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzojVar.zzd;
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

    public final void zzf(zzov zzovVar) throws IOException {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzovVar.zzv(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzg(zzov zzovVar) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i8 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i9 = i8 & 7;
                int i10 = i8 >>> 3;
                if (i9 == 0) {
                    zzovVar.zzc(i10, ((Long) obj).longValue());
                } else if (i9 == 1) {
                    zzovVar.zzj(i10, ((Long) obj).longValue());
                } else if (i9 == 2) {
                    zzovVar.zzn(i10, (zzlh) obj);
                } else if (i9 == 3) {
                    zzovVar.zzt(i10);
                    ((zzoj) obj).zzg(zzovVar);
                    zzovVar.zzu(i10);
                } else {
                    if (i9 != 5) {
                        throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    zzovVar.zzk(i10, ((Integer) obj).intValue());
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
            zzlh zzlhVar = (zzlh) this.zzd[i8];
            int iZzz = zzlm.zzz(8);
            int iZzz2 = zzlm.zzz(i9) + zzlm.zzz(16);
            int iZzz3 = zzlm.zzz(24);
            int iZzc = zzlhVar.zzc();
            iB = a1.a.b(iZzz + iZzz, iZzz2, com.google.android.gms.ads.internal.client.a.v(iZzc, iZzc, iZzz3), iB);
        }
        this.zze = iB;
        return iB;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int iZzz3 = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            int i9 = this.zzc[i8];
            int i10 = i9 >>> 3;
            int i11 = i9 & 7;
            if (i11 != 0) {
                if (i11 == 1) {
                    ((Long) this.zzd[i8]).getClass();
                    iZzz2 = zzlm.zzz(i10 << 3) + 8;
                } else if (i11 == 2) {
                    int i12 = i10 << 3;
                    zzlh zzlhVar = (zzlh) this.zzd[i8];
                    int iZzz4 = zzlm.zzz(i12);
                    int iZzc = zzlhVar.zzc();
                    iZzz3 = zzlm.zzz(iZzc) + iZzc + iZzz4 + iZzz3;
                } else if (i11 == 3) {
                    int iZzz5 = zzlm.zzz(i10 << 3);
                    iZzz = iZzz5 + iZzz5;
                    iZzA = ((zzoj) this.zzd[i8]).zzi();
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i8]).getClass();
                    iZzz2 = zzlm.zzz(i10 << 3) + 4;
                }
                iZzz3 = iZzz2 + iZzz3;
            } else {
                int i13 = i10 << 3;
                long jLongValue = ((Long) this.zzd[i8]).longValue();
                iZzz = zzlm.zzz(i13);
                iZzA = zzlm.zzA(jLongValue);
            }
            iZzz3 = iZzA + iZzz + iZzz3;
        }
        this.zze = iZzz3;
        return iZzz3;
    }

    public final void zzj(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzno.zzb(sb, i2, String.valueOf(this.zzc[i8] >>> 3), this.zzd[i8]);
        }
    }

    public final void zzk(int i2, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i8 = this.zzb;
        iArr[i8] = i2;
        this.zzd[i8] = obj;
        this.zzb = i8 + 1;
    }

    public final zzoj zzl(zzoj zzojVar) {
        if (zzojVar.equals(zza)) {
            return this;
        }
        zze();
        int i2 = this.zzb + zzojVar.zzb;
        zzm(i2);
        System.arraycopy(zzojVar.zzc, 0, this.zzc, this.zzb, zzojVar.zzb);
        System.arraycopy(zzojVar.zzd, 0, this.zzd, this.zzb, zzojVar.zzb);
        this.zzb = i2;
        return this;
    }

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }
}
