package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.hp;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ht extends hp {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private Class f2380;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private int f2381;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private List<Class> f2382;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private List<Class> f2383 = new ArrayList();

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private boolean f2384;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private int f2385;

    public ht() {
        mo2312();
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public final int m2367() {
        return this.f2381;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final List<Class> m2368() {
        return this.f2383;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final int m2369() {
        return this.f2385;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final List<Class> m2370() {
        return this.f2382;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final Class m2371() {
        return this.f2380;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final boolean m2372() {
        return this.f2384;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends hp.c implements ci {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static short[] f2386 = null;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f2388 = 0;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f2389 = 1;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2391 = -1690345766;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f2392 = 1430619798;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2393 = 93;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ht f2394 = new ht();

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static byte[] f2390 = {-10, 5, 35, -41, 27, -17, -11, -9, 37, -26, -4, -3, 1, 15, 19, -34, 15, -14, 14, -11, -9, 37, -31, 1, 13, -15, 15, -8, 12, -17, 17, 17, -36, 15, -14, 1, 13, -15, 15, -8, 12, -17, 17, 17, -22, 23, -35, 13, 3, -11, -8, 39, -38, 15, -14, 1, -17, 9, 9, -11, 37, -38, 27, -31, 1, 13, -4, 3, -3, 5, -11, 34, -23, 0, 3, 1, -17, 9, 9, -21, 51, -42, 27, -31, 1, 13, -4, 3, -3, 5, -11, 34, -23, 0, 3, 0, 18, -11, 9, -15, 13, -11, -5, 34, -27, 37, -31, 5, -15, 17, -4, -14, 0, 0, 0, 0, 0, 0};

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static long f2387 = 774576766549373894L;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private e m2374(int i2) {
            f2388 = (f2389 + 13) % 128;
            this.f2394.f2385 = i2;
            int i8 = f2389 + 99;
            f2388 = i8 % 128;
            if (i8 % 2 == 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private e m2376(int i2) {
            ht htVar;
            int i8;
            int i9 = f2388 + 55;
            f2389 = i9 % 128;
            if (i9 % 2 == 0) {
                htVar = this.f2394;
                i8 = i2 ^ htVar.f2374;
            } else {
                htVar = this.f2394;
                i8 = i2 | htVar.f2374;
            }
            htVar.f2374 = i8;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private e m2380(boolean z2) {
            int i2 = f2388 + 31;
            f2389 = i2 % 128;
            if (i2 % 2 != 0) {
                this.f2394.f2384 = z2;
                return this;
            }
            this.f2394.f2384 = z2;
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private e m2381(int i2) {
            int i8 = f2388;
            int i9 = i8 + 81;
            f2389 = i9 % 128;
            int i10 = i9 % 2;
            ht htVar = this.f2394;
            htVar.f2375 = i2 | htVar.f2375;
            f2389 = (i8 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private e m2384(Class cls) {
            int i2 = f2389 + 57;
            f2388 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f2394.f2380 = cls;
                return this;
            }
            this.f2394.f2380 = cls;
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private e m2377(boolean z2, int i2) {
            int i8 = f2388 + 85;
            f2389 = i8 % 128;
            if (i8 % 2 != 0) {
                ht htVar = this.f2394;
                htVar.f2372 = z2;
                htVar.f2373 = i2;
                return this;
            }
            ht htVar2 = this.f2394;
            htVar2.f2372 = z2;
            htVar2.f2373 = i2;
            throw null;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private e m2375(Class cls) {
            f2389 = (f2388 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
            this.f2394.f2383.add(cls);
            f2388 = (f2389 + 65) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private e m2382(List<Class> list) {
            int i2 = f2389 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
            f2388 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f2394.f2382 = list;
                f2388 = (f2389 + 113) % 128;
                return this;
            }
            this.f2394.f2382 = list;
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private e m2383(int i2) {
            f2388 = (f2389 + 57) % 128;
            this.f2394.f2381 = i2;
            f2388 = (f2389 + 97) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private e m2373() {
            f2389 = (f2388 + 41) % 128;
            this.f2394.mo2312();
            int i2 = f2388 + 41;
            f2389 = i2 % 128;
            if (i2 % 2 != 0) {
                return this;
            }
            throw null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0122, code lost:
        
            if ((r1 % 2) != 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0134, code lost:
        
            return m2381(((java.lang.Integer) com.ironsource.adqualitysdk.sdk.i.da.m1896(r18, 0, java.lang.Integer.class)).intValue());
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01ed, code lost:
        
            return m2383(((java.lang.Integer) com.ironsource.adqualitysdk.sdk.i.da.m1896(r18, 0, java.lang.Integer.class)).intValue());
         */
        @Override // com.ironsource.adqualitysdk.sdk.i.ci
        /* JADX INFO: renamed from: ﾒ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object mo886(java.lang.String r17, java.util.List<java.lang.Object> r18, com.ironsource.adqualitysdk.sdk.i.ch r19) {
            /*
                Method dump skipped, instruction units count: 700
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ht.e.mo886(java.lang.String, java.util.List, com.ironsource.adqualitysdk.sdk.i.ch):java.lang.Object");
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ht m2378() {
            int i2 = f2388 + 1;
            int i8 = i2 % 128;
            f2389 = i8;
            if (i2 % 2 == 0) {
                throw null;
            }
            ht htVar = this.f2394;
            int i9 = i8 + 35;
            f2388 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 21 / 0;
            }
            return htVar;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2379(int i2, short s7, int i8, byte b8, int i9) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f2393;
                    int i11 = i2 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f2390;
                        if (bArr != null) {
                            i11 = (byte) (bArr[f2391 + i8] + i10);
                        } else {
                            i11 = (short) (f2386[f2391 + i8] + i10);
                        }
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i8 + i11) - 2) + f2391 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f2392);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f2390;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f2386;
                                int i14 = n.f2984;
                                n.f2984 = i14 - 1;
                                n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                            }
                            sb.append(n.f2981);
                            n.f2980 = n.f2981;
                            n.f2983++;
                        }
                    }
                    string = sb.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return string;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m2385(String str, int i2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (j.f2671) {
                try {
                    j.f2669 = i2;
                    char[] cArr2 = new char[cArr.length];
                    j.f2670 = 0;
                    while (true) {
                        int i8 = j.f2670;
                        if (i8 < cArr.length) {
                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2387);
                            j.f2670++;
                        } else {
                            str2 = new String(cArr2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.hp
    /* JADX INFO: renamed from: ﻐ */
    public final void mo2312() {
        super.mo2312();
        this.f2380 = null;
        this.f2385 = 0;
        this.f2384 = true;
        this.f2383.clear();
        this.f2382 = null;
        this.f2381 = -1;
    }
}
