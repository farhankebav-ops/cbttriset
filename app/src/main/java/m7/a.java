package m7;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import l7.k0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f12997b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(n6.a.f13073a);
        kotlin.jvm.internal.k.d(bytes, "getBytes(...)");
        f12996a = bytes;
        f12997b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, LocationRequestCompat.PASSIVE_INTERVAL};
    }

    public static final long a(l7.j jVar, l7.m bytes, long j, long j3, int i2) {
        k0 k0Var;
        byte[] bArr;
        long j8 = j;
        long j9 = j3;
        kotlin.jvm.internal.k.e(bytes, "bytes");
        long j10 = i2;
        l7.b.e(bytes.d(), 0, j10);
        if (i2 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long j11 = 0;
        if (j8 < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("fromIndex < 0: ", j8).toString());
        }
        if (j8 > j9) {
            StringBuilder sbT = androidx.camera.core.processing.util.a.t("fromIndex > toIndex: ", j8, " > ");
            sbT.append(j9);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        long j12 = jVar.f12868b;
        if (j9 > j12) {
            j9 = j12;
        }
        if (j8 == j9 || (k0Var = jVar.f12867a) == null) {
            return -1L;
        }
        if (j12 - j8 >= j8) {
            while (true) {
                long j13 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j11;
                if (j13 > j8) {
                    break;
                }
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                j11 = j13;
            }
            byte[] bArrH = bytes.h();
            byte b8 = bArrH[0];
            long jMin = Math.min(j9, (jVar.f12868b - j10) + 1);
            while (j11 < jMin) {
                byte[] bArr2 = k0Var.f12872a;
                int iMin = (int) Math.min(k0Var.f12874c, (((long) k0Var.f12873b) + jMin) - j11);
                for (int i8 = (int) ((((long) k0Var.f12873b) + j8) - j11); i8 < iMin; i8++) {
                    if (bArr2[i8] == b8 && b(k0Var, i8 + 1, bArrH, 1, i2)) {
                        return ((long) (i8 - k0Var.f12873b)) + j11;
                    }
                }
                j11 += (long) (k0Var.f12874c - k0Var.f12873b);
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                j8 = j11;
            }
            return -1L;
        }
        while (j12 > j8) {
            k0Var = k0Var.g;
            kotlin.jvm.internal.k.b(k0Var);
            j12 -= (long) (k0Var.f12874c - k0Var.f12873b);
        }
        byte[] bArrH2 = bytes.h();
        byte b9 = bArrH2[0];
        byte[] bArr3 = bArrH2;
        long jMin2 = Math.min(j9, (jVar.f12868b - j10) + 1);
        while (j12 < jMin2) {
            byte[] bArr4 = k0Var.f12872a;
            int iMin2 = (int) Math.min(k0Var.f12874c, (((long) k0Var.f12873b) + jMin2) - j12);
            int i9 = (int) ((((long) k0Var.f12873b) + j8) - j12);
            while (i9 < iMin2) {
                if (bArr4[i9] == b9) {
                    bArr = bArr3;
                    if (b(k0Var, i9 + 1, bArr, 1, i2)) {
                        return ((long) (i9 - k0Var.f12873b)) + j12;
                    }
                } else {
                    bArr = bArr3;
                }
                i9++;
                bArr3 = bArr;
            }
            j12 += (long) (k0Var.f12874c - k0Var.f12873b);
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j8 = j12;
        }
        return -1L;
    }

    public static final boolean b(k0 k0Var, int i2, byte[] bArr, int i8, int i9) {
        int i10 = k0Var.f12874c;
        byte[] bArr2 = k0Var.f12872a;
        while (i8 < i9) {
            if (i2 == i10) {
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                byte[] bArr3 = k0Var.f12872a;
                bArr2 = bArr3;
                i2 = k0Var.f12873b;
                i10 = k0Var.f12874c;
            }
            if (bArr2[i2] != bArr[i8]) {
                return false;
            }
            i2++;
            i8++;
        }
        return true;
    }

    public static final String c(l7.j jVar, long j) throws EOFException {
        if (j > 0) {
            long j3 = j - 1;
            if (jVar.i(j3) == 13) {
                String strQ = jVar.q(j3, n6.a.f13073a);
                jVar.skip(2L);
                return strQ;
            }
        }
        String strQ2 = jVar.q(j, n6.a.f13073a);
        jVar.skip(1L);
        return strQ2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int d(l7.j r16, l7.f0 r17, boolean r18) {
        /*
            r0 = r17
            java.lang.String r1 = "options"
            kotlin.jvm.internal.k.e(r0, r1)
            r1 = r16
            l7.k0 r1 = r1.f12867a
            r2 = -1
            if (r1 != 0) goto L12
            if (r18 == 0) goto L11
            goto L5e
        L11:
            return r2
        L12:
            byte[] r3 = r1.f12872a
            int r4 = r1.f12873b
            int r5 = r1.f12874c
            int[] r0 = r0.f12849b
            r6 = 0
            r8 = r1
            r9 = r2
            r7 = r6
        L1e:
            int r10 = r7 + 1
            r11 = r0[r7]
            int r7 = r7 + 2
            r10 = r0[r10]
            if (r10 == r2) goto L29
            r9 = r10
        L29:
            if (r8 != 0) goto L2c
            goto L5c
        L2c:
            r10 = 0
            if (r11 >= 0) goto L74
            int r11 = r11 * (-1)
            int r12 = r11 + r7
        L33:
            int r11 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r13 = r7 + 1
            r7 = r0[r7]
            if (r4 == r7) goto L40
            goto L7e
        L40:
            if (r13 != r12) goto L44
            r4 = 1
            goto L45
        L44:
            r4 = r6
        L45:
            if (r11 != r5) goto L64
            kotlin.jvm.internal.k.b(r8)
            l7.k0 r3 = r8.f12876f
            kotlin.jvm.internal.k.b(r3)
            int r5 = r3.f12873b
            byte[] r7 = r3.f12872a
            int r8 = r3.f12874c
            if (r3 != r1) goto L60
            if (r4 == 0) goto L5c
            r3 = r7
            r7 = r10
            goto L67
        L5c:
            if (r18 == 0) goto L7e
        L5e:
            r0 = -2
            return r0
        L60:
            r15 = r7
            r7 = r3
            r3 = r15
            goto L67
        L64:
            r7 = r8
            r8 = r5
            r5 = r11
        L67:
            if (r4 == 0) goto L6f
            r4 = r0[r13]
            r15 = r8
            r8 = r7
            r7 = r15
            goto La0
        L6f:
            r4 = r5
            r5 = r8
            r8 = r7
            r7 = r13
            goto L33
        L74:
            int r12 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r13 = r7 + r11
        L7c:
            if (r7 != r13) goto L7f
        L7e:
            return r9
        L7f:
            r14 = r0[r7]
            if (r4 != r14) goto Laa
            int r7 = r7 + r11
            r4 = r0[r7]
            if (r12 != r5) goto L9e
            l7.k0 r8 = r8.f12876f
            kotlin.jvm.internal.k.b(r8)
            int r3 = r8.f12873b
            byte[] r5 = r8.f12872a
            int r7 = r8.f12874c
            if (r8 != r1) goto L9a
            r8 = r5
            r5 = r3
            r3 = r8
            r8 = r10
            goto La0
        L9a:
            r15 = r5
            r5 = r3
            r3 = r15
            goto La0
        L9e:
            r7 = r5
            r5 = r12
        La0:
            if (r4 < 0) goto La3
            return r4
        La3:
            int r4 = -r4
            r15 = r7
            r7 = r4
            r4 = r5
            r5 = r15
            goto L1e
        Laa:
            int r7 = r7 + 1
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.a.d(l7.j, l7.f0, boolean):int");
    }
}
