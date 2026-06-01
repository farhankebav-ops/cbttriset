package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.vungle.ads.internal.protos.Sdk;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacz {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE, 88200, 176400, 352800, 12000, 24000, 48000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(int i2) {
        if (i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368) {
            return 1;
        }
        if (i2 == 1683496997 || i2 == 622876772) {
            return 2;
        }
        if (i2 == 1078008818 || i2 == -233094848) {
            return 3;
        }
        return (i2 == 1908687592 || i2 == -398277519) ? 4 : 0;
    }

    public static zzv zzb(byte[] bArr, @Nullable String str, @Nullable String str2, int i2, String str3, @Nullable zzq zzqVar) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(60);
        int i8 = zzb[zzefVarZzi.zzj(6)];
        int i9 = zzc[zzefVarZzi.zzj(4)];
        int iZzj = zzefVarZzi.zzj(5);
        int i10 = iZzj >= 29 ? -1 : (zzd[iZzj] * 1000) / 2;
        zzefVarZzi.zzh(10);
        int i11 = i8 + (zzefVarZzi.zzj(2) > 0 ? 1 : 0);
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzl("video/mp2t");
        zztVar.zzm("audio/vnd.dts");
        zztVar.zzh(i10);
        zztVar.zzE(i11);
        zztVar.zzF(i9);
        zztVar.zzq(null);
        zztVar.zze(str2);
        zztVar.zzg(i2);
        return zztVar.zzM();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzc(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4e
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r3]
        L1f:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r1 = r1 | r2
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5c
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 8
            r7 = r7[r2]
        L35:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r0 = r0 | r1
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5c
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 9
            r7 = r7[r2]
            goto L35
        L4e:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r4]
            goto L1f
        L5c:
            if (r0 == 0) goto L62
            int r7 = r7 * 16
            int r7 = r7 / 14
        L62:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacz.zzc(byte[]):int");
    }

    public static zzacy zzd(byte[] bArr) throws zzat {
        int iZzj;
        int i2;
        long jZzt;
        int i8;
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(40);
        int iZzj2 = zzefVarZzi.zzj(2);
        boolean zZzi = zzefVarZzi.zzi();
        int i9 = true != zZzi ? 16 : 20;
        zzefVarZzi.zzh(true != zZzi ? 8 : 12);
        int iZzj3 = zzefVarZzi.zzj(i9) + 1;
        boolean zZzi2 = zzefVarZzi.zzi();
        int iZzj4 = -1;
        int i10 = 0;
        if (zZzi2) {
            iZzj = zzefVarZzi.zzj(2);
            int iZzj5 = zzefVarZzi.zzj(3) + 1;
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(36);
            }
            int iZzj6 = zzefVarZzi.zzj(3) + 1;
            int iZzj7 = zzefVarZzi.zzj(3) + 1;
            if (iZzj6 != 1 || iZzj7 != 1) {
                throw zzat.zzc("Multiple audio presentations or assets not supported");
            }
            int i11 = iZzj2 + 1;
            int iZzj8 = zzefVarZzi.zzj(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                if (((iZzj8 >> i12) & 1) == 1) {
                    zzefVarZzi.zzh(8);
                }
            }
            int i13 = iZzj5 * 512;
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(2);
                int iZzj9 = (zzefVarZzi.zzj(2) + 1) << 2;
                int iZzj10 = zzefVarZzi.zzj(2) + 1;
                while (i10 < iZzj10) {
                    zzefVarZzi.zzh(iZzj9);
                    i10++;
                }
            }
            i10 = i13;
        } else {
            iZzj = -1;
        }
        zzefVarZzi.zzh(i9);
        zzefVarZzi.zzh(12);
        if (zZzi2) {
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(4);
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(24);
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzo(zzefVarZzi.zzj(10) + 1);
            }
            zzefVarZzi.zzh(5);
            i2 = zze[zzefVarZzi.zzj(4)];
            iZzj4 = zzefVarZzi.zzj(8) + 1;
        } else {
            i2 = -2147483647;
        }
        int i14 = i2;
        if (zZzi2) {
            if (iZzj == 0) {
                i8 = 32000;
            } else if (iZzj == 1) {
                i8 = DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE;
            } else {
                if (iZzj != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj).length() + 51);
                    sb.append("Unsupported reference clock code in DTS HD header: ");
                    sb.append(iZzj);
                    throw zzat.zzb(sb.toString(), null);
                }
                i8 = 48000;
            }
            jZzt = zzep.zzt(i10, 1000000L, i8, RoundingMode.DOWN);
        } else {
            jZzt = -9223372036854775807L;
        }
        return new zzacy("audio/vnd.dts.hd;profile=lbr", iZzj4, i14, iZzj3, jZzt, 0, null);
    }

    public static int zze(byte[] bArr) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(42);
        return zzefVarZzi.zzj(true != zzefVarZzi.zzi() ? 8 : 12) + 1;
    }

    public static zzacy zzf(byte[] bArr, AtomicInteger atomicInteger) throws zzat {
        long jZzt;
        int iZzj;
        AtomicInteger atomicInteger2;
        int i2;
        int i8;
        zzef zzefVarZzi = zzi(bArr);
        int iZzj2 = zzefVarZzi.zzj(32);
        int iZzh = zzh(zzefVarZzi, zzf, true);
        int i9 = iZzh + 1;
        char c7 = iZzj2 == 1078008818 ? (char) 1 : (char) 0;
        if (c7 == 0) {
            jZzt = -9223372036854775807L;
            iZzj = -2147483647;
        } else {
            if (!zzefVarZzi.zzi()) {
                throw zzat.zzc("Only supports full channel mask-based audio presentation");
            }
            int i10 = iZzh - 1;
            if (((bArr[iZzh] & 255) | ((char) (bArr[i10] << 8))) != zzep.zzI(bArr, 0, i10, 65535)) {
                throw zzat.zzb("CRC check failed", null);
            }
            int iZzj3 = zzefVarZzi.zzj(2);
            if (iZzj3 == 0) {
                i2 = 512;
            } else if (iZzj3 == 1) {
                i2 = 480;
            } else {
                if (iZzj3 != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 51);
                    sb.append("Unsupported base duration index in DTS UHD header: ");
                    sb.append(iZzj3);
                    throw zzat.zzb(sb.toString(), null);
                }
                i2 = 384;
            }
            int iZzj4 = zzefVarZzi.zzj(3) + 1;
            int iZzj5 = zzefVarZzi.zzj(2);
            if (iZzj5 == 0) {
                i8 = 32000;
            } else if (iZzj5 == 1) {
                i8 = DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE;
            } else {
                if (iZzj5 != 2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 48);
                    sb2.append("Unsupported clock rate index in DTS UHD header: ");
                    sb2.append(iZzj5);
                    throw zzat.zzb(sb2.toString(), null);
                }
                i8 = 48000;
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(36);
            }
            iZzj = (1 << zzefVarZzi.zzj(2)) * i8;
            jZzt = zzep.zzt(i2 * iZzj4, 1000000L, i8, RoundingMode.DOWN);
        }
        int i11 = iZzj;
        long j = jZzt;
        int iZzh2 = 0;
        for (char c8 = 0; c8 < c7; c8 = 1) {
            iZzh2 += zzh(zzefVarZzi, zzg, true);
        }
        for (int i12 = 0; i12 <= 0; i12++) {
            if (c7 != 0) {
                atomicInteger2 = atomicInteger;
                atomicInteger2.set(zzh(zzefVarZzi, zzh, true));
            } else {
                atomicInteger2 = atomicInteger;
            }
            iZzh2 += atomicInteger2.get() != 0 ? zzh(zzefVarZzi, zzi, true) : 0;
        }
        return new zzacy("audio/vnd.dts.uhd;profile=p2", 2, i11, i9 + iZzh2, j, 0, null);
    }

    public static int zzg(byte[] bArr) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(32);
        return zzh(zzefVarZzi, zzj, true) + 1;
    }

    private static int zzh(zzef zzefVar, int[] iArr, boolean z2) {
        int i2 = 0;
        for (int i8 = 0; i8 < 3 && zzefVar.zzi(); i8++) {
            i2++;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            i9 += 1 << iArr[i10];
        }
        return zzefVar.zzj(iArr[i2]) + i9;
    }

    private static zzef zzi(byte[] bArr) {
        byte b8 = bArr[0];
        if (b8 == 127 || b8 == 100 || b8 == 64 || b8 == 113) {
            return new zzef(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b9 = bArrCopyOf[0];
        if (b9 == -2 || b9 == -1 || b9 == 37 || b9 == -14 || b9 == -24) {
            for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                byte b10 = bArrCopyOf[i2];
                int i8 = i2 + 1;
                bArrCopyOf[i2] = bArrCopyOf[i8];
                bArrCopyOf[i8] = b10;
            }
        }
        int length = bArrCopyOf.length;
        zzef zzefVar = new zzef(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzef zzefVar2 = new zzef(bArrCopyOf, length);
            while (zzefVar2.zzc() >= 16) {
                zzefVar2.zzh(2);
                zzefVar.zzp(zzefVar2.zzj(14), 14);
            }
        }
        zzefVar.zzb(bArrCopyOf, bArrCopyOf.length);
        return zzefVar;
    }
}
