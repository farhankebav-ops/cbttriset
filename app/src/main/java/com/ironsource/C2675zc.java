package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.zc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2675zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10643d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JSONObject f10644f;
    private final Map<String, JSONObject> g;
    private final String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f10645i;
    private final boolean j;
    private C2675zc k;
    private final q5.f l;

    /* JADX INFO: renamed from: com.ironsource.zc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {
        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NetworkSettings invoke() {
            String strJ = C2675zc.this.j();
            String strL = C2675zc.this.l();
            String strH = C2675zc.this.h();
            String strK = C2675zc.this.k();
            JSONObject jSONObjectC = C2675zc.this.c();
            C2675zc c2675zc = C2675zc.this.k;
            JSONObject jSONObjectB = IronSourceUtils.b(jSONObjectC, c2675zc != null ? c2675zc.c() : null);
            JSONObject jSONObjectM = C2675zc.this.m();
            C2675zc c2675zc2 = C2675zc.this.k;
            JSONObject jSONObjectB2 = IronSourceUtils.b(jSONObjectM, c2675zc2 != null ? c2675zc2.m() : null);
            JSONObject jSONObjectE = C2675zc.this.e();
            C2675zc c2675zc3 = C2675zc.this.k;
            JSONObject jSONObjectB3 = IronSourceUtils.b(jSONObjectE, c2675zc3 != null ? c2675zc3.e() : null);
            JSONObject jSONObjectD = C2675zc.this.d();
            C2675zc c2675zc4 = C2675zc.this.k;
            JSONObject jSONObjectB4 = IronSourceUtils.b(jSONObjectD, c2675zc4 != null ? c2675zc4.d() : null);
            JSONObject jSONObjectG = C2675zc.this.g();
            C2675zc c2675zc5 = C2675zc.this.k;
            NetworkSettings networkSettings = new NetworkSettings(strJ, strL, strH, strK, jSONObjectB, jSONObjectB2, jSONObjectB3, jSONObjectB4, IronSourceUtils.b(jSONObjectG, c2675zc5 != null ? c2675zc5.g() : null));
            networkSettings.setIsMultipleInstances(C2675zc.this.o());
            networkSettings.setSubProviderId(C2675zc.this.n());
            networkSettings.setAdSourceNameForEvents(C2675zc.this.b());
            return networkSettings;
        }
    }

    public C2675zc(String providerName, JSONObject networkSettings) {
        kotlin.jvm.internal.k.e(providerName, "providerName");
        kotlin.jvm.internal.k.e(networkSettings, "networkSettings");
        this.f10640a = providerName;
        this.f10641b = providerName;
        String strOptString = networkSettings.optString(Ac.f6337d, providerName);
        kotlin.jvm.internal.k.d(strOptString, "networkSettings.optStrin…,\n          providerName)");
        this.f10642c = strOptString;
        String strOptString2 = networkSettings.optString(Ac.e, strOptString);
        kotlin.jvm.internal.k.d(strOptString2, "networkSettings.optStrin…roviderTypeForReflection)");
        this.f10643d = strOptString2;
        Object objOpt = networkSettings.opt(Ac.f6338f);
        this.e = objOpt instanceof String ? (String) objOpt : null;
        this.f10644f = networkSettings.optJSONObject("application");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        ArrayList arrayList = new ArrayList(adFormatArrValues.length);
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            arrayList.add(C2627wf.a(adFormat));
        }
        int iD0 = r5.x.d0(r5.n.L0(arrayList, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str = (String) obj;
            JSONObject jSONObjectOptJSONObject = networkSettings.optJSONObject("adFormats");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str) : null;
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            linkedHashMap.put(obj, jSONObjectOptJSONObject2);
        }
        this.g = linkedHashMap;
        String strOptString3 = networkSettings.optString("spId", "0");
        kotlin.jvm.internal.k.d(strOptString3, "networkSettings.optStrin…B_PROVIDER_ID_FIELD, \"0\")");
        this.h = strOptString3;
        String strOptString4 = networkSettings.optString(Ac.f6334a);
        kotlin.jvm.internal.k.d(strOptString4, "networkSettings.optString(AD_SOURCE_NAME_FIELD)");
        this.f10645i = strOptString4;
        this.j = networkSettings.optBoolean(Ac.f6336c, false);
        this.l = n7.b.C(new a());
    }

    public final String b() {
        return this.f10645i;
    }

    public final JSONObject c() {
        return this.f10644f;
    }

    public final JSONObject d() {
        JSONObject jSONObjectB = IronSourceUtils.b(this.g.get("banner"), this.f10644f);
        kotlin.jvm.internal.k.d(jSONObjectB, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectB;
    }

    public final JSONObject e() {
        JSONObject jSONObjectB = IronSourceUtils.b(this.g.get("interstitial"), this.f10644f);
        kotlin.jvm.internal.k.d(jSONObjectB, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectB;
    }

    public final NetworkSettings f() {
        return (NetworkSettings) this.l.getValue();
    }

    public final JSONObject g() {
        JSONObject jSONObjectB = IronSourceUtils.b(this.g.get("nativeAd"), this.f10644f);
        kotlin.jvm.internal.k.d(jSONObjectB, "mergeJsons(\n            …EY], applicationSettings)");
        return jSONObjectB;
    }

    public final String h() {
        return this.f10643d;
    }

    public final String i() {
        return this.f10641b;
    }

    public final String j() {
        return this.f10640a;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.f10642c;
    }

    public final JSONObject m() {
        JSONObject jSONObjectB = IronSourceUtils.b(this.g.get("rewarded"), this.f10644f);
        kotlin.jvm.internal.k.d(jSONObjectB, "mergeJsons(\n            …     applicationSettings)");
        return jSONObjectB;
    }

    public final String n() {
        return this.h;
    }

    public final boolean o() {
        return this.j;
    }

    public final Map<String, JSONObject> a() {
        return this.g;
    }

    public final void b(C2675zc c2675zc) {
        this.k = c2675zc;
    }
}
