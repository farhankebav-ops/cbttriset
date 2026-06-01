package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class du {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1877 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1879;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Object f1881;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f1882;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f1883;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean f1884;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f1880 = {'\"'};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static long f1878 = -8285889348279831271L;

    public du(Object obj) {
        this.f1881 = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0066, code lost:
    
        return com.google.android.gms.ads.internal.client.a.z(r0, m2145((char) android.widget.ExpandableListView.getPackedPositionType(0), 1 - android.text.TextUtils.getTrimmedLength(""), (android.os.SystemClock.currentThreadTimeMillis() > (-1) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1) ? 0 : -1)) - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r7.f1881);
        r0 = r0.toString();
        com.ironsource.adqualitysdk.sdk.i.du.f1879 = (com.ironsource.adqualitysdk.sdk.i.du.f1877 + 3) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x007d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if ((r7.f1881 instanceof java.lang.String) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if ((r7.f1881 instanceof java.lang.String) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(m2145((char) ((android.os.Process.getThreadPriority(0) + 20) >> 6), (android.view.ViewConfiguration.getGlobalActionKeyTimeout() > 0 ? 1 : (android.view.ViewConfiguration.getGlobalActionKeyTimeout() == 0 ? 0 : -1)), android.widget.ExpandableListView.getPackedPositionGroup(0)).intern());
        r0.append(r7.f1881);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r7 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.du.f1877
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.du.f1879 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L17
            java.lang.Object r0 = r7.f1881
            boolean r0 = r0 instanceof java.lang.String
            r2 = 92
            int r2 = r2 / r1
            if (r0 == 0) goto L67
            goto L1d
        L17:
            java.lang.Object r0 = r7.f1881
            boolean r0 = r0 instanceof java.lang.String
            if (r0 == 0) goto L67
        L1d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = android.os.Process.getThreadPriority(r1)
            int r1 = r1 + 20
            int r1 = r1 >> 6
            char r1 = (char) r1
            long r2 = android.view.ViewConfiguration.getGlobalActionKeyTimeout()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            int r3 = android.widget.ExpandableListView.getPackedPositionGroup(r4)
            java.lang.String r1 = m2145(r1, r2, r3)
            java.lang.String r1 = r1.intern()
            r0.append(r1)
            java.lang.Object r1 = r7.f1881
            r0.append(r1)
            int r1 = android.widget.ExpandableListView.getPackedPositionType(r4)
            char r1 = (char) r1
            java.lang.String r2 = ""
            int r2 = android.text.TextUtils.getTrimmedLength(r2)
            int r2 = 1 - r2
            long r3 = android.os.SystemClock.currentThreadTimeMillis()
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            int r3 = r3 + (-1)
            java.lang.String r1 = m2145(r1, r2, r3)
            java.lang.String r0 = com.google.android.gms.ads.internal.client.a.z(r0, r1)
            return r0
        L67:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Object r1 = r7.f1881
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = com.ironsource.adqualitysdk.sdk.i.du.f1877
            int r1 = r1 + 3
            int r1 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.du.f1879 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.du.toString():java.lang.String");
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final du m2146() {
        int i2 = f1877;
        this.f1883 = true;
        f1879 = (i2 + 11) % 128;
        return this;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final du m2147() {
        int i2 = f1879 + 25;
        f1877 = i2 % 128;
        this.f1882 = i2 % 2 != 0;
        return this;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final boolean m2148() {
        int i2 = (f1879 + 65) % 128;
        f1877 = i2;
        boolean z2 = this.f1883;
        f1879 = (i2 + 67) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2150() {
        Object obj = this.f1881;
        if (obj == null) {
            int i2 = f1879 + 99;
            f1877 = i2 % 128;
            return i2 % 2 == 0;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return false;
            }
            int i8 = f1877 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
            f1879 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 72 / 0;
            }
            return true;
        }
        if (obj instanceof Long) {
            int i10 = f1879 + 87;
            f1877 = i10 % 128;
            if (i10 % 2 != 0 ? ((Long) obj).longValue() == 0 : ((Long) obj).longValue() == 0) {
                return false;
            }
            f1879 = (f1877 + 27) % 128;
            return true;
        }
        if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return false;
            }
            f1877 = (f1879 + 113) % 128;
            return true;
        }
        if (!(obj instanceof String)) {
            return true;
        }
        int i11 = f1877 + 39;
        f1879 = i11 % 128;
        if (i11 % 2 == 0) {
            return !TextUtils.isEmpty((String) obj);
        }
        TextUtils.isEmpty((String) obj);
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final boolean m2151() {
        int i2 = f1877;
        int i8 = i2 + 33;
        f1879 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        boolean z2 = this.f1884;
        int i9 = i2 + 11;
        f1879 = i9 % 128;
        if (i9 % 2 == 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final Number m2152() {
        Number number;
        int i2;
        int i8 = f1877;
        int i9 = (i8 + 65) % 128;
        f1879 = i9;
        Object obj = this.f1881;
        if (obj instanceof Integer) {
            int i10 = i9 + 69;
            f1877 = i10 % 128;
            if (i10 % 2 != 0) {
                return (Integer) obj;
            }
            number = (Integer) obj;
            i2 = 82;
        } else {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (!(obj instanceof Double)) {
                return null;
            }
            number = (Double) obj;
            int i11 = i8 + 65;
            f1879 = i11 % 128;
            if (i11 % 2 == 0) {
                return number;
            }
            i2 = 95;
        }
        int i12 = i2 / 0;
        return number;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final Object m2153() {
        int i2 = f1877 + 107;
        int i8 = i2 % 128;
        f1879 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        Object obj = this.f1881;
        int i9 = i8 + 45;
        f1877 = i9 % 128;
        if (i9 % 2 != 0) {
            return obj;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final boolean m2154() {
        int i2 = f1877 + 73;
        int i8 = i2 % 128;
        f1879 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        boolean z2 = this.f1882;
        int i9 = i8 + 75;
        f1877 = i9 % 128;
        if (i9 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final du m2149(boolean z2) {
        int i2 = f1877;
        this.f1884 = z2;
        f1879 = (i2 + 45) % 128;
        return this;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2145(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1880[i8 + i9]) ^ (((long) i9) * f1878)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
