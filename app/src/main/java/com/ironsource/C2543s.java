package com.ironsource;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2543s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f9773d = new c(null);
    public static final String e = "capping";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9774f = "pacing";
    public static final String g = "delivery";
    public static final String h = "progressiveLoadingConfig";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9775i = "expiredDurationInMinutes";
    public static final String j = "reward";
    public static final String k = "name";
    public static final String l = "amount";
    public static final String m = "virtualItemName";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9776n = "virtualItemCount";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f9777o = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, d> f9778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f9779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d> f9780c;

    /* JADX INFO: renamed from: com.ironsource.s$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9781a = new a();

        public a() {
            super(1);
        }

        @Override // e6.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(JSONObject it) {
            kotlin.jvm.internal.k.e(it, "it");
            return new d(it);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9782a = new b();

        public b() {
            super(1);
        }

        @Override // e6.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(JSONObject it) {
            kotlin.jvm.internal.k.e(it, "it");
            return new d(it);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K3 f9783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C2273cd f9784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final R4 f9785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Long f9786d;
        private final Hd e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Hd f9787f;
        private final C2642xd g;

        public d(JSONObject features) throws JSONException {
            K3 k32;
            C2273cd c2273cd;
            kotlin.jvm.internal.k.e(features, "features");
            C2642xd c2642xd = null;
            if (features.has(C2543s.e)) {
                JSONObject jSONObject = features.getJSONObject(C2543s.e);
                kotlin.jvm.internal.k.d(jSONObject, "features.getJSONObject(key)");
                k32 = new K3(jSONObject);
            } else {
                k32 = null;
            }
            this.f9783a = k32;
            if (features.has(C2543s.f9774f)) {
                JSONObject jSONObject2 = features.getJSONObject(C2543s.f9774f);
                kotlin.jvm.internal.k.d(jSONObject2, "features.getJSONObject(key)");
                c2273cd = new C2273cd(jSONObject2);
            } else {
                c2273cd = null;
            }
            this.f9784b = c2273cd;
            this.f9785c = features.has(C2543s.g) ? new R4(features.getBoolean(C2543s.g)) : null;
            this.f9786d = features.has(C2543s.f9775i) ? Long.valueOf(features.getLong(C2543s.f9775i)) : null;
            JSONObject jSONObjectOptJSONObject = features.optJSONObject(C2543s.j);
            this.e = jSONObjectOptJSONObject != null ? new Hd(jSONObjectOptJSONObject, "name", C2543s.l) : null;
            Hd hd = new Hd(features, C2543s.m, C2543s.f9776n);
            String strB = hd.b();
            this.f9787f = (strB == null || strB.length() == 0 || hd.a() == null) ? null : hd;
            if (features.has(C2543s.h)) {
                JSONObject jSONObject3 = features.getJSONObject(C2543s.h);
                kotlin.jvm.internal.k.d(jSONObject3, "features.getJSONObject(key)");
                c2642xd = new C2642xd(jSONObject3);
            }
            this.g = c2642xd;
        }

        public final Hd a() {
            return this.e;
        }

        public final K3 b() {
            return this.f9783a;
        }

        public final R4 c() {
            return this.f9785c;
        }

        public final Long d() {
            return this.f9786d;
        }

        public final C2273cd e() {
            return this.f9784b;
        }

        public final Hd f() {
            return this.f9787f;
        }

        public final C2642xd g() {
            return this.g;
        }
    }

    public C2543s(JSONObject configurations) {
        kotlin.jvm.internal.k.e(configurations, "configurations");
        this.f9778a = new C2574td(configurations).a(b.f9782a);
        this.f9779b = new d(configurations);
        this.f9780c = new X0(configurations).a(a.f9781a);
    }

    public final Map<String, d> a() {
        return this.f9780c;
    }

    public final d b() {
        return this.f9779b;
    }

    public final Map<String, d> c() {
        return this.f9778a;
    }
}
