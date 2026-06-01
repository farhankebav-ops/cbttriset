package com.ironsource.adqualitysdk.sdk.i;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hx<T> extends da implements ci, hs<T> {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2408 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2409;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private hs f2410;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Map f2411;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private Collection f2412;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Object f2413;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Field f2414;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char[] f2407 = {144, 297, 300, 290, 279, 289, 296, 290, 'M', 154, 152, 154, 151, 144, 148, 152, 153, 133, 135, 154, 'B', 137, '{', 'r', 131, '3', 'f', 'l', '`', 'W', 'h', '7', 'g', 'j', 's', 'p', '[', '^', 'l', 'f', 'f', 'd'};

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int[] f2406 = {-1174510426, -701681626, 1333245612, 1244200790, 1098207783, 293684225, 1667433755, 322818964, 1922638686, -1704600261, 910457552, 1634534306, 146591051, -997609333, -750438280, -1586326265, 1289045300, -1151404293};

    public hx(Field field, Object obj, hs hsVar) {
        this.f2414 = field;
        this.f2413 = obj;
        this.f2410 = hsVar;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private hs m2404() {
        int i2 = f2409 + 109;
        f2408 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f2410;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private Object m2405() {
        int i2 = f2409;
        Object obj = this.f2413;
        int i8 = i2 + 23;
        f2408 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 97 / 0;
        }
        return obj;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private Collection m2406() {
        int i2 = f2408 + 67;
        f2409 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2412;
        }
        int i8 = 38 / 0;
        return this.f2412;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private Map m2407() {
        int i2 = (f2409 + 97) % 128;
        f2408 = i2;
        Map map = this.f2411;
        f2409 = (i2 + 93) % 128;
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if ((r0 % 2) == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r4.f2412 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r4.f2412 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        r0 = r0 + 45;
        com.ironsource.adqualitysdk.sdk.i.hx.f2408 = r0 % 128;
     */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m2409() {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.hx.f2409
            int r1 = r0 + 109
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.hx.f2408 = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L15
            java.util.Collection r1 = r4.f2412
            r3 = 34
            int r3 = r3 / r2
            if (r1 == 0) goto L27
            goto L19
        L15:
            java.util.Collection r1 = r4.f2412
            if (r1 == 0) goto L27
        L19:
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.hx.f2408 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L25
            r0 = 1
            return r0
        L25:
            r0 = 0
            throw r0
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hx.m2409():boolean");
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2410(T t3) {
        if (m2411()) {
            f2408 = (f2409 + 63) % 128;
            try {
                this.f2414.set(this.f2413, t3);
                int i2 = f2409 + 15;
                f2408 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean m2413() {
        int i2 = f2408 + 81;
        int i8 = i2 % 128;
        f2409 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f2411 == null) {
            return false;
        }
        int i9 = i8 + 45;
        f2408 = i9 % 128;
        return i9 % 2 != 0;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.hs
    /* JADX INFO: renamed from: ｋ */
    public final T mo2359() {
        if (m2411()) {
            f2408 = (f2409 + 89) % 128;
            try {
                return (T) this.f2414.get(this.f2413);
            } catch (Exception unused) {
                return null;
            }
        }
        if (!m2409()) {
            f2408 = (f2409 + 57) % 128;
            if (!m2413()) {
                return null;
            }
        }
        return (T) this.f2413;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.hs
    /* JADX INFO: renamed from: ﾇ */
    public final Field mo2360() {
        Field field;
        int i2 = f2408 + 19;
        int i8 = i2 % 128;
        f2409 = i8;
        if (i2 % 2 != 0) {
            field = this.f2414;
            int i9 = 97 / 0;
        } else {
            field = this.f2414;
        }
        int i10 = i8 + 19;
        f2408 = i10 % 128;
        if (i10 % 2 != 0) {
            return field;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2408(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2406.clone();
                d.f1665 = 0;
                while (true) {
                    int i8 = d.f1665;
                    if (i8 < iArr.length) {
                        int i9 = iArr[i8];
                        char c7 = (char) (i9 >> 16);
                        cArr[0] = c7;
                        char c8 = (char) i9;
                        cArr[1] = c8;
                        char c9 = (char) (iArr[i8 + 1] >> 16);
                        cArr[2] = c9;
                        char c10 = (char) iArr[i8 + 1];
                        cArr[3] = c10;
                        d.f1663 = (c7 << 16) + c8;
                        d.f1666 = (c9 << 16) + c10;
                        d.m1895(iArr2);
                        for (int i10 = 0; i10 < 16; i10++) {
                            int i11 = d.f1663 ^ iArr2[i10];
                            d.f1663 = i11;
                            int iM1894 = d.m1894(i11) ^ d.f1666;
                            int i12 = d.f1663;
                            d.f1663 = iM1894;
                            d.f1666 = i12;
                        }
                        int i13 = d.f1663;
                        int i14 = d.f1666;
                        d.f1663 = i14;
                        d.f1666 = i13;
                        int i15 = i13 ^ iArr2[16];
                        d.f1666 = i15;
                        int i16 = i14 ^ iArr2[17];
                        d.f1663 = i16;
                        cArr[0] = (char) (i16 >>> 16);
                        cArr[1] = (char) i16;
                        cArr[2] = (char) (i15 >>> 16);
                        cArr[3] = (char) i15;
                        d.m1895(iArr2);
                        int i17 = d.f1665;
                        cArr2[i17 << 1] = cArr[0];
                        cArr2[(i17 << 1) + 1] = cArr[1];
                        cArr2[(i17 << 1) + 2] = cArr[2];
                        cArr2[(i17 << 1) + 3] = cArr[3];
                        d.f1665 = i17 + 2;
                    } else {
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
    
        if ((r7 % 2) != 0) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo886(java.lang.String r7, java.util.List<java.lang.Object> r8, com.ironsource.adqualitysdk.sdk.i.ch r9) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hx.mo886(java.lang.String, java.util.List, com.ironsource.adqualitysdk.sdk.i.ch):java.lang.Object");
    }

    public hx(Collection collection, Object obj, hs hsVar) {
        this.f2412 = collection;
        this.f2413 = obj;
        this.f2410 = hsVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean m2411() {
        int i2 = f2409;
        f2408 = (i2 + 15) % 128;
        if (this.f2414 == null) {
            return false;
        }
        int i8 = i2 + 79;
        f2408 = i8 % 128;
        return i8 % 2 != 0;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2412(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f2407, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    public hx(Map map, Object obj, hs hsVar) {
        this.f2411 = map;
        this.f2413 = obj;
        this.f2410 = hsVar;
    }
}
