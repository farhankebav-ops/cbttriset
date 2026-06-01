package com.pgl.ssdk.ces;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.work.WorkRequest;
import com.ironsource.Q6;
import com.pgl.ssdk.a0;
import com.pgl.ssdk.b0;
import com.pgl.ssdk.c0;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.d0;
import com.pgl.ssdk.e0;
import com.pgl.ssdk.e1;
import com.pgl.ssdk.f;
import com.pgl.ssdk.f0;
import com.pgl.ssdk.g0;
import com.pgl.ssdk.h0;
import com.pgl.ssdk.i0;
import com.pgl.ssdk.j0;
import com.pgl.ssdk.k0;
import com.pgl.ssdk.l0;
import com.pgl.ssdk.m0;
import com.pgl.ssdk.n0;
import com.pgl.ssdk.q0;
import com.pgl.ssdk.u;
import com.pgl.ssdk.v;
import com.pgl.ssdk.v0;
import com.pgl.ssdk.w;
import com.pgl.ssdk.w0;
import com.pgl.ssdk.x;
import com.pgl.ssdk.x0;
import com.pgl.ssdk.y;
import com.pgl.ssdk.z;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f10720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10721b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, Object> f10722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f10723d = 1;
    private static v0.a e;
    public Context g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10725i;
    private String j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f10726n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10724f = false;
    private String k = null;
    private String l = null;
    private boolean m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f10727o = false;
    public int p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10728q = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            z.b(z.b());
        }
    }

    /* JADX INFO: renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class RunnableC0211b implements Runnable {
        public RunnableC0211b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.c();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.a(b.this.g).a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.b(b.this.g);
        }
    }

    private b(Context context, String str) {
        this.g = context;
        this.h = str;
    }

    public static b a(Context context, String str, int i2, int i8, String str2) {
        if (f10720a == null) {
            synchronized (b.class) {
                try {
                    if (f10720a == null) {
                        if (context == null) {
                            context = b0.a().getApplicationContext();
                        }
                        if (context == null) {
                            f10723d = 4;
                            return null;
                        }
                        a(i2);
                        v0.a aVarB = v0.b(context, "nms");
                        if (aVarB != null) {
                            f10723d = aVarB.f10821a;
                            e = aVarB;
                            return null;
                        }
                        b bVar = new b(context, str);
                        f10720a = bVar;
                        bVar.f10725i = i8;
                        f10720a.j = str2;
                        f10720a.b(context);
                        f10720a.d(a(context));
                        z.c(context);
                        f10723d = 0;
                        q0.b(new a());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10720a;
    }

    private void b(Context context) {
        if (context == null || f10721b) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.h);
            com.pgl.ssdk.ces.a.meta(114, null, Integer.valueOf(this.f10725i));
            StringBuilder sb = new StringBuilder();
            sb.append(b0.h(context));
            com.pgl.ssdk.ces.a.meta(105, null, sb.toString());
            com.pgl.ssdk.ces.a.meta(152, null, b0.i(context));
            com.pgl.ssdk.ces.a.meta(153, null, b0.d(context));
            com.pgl.ssdk.ces.a.meta(106, null, b0.f(context));
            com.pgl.ssdk.ces.a.meta(107, null, b0.e(context));
            com.pgl.ssdk.ces.a.meta(108, null, b0.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, b0.d());
            com.pgl.ssdk.ces.a.meta(110, null, b0.c());
            com.pgl.ssdk.ces.a.meta(115, null, this.j);
            f10721b = true;
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        if (h() != null) {
            return h().h;
        }
        return null;
    }

    public static String d() {
        if (h() != null) {
            return h().k;
        }
        return null;
    }

    public static String f() {
        b bVarH = h();
        if (bVarH == null || !bVarH.m || TextUtils.isEmpty(bVarH.l)) {
            return null;
        }
        return bVarH.l;
    }

    public static int g() {
        return f10723d;
    }

    public static b h() {
        return f10720a;
    }

    public static v0.a i() {
        return e;
    }

    public long e() {
        return z.a(this.g);
    }

    public String j() {
        return z.c();
    }

    public String k() {
        return e1.a();
    }

    public void l() {
        this.f10727o = true;
        e1.a(this.g, this.h);
        a("Start", (Map<String, Object>) null);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10726n = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public synchronized void c(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.l)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.l = str;
            e1.b();
        }
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.k)) {
            this.k = str;
            com.pgl.ssdk.ces.a.meta(103, null, str);
            e1.b();
        }
    }

    public void b() {
        q0.b(new d());
    }

    private static String a(Context context) {
        String strA = w0.a(context, "iid");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String string = UUID.randomUUID().toString();
        w0.b(context, "iid", string);
        return string;
    }

    public static void a(int i2) {
        m0.a(i2);
    }

    public void a(String str, String str2, String str3, String str4) {
        b(str2);
        c(str4);
        try {
            l();
        } catch (Throwable unused) {
        }
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String str2 = (String) com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, this.g, new Object[]{str, bArr});
        if (!TextUtils.isEmpty(str2)) {
            map.put("X-Armors", str2);
        }
        return map;
    }

    public void a(String str, Map<String, Object> map) {
        try {
            long j = "Start".equals(str) ? WorkRequest.MIN_BACKOFF_MILLIS : 0L;
            Handler handlerB = q0.b();
            if (handlerB != null) {
                handlerB.postDelayed(new n0(this.g, Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, new Object[]{str, map}), j);
                if (this.f10728q && "Start".equals(str)) {
                    handlerB.postDelayed(new RunnableC0211b(), j * 2);
                }
            }
            a();
            z.a();
        } catch (Throwable unused) {
        }
    }

    public Object a(int i2, Object obj) {
        if (i2 == 123) {
            return f0.a(this.g);
        }
        if (i2 == 121) {
            return d0.a();
        }
        if (i2 == 122) {
            return d0.b();
        }
        if (i2 == 126) {
            return d0.b(this.g);
        }
        if (i2 == 128) {
            return d0.c(this.g);
        }
        if (i2 == 120) {
            return c0.c();
        }
        if (i2 == 124) {
            return g0.c(this.g);
        }
        if (i2 == 130) {
            return g0.a(this.g);
        }
        if (i2 == 145) {
            return h0.b(this.g);
        }
        if (i2 == 125) {
            return g0.b(this.g);
        }
        if (i2 == 129) {
            return e0.e(this.g);
        }
        if (i2 == 141) {
            return e0.d(this.g);
        }
        if (i2 == 134) {
            return j0.a(this.g).b();
        }
        if (i2 == 140) {
            return k0.a(this.g).e();
        }
        if (i2 == 144) {
            return k0.a(this.g).d();
        }
        if (i2 == 133) {
            return a(obj);
        }
        if (i2 == 135) {
            return v.f();
        }
        if (i2 == 201) {
            return d0.a(this.g);
        }
        if (i2 == 202) {
            return d0.c();
        }
        if (i2 == 236) {
            return x0.a((String) obj);
        }
        if (i2 == 142) {
            return b0.g(this.g);
        }
        if (i2 == 143) {
            return h0.a(this.g);
        }
        if (i2 == 146) {
            try {
                return v.b();
            } catch (Throwable unused) {
                return null;
            }
        }
        if (i2 == 147) {
            return Boolean.valueOf(b0.j(this.g));
        }
        if (i2 == 148) {
            return u.b(this.g);
        }
        if (i2 == 149) {
            return w.a(this.g);
        }
        if (i2 == 150) {
            return Integer.valueOf(x.a());
        }
        if (i2 == 151) {
            return w.c();
        }
        if (i2 == 161) {
            return Boolean.valueOf(v.g());
        }
        if (i2 == 169) {
            return Boolean.valueOf(a0.b(this.g));
        }
        if (i2 == 170) {
            return Integer.valueOf(y.b((String) obj));
        }
        if (i2 == 203) {
            return b0.b();
        }
        return null;
    }

    public void a(MotionEvent motionEvent) {
        y.a(motionEvent, this.g);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            try {
            } finally {
            }
            if (!map.isEmpty()) {
                try {
                    for (String str : map.keySet()) {
                        Object obj = map.get(str);
                        if (obj != null) {
                            switch (str.hashCode()) {
                                case -2021683300:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST)) {
                                        continue;
                                    } else if (obj instanceof String) {
                                        m0.a((String) obj);
                                    }
                                    break;
                                case -1195280656:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR)) {
                                        continue;
                                    } else if (obj instanceof String) {
                                        a((String) obj);
                                    }
                                    break;
                                case 156851746:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS)) {
                                        continue;
                                    } else if (obj instanceof Set) {
                                        try {
                                            Set set = (Set) obj;
                                            com.pgl.ssdk.ces.a.meta(165, null, Boolean.valueOf(set.contains("boot")));
                                            com.pgl.ssdk.ces.a.meta(166, null, Boolean.valueOf(set.contains("mnc")));
                                            com.pgl.ssdk.ces.a.meta(167, null, Boolean.valueOf(set.contains("mcc")));
                                            com.pgl.ssdk.ces.a.meta(168, null, Boolean.valueOf(set.contains(Q6.U0)));
                                            this.m = set.contains(Q6.U0);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    break;
                                case 398905722:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ)) {
                                        continue;
                                    } else if (obj instanceof String) {
                                        String strA = i0.a((String) obj);
                                        if (!TextUtils.isEmpty(strA)) {
                                            com.pgl.ssdk.ces.a.meta(159, null, strA);
                                        }
                                    }
                                    break;
                                case 485444716:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC)) {
                                        continue;
                                    } else if (obj instanceof String) {
                                        m0.b((String) obj);
                                    }
                                    break;
                                case 500804551:
                                    if (!str.equals(PglSSConfig.CUSTOMINFO_KEY_IPV6)) {
                                        continue;
                                    } else if (obj instanceof String) {
                                        String str2 = (String) obj;
                                        if (!TextUtils.isEmpty(str2)) {
                                            l0.a(str2);
                                        }
                                    }
                                    break;
                                default:
                                    continue;
                            }
                        }
                    }
                    if (f10722c == null) {
                        f10722c = new HashMap();
                    }
                    f10722c.putAll(map);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                int iHashCode = next.hashCode();
                if (iHashCode != -93508180) {
                    if (iHashCode != 449342513) {
                        if (iHashCode != 944591168) {
                            if (iHashCode == 1286849298 && next.equals("app_switch") && (obj instanceof Boolean)) {
                                this.f10728q = ((Boolean) obj).booleanValue();
                            }
                        } else if (next.equals("report_ratio") && (obj instanceof Integer) && ((Integer) obj).intValue() > 0) {
                            this.p = ((Integer) obj).intValue();
                        }
                    } else if (next.equals("craw_ratio") && (obj instanceof Integer) && ((Integer) obj).intValue() > 0) {
                        f.f10762b = ((Integer) obj).intValue();
                    }
                } else if (next.equals("autoctl_detect_enable") && (obj instanceof Boolean)) {
                    j0.f10769b = ((Boolean) obj).booleanValue();
                }
            }
        } catch (JSONException unused) {
        }
    }

    private String a(Object obj) {
        Map<String, Object> map;
        if (!(obj instanceof String) || !"Start".equals((String) obj) || (map = f10722c) == null || map.isEmpty()) {
            return "{}";
        }
        try {
            return new JSONObject(f10722c).toString();
        } catch (Exception unused) {
            return "{}";
        }
    }

    public void a() {
        q0.b(new c());
    }
}
