package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.j2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2387j2 {
    public static final b h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.mediationsdk.demandOnly.a f8751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2461n2 f8752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f8753d;
    private final JSONObject e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C2280d2 f8754f;
    private final C2479o2 g;

    /* JADX INFO: renamed from: com.ironsource.j2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f8755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f8757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.ironsource.mediationsdk.demandOnly.a f8758d;
        private final C2461n2 e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final JSONObject f8759f;
        private final JSONObject g;
        private final C2280d2 h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final C2479o2 f8760i;

        public a(JSONObject auctionData, String instanceId) {
            kotlin.jvm.internal.k.e(auctionData, "auctionData");
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            this.f8755a = auctionData;
            this.f8756b = instanceId;
            JSONObject jSONObjectA = a(auctionData);
            this.f8757c = auctionData.optString("auctionId");
            com.ironsource.mediationsdk.demandOnly.a aVarA = a(auctionData, jSONObjectA);
            this.f8758d = aVarA;
            this.e = c(jSONObjectA);
            this.f8759f = d(jSONObjectA);
            this.g = b(jSONObjectA);
            this.h = a(aVarA, instanceId);
            this.f8760i = b(aVarA, instanceId);
        }

        private final JSONObject d(JSONObject jSONObject) {
            return jSONObject.optJSONObject("genericParams");
        }

        public final C2387j2 a() {
            return new C2387j2(this.f8757c, this.f8758d, this.e, this.f8759f, this.g, this.h, this.f8760i);
        }

        public final JSONObject b() {
            return this.f8755a;
        }

        public final String c() {
            return this.f8756b;
        }

        private final JSONObject b(JSONObject jSONObject) {
            return jSONObject.optJSONObject("configurations");
        }

        private final C2461n2 c(JSONObject jSONObject) {
            return new C2461n2(jSONObject);
        }

        private final C2479o2 b(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            C2461n2 c2461n2A = aVar.a(str);
            if (c2461n2A == null) {
                return null;
            }
            String strK = c2461n2A.k();
            kotlin.jvm.internal.k.d(strK, "it.serverData");
            return new C2479o2(strK);
        }

        private final JSONObject a(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
            return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        }

        private final com.ironsource.mediationsdk.demandOnly.a a(JSONObject jSONObject, JSONObject jSONObject2) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(com.ironsource.mediationsdk.d.f9036d);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.ironsource.mediationsdk.d.h);
            if (jSONArrayOptJSONArray != null) {
                k6.d dVarD0 = r2.q.D0(0, jSONArrayOptJSONArray.length());
                ArrayList arrayList2 = new ArrayList();
                Iterator it = dVarD0.iterator();
                while (((k6.c) it).f12714c) {
                    int iNextInt = ((r5.v) it).nextInt();
                    C2461n2 c2461n2 = new C2461n2(jSONArrayOptJSONArray.getJSONObject(iNextInt), iNextInt, jSONObjectOptJSONObject);
                    if (!c2461n2.m()) {
                        c2461n2 = null;
                    }
                    if (c2461n2 != null) {
                        arrayList2.add(c2461n2);
                    }
                }
                arrayList.addAll(arrayList2);
            }
            return new a.C0192a(arrayList);
        }

        private final C2280d2 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            C2461n2 c2461n2A = aVar.a(str);
            if (c2461n2A == null) {
                return null;
            }
            C2280d2 c2280d2 = new C2280d2();
            c2280d2.a(c2461n2A.b());
            c2280d2.c(c2461n2A.h());
            c2280d2.b(c2461n2A.g());
            return c2280d2;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.j2$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Object a(JSONObject auctionData, String instanceId) {
            kotlin.jvm.internal.k.e(auctionData, "auctionData");
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            return a(new a(auctionData, instanceId).a(), instanceId);
        }

        private b() {
        }

        private final Object a(C2387j2 c2387j2, String str) {
            String strB = c2387j2.b();
            if (strB != null && strB.length() != 0) {
                if (c2387j2.i()) {
                    return r2.q.M(new C2322f8(C2668z5.f10625a.f()));
                }
                C2461n2 c2461n2A = c2387j2.a(str);
                if (c2461n2A == null) {
                    return r2.q.M(new C2322f8(C2668z5.f10625a.j()));
                }
                String strK = c2461n2A.k();
                return (strK == null || strK.length() == 0) ? r2.q.M(new C2322f8(C2668z5.f10625a.e())) : c2387j2;
            }
            return r2.q.M(new C2322f8(C2668z5.f10625a.i()));
        }
    }

    public C2387j2(String str, com.ironsource.mediationsdk.demandOnly.a waterfall, C2461n2 genericNotifications, JSONObject jSONObject, JSONObject jSONObject2, C2280d2 c2280d2, C2479o2 c2479o2) {
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        kotlin.jvm.internal.k.e(genericNotifications, "genericNotifications");
        this.f8750a = str;
        this.f8751b = waterfall;
        this.f8752c = genericNotifications;
        this.f8753d = jSONObject;
        this.e = jSONObject2;
        this.f8754f = c2280d2;
        this.g = c2479o2;
    }

    public final String a() {
        C2479o2 c2479o2 = this.g;
        if (c2479o2 != null) {
            return c2479o2.d();
        }
        return null;
    }

    public final String b() {
        return this.f8750a;
    }

    public final C2280d2 c() {
        return this.f8754f;
    }

    public final JSONObject d() {
        return this.e;
    }

    public final C2461n2 e() {
        return this.f8752c;
    }

    public final JSONObject f() {
        return this.f8753d;
    }

    public final C2479o2 g() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.demandOnly.a h() {
        return this.f8751b;
    }

    public final boolean i() {
        return this.f8751b.isEmpty();
    }

    public final C2461n2 a(String providerName) {
        kotlin.jvm.internal.k.e(providerName, "providerName");
        return a(this.f8751b, providerName);
    }

    private final C2461n2 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
        return aVar.a(str);
    }
}
