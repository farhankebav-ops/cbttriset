package com.apm.insight.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4583a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4584b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4585c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4586d = 1;
    private static boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f4587f = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile b f4588z;
    private int B;
    private Application g;
    private Context h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f4590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f4591o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f4592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f4593r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f4594s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f4595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f4596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f4597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f4598w;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f4589i = new ArrayList();
    private List<Long> j = new ArrayList();
    private List<String> k = new ArrayList();
    private List<Long> l = new ArrayList();
    private LinkedList<a> m = new LinkedList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f4599x = false;
    private long y = -1;
    private int A = 50;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f4602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4603c;

        public a(String str, String str2, long j) {
            this.f4602b = str2;
            this.f4603c = j;
            this.f4601a = str;
        }

        public final String toString() {
            return com.apm.insight.l.b.a().format(new Date(this.f4603c)) + " : " + this.f4601a + ' ' + this.f4602b;
        }
    }

    private b(@NonNull Application application) {
        this.h = application;
        this.g = application;
        if (application != null) {
            try {
                this.g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.insight.runtime.a.b.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                        b.this.f4590n = activity.getClass().getName();
                        b.this.f4591o = System.currentTimeMillis();
                        boolean unused = b.f4584b = bundle != null;
                        boolean unused2 = b.f4585c = true;
                        b.this.f4589i.add(b.this.f4590n);
                        b.this.j.add(Long.valueOf(b.this.f4591o));
                        b bVar = b.this;
                        b.a(bVar, bVar.f4590n, b.this.f4591o, "onCreate");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityDestroyed(Activity activity) {
                        String name = activity.getClass().getName();
                        int iIndexOf = b.this.f4589i.indexOf(name);
                        if (iIndexOf >= 0 && iIndexOf < b.this.f4589i.size()) {
                            b.this.f4589i.remove(iIndexOf);
                            b.this.j.remove(iIndexOf);
                        }
                        b.this.k.add(name);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        b.this.l.add(Long.valueOf(jCurrentTimeMillis));
                        b.a(b.this, name, jCurrentTimeMillis, "onDestroy");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityPaused(Activity activity) {
                        b.this.f4595t = activity.getClass().getName();
                        b.this.f4596u = System.currentTimeMillis();
                        b.l(b.this);
                        if (b.this.B == 0) {
                            b.this.f4599x = false;
                            boolean unused = b.f4585c = false;
                            b.this.y = SystemClock.uptimeMillis();
                        } else if (b.this.B < 0) {
                            b.n(b.this);
                            b.this.f4599x = false;
                            boolean unused2 = b.f4585c = false;
                            b.this.y = SystemClock.uptimeMillis();
                        }
                        b bVar = b.this;
                        b.a(bVar, bVar.f4595t, b.this.f4596u, C2300e4.h.t0);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityResumed(Activity activity) {
                        b.this.f4593r = activity.getClass().getName();
                        b.this.f4594s = System.currentTimeMillis();
                        b.g(b.this);
                        if (!b.this.f4599x) {
                            if (b.f4583a) {
                                b.k();
                                int unused = b.f4586d = 1;
                                long unused2 = b.f4587f = b.this.f4594s;
                            }
                            if (!b.this.f4593r.equals(b.this.f4595t)) {
                                return;
                            }
                            if (b.f4585c && !b.f4584b) {
                                int unused3 = b.f4586d = 4;
                                long unused4 = b.f4587f = b.this.f4594s;
                                return;
                            } else if (!b.f4585c) {
                                int unused5 = b.f4586d = 3;
                                long unused6 = b.f4587f = b.this.f4594s;
                                return;
                            }
                        }
                        b.this.f4599x = true;
                        b bVar = b.this;
                        b.a(bVar, bVar.f4593r, b.this.f4594s, C2300e4.h.f8387u0);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStarted(Activity activity) {
                        b.this.p = activity.getClass().getName();
                        b.this.f4592q = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.p, b.this.f4592q, "onStart");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStopped(Activity activity) {
                        b.this.f4597v = activity.getClass().getName();
                        b.this.f4598w = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.f4597v, b.this.f4598w, "onStop");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static /* synthetic */ int g(b bVar) {
        int i2 = bVar.B;
        bVar.B = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int l(b bVar) {
        int i2 = bVar.B;
        bVar.B = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int n(b bVar) {
        bVar.B = 0;
        return 0;
    }

    public static /* synthetic */ boolean k() {
        f4583a = false;
        return false;
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f4589i;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f4589i.size(); i2++) {
                try {
                    jSONArray.put(a(this.f4589i.get(i2), this.j.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.k;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                try {
                    jSONArray.put(a(this.k.get(i2), this.l.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        if (com.apm.insight.e.w()) {
            try {
                jSONObject.put("last_create_activity", a(this.f4590n, this.f4591o));
                jSONObject.put("last_start_activity", a(this.p, this.f4592q));
                jSONObject.put("last_resume_activity", a(this.f4593r, this.f4594s));
                jSONObject.put("last_pause_activity", a(this.f4595t, this.f4596u));
                jSONObject.put("last_stop_activity", a(this.f4597v, this.f4598w));
                jSONObject.put("alive_activities", n());
                jSONObject.put("finish_activities", o());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    @NonNull
    public final String h() {
        return String.valueOf(this.f4593r);
    }

    public final JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList(this.m);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            jSONArray.put(((a) obj).toString());
        }
        return jSONArray;
    }

    public final boolean f() {
        return this.f4599x;
    }

    public static long c() {
        return f4587f;
    }

    public static b d() {
        if (f4588z == null) {
            synchronized (b.class) {
                try {
                    if (f4588z == null) {
                        f4588z = new b(com.apm.insight.e.h());
                    }
                } finally {
                }
            }
        }
        return f4588z;
    }

    public final long e() {
        return SystemClock.uptimeMillis() - this.y;
    }

    public static int b() {
        int i2 = f4586d;
        return i2 == 1 ? e ? 2 : 1 : i2;
    }

    public static void a() {
        e = true;
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put(InfluenceConstants.TIME, j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static /* synthetic */ void a(b bVar, String str, long j, String str2) {
        a aVar;
        if (com.apm.insight.e.w()) {
            try {
                if (bVar.m.size() >= bVar.A) {
                    aVar = bVar.m.poll();
                    if (aVar != null) {
                        bVar.m.add(aVar);
                    }
                } else {
                    aVar = null;
                }
                if (aVar == null) {
                    aVar = new a(str, str2, j);
                    bVar.m.add(aVar);
                }
                aVar.f4602b = str2;
                aVar.f4601a = str;
                aVar.f4603c = j;
            } catch (Throwable unused) {
            }
        }
    }
}
