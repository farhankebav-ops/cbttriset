package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagp {
    public static final zzagm zza = zzagn.zza;

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.google.android.gms.internal.ads.zzap zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzagm r13, com.google.android.gms.internal.ads.zzaga r14) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zza(byte[], int, com.google.android.gms.internal.ads.zzagm, com.google.android.gms.internal.ads.zzaga):com.google.android.gms.internal.ads.zzap");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean zzb(com.google.android.gms.internal.ads.zzeg r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r1.zzg()
        L8:
            int r3 = r1.zzd()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r23
            if (r3 < r5) goto La7
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r1.zzB()     // Catch: java.lang.Throwable -> L22
            long r8 = r1.zzz()     // Catch: java.lang.Throwable -> L22
            int r10 = r1.zzt()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lab
        L25:
            int r7 = r1.zzx()     // Catch: java.lang.Throwable -> L22
            int r8 = r1.zzx()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L22
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            goto La7
        L3b:
            r7 = 4
            if (r0 != r7) goto L6b
            if (r24 != 0) goto L6b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4b
        L48:
            r4 = r6
            goto La7
        L4b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L6b:
            if (r0 != r7) goto L7b
            r3 = r10 & 64
            if (r3 == 0) goto L72
            goto L73
        L72:
            r4 = r6
        L73:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L8d
        L7b:
            if (r0 != r3) goto L8b
            r3 = r10 & 32
            if (r3 == 0) goto L83
            r3 = r4
            goto L84
        L83:
            r3 = r6
        L84:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L89
            goto L8d
        L89:
            r4 = r6
            goto L8d
        L8b:
            r3 = r6
            r4 = r3
        L8d:
            if (r4 == 0) goto L91
            int r3 = r3 + 4
        L91:
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L22
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L97
            goto L48
        L97:
            int r3 = r1.zzd()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L22
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La1
            goto L48
        La1:
            int r3 = (int) r8     // Catch: java.lang.Throwable -> L22
            r1.zzk(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        La7:
            r1.zzh(r2)
            return r4
        Lab:
            r1.zzh(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zzb(com.google.android.gms.internal.ads.zzeg, int, int, boolean):boolean");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02a7 A[Catch: all -> 0x013e, Exception -> 0x0262, OutOfMemoryError -> 0x0267, TRY_LEAVE, TryCatch #7 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0185, B:110:0x01b7, B:118:0x01e3, B:132:0x0218, B:134:0x022f, B:158:0x0293, B:160:0x02a7, B:162:0x02ae, B:174:0x02ef, B:170:0x02cf, B:172:0x02e9, B:187:0x032b, B:194:0x036e, B:197:0x03a3, B:200:0x03b4, B:201:0x03bc, B:203:0x03c2, B:205:0x03c9, B:206:0x03cd, B:214:0x03ee, B:218:0x0419, B:220:0x0424, B:221:0x045a, B:222:0x0467, B:224:0x046d, B:226:0x0474, B:227:0x0478, B:231:0x048e, B:239:0x04a1, B:241:0x04cb, B:242:0x04da, B:243:0x04e5), top: B:256:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02cf A[Catch: all -> 0x013e, Exception -> 0x02c9, OutOfMemoryError -> 0x02cc, TryCatch #7 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0185, B:110:0x01b7, B:118:0x01e3, B:132:0x0218, B:134:0x022f, B:158:0x0293, B:160:0x02a7, B:162:0x02ae, B:174:0x02ef, B:170:0x02cf, B:172:0x02e9, B:187:0x032b, B:194:0x036e, B:197:0x03a3, B:200:0x03b4, B:201:0x03bc, B:203:0x03c2, B:205:0x03c9, B:206:0x03cd, B:214:0x03ee, B:218:0x0419, B:220:0x0424, B:221:0x045a, B:222:0x0467, B:224:0x046d, B:226:0x0474, B:227:0x0478, B:231:0x048e, B:239:0x04a1, B:241:0x04cb, B:242:0x04da, B:243:0x04e5), top: B:256:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0506  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzagq zzc(int r33, com.google.android.gms.internal.ads.zzeg r34, boolean r35, int r36, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzagm r37) {
        /*
            Method dump skipped, instruction units count: 1357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zzc(int, com.google.android.gms.internal.ads.zzeg, boolean, int, com.google.android.gms.internal.ads.zzagm):com.google.android.gms.internal.ads.zzagq");
    }

    private static zzgpe zzd(byte[] bArr, int i2, int i8) {
        if (i8 >= bArr.length) {
            return zzgpe.zzj("");
        }
        int i9 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        int iZzh = zzh(bArr, i8, i2);
        while (i8 < iZzh) {
            zzgpbVar.zzf(new String(bArr, i8, iZzh - i8, zzf(i2)));
            i8 = zzj(i2) + iZzh;
            iZzh = zzh(bArr, i8, i2);
        }
        zzgpe zzgpeVarZzi = zzgpbVar.zzi();
        return zzgpeVarZzi.isEmpty() ? zzgpe.zzj("") : zzgpeVarZzi;
    }

    private static int zze(zzeg zzegVar, int i2) {
        byte[] bArrZzi = zzegVar.zzi();
        int iZzg = zzegVar.zzg();
        int i8 = iZzg;
        while (true) {
            int i9 = i8 + 1;
            if (i9 >= iZzg + i2) {
                return i2;
            }
            if ((bArrZzi[i8] & 255) == 255 && bArrZzi[i9] == 0) {
                System.arraycopy(bArrZzi, i8 + 2, bArrZzi, i9, (i2 - (i8 - iZzg)) - 2);
                i2--;
            }
            i8 = i9;
        }
    }

    private static Charset zzf(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    private static String zzg(int i2, int i8, int i9, int i10, int i11) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11));
    }

    private static int zzh(byte[] bArr, int i2, int i8) {
        int iZzi = zzi(bArr, i2);
        if (i8 == 0 || i8 == 3) {
            return iZzi;
        }
        while (true) {
            int length = bArr.length;
            if (iZzi >= length - 1) {
                return length;
            }
            int i9 = iZzi + 1;
            if ((iZzi - i2) % 2 == 0 && bArr[i9] == 0) {
                return iZzi;
            }
            iZzi = zzi(bArr, i9);
        }
    }

    private static int zzi(byte[] bArr, int i2) {
        while (true) {
            int length = bArr.length;
            if (i2 >= length) {
                return length;
            }
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
    }

    private static int zzj(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static byte[] zzk(byte[] bArr, int i2, int i8) {
        return i8 <= i2 ? zzep.zzb : Arrays.copyOfRange(bArr, i2, i8);
    }

    private static String zzl(byte[] bArr, int i2, int i8, Charset charset) {
        return (i8 <= i2 || i8 > bArr.length) ? "" : new String(bArr, i2, i8 - i2, charset);
    }
}
