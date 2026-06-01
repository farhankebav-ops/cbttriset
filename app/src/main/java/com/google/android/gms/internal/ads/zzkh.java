package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkh implements Handler.Callback, zzur, zzyq, zzld, zzhy, zzlh, zzhp, zzaax {
    private static final long zza = zzep.zzp(WorkRequest.MIN_BACKOFF_MILLIS);
    private zzlv zzA;
    private boolean zzC;
    private boolean zzD;

    @Nullable
    private zzkg zzE;
    private int zzF;
    private zzlf zzG;
    private zzke zzH;
    private boolean zzI;
    private boolean zzK;
    private boolean zzL;
    private boolean zzN;
    private boolean zzQ;
    private int zzR;

    @Nullable
    private zzkg zzS;
    private long zzT;
    private long zzU;
    private int zzV;
    private boolean zzW;

    @Nullable
    private zzib zzX;
    private zzil zzZ;
    private boolean zzab;
    private final zzhu zzad;
    private final zzlr[] zzb;
    private final zzlp[] zzc;
    private final boolean[] zzd;
    private final zzyr zze;
    private final zzys zzf;
    private final zzkl zzg;
    private final zzza zzh;
    private final zzdm zzi;
    private final zzlg zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzhz zzo;
    private final ArrayList zzp;
    private final zzdc zzq;
    private final zzkf zzr;
    private final zzks zzs;
    private final zzle zzt;
    private final long zzu;
    private final zzpc zzv;
    private final zzmi zzw;
    private final zzdm zzx;
    private final boolean zzy;
    private final zzhq zzz;
    private long zzaa = -9223372036854775807L;
    private int zzO = 0;
    private boolean zzP = false;
    private boolean zzJ = false;
    private float zzac = 1.0f;
    private zzlu zzB = zzlu.zza;
    private long zzY = -9223372036854775807L;
    private long zzM = -9223372036854775807L;

    public zzkh(Context context, zzln[] zzlnVarArr, zzln[] zzlnVarArr2, zzyr zzyrVar, zzys zzysVar, zzkl zzklVar, zzza zzzaVar, int i2, boolean z2, zzmi zzmiVar, zzlv zzlvVar, zzhu zzhuVar, long j, boolean z7, boolean z8, Looper looper, zzdc zzdcVar, zzkf zzkfVar, zzpc zzpcVar, @Nullable zzlg zzlgVar, zzil zzilVar, final zzaax zzaaxVar) {
        this.zzr = zzkfVar;
        this.zze = zzyrVar;
        this.zzf = zzysVar;
        this.zzg = zzklVar;
        this.zzh = zzzaVar;
        this.zzA = zzlvVar;
        this.zzad = zzhuVar;
        this.zzu = j;
        this.zzq = zzdcVar;
        this.zzv = zzpcVar;
        this.zzZ = zzilVar;
        this.zzw = zzmiVar;
        this.zzn = zzklVar.zzf(zzpcVar);
        zzklVar.zzg(zzpcVar);
        zzbf zzbfVar = zzbf.zza;
        zzlf zzlfVarZza = zzlf.zza(zzysVar);
        this.zzG = zzlfVarZza;
        this.zzH = new zzke(zzlfVarZza);
        int length = zzlnVarArr.length;
        this.zzc = new zzlp[2];
        this.zzd = new boolean[2];
        zzlo zzloVarZzg = zzyrVar.zzg();
        this.zzb = new zzlr[2];
        boolean z9 = false;
        for (int i8 = 0; i8 < 2; i8++) {
            zzlnVarArr[i8].zzc(i8, zzpcVar, zzdcVar);
            this.zzc[i8] = zzlnVarArr[i8].zzb();
            this.zzc[i8].zzv(zzloVarZzg);
            zzln zzlnVar = zzlnVarArr2[i8];
            if (zzlnVar != null) {
                zzlnVar.zzc(i8, zzpcVar, zzdcVar);
                z9 = true;
            }
            this.zzb[i8] = new zzlr(zzlnVarArr[i8], zzlnVarArr2[i8], i8);
        }
        this.zzy = z9;
        this.zzo = new zzhz(this, zzdcVar);
        this.zzp = new ArrayList();
        this.zzl = new zzbe();
        this.zzm = new zzbd();
        zzyrVar.zzr(this, zzzaVar);
        this.zzW = true;
        zzdm zzdmVarZzd = zzdcVar.zzd(looper, null);
        this.zzx = zzdmVarZzd;
        this.zzs = new zzks(zzmiVar, zzdmVarZzd, new zzka(this), zzilVar);
        this.zzt = new zzle(this, zzmiVar, zzdmVarZzd, zzpcVar);
        zzlg zzlgVar2 = new zzlg(null);
        this.zzj = zzlgVar2;
        Looper looperZza = zzlgVar2.zza();
        this.zzk = looperZza;
        zzdm zzdmVarZzd2 = zzdcVar.zzd(looperZza, this);
        this.zzi = zzdmVarZzd2;
        this.zzz = new zzhq(context, looperZza, this);
        zzdmVarZzd2.zzd(35, new zzaax() { // from class: com.google.android.gms.internal.ads.zzjw
            @Override // com.google.android.gms.internal.ads.zzaax
            public final /* synthetic */ void zzcS(long j3, long j8, zzv zzvVar, MediaFormat mediaFormat) {
                this.zza.zzcS(j3, j8, zzvVar, mediaFormat);
            }
        }).zza();
    }

    private final void zzA(IOException iOException, int i2) {
        zzks zzksVar = this.zzs;
        zzib zzibVarZza = zzib.zza(iOException, i2);
        zzkp zzkpVarZzm = zzksVar.zzm();
        if (zzkpVarZzm != null) {
            zzibVarZza = zzibVarZza.zzd(zzkpVarZzm.zzg.zza);
        }
        zzdt.zzf("ExoPlayerImplInternal", "Playback error", zzibVarZza);
        zzW(false, false);
        this.zzG = this.zzG.zzf(zzibVarZza);
    }

    private final void zzB(int i2) {
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zze != i2) {
            if (i2 != 2) {
                this.zzY = -9223372036854775807L;
            }
            this.zzG = zzlfVar.zze(i2);
        }
    }

    private final void zzC() {
        this.zzH.zzb(this.zzG);
        if (this.zzH.zzd()) {
            this.zzr.zza(this.zzH);
            this.zzH = new zzke(this.zzG);
        }
    }

    private final void zzD(float f4) throws zzib {
        this.zzac = f4;
        float fZza = this.zzz.zza() * f4;
        int i2 = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                return;
            }
            zzlrVarArr[i2].zzL(fZza);
            i2++;
        }
    }

    private final void zzE(boolean z2, int i2, boolean z7, int i8) throws zzib {
        this.zzH.zza(z7 ? 1 : 0);
        zzG(z2, i2, i8);
    }

    private final void zzF() throws zzib {
        zzlf zzlfVar = this.zzG;
        zzG(zzlfVar.zzl, zzlfVar.zzn, zzlfVar.zzm);
    }

    private final void zzG(boolean z2, int i2, int i8) throws zzib {
        zzH(z2, this.zzz.zzc(z2, this.zzG.zze), i2, i8);
    }

    private final void zzH(boolean z2, int i2, int i8, int i9) throws zzib {
        boolean z7;
        if (!z2) {
            z7 = false;
        } else if (i2 != -1) {
            z7 = true;
        } else {
            i2 = -1;
            z7 = false;
        }
        if (i2 == -1) {
            i9 = 2;
        } else if (i9 == 2) {
            i9 = 1;
        }
        boolean z8 = this.zzC;
        if (i2 == 0) {
            i8 = 1;
        } else if (i8 == 1) {
            i8 = z8 ? 4 : 0;
        }
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zzl == z7 && zzlfVar.zzn == i8 && zzlfVar.zzm == i9) {
            return;
        }
        this.zzG = zzlfVar.zzi(z7, i9, i8);
        zzaC(false, false);
        zzks zzksVar = this.zzs;
        for (zzkp zzkpVarZzm = zzksVar.zzm(); zzkpVarZzm != null; zzkpVarZzm = zzkpVarZzm.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm.zzr().zzc) {
            }
        }
        if (!zzax()) {
            zzK();
            zzL();
            boolean z9 = this.zzG.zzp;
            zzksVar.zzf(this.zzT);
            return;
        }
        int i10 = this.zzG.zze;
        if (i10 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i10 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z2) throws zzib {
        zzuu zzuuVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzuuVar, this.zzG.zzs, true, false);
        if (jZzT != this.zzG.zzs) {
            zzlf zzlfVar = this.zzG;
            this.zzG = zzao(zzuuVar, jZzT, zzlfVar.zzc, zzlfVar.zzd, z2, 5);
        }
    }

    private final void zzJ() throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        if (zzkpVarZzm == null) {
            return;
        }
        zzys zzysVarZzr = zzkpVarZzm.zzr();
        int i2 = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                return;
            }
            if (zzysVarZzr.zza(i2)) {
                zzlrVarArr[i2].zzv();
            }
            i2++;
        }
    }

    private final void zzK() throws zzib {
        this.zzo.zzb();
        int i2 = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                return;
            }
            zzlrVarArr[i2].zzw();
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzL() throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzL():void");
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i2, final boolean z2) {
        boolean[] zArr = this.zzd;
        if (zArr[i2] != z2) {
            zArr[i2] = z2;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i2, z2);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j) {
        int i2 = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        if (zzbeVar.zzf == -9223372036854775807L || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return -9223372036854775807L;
        }
        long j3 = zzbeVar.zzg;
        String str = zzep.zza;
        return zzep.zzq((j3 == -9223372036854775807L ? System.currentTimeMillis() : j3 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j;
    }

    private final boolean zzP(zzbf zzbfVar, zzuu zzuuVar) {
        if (!zzuuVar.zzb() && !zzbfVar.zzg()) {
            int i2 = zzbfVar.zzo(zzuuVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i2, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j) {
        if (zzw()) {
            jMin = this.zzG.zze != 3 ? zza : 1000L;
            zzlr[] zzlrVarArr = this.zzb;
            for (int i2 = 0; i2 < 2; i2++) {
                jMin = Math.min(jMin, zzep.zzp(zzlrVarArr[i2].zzk(this.zzT, this.zzU)));
            }
            if (this.zzG.zzj()) {
                zzks zzksVar = this.zzs;
                if ((zzksVar.zzm() != null ? zzksVar.zzm().zzp() : null) != null) {
                    if (this.zzT + (zzep.zzq(jMin) * this.zzG.zzo.zzb) >= r0.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzG.zze != 3 || zzax()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j + jMin);
    }

    private final void zzR(zzkg zzkgVar, boolean z2) throws Throwable {
        long jLongValue;
        long j;
        long j3;
        boolean z7;
        zzuu zzuuVar;
        zzuu zzuuVar2;
        boolean z8;
        long j8;
        long jZzk;
        zzlf zzlfVar;
        zzbf zzbfVar;
        zzuu zzuuVar3;
        long j9;
        zzuu zzuuVar4;
        long j10;
        long j11;
        boolean z9;
        zzlf zzlfVar2;
        int i2;
        this.zzH.zza(z2 ? 1 : 0);
        if (this.zzD) {
            if (this.zzE != null) {
                this.zzF++;
            }
            this.zzE = zzkgVar;
            return;
        }
        zzbf zzbfVar2 = this.zzG.zza;
        int i8 = this.zzO;
        boolean z10 = this.zzP;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaD = zzaD(zzbfVar2, zzkgVar, true, i8, z10, zzbeVar, zzbdVar);
        if (pairZzaD == null) {
            Pair pairZzY = zzY(this.zzG.zza);
            zzuuVar = (zzuu) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z7 = !this.zzG.zza.zzg();
            j = -9223372036854775807L;
            j3 = 0;
        } else {
            Object obj = pairZzaD.first;
            jLongValue = ((Long) pairZzaD.second).longValue();
            long j12 = zzkgVar.zzc;
            j = j12 == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            j3 = 0;
            zzuu zzuuVarZzy = this.zzs.zzy(this.zzG.zza, obj, jLongValue);
            if (zzuuVarZzy.zzb()) {
                this.zzG.zza.zzo(zzuuVarZzy.zza, zzbdVar);
                if (zzbdVar.zzd(zzuuVarZzy.zzb) == zzuuVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                zzuuVar = zzuuVarZzy;
                z7 = true;
                jLongValue = 0;
            } else {
                z7 = j12 == -9223372036854775807L;
                zzuuVar = zzuuVarZzy;
            }
        }
        try {
            if (this.zzG.zza.zzg()) {
                this.zzS = zzkgVar;
            } else {
                if (pairZzaD != null) {
                    if (zzuuVar.equals(this.zzG.zzb)) {
                        zzkp zzkpVarZzm = this.zzs.zzm();
                        if (zzkpVarZzm == null || !zzkpVarZzm.zze || jLongValue == j3) {
                            jZzk = jLongValue;
                        } else {
                            zzus zzusVar = zzkpVarZzm.zza;
                            long j13 = zzbeVar.zzm;
                            if (this.zzC && j13 != -9223372036854775807L) {
                                Double d8 = this.zzB.zzc;
                            }
                            jZzk = zzusVar.zzk(jLongValue, this.zzA);
                        }
                        if (zzep.zzp(jZzk) == zzep.zzp(this.zzG.zzs) && ((i2 = (zzlfVar2 = this.zzG).zze) == 2 || i2 == 3)) {
                            jLongValue = zzlfVar2.zzs;
                        }
                    } else {
                        jZzk = jLongValue;
                    }
                    this.zzD = this.zzC;
                    long jZzS = zzS(zzuuVar, jZzk, this.zzG.zze == 4);
                    boolean z11 = z7 | (jLongValue != jZzS);
                    try {
                        zzlfVar = this.zzG;
                        zzbfVar = zzlfVar.zza;
                        zzuuVar3 = zzuuVar;
                        j9 = j;
                    } catch (Throwable th) {
                        th = th;
                        zzuuVar2 = zzuuVar;
                    }
                    try {
                        zzag(zzbfVar, zzuuVar3, zzbfVar, zzlfVar.zzb, j9, true);
                        zzuuVar4 = zzuuVar3;
                        j10 = j9;
                        j11 = jZzS;
                        z9 = z11;
                        this.zzG = zzao(zzuuVar4, j11, j10, j11, z9, 2);
                    } catch (Throwable th2) {
                        th = th2;
                        zzuuVar2 = zzuuVar3;
                        j = j9;
                        j8 = jZzS;
                        z8 = z11;
                        this.zzG = zzao(zzuuVar2, j8, j, j8, z8, 2);
                        throw th;
                    }
                }
                if (this.zzG.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            }
            z9 = z7;
            zzuuVar4 = zzuuVar;
            j11 = jLongValue;
            j10 = j;
            this.zzG = zzao(zzuuVar4, j11, j10, j11, z9, 2);
        } catch (Throwable th3) {
            th = th3;
            zzuuVar2 = zzuuVar;
            z8 = z7;
            j8 = jLongValue;
        }
    }

    private final long zzS(zzuu zzuuVar, long j, boolean z2) throws zzib {
        zzks zzksVar = this.zzs;
        return zzT(zzuuVar, j, zzksVar.zzm() != zzksVar.zzn(), z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzT(com.google.android.gms.internal.ads.zzuu r10, long r11, boolean r13, boolean r14) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzT(com.google.android.gms.internal.ads.zzuu, long, boolean, boolean):long");
    }

    private final void zzU(long j, boolean z2) throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long jZza = j + (zzkpVarZzm == null ? 1000000000000L : zzkpVarZzm.zza());
        this.zzT = jZza;
        this.zzo.zzc(jZza);
        zzlr[] zzlrVarArr = this.zzb;
        for (int i2 = 0; i2 < 2; i2++) {
            zzlrVarArr[i2].zzE(zzkpVarZzm, this.zzT, z2);
        }
        for (zzkp zzkpVarZzm2 = r0.zzm(); zzkpVarZzm2 != null; zzkpVarZzm2 = zzkpVarZzm2.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() throws zzib {
        int i2 = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                return;
            }
            zzlrVarArr[i2].zzz(this.zzC ? this.zzB : null);
            i2++;
        }
    }

    private final void zzW(boolean z2, boolean z7) {
        zzX(z2 || !this.zzQ, false, true, false);
        this.zzH.zza(z7 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzG.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[PHI: r2 r7 r9
  0x0094: PHI (r2v2 com.google.android.gms.internal.ads.zzuu) = (r2v1 com.google.android.gms.internal.ads.zzuu), (r2v11 com.google.android.gms.internal.ads.zzuu) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]
  0x0094: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]
  0x0094: PHI (r9v2 long) = (r9v1 long), (r9v7 long) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[PHI: r3
  0x00d8: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v12 com.google.android.gms.internal.ads.zzbf)
  (r3v12 com.google.android.gms.internal.ads.zzbf)
 binds: [B:31:0x00a1, B:33:0x00a5, B:35:0x00b6, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzX(boolean r35, boolean r36, boolean r37, boolean r38) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzX(boolean, boolean, boolean, boolean):void");
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzlf.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzP);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, -9223372036854775807L);
        zzuu zzuuVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzuuVarZzy.zzb()) {
            zzbfVar.zzo(zzuuVarZzy.zza, zzbdVar);
            if (zzuuVarZzy.zzc == zzbdVar.zzd(zzuuVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzuuVarZzy, Long.valueOf(j));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            Object obj = ((zzkd) arrayList.get(size)).zzb;
            String str = zzep.zza;
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaA, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzC) {
            return false;
        }
        boolean z2 = this.zzB.zzg;
        return true;
    }

    private static boolean zzaB(zzlf zzlfVar, zzbd zzbdVar) {
        zzuu zzuuVar = zzlfVar.zzb;
        zzbf zzbfVar = zzlfVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzuuVar.zza, zzbdVar).zzf;
    }

    private final void zzaC(boolean z2, boolean z7) {
        this.zzL = z2;
        long jElapsedRealtime = -9223372036854775807L;
        if (z2 && !z7) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzM = jElapsedRealtime;
    }

    @Nullable
    private static Pair zzaD(zzbf zzbfVar, zzkg zzkgVar, boolean z2, int i2, boolean z7, zzbe zzbeVar, zzbd zzbdVar) {
        Pair pairZzm;
        zzbf zzbfVar2;
        zzbf zzbfVar3 = zzkgVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        boolean zZzg = zzbfVar3.zzg();
        zzbf zzbfVar4 = zzbfVar3;
        if (true == zZzg) {
            zzbfVar4 = zzbfVar;
        }
        try {
            pairZzm = zzbfVar4.zzm(zzbeVar, zzbdVar, zzkgVar.zzb, zzkgVar.zzc);
            zzbfVar2 = zzbfVar4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzbfVar.equals(zzbfVar2)) {
            return pairZzm;
        }
        if (zzbfVar.zze(pairZzm.first) != -1) {
            return (zzbfVar2.zzo(pairZzm.first, zzbdVar).zzf && zzbfVar2.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar2.zze(pairZzm.first)) ? zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzkgVar.zzc) : pairZzm;
        }
        int iZzr = zzr(zzbeVar, zzbdVar, i2, z7, pairZzm.first, zzbfVar2, zzbfVar);
        if (iZzr != -1) {
            return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, -9223372036854775807L);
        }
        return null;
    }

    private static final void zzaE(zzlj zzljVar) throws zzib {
        zzljVar.zzh();
        try {
            zzljVar.zza().zzx(zzljVar.zzc(), zzljVar.zze());
        } finally {
            zzljVar.zzi(true);
        }
    }

    private static final boolean zzaF(@Nullable zzkp zzkpVar) {
        if (zzkpVar != null) {
            try {
                if (zzkpVar.zze) {
                    zzwk[] zzwkVarArr = zzkpVar.zzc;
                    for (int i2 = 0; i2 < 2; i2++) {
                        zzwk zzwkVar = zzwkVarArr[i2];
                        if (zzwkVar != null) {
                            zzwkVar.zzc();
                        }
                    }
                } else {
                    zzkpVar.zza.zzc();
                }
                if (zzkpVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() throws zzib {
        int i2 = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                this.zzaa = -9223372036854775807L;
                return;
            }
            int iZzd = zzlrVarArr[i2].zzd();
            zzlrVarArr[i2].zzA(this.zzo);
            zzN(i2, false);
            this.zzR -= iZzd;
            i2++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaz()) {
            zzlr[] zzlrVarArr = this.zzb;
            for (int i2 = 0; i2 < 2; i2++) {
                zzlr zzlrVar = zzlrVarArr[i2];
                int iZzd = zzlrVar.zzd();
                zzlrVar.zzC(this.zzo);
                this.zzR -= iZzd - zzlrVar.zzd();
            }
            this.zzaa = -9223372036854775807L;
        }
    }

    private final void zzac() throws zzib {
        zzad();
        zzI(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.google.android.gms.internal.ads.zzkh] */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.google.android.gms.internal.ads.zzkh] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    private final void zzad() throws zzib {
        int i2;
        ?? r62;
        boolean z2;
        zzhz zzhzVar = this.zzo;
        float f4 = zzhzVar.zzj().zzb;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzm = zzksVar.zzm();
        zzkp zzkpVarZzn = zzksVar.zzn();
        zzys zzysVar = null;
        boolean z7 = true;
        while (zzkpVarZzm != null && zzkpVarZzm.zze) {
            zzlf zzlfVar = this.zzG;
            zzys zzysVarZzk = zzkpVarZzm.zzk(f4, zzlfVar.zza, zzlfVar.zzl);
            zzys zzysVar2 = zzkpVarZzm == zzksVar.zzm() ? zzysVarZzk : zzysVar;
            zzys zzysVarZzr = zzkpVarZzm.zzr();
            boolean z8 = false;
            if (zzysVarZzr != null) {
                zzyk[] zzykVarArr = zzysVarZzk.zzc;
                if (zzysVarZzr.zzc.length == zzykVarArr.length) {
                    for (int i8 = 0; i8 < zzykVarArr.length; i8++) {
                        if (zzysVarZzk.zzb(zzysVarZzr, i8)) {
                        }
                    }
                    if (zzkpVarZzm != zzkpVarZzn) {
                        z8 = true;
                    }
                    z7 &= z8;
                    zzkpVarZzm = zzkpVarZzm.zzp();
                    zzysVar = zzysVar2;
                }
            }
            if (z7) {
                zzkp zzkpVarZzm2 = zzksVar.zzm();
                int iZzs = zzksVar.zzs(zzkpVarZzm2) & 1;
                zzlr[] zzlrVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzysVar2.getClass();
                long jZzm = zzkpVarZzm2.zzm(zzysVar2, this.zzG.zzs, 1 == iZzs, zArr);
                zzlf zzlfVar2 = this.zzG;
                if (zzlfVar2.zze == 4 || jZzm == zzlfVar2.zzs) {
                    z2 = false;
                } else {
                    z2 = false;
                    z8 = true;
                }
                zzlf zzlfVar3 = this.zzG;
                boolean z9 = z2;
                i2 = 2;
                ?? r63 = this;
                r63.zzG = zzao(zzlfVar3.zzb, jZzm, zzlfVar3.zzc, zzlfVar3.zzd, z8, 5);
                if (z8) {
                    r63.zzU(jZzm, true);
                }
                r63.zzab();
                boolean[] zArr2 = new boolean[2];
                for (?? r8 = z9; r8 < 2; r8++) {
                    int iZzd = zzlrVarArr[r8].zzd();
                    zArr2[r8] = zzlrVarArr[r8].zzM();
                    zzlrVarArr[r8].zzD(zzkpVarZzm2.zzc[r8], zzhzVar, r63.zzT, zArr[r8]);
                    if (iZzd - zzlrVarArr[r8].zzd() > 0) {
                        r63.zzN(r8, z9);
                    }
                    r63.zzR -= iZzd - zzlrVarArr[r8].zzd();
                }
                r63.zzaq(zArr2, r63.zzT);
                zzkpVarZzm2.zzh = true;
                r62 = r63;
            } else {
                zzkh zzkhVar = this;
                i2 = 2;
                zzksVar.zzs(zzkpVarZzm);
                r62 = zzkhVar;
                if (zzkpVarZzm.zze) {
                    long jMax = Math.max(zzkpVarZzm.zzg.zzb, zzkhVar.zzT - zzkpVarZzm.zza());
                    if (zzkhVar.zzy && zzkhVar.zzaz() && zzksVar.zzo() == zzkpVarZzm) {
                        zzkhVar.zzab();
                    }
                    zzkpVarZzm.zzl(zzysVarZzk, jMax, false);
                    r62 = zzkhVar;
                }
            }
            r62.zzas(true);
            if (r62.zzG.zze != 4) {
                r62.zzam();
                r62.zzL();
                r62.zzi.zzh(i2);
                return;
            }
            return;
        }
    }

    private final boolean zzae() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long j = zzkpVarZzm.zzg.zze;
        if (zzkpVarZzm.zze) {
            return j == -9223372036854775807L || this.zzG.zzs < j || !zzax();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaf(com.google.android.gms.internal.ads.zzbf r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzaf(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    private final void zzag(zzbf zzbfVar, zzuu zzuuVar, zzbf zzbfVar2, zzuu zzuuVar2, long j, boolean z2) throws zzib {
        if (!zzP(zzbfVar, zzuuVar)) {
            zzav zzavVar = zzuuVar.zzb() ? zzav.zza : this.zzG.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzal(this.zzG.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zzm;
        int i2 = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        zzhu zzhuVar = this.zzad;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzep.zza;
        zzhuVar.zza(zzafVar);
        if (j != -9223372036854775807L) {
            zzhuVar.zzb(zzO(zzbfVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzuuVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z2) {
            zzhuVar.zzb(-9223372036854775807L);
        }
    }

    private final long zzah(zzkp zzkpVar) {
        if (zzkpVar == null) {
            return 0L;
        }
        long jZza = zzkpVar.zza();
        if (zzkpVar.zze) {
            int i2 = 0;
            while (true) {
                zzlr[] zzlrVarArr = this.zzb;
                if (i2 >= 2) {
                    break;
                }
                if (zzlrVarArr[i2].zzp(zzkpVar)) {
                    long jZzf = zzlrVarArr[i2].zzf(zzkpVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i2++;
            }
        }
        return jZza;
    }

    private final void zzai() {
        zzks zzksVar = this.zzs;
        zzksVar.zzt();
        zzkp zzkpVarZzl = zzksVar.zzl();
        if (zzkpVarZzl != null) {
            if (!zzkpVarZzl.zzd || zzkpVarZzl.zze) {
                zzus zzusVar = zzkpVarZzl.zza;
                if (zzusVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzG.zza, zzkpVarZzl.zzg.zza, zzkpVarZzl.zze ? zzusVar.zzi() : 0L)) {
                    if (!zzkpVarZzl.zzd) {
                        zzkpVarZzl.zzt(this, zzkpVarZzl.zzg.zzb);
                        return;
                    }
                    zzkm zzkmVar = new zzkm();
                    zzkmVar.zza(this.zzT - zzkpVarZzl.zza());
                    zzkmVar.zzb(this.zzo.zzj().zzb);
                    zzkmVar.zzc(this.zzM);
                    zzkpVarZzl.zzj(new zzkn(zzkmVar, null));
                }
            }
        }
    }

    private final void zzaj() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        boolean z2 = false;
        if (zzkpVarZzm != null && zzkpVarZzm.zzg.zzi && this.zzJ) {
            z2 = true;
        }
        this.zzK = z2;
    }

    private final void zzak(zzav zzavVar, boolean z2) throws zzib {
        zzal(zzavVar, zzavVar.zzb, true, z2);
    }

    private final void zzal(zzav zzavVar, float f4, boolean z2, boolean z7) throws zzib {
        int i2;
        if (z2) {
            if (z7) {
                this.zzH.zza(1);
            }
            zzlf zzlfVar = this.zzG;
            this.zzG = new zzlf(zzlfVar.zza, zzlfVar.zzb, zzlfVar.zzc, zzlfVar.zzd, zzlfVar.zze, zzlfVar.zzf, zzlfVar.zzg, zzlfVar.zzh, zzlfVar.zzi, zzlfVar.zzj, zzlfVar.zzk, zzlfVar.zzl, zzlfVar.zzm, zzlfVar.zzn, zzavVar, zzlfVar.zzq, zzlfVar.zzr, zzlfVar.zzs, zzlfVar.zzt, false);
        }
        float f8 = zzavVar.zzb;
        zzkp zzkpVarZzm = this.zzs.zzm();
        while (true) {
            i2 = 0;
            if (zzkpVarZzm == null) {
                break;
            }
            zzyk[] zzykVarArr = zzkpVarZzm.zzr().zzc;
            int length = zzykVarArr.length;
            while (i2 < length) {
                zzyk zzykVar = zzykVarArr[i2];
                i2++;
            }
            zzkpVarZzm = zzkpVarZzm.zzp();
        }
        zzlr[] zzlrVarArr = this.zzb;
        while (i2 < 2) {
            zzlrVarArr[i2].zzm(f4, f8);
            i2++;
        }
    }

    private final void zzam() {
        long jZza;
        long jZza2;
        zzks zzksVar = this.zzs;
        boolean zZzh = false;
        if (zzaF(zzksVar.zzk())) {
            zzkp zzkpVarZzk = zzksVar.zzk();
            long jZzau = zzau(zzkpVarZzk.zzg());
            if (zzkpVarZzk == zzksVar.zzm()) {
                jZza = this.zzT;
                jZza2 = zzkpVarZzk.zza();
            } else {
                jZza = this.zzT - zzkpVarZzk.zza();
                jZza2 = zzkpVarZzk.zzg.zzb;
            }
            zzkk zzkkVar = new zzkk(this.zzv, this.zzG.zza, zzkpVarZzk.zzg.zza, jZza - jZza2, jZzau, this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : -9223372036854775807L, this.zzM);
            zzkl zzklVar = this.zzg;
            boolean zZzh2 = zzklVar.zzh(zzkkVar);
            zzkp zzkpVarZzm = zzksVar.zzm();
            if (zZzh2 || !zzkpVarZzm.zze || jZzau >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzkpVarZzm.zza.zzf(this.zzG.zzs, false);
                zZzh = zzklVar.zzh(zzkkVar);
            }
        }
        this.zzN = zZzh;
        if (zZzh) {
            zzkp zzkpVarZzk2 = zzksVar.zzk();
            zzkpVarZzk2.getClass();
            zzkm zzkmVar = new zzkm();
            zzkmVar.zza(this.zzT - zzkpVarZzk2.zza());
            zzkmVar.zzb(this.zzo.zzj().zzb);
            zzkmVar.zzc(this.zzM);
            zzkpVarZzk2.zzj(new zzkn(zzkmVar, null));
        }
        zzan();
    }

    private final void zzan() {
        zzkp zzkpVarZzk = this.zzs.zzk();
        boolean z2 = true;
        if (!this.zzN && (zzkpVarZzk == null || !zzkpVarZzk.zza.zzn())) {
            z2 = false;
        }
        zzlf zzlfVar = this.zzG;
        if (z2 != zzlfVar.zzg) {
            this.zzG = zzlfVar.zzg(z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    @androidx.annotation.CheckResult
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzlf zzao(com.google.android.gms.internal.ads.zzuu r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzao(com.google.android.gms.internal.ads.zzuu, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzlf");
    }

    private final void zzap() throws zzib {
        zzaq(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzaq(boolean[] zArr, long j) throws zzib {
        zzlr[] zzlrVarArr;
        long j3;
        zzkp zzkpVarZzn = this.zzs.zzn();
        zzys zzysVarZzr = zzkpVarZzn.zzr();
        int i2 = 0;
        while (true) {
            zzlrVarArr = this.zzb;
            if (i2 >= 2) {
                break;
            }
            if (!zzysVarZzr.zza(i2)) {
                zzlrVarArr[i2].zzG();
            }
            i2++;
        }
        int i8 = 0;
        while (i8 < 2) {
            if (!zzysVarZzr.zza(i8) || zzlrVarArr[i8].zzp(zzkpVarZzn)) {
                j3 = j;
            } else {
                j3 = j;
                zzar(zzkpVarZzn, i8, zArr[i8], j3);
            }
            i8++;
            j = j3;
        }
    }

    private final void zzar(zzkp zzkpVar, int i2, boolean z2, long j) throws zzib {
        zzlr zzlrVar = this.zzb[i2];
        if (zzlrVar.zzM()) {
            return;
        }
        boolean z7 = zzkpVar == this.zzs.zzm();
        zzys zzysVarZzr = zzkpVar.zzr();
        zzlq zzlqVar = zzysVarZzr.zzb[i2];
        zzyk zzykVar = zzysVarZzr.zzc[i2];
        boolean z8 = zzax() && this.zzG.zze == 3;
        boolean z9 = !z2 && z8;
        this.zzR++;
        zzlrVar.zzx(zzlqVar, zzykVar, zzkpVar.zzc[i2], this.zzT, z9, z7, j, zzkpVar.zza(), zzkpVar.zzg.zza, this.zzo);
        zzlrVar.zzy(11, new zzjv(this), zzkpVar);
        if (z8 && z7) {
            zzlrVar.zzv();
        }
    }

    private final void zzas(boolean z2) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        zzuu zzuuVar = zzkpVarZzk == null ? this.zzG.zzb : zzkpVarZzk.zzg.zza;
        boolean zEquals = this.zzG.zzk.equals(zzuuVar);
        if (!zEquals) {
            this.zzG = this.zzG.zzh(zzuuVar);
        }
        zzlf zzlfVar = this.zzG;
        zzlfVar.zzq = zzkpVarZzk == null ? zzlfVar.zzs : zzkpVarZzk.zzf();
        this.zzG.zzr = zzat();
        if ((!zEquals || z2) && zzkpVarZzk != null && zzkpVarZzk.zze) {
            zzaw(zzkpVarZzk.zzg.zza, zzkpVarZzk.zzq(), zzkpVarZzk.zzr());
        }
    }

    private final long zzat() {
        return zzau(this.zzG.zzq);
    }

    private final long zzau(long j) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        if (zzkpVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzT - zzkpVarZzk.zza()));
    }

    private final long zzav(zzkp zzkpVar) {
        zzgmd.zzh(zzkpVar.zze);
        return (long) ((zzkpVar.zzc() - this.zzT) / this.zzo.zzj().zzb);
    }

    private final void zzaw(zzuu zzuuVar, zzwv zzwvVar, zzys zzysVar) {
        long jZza;
        long jZza2;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzk = zzksVar.zzk();
        zzkpVarZzk.getClass();
        if (zzkpVarZzk == zzksVar.zzm()) {
            jZza = this.zzT;
            jZza2 = zzkpVarZzk.zza();
        } else {
            jZza = this.zzT - zzkpVarZzk.zza();
            jZza2 = zzkpVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzkk(this.zzv, this.zzG.zza, zzuuVar, jZza - jZza2, zzau(zzkpVarZzk.zzf()), this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : -9223372036854775807L, this.zzM), zzwvVar, zzysVar.zzc);
    }

    private final boolean zzax() {
        zzlf zzlfVar = this.zzG;
        return zzlfVar.zzl && zzlfVar.zzn == 0;
    }

    private final void zzay(int i2) throws Throwable {
        zzlr zzlrVar = this.zzb[i2];
        try {
            zzkp zzkpVarZzm = this.zzs.zzm();
            if (zzkpVarZzm == null) {
                throw null;
            }
            zzlrVar.zzu(zzkpVarZzm);
        } catch (IOException e) {
            e = e;
            zzlrVar.zze();
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zzlrVar.zze();
            throw e;
        }
    }

    private final boolean zzaz() {
        if (!this.zzy) {
            return false;
        }
        zzlr[] zzlrVarArr = this.zzb;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzlrVarArr[i2].zzc()) {
                return true;
            }
        }
        return false;
    }

    public static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i2, boolean z2, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbe zzbeVar2 = zzbeVar;
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.zzb(zzbfVar3.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i8 = 0; i8 < zzbfVar2.zza(); i8++) {
            if (zzbfVar2.zzb(i8, zzbeVar, 0L).zzb.equals(obj2)) {
                return i8;
            }
        }
        int iZze = zzbfVar3.zze(obj);
        int iZzc = zzbfVar3.zzc();
        int iZze2 = -1;
        int i9 = 0;
        while (true) {
            if (i9 >= iZzc || iZze2 != -1) {
                break;
            }
            zzbf zzbfVar4 = zzbfVar3;
            int iZzl = zzbfVar4.zzl(iZze, zzbdVar, zzbeVar2, i2, z2);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar4.zzf(iZzl));
            i9++;
            zzbfVar3 = zzbfVar4;
            iZze = iZzl;
            zzbeVar2 = zzbeVar;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    public static final /* synthetic */ void zzz(zzlj zzljVar) {
        try {
            zzaE(zzljVar);
        } catch (zzib e) {
            zzdt.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05f6 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TRY_LEAVE, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0705 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, LOOP:18: B:349:0x0703->B:350:0x0705, LOOP_END, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x086e A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, LOOP:8: B:439:0x086c->B:440:0x086e, LOOP_END, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:443:0x087c A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:447:0x088c A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x096f A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0a20 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0a2d A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0a34 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:545:0x0a51 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0ad1 A[Catch: IOException -> 0x0029, zztu -> 0x002c, zzgc -> 0x002f, zzat -> 0x0032, zzrr -> 0x0035, RuntimeException -> 0x0590, zzib -> 0x0593, TryCatch #34 {zzib -> 0x0593, RuntimeException -> 0x0590, blocks: (B:270:0x058c, B:278:0x05aa, B:279:0x05b3, B:281:0x05c4, B:283:0x05d2, B:287:0x05eb, B:384:0x076d, B:386:0x0773, B:388:0x0779, B:391:0x077e, B:392:0x0789, B:394:0x078d, B:398:0x07b2, B:400:0x07b8, B:402:0x07c0, B:403:0x07c8, B:404:0x07cb, B:406:0x07d4, B:454:0x089f, B:457:0x08ab, B:462:0x08b8, B:464:0x08c0, B:465:0x08c6, B:467:0x08d4, B:468:0x08ee, B:470:0x08f2, B:472:0x08fa, B:486:0x0927, B:473:0x0900, B:475:0x090b, B:479:0x0914, B:485:0x0924, B:489:0x093b, B:491:0x0941, B:495:0x0949, B:497:0x0951, B:499:0x0955, B:500:0x0960, B:502:0x0966, B:553:0x0a73, B:556:0x0a7b, B:558:0x0a7f, B:560:0x0a87, B:561:0x0a8a, B:562:0x0a8e, B:564:0x0a94, B:566:0x0a9d, B:568:0x0aa7, B:570:0x0aad, B:572:0x0ab3, B:579:0x0ad5, B:581:0x0adb, B:585:0x0ae5, B:596:0x0afe, B:593:0x0af7, B:595:0x0afb, B:573:0x0aba, B:576:0x0ac8, B:577:0x0ad0, B:578:0x0ad1, B:503:0x096f, B:505:0x0976, B:507:0x097a, B:532:0x0a14, B:534:0x0a20, B:510:0x0984, B:512:0x0988, B:514:0x099a, B:516:0x09a5, B:518:0x09af, B:522:0x09b8, B:524:0x09c2, B:530:0x09cd, B:535:0x0a2d, B:537:0x0a34, B:539:0x0a38, B:543:0x0a41, B:545:0x0a51, B:547:0x0a57, B:549:0x0a61, B:550:0x0a66, B:551:0x0a6b, B:552:0x0a70, B:488:0x0932, B:409:0x07de, B:411:0x07e2, B:413:0x07e8, B:415:0x07ee, B:417:0x07f8, B:420:0x07fe, B:421:0x0801, B:423:0x080a, B:425:0x081c, B:427:0x0825, B:429:0x082d, B:434:0x0839, B:436:0x0863, B:438:0x0869, B:440:0x086e, B:441:0x0876, B:443:0x087c, B:444:0x087f, B:445:0x0888, B:447:0x088c, B:449:0x0892, B:450:0x0897, B:453:0x089e, B:290:0x05f6, B:300:0x0612, B:305:0x0623, B:309:0x0635, B:314:0x064b, B:319:0x068a, B:321:0x0691, B:323:0x0695, B:327:0x06a5, B:329:0x06a9, B:333:0x06b0, B:335:0x06b6, B:337:0x06d3, B:340:0x06dc, B:342:0x06e1, B:344:0x06e8, B:345:0x06f0, B:347:0x06f6, B:325:0x069b, B:350:0x0705, B:365:0x0734, B:367:0x073a, B:369:0x073e, B:371:0x0743, B:383:0x076a, B:374:0x074c, B:376:0x0752, B:380:0x0760, B:382:0x0767, B:597:0x0b03, B:601:0x0b0e), top: B:687:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0b1f  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0b23  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0b5b  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0b65  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0b78  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0b91  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0bf3  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0bf7  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0c01  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zza(float f4) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzb(int i2) {
        this.zzi.zze(33, i2, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzcS(long j, long j3, zzv zzvVar, @Nullable MediaFormat mediaFormat) {
        if (this.zzD) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z2, int i2, int i8) {
        this.zzi.zze(1, z2 ? 1 : 0, (i8 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i2, long j) {
        this.zzi.zzd(3, new zzkg(zzbfVar, i2, j)).zza();
    }

    public final void zzg(zzlu zzluVar) {
        this.zzi.zzd(38, zzluVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z2) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f4) {
        this.zzi.zzd(32, Float.valueOf(f4)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzk(zzlj zzljVar) {
        if (!this.zzI && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzljVar).zza();
        } else {
            zzdt.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzljVar.zzi(false);
        }
    }

    public final boolean zzl(@Nullable Object obj, long j) {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdfVar)).zza();
        if (j != -9223372036854775807L) {
            return zzdfVar.zze(j);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzI = true;
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(7, zzdfVar).zza();
        return zzdfVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final void zzo() {
        zzdm zzdmVar = this.zzi;
        zzdmVar.zzk(2);
        zzdmVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        this.zzi.zzd(8, zzusVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyq
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        this.zzi.zzd(9, (zzus) zzwmVar).zza();
    }

    public final /* synthetic */ zzkp zzt(zzkq zzkqVar, long j) {
        zzyv zzyvVarZze = this.zzg.zze(this.zzv);
        long j3 = this.zzZ.zzb;
        zzys zzysVar = this.zzf;
        zzle zzleVar = this.zzt;
        return new zzkp(this.zzc, j, this.zze, zzyvVarZze, zzleVar, zzkqVar, zzysVar, -9223372036854775807L);
    }

    public final /* synthetic */ void zzu(int i2, boolean z2) {
        this.zzw.zzB(i2, this.zzb[i2].zze(), z2);
    }

    public final /* synthetic */ void zzv(int i2) {
        this.zzw.zzW(i2);
    }

    public final /* synthetic */ zzdm zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i2, long j, zzwn zzwnVar) {
        this.zzi.zzd(17, new zzkb(list, zzwnVar, i2, j, null)).zza();
    }
}
