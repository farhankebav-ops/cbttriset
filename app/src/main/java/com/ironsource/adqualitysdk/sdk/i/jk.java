package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.kc;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jk {

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static jk f2832;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Map<String, e> f2833;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private Map<String, e> f2835 = new HashMap();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Handler f2834 = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum e {
        f2842,
        f2841,
        f2843;


        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f2839 = 1;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f2840;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static long f2844;

        static {
            m2739();
            int i2 = f2840 + 87;
            f2839 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        public static e valueOf(String str) {
            f2840 = (f2839 + 85) % 128;
            e eVar = (e) Enum.valueOf(e.class, str);
            f2839 = (f2840 + 109) % 128;
            return eVar;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static e[] valuesCustom() {
            f2840 = (f2839 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            e[] eVarArr = (e[]) values().clone();
            int i2 = f2840 + 89;
            f2839 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 6 / 0;
            }
            return eVarArr;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2737(String str, int i2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (i.f2441) {
                try {
                    char[] cArrM2497 = i.m2497(f2844, cArr, i2);
                    i.f2442 = 4;
                    while (true) {
                        int i8 = i.f2442;
                        if (i8 < cArrM2497.length) {
                            i.f2443 = i8 - 4;
                            cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2844));
                            i.f2442 = i8 + 1;
                        } else {
                            str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static void m2739() {
            f2844 = 1218391058915700659L;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static e m2738(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int iHashCode = str.hashCode();
            if (iHashCode == 3642) {
                if (!str.equals(m2737("淣\u2e6a涑膵\uf7f5䏼", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1).intern())) {
                    return null;
                }
                int i2 = f2839 + 97;
                f2840 = i2 % 128;
                if (i2 % 2 != 0) {
                    return null;
                }
                return f2843;
            }
            if (iHashCode != 96921) {
                if (iHashCode == 109261 && str.equals(m2737("嵊鼟崤ッ빓폺\ue15b", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1).intern())) {
                    return f2842;
                }
                return null;
            }
            if (!str.equals(m2737("黿樣麞엤ᨽ啺䔷", (ViewConfiguration.getTouchSlop() >> 8) + 1).intern())) {
                return null;
            }
            int i8 = (f2839 + 81) % 128;
            f2840 = i8;
            e eVar = f2841;
            f2839 = (i8 + 105) % 128;
            return eVar;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private synchronized Map<String, e> m2730() {
        try {
            if (this.f2833 == null) {
                this.f2833 = new HashMap();
                JSONObject jSONObjectMo536 = aq.m530().mo536();
                if (jSONObjectMo536 != null) {
                    this.f2833 = kc.m2902(jSONObjectMo536, new kc.b<e>() { // from class: com.ironsource.adqualitysdk.sdk.i.jk.4
                        @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
                        /* JADX INFO: renamed from: ﻐ */
                        public final /* synthetic */ e mo595(JSONObject jSONObject, String str) {
                            return e.m2738(jSONObject.optString(str));
                        }
                    });
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2833;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private synchronized e m2731(Activity activity) {
        if (activity != null) {
            String name = activity.getClass().getName();
            if (m2732().containsKey(name)) {
                return m2732().get(name);
            }
            if (m2730().containsKey(name)) {
                return m2730().get(name);
            }
        }
        return e.m2738(aq.m530().mo538());
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static synchronized jk m2733() {
        try {
            if (f2832 == null) {
                f2832 = new jk();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2832;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized boolean m2736(Activity activity) {
        return e.f2841 == m2731(activity);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m2734(final String str, final e eVar) {
        this.f2834.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jk.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                synchronized (jk.this) {
                    jk.this.f2835.put(str, eVar);
                }
            }
        });
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized boolean m2735(Activity activity) {
        return e.f2843 == m2731(activity);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private synchronized Map<String, e> m2732() {
        return new HashMap(this.f2835);
    }
}
