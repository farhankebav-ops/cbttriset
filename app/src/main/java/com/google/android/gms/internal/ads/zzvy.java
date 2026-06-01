package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvy implements zzus, zzadd, zzzf, zzzk, zzwi {
    private static final Map zzb;
    private static final zzv zzc;
    private zzvx zzA;
    private zzaed zzB;
    private long zzC;
    private boolean zzD;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private int zzI;
    private boolean zzJ;
    private long zzK;
    private boolean zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    private final Uri zzd;
    private final zzgb zze;
    private final zzrz zzf;
    private final zzve zzg;
    private final zzru zzh;
    private final zzvq zzi;
    private final zzyv zzj;
    private final long zzk;
    private final long zzl;
    private final zzvn zzn;

    @Nullable
    private zzur zzs;

    @Nullable
    private zzagf zzt;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;
    private final zzzn zzm = new zzzn("ProgressiveMediaPeriod");
    private final zzdf zzo = new zzdf(zzdc.zza);
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvu
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzD();
        }
    };
    private final Runnable zzq = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvr
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzr = zzep.zzc(null);
    private zzvw[] zzv = new zzvw[0];
    private zzwj[] zzu = new zzwj[0];
    private long zzL = -9223372036854775807L;
    private int zzE = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzt zztVar = new zzt();
        zztVar.zza("icy");
        zztVar.zzm("application/x-icy");
        zzc = zztVar.zzM();
    }

    public zzvy(Uri uri, zzgb zzgbVar, zzvn zzvnVar, zzrz zzrzVar, zzru zzruVar, zzze zzzeVar, zzve zzveVar, zzvq zzvqVar, zzyv zzyvVar, @Nullable String str, int i2, int i8, @Nullable zzv zzvVar, long j, @Nullable zzzt zzztVar) {
        this.zzd = uri;
        this.zze = zzgbVar;
        this.zzf = zzrzVar;
        this.zzh = zzruVar;
        this.zzg = zzveVar;
        this.zzi = zzvqVar;
        this.zzj = zzyvVar;
        this.zzk = i2;
        this.zzn = zzvnVar;
        this.zzl = j;
    }

    private final void zzR(int i2) {
        zzaa();
        zzvx zzvxVar = this.zzA;
        boolean[] zArr = zzvxVar.zzd;
        if (zArr[i2]) {
            return;
        }
        zzv zzvVarZza = zzvxVar.zza.zza(i2).zza(0);
        this.zzg.zzh(new zzuq(1, zzas.zzg(zzvVarZza.zzo), zzvVarZza, 0, null, zzep.zzp(this.zzK), -9223372036854775807L));
        zArr[i2] = true;
    }

    private final void zzS(int i2) {
        zzaa();
        if (this.zzM) {
            if ((!this.zzy || this.zzA.zzb[i2]) && !this.zzu[i2].zzl(false)) {
                this.zzL = 0L;
                this.zzM = false;
                this.zzG = true;
                this.zzK = 0L;
                this.zzN = 0;
                for (zzwj zzwjVar : this.zzu) {
                    zzwjVar.zzb(false);
                }
                zzur zzurVar = this.zzs;
                zzurVar.getClass();
                zzurVar.zzs(this);
            }
        }
    }

    private final boolean zzT() {
        return this.zzG || zzZ();
    }

    private final zzaem zzU(zzvw zzvwVar) {
        int length = this.zzu.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zzvwVar.equals(this.zzv[i2])) {
                return this.zzu[i2];
            }
        }
        if (this.zzw) {
            int i8 = zzvwVar.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 55);
            sb.append("Extractor added new track (id=");
            sb.append(i8);
            sb.append(") after finishing tracks.");
            zzdt.zzc("ProgressiveMediaPeriod", sb.toString());
            return new zzacx();
        }
        zzwj zzwjVar = new zzwj(this.zzj, this.zzf, this.zzh);
        zzwjVar.zzt(this);
        int i9 = length + 1;
        zzvw[] zzvwVarArr = (zzvw[]) Arrays.copyOf(this.zzv, i9);
        zzvwVarArr[length] = zzvwVar;
        String str = zzep.zza;
        this.zzv = zzvwVarArr;
        zzwj[] zzwjVarArr = (zzwj[]) Arrays.copyOf(this.zzu, i9);
        zzwjVarArr[length] = zzwjVar;
        this.zzu = zzwjVarArr;
        return zzwjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public final void zzD() {
        int i2;
        if (this.zzP || this.zzx || !this.zzw || this.zzB == null) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            if (zzwjVar.zzi() == null) {
                return;
            }
        }
        this.zzo.zzb();
        int length = this.zzu.length;
        zzbg[] zzbgVarArr = new zzbg[length];
        boolean[] zArr = new boolean[length];
        for (int i8 = 0; i8 < length; i8++) {
            zzv zzvVarZzi = this.zzu[i8].zzi();
            zzvVarZzi.getClass();
            String str = zzvVarZzi.zzo;
            boolean zZza = zzas.zza(str);
            boolean z2 = zZza || zzas.zzb(str);
            zArr[i8] = z2;
            this.zzy = z2 | this.zzy;
            this.zzz = this.zzl != -9223372036854775807L && length == 1 && zzas.zzc(str);
            zzagf zzagfVar = this.zzt;
            if (zzagfVar != null) {
                if (zZza || this.zzv[i8].zzb) {
                    zzap zzapVar = zzvVarZzi.zzl;
                    zzap zzapVar2 = zzapVar == null ? new zzap(-9223372036854775807L, zzagfVar) : zzapVar.zzg(zzagfVar);
                    zzt zztVarZza = zzvVarZzi.zza();
                    zztVarZza.zzk(zzapVar2);
                    zzvVarZzi = zztVarZza.zzM();
                }
                if (zZza && zzvVarZzi.zzh == -1 && zzvVarZzi.zzi == -1 && (i2 = zzagfVar.zza) != -1) {
                    zzt zztVarZza2 = zzvVarZzi.zza();
                    zztVarZza2.zzh(i2);
                    zzvVarZzi = zztVarZza2.zzM();
                }
            }
            zzv zzvVarZzb = zzvVarZzi.zzb(this.zzf.zzb(zzvVarZzi));
            zzbgVarArr[i8] = new zzbg(Integer.toString(i8), zzvVarZzb);
            this.zzH = zzvVarZzb.zzu | this.zzH;
        }
        this.zzA = new zzvx(new zzwv(zzbgVarArr), zArr);
        if (this.zzz && this.zzC == -9223372036854775807L) {
            this.zzC = this.zzl;
            this.zzB = new zzvo(this, this.zzB);
        }
        this.zzi.zzb(this.zzC, this.zzB, this.zzD);
        this.zzx = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzp(this);
    }

    private final void zzW() {
        zzvp zzvpVar = new zzvp(this, this.zzd, this.zze, this.zzn, this, this.zzo);
        if (this.zzx) {
            zzgmd.zzh(zzZ());
            long j = this.zzC;
            if (j != -9223372036854775807L && this.zzL > j) {
                this.zzO = true;
                this.zzL = -9223372036854775807L;
                return;
            }
            zzaed zzaedVar = this.zzB;
            zzaedVar.getClass();
            zzvpVar.zzd(zzaedVar.zzc(this.zzL).zza.zzc, this.zzL);
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zzc(this.zzL);
            }
            this.zzL = -9223372036854775807L;
        }
        this.zzN = zzX();
        this.zzm.zzd(zzvpVar, this, zzze.zza(this.zzE));
    }

    private final int zzX() {
        int iZzd = 0;
        for (zzwj zzwjVar : this.zzu) {
            iZzd += zzwjVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzY(boolean r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzwj[] r3 = r5.zzu
            int r4 = r3.length
            if (r0 >= r4) goto L22
            if (r6 != 0) goto L15
            com.google.android.gms.internal.ads.zzvx r4 = r5.zzA
            r4.getClass()
            boolean[] r4 = r4.zzc
            boolean r4 = r4[r0]
            if (r4 == 0) goto L1f
        L15:
            r3 = r3[r0]
            long r3 = r3.zzj()
            long r1 = java.lang.Math.max(r1, r3)
        L1f:
            int r0 = r0 + 1
            goto L3
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzY(boolean):long");
    }

    private final boolean zzZ() {
        return this.zzL != -9223372036854775807L;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzaa() {
        zzgmd.zzh(this.zzx);
        this.zzA.getClass();
        this.zzB.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzA(zzzj zzzjVar, long j, long j3, boolean z2) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j3, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zzf(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        if (z2) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zzb(false);
        }
        if (this.zzI > 0) {
            zzur zzurVar = this.zzs;
            zzurVar.getClass();
            zzurVar.zzs(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzB(zzzj zzzjVar, long j, long j3) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        if (this.zzC == -9223372036854775807L && this.zzB != null) {
            long jZzY = zzY(true);
            long j8 = jZzY == Long.MIN_VALUE ? 0L : jZzY + WorkRequest.MIN_BACKOFF_MILLIS;
            this.zzC = j8;
            this.zzi.zzb(j8, this.zzB, this.zzD);
        }
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j3, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zze(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        this.zzO = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzC(zzzj zzzjVar, long j, long j3, int i2) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        this.zzg.zzd(i2 == 0 ? new zzul(zzvpVar.zze(), zzvpVar.zzh(), j) : new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j3, zzgyVarZzf.zzf()), new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), i2);
    }

    public final /* synthetic */ void zzE() {
        if (this.zzP) {
            return;
        }
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    public final /* synthetic */ void zzF(zzaed zzaedVar) {
        this.zzB = this.zzt == null ? zzaedVar : new zzaec(-9223372036854775807L, 0L);
        this.zzC = zzaedVar.zza();
        boolean z2 = false;
        if (!this.zzJ && zzaedVar.zza() == -9223372036854775807L) {
            z2 = true;
        }
        this.zzD = z2;
        this.zzE = true == z2 ? 7 : 1;
        if (this.zzx) {
            this.zzi.zzb(this.zzC, zzaedVar, z2);
        } else {
            zzD();
        }
    }

    public final /* synthetic */ void zzG() {
        this.zzJ = true;
    }

    public final /* synthetic */ void zzH() {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    public final /* synthetic */ long zzI(boolean z2) {
        return zzY(true);
    }

    public final /* synthetic */ long zzL() {
        return this.zzk;
    }

    public final /* synthetic */ Runnable zzM() {
        return this.zzq;
    }

    public final /* synthetic */ Handler zzN() {
        return this.zzr;
    }

    public final /* synthetic */ zzagf zzO() {
        return this.zzt;
    }

    public final /* synthetic */ void zzP(zzagf zzagfVar) {
        this.zzt = zzagfVar;
    }

    public final /* synthetic */ long zzQ() {
        return this.zzC;
    }

    public final void zza() {
        if (this.zzx) {
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zze();
            }
        }
        this.zzm.zzg(this);
        this.zzr.removeCallbacksAndMessages(null);
        this.zzs = null;
        this.zzP = true;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzs = zzurVar;
        this.zzo.zza();
        zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        zzr();
        if (this.zzO && !this.zzx) {
            throw zzat.zzb("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzaa();
        return this.zzA.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        zzyk zzykVar;
        zzaa();
        zzvx zzvxVar = this.zzA;
        zzwv zzwvVar = zzvxVar.zza;
        boolean[] zArr3 = zzvxVar.zzc;
        int i2 = this.zzI;
        int i8 = 0;
        for (int i9 = 0; i9 < zzykVarArr.length; i9++) {
            zzwk zzwkVar = zzwkVarArr[i9];
            if (zzwkVar != null && (zzykVarArr[i9] == null || !zArr[i9])) {
                int iZza = ((zzvv) zzwkVar).zza();
                zzgmd.zzh(zArr3[iZza]);
                this.zzI--;
                zArr3[iZza] = false;
                zzwkVarArr[i9] = null;
            }
        }
        boolean z2 = !this.zzF ? j == 0 || this.zzz : i2 != 0;
        for (int i10 = 0; i10 < zzykVarArr.length; i10++) {
            if (zzwkVarArr[i10] == null && (zzykVar = zzykVarArr[i10]) != null) {
                zzgmd.zzh(zzykVar.zze() == 1);
                zzgmd.zzh(zzykVar.zzf(0) == 0);
                int iZzb = zzwvVar.zzb(zzykVar.zza());
                zzgmd.zzh(!zArr3[iZzb]);
                this.zzI++;
                zArr3[iZzb] = true;
                this.zzH = zzykVar.zzc().zzu | this.zzH;
                zzwkVarArr[i10] = new zzvv(this, iZzb);
                zArr2[i10] = true;
                if (!z2) {
                    zzwj zzwjVar = this.zzu[iZzb];
                    z2 = (zzwjVar.zzh() == 0 || zzwjVar.zzo(j, true)) ? false : true;
                }
            }
        }
        if (this.zzI == 0) {
            this.zzM = false;
            this.zzG = false;
            this.zzH = false;
            zzzn zzznVar = this.zzm;
            if (zzznVar.zze()) {
                zzwj[] zzwjVarArr = this.zzu;
                int length = zzwjVarArr.length;
                while (i8 < length) {
                    zzwjVarArr[i8].zzs();
                    i8++;
                }
                zzznVar.zzf();
            } else {
                this.zzO = false;
                for (zzwj zzwjVar2 : this.zzu) {
                    zzwjVar2.zzb(false);
                }
            }
        } else if (z2) {
            j = zzj(j);
            while (i8 < zzwkVarArr.length) {
                if (zzwkVarArr[i8] != null) {
                    zArr2[i8] = true;
                }
                i8++;
            }
        }
        this.zzF = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z2) {
        if (this.zzz) {
            return;
        }
        zzaa();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzA.zzc;
        int length = this.zzu.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.zzu[i2].zzr(j, false, zArr[i2]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        if (this.zzH) {
            this.zzH = false;
        } else {
            if (!this.zzG) {
                return -9223372036854775807L;
            }
            if (!this.zzO && zzX() <= this.zzN) {
                return -9223372036854775807L;
            }
            this.zzG = false;
        }
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzY;
        zzaa();
        if (this.zzO || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzL;
        }
        if (this.zzy) {
            int length = this.zzu.length;
            jZzY = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                zzvx zzvxVar = this.zzA;
                if (zzvxVar.zzb[i2] && zzvxVar.zzc[i2] && !this.zzu[i2].zzk()) {
                    jZzY = Math.min(jZzY, this.zzu[i2].zzj());
                }
            }
        } else {
            jZzY = Long.MAX_VALUE;
        }
        if (jZzY == LocationRequestCompat.PASSIVE_INTERVAL) {
            jZzY = zzY(false);
        }
        return jZzY == Long.MIN_VALUE ? this.zzK : jZzY;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    @Override // com.google.android.gms.internal.ads.zzus
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzj(long r9) {
        /*
            r8 = this;
            r8.zzaa()
            com.google.android.gms.internal.ads.zzvx r0 = r8.zzA
            boolean[] r0 = r0.zzb
            com.google.android.gms.internal.ads.zzaed r1 = r8.zzB
            boolean r1 = r1.zzb()
            r2 = 1
            if (r2 == r1) goto L12
            r9 = 0
        L12:
            r1 = 0
            r8.zzG = r1
            long r2 = r8.zzK
            r8.zzK = r9
            boolean r4 = r8.zzZ()
            if (r4 == 0) goto L22
            r8.zzL = r9
            return r9
        L22:
            int r4 = r8.zzE
            r5 = 7
            if (r4 == r5) goto L69
            boolean r4 = r8.zzO
            if (r4 != 0) goto L33
            com.google.android.gms.internal.ads.zzzn r4 = r8.zzm
            boolean r4 = r4.zze()
            if (r4 == 0) goto L69
        L33:
            com.google.android.gms.internal.ads.zzwj[] r4 = r8.zzu
            int r4 = r4.length
            r5 = r1
        L37:
            if (r5 >= r4) goto L9b
            com.google.android.gms.internal.ads.zzwj[] r6 = r8.zzu
            r6 = r6[r5]
            int r7 = r6.zzh()
            if (r7 != 0) goto L48
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 != 0) goto L48
            goto L66
        L48:
            boolean r7 = r8.zzz
            if (r7 == 0) goto L55
            int r7 = r6.zzg()
            boolean r6 = r6.zzn(r7)
            goto L5b
        L55:
            boolean r7 = r8.zzO
            boolean r6 = r6.zzo(r9, r7)
        L5b:
            if (r6 != 0) goto L66
            boolean r6 = r0[r5]
            if (r6 != 0) goto L69
            boolean r6 = r8.zzy
            if (r6 != 0) goto L66
            goto L69
        L66:
            int r5 = r5 + 1
            goto L37
        L69:
            r8.zzM = r1
            r8.zzL = r9
            r8.zzO = r1
            r8.zzH = r1
            com.google.android.gms.internal.ads.zzzn r0 = r8.zzm
            boolean r2 = r0.zze()
            if (r2 == 0) goto L8a
            com.google.android.gms.internal.ads.zzwj[] r2 = r8.zzu
            int r3 = r2.length
        L7c:
            if (r1 >= r3) goto L86
            r4 = r2[r1]
            r4.zzs()
            int r1 = r1 + 1
            goto L7c
        L86:
            r0.zzf()
            return r9
        L8a:
            r0.zzc()
            com.google.android.gms.internal.ads.zzwj[] r0 = r8.zzu
            int r2 = r0.length
            r3 = r1
        L91:
            if (r3 >= r2) goto L9b
            r4 = r0[r3]
            r4.zzb(r1)
            int r3 = r3 + 1
            goto L91
        L9b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzj(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzus
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzk(long r28, com.google.android.gms.internal.ads.zzlv r30) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzk(long, com.google.android.gms.internal.ads.zzlv):long");
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        if (this.zzO) {
            return false;
        }
        zzzn zzznVar = this.zzm;
        if (zzznVar.zzb() || this.zzM) {
            return false;
        }
        if (this.zzx && this.zzI == 0) {
            return false;
        }
        boolean zZza = this.zzo.zza();
        if (zzznVar.zze()) {
            return zZza;
        }
        zzW();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zzm.zze() && this.zzo.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzo() {
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zza();
        }
        this.zzn.zzb();
    }

    public final boolean zzp(int i2) {
        return !zzT() && this.zzu[i2].zzl(this.zzO);
    }

    public final void zzq(int i2) throws IOException {
        this.zzu[i2].zzf();
        zzr();
    }

    public final void zzr() throws IOException {
        this.zzm.zzh(zzze.zza(this.zzE));
    }

    public final int zzs(int i2, zzkj zzkjVar, zzhh zzhhVar, int i8) {
        if (zzT()) {
            return -3;
        }
        zzR(i2);
        int iZzm = this.zzu[i2].zzm(zzkjVar, zzhhVar, i8, this.zzO);
        if (iZzm == -3) {
            zzS(i2);
        }
        return iZzm;
    }

    public final int zzt(int i2, long j) {
        if (zzT()) {
            return 0;
        }
        zzR(i2);
        zzwj zzwjVar = this.zzu[i2];
        int iZzp = zzwjVar.zzp(j, this.zzO);
        zzwjVar.zzq(iZzp);
        if (iZzp != 0) {
            return iZzp;
        }
        zzS(i2);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i2, int i8) {
        return zzU(new zzvw(i2, false));
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzw = true;
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(final zzaed zzaedVar) {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzF(zzaedVar);
            }
        });
    }

    public final zzaem zzx() {
        return zzU(new zzvw(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void zzy(zzv zzvVar) {
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ zzzh zzz(zzzj zzzjVar, long j, long j3, IOException iOException, int i2) {
        long jMin;
        zzzh zzzhVarZza;
        zzaed zzaedVar;
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j3, zzgyVarZzf.zzf());
        zzvpVar.zzg();
        String str = zzep.zza;
        if ((iOException instanceof zzat) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgp) || (iOException instanceof zzzm)) {
            jMin = -9223372036854775807L;
            break;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzgc) && ((zzgc) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i2 - 1) * 1000, 5000);
        if (jMin == -9223372036854775807L) {
            zzzhVarZza = zzzn.zzb;
        } else {
            int iZzX = zzX();
            boolean z2 = iZzX > this.zzN;
            if (this.zzJ || !((zzaedVar = this.zzB) == null || zzaedVar.zza() == -9223372036854775807L)) {
                this.zzN = iZzX;
            } else {
                boolean z7 = this.zzx;
                if (!z7 || zzT()) {
                    this.zzG = z7;
                    this.zzK = 0L;
                    this.zzN = 0;
                    for (zzwj zzwjVar : this.zzu) {
                        zzwjVar.zzb(false);
                    }
                    zzvpVar.zzd(0L, 0L);
                } else {
                    this.zzM = true;
                    zzzhVarZza = zzzn.zza;
                }
            }
            zzzhVarZza = zzzn.zza(z2, jMin);
        }
        boolean zZza = zzzhVarZza.zza();
        this.zzg.zzg(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), iOException, !zZza);
        if (!zZza) {
            zzvpVar.zze();
        }
        return zzzhVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
    }
}
