package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfm {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i2) {
        int i8;
        synchronized (zzc) {
            int i9 = 0;
            int i10 = 0;
            while (i9 < i2) {
                while (true) {
                    try {
                        if (i9 >= i2 - 2) {
                            i9 = i2;
                            break;
                        }
                        int i11 = i9 + 1;
                        if (bArr[i9] == 0 && bArr[i11] == 0 && bArr[i9 + 2] == 3) {
                            break;
                        }
                        i9 = i11;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i9 < i2) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i10) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i10] = i9;
                    i9 += 3;
                    i10++;
                }
            }
            i8 = i2 - i10;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = zzd[i14] - i12;
                System.arraycopy(bArr, i12, bArr, i13, i15);
                int i16 = i13 + i15;
                int i17 = i16 + 1;
                bArr[i16] = 0;
                i13 = i16 + 2;
                bArr[i17] = 0;
                i12 += i15 + 3;
            }
            System.arraycopy(bArr, i12, bArr, i13, i8 - i13);
        }
        return i8;
    }

    public static int zzb(zzv zzvVar) {
        String str = zzvVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            return 1;
        }
        return (Objects.equals(str, MimeTypes.VIDEO_H265) || zzas.zze(zzvVar.zzk, MimeTypes.VIDEO_H265)) ? 2 : 0;
    }

    public static boolean zzc(byte[] bArr, int i2, int i8, zzv zzvVar) {
        String str = zzvVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            byte b8 = bArr[4];
            if (((b8 & 96) >> 5) != 0) {
                return true;
            }
            int i9 = b8 & 31;
            return (i9 == 1 || i9 == 9 || i9 == 14) ? false : true;
        }
        if (Objects.equals(str, MimeTypes.VIDEO_H265)) {
            zzfa zzfaVarZzk = zzk(new zzfn(bArr, 4, i8 + 4));
            int i10 = zzfaVarZzk.zza;
            if (i10 == 35) {
                return false;
            }
            return (i10 <= 14 && i10 % 2 == 0 && zzfaVarZzk.zzc == zzvVar.zzF + (-1)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0235 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016c A[PHI: r2
  0x016c: PHI (r2v6 int) = (r2v4 int), (r2v3 int) binds: [B:87:0x0171, B:83:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016f A[PHI: r2
  0x016f: PHI (r2v4 int) = (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v7 int) binds: [B:74:0x0156, B:76:0x015a, B:78:0x015e, B:80:0x0162, B:82:0x0166, B:84:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzfl zzd(byte[] r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfm.zzd(byte[], int, int):com.google.android.gms.internal.ads.zzfl");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x05f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzfj zze(byte[] r35, int r36, int r37) {
        /*
            Method dump skipped, instruction units count: 2155
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfm.zze(byte[], int, int):com.google.android.gms.internal.ads.zzfj");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzfg zzf(byte[] r36, int r37, int r38, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzfj r39) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfm.zzf(byte[], int, int, com.google.android.gms.internal.ads.zzfj):com.google.android.gms.internal.ads.zzfg");
    }

    public static zzfk zzg(byte[] bArr, int i2, int i8) {
        zzfn zzfnVar = new zzfn(bArr, 4, i8);
        int iZzg = zzfnVar.zzg();
        int iZzg2 = zzfnVar.zzg();
        zzfnVar.zza();
        return new zzfk(iZzg, iZzg2, zzfnVar.zze());
    }

    public static int zzh(byte[] bArr, int i2, int i8, boolean[] zArr) {
        int i9 = i8 - i2;
        zzgmd.zzh(i9 >= 0);
        if (i9 == 0) {
            return i8;
        }
        if (zArr[0]) {
            zzi(zArr);
            return i2 - 3;
        }
        if (i9 > 1 && zArr[1] && bArr[i2] == 1) {
            zzi(zArr);
            return i2 - 2;
        }
        if (i9 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
            zzi(zArr);
            return i2 - 1;
        }
        int i10 = i8 - 1;
        int i11 = i2 + 2;
        while (i11 < i10) {
            byte b8 = bArr[i11];
            if ((b8 & 254) == 0) {
                int i12 = i11 - 2;
                if (bArr[i12] == 0 && bArr[i11 - 1] == 0 && b8 == 1) {
                    zzi(zArr);
                    return i12;
                }
                i11 = i12;
            }
            i11 += 3;
        }
        zArr[0] = i9 <= 2 ? !(i9 != 2 ? !(zArr[1] && bArr[i10] == 1) : !(zArr[2] && bArr[i8 + (-2)] == 0 && bArr[i10] == 1)) : bArr[i8 + (-3)] == 0 && bArr[i8 + (-2)] == 0 && bArr[i10] == 1;
        zArr[1] = i9 <= 1 ? zArr[2] && bArr[i10] == 0 : bArr[i8 + (-2)] == 0 && bArr[i10] == 0;
        zArr[2] = bArr[i10] == 0;
        return i8;
    }

    public static void zzi(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    @Nullable
    public static String zzj(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            byte[] bArr = (byte[]) list.get(i2);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i8 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                int i9 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i9 >= length2) {
                        break;
                    }
                    int iZzh = zzh(bArr, i9, length2, zArr);
                    if (iZzh != length2) {
                        zzgpbVar.zzf(Integer.valueOf(iZzh));
                    }
                    i9 = iZzh + 3;
                }
                zzgpe zzgpeVarZzi = zzgpbVar.zzi();
                for (int i10 = 0; i10 < zzgpeVarZzi.size(); i10++) {
                    if (((Integer) zzgpeVarZzi.get(i10)).intValue() + 3 < length) {
                        zzfn zzfnVar = new zzfn(bArr, ((Integer) zzgpeVarZzi.get(i10)).intValue() + 3, length);
                        zzfa zzfaVarZzk = zzk(zzfnVar);
                        if (zzfaVarZzk.zza == 33 && zzfaVarZzk.zzb == 0) {
                            zzfnVar.zzb(4);
                            int iZzf = zzfnVar.zzf(3);
                            zzfnVar.zza();
                            zzfb zzfbVarZzl = zzl(zzfnVar, true, iZzf, null);
                            return zzdd.zzb(zzfbVarZzl.zza, zzfbVarZzl.zzb, zzfbVarZzl.zzc, zzfbVarZzl.zzd, zzfbVarZzl.zze, zzfbVarZzl.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    private static zzfa zzk(zzfn zzfnVar) {
        zzfnVar.zza();
        return new zzfa(zzfnVar.zzf(6), zzfnVar.zzf(6), zzfnVar.zzf(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzfb zzl(com.google.android.gms.internal.ads.zzfn r18, boolean r19, int r20, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzfb r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 8
            r6 = 0
            if (r19 == 0) goto L41
            r2 = 2
            int r2 = r0.zzf(r2)
            boolean r7 = r0.zze()
            r8 = 5
            int r8 = r0.zzf(r8)
            r9 = r6
            r10 = r9
        L1e:
            r11 = 32
            if (r9 >= r11) goto L2e
            boolean r11 = r0.zze()
            if (r11 == 0) goto L2b
            r11 = 1
            int r11 = r11 << r9
            r10 = r10 | r11
        L2b:
            int r9 = r9 + 1
            goto L1e
        L2e:
            r9 = r6
        L2f:
            if (r9 >= r3) goto L3a
            int r11 = r0.zzf(r5)
            r4[r9] = r11
            int r9 = r9 + 1
            goto L2f
        L3a:
            r12 = r2
        L3b:
            r16 = r4
            r13 = r7
            r14 = r8
            r15 = r10
            goto L55
        L41:
            if (r2 == 0) goto L4f
            int r3 = r2.zza
            boolean r7 = r2.zzb
            int r8 = r2.zzc
            int r10 = r2.zzd
            int[] r4 = r2.zze
            r12 = r3
            goto L3b
        L4f:
            r16 = r4
            r12 = r6
            r13 = r12
            r14 = r13
            r15 = r14
        L55:
            int r17 = r0.zzf(r5)
            r2 = r6
        L5a:
            if (r6 >= r1) goto L6f
            boolean r3 = r0.zze()
            if (r3 == 0) goto L64
            int r2 = r2 + 88
        L64:
            boolean r3 = r0.zze()
            if (r3 == 0) goto L6c
            int r2 = r2 + 8
        L6c:
            int r6 = r6 + 1
            goto L5a
        L6f:
            r0.zzb(r2)
            if (r1 <= 0) goto L79
            int r5 = r5 - r1
            int r5 = r5 + r5
            r0.zzb(r5)
        L79:
            com.google.android.gms.internal.ads.zzfb r11 = new com.google.android.gms.internal.ads.zzfb
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfm.zzl(com.google.android.gms.internal.ads.zzfn, boolean, int, com.google.android.gms.internal.ads.zzfb):com.google.android.gms.internal.ads.zzfb");
    }

    private static int zzm(int i2, int i8, int i9, int i10) {
        int i11 = 2;
        if (i8 != 1 && i8 != 2) {
            i11 = 1;
        }
        return i2 - ((i9 + i10) * i11);
    }

    private static int zzn(int i2, int i8, int i9, int i10) {
        return i2 - ((i9 + i10) * (i8 == 1 ? 2 : 1));
    }

    private static void zzo(zzfn zzfnVar) {
        int iZzg = zzfnVar.zzg() + 1;
        zzfnVar.zzb(8);
        for (int i2 = 0; i2 < iZzg; i2++) {
            zzfnVar.zzg();
            zzfnVar.zzg();
            zzfnVar.zza();
        }
        zzfnVar.zzb(20);
    }
}
