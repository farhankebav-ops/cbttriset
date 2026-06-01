package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class R6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final B7 f7546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f7547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f7548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f7549d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7550a;

        public a(Context context) {
            this.f7550a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                R6.this.e(this.f7550a);
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            R6.this.f7548c.set(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile R6 f7552a = new R6(0);

        private b() {
        }
    }

    public /* synthetic */ R6(int i2) {
        this();
    }

    private void d(Context context) {
        if (context == null || this.f7549d.getAndSet(true)) {
            return;
        }
        a("auid", this.f7546a.d(context));
        a(Q6.B, this.f7546a.l());
        a(Q6.f7468t, this.f7546a.q());
        a(Q6.F, this.f7546a.f());
        a(Q6.p, this.f7546a.L(context));
        String adQualitySdkVersion = AdQualityBridge.getAdQualitySdkVersion();
        if (!TextUtils.isEmpty(adQualitySdkVersion)) {
            a(Q6.B1, adQualitySdkVersion);
        }
        String strI = this.f7546a.i();
        if (strI != null) {
            a(Q6.G, strI.replaceAll("[^0-9/.]", ""));
            a(Q6.J, strI);
        }
        a(Q6.f7426a, String.valueOf(this.f7546a.e()));
        String strU = this.f7546a.u(context);
        if (!TextUtils.isEmpty(strU)) {
            a(Q6.P0, strU);
        }
        String strE = C1.e(context);
        if (!TextUtils.isEmpty(strE)) {
            a(Q6.f7455o, strE);
        }
        String strR = this.f7546a.r(context);
        if (!TextUtils.isEmpty(strR)) {
            a(Q6.f7474v0, strR);
        }
        a(Q6.f7439f, context.getPackageName());
        a("mem", String.valueOf(this.f7546a.q(context)));
        a(Q6.f7430b0, Q6.f7445j0);
        a(Q6.f7433c0, Long.valueOf(C1.f(context)));
        a(Q6.f7427a0, Long.valueOf(C1.d(context)));
        a(Q6.f7435d, C1.b(context));
        a(Q6.O, Integer.valueOf(C2228a4.f(context)));
        a(Q6.Y, C2228a4.g(context));
        a("stid", C2291dd.c(context));
        a(Q6.H, "android");
        a(Q6.f7484z, this.f7546a.t());
        a("mThreshold", this.f7546a.a(this.f7546a.n(context)));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            String strI = this.f7546a.I(context);
            if (!TextUtils.isEmpty(strI)) {
                a(Q6.U0, strI);
            }
            String strB = this.f7546a.b(context);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            a(Q6.f7465s, Boolean.valueOf(Boolean.parseBoolean(strB)));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void f(Context context) {
        if (context == null) {
            return;
        }
        a(context);
        String strY = this.f7546a.y(context);
        if (!TextUtils.isEmpty(strY)) {
            a(Q6.K0, strY);
        } else if (a(Q6.K0)) {
            b(Q6.K0);
        }
        a("idfi", this.f7546a.i(context));
        String strC = this.f7546a.c(context);
        if (!TextUtils.isEmpty(strC)) {
            a(Q6.f7460q, strC.toUpperCase(Locale.getDefault()));
        }
        a(Q6.f7463r, this.f7546a.A(context));
        String strD = this.f7546a.d();
        if (!TextUtils.isEmpty(strD)) {
            a("tz", strD);
        }
        String strB = C2246b4.b(context);
        if (!TextUtils.isEmpty(strB) && !strB.equals("none")) {
            a(Q6.j, strB);
        }
        String strD2 = C2246b4.d(context);
        if (!TextUtils.isEmpty(strD2)) {
            a(Q6.k, strD2);
        }
        a("vpn", Boolean.valueOf(C2246b4.e(context)));
        String strG = this.f7546a.G(context);
        if (!TextUtils.isEmpty(strG)) {
            a("icc", strG);
        }
        int iS = this.f7546a.s(context);
        if (iS >= 0) {
            a(Q6.f7446j1, Integer.valueOf(iS));
        }
        a(Q6.f7447k1, this.f7546a.v(context));
        a(Q6.f7449l1, this.f7546a.F(context));
        a(Q6.h0, Float.valueOf(this.f7546a.E(context)));
        a(Q6.m, String.valueOf(this.f7546a.h()));
        a(Q6.R, Integer.valueOf(this.f7546a.k()));
        a(Q6.Q, Integer.valueOf(this.f7546a.c()));
        a(Q6.X0, String.valueOf(this.f7546a.a()));
        a(Q6.f7441g1, String.valueOf(this.f7546a.m()));
        a("mcc", Integer.valueOf(C2228a4.b(context)));
        a("mnc", Integer.valueOf(C2228a4.c(context)));
        a(Q6.T, Boolean.valueOf(this.f7546a.j()));
        a(Q6.g, Boolean.valueOf(this.f7546a.C(context)));
        a(Q6.h, Integer.valueOf(this.f7546a.D(context)));
        a(Q6.f7429b, Boolean.valueOf(this.f7546a.e(context)));
        a(Q6.K, Boolean.valueOf(this.f7546a.h(context)));
        a("rt", Boolean.valueOf(this.f7546a.p()));
        a(Q6.Z, String.valueOf(this.f7546a.r()));
        a(Q6.e, Integer.valueOf(this.f7546a.k(context)));
        a(Q6.Y0, Boolean.valueOf(this.f7546a.J(context)));
        a(Q6.f7432c, this.f7546a.m(context));
        a(Q6.d0, this.f7546a.s());
        C2645y c2645y = new C2645y(Mb.U().s());
        HashMap map = new HashMap();
        c2645y.a(map);
        a(Q6.D0, map);
        a(Q6.L, ConfigFile.getConfigFile().getPluginType());
        a(Q6.M, ConfigFile.getConfigFile().getPluginVersion());
        a(Q6.N, ConfigFile.getConfigFile().getPluginFrameworkVersion());
    }

    public void c(Context context) {
        try {
            d(context);
            f(context);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private R6() {
        this.f7548c = new AtomicBoolean(false);
        this.f7549d = new AtomicBoolean(false);
        this.f7546a = Mb.U().i();
        this.f7547b = new ConcurrentHashMap<>();
    }

    public static R6 b() {
        return b.f7552a;
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                if (map.containsKey(str)) {
                    a(str, map.get(str));
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void b(String str, Object obj) {
        a(str, obj);
    }

    public void b(String str) {
        if (str == null) {
            return;
        }
        try {
            this.f7547b.remove(str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public JSONObject b(Context context) throws JSONException {
        f(context);
        return new JSONObject(T6.a(this.f7547b));
    }

    public void a(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            Object obj = this.f7547b.get(str);
            if (!(obj instanceof JSONArray)) {
                a(str, (Object) jSONArray);
                return;
            }
            JSONArray jSONArray2 = (JSONArray) obj;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                jSONArray2.put(jSONArray.get(i2));
            }
            a(str, (Object) jSONArray2);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Object obj = this.f7547b.get(str);
            if (!(obj instanceof JSONObject)) {
                a(str, (Object) jSONObject);
                return;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
            }
            a(str, (Object) jSONObject2);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof Boolean) {
                obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            }
            this.f7547b.put(str, obj);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(String str) {
        return str != null && this.f7547b.containsKey(str);
    }

    private void a(Context context) {
        if (this.f7548c.get()) {
            return;
        }
        try {
            this.f7548c.set(true);
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(context));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            this.f7548c.set(false);
        }
    }

    private void a() {
        String strA = C2348gg.f8624a.a();
        if (strA != null) {
            HashMap mapU = androidx.camera.core.processing.util.a.u("sdk", strA);
            HashMap map = new HashMap();
            map.put(Q6.G1, mapU);
            HashMap map2 = new HashMap();
            map2.put(Q6.D1, map);
            a(map2);
        }
    }
}
