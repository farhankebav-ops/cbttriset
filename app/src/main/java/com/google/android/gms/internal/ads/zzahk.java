package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahk implements zzada {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzD;

    @Nullable
    private zzahj zzE;
    private boolean zzF;
    private int zzG;
    private long zzH;
    private final SparseArray zzI;
    private boolean zzJ;
    private long zzK;
    private int zzL;
    private long zzM;
    private int zzN;
    private boolean zzO;
    private long zzP;
    private long zzQ;
    private long zzR;
    private boolean zzS;
    private int zzT;
    private long zzU;
    private long zzV;
    private int zzW;
    private int zzX;
    private int[] zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private long zzae;
    private int zzaf;
    private int zzag;
    private int zzah;
    private boolean zzai;
    private boolean zzaj;
    private boolean zzak;
    private int zzal;
    private byte zzam;
    private boolean zzan;
    private zzadd zzao;
    private final zzahd zzap;
    private final zzahm zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzakg zzl;
    private final zzeg zzm;
    private final zzeg zzn;
    private final zzeg zzo;
    private final zzeg zzp;
    private final zzeg zzq;
    private final zzeg zzr;
    private final zzeg zzs;
    private final zzeg zzt;
    private final zzeg zzu;
    private final zzeg zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        String str = zzep.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahk() {
        this(new zzahd(), 2, zzakg.zza);
    }

    private final void zzA() {
        if (!this.zzD) {
            return;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i2 >= sparseArray.size()) {
                zzadd zzaddVar = this.zzao;
                zzaddVar.getClass();
                zzaddVar.zzv();
                this.zzD = false;
                return;
            }
            if (((zzahj) sparseArray.valueAt(i2)).zzV) {
                return;
            } else {
                i2++;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzp(int i2) throws zzat {
        if (this.zzE != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 32);
        sb.append("Element ");
        sb.append(i2);
        sb.append(" must be in a TrackEntry");
        throw zzat.zzb(sb.toString(), null);
    }

    private final void zzq(int i2) throws zzat {
        if (this.zzJ) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 26);
        sb.append("Element ");
        sb.append(i2);
        sb.append(" must be in a Cues");
        throw zzat.zzb(sb.toString(), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
    
        if (r2.equals("S_TEXT/SSA") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (r2.equals("S_TEXT/ASS") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        r2 = zzw(r10, "%01d:%02d:%02d:%02d", androidx.work.WorkRequest.MIN_BACKOFF_MILLIS);
        r3 = 21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ca A[SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzr(com.google.android.gms.internal.ads.zzahj r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahk.zzr(com.google.android.gms.internal.ads.zzahj, long, int, int, int):void");
    }

    private final void zzs(zzadb zzadbVar, int i2) throws IOException {
        zzeg zzegVar = this.zzo;
        if (zzegVar.zze() >= i2) {
            return;
        }
        if (zzegVar.zzj() < i2) {
            int iZzj = zzegVar.zzj();
            zzegVar.zzc(Math.max(iZzj + iZzj, i2));
        }
        zzadbVar.zzc(zzegVar.zzi(), zzegVar.zze(), i2 - zzegVar.zze());
        zzegVar.zzf(i2);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzt(zzadb zzadbVar, zzahj zzahjVar, int i2, boolean z2) throws IOException {
        int i8;
        if ("S_TEXT/UTF8".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zzb, i2);
            int i9 = this.zzag;
            zzu();
            return i9;
        }
        if ("S_TEXT/ASS".equals(zzahjVar.zzc) || "S_TEXT/SSA".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zzd, i2);
            int i10 = this.zzag;
            zzu();
            return i10;
        }
        if ("S_TEXT/WEBVTT".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zze, i2);
            int i11 = this.zzag;
            zzu();
            return i11;
        }
        if (zzahjVar.zzV) {
            zzahjVar.zzZ.getClass();
            zzeg zzegVar = new zzeg(i2);
            if (zzadbVar.zzh(zzegVar.zzi(), 0, i2, true)) {
                zzadbVar.zzl();
                if (zzacz.zza(zzegVar.zzr()) == 1 && zzegVar.zzd() >= 10) {
                    byte[] bArr = new byte[10];
                    zzegVar.zzm(bArr, 0, 10);
                    zzegVar.zzh(0);
                    int iZzc = zzacz.zzc(bArr);
                    if (zzegVar.zzd() >= iZzc + 4) {
                        zzegVar.zzk(iZzc);
                        if (zzacz.zza(zzegVar.zzB()) == 2) {
                            zzt zztVarZza = zzahjVar.zzZ.zza();
                            zztVarZza.zzm("audio/vnd.dts.hd");
                            zzahjVar.zzZ = zztVarZza.zzM();
                        }
                    }
                }
            }
            zzahjVar.zzY.zzu(zzahjVar.zzZ);
            zzahjVar.zzV = false;
            zzA();
        }
        zzaem zzaemVar = zzahjVar.zzY;
        if (!this.zzai) {
            if (zzahjVar.zzh) {
                this.zzab &= -1073741825;
                if (!this.zzaj) {
                    zzeg zzegVar2 = this.zzo;
                    zzadbVar.zzc(zzegVar2.zzi(), 0, 1);
                    this.zzaf++;
                    if ((zzegVar2.zzi()[0] & 128) == 128) {
                        throw zzat.zzb("Extension bit is set in signal byte", null);
                    }
                    this.zzam = zzegVar2.zzi()[0];
                    this.zzaj = true;
                }
                byte b8 = this.zzam;
                if ((b8 & 1) == 1) {
                    int i12 = b8 & 2;
                    this.zzab |= BasicMeasure.EXACTLY;
                    if (!this.zzan) {
                        zzeg zzegVar3 = this.zzt;
                        zzadbVar.zzc(zzegVar3.zzi(), 0, 8);
                        this.zzaf += 8;
                        this.zzan = true;
                        zzeg zzegVar4 = this.zzo;
                        zzegVar4.zzi()[0] = (byte) ((i12 != 2 ? 0 : 128) | 8);
                        zzegVar4.zzh(0);
                        zzaemVar.zzw(zzegVar4, 1, 1);
                        this.zzag++;
                        zzegVar3.zzh(0);
                        zzaemVar.zzw(zzegVar3, 8, 1);
                        this.zzag += 8;
                    }
                    if (i12 == 2) {
                        if (!this.zzak) {
                            zzeg zzegVar5 = this.zzo;
                            zzadbVar.zzc(zzegVar5.zzi(), 0, 1);
                            this.zzaf++;
                            zzegVar5.zzh(0);
                            this.zzal = zzegVar5.zzs();
                            this.zzak = true;
                        }
                        int i13 = this.zzal * 4;
                        zzeg zzegVar6 = this.zzo;
                        zzegVar6.zza(i13);
                        zzadbVar.zzc(zzegVar6.zzi(), 0, i13);
                        this.zzaf += i13;
                        int i14 = (this.zzal >> 1) + 1;
                        int i15 = (i14 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i15) {
                            this.zzw = ByteBuffer.allocate(i15);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i14);
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            i8 = this.zzal;
                            if (i16 >= i8) {
                                break;
                            }
                            int iZzH = zzegVar6.zzH();
                            int i18 = iZzH - i17;
                            if (i16 % 2 == 0) {
                                this.zzw.putShort((short) i18);
                            } else {
                                this.zzw.putInt(i18);
                            }
                            i16++;
                            i17 = iZzH;
                        }
                        int i19 = (i2 - this.zzaf) - i17;
                        if ((i8 & 1) == 1) {
                            this.zzw.putInt(i19);
                        } else {
                            this.zzw.putShort((short) i19);
                            this.zzw.putInt(0);
                        }
                        zzeg zzegVar7 = this.zzu;
                        zzegVar7.zzb(this.zzw.array(), i15);
                        zzaemVar.zzw(zzegVar7, i15, 1);
                        this.zzag += i15;
                    }
                }
            } else {
                byte[] bArr2 = zzahjVar.zzi;
                if (bArr2 != null) {
                    this.zzr.zzb(bArr2, bArr2.length);
                }
            }
            if (!"A_OPUS".equals(zzahjVar.zzc) ? zzahjVar.zzg > 0 : z2) {
                this.zzab |= 268435456;
                this.zzv.zza(0);
                int iZze = (this.zzr.zze() + i2) - this.zzaf;
                zzeg zzegVar8 = this.zzo;
                zzegVar8.zza(4);
                zzegVar8.zzi()[0] = (byte) ((iZze >> 24) & 255);
                zzegVar8.zzi()[1] = (byte) ((iZze >> 16) & 255);
                zzegVar8.zzi()[2] = (byte) ((iZze >> 8) & 255);
                zzegVar8.zzi()[3] = (byte) (iZze & 255);
                zzaemVar.zzw(zzegVar8, 4, 2);
                this.zzag += 4;
            }
            this.zzai = true;
        }
        zzeg zzegVar9 = this.zzr;
        int iZze2 = zzegVar9.zze() + i2;
        if (!"V_MPEG4/ISO/AVC".equals(zzahjVar.zzc) && !"V_MPEGH/ISO/HEVC".equals(zzahjVar.zzc)) {
            if (zzahjVar.zzU != null) {
                zzgmd.zzh(zzegVar9.zze() == 0);
                zzahjVar.zzU.zzb(zzadbVar);
            }
            while (true) {
                int i20 = this.zzaf;
                if (i20 >= iZze2) {
                    break;
                }
                int iZzx = zzx(zzadbVar, zzaemVar, iZze2 - i20);
                this.zzaf += iZzx;
                this.zzag += iZzx;
            }
        } else {
            zzeg zzegVar10 = this.zzn;
            byte[] bArrZzi = zzegVar10.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i21 = zzahjVar.zzaa;
            int i22 = 4 - i21;
            while (this.zzaf < iZze2) {
                int i23 = this.zzah;
                if (i23 == 0) {
                    int iMin = Math.min(i21, zzegVar9.zzd());
                    zzadbVar.zzc(bArrZzi, i22 + iMin, i21 - iMin);
                    if (iMin > 0) {
                        zzegVar9.zzm(bArrZzi, i22, iMin);
                    }
                    this.zzaf += i21;
                    zzegVar10.zzh(0);
                    this.zzah = zzegVar10.zzH();
                    zzeg zzegVar11 = this.zzm;
                    zzegVar11.zzh(0);
                    zzaemVar.zzz(zzegVar11, 4);
                    this.zzag += 4;
                } else {
                    int iZzx2 = zzx(zzadbVar, zzaemVar, i23);
                    this.zzaf += iZzx2;
                    this.zzag += iZzx2;
                    this.zzah -= iZzx2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahjVar.zzc)) {
            zzeg zzegVar12 = this.zzp;
            zzegVar12.zzh(0);
            zzaemVar.zzz(zzegVar12, 4);
            this.zzag += 4;
        }
        int i24 = this.zzag;
        zzu();
        return i24;
    }

    private final void zzu() {
        this.zzaf = 0;
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = false;
        this.zzaj = false;
        this.zzak = false;
        this.zzal = 0;
        this.zzam = (byte) 0;
        this.zzan = false;
        this.zzr.zza(0);
    }

    private final void zzv(zzadb zzadbVar, byte[] bArr, int i2) throws IOException {
        int length = bArr.length;
        int i8 = length + i2;
        zzeg zzegVar = this.zzs;
        if (zzegVar.zzj() < i8) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i8 + i2);
            zzegVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzegVar.zzi(), 0, length);
        }
        zzadbVar.zzc(zzegVar.zzi(), length, i2);
        zzegVar.zzh(0);
        zzegVar.zzf(i8);
    }

    private static byte[] zzw(long j, String str, long j3) {
        zzgmd.zza(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i2 = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i2);
        long j8 = j - (((long) i2) * 3600000000L);
        int i8 = (int) (j8 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i8);
        long j9 = j8 - (((long) i8) * 60000000);
        int i9 = (int) (j9 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i9), Integer.valueOf((int) ((j9 - (((long) i9) * 1000000)) / j3)));
        String str3 = zzep.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private final int zzx(zzadb zzadbVar, zzaem zzaemVar, int i2) throws IOException {
        zzeg zzegVar = this.zzr;
        int iZzd = zzegVar.zzd();
        if (iZzd <= 0) {
            return zzaemVar.zzy(zzadbVar, i2, false);
        }
        int iMin = Math.min(i2, iZzd);
        zzaemVar.zzz(zzegVar, iMin);
        return iMin;
    }

    private final long zzy(long j) throws zzat {
        long j3 = this.zzz;
        if (j3 != -9223372036854775807L) {
            return zzep.zzt(j, j3, 1000L, RoundingMode.DOWN);
        }
        throw zzat.zzb("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static int[] zzz(@Nullable int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        int length = iArr.length;
        return length >= i2 ? iArr : new int[Math.max(length + length, i2)];
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return new zzahl().zza(zzadbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if (this.zzk) {
            zzaddVar = new zzakj(zzaddVar, this.zzl);
        }
        this.zzao = zzaddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        int i2 = 0;
        this.zzS = false;
        while (!this.zzS) {
            if (this.zzap.zzc(zzadbVar)) {
                long jZzn = zzadbVar.zzn();
                if (this.zzO) {
                    this.zzQ = jZzn;
                    zzaeaVar.zza = this.zzP;
                    this.zzO = false;
                    return 1;
                }
                if (this.zzF) {
                    long j = this.zzQ;
                    if (j != -1) {
                        zzaeaVar.zza = j;
                        this.zzQ = -1L;
                        return 1;
                    }
                }
            } else {
                while (true) {
                    SparseArray sparseArray = this.zzi;
                    if (i2 >= sparseArray.size()) {
                        return -1;
                    }
                    zzahj zzahjVar = (zzahj) sparseArray.valueAt(i2);
                    zzahjVar.zzb();
                    zzaen zzaenVar = zzahjVar.zzU;
                    if (zzaenVar != null) {
                        zzaenVar.zzd(zzahjVar.zzY, zzahjVar.zzj);
                    }
                    i2++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    @CallSuper
    public final void zze(long j, long j3) {
        this.zzR = -9223372036854775807L;
        int i2 = 0;
        this.zzT = 0;
        this.zzap.zzb();
        this.zzh.zza();
        zzu();
        this.zzJ = false;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i2 >= sparseArray.size()) {
                return;
            }
            zzaen zzaenVar = ((zzahj) sparseArray.valueAt(i2)).zzU;
            if (zzaenVar != null) {
                zzaenVar.zza();
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    @CallSuper
    public final void zzg(int i2, long j, long j3) throws zzat {
        zzadd zzaddVar = this.zzao;
        zzaddVar.getClass();
        if (i2 == 160) {
            this.zzad = false;
            this.zzae = 0L;
            return;
        }
        if (i2 == 174) {
            zzahj zzahjVar = new zzahj();
            this.zzE = zzahjVar;
            zzahjVar.zza = this.zzC;
            return;
        }
        if (i2 == 183) {
            zzq(i2);
            this.zzL = -1;
            this.zzM = -1L;
            return;
        }
        if (i2 == 187) {
            zzq(i2);
            this.zzK = -9223372036854775807L;
            return;
        }
        if (i2 == 19899) {
            this.zzG = -1;
            this.zzH = -1L;
            return;
        }
        if (i2 == 20533) {
            zzp(i2);
            this.zzE.zzh = true;
            return;
        }
        if (i2 == 21968) {
            zzp(i2);
            this.zzE.zzy = true;
            return;
        }
        if (i2 == 408125543) {
            long j8 = this.zzy;
            if (j8 != -1 && j8 != j) {
                throw zzat.zzb("Multiple Segment elements not supported", null);
            }
            this.zzy = j;
            this.zzx = j3;
            return;
        }
        if (i2 == 475249515) {
            this.zzJ = true;
            return;
        }
        if (i2 == 524531317 && !this.zzF) {
            if (this.zzj && this.zzP != -1) {
                this.zzO = true;
            } else {
                zzaddVar.zzw(new zzaec(this.zzB, 0L));
                this.zzF = true;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:223:0x030b  */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(int r25) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahk.zzh(int):void");
    }

    @CallSuper
    public final void zzi(int i2, long j) throws zzat {
        boolean z2;
        if (i2 == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 35);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw zzat.zzb(sb.toString(), null);
        }
        if (i2 == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(j).length() + 35);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw zzat.zzb(sb2.toString(), null);
        }
        switch (i2) {
            case MRAID_JS_WRITE_FAILED_VALUE:
                int i8 = (int) j;
                if (i8 == 1) {
                    zzp(i2);
                    this.zzE.zze = 2;
                    return;
                }
                if (i8 == 2) {
                    zzp(i2);
                    this.zzE.zze = 1;
                    return;
                } else if (i8 == 17) {
                    zzp(i2);
                    this.zzE.zze = 3;
                    return;
                } else if (i8 != 33) {
                    zzp(i2);
                    this.zzE.zze = -1;
                    return;
                } else {
                    zzp(i2);
                    this.zzE.zze = 5;
                    return;
                }
            case PRIVACY_URL_ERROR_VALUE:
                z2 = j == 1;
                zzp(i2);
                this.zzE.zzX = z2;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                this.zzV = zzy(j);
                return;
            case 159:
                zzp(i2);
                this.zzE.zzP = (int) j;
                return;
            case 176:
                zzp(i2);
                this.zzE.zzm = (int) j;
                return;
            case 179:
                zzq(i2);
                this.zzK = zzy(j);
                return;
            case 186:
                zzp(i2);
                this.zzE.zzn = (int) j;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                zzp(i2);
                this.zzE.zzd = (int) j;
                return;
            case 231:
                this.zzR = zzy(j);
                return;
            case 238:
                this.zzac = (int) j;
                return;
            case 241:
                zzq(i2);
                if (this.zzM == -1) {
                    this.zzM = j;
                    return;
                }
                return;
            case 247:
                zzq(i2);
                this.zzL = (int) j;
                return;
            case 251:
                this.zzad = true;
                return;
            case 16871:
                zzp(i2);
                this.zzE.zzd((int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j).length() + 30);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw zzat.zzb(sb3.toString(), null);
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j).length() + 33);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw zzat.zzb(sb4.toString(), null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j).length() + 30);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw zzat.zzb(sb5.toString(), null);
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(j).length() + 29);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw zzat.zzb(sb6.toString(), null);
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(j).length() + 36);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw zzat.zzb(sb7.toString(), null);
            case 21420:
                this.zzH = j + this.zzy;
                return;
            case 21432:
                int i9 = (int) j;
                zzp(i2);
                if (i9 == 0) {
                    this.zzE.zzx = 0;
                    return;
                }
                if (i9 == 1) {
                    this.zzE.zzx = 2;
                    return;
                } else if (i9 == 3) {
                    this.zzE.zzx = 1;
                    return;
                } else {
                    if (i9 != 15) {
                        return;
                    }
                    this.zzE.zzx = 3;
                    return;
                }
            case 21680:
                zzp(i2);
                this.zzE.zzp = (int) j;
                return;
            case 21682:
                zzp(i2);
                this.zzE.zzr = (int) j;
                return;
            case 21690:
                zzp(i2);
                this.zzE.zzq = (int) j;
                return;
            case 21930:
                z2 = j == 1;
                zzp(i2);
                this.zzE.zzW = z2;
                return;
            case 21938:
                zzp(i2);
                zzahj zzahjVar = this.zzE;
                zzahjVar.zzy = true;
                zzahjVar.zzo = (int) j;
                return;
            case 21998:
                zzp(i2);
                this.zzE.zzg = (int) j;
                return;
            case 22186:
                zzp(i2);
                this.zzE.zzS = j;
                return;
            case 22203:
                zzp(i2);
                this.zzE.zzT = j;
                return;
            case 25188:
                zzp(i2);
                this.zzE.zzQ = (int) j;
                return;
            case 30114:
                this.zzae = j;
                return;
            case 30321:
                int i10 = (int) j;
                zzp(i2);
                if (i10 == 0) {
                    this.zzE.zzs = 0;
                    return;
                }
                if (i10 == 1) {
                    this.zzE.zzs = 1;
                    return;
                } else if (i10 == 2) {
                    this.zzE.zzs = 2;
                    return;
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    this.zzE.zzs = 3;
                    return;
                }
            case 2352003:
                zzp(i2);
                this.zzE.zzf = (int) j;
                return;
            case 2807729:
                this.zzz = j;
                return;
            default:
                switch (i2) {
                    case 21945:
                        int i11 = (int) j;
                        zzp(i2);
                        if (i11 == 1) {
                            this.zzE.zzB = 2;
                            return;
                        } else {
                            if (i11 != 2) {
                                return;
                            }
                            this.zzE.zzB = 1;
                            return;
                        }
                    case 21946:
                        zzp(i2);
                        int iZzc = zzi.zzc((int) j);
                        if (iZzc != -1) {
                            this.zzE.zzA = iZzc;
                            return;
                        }
                        return;
                    case 21947:
                        zzp(i2);
                        this.zzE.zzy = true;
                        int iZzb = zzi.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzE.zzz = iZzb;
                            return;
                        }
                        return;
                    case 21948:
                        zzp(i2);
                        this.zzE.zzC = (int) j;
                        return;
                    case 21949:
                        zzp(i2);
                        this.zzE.zzD = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public final void zzj(int i2, double d8) throws zzat {
        if (i2 == 181) {
            zzp(i2);
            this.zzE.zzR = (int) d8;
            return;
        }
        if (i2 == 17545) {
            this.zzA = (long) d8;
            return;
        }
        switch (i2) {
            case 21969:
                zzp(i2);
                this.zzE.zzE = (float) d8;
                break;
            case 21970:
                zzp(i2);
                this.zzE.zzF = (float) d8;
                break;
            case 21971:
                zzp(i2);
                this.zzE.zzG = (float) d8;
                break;
            case 21972:
                zzp(i2);
                this.zzE.zzH = (float) d8;
                break;
            case 21973:
                zzp(i2);
                this.zzE.zzI = (float) d8;
                break;
            case 21974:
                zzp(i2);
                this.zzE.zzJ = (float) d8;
                break;
            case 21975:
                zzp(i2);
                this.zzE.zzK = (float) d8;
                break;
            case 21976:
                zzp(i2);
                this.zzE.zzL = (float) d8;
                break;
            case 21977:
                zzp(i2);
                this.zzE.zzM = (float) d8;
                break;
            case 21978:
                zzp(i2);
                this.zzE.zzN = (float) d8;
                break;
            default:
                switch (i2) {
                    case 30323:
                        zzp(i2);
                        this.zzE.zzt = (float) d8;
                        break;
                    case 30324:
                        zzp(i2);
                        this.zzE.zzu = (float) d8;
                        break;
                    case 30325:
                        zzp(i2);
                        this.zzE.zzv = (float) d8;
                        break;
                }
                break;
        }
    }

    @CallSuper
    public final void zzk(int i2, String str) throws zzat {
        if (i2 == 134) {
            zzp(i2);
            this.zzE.zzc = str;
            return;
        }
        if (i2 != 17026) {
            if (i2 == 21358) {
                zzp(i2);
                this.zzE.zzb = str;
                return;
            } else {
                if (i2 != 2274716) {
                    return;
                }
                zzp(i2);
                this.zzE.zze(str);
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.zzC = Objects.equals(str, "webm");
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw zzat.zzb(sb.toString(), null);
    }

    @CallSuper
    public final void zzl(int i2, int i8, zzadb zzadbVar) throws IOException {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20 = i2;
        int i21 = 2;
        int i22 = 1;
        int i23 = 0;
        if (i20 != 161 && i20 != 163) {
            if (i20 == 165) {
                if (this.zzT != 2) {
                    return;
                }
                zzahj zzahjVar = (zzahj) this.zzi.get(this.zzZ);
                if (this.zzac != 4 || !"V_VP9".equals(zzahjVar.zzc)) {
                    zzadbVar.zzf(i8);
                    return;
                }
                zzeg zzegVar = this.zzv;
                zzegVar.zza(i8);
                zzadbVar.zzc(zzegVar.zzi(), 0, i8);
                return;
            }
            if (i20 == 16877) {
                zzp(i2);
                zzahj zzahjVar2 = this.zzE;
                if (zzahjVar2.zzc() != 1685485123 && zzahjVar2.zzc() != 1685480259) {
                    zzadbVar.zzf(i8);
                    return;
                }
                byte[] bArr = new byte[i8];
                zzahjVar2.zzO = bArr;
                zzadbVar.zzc(bArr, 0, i8);
                return;
            }
            if (i20 == 16981) {
                zzp(i2);
                byte[] bArr2 = new byte[i8];
                this.zzE.zzi = bArr2;
                zzadbVar.zzc(bArr2, 0, i8);
                return;
            }
            if (i20 == 18402) {
                byte[] bArr3 = new byte[i8];
                zzadbVar.zzc(bArr3, 0, i8);
                zzp(i2);
                this.zzE.zzj = new zzael(1, bArr3, 0, 0);
                return;
            }
            if (i20 == 21419) {
                zzeg zzegVar2 = this.zzq;
                Arrays.fill(zzegVar2.zzi(), (byte) 0);
                zzadbVar.zzc(zzegVar2.zzi(), 4 - i8, i8);
                zzegVar2.zzh(0);
                this.zzG = (int) zzegVar2.zzz();
                return;
            }
            if (i20 == 25506) {
                zzp(i2);
                byte[] bArr4 = new byte[i8];
                this.zzE.zzk = bArr4;
                zzadbVar.zzc(bArr4, 0, i8);
                return;
            }
            if (i20 != 30322) {
                StringBuilder sb = new StringBuilder(String.valueOf(i20).length() + 15);
                sb.append("Unexpected id: ");
                sb.append(i20);
                throw zzat.zzb(sb.toString(), null);
            }
            zzp(i2);
            byte[] bArr5 = new byte[i8];
            this.zzE.zzw = bArr5;
            zzadbVar.zzc(bArr5, 0, i8);
            return;
        }
        int i24 = 8;
        if (this.zzT == 0) {
            zzahm zzahmVar = this.zzh;
            this.zzZ = (int) zzahmVar.zzb(zzadbVar, false, true, 8);
            this.zzaa = zzahmVar.zzc();
            this.zzV = -9223372036854775807L;
            this.zzT = 1;
            this.zzo.zza(0);
        }
        zzahj zzahjVar3 = (zzahj) this.zzi.get(this.zzZ);
        if (zzahjVar3 == null) {
            zzadbVar.zzf(i8 - this.zzaa);
            this.zzT = 0;
            return;
        }
        zzahjVar3.zzb();
        if (this.zzT == 1) {
            zzs(zzadbVar, 3);
            zzeg zzegVar3 = this.zzo;
            int i25 = (zzegVar3.zzi()[2] & 6) >> 1;
            if (i25 == 0) {
                this.zzX = 1;
                int[] iArrZzz = zzz(this.zzY, 1);
                this.zzY = iArrZzz;
                iArrZzz[0] = (i8 - this.zzaa) - 3;
            } else {
                zzs(zzadbVar, 4);
                int i26 = (zzegVar3.zzi()[3] & 255) + 1;
                this.zzX = i26;
                int[] iArrZzz2 = zzz(this.zzY, i26);
                this.zzY = iArrZzz2;
                if (i25 == 2) {
                    int i27 = (i8 - this.zzaa) - 4;
                    int i28 = this.zzX;
                    Arrays.fill(iArrZzz2, 0, i28, i27 / i28);
                } else {
                    if (i25 != 1) {
                        if (i25 != 3) {
                            throw zzat.zzb("Unexpected lacing value: 2", null);
                        }
                        int i29 = 0;
                        int i30 = 0;
                        int i31 = 4;
                        while (true) {
                            int i32 = this.zzX - 1;
                            if (i29 >= i32) {
                                i10 = i21;
                                i11 = i22;
                                i12 = i23;
                                this.zzY[i32] = ((i8 - this.zzaa) - i31) - i30;
                                break;
                            }
                            this.zzY[i29] = i23;
                            int i33 = i31 + 1;
                            zzs(zzadbVar, i33);
                            if (zzegVar3.zzi()[i31] == 0) {
                                throw zzat.zzb("No valid varint length mask found", null);
                            }
                            int i34 = i23;
                            while (true) {
                                if (i23 >= i24) {
                                    i13 = i21;
                                    i14 = i22;
                                    i15 = i24;
                                    j = 0;
                                    break;
                                }
                                i15 = i24;
                                int i35 = i22 << (7 - i23);
                                if ((zzegVar3.zzi()[i31] & i35) != 0) {
                                    i33 += i23;
                                    zzs(zzadbVar, i33);
                                    int i36 = i31 + 1;
                                    int i37 = zzegVar3.zzi()[i31] & 255 & (~i35);
                                    int i38 = i21;
                                    j = i37;
                                    i13 = i38;
                                    int i39 = i36;
                                    while (i39 < i33) {
                                        j = (j << i15) | ((long) (zzegVar3.zzi()[i39] & 255));
                                        i22 = i22;
                                        i39++;
                                        i23 = i23;
                                    }
                                    i14 = i22;
                                    int i40 = i23;
                                    if (i29 > 0) {
                                        j -= (1 << ((i40 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i23++;
                                    i24 = i15;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzY;
                            int i41 = (int) j;
                            if (i29 != 0) {
                                i41 += iArr[i29 - 1];
                            }
                            iArr[i29] = i41;
                            i30 += i41;
                            i29++;
                            i31 = i33;
                            i23 = i34;
                            i21 = i13;
                            i24 = i15;
                            i22 = i14;
                        }
                        throw zzat.zzb("EBML lacing sample size out of range.", null);
                    }
                    int i42 = 0;
                    int i43 = 0;
                    int i44 = 4;
                    while (true) {
                        i16 = this.zzX - 1;
                        if (i42 >= i16) {
                            break;
                        }
                        this.zzY[i42] = 0;
                        while (true) {
                            i17 = i44 + 1;
                            zzs(zzadbVar, i17);
                            int i45 = zzegVar3.zzi()[i44] & 255;
                            int[] iArr2 = this.zzY;
                            i18 = iArr2[i42] + i45;
                            iArr2[i42] = i18;
                            if (i45 != 255) {
                                break;
                            } else {
                                i44 = i17;
                            }
                        }
                        i43 += i18;
                        i42++;
                        i44 = i17;
                    }
                    this.zzY[i16] = ((i8 - this.zzaa) - i44) - i43;
                }
            }
            i10 = 2;
            i11 = 1;
            i12 = 0;
            this.zzU = this.zzR + zzy((zzegVar3.zzi()[i12] << 8) | (zzegVar3.zzi()[i11] & 255));
            if (zzahjVar3.zze == i11) {
                i19 = 1;
                this.zzab = i19;
                this.zzT = i10;
                this.zzW = i12;
                i9 = 163;
            } else {
                if (i20 != 163) {
                    i19 = i12;
                } else if ((zzegVar3.zzi()[i10] & 128) == 128) {
                    i20 = 163;
                    i19 = 1;
                } else {
                    i19 = i12;
                    i20 = 163;
                }
                this.zzab = i19;
                this.zzT = i10;
                this.zzW = i12;
                i9 = 163;
            }
        } else {
            i9 = 163;
        }
        if (i20 == i9) {
            while (true) {
                int i46 = this.zzW;
                if (i46 >= this.zzX) {
                    this.zzT = 0;
                    return;
                }
                int iZzt = zzt(zzadbVar, zzahjVar3, this.zzY[i46], false);
                zzahj zzahjVar4 = zzahjVar3;
                zzr(zzahjVar4, this.zzU + ((long) ((this.zzW * zzahjVar3.zzf) / 1000)), this.zzab, iZzt, 0);
                this.zzW++;
                zzahjVar3 = zzahjVar4;
            }
        } else {
            while (true) {
                int i47 = this.zzW;
                if (i47 >= this.zzX) {
                    return;
                }
                int[] iArr3 = this.zzY;
                iArr3[i47] = zzt(zzadbVar, zzahjVar3, iArr3[i47], true);
                this.zzW++;
            }
        }
    }

    public zzahk(zzahd zzahdVar, int i2, zzakg zzakgVar) {
        this.zzy = -1L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1;
        this.zzP = -1L;
        this.zzQ = -1L;
        this.zzR = -9223372036854775807L;
        this.zzap = zzahdVar;
        zzahdVar.zza(new zzahf(this, null));
        this.zzl = zzakgVar;
        this.zzI = new SparseArray();
        this.zzj = 1 == ((i2 & 1) ^ 1);
        this.zzk = (i2 & 2) == 0;
        this.zzh = new zzahm();
        this.zzi = new SparseArray();
        this.zzo = new zzeg(4);
        this.zzp = new zzeg(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzeg(4);
        this.zzm = new zzeg(zzfm.zza);
        this.zzn = new zzeg(4);
        this.zzr = new zzeg();
        this.zzs = new zzeg();
        this.zzt = new zzeg(8);
        this.zzu = new zzeg();
        this.zzv = new zzeg();
        this.zzY = new int[1];
        this.zzD = true;
    }

    public zzahk(zzakg zzakgVar, int i2) {
        this(new zzahd(), 0, zzakgVar);
    }
}
