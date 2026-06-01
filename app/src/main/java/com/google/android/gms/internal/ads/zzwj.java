package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwj implements zzaem {
    private boolean zzB;
    private final zzwe zza;

    @Nullable
    private final zzrz zzd;

    @Nullable
    private final zzru zze;

    @Nullable
    private zzwi zzf;

    @Nullable
    private zzv zzg;

    @Nullable
    private zzrs zzh;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzw;

    @Nullable
    private zzv zzz;
    private final zzwf zzb = new zzwf();
    private int zzi = 1000;
    private long[] zzj = new long[1000];
    private long[] zzk = new long[1000];
    private long[] zzn = new long[1000];
    private int[] zzm = new int[1000];
    private int[] zzl = new int[1000];
    private zzael[] zzo = new zzael[1000];
    private final zzwq zzc = new zzwq(zzwg.zza);
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private long zzv = Long.MIN_VALUE;
    private boolean zzy = true;
    private boolean zzx = true;
    private boolean zzA = true;

    public zzwj(zzyv zzyvVar, @Nullable zzrz zzrzVar, @Nullable zzru zzruVar) {
        this.zzd = zzrzVar;
        this.zze = zzruVar;
        this.zza = new zzwe(zzyvVar);
    }

    private final synchronized void zzA() {
        this.zzs = 0;
        this.zza.zzb();
    }

    private final synchronized int zzB(zzkj zzkjVar, zzhh zzhhVar, boolean z2, boolean z7, zzwf zzwfVar) {
        try {
            zzhhVar.zzd = false;
            if (!zzH()) {
                if (!z7 && !this.zzw) {
                    zzv zzvVar = this.zzz;
                    if (zzvVar == null || (!z2 && zzvVar == this.zzg)) {
                        return -3;
                    }
                    zzI(zzvVar, zzkjVar);
                    return -5;
                }
                zzhhVar.zzg(4);
                zzhhVar.zze = Long.MIN_VALUE;
                return -4;
            }
            zzv zzvVar2 = ((zzwh) this.zzc.zza(this.zzq + this.zzs)).zza;
            if (!z2 && zzvVar2 == this.zzg) {
                int iZzM = zzM(this.zzs);
                if (!zzJ(iZzM)) {
                    zzhhVar.zzd = true;
                    return -3;
                }
                zzhhVar.zzg(this.zzm[iZzM]);
                if (this.zzs == this.zzp - 1 && (z7 || this.zzw)) {
                    zzhhVar.zzh(536870912);
                }
                zzhhVar.zze = this.zzn[iZzM];
                zzwfVar.zza = this.zzl[iZzM];
                zzwfVar.zzb = this.zzk[iZzM];
                zzwfVar.zzc = this.zzo[iZzM];
                return -4;
            }
            zzI(zzvVar2, zzkjVar);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzC(zzv zzvVar) {
        try {
            this.zzy = false;
            if (Objects.equals(zzvVar, this.zzz)) {
                return false;
            }
            zzwq zzwqVar = this.zzc;
            if (zzwqVar.zzf() || !((zzwh) zzwqVar.zzc()).zza.equals(zzvVar)) {
                this.zzz = zzvVar;
            } else {
                this.zzz = ((zzwh) zzwqVar.zzc()).zza;
            }
            boolean z2 = this.zzA;
            zzv zzvVar2 = this.zzz;
            this.zzA = z2 & zzas.zzd(zzvVar2.zzo, zzvVar2.zzk);
            this.zzB = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized long zzD(long r8, boolean r10, boolean r11) throws java.lang.Throwable {
        /*
            r7 = this;
            monitor-enter(r7)
            int r10 = r7.zzp     // Catch: java.lang.Throwable -> L32
            if (r10 == 0) goto Lf
            long[] r0 = r7.zzn     // Catch: java.lang.Throwable -> L32
            int r2 = r7.zzr     // Catch: java.lang.Throwable -> L32
            r3 = r0[r2]     // Catch: java.lang.Throwable -> L32
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L11
        Lf:
            r1 = r7
            goto L35
        L11:
            if (r11 == 0) goto L19
            int r11 = r7.zzs     // Catch: java.lang.Throwable -> L1b
            if (r11 == r10) goto L19
            int r10 = r11 + 1
        L19:
            r3 = r10
            goto L1f
        L1b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L39
        L1f:
            r6 = 0
            r1 = r7
            r4 = r8
            int r8 = r1.zzK(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L2f
            r9 = -1
            if (r8 == r9) goto L35
            long r8 = r7.zzL(r8)     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r7)
            return r8
        L2f:
            r0 = move-exception
        L30:
            r8 = r0
            goto L39
        L32:
            r0 = move-exception
            r1 = r7
            goto L30
        L35:
            monitor-exit(r7)
            r8 = -1
            return r8
        L39:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L2f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwj.zzD(long, boolean, boolean):long");
    }

    private final synchronized long zzE() {
        int i2 = this.zzp;
        if (i2 == 0) {
            return -1L;
        }
        return zzL(i2);
    }

    private final void zzF() {
        if (this.zzh != null) {
            this.zzh = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzG(long j, int i2, long j3, int i8, @Nullable zzael zzaelVar) {
        try {
            int i9 = this.zzp;
            if (i9 > 0) {
                int iZzM = zzM(i9 - 1);
                zzgmd.zza(this.zzk[iZzM] + ((long) this.zzl[iZzM]) <= j3);
            }
            this.zzw = (536870912 & i2) != 0;
            this.zzv = Math.max(this.zzv, j);
            int iZzM2 = zzM(this.zzp);
            this.zzn[iZzM2] = j;
            this.zzk[iZzM2] = j3;
            this.zzl[iZzM2] = i8;
            this.zzm[iZzM2] = i2;
            this.zzo[iZzM2] = zzaelVar;
            this.zzj[iZzM2] = 0;
            zzwq zzwqVar = this.zzc;
            if (zzwqVar.zzf() || !((zzwh) zzwqVar.zzc()).zza.equals(this.zzz)) {
                zzv zzvVar = this.zzz;
                byte[] bArr = null;
                if (zzvVar == null) {
                    throw null;
                }
                zzwqVar.zzb(this.zzq + this.zzp, new zzwh(zzvVar, zzry.zzb, bArr));
            }
            int i10 = this.zzp + 1;
            this.zzp = i10;
            int i11 = this.zzi;
            if (i10 == i11) {
                int i12 = i11 + 1000;
                long[] jArr = new long[i12];
                long[] jArr2 = new long[i12];
                long[] jArr3 = new long[i12];
                int[] iArr = new int[i12];
                int[] iArr2 = new int[i12];
                zzael[] zzaelVarArr = new zzael[i12];
                int i13 = this.zzr;
                int i14 = i11 - i13;
                System.arraycopy(this.zzk, i13, jArr2, 0, i14);
                System.arraycopy(this.zzn, this.zzr, jArr3, 0, i14);
                System.arraycopy(this.zzm, this.zzr, iArr, 0, i14);
                System.arraycopy(this.zzl, this.zzr, iArr2, 0, i14);
                System.arraycopy(this.zzo, this.zzr, zzaelVarArr, 0, i14);
                System.arraycopy(this.zzj, this.zzr, jArr, 0, i14);
                int i15 = this.zzr;
                System.arraycopy(this.zzk, 0, jArr2, i14, i15);
                System.arraycopy(this.zzn, 0, jArr3, i14, i15);
                System.arraycopy(this.zzm, 0, iArr, i14, i15);
                System.arraycopy(this.zzl, 0, iArr2, i14, i15);
                System.arraycopy(this.zzo, 0, zzaelVarArr, i14, i15);
                System.arraycopy(this.zzj, 0, jArr, i14, i15);
                this.zzk = jArr2;
                this.zzn = jArr3;
                this.zzm = iArr;
                this.zzl = iArr2;
                this.zzo = zzaelVarArr;
                this.zzj = jArr;
                this.zzr = 0;
                this.zzi = i12;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean zzH() {
        return this.zzs != this.zzp;
    }

    private final void zzI(zzv zzvVar, zzkj zzkjVar) {
        zzv zzvVar2 = this.zzg;
        zzq zzqVar = zzvVar2 == null ? null : zzvVar2.zzs;
        this.zzg = zzvVar;
        zzq zzqVar2 = zzvVar.zzs;
        zzrz zzrzVar = this.zzd;
        zzkjVar.zzb = zzvVar.zzb(zzrzVar.zzb(zzvVar));
        zzkjVar.zza = this.zzh;
        if (zzvVar2 == null || !Objects.equals(zzqVar, zzqVar2)) {
            zzrs zzrsVarZza = zzrzVar.zza(this.zze, zzvVar);
            this.zzh = zzrsVarZza;
            zzkjVar.zza = zzrsVarZza;
        }
    }

    private final boolean zzJ(int i2) {
        if (this.zzh == null) {
            return true;
        }
        int i8 = this.zzm[i2];
        return false;
    }

    private final int zzK(int i2, int i8, long j, boolean z2) {
        int i9 = -1;
        for (int i10 = 0; i10 < i8; i10++) {
            long j3 = this.zzn[i2];
            if (j3 > j) {
                break;
            }
            if (!z2 || (this.zzm[i2] & 1) != 0) {
                if (j3 == j) {
                    return i10;
                }
                i9 = i10;
            }
            i2++;
            if (i2 == this.zzi) {
                i2 = 0;
            }
        }
        return i9;
    }

    @GuardedBy("this")
    private final long zzL(int i2) {
        long j = this.zzu;
        long jMax = Long.MIN_VALUE;
        if (i2 != 0) {
            int iZzM = zzM(i2 - 1);
            for (int i8 = 0; i8 < i2; i8++) {
                jMax = Math.max(jMax, this.zzn[iZzM]);
                if ((this.zzm[iZzM] & 1) != 0) {
                    break;
                }
                iZzM--;
                if (iZzM == -1) {
                    iZzM = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j, jMax);
        this.zzp -= i2;
        int i9 = this.zzq + i2;
        this.zzq = i9;
        int i10 = this.zzr + i2;
        this.zzr = i10;
        int i11 = this.zzi;
        if (i10 >= i11) {
            this.zzr = i10 - i11;
        }
        int i12 = this.zzs - i2;
        this.zzs = i12;
        if (i12 < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(i9);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i13 = this.zzr;
        if (i13 == 0) {
            i13 = this.zzi;
        }
        int i14 = i13 - 1;
        return this.zzk[i14] + ((long) this.zzl[i14]);
    }

    private final int zzM(int i2) {
        int i8 = this.zzr + i2;
        int i9 = this.zzi;
        return i8 < i9 ? i8 : i8 - i9;
    }

    @CallSuper
    public final void zza() {
        zzb(true);
        zzF();
    }

    @CallSuper
    public final void zzb(boolean z2) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzx = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzw = false;
        this.zzc.zze();
        if (z2) {
            this.zzz = null;
            this.zzy = true;
            this.zzA = true;
        }
    }

    public final void zzc(long j) {
        this.zzt = j;
    }

    public final int zzd() {
        return this.zzq + this.zzp;
    }

    @CallSuper
    public final void zze() {
        zzs();
        zzF();
    }

    @CallSuper
    public final void zzf() throws IOException {
        zzrs zzrsVar = this.zzh;
        if (zzrsVar != null) {
            throw zzrsVar.zza();
        }
    }

    public final int zzg() {
        return this.zzq;
    }

    public final int zzh() {
        return this.zzq + this.zzs;
    }

    @Nullable
    public final synchronized zzv zzi() {
        if (this.zzy) {
            return null;
        }
        return this.zzz;
    }

    public final synchronized long zzj() {
        return this.zzv;
    }

    public final synchronized boolean zzk() {
        return this.zzw;
    }

    @CallSuper
    public final synchronized boolean zzl(boolean z2) {
        boolean z7 = true;
        if (zzH()) {
            if (((zzwh) this.zzc.zza(this.zzq + this.zzs)).zza != this.zzg) {
                return true;
            }
            return zzJ(zzM(this.zzs));
        }
        if (!z2 && !this.zzw) {
            zzv zzvVar = this.zzz;
            if (zzvVar == null) {
                z7 = false;
            } else if (zzvVar == this.zzg) {
                return false;
            }
        }
        return z7;
    }

    @CallSuper
    public final int zzm(zzkj zzkjVar, zzhh zzhhVar, int i2, boolean z2) {
        boolean z7 = (i2 & 2) != 0;
        zzwf zzwfVar = this.zzb;
        int iZzB = zzB(zzkjVar, zzhhVar, z7, z2, zzwfVar);
        if (iZzB != -4) {
            return iZzB;
        }
        if (!zzhhVar.zzb()) {
            int i8 = i2 & 1;
            if ((i2 & 4) == 0) {
                if (i8 != 0) {
                    this.zza.zzd(zzhhVar, zzwfVar);
                    return -4;
                }
                this.zza.zzc(zzhhVar, zzwfVar);
            } else if (i8 != 0) {
                return -4;
            }
            this.zzs++;
        }
        return -4;
    }

    public final synchronized boolean zzn(int i2) {
        zzA();
        int i8 = this.zzq;
        if (i2 >= i8 && i2 <= this.zzp + i8) {
            this.zzt = Long.MIN_VALUE;
            this.zzs = i2 - i8;
            return true;
        }
        return false;
    }

    public final synchronized boolean zzo(long j, boolean z2) throws Throwable {
        Throwable th;
        zzwj zzwjVar;
        long j3;
        int iZzK;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            zzA();
            int i2 = this.zzs;
            int iZzM = zzM(i2);
            if (zzH() && j >= this.zzn[iZzM]) {
                if (j > this.zzv) {
                    if (z2) {
                        z2 = true;
                    }
                }
                if (this.zzA) {
                    try {
                        int i8 = this.zzp - i2;
                        int i9 = 0;
                        while (true) {
                            if (i9 < i8) {
                                if (this.zzn[iZzM] >= j) {
                                    zzwjVar = this;
                                    j3 = j;
                                    iZzK = i9;
                                    break;
                                }
                                iZzM++;
                                if (iZzM == this.zzi) {
                                    iZzM = 0;
                                }
                                i9++;
                            } else if (z2) {
                                j3 = j;
                                iZzK = i8;
                                zzwjVar = this;
                            } else {
                                zzwjVar = this;
                                j3 = j;
                                iZzK = -1;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    zzwjVar = this;
                    j3 = j;
                    iZzK = zzwjVar.zzK(iZzM, this.zzp - i2, j3, true);
                }
                if (iZzK != -1) {
                    zzwjVar.zzt = j3;
                    zzwjVar.zzs += iZzK;
                    return true;
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized int zzp(long j, boolean z2) throws Throwable {
        Throwable th;
        try {
            try {
                int i2 = this.zzs;
                int iZzM = zzM(i2);
                if (!zzH() || j < this.zzn[iZzM]) {
                    return 0;
                }
                if (j <= this.zzv || !z2) {
                    int iZzK = zzK(iZzM, this.zzp - i2, j, true);
                    if (iZzK == -1) {
                        return 0;
                    }
                    return iZzK;
                }
                try {
                    return this.zzp - i2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    public final synchronized void zzq(int i2) {
        boolean z2 = false;
        if (i2 >= 0) {
            try {
                if (this.zzs + i2 <= this.zzp) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzgmd.zza(z2);
        this.zzs += i2;
    }

    public final void zzr(long j, boolean z2, boolean z7) {
        this.zza.zze(zzD(j, false, z7));
    }

    public final void zzs() {
        this.zza.zze(zzE());
    }

    public final void zzt(@Nullable zzwi zzwiVar) {
        this.zzf = zzwiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzu(zzv zzvVar) {
        boolean zZzC = zzC(zzvVar);
        zzwi zzwiVar = this.zzf;
        if (zzwiVar == null || !zZzC) {
            return;
        }
        zzwiVar.zzy(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final int zzv(zzj zzjVar, int i2, boolean z2, int i8) throws IOException {
        return this.zza.zzg(zzjVar, i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzw(zzeg zzegVar, int i2, int i8) {
        this.zza.zzh(zzegVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzx(long j, int i2, int i8, int i9, @Nullable zzael zzaelVar) {
        if (this.zzx) {
            if ((i2 & 1) == 0) {
                return;
            } else {
                this.zzx = false;
            }
        }
        if (this.zzA) {
            if (j < this.zzt) {
                return;
            }
            if ((i2 & 1) == 0) {
                if (!this.zzB) {
                    zzdt.zzc("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzz)));
                    this.zzB = true;
                }
                i2 |= 1;
            }
        }
        int i10 = i2;
        zzG(j, i10, (this.zza.zzf() - ((long) i8)) - ((long) i9), i8, zzaelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ int zzy(zzj zzjVar, int i2, boolean z2) {
        return f.a(this, zzjVar, i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ void zzz(zzeg zzegVar, int i2) {
        f.b(this, zzegVar, i2);
    }
}
