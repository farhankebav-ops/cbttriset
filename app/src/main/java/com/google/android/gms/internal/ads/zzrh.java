package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrh implements zzqh {
    private static final Object zza = new Object();

    @Nullable
    @GuardedBy("releaseExecutorLock")
    private static ScheduledExecutorService zzb;

    @GuardedBy("releaseExecutorLock")
    private static int zzc;
    private zzqx zzA;
    private zzav zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;

    @Nullable
    private ByteBuffer zzM;
    private int zzN;

    @Nullable
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private boolean zzU;
    private zze zzV;

    @Nullable
    private AudioDeviceInfo zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;

    @Nullable
    private Looper zzaa;
    private long zzab;
    private long zzac;
    private Handler zzad;

    @Nullable
    private Context zzae;
    private boolean zzaf;
    private int zzag;
    private boolean zzah;
    private final zzqr zzai;
    private final zzqn zzaj;

    @Nullable
    private final Context zzd;
    private final zzqm zze;
    private final zzrp zzf;
    private final zzck zzg;
    private final zzro zzh;
    private final zzgpe zzi;
    private final zzql zzj;
    private final ArrayDeque zzk;
    private zzrg zzl;
    private final zzrc zzm;
    private final zzrc zzn;
    private final int zzo;

    @Nullable
    private zzpc zzp;

    @Nullable
    private zzqe zzq;

    @Nullable
    private zzqq zzr;
    private zzqq zzs;
    private zzcc zzt;

    @Nullable
    private AudioTrack zzu;
    private zzpe zzv;
    private zzpj zzw;

    @Nullable
    private zzrb zzx;
    private zzd zzy;

    @Nullable
    private zzqx zzz;

    public /* synthetic */ zzrh(zzqp zzqpVar, byte[] bArr) {
        int deviceId;
        byte[] bArr2 = null;
        Context applicationContext = zzqpVar.zzb() == null ? null : zzqpVar.zzb().getApplicationContext();
        this.zzd = applicationContext;
        this.zzy = zzd.zza;
        this.zzv = applicationContext != null ? null : zzqpVar.zzc();
        this.zzai = zzqpVar.zzd();
        zzqn zzqnVarZze = zzqpVar.zze();
        zzqnVarZze.getClass();
        this.zzaj = zzqnVarZze;
        this.zzj = new zzql(new zzrd(this, bArr2));
        zzqm zzqmVar = new zzqm();
        this.zze = zzqmVar;
        zzrp zzrpVar = new zzrp();
        this.zzf = zzrpVar;
        this.zzg = new zzck();
        this.zzh = new zzro();
        this.zzi = zzgpe.zzk(zzrpVar, zzqmVar);
        this.zzL = 1.0f;
        this.zzT = 0;
        this.zzV = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzA = new zzqx(zzavVar, 0L, 0L, null);
        this.zzB = zzavVar;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzrc();
        this.zzn = new zzrc();
        int i2 = -1;
        if (Build.VERSION.SDK_INT >= 34 && zzqpVar.zzb() != null && (deviceId = zzqpVar.zzb().getDeviceId()) != 0 && deviceId != -1) {
            i2 = deviceId;
        }
        this.zzo = i2;
        this.zzaf = true;
    }

    public static /* synthetic */ void zzE(AudioTrack audioTrack, final zzqe zzqeVar, Handler handler, final zzqb zzqbVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i2 = zzc - 1;
                    zzc = i2;
                    if (i2 == 0) {
                        zzb.shutdown();
                        zzb = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i8 = zzc - 1;
                    zzc = i8;
                    if (i8 == 0) {
                        zzb.shutdown();
                        zzb = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public static /* synthetic */ boolean zzH() {
        boolean z2;
        synchronized (zza) {
            z2 = zzc > 0;
        }
        return z2;
    }

    private final void zzM() {
        zzcc zzccVar = this.zzs.zzi;
        this.zzt = zzccVar;
        zzccVar.zzb(zzce.zza);
    }

    private final AudioTrack zzN(zzqq zzqqVar) throws zzqd {
        Context context;
        try {
            int i2 = this.zzT;
            int i8 = this.zzo;
            Context context2 = null;
            if (i8 != -1 && (context = this.zzd) != null && Build.VERSION.SDK_INT >= 34) {
                if (this.zzae == null) {
                    this.zzae = context.createDeviceContext(i8);
                }
                context2 = this.zzae;
                i2 = 0;
            }
            return zzaf(zzqqVar.zza(), this.zzy, i2, zzqqVar.zza, context2);
        } catch (zzqd e) {
            zzqe zzqeVar = this.zzq;
            if (zzqeVar != null) {
                zzqeVar.zzb(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) throws Exception {
        zzR(j);
        if (this.zzO != null) {
            return;
        }
        if (!this.zzt.zzc()) {
            ByteBuffer byteBuffer = this.zzM;
            if (byteBuffer != null) {
                zzQ(byteBuffer);
                zzR(j);
                return;
            }
            return;
        }
        while (!this.zzt.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzt.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzQ(byteBufferZze);
                    zzR(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzM;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzt.zzd(this.zzM);
                    }
                }
            } while (this.zzO == null);
            return;
        }
    }

    private final boolean zzP() throws Exception {
        if (!this.zzt.zzc()) {
            zzR(Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzf();
        zzO(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzO;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzQ(java.nio.ByteBuffer r19) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzQ(java.nio.ByteBuffer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzR(long r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.nio.ByteBuffer r8 = r7.zzO
            if (r8 != 0) goto L6
            goto Lbb
        L6:
            com.google.android.gms.internal.ads.zzrc r8 = r7.zzn
            boolean r9 = r8.zzb()
            if (r9 != 0) goto Lbb
            java.nio.ByteBuffer r9 = r7.zzO
            int r9 = r9.remaining()
            android.media.AudioTrack r0 = r7.zzu
            java.nio.ByteBuffer r1 = r7.zzO
            r2 = 1
            int r0 = r0.write(r1, r9, r2)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r7.zzX = r3
            r3 = 0
            r1 = 0
            if (r0 >= 0) goto L72
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r9 < r5) goto L31
            r9 = -6
            if (r0 == r9) goto L35
        L31:
            r9 = -32
            if (r0 != r9) goto L4a
        L35:
            long r5 = r7.zzG()
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 <= 0) goto L3e
            goto L4b
        L3e:
            android.media.AudioTrack r9 = r7.zzu
            boolean r9 = zzab(r9)
            if (r9 == 0) goto L4a
            r7.zzS()
            goto L4b
        L4a:
            r2 = r1
        L4b:
            com.google.android.gms.internal.ads.zzqg r9 = new com.google.android.gms.internal.ads.zzqg
            com.google.android.gms.internal.ads.zzqq r1 = r7.zzs
            com.google.android.gms.internal.ads.zzv r1 = r1.zza
            r9.<init>(r0, r1, r2)
            com.google.android.gms.internal.ads.zzqe r0 = r7.zzq
            if (r0 == 0) goto L5b
            r0.zzb(r9)
        L5b:
            boolean r0 = r9.zzb
            if (r0 == 0) goto L6e
            android.content.Context r0 = r7.zzd
            if (r0 != 0) goto L64
            goto L6e
        L64:
            com.google.android.gms.internal.ads.zzpe r8 = com.google.android.gms.internal.ads.zzpe.zza
            r7.zzv = r8
            com.google.android.gms.internal.ads.zzpj r0 = r7.zzw
            r0.zza(r8)
            throw r9
        L6e:
            r8.zza(r9)
            return
        L72:
            r8.zzc()
            android.media.AudioTrack r8 = r7.zzu
            boolean r8 = zzab(r8)
            if (r8 == 0) goto L91
            long r5 = r7.zzG
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 <= 0) goto L85
            r7.zzZ = r1
        L85:
            boolean r8 = r7.zzS
            if (r8 == 0) goto L91
            com.google.android.gms.internal.ads.zzqe r8 = r7.zzq
            if (r8 == 0) goto L91
            if (r0 >= r9) goto L91
            com.google.android.gms.internal.ads.zzrk r8 = (com.google.android.gms.internal.ads.zzrk) r8
        L91:
            com.google.android.gms.internal.ads.zzqq r8 = r7.zzs
            int r8 = r8.zzc
            if (r8 != 0) goto L9d
            long r3 = r7.zzF
            long r5 = (long) r0
            long r3 = r3 + r5
            r7.zzF = r3
        L9d:
            if (r0 != r9) goto Lbb
            if (r8 == 0) goto Lb8
            java.nio.ByteBuffer r8 = r7.zzO
            java.nio.ByteBuffer r9 = r7.zzM
            if (r8 != r9) goto La8
            goto La9
        La8:
            r2 = r1
        La9:
            com.google.android.gms.internal.ads.zzgmd.zzh(r2)
            long r8 = r7.zzG
            int r0 = r7.zzH
            long r0 = (long) r0
            int r2 = r7.zzN
            long r2 = (long) r2
            long r0 = r0 * r2
            long r0 = r0 + r8
            r7.zzG = r0
        Lb8:
            r8 = 0
            r7.zzO = r8
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzR(long):void");
    }

    private final void zzS() {
        if (this.zzs.zzc == 1) {
            this.zzY = true;
        }
    }

    private final void zzT() {
        if (zzX()) {
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzU(zzav zzavVar) {
        zzqx zzqxVar = new zzqx(zzavVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzX()) {
            this.zzz = zzqxVar;
        } else {
            this.zzA = zzqxVar;
        }
    }

    private final void zzV(long j) {
        zzav zzavVar;
        boolean z2;
        if (zzW()) {
            zzqr zzqrVar = this.zzai;
            zzavVar = this.zzB;
            zzqrVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzB = zzavVar2;
        if (zzW()) {
            zzqr zzqrVar2 = this.zzai;
            z2 = this.zzC;
            zzqrVar2.zzc(z2);
        } else {
            z2 = false;
        }
        this.zzC = z2;
        this.zzk.add(new zzqx(zzavVar2, Math.max(0L, j), zzep.zzr(zzG(), this.zzs.zze), null));
        zzM();
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzaw().zzh(this.zzC);
        }
    }

    private final boolean zzW() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return false;
        }
        int i2 = zzqqVar.zza.zzI;
        return true;
    }

    private final boolean zzX() {
        return this.zzu != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzY, reason: merged with bridge method [inline-methods] */
    public final long zzF() {
        zzqq zzqqVar = this.zzs;
        return zzqqVar.zzc == 0 ? this.zzD / ((long) zzqqVar.zzb) : this.zzE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzZ, reason: merged with bridge method [inline-methods] */
    public final long zzG() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j3 = zzqqVar.zzd;
        String str = zzep.zza;
        return ((j + j3) - 1) / j3;
    }

    @EnsuresNonNull({"audioCapabilities"})
    private final void zzaa() {
        Context context;
        Looper looperMyLooper = Looper.myLooper();
        boolean z2 = true;
        if (this.zzw != null && this.zzaa != looperMyLooper) {
            z2 = false;
        }
        zzgmd.zzj(z2, "DefaultAudioSink accessed on multiple threads: %s and %s", zzae(this.zzaa), zzae(looperMyLooper));
        if (this.zzw == null && (context = this.zzd) != null) {
            this.zzaa = looperMyLooper;
            zzpj zzpjVar = new zzpj(context, new zzpi() { // from class: com.google.android.gms.internal.ads.zzqs
                @Override // com.google.android.gms.internal.ads.zzpi
                public final /* synthetic */ void zza(zzpe zzpeVar) {
                    this.zza.zzC(zzpeVar);
                }
            }, this.zzy, this.zzW);
            this.zzw = zzpjVar;
            this.zzv = zzpjVar.zzd();
        }
        this.zzv.getClass();
    }

    private static boolean zzab(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final void zzac() {
        if (this.zzQ) {
            return;
        }
        this.zzQ = true;
        this.zzj.zzf(zzG());
        if (zzab(this.zzu)) {
            this.zzR = false;
        }
        this.zzu.stop();
    }

    private final boolean zzad(long j) {
        long jZzb = this.zzj.zzb();
        AudioTrack audioTrack = this.zzu;
        audioTrack.getClass();
        return j > zzep.zzs(jZzb, audioTrack.getSampleRate());
    }

    private static String zzae(@Nullable Looper looper) {
        return looper == null ? "null" : looper.getThread().getName();
    }

    private static final AudioTrack zzaf(zzqb zzqbVar, zzd zzdVar, int i2, zzv zzvVar, @Nullable Context context) throws zzqd {
        zzv zzvVar2;
        Exception exc;
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzdVar.zza()).setAudioFormat(zzep.zzC(zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzqbVar.zze).setSessionId(i2);
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 29) {
                try {
                    sessionId.setOffloadedPlayback(zzqbVar.zzd);
                } catch (IllegalArgumentException e) {
                    e = e;
                    exc = e;
                    zzvVar2 = zzvVar;
                    throw new zzqd(0, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar2, zzqbVar.zzd, exc);
                } catch (UnsupportedOperationException e4) {
                    e = e4;
                    exc = e;
                    zzvVar2 = zzvVar;
                    throw new zzqd(0, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar2, zzqbVar.zzd, exc);
                }
            }
            if (i8 >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            int state = audioTrackBuild.getState();
            if (state == 1) {
                return audioTrackBuild;
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqd(state, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar, zzqbVar.zzd, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e8) {
            zzvVar2 = zzvVar;
            exc = e8;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzA() {
        zzz();
        zzgpe zzgpeVar = this.zzi;
        int size = zzgpeVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzcg) zzgpeVar.get(i2)).zzj();
        }
        this.zzg.zzj();
        this.zzh.zzj();
        zzcc zzccVar = this.zzt;
        if (zzccVar != null) {
            zzccVar.zzh();
        }
        this.zzS = false;
        this.zzY = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzB() {
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zze();
        }
    }

    public final void zzC(zzpe zzpeVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzaa;
        zzgmd.zzj(looper == looperMyLooper, "Current looper (%s) is not the playback looper (%s)", zzae(looperMyLooper), zzae(this.zzaa));
        zzpe zzpeVar2 = this.zzv;
        if (zzpeVar2 == null || zzpeVar.equals(zzpeVar2)) {
            return;
        }
        this.zzv = zzpeVar;
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzR();
        }
    }

    public final /* synthetic */ void zzD() {
        if (this.zzac >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            ((zzrk) this.zzq).zza.zzay(true);
            this.zzac = 0L;
        }
    }

    public final /* synthetic */ zzqe zzI() {
        return this.zzq;
    }

    public final /* synthetic */ AudioTrack zzJ() {
        return this.zzu;
    }

    public final /* synthetic */ void zzK(boolean z2) {
        this.zzR = true;
    }

    public final /* synthetic */ boolean zzL() {
        return this.zzS;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zza(zzqe zzqeVar) {
        this.zzq = zzqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzb(@Nullable zzpc zzpcVar) {
        this.zzp = zzpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzc(zzdc zzdcVar) {
        this.zzj.zzi(zzdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final int zze(zzv zzvVar) {
        zzaa();
        if (!"audio/raw".equals(zzvVar.zzo)) {
            return this.zzv.zzd(zzvVar, this.zzy) != null ? 2 : 0;
        }
        int i2 = zzvVar.zzI;
        if (zzep.zzA(i2)) {
            return i2 != 2 ? 1 : 2;
        }
        com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(i2).length() + 22), "Invalid PCM encoding: ", i2, "DefaultAudioSink");
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzpl zzf(zzv zzvVar) {
        return this.zzY ? zzpl.zza : this.zzaj.zza(zzvVar, this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzg(boolean z2) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzX() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzj.zzb(), zzep.zzr(zzG(), this.zzs.zze));
        while (true) {
            arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || jMin < ((zzqx) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzA = (zzqx) arrayDeque.remove();
        }
        zzqx zzqxVar = this.zzA;
        long j3 = jMin - zzqxVar.zzc;
        long jZzv = zzep.zzv(j3, zzqxVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzai.zzd(j3);
            zzqx zzqxVar2 = this.zzA;
            j = zzqxVar2.zzb + jZzd;
            zzqxVar2.zzd = jZzd - jZzv;
        } else {
            zzqx zzqxVar3 = this.zzA;
            j = zzqxVar3.zzb + jZzv + zzqxVar3.zzd;
        }
        long jZze = this.zzai.zze();
        long jZzr = zzep.zzr(jZze, this.zzs.zze) + j;
        long j8 = this.zzab;
        if (jZze > j8) {
            long jZzr2 = zzep.zzr(jZze - j8, this.zzs.zze);
            this.zzab = jZze;
            this.zzac += jZzr2;
            if (this.zzad == null) {
                this.zzad = new Handler(Looper.myLooper());
            }
            this.zzad.removeCallbacksAndMessages(null);
            this.zzad.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzD();
                }
            }, 100L);
        }
        return jZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzh(zzv zzvVar, int i2, @Nullable int[] iArr) throws zzqc {
        zzcc zzccVar;
        int i8;
        int i9;
        int iZzE;
        int iIntValue;
        int i10;
        int i11;
        zzaa();
        if ("audio/raw".equals(zzvVar.zzo)) {
            int i12 = zzvVar.zzI;
            zzgmd.zza(zzep.zzA(i12));
            int i13 = zzvVar.zzG;
            iZzE = zzep.zzE(i12) * i13;
            zzgpb zzgpbVar = new zzgpb();
            zzgpbVar.zzh(this.zzi);
            zzgpbVar.zzf(this.zzg);
            zzgpbVar.zzg(this.zzai.zza());
            zzccVar = new zzcc(zzgpbVar.zzi());
            if (zzccVar.equals(this.zzt)) {
                zzccVar = this.zzt;
            }
            this.zzf.zzq(zzvVar.zzJ, zzvVar.zzK);
            this.zze.zzq(iArr);
            try {
                zzcd zzcdVarZza = zzccVar.zza(new zzcd(zzvVar.zzH, i13, i12));
                int i14 = zzcdVarZza.zzd;
                i8 = zzcdVarZza.zzb;
                int i15 = zzcdVarZza.zzc;
                int iZzB = zzep.zzB(i15);
                int iZzE2 = zzep.zzE(i14) * i15;
                i9 = 0;
                iIntValue = iZzB;
                i10 = i14;
                i11 = iZzE2;
            } catch (zzcf e) {
                throw new zzqc(e, zzvVar);
            }
        } else {
            zzccVar = new zzcc(zzgpe.zzi());
            i8 = zzvVar.zzH;
            zzpl zzplVar = zzpl.zza;
            Pair pairZzd = this.zzv.zzd(zzvVar, this.zzy);
            if (pairZzd == null) {
                throw new zzqc("Unable to configure passthrough for: ".concat(String.valueOf(zzvVar)), zzvVar);
            }
            int iIntValue2 = ((Integer) pairZzd.first).intValue();
            i9 = 2;
            iZzE = -1;
            iIntValue = ((Integer) pairZzd.second).intValue();
            i10 = iIntValue2;
            i11 = -1;
        }
        int i16 = i8;
        if (i10 == 0) {
            String strValueOf = String.valueOf(zzvVar);
            StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i9, 37) + strValueOf.length());
            sb.append("Invalid output encoding (mode=");
            sb.append(i9);
            sb.append(") for: ");
            sb.append(strValueOf);
            throw new zzqc(sb.toString(), zzvVar);
        }
        if (iIntValue == 0) {
            String strValueOf2 = String.valueOf(zzvVar);
            StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i9, 43) + strValueOf2.length());
            sb2.append("Invalid output channel config (mode=");
            sb2.append(i9);
            sb2.append(") for: ");
            sb2.append(strValueOf2);
            throw new zzqc(sb2.toString(), zzvVar);
        }
        int i17 = zzvVar.zzj;
        if ("audio/vnd.dts.hd;profile=lbr".equals(zzvVar.zzo) && i17 == -1) {
            i17 = 768000;
        }
        int i18 = i17;
        int minBufferSize = AudioTrack.getMinBufferSize(i16, iIntValue, i10);
        zzgmd.zzh(minBufferSize != -2);
        int i19 = i11 != -1 ? i11 : 1;
        int i20 = i10;
        int iZzb = zzrj.zzb(minBufferSize, i20, i9, i19, i16, i18);
        int i21 = i19;
        this.zzY = false;
        zzqq zzqqVar = new zzqq(zzvVar, iZzE, i9, i11, i16, iIntValue, i20, (((Math.max(minBufferSize, iZzb) + i21) - 1) / i21) * i21, zzccVar, false, false, false);
        if (zzX()) {
            this.zzr = zzqqVar;
        } else {
            this.zzs = zzqqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzi() {
        this.zzS = true;
        if (zzX()) {
            this.zzj.zzc();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.play();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzj() {
        this.zzI = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01dd  */
    @Override // com.google.android.gms.internal.ads.zzqh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.nio.ByteBuffer r30, long r31, int r33) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzk(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzl() throws zzqg {
        if (!this.zzP && zzX() && zzP()) {
            zzac();
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzm() {
        if (zzX()) {
            return this.zzP && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzn() {
        if (zzX()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.zzu.isOffloadedPlayback() && this.zzR) && zzad(zzG());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzo(zzav zzavVar) {
        float f4 = zzavVar.zzb;
        String str = zzep.zza;
        this.zzB = new zzav(Math.max(0.1f, Math.min(f4, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        zzU(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzav zzp() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzq(boolean z2) {
        this.zzC = z2;
        zzU(this.zzB);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzr(zzd zzdVar) {
        if (this.zzy.equals(zzdVar)) {
            return;
        }
        this.zzy = zzdVar;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzb(zzdVar);
        }
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzs(int i2) {
        if (this.zzU) {
            if (this.zzT != i2) {
                return;
            } else {
                this.zzU = false;
            }
        }
        if (this.zzT != i2) {
            this.zzT = i2;
            zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzt(zze zzeVar) {
        if (this.zzV.equals(zzeVar)) {
            return;
        }
        if (this.zzu != null) {
            int i2 = this.zzV.zza;
        }
        this.zzV = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzu(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.zzW = audioDeviceInfo;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzc(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            audioTrack.setPreferredDevice(this.zzW);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzv() {
        if (!zzX()) {
            return -9223372036854775807L;
        }
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc == 0) {
            return zzep.zzr(this.zzu.getBufferSizeInFrames(), zzqqVar.zze);
        }
        long bufferSizeInFrames = this.zzu.getBufferSizeInFrames();
        int iZzf = zzade.zzf(this.zzs.zzg);
        zzgmd.zzh(iZzf != -2147483647);
        return zzep.zzt(bufferSizeInFrames, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    @RequiresApi(29)
    public final void zzw(int i2, int i8) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzab(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzx(float f4) {
        if (this.zzL != f4) {
            this.zzL = f4;
            zzT();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzy() {
        this.zzS = false;
        if (zzX()) {
            this.zzj.zzg();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzz() {
        zzrb zzrbVar;
        if (zzX()) {
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzG = 0L;
            this.zzZ = false;
            this.zzH = 0;
            this.zzA = new zzqx(this.zzB, 0L, 0L, null);
            this.zzK = 0L;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzr();
            zzM();
            zzql zzqlVar = this.zzj;
            if (zzqlVar.zzd()) {
                this.zzu.pause();
            }
            if (zzab(this.zzu)) {
                zzrg zzrgVar = this.zzl;
                zzrgVar.getClass();
                zzrgVar.zzb(this.zzu);
            }
            final zzqb zzqbVarZza = this.zzs.zza();
            zzqq zzqqVar = this.zzr;
            if (zzqqVar != null) {
                this.zzs = zzqqVar;
                this.zzr = null;
            }
            zzqlVar.zzh();
            if (Build.VERSION.SDK_INT >= 24 && (zzrbVar = this.zzx) != null) {
                zzrbVar.zza();
                this.zzx = null;
            }
            final AudioTrack audioTrack = this.zzu;
            final zzqe zzqeVar = this.zzq;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                try {
                    if (zzb == null) {
                        zzb = zzep.zzg("ExoPlayer:AudioTrackReleaseThread");
                    }
                    zzc++;
                    zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqt
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzrh.zzE(audioTrack, zzqeVar, handler, zzqbVarZza);
                        }
                    }, 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zzu = null;
        }
        this.zzn.zzc();
        this.zzm.zzc();
        this.zzab = 0L;
        this.zzac = 0L;
        Handler handler2 = this.zzad;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }
}
