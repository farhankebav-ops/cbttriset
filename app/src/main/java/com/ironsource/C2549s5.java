package com.ironsource;

import com.ironsource.D7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.s5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2549s5 implements D7, D7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f9817a = new JSONObject();

    private final JSONObject j() {
        JSONObject jSONObjectOptJSONObject = this.f9817a.optJSONObject(C2566t5.f10270a);
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    @Override // com.ironsource.D7.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = this.f9817a;
        }
        this.f9817a = jSONObject;
        IronLog.INTERNAL.verbose("setEpConfig: " + jSONObject);
    }

    @Override // com.ironsource.InterfaceC2583u5
    public long b() {
        String strOptString = j().optString(C2600v5.f10434c);
        kotlin.jvm.internal.k.d(strOptString, "traits.optString(LPM_BN_…FRESH_ANIMATION_DURATION)");
        Long lP0 = n6.t.p0(strOptString);
        if (lP0 != null) {
            return lP0.longValue();
        }
        return 0L;
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean c() {
        return j().optBoolean(C2600v5.h, true);
    }

    @Override // com.ironsource.D7
    public JSONObject config() {
        return this.f9817a;
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean d() {
        return j().optBoolean(C2600v5.g, true);
    }

    @Override // com.ironsource.InterfaceC2583u5
    public long e() {
        String strOptString = j().optString(C2600v5.f10435d);
        kotlin.jvm.internal.k.d(strOptString, "traits.optString(LPM_DEL…_TIME_AFTER_INIT_PROCESS)");
        Long lP0 = n6.t.p0(strOptString);
        if (lP0 != null) {
            return lP0.longValue();
        }
        return 2000L;
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean f() {
        return j().optBoolean(C2600v5.f10437i, false);
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean g() {
        String strOptString = j().optString(C2600v5.f10432a);
        kotlin.jvm.internal.k.d(strOptString, "traits.optString(IS_EP_CONFIG_ENABLED)");
        String lowerCase = strOptString.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.k.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase.equals(com.ironsource.mediationsdk.metadata.a.g);
    }

    @Override // com.ironsource.InterfaceC2583u5
    public int h() {
        String strOptString = j().optString(C2600v5.f10433b);
        kotlin.jvm.internal.k.d(strOptString, "traits.optString(ISN_CTRL_INIT_DELAY)");
        Integer numO0 = n6.t.o0(strOptString);
        if (numO0 != null) {
            return numO0.intValue();
        }
        return 0;
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean i() {
        return j().optBoolean(C2600v5.e, true);
    }

    @Override // com.ironsource.InterfaceC2583u5
    public boolean a() {
        return j().optBoolean(C2600v5.f10436f, true);
    }
}
