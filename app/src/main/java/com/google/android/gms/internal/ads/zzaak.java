package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.ads.AdError;
import com.google.android.gms.common.Scopes;
import com.onesignal.core.internal.config.InfluenceConfigModel;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaak extends zzte implements zzaaz {
    private static final int[] zzb = {1920, 1600, InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private int zzB;
    private int zzC;

    @Nullable
    private zzlu zzD;
    private boolean zzE;
    private long zzF;
    private int zzG;
    private long zzH;
    private zzbv zzI;

    @Nullable
    private zzbv zzJ;
    private int zzK;
    private int zzL;

    @Nullable
    private zzaax zzM;
    private long zzN;
    private long zzO;
    private boolean zzP;
    private final Context zze;
    private final boolean zzf;
    private final zzabr zzg;
    private final boolean zzh;
    private final zzaba zzi;
    private final zzaay zzj;
    private final long zzk;
    private final PriorityQueue zzl;
    private zzaaj zzm;
    private boolean zzn;
    private boolean zzo;
    private zzabx zzp;
    private boolean zzq;
    private int zzr;
    private List zzs;

    @Nullable
    private Surface zzt;

    @Nullable
    private zzaam zzu;
    private zzeh zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private long zzz;

    public zzaak(zzaai zzaaiVar) {
        super(2, zzaaiVar.zzg(), zzaaiVar.zzf(), false, 30.0f);
        Context applicationContext = zzaaiVar.zze().getApplicationContext();
        this.zze = applicationContext;
        this.zzp = null;
        this.zzg = new zzabr(zzaaiVar.zzh(), zzaaiVar.zzi());
        this.zzf = this.zzp == null;
        this.zzi = new zzaba(applicationContext, this, 0L);
        this.zzj = new zzaay();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzv = zzeh.zza;
        this.zzx = 1;
        this.zzy = 0;
        this.zzI = zzbv.zza;
        this.zzL = 0;
        this.zzJ = null;
        this.zzK = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        this.zzN = -9223372036854775807L;
        this.zzO = -9223372036854775807L;
        this.zzl = new PriorityQueue();
        this.zzk = -9223372036854775807L;
        this.zzD = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r3.equals("video/x-vnd.on2.vp8") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
    
        if (r3.equals("video/mp4v-es") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bc, code lost:
    
        if (r3.equals(com.unity3d.services.core.device.MimeTypes.VIDEO_AV1) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c5, code lost:
    
        if (r3.equals("video/3gpp") != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzat(com.google.android.gms.internal.ads.zzsy r8, com.google.android.gms.internal.ads.zzv r9) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzat(com.google.android.gms.internal.ads.zzsy, com.google.android.gms.internal.ads.zzv):int");
    }

    public static int zzbg(zzsy zzsyVar, zzv zzvVar) {
        int i2 = zzvVar.zzp;
        if (i2 == -1) {
            return zzat(zzsyVar, zzvVar);
        }
        List list = zzvVar.zzr;
        int size = list.size();
        int length = 0;
        for (int i8 = 0; i8 < size; i8++) {
            length += ((byte[]) list.get(i8)).length;
        }
        return i2 + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0656 A[Catch: all -> 0x006c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0011, B:11:0x0018, B:507:0x066a, B:42:0x0073, B:45:0x007e, B:77:0x00dd, B:500:0x0656, B:508:0x066e), top: B:513:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean zzbk(java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 2286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzbk(java.lang.String):boolean");
    }

    public static final boolean zzbl(zzsy zzsyVar) {
        return Build.VERSION.SDK_INT >= 35 && zzsyVar.zzh;
    }

    private static List zzbm(Context context, zztg zztgVar, zzv zzvVar, boolean z2, boolean z7) throws zzti {
        String str = zzvVar.zzo;
        if (str == null) {
            return zzgpe.zzi();
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzaah.zza(context)) {
            List listZzd = zztq.zzd(zztgVar, zzvVar, z2, z7);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztq.zzc(zztgVar, zzvVar, z2, z7);
    }

    private final void zzbn(@Nullable Object obj) throws zzib {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzt == surface) {
            if (surface != null) {
                zzbv();
                Surface surface2 = this.zzt;
                if (surface2 == null || !this.zzw) {
                    return;
                }
                this.zzg.zzg(surface2);
                return;
            }
            return;
        }
        this.zzt = surface;
        if (this.zzp == null) {
            this.zzi.zzd(surface);
        }
        this.zzw = false;
        int iZze = zze();
        zzsv zzsvVarZzaE = zzaE();
        if (zzsvVarZzaE != null && this.zzp == null) {
            zzsy zzsyVarZzaH = zzaH();
            zzsyVarZzaH.getClass();
            if (!zzbr(zzsyVarZzaH) || this.zzn) {
                zzaI();
                zzaA();
            } else {
                Surface surfaceZzbs = zzbs(zzsyVarZzaH);
                if (surfaceZzbs != null) {
                    zzsvVarZzaE.zzm(surfaceZzbs);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzsvVarZzaE.zzn();
                }
            }
        }
        if (surface != null) {
            zzbv();
        } else {
            this.zzJ = null;
            zzabx zzabxVar = this.zzp;
            if (zzabxVar != null) {
                zzabxVar.zzq();
            }
        }
        if (iZze == 2) {
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzw(true);
            } else {
                this.zzi.zzj(true);
            }
        }
    }

    private final boolean zzbo(zzhh zzhhVar) {
        if (zzdb() || zzhhVar.zzd() || this.zzO == -9223372036854775807L) {
            return true;
        }
        return this.zzO - (zzhhVar.zze - zzbb()) <= 100000;
    }

    private final boolean zzbp(zzhh zzhhVar) {
        return zzhhVar.zze < zzG();
    }

    private final void zzbq(long j, long j3, zzv zzvVar) {
        zzaax zzaaxVar = this.zzM;
        if (zzaaxVar != null) {
            zzaaxVar.zzcS(j, j3, zzvVar, zzaG());
        }
    }

    private final boolean zzbr(zzsy zzsyVar) {
        if (this.zzp != null) {
            return true;
        }
        Surface surface = this.zzt;
        return (surface != null && surface.isValid()) || zzbl(zzsyVar) || zzbf(zzsyVar);
    }

    @Nullable
    private final Surface zzbs(zzsy zzsyVar) {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            return zzabxVar.zzk();
        }
        Surface surface = this.zzt;
        if (surface != null) {
            return surface;
        }
        if (zzbl(zzsyVar)) {
            return null;
        }
        zzgmd.zzh(zzbf(zzsyVar));
        zzaam zzaamVar = this.zzu;
        if (zzaamVar != null) {
            if (zzaamVar.zza != zzsyVar.zzf) {
                zzbt();
            }
        }
        if (this.zzu == null) {
            this.zzu = zzaam.zzb(this.zze, zzsyVar.zzf);
        }
        return this.zzu;
    }

    private final void zzbt() {
        zzaam zzaamVar = this.zzu;
        if (zzaamVar != null) {
            zzaamVar.release();
            this.zzu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    /* JADX INFO: renamed from: zzbu, reason: merged with bridge method [inline-methods] */
    public final void zzbi() {
        this.zzg.zzg(this.zzt);
        this.zzw = true;
    }

    private final void zzbv() {
        zzbv zzbvVar = this.zzJ;
        if (zzbvVar != null) {
            this.zzg.zzf(zzbvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzA(long j, boolean z2, boolean z7) throws zzib {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null && !z2) {
            zzabxVar.zzg(true);
        }
        super.zzA(j, z2, z7);
        if (this.zzp == null) {
            this.zzi.zzl();
        }
        if (z2) {
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzw(false);
            } else {
                this.zzi.zzj(false);
            }
        }
        this.zzB = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzB() {
        this.zzA = 0;
        this.zzz = zzL().zzb();
        this.zzF = 0L;
        this.zzG = 0;
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zza();
        } else {
            this.zzi.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzC() {
        if (this.zzA > 0) {
            long jZzb = zzL().zzb();
            this.zzg.zzd(this.zzA, jZzb - this.zzz);
            this.zzA = 0;
            this.zzz = jZzb;
        }
        int i2 = this.zzG;
        if (i2 != 0) {
            this.zzg.zze(this.zzF, i2);
            this.zzF = 0L;
            this.zzG = 0;
        }
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzb();
        } else {
            this.zzi.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzD() {
        this.zzJ = null;
        this.zzO = -9223372036854775807L;
        this.zzw = false;
        this.zzE = true;
        try {
            super.zzD();
        } finally {
            zzabr zzabrVar = this.zzg;
            zzabrVar.zzi(((zzte) this).zza);
            zzabrVar.zzf(zzbv.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzE() {
        try {
            super.zzE();
        } finally {
            this.zzq = false;
            this.zzN = -9223372036854775807L;
            zzbt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    public final void zzF() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || !this.zzf) {
            return;
        }
        zzabxVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final String zzS() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final boolean zzU(long j) {
        long jZzaU = zzaU();
        return jZzaU == -9223372036854775807L || j > jZzaU - zzbb();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final void zzV(float f4, float f8) throws zzib {
        super.zzV(f4, f8);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzm(f4);
        } else {
            this.zzi.zzn(f4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final void zzW() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null) {
            this.zzi.zzh();
            return;
        }
        int i2 = this.zzr;
        if (i2 == 0 || i2 == 1) {
            this.zzr = 0;
        } else {
            zzabxVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    @CallSuper
    public final void zzX(long j, long j3) throws Throwable {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            try {
                zzabxVar.zzv(j, j3);
            } catch (zzabw e) {
                throw zzN(e, e.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
        super.zzX(j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzY() {
        boolean zZzaW = zzaW();
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            return zzabxVar.zzh(zZzaW);
        }
        if (zZzaW && zzaE() == null) {
            return true;
        }
        return this.zzi.zzi(zZzaW);
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzZ() {
        if (!super.zzZ()) {
            return false;
        }
        zzabx zzabxVar = this.zzp;
        return zzabxVar == null || zzabxVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzaC(zzsy zzsyVar) {
        return zzbr(zzsyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzaK() {
        zzsy zzsyVarZzaH = zzaH();
        if (this.zzp != null && zzsyVarZzaH != null) {
            String str = zzsyVarZzaH.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaK();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a  */
    @Override // com.google.android.gms.internal.ads.zzte
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzaL() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzv r0 = r12.zzaF()
            long r1 = r12.zzO
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L2a
            r8 = 1
            long r1 = r1 + r8
            long r8 = r12.zzbb()
            long r10 = r12.zzO
            long r8 = r8 + r10
            long r10 = r12.zzaM()
            long r10 = r10 + r1
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r1 = r1 - r8
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 <= 0) goto L2c
        L2a:
            r1 = r7
            goto L2d
        L2c:
            r1 = r6
        L2d:
            com.google.android.gms.internal.ads.zzlu r2 = r12.zzD
            if (r2 != 0) goto L32
            goto L47
        L32:
            boolean r2 = r12.zzE
            if (r2 != 0) goto L47
            if (r0 == 0) goto L3c
            int r0 = r0.zzq
            if (r0 > 0) goto L47
        L3c:
            if (r1 != 0) goto L47
            long r0 = r12.zzba()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L47
            return r6
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzaL():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @CallSuper
    public final void zzaN() {
        super.zzaN();
        this.zzl.clear();
        this.zzC = 0;
        this.zzE = false;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final zzsx zzaP(Throwable th, @Nullable zzsy zzsyVar) {
        return new zzaae(th, zzsyVar, this.zzt);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @CallSuper
    public final boolean zzaQ(zzv zzvVar) throws zzib {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || zzabxVar.zze()) {
            return true;
        }
        try {
            zzabxVar.zzd(zzvVar);
            return true;
        } catch (zzabw e) {
            throw zzN(e, zzvVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @CallSuper
    public final void zzaR(zzhh zzhhVar) throws zzib {
        int iZzaS = zzaS(zzhhVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzaS & 32) == 0) {
            this.zzC++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final int zzaS(zzhh zzhhVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzD == null || !zzbp(zzhhVar) || zzbo(zzhhVar)) ? 0 : 32;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzaT(zzhh zzhhVar) {
        boolean z2 = false;
        if (zzbo(zzhhVar)) {
            return false;
        }
        if (zzbp(zzhhVar)) {
            if (zzhhVar.zze()) {
                return false;
            }
            if (zzhhVar.zzf()) {
                zzhhVar.zza();
                z2 = true;
            }
            if (z2) {
                ((zzte) this).zza.zzd++;
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @CallSuper
    public final void zzaV(long j) {
        super.zzaV(j);
        this.zzC--;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final int zzac(zztg zztgVar, zzv zzvVar) throws zzti {
        boolean z2;
        String str = zzvVar.zzo;
        if (!zzas.zzb(str)) {
            return 128;
        }
        Context context = this.zze;
        int i2 = 0;
        boolean z7 = zzvVar.zzs != null;
        List listZzbm = zzbm(context, zztgVar, zzvVar, z7, false);
        if (z7 && listZzbm.isEmpty()) {
            listZzbm = zzbm(context, zztgVar, zzvVar, false, false);
        }
        if (listZzbm.isEmpty()) {
            return Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
        }
        if (!zzte.zzbd(zzvVar)) {
            return Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
        }
        zzsy zzsyVar = (zzsy) listZzbm.get(0);
        boolean zZzc = zzsyVar.zzc(zzvVar);
        if (zZzc) {
            z2 = true;
        } else {
            for (int i8 = 1; i8 < listZzbm.size(); i8++) {
                zzsy zzsyVar2 = (zzsy) listZzbm.get(i8);
                if (zzsyVar2.zzc(zzvVar)) {
                    zZzc = true;
                    z2 = false;
                    zzsyVar = zzsyVar2;
                    break;
                }
            }
            z2 = true;
        }
        int i9 = true != zZzc ? 3 : 4;
        int i10 = true != zzsyVar.zze(zzvVar) ? 8 : 16;
        int i11 = true != zzsyVar.zzg ? 0 : 64;
        int i12 = true != z2 ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzaah.zza(context)) {
            i12 = 256;
        }
        if (zZzc) {
            List listZzbm2 = zzbm(context, zztgVar, zzvVar, z7, true);
            if (!listZzbm2.isEmpty()) {
                zzsy zzsyVar3 = (zzsy) zztq.zze(listZzbm2, zzvVar).get(0);
                if (zzsyVar3.zzc(zzvVar) && zzsyVar3.zze(zzvVar)) {
                    i2 = 32;
                }
            }
        }
        return i9 | i10 | i2 | i11 | i12;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final List zzad(zztg zztgVar, zzv zzvVar, boolean z2) throws zzti {
        return zztq.zze(zzbm(this.zze, zztgVar, zzvVar, false, false), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final zzss zzaf(zzsy zzsyVar, zzv zzvVar, @Nullable MediaCrypto mediaCrypto, float f4) {
        zzaaj zzaajVar;
        Point pointZzi;
        int i2;
        int i8;
        int i9;
        boolean z2;
        zzv[] zzvVarArr;
        byte b8;
        boolean z7;
        int iZzat;
        zzv[] zzvVarArrZzI = zzI();
        int length = zzvVarArrZzI.length;
        int iZzbg = zzbg(zzsyVar, zzvVar);
        int i10 = zzvVar.zzw;
        int i11 = zzvVar.zzv;
        if (length == 1) {
            if (iZzbg != -1 && (iZzat = zzat(zzsyVar, zzvVar)) != -1) {
                iZzbg = Math.min((int) (iZzbg * 1.5f), iZzat);
            }
            zzaajVar = new zzaaj(i11, i10, iZzbg);
        } else {
            int iMax = i10;
            int iMax2 = i11;
            int i12 = 0;
            boolean z8 = false;
            while (i12 < length) {
                zzv zzvVarZzM = zzvVarArrZzI[i12];
                zzi zziVar = zzvVar.zzE;
                if (zziVar != null && zzvVarZzM.zzE == null) {
                    zzt zztVarZza = zzvVarZzM.zza();
                    zztVarZza.zzC(zziVar);
                    zzvVarZzM = zztVarZza.zzM();
                }
                if (zzsyVar.zzf(zzvVar, zzvVarZzM).zzd != 0) {
                    int i13 = zzvVarZzM.zzv;
                    b8 = -1;
                    if (i13 != -1) {
                        zzvVarArr = zzvVarArrZzI;
                        if (zzvVarZzM.zzw != -1) {
                            z7 = false;
                        }
                        z8 |= z7;
                        iMax2 = Math.max(iMax2, i13);
                        iMax = Math.max(iMax, zzvVarZzM.zzw);
                        iZzbg = Math.max(iZzbg, zzbg(zzsyVar, zzvVarZzM));
                    } else {
                        zzvVarArr = zzvVarArrZzI;
                    }
                    z7 = true;
                    z8 |= z7;
                    iMax2 = Math.max(iMax2, i13);
                    iMax = Math.max(iMax, zzvVarZzM.zzw);
                    iZzbg = Math.max(iZzbg, zzbg(zzsyVar, zzvVarZzM));
                } else {
                    zzvVarArr = zzvVarArrZzI;
                    b8 = -1;
                }
                i12++;
                zzvVarArrZzI = zzvVarArr;
            }
            if (z8) {
                zzdt.zzc("MediaCodecVideoRenderer", a1.a.f(iMax2, iMax, "Resolutions unknown. Codec max resolution: ", "x", new StringBuilder(String.valueOf(iMax2).length() + 44 + String.valueOf(iMax).length())));
                boolean z9 = i10 > i11;
                int i14 = z9 ? i10 : i11;
                int i15 = true != z9 ? i10 : i11;
                int[] iArr = zzb;
                int i16 = 0;
                while (i16 < 9) {
                    float f8 = i15;
                    float f9 = i14;
                    int i17 = iArr[i16];
                    int i18 = i16;
                    float f10 = i17;
                    if (i17 <= i14 || (i2 = (int) (f10 * (f8 / f9))) <= i15) {
                        break;
                    }
                    int i19 = i14;
                    if (true != z9) {
                        i8 = i15;
                        i9 = i17;
                    } else {
                        i8 = i15;
                        i9 = i2;
                    }
                    if (true != z9) {
                        i17 = i2;
                    }
                    pointZzi = zzsyVar.zzi(i9, i17);
                    float f11 = zzvVar.zzz;
                    if (pointZzi != null) {
                        z2 = z9;
                        if (zzsyVar.zzg(pointZzi.x, pointZzi.y, f11)) {
                            break;
                        }
                    } else {
                        z2 = z9;
                    }
                    i16 = i18 + 1;
                    i14 = i19;
                    i15 = i8;
                    z9 = z2;
                }
                pointZzi = null;
                if (pointZzi != null) {
                    iMax2 = Math.max(iMax2, pointZzi.x);
                    iMax = Math.max(iMax, pointZzi.y);
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzt(iMax2);
                    zztVarZza2.zzu(iMax);
                    iZzbg = Math.max(iZzbg, zzat(zzsyVar, zztVarZza2.zzM()));
                    zzdt.zzc("MediaCodecVideoRenderer", a1.a.f(iMax2, iMax, "Codec max resolution adjusted to: ", "x", new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iMax2, 35) + String.valueOf(iMax).length())));
                }
            }
            zzaajVar = new zzaaj(iMax2, iMax, iZzbg);
        }
        String str = zzsyVar.zzc;
        this.zzm = zzaajVar;
        boolean z10 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i11);
        mediaFormat.setInteger("height", i10);
        zzdw.zza(mediaFormat, zzvVar.zzr);
        float f12 = zzvVar.zzz;
        if (f12 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f12);
        }
        zzdw.zzb(mediaFormat, "rotation-degrees", zzvVar.zzA);
        zzi zziVar2 = zzvVar.zzE;
        if (zziVar2 != null) {
            zzdw.zzb(mediaFormat, "color-transfer", zziVar2.zzd);
            zzdw.zzb(mediaFormat, "color-standard", zziVar2.zzb);
            zzdw.zzb(mediaFormat, "color-range", zziVar2.zzc);
            byte[] bArr = zziVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzvVar.zzo)) {
            int i20 = zztq.zza;
            Pair pairZzd = zzdd.zzd(zzvVar);
            if (pairZzd != null) {
                zzdw.zzb(mediaFormat, Scopes.PROFILE, ((Integer) pairZzd.first).intValue());
            }
        }
        mediaFormat.setInteger("max-width", zzaajVar.zza);
        mediaFormat.setInteger("max-height", zzaajVar.zzb);
        zzdw.zzb(mediaFormat, "max-input-size", zzaajVar.zzc);
        mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        if (f4 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f4);
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzK));
        }
        Surface surfaceZzbs = zzbs(zzsyVar);
        if (this.zzp != null && !zzep.zzS(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zzss.zzb(zzsyVar, mediaFormat, zzvVar, surfaceZzbs, null);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        int i2;
        int i8;
        zzht zzhtVarZzf = zzsyVar.zzf(zzvVar, zzvVar2);
        int i9 = zzhtVarZzf.zze;
        zzaaj zzaajVar = this.zzm;
        zzaajVar.getClass();
        if (zzvVar2.zzv > zzaajVar.zza || zzvVar2.zzw > zzaajVar.zzb) {
            i9 |= 256;
        }
        if (zzbg(zzsyVar, zzvVar2) > zzaajVar.zzc) {
            i9 |= 64;
        }
        String str = zzsyVar.zza;
        if (i9 != 0) {
            i8 = 0;
            i2 = i9;
        } else {
            i2 = 0;
            i8 = zzhtVarZzf.zzd;
        }
        return new zzht(str, zzvVar, zzvVar2, i8, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final float zzai(float f4, zzv zzvVar, zzv[] zzvVarArr) {
        zzsy zzsyVarZzaH;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f8 = zzvVar2.zzz;
            if (f8 != -1.0f) {
                fMax = Math.max(fMax, f8);
            }
        }
        float f9 = fMax == -1.0f ? -1.0f : fMax * f4;
        if (this.zzD == null || (zzsyVarZzaH = zzaH()) == null) {
            return f9;
        }
        float fZzh = zzsyVarZzaH.zzh(zzvVar.zzv, zzvVar.zzw);
        return f9 != -1.0f ? Math.max(f9, fZzh) : fZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzaj(String str, zzss zzssVar, long j, long j3) {
        this.zzg.zzb(str, j, j3);
        this.zzn = zzbk(str);
        zzsy zzsyVarZzaH = zzaH();
        zzsyVarZzaH.getClass();
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zzsyVarZzaH.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzb = zzsyVarZzaH.zzb();
            int length = codecProfileLevelArrZzb.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (codecProfileLevelArrZzb[i2].profile == 16384) {
                    z2 = true;
                    break;
                }
                i2++;
            }
        }
        this.zzo = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzak(String str) {
        this.zzg.zzh(str);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzal(Exception exc) {
        zzdt.zzf("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    @Nullable
    public final zzht zzam(zzkj zzkjVar) throws zzib {
        zzht zzhtVarZzam = super.zzam(zzkjVar);
        zzv zzvVar = zzkjVar.zzb;
        zzvVar.getClass();
        this.zzg.zzc(zzvVar, zzhtVarZzam);
        return zzhtVarZzam;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzan(zzv zzvVar, @Nullable MediaFormat mediaFormat) {
        zzsv zzsvVarZzaE = zzaE();
        if (zzsvVarZzaE != null) {
            zzsvVarZzaE.zzp(this.zzx);
        }
        mediaFormat.getClass();
        boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f4 = zzvVar.zzB;
        int i2 = zzvVar.zzA;
        if (i2 == 90 || i2 == 270) {
            f4 = 1.0f / f4;
            int i8 = integer2;
            integer2 = integer;
            integer = i8;
        }
        this.zzI = new zzbv(integer, integer2, f4);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || !this.zzP) {
            this.zzi.zze(zzvVar.zzz);
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzt(integer);
            zztVarZza.zzu(integer2);
            zztVarZza.zzz(f4);
            zzv zzvVarZzM = zztVarZza.zzM();
            int i9 = this.zzr;
            List listZzi = this.zzs;
            if (listZzi == null) {
                listZzi = zzgpe.zzi();
            }
            zzabxVar.zzs(1, zzvVarZzM, zzbc(), i9, listZzi);
            this.zzr = 2;
        }
        this.zzP = false;
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final boolean zzao(long j, long j3, long j8, boolean z2, boolean z7) throws zzib {
        int iZzP;
        if (this.zzp != null && this.zzf) {
            j3 -= -this.zzN;
        }
        if (j >= -500000 || z2 || (iZzP = zzP(j3)) == 0) {
            return false;
        }
        if (z7) {
            zzhs zzhsVar = ((zzte) this).zza;
            int i2 = zzhsVar.zzd + iZzP;
            zzhsVar.zzd = i2;
            zzhsVar.zzf += this.zzC;
            zzhsVar.zzd = this.zzl.size() + i2;
        } else {
            ((zzte) this).zza.zzj++;
            zzaw(this.zzl.size() + iZzP, this.zzC);
        }
        zzaJ();
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzg(false);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzap() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzi();
            long jZzbc = this.zzN;
            if (jZzbc == -9223372036854775807L) {
                jZzbc = zzbc();
                this.zzN = jZzbc;
            }
            this.zzp.zzo(-jZzbc);
        } else {
            this.zzi.zza(2);
        }
        this.zzP = true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final boolean zzaq(long j, long j3, @Nullable zzsv zzsvVar, @Nullable ByteBuffer byteBuffer, int i2, int i8, int i9, long j8, boolean z2, boolean z7, zzv zzvVar) throws zzib {
        zzaak zzaakVar;
        long j9;
        zzsvVar.getClass();
        long jZzbb = j8 - zzbb();
        int i10 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzl;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j8) {
                break;
            }
            priorityQueue.poll();
            i10++;
        }
        zzaw(i10, 0);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            if (!z2 || z7) {
                return zzabxVar.zzu(j8, new zzaag(this, zzsvVar, i2, jZzbb));
            }
            zzau(zzsvVar, i2, jZzbb);
            return true;
        }
        zzaba zzabaVar = this.zzi;
        long jZzbc = zzbc();
        zzaay zzaayVar = this.zzj;
        int iZzk = zzabaVar.zzk(j8, j, j3, jZzbc, z2, z7, zzaayVar);
        if (iZzk == 0) {
            long jZzc = zzL().zzc();
            zzbq(jZzbb, jZzc, zzvVar);
            zzay(zzsvVar, i2, jZzbb, jZzc);
            zzax(zzaayVar.zza());
            return true;
        }
        if (iZzk != 1) {
            if (iZzk == 2) {
                zzav(zzsvVar, i2, jZzbb);
                zzax(zzaayVar.zza());
                return true;
            }
            if (iZzk != 3) {
                return false;
            }
            zzau(zzsvVar, i2, jZzbb);
            zzax(zzaayVar.zza());
            return true;
        }
        long jZzb = zzaayVar.zzb();
        long jZza = zzaayVar.zza();
        if (jZzb == this.zzH) {
            zzau(zzsvVar, i2, jZzbb);
            j9 = jZzb;
            zzaakVar = this;
        } else {
            zzbq(jZzbb, jZzb, zzvVar);
            zzay(zzsvVar, i2, jZzbb, jZzb);
            zzaakVar = this;
            j9 = jZzb;
        }
        zzaakVar.zzax(jZza);
        zzaakVar.zzH = j9;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzar() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzas(zzhh zzhhVar) throws zzib {
        if (this.zzo) {
            ByteBuffer byteBuffer = zzhhVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b8 = byteBuffer.get();
                short s7 = byteBuffer.getShort();
                short s8 = byteBuffer.getShort();
                byte b9 = byteBuffer.get();
                byte b10 = byteBuffer.get();
                byteBuffer.position(0);
                if (b8 == -75 && s7 == 60 && s8 == 1 && b9 == 4) {
                    if (b10 == 0 || b10 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsv zzsvVarZzaE = zzaE();
                        zzsvVarZzaE.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzsvVarZzaE.zzo(bundle);
                    }
                }
            }
        }
    }

    public final void zzau(zzsv zzsvVar, int i2, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzsvVar.zzc(i2, false);
        Trace.endSection();
        ((zzte) this).zza.zzf++;
    }

    public final void zzav(zzsv zzsvVar, int i2, long j) {
        Trace.beginSection("dropVideoBuffer");
        zzsvVar.zzc(i2, false);
        Trace.endSection();
        zzaw(0, 1);
    }

    public final void zzaw(int i2, int i8) {
        zzhs zzhsVar = ((zzte) this).zza;
        zzhsVar.zzh += i2;
        int i9 = i2 + i8;
        zzhsVar.zzg += i9;
        this.zzA += i9;
        int i10 = this.zzB + i9;
        this.zzB = i10;
        zzhsVar.zzi = Math.max(i10, zzhsVar.zzi);
    }

    public final void zzax(long j) {
        zzhs zzhsVar = ((zzte) this).zza;
        zzhsVar.zzk += j;
        zzhsVar.zzl++;
        this.zzF += j;
        this.zzG++;
    }

    public final void zzay(zzsv zzsvVar, int i2, long j, long j3) {
        Trace.beginSection("releaseOutputBuffer");
        zzsvVar.zzd(i2, j3);
        Trace.endSection();
        ((zzte) this).zza.zze++;
        this.zzB = 0;
        if (this.zzp == null) {
            zzbv zzbvVar = this.zzI;
            if (!zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzJ)) {
                this.zzJ = zzbvVar;
                this.zzg.zzf(zzbvVar);
            }
            if (!this.zzi.zzf() || this.zzt == null) {
                return;
            }
            zzbi();
        }
    }

    public final boolean zzbf(zzsy zzsyVar) {
        if (zzbk(zzsyVar.zza)) {
            return false;
        }
        return !zzsyVar.zzf || zzaam.zza(this.zze);
    }

    public final /* synthetic */ Surface zzbj() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public final void zzx(int i2, @Nullable Object obj) throws zzib {
        if (i2 == 1) {
            zzbn(obj);
            return;
        }
        if (i2 == 7) {
            obj.getClass();
            zzaax zzaaxVar = (zzaax) obj;
            this.zzM = zzaaxVar;
            zzabx zzabxVar = this.zzp;
            if (zzabxVar != null) {
                zzabxVar.zzl(zzaaxVar);
                return;
            }
            return;
        }
        if (i2 == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzL != iIntValue) {
                this.zzL = iIntValue;
                return;
            }
            return;
        }
        if (i2 == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzx = iIntValue2;
            zzsv zzsvVarZzaE = zzaE();
            if (zzsvVarZzaE != null) {
                zzsvVarZzaE.zzp(iIntValue2);
                return;
            }
            return;
        }
        if (i2 == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzy = iIntValue3;
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzr(iIntValue3);
                return;
            } else {
                this.zzi.zzm(iIntValue3);
                return;
            }
        }
        if (i2 == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.zza)) {
                zzabx zzabxVar3 = this.zzp;
                if (zzabxVar3 == null || !zzabxVar3.zze()) {
                    return;
                }
                zzabxVar3.zzf();
                return;
            }
            this.zzs = list;
            zzabx zzabxVar4 = this.zzp;
            if (zzabxVar4 != null) {
                zzabxVar4.zzn(list);
                return;
            }
            return;
        }
        if (i2 == 14) {
            obj.getClass();
            zzeh zzehVar = (zzeh) obj;
            if (zzehVar.zza() == 0 || zzehVar.zzb() == 0) {
                return;
            }
            this.zzv = zzehVar;
            zzabx zzabxVar5 = this.zzp;
            if (zzabxVar5 != null) {
                Surface surface = this.zzt;
                surface.getClass();
                zzabxVar5.zzp(surface, zzehVar);
                return;
            }
            return;
        }
        switch (i2) {
            case 16:
                obj.getClass();
                this.zzK = ((Integer) obj).intValue();
                zzsv zzsvVarZzaE2 = zzaE();
                if (zzsvVarZzaE2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzK));
                    zzsvVarZzaE2.zzo(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzt;
                zzbn(null);
                obj.getClass();
                ((zzaak) obj).zzx(1, surface2);
                break;
            case 18:
                boolean z2 = this.zzD != null;
                zzlu zzluVar = (zzlu) obj;
                this.zzD = zzluVar;
                if (z2 != (zzluVar != null)) {
                    zzaZ();
                }
                break;
            default:
                super.zzx(i2, obj);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzy(boolean z2, boolean z7) throws zzib {
        super.zzy(z2, z7);
        zzJ();
        this.zzg.zza(((zzte) this).zza);
        if (!this.zzq) {
            if (this.zzs != null && this.zzp == null) {
                zzaao zzaaoVar = new zzaao(this.zze, this.zzi);
                zzaaoVar.zza(true);
                long j = this.zzk;
                zzaaoVar.zzc(j != -9223372036854775807L ? -j : -9223372036854775807L);
                zzaaoVar.zzb(zzL());
                zzaaw zzaawVarZzd = zzaaoVar.zzd();
                zzaawVarZzd.zza(1);
                this.zzp = zzaawVarZzd.zzb(0);
            }
            this.zzq = true;
        }
        int i2 = !z7 ? 1 : 0;
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null) {
            zzaba zzabaVar = this.zzi;
            zzabaVar.zzg(zzL());
            zzabaVar.zza(i2);
            return;
        }
        zzabxVar.zzc(new zzaaf(this), zzguz.zza());
        zzaax zzaaxVar = this.zzM;
        if (zzaaxVar != null) {
            this.zzp.zzl(zzaaxVar);
        }
        if (this.zzt != null && !this.zzv.equals(zzeh.zza)) {
            this.zzp.zzp(this.zzt, this.zzv);
        }
        this.zzp.zzr(this.zzy);
        this.zzp.zzm(zzaX());
        List list = this.zzs;
        if (list != null) {
            this.zzp.zzn(list);
        }
        this.zzr = i2;
        zzaz();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    public final void zzz(zzv[] zzvVarArr, long j, long j3, zzuu zzuuVar) throws zzib {
        super.zzz(zzvVarArr, j, j3, zzuuVar);
        zzbf zzbfVarZzM = zzM();
        if (zzbfVarZzM.zzg()) {
            this.zzO = -9223372036854775807L;
        } else {
            this.zzO = zzbfVarZzM.zzo(zzuuVar.zza, new zzbd()).zzd;
        }
    }
}
