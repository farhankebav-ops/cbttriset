package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6785d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6786f;
    private final int g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f6787i;
    private final List<Integer> j;
    private final List<Integer> k;
    private final List<Integer> l;
    private final List<Integer> m;

    public G1(JSONObject applicationEvents) {
        kotlin.jvm.internal.k.e(applicationEvents, "applicationEvents");
        this.f6782a = applicationEvents.optBoolean(I1.f6954a, false);
        this.f6783b = applicationEvents.optBoolean(I1.f6955b, false);
        this.f6784c = applicationEvents.optBoolean(I1.f6956c, false);
        this.f6785d = applicationEvents.optInt(I1.f6957d, -1);
        String strOptString = applicationEvents.optString(I1.e);
        kotlin.jvm.internal.k.d(strOptString, "applicationEvents.optStr…(SERVER_EVENTS_URL_FIELD)");
        this.e = strOptString;
        String strOptString2 = applicationEvents.optString(I1.f6958f);
        kotlin.jvm.internal.k.d(strOptString2, "applicationEvents.optString(SERVER_EVENTS_TYPE)");
        this.f6786f = strOptString2;
        this.g = applicationEvents.optInt(I1.g, -1);
        this.h = applicationEvents.optInt(I1.h, -1);
        this.f6787i = applicationEvents.optInt(I1.f6959i, 5000);
        this.j = a(applicationEvents, I1.j);
        this.k = a(applicationEvents, I1.k);
        this.l = a(applicationEvents, I1.l);
        this.m = a(applicationEvents, I1.m);
    }

    public final int a() {
        return this.g;
    }

    public final boolean b() {
        return this.f6784c;
    }

    public final int c() {
        return this.f6785d;
    }

    public final String d() {
        return this.f6786f;
    }

    public final int e() {
        return this.f6787i;
    }

    public final int f() {
        return this.h;
    }

    public final List<Integer> g() {
        return this.m;
    }

    public final List<Integer> h() {
        return this.k;
    }

    public final List<Integer> i() {
        return this.j;
    }

    public final boolean j() {
        return this.f6783b;
    }

    public final boolean k() {
        return this.f6782a;
    }

    public final String l() {
        return this.e;
    }

    public final List<Integer> m() {
        return this.l;
    }

    private final List<Integer> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return r5.r.f13638a;
        }
        k6.d dVarD0 = r2.q.D0(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(r5.n.L0(dVarD0, 10));
        Iterator it = dVarD0.iterator();
        while (((k6.c) it).f12714c) {
            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(((r5.v) it).nextInt())));
        }
        return arrayList;
    }
}
