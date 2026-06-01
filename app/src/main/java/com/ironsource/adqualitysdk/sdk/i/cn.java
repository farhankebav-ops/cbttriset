package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cn {

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f1369 = 1;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f1370 = 0;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static short[] f1371 = null;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static byte[] f1372 = {72, 77, 69, 65, 122, 39, 57, 87, 63, 93, 61, -1, -7, 10, 1, -13, 9, -44, -50, -33, -42, -61, -33, -38, 0, 0, 0};

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1373 = 67;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1374 = 1504678843;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1375 = 967891582;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private List<cp> f1376 = new ArrayList();

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private dn f1377;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private de f1378;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Context f1379;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private bb f1380;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private dh f1381;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private bg f1382;

    public cn(Context context, dh dhVar, bb bbVar, de deVar, bg bgVar) {
        this.f1381 = dhVar;
        this.f1380 = bbVar;
        this.f1378 = deVar;
        this.f1382 = bgVar;
        this.f1379 = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private synchronized List<cp> m1647() {
        try {
            f1369 = (f1370 + 73) % 128;
            if (this.f1376 == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(this.f1376);
            int i2 = f1369 + 13;
            f1370 = i2 % 128;
            if (i2 % 2 == 0) {
                return arrayList;
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ List m1648(cn cnVar) {
        int i2 = (f1369 + 93) % 128;
        f1370 = i2;
        List<cp> list = cnVar.f1376;
        int i8 = i2 + 27;
        f1369 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 30 / 0;
        }
        return list;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private synchronized void m1651(dn dnVar) {
        try {
            int i2 = (f1369 + 23) % 128;
            f1370 = i2;
            if (dnVar != null) {
                int i8 = i2 + 83;
                f1369 = i8 % 128;
                if (i8 % 2 == 0) {
                    this.f1377 = dnVar;
                    throw null;
                }
                this.f1377 = dnVar;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        r0 = r0 + 41;
        com.ironsource.adqualitysdk.sdk.i.cn.f1370 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if ((r0 % 2) == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        r0 = 69 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r4 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r4 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        return new com.ironsource.adqualitysdk.sdk.i.hr(r4, m1652(r3.f1381.m1949().get(r4.m2074())));
     */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ironsource.adqualitysdk.sdk.i.hr m1652(com.ironsource.adqualitysdk.sdk.i.dp r4) {
        /*
            r3 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cn.f1369
            int r1 = r0 + 47
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.cn.f1370 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L13
            r1 = 33
            int r1 = r1 / 0
            if (r4 == 0) goto L2f
            goto L15
        L13:
            if (r4 == 0) goto L2f
        L15:
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r3.f1381
            java.util.Map r0 = r0.m1949()
            java.lang.String r1 = r4.m2074()
            java.lang.Object r0 = r0.get(r1)
            com.ironsource.adqualitysdk.sdk.i.dp r0 = (com.ironsource.adqualitysdk.sdk.i.dp) r0
            com.ironsource.adqualitysdk.sdk.i.hr r1 = new com.ironsource.adqualitysdk.sdk.i.hr
            com.ironsource.adqualitysdk.sdk.i.hr r0 = r3.m1652(r0)
            r1.<init>(r4, r0)
            return r1
        L2f:
            int r0 = r0 + 41
            int r4 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cn.f1370 = r4
            int r0 = r0 % 2
            r4 = 0
            if (r0 == 0) goto L3e
            r0 = 69
            int r0 = r0 / 0
        L3e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cn.m1652(com.ironsource.adqualitysdk.sdk.i.dp):com.ironsource.adqualitysdk.sdk.i.hr");
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public final Context m1655() {
        int i2 = f1370;
        Context context = this.f1379;
        int i8 = i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f1369 = i8 % 128;
        if (i8 % 2 != 0) {
            return context;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public final synchronized boolean m1656() {
        boolean zMo870;
        try {
            int i2 = f1370 + 17;
            f1369 = i2 % 128;
            if (i2 % 2 == 0) {
                zMo870 = this.f1382.mo870();
                int i8 = 70 / 0;
            } else {
                zMo870 = this.f1382.mo870();
            }
            int i9 = f1369 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f1370 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zMo870;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public final bb m1657() {
        int i2 = (f1370 + 15) % 128;
        f1369 = i2;
        bb bbVar = this.f1380;
        f1370 = (i2 + 115) % 128;
        return bbVar;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public final synchronized dn m1658() {
        dn dnVar;
        int i2 = (f1370 + 5) % 128;
        f1369 = i2;
        dnVar = this.f1377;
        f1370 = (i2 + 9) % 128;
        return dnVar;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final String m1659() {
        f1370 = (f1369 + 27) % 128;
        String strM1952 = this.f1381.m1952();
        f1370 = (f1369 + 79) % 128;
        return strM1952;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final String m1660() {
        f1370 = (f1369 + 73) % 128;
        String strM1954 = this.f1381.m1954();
        int i2 = f1370 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f1369 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 1 / 0;
        }
        return strM1954;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final String m1661() {
        f1369 = (f1370 + 45) % 128;
        String strM883 = this.f1382.m883();
        int i2 = f1370 + 9;
        f1369 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM883;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final String m1662() {
        f1369 = (f1370 + 101) % 128;
        String strM1661 = m1661();
        if (TextUtils.isEmpty(strM1661) || m1653((ViewConfiguration.getFadingEdgeLength() >> 16) - 60, (short) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (-967891571) - TextUtils.getOffsetAfter("", 0), (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (-1504678774) - (ViewConfiguration.getMinimumFlingVelocity() >> 16)).intern().equals(strM1661)) {
            return null;
        }
        f1369 = (f1370 + 95) % 128;
        if (m1653((-59) - (ViewConfiguration.getFadingEdgeLength() >> 16), (short) (KeyEvent.getDeadChar(0, 0) + 43), (ViewConfiguration.getWindowTouchSlop() >> 8) - 967891565, (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-1504678776) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern().equals(strM1661)) {
            return null;
        }
        return this.f1381.m1957(m1661());
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final String m1663() {
        f1369 = (f1370 + 7) % 128;
        String strMo881 = this.f1382.mo881();
        f1370 = (f1369 + 17) % 128;
        return strMo881;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m1667() {
        int i2 = f1370 + 7;
        f1369 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1381.m1955();
        }
        this.f1381.m1955();
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m1669() {
        f1370 = (f1369 + 95) % 128;
        String strM1953 = this.f1381.m1953();
        int i2 = f1370 + 37;
        f1369 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 36 / 0;
        }
        return strM1953;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m1654(dn dnVar) {
        int i2 = f1370 + 77;
        f1369 = i2 % 128;
        int i8 = i2 % 2;
        m1651(dnVar);
        if (i8 == 0) {
            throw null;
        }
        f1369 = (f1370 + 71) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m1664() {
        int i2 = f1370 + 111;
        f1369 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f1376.iterator();
            throw null;
        }
        Iterator<cp> it = this.f1376.iterator();
        while (it.hasNext()) {
            it.next().m1718();
        }
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cn.1
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                cn.m1648(cn.this).clear();
            }
        });
        f1370 = (f1369 + 89) % 128;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[PHI: r0
  0x0021: PHI (r0v5 com.ironsource.adqualitysdk.sdk.i.dn) = (r0v4 com.ironsource.adqualitysdk.sdk.i.dn), (r0v14 com.ironsource.adqualitysdk.sdk.i.dn) binds: [B:8:0x001f, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1665() {
        /*
            r10 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cn.f1369
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cn.f1370 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L19
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r10.f1381
            com.ironsource.adqualitysdk.sdk.i.dn r0 = r0.m1950()
            r2 = 38
            int r2 = r2 / r1
            if (r0 == 0) goto L2f
            goto L21
        L19:
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r10.f1381
            com.ironsource.adqualitysdk.sdk.i.dn r0 = r0.m1950()
            if (r0 == 0) goto L2f
        L21:
            r10.m1654(r0)
            com.ironsource.adqualitysdk.sdk.i.bg r2 = r10.f1382
            boolean r2 = r2.mo872()
            if (r2 == 0) goto L2f
            com.ironsource.adqualitysdk.sdk.i.jq.m2759(r0)
        L2f:
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r10.f1381
            com.ironsource.adqualitysdk.sdk.i.ds r0 = r0.m1951()
            float r2 = android.media.AudioTrack.getMinVolume()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            int r2 = r2 + (-55)
            int r1 = android.graphics.Color.green(r1)
            int r1 = (-74) - r1
            short r1 = (short) r1
            float r4 = android.view.ViewConfiguration.getScrollFriction()
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            r4 = -967891583(0xffffffffc64f2581, float:-13257.376)
            int r3 = r3 + r4
            long r4 = android.os.SystemClock.elapsedRealtime()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            int r4 = 1 - r4
            byte r4 = (byte) r4
            long r8 = android.os.SystemClock.uptimeMillis()
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            r6 = -1504678732(0xffffffffa6506cb4, float:-7.2311817E-16)
            int r6 = r6 - r5
            java.lang.String r1 = m1653(r2, r1, r3, r4, r6)
            java.lang.String r1 = r1.intern()
            com.ironsource.adqualitysdk.sdk.i.bg r2 = r10.f1382
            r0.m2135(r1, r2)
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r10.f1381
            java.util.Map r0 = r0.m1949()
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L7f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lbf
            int r1 = com.ironsource.adqualitysdk.sdk.i.cn.f1370
            int r1 = r1 + 117
            int r1 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.cn.f1369 = r1
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.ironsource.adqualitysdk.sdk.i.dh r2 = r10.f1381
            java.util.Map r2 = r2.m1949()
            java.lang.Object r1 = r2.get(r1)
            com.ironsource.adqualitysdk.sdk.i.dp r1 = (com.ironsource.adqualitysdk.sdk.i.dp) r1
            boolean r2 = r1.m2077()
            if (r2 != 0) goto Lbd
            com.ironsource.adqualitysdk.sdk.i.hr r7 = r10.m1652(r1)
            com.ironsource.adqualitysdk.sdk.i.cp r3 = new com.ironsource.adqualitysdk.sdk.i.cp
            com.ironsource.adqualitysdk.sdk.i.de r5 = r10.f1378
            com.ironsource.adqualitysdk.sdk.i.bg r6 = r10.f1382
            com.ironsource.adqualitysdk.sdk.i.dh r1 = r10.f1381
            com.ironsource.adqualitysdk.sdk.i.ds r8 = r1.m1951()
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r10.m1650(r3)
            goto L7f
        Lbd:
            r4 = r10
            goto L7f
        Lbf:
            r4 = r10
            com.ironsource.adqualitysdk.sdk.i.dh r0 = r4.f1381
            com.ironsource.adqualitysdk.sdk.i.bg r1 = r4.f1382
            r10.m1649(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cn.m1665():void");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m1668(String str, List<Object> list) {
        Iterator<cp> it;
        int i2 = f1369 + 95;
        f1370 = i2 % 128;
        if (i2 % 2 != 0) {
            it = m1647().iterator();
            int i8 = 24 / 0;
        } else {
            it = m1647().iterator();
        }
        while (it.hasNext()) {
            f1370 = (f1369 + 95) % 128;
            it.next().m1725(str, list);
            f1369 = (f1370 + 15) % 128;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1653(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1373;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1372;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f1375 + i8] + i10);
                    } else {
                        i11 = (short) (f1371[f1375 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1375 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1374);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1372;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1371;
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m1666() {
        int i2 = f1369 + 81;
        f1370 = i2 % 128;
        if (i2 % 2 != 0) {
            this.f1381.m1956();
            throw null;
        }
        String strM1956 = this.f1381.m1956();
        f1370 = (f1369 + 31) % 128;
        return strM1956;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private synchronized void m1649(dh dhVar, bg bgVar) {
        try {
            if (bgVar.mo870()) {
                f1369 = (f1370 + 99) % 128;
                for (cp cpVar : m1647()) {
                    dhVar.m1951().m2138().m2135(cpVar.m1732().m2352(), cpVar);
                }
            }
            f1369 = (f1370 + 93) % 128;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m1650(cp cpVar) {
        f1369 = (f1370 + 47) % 128;
        this.f1376.add(cpVar);
        f1370 = (f1369 + 87) % 128;
    }
}
