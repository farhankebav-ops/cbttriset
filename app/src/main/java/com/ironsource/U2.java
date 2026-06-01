package com.ironsource;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class U2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, b> f7659b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7660a = new a();

        public a() {
            super(1);
        }

        @Override // e6.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke(JSONObject it) {
            kotlin.jvm.internal.k.e(it, "it");
            return new b(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f7661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f7663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f7664d;
        private final float e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<String> f7665f;

        public b(JSONObject features) {
            kotlin.jvm.internal.k.e(features, "features");
            JSONObject jSONObject = features.has(W2.f7757a) ? features : null;
            JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject(W2.f7757a) : null;
            this.f7661a = jSONObjectOptJSONObject;
            int iOptInt = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt(W2.f7758b, W2.g) : W2.g;
            this.f7662b = iOptInt;
            this.f7663c = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optBoolean("enabled", true) : true;
            this.f7664d = (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has(W2.f7760d) || jSONObjectOptJSONObject.isNull(W2.f7760d)) ? iOptInt : jSONObjectOptJSONObject.optLong(W2.f7760d);
            this.e = features.has(W2.e) ? features.optInt(W2.e) / 100.0f : 0.15f;
            List<String> listB = features.has(W2.f7761f) ? C2395ja.b(features.getJSONArray(W2.f7761f)) : r5.m.H0(com.ironsource.mediationsdk.l.f9204a, com.ironsource.mediationsdk.l.f9207d);
            kotlin.jvm.internal.k.d(listB, "BANNER_CONFIGURATIONS_AD…ZE_LEADERBOARD)\n        }");
            this.f7665f = listB;
        }

        public final List<String> a() {
            return this.f7665f;
        }

        public final float b() {
            return this.e;
        }

        public final int c() {
            return this.f7662b;
        }

        public final long d() {
            return this.f7664d;
        }

        public final boolean e() {
            return this.f7663c;
        }
    }

    public U2(JSONObject bannerConfigurations) {
        kotlin.jvm.internal.k.e(bannerConfigurations, "bannerConfigurations");
        this.f7658a = new b(bannerConfigurations);
        this.f7659b = new X0(bannerConfigurations).a(a.f7660a);
    }

    public final Map<String, b> a() {
        return this.f7659b;
    }

    public final b b() {
        return this.f7658a;
    }
}
