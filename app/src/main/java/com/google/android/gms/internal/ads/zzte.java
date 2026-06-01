package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzte extends zzhr {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};

    @Nullable
    private ArrayDeque zzA;

    @Nullable
    private zztb zzB;

    @Nullable
    private zzsy zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private long zzJ;
    private boolean zzK;
    private long zzL;
    private int zzM;
    private int zzN;

    @Nullable
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzhs zza;
    private boolean zzaa;
    private long zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private zztd zzaf;
    private long zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private long zzak;
    private final zzst zzc;
    private final zztg zzd;
    private final float zze;
    private final zzhh zzf;
    private final zzhh zzg;
    private final zzhh zzh;
    private final zzsm zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrm zzl;

    @Nullable
    private zzv zzm;
    private zzv zzn;

    @Nullable
    private zzrs zzo;

    @Nullable
    private zzrs zzp;
    private zzlm zzq;

    @Nullable
    private MediaCrypto zzr;
    private long zzs;
    private float zzt;
    private float zzu;

    @Nullable
    private zzsv zzv;

    @Nullable
    private zzv zzw;

    @Nullable
    private MediaFormat zzx;
    private boolean zzy;
    private float zzz;

    public zzte(int i2, zzst zzstVar, zztg zztgVar, boolean z2, float f4) {
        super(i2);
        this.zzc = zzstVar;
        zztgVar.getClass();
        this.zzd = zztgVar;
        this.zze = f4;
        this.zzf = new zzhh(0, 0);
        this.zzg = new zzhh(0, 0);
        this.zzh = new zzhh(2, 0);
        zzsm zzsmVar = new zzsm();
        this.zzi = zzsmVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzt = 1.0f;
        this.zzu = 1.0f;
        this.zzs = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzaf = zztd.zza;
        zzsmVar.zzj(0);
        zzsmVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrm();
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzV = 0;
        this.zzM = -1;
        this.zzN = -1;
        this.zzL = -9223372036854775807L;
        this.zzab = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        this.zzJ = -9223372036854775807L;
        this.zzW = 0;
        this.zzX = 0;
        this.zza = new zzhs();
        this.zzaj = false;
        this.zzak = 0L;
    }

    private final void zzao() {
        this.zzR = false;
        zzat();
    }

    private final void zzat() {
        zzaw();
        this.zzT = false;
        this.zzi.zza();
        this.zzh.zza();
        this.zzS = false;
        this.zzl.zzb();
    }

    private final boolean zzau() {
        if (this.zzv == null) {
            return false;
        }
        if (zzaK()) {
            zzaI();
            return true;
        }
        if (zzaL()) {
            zzav();
            return false;
        }
        this.zzaj = true;
        return false;
    }

    private final void zzav() {
        try {
            zzsv zzsvVar = this.zzv;
            if (zzsvVar == null) {
                throw null;
            }
            zzsvVar.zzj();
        } finally {
            zzaN();
        }
    }

    private final void zzaw() {
        this.zzab = -9223372036854775807L;
        this.zzaf.zzf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
    }

    private final boolean zzax(int i2) throws zzib {
        zzkj zzkjVarZzH = zzH();
        zzhh zzhhVar = this.zzf;
        zzhhVar.zza();
        int iZzO = zzO(zzkjVarZzH, zzhhVar, i2 | 4);
        if (iZzO == -5) {
            zzam(zzkjVarZzH);
            return true;
        }
        if (iZzO != -4 || !zzhhVar.zzb()) {
            return false;
        }
        this.zzac = true;
        zzbl();
        return false;
    }

    private final boolean zzay(long j) {
        return this.zzs == -9223372036854775807L || zzL().zzb() - j < this.zzs;
    }

    public static boolean zzbd(zzv zzvVar) {
        return zzvVar.zzN == 0;
    }

    private final boolean zzbf() {
        return this.zzN >= 0;
    }

    private final void zzbg() {
        this.zzM = -1;
        this.zzg.zzc = null;
    }

    private final void zzbh() {
        this.zzN = -1;
        this.zzO = null;
    }

    private final boolean zzbi(@Nullable zzv zzvVar) throws zzib {
        if (this.zzv != null && this.zzX != 3 && zze() != 0) {
            float f4 = this.zzu;
            zzvVar.getClass();
            float fZzai = zzai(f4, zzvVar, zzI());
            float f8 = this.zzz;
            if (f8 != fZzai) {
                if (fZzai == -1.0f) {
                    zzbk();
                    return false;
                }
                if (f8 != -1.0f || fZzai > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzai);
                    zzsv zzsvVar = this.zzv;
                    zzsvVar.getClass();
                    zzsvVar.zzo(bundle);
                    this.zzz = fZzai;
                }
            }
        }
        return true;
    }

    private final boolean zzbj() throws zzib {
        if (this.zzY) {
            this.zzW = 1;
            if (this.zzF) {
                this.zzX = 3;
                return false;
            }
            this.zzX = 2;
        } else {
            zzbo();
        }
        return true;
    }

    private final void zzbk() throws zzib {
        if (this.zzY) {
            this.zzW = 1;
            this.zzX = 3;
        } else {
            zzaI();
            zzaA();
        }
    }

    private final void zzbl() throws zzib {
        int i2 = this.zzX;
        if (i2 == 1) {
            zzav();
            return;
        }
        if (i2 == 2) {
            zzav();
            zzbo();
        } else if (i2 != 3) {
            this.zzad = true;
            zzar();
        } else {
            zzaI();
            zzaA();
        }
    }

    private final void zzbm(zztd zztdVar) {
        this.zzaf = zztdVar;
        if (zztdVar.zzd != -9223372036854775807L) {
            this.zzah = true;
        }
    }

    private final zztd zzbn() {
        ArrayDeque arrayDeque = this.zzk;
        return !arrayDeque.isEmpty() ? (zztd) arrayDeque.getLast() : this.zzaf;
    }

    private final void zzbo() throws zzib {
        zzrs zzrsVar = this.zzp;
        zzrsVar.getClass();
        this.zzo = zzrsVar;
        this.zzW = 0;
        this.zzX = 0;
    }

    private final boolean zzbp(long j, long j3) {
        if (j3 >= j) {
            return false;
        }
        zzv zzvVar = this.zzn;
        return (zzvVar != null && Objects.equals(zzvVar.zzo, "audio/opus") && zzadz.zzf(j, j3)) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public void zzA(long j, boolean z2, boolean z7) throws zzib {
        if (z7) {
            this.zzac = false;
            this.zzad = false;
            if (this.zzR) {
                zzat();
            } else {
                zzaJ();
            }
            zzel zzelVar = this.zzaf.zze;
            if (zzelVar.zzc() > 0) {
                this.zzae = true;
            }
            zzelVar.zzb();
            this.zzk.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public void zzD() {
        this.zzm = null;
        zzbm(zztd.zza);
        this.zzk.clear();
        if (this.zzR) {
            zzao();
        } else {
            zzau();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public void zzE() {
        try {
            zzao();
            zzaI();
        } finally {
            this.zzp = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final long zzT(long j, long j3) {
        return zzah(j, j3, this.zzK);
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public void zzV(float f4, float f8) throws zzib {
        this.zzt = f4;
        this.zzu = f8;
        zzbi(this.zzw);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:128|129|(12:392|131|(2:133|(2:135|(6:137|(1:146)(1:143)|144|145|227|(2:402|229)(1:230))(2:396|147))(6:395|148|(1:154)|155|(1:159)|160))(2:162|(4:164|145|227|(0)(0))(2:167|(7:172|(1:174)|175|(1:181)|(1:183)(2:184|(0))|188|(1:190)(2:398|191))(2:397|171)))|358|(2:361|(1:379))|365|(1:370)(1:369)|(1:372)|373|(1:375)(1:376)|377|378)(1:192)|193|(1:197)(1:198)|199|(1:204)(1:203)|205|206|383|207|(3:209|210|(5:212|(1:214)(1:215)|(1:221)|222|(2:401|224)(3:226|227|(0)(0)))(1:400))(3:399|349|350)) */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x026a, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x035d, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0372, code lost:
    
        r4 = r21.zzv;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0374, code lost:
    
        if (r4 == null) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0379, code lost:
    
        if (r21.zzW == 2) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x037d, code lost:
    
        if (r21.zzac == false) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0385, code lost:
    
        if (r21.zzM >= 0) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0387, code lost:
    
        r0 = r4.zze();
        r21.zzM = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x038d, code lost:
    
        if (r0 < 0) goto L416;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x038f, code lost:
    
        r5 = r21.zzg;
        r5.zzc = r4.zzh(r0);
        r5.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x039c, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x039d, code lost:
    
        if (r21.zzW != 1) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x03a1, code lost:
    
        if (r21.zzI != false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03a3, code lost:
    
        r21.zzZ = true;
        r4.zza(r21.zzM, 0, 0, 0, 4);
        zzbg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x03b4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x03b7, code lost:
    
        r21.zzW = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x03be, code lost:
    
        if (r21.zzG == false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x03c1, code lost:
    
        r21.zzG = false;
        r0 = r21.zzg.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x03c7, code lost:
    
        if (r0 == null) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x03c9, code lost:
    
        r0.put(com.google.android.gms.internal.ads.zzte.zzb);
        r4.zza(r21.zzM, 0, 38, 0, 0);
        zzbg();
        r21.zzY = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x03e6, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x03ea, code lost:
    
        if (r21.zzV != 1) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x03ec, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x03ed, code lost:
    
        r5 = r21.zzw;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x03ef, code lost:
    
        if (r5 == null) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x03f7, code lost:
    
        if (r0 >= r5.zzr.size()) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x03f9, code lost:
    
        r5 = (byte[]) r21.zzw.zzr.get(r0);
        r6 = r21.zzg.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0407, code lost:
    
        if (r6 == null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0409, code lost:
    
        r6.put(r5);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x040f, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0410, code lost:
    
        r21.zzV = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0413, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0414, code lost:
    
        r0 = r21.zzg;
        r5 = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0418, code lost:
    
        if (r5 == null) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x041a, code lost:
    
        r5 = r5.position();
        r6 = zzH();
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0422, code lost:
    
        r0 = zzO(r6, r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0427, code lost:
    
        if (r0 != (-3)) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x042d, code lost:
    
        if (zzdb() == false) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x042f, code lost:
    
        zzbn().zzf = r21.zzab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x043a, code lost:
    
        if (r0 != (-5)) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x043e, code lost:
    
        if (r21.zzV != 2) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0440, code lost:
    
        r21.zzg.zza();
        r21.zzV = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0447, code lost:
    
        zzam(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x044c, code lost:
    
        r0 = r21.zzg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0452, code lost:
    
        if (r0.zzb() == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0454, code lost:
    
        zzbn().zzf = r21.zzab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x045e, code lost:
    
        if (r21.zzV != 2) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0460, code lost:
    
        r0.zza();
        r21.zzV = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0465, code lost:
    
        r21.zzac = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0469, code lost:
    
        if (r21.zzY != false) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x046b, code lost:
    
        zzbl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0472, code lost:
    
        if (r21.zzI != false) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0474, code lost:
    
        r21.zzZ = true;
        r4.zza(r21.zzM, 0, 0, 0, 4);
        zzbg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0488, code lost:
    
        if (r21.zzY != false) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x048e, code lost:
    
        if (r0.zzc() != false) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0490, code lost:
    
        r0.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0495, code lost:
    
        if (r21.zzV != 2) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0497, code lost:
    
        r21.zzV = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x049f, code lost:
    
        if (zzaT(r0) != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x04a1, code lost:
    
        r6 = r0.zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x04a5, code lost:
    
        if (r6 == false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x04a7, code lost:
    
        r0.zzb.zzc(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x04ac, code lost:
    
        r7 = r0.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x04b0, code lost:
    
        if (r21.zzae == false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x04b2, code lost:
    
        r5 = zzbn().zze;
        r9 = r21.zzm;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x04ba, code lost:
    
        if (r9 == null) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x04bc, code lost:
    
        r5.zza(r7, r9);
        r21.zzae = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x04c2, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x04c3, code lost:
    
        r21.zzab = java.lang.Math.max(r21.zzab, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x04cf, code lost:
    
        if (zzdb() != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x04d5, code lost:
    
        if (r0.zzd() == false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x04d7, code lost:
    
        zzbn().zzf = r21.zzab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x04df, code lost:
    
        r0.zzl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x04e6, code lost:
    
        if (r0.zze() == false) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x04e8, code lost:
    
        zzas(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x04ed, code lost:
    
        if (r21.zzaj == false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x04ef, code lost:
    
        r9 = r21.zzab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x04f3, code lost:
    
        if (r7 > r9) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x04f5, code lost:
    
        r21.zzak = ((r9 - r7) + 1) + r21.zzak;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x04ff, code lost:
    
        r21.zzab = r7;
        r21.zzaj = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0503, code lost:
    
        zzaR(r0);
        r10 = zzaS(r0);
        r7 = r7 + r21.zzak;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x050d, code lost:
    
        if (r6 == false) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x050f, code lost:
    
        r4.zzb(r21.zzM, 0, r0.zzb, r7, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0519, code lost:
    
        r5 = r21.zzM;
        r0 = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x051e, code lost:
    
        if (r0 == null) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0520, code lost:
    
        r4.zza(r5, 0, r0.limit(), r7, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0528, code lost:
    
        zzbg();
        r21.zzY = true;
        r21.zzV = 0;
        r21.zza.zzc++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0537, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0538, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0539, code lost:
    
        zzal(r0);
        zzax(0);
        zzav();
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x054a, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0553, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0554, code lost:
    
        r12 = r5;
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0369 A[LOOP:0: B:126:0x01fa->B:230:0x0369, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzte] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.google.android.gms.internal.ads.zzln
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzX(long r22, long r24) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 1483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzte.zzX(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public boolean zzY() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public boolean zzZ() {
        return this.zzad;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ed A[Catch: Exception -> 0x0106, TryCatch #4 {Exception -> 0x0106, blocks: (B:57:0x00dd, B:59:0x00e7, B:61:0x00f8, B:67:0x0138, B:69:0x0149, B:71:0x0177, B:73:0x0180, B:75:0x0188, B:77:0x0192, B:79:0x019a, B:81:0x01a2, B:101:0x01e7, B:103:0x01ed, B:107:0x01f9, B:109:0x01ff, B:113:0x020b, B:115:0x0211, B:140:0x0269, B:142:0x026f, B:144:0x0275, B:145:0x0283, B:120:0x021f, B:122:0x0227, B:124:0x022f, B:126:0x0237, B:128:0x023f, B:130:0x0247, B:132:0x024f, B:134:0x0259, B:136:0x0263, B:86:0x01b0, B:88:0x01b8, B:92:0x01c3, B:94:0x01cd, B:96:0x01d5, B:98:0x01dd), top: B:188:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x026f A[Catch: Exception -> 0x0106, TryCatch #4 {Exception -> 0x0106, blocks: (B:57:0x00dd, B:59:0x00e7, B:61:0x00f8, B:67:0x0138, B:69:0x0149, B:71:0x0177, B:73:0x0180, B:75:0x0188, B:77:0x0192, B:79:0x019a, B:81:0x01a2, B:101:0x01e7, B:103:0x01ed, B:107:0x01f9, B:109:0x01ff, B:113:0x020b, B:115:0x0211, B:140:0x0269, B:142:0x026f, B:144:0x0275, B:145:0x0283, B:120:0x021f, B:122:0x0227, B:124:0x022f, B:126:0x0237, B:128:0x023f, B:130:0x0247, B:132:0x024f, B:134:0x0259, B:136:0x0263, B:86:0x01b0, B:88:0x01b8, B:92:0x01c3, B:94:0x01cd, B:96:0x01d5, B:98:0x01dd), top: B:188:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02cb A[Catch: zztb -> 0x0084, TryCatch #5 {zztb -> 0x0084, blocks: (B:25:0x0057, B:27:0x005e, B:29:0x0062, B:31:0x0078, B:36:0x0089, B:40:0x0095, B:42:0x009d, B:44:0x00a1, B:46:0x00a5, B:48:0x00ae, B:160:0x02b2, B:162:0x02cb, B:164:0x02d4, B:167:0x02db, B:168:0x02dd, B:163:0x02ce, B:170:0x02df, B:171:0x02e0, B:173:0x02e5, B:174:0x02e6, B:175:0x02f0, B:38:0x008c, B:39:0x0094, B:177:0x02f3), top: B:190:0x0057, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ce A[Catch: zztb -> 0x0084, TryCatch #5 {zztb -> 0x0084, blocks: (B:25:0x0057, B:27:0x005e, B:29:0x0062, B:31:0x0078, B:36:0x0089, B:40:0x0095, B:42:0x009d, B:44:0x00a1, B:46:0x00a5, B:48:0x00ae, B:160:0x02b2, B:162:0x02cb, B:164:0x02d4, B:167:0x02db, B:168:0x02dd, B:163:0x02ce, B:170:0x02df, B:171:0x02e0, B:173:0x02e5, B:174:0x02e6, B:175:0x02f0, B:38:0x008c, B:39:0x0094, B:177:0x02f3), top: B:190:0x0057, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x029d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c1  */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.google.android.gms.internal.ads.zzst] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v54, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.gms.internal.ads.zzsy] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.ads.zzss] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzte] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzaA() throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 765
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzte.zzaA():void");
    }

    public final boolean zzaB(zzv zzvVar) {
        return this.zzp == null && zzae(zzvVar);
    }

    public boolean zzaC(zzsy zzsyVar) {
        return true;
    }

    public final boolean zzaD() {
        return this.zzR;
    }

    @Nullable
    public final zzsv zzaE() {
        return this.zzv;
    }

    @Nullable
    public final zzv zzaF() {
        return this.zzw;
    }

    @Nullable
    public final MediaFormat zzaG() {
        return this.zzx;
    }

    @Nullable
    public final zzsy zzaH() {
        return this.zzC;
    }

    public final void zzaI() {
        try {
            zzsv zzsvVar = this.zzv;
            if (zzsvVar != null) {
                zzsvVar.zzk();
                this.zza.zzb++;
                zzsy zzsyVar = this.zzC;
                if (zzsyVar == null) {
                    throw null;
                }
                zzak(zzsyVar.zza);
            }
            this.zzv = null;
            this.zzr = null;
            this.zzo = null;
            zzaO();
        } catch (Throwable th) {
            this.zzv = null;
            this.zzr = null;
            this.zzo = null;
            zzaO();
            throw th;
        }
    }

    public final boolean zzaJ() throws zzib {
        boolean zZzau = zzau();
        if (zZzau) {
            zzaA();
        }
        return zZzau;
    }

    public boolean zzaK() {
        int i2 = this.zzX;
        if (i2 == 3 || ((this.zzE && !this.zzaa) || (this.zzF && this.zzZ))) {
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        try {
            zzbo();
            return false;
        } catch (zzib e) {
            zzdt.zzd("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    public boolean zzaL() {
        return true;
    }

    public final long zzaM() {
        return this.zzak;
    }

    @CallSuper
    public void zzaN() {
        zzbg();
        zzbh();
        zzaw();
        this.zzL = -9223372036854775807L;
        this.zzZ = false;
        this.zzJ = -9223372036854775807L;
        this.zzY = false;
        this.zzG = false;
        this.zzH = false;
        this.zzP = false;
        this.zzQ = false;
        this.zzW = 0;
        this.zzX = 0;
        this.zzV = this.zzU ? 1 : 0;
        this.zzaj = false;
        this.zzak = 0L;
    }

    @CallSuper
    public final void zzaO() {
        zzaN();
        this.zzA = null;
        this.zzC = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = false;
        this.zzaa = false;
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = false;
        this.zzI = false;
        this.zzK = false;
        this.zzU = false;
        this.zzV = 0;
    }

    public zzsx zzaP(Throwable th, @Nullable zzsy zzsyVar) {
        return new zzsx(th, zzsyVar);
    }

    public boolean zzaQ(zzv zzvVar) throws zzib {
        return true;
    }

    public int zzaS(zzhh zzhhVar) {
        return 0;
    }

    public boolean zzaT(zzhh zzhhVar) {
        return false;
    }

    public final long zzaU() {
        return this.zzag;
    }

    @CallSuper
    public void zzaV(long j) {
        this.zzag = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || j < ((zztd) arrayDeque.peek()).zzb) {
                return;
            }
            zztd zztdVar = (zztd) arrayDeque.poll();
            zztdVar.getClass();
            zzbm(zztdVar);
            zzap();
        }
    }

    public final boolean zzaW() {
        if (this.zzm == null) {
            return false;
        }
        if (zzQ() || zzbf()) {
            return true;
        }
        return this.zzL != -9223372036854775807L && zzL().zzb() < this.zzL;
    }

    public final float zzaX() {
        return this.zzt;
    }

    @Nullable
    public final zzlm zzaY() {
        return this.zzq;
    }

    public final boolean zzaZ() throws zzib {
        return zzbi(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final int zzab(zzv zzvVar) throws zzib {
        try {
            return zzac(this.zzd, zzvVar);
        } catch (zzti e) {
            throw zzN(e, zzvVar, false, 4002);
        }
    }

    public abstract int zzac(zztg zztgVar, zzv zzvVar) throws zzti;

    public abstract List zzad(zztg zztgVar, zzv zzvVar, boolean z2) throws zzti;

    public boolean zzae(zzv zzvVar) {
        return false;
    }

    public abstract zzss zzaf(zzsy zzsyVar, zzv zzvVar, @Nullable MediaCrypto mediaCrypto, float f4);

    public zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        throw null;
    }

    public long zzah(long j, long j3, boolean z2) {
        return g0.a(this, j, j3);
    }

    public float zzai(float f4, zzv zzvVar, zzv[] zzvVarArr) {
        throw null;
    }

    public void zzaj(String str, zzss zzssVar, long j, long j3) {
        throw null;
    }

    public void zzak(String str) {
        throw null;
    }

    public void zzal(Exception exc) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    @androidx.annotation.Nullable
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.ads.zzht zzam(com.google.android.gms.internal.ads.zzkj r14) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzte.zzam(com.google.android.gms.internal.ads.zzkj):com.google.android.gms.internal.ads.zzht");
    }

    public void zzan(zzv zzvVar, @Nullable MediaFormat mediaFormat) throws zzib {
        throw null;
    }

    public abstract boolean zzaq(long j, long j3, @Nullable zzsv zzsvVar, @Nullable ByteBuffer byteBuffer, int i2, int i8, int i9, long j8, boolean z2, boolean z7, zzv zzvVar) throws zzib;

    public void zzar() throws zzib {
        throw null;
    }

    public void zzas(zzhh zzhhVar) throws zzib {
        throw null;
    }

    public final void zzaz() {
        this.zzai = true;
    }

    public final long zzba() {
        return this.zzaf.zzf;
    }

    public final long zzbb() {
        return this.zzaf.zzd;
    }

    public final long zzbc() {
        return this.zzaf.zzc;
    }

    public final /* synthetic */ zzlm zzbe() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzlp
    public final int zzu() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public void zzx(int i2, @Nullable Object obj) throws zzib {
        if (i2 == 11) {
            zzlm zzlmVar = (zzlm) obj;
            zzlmVar.getClass();
            this.zzq = zzlmVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public void zzy(boolean z2, boolean z7) throws zzib {
        this.zza = new zzhs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzhr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzz(com.google.android.gms.internal.ads.zzv[] r12, long r13, long r15, com.google.android.gms.internal.ads.zzuu r17) throws com.google.android.gms.internal.ads.zzib {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zztd r12 = r11.zzaf
            long r0 = r12.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            com.google.android.gms.internal.ads.zztd r4 = new com.google.android.gms.internal.ads.zztd
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbm(r4)
            boolean r12 = r11.zzai
            if (r12 == 0) goto L56
            r11.zzap()
            return
        L24:
            java.util.ArrayDeque r12 = r11.zzk
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.zzab
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.zzag
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            com.google.android.gms.internal.ads.zztd r4 = new com.google.android.gms.internal.ads.zztd
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbm(r4)
            com.google.android.gms.internal.ads.zztd r12 = r11.zzaf
            long r12 = r12.zzd
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.zzap()
        L56:
            return
        L57:
            com.google.android.gms.internal.ads.zztd r0 = new com.google.android.gms.internal.ads.zztd
            long r1 = r11.zzab
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzte.zzz(com.google.android.gms.internal.ads.zzv[], long, long, com.google.android.gms.internal.ads.zzuu):void");
    }

    public void zzap() {
    }

    public void zzaR(zzhh zzhhVar) throws zzib {
    }
}
