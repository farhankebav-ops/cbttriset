package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2543s f7763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2543s f7764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final U2 f7765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Sb f7766d;
    private final C2664z1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, C2543s> f7767f;

    public W3(JSONObject configurations) {
        kotlin.jvm.internal.k.e(configurations, "configurations");
        C2543s c2543s = new C2543s(a(configurations, "rewarded"));
        this.f7763a = c2543s;
        C2543s c2543s2 = new C2543s(a(configurations, "interstitial"));
        this.f7764b = c2543s2;
        this.f7765c = new U2(a(configurations, "banner"));
        this.f7766d = new Sb(a(configurations, "nativeAd"));
        JSONObject jSONObjectOptJSONObject = configurations.optJSONObject("application");
        this.e = new C2664z1(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
        this.f7767f = r5.x.f0(new q5.i(LevelPlay.AdFormat.INTERSTITIAL, c2543s2), new q5.i(LevelPlay.AdFormat.REWARDED, c2543s));
    }

    public final Map<LevelPlay.AdFormat, C2543s> a() {
        return this.f7767f;
    }

    public final C2664z1 b() {
        return this.e;
    }

    public final U2 c() {
        return this.f7765c;
    }

    public final Sb d() {
        return this.f7766d;
    }

    private final JSONObject a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adFormats");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str) : null;
        return jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2;
    }
}
