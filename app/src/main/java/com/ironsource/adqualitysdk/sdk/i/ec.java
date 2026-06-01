package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ec extends ee {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1941 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1942;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f1943 = {23826, 44132, 49139, 'S', 61735, 58022, 54384, '(', ')'};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f1944 = -7410242619478052491L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ee[] f1945;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1946;

    public ec(String str, List<ee> list, Cdo cdo) {
        super(cdo);
        this.f1946 = dy.m2174(str);
        ee[] eeVarArr = new ee[list.size()];
        this.f1945 = eeVarArr;
        list.toArray(eeVarArr);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2182(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1943[i8 + i9]) ^ (((long) i9) * f1944)) ^ ((long) c7));
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

    public boolean equals(Object obj) {
        f1941 = (f1942 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ec ecVar = (ec) obj;
        if (this.f1946.equals(ecVar.f1946)) {
            return Arrays.equals(this.f1945, ecVar.f1945);
        }
        int i2 = (f1941 + 1) % 128;
        f1942 = i2;
        int i8 = i2 + 61;
        f1941 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 82 / 0;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode;
        String str = this.f1946;
        if (str != null) {
            iHashCode = str.hashCode();
            f1941 = (f1942 + 9) % 128;
        } else {
            f1941 = (f1942 + 7) % 128;
            iHashCode = 0;
        }
        return Arrays.hashCode(this.f1945) + (iHashCode * 31);
    }

    public String toString() {
        f1942 = (f1941 + 9) % 128;
        String strMo2181 = mo2181(this.f1945);
        f1941 = (f1942 + 41) % 128;
        return strMo2181;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m2183() {
        int i2 = f1941 + 25;
        f1942 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1946;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final ee[] m2184() {
        int i2 = (f1941 + 75) % 128;
        f1942 = i2;
        ee[] eeVarArr = this.f1945;
        f1941 = (i2 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return eeVarArr;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final List<Object> m2185(ds dsVar, cp cpVar) {
        ArrayList arrayList = new ArrayList();
        ee[] eeVarArr = this.f1945;
        f1941 = (f1942 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        for (ee eeVar : eeVarArr) {
            f1942 = (f1941 + 103) % 128;
            arrayList.add(eeVar.m2189(dsVar, cpVar).m2153());
        }
        return arrayList;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public du mo2156(ds dsVar, cp cpVar) {
        f1941 = (f1942 + 75) % 128;
        List<Object> listM2185 = m2185(dsVar, cpVar);
        if (m2183().equals(m2182((char) (23934 - (ViewConfiguration.getTapTimeout() >> 16)), Drawable.resolveOpacity(0, 0) + 3, (-1) - ExpandableListView.getPackedPositionChild(0L)).intern())) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2182((char) KeyEvent.normalizeMetaState(0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 4, 2 - TextUtils.indexOf((CharSequence) "", '0', 0)).intern());
            sb.append(cpVar.m1723());
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(listM2185.get(0));
            k.m2863(string, sb2.toString());
            return new du(null);
        }
        try {
            du duVar = new du(((dq) dsVar.m2136(m2183())).m2081(dsVar, cpVar, listM2185));
            int i2 = f1941 + 27;
            f1942 = i2 % 128;
            if (i2 % 2 == 0) {
                return duVar;
            }
            throw null;
        } catch (Exception unused) {
            if (cpVar.m1732().m2353(m2183()) != null) {
                return cpVar.m1732().m2353(m2183()).m2081(dsVar, cpVar, listM2185).m2149(false);
            }
            de deVarM1719 = cpVar.m1719();
            String strM2183 = m2183();
            cpVar.m1720();
            return new du(deVarM1719.mo1636(cpVar, strM2183, listM2185, dsVar));
        }
    }

    /* JADX INFO: renamed from: ﻛ */
    public String mo2181(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1946);
        sb.append(m2182((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (ViewConfiguration.getEdgeSlop() >> 16) + 1, 7 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern());
        sb.append(ee.m2188(objArr));
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2182((char) (Process.myTid() >> 22), (KeyEvent.getMaxKeyCode() >> 16) + 1, 8 - (ViewConfiguration.getJumpTapTimeout() >> 16)));
        int i2 = f1942 + 27;
        f1941 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 13 / 0;
        }
        return strZ;
    }
}
