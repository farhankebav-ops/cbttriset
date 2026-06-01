package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Kf f7064a = new Kf();

    private Kf() {
    }

    public final String a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return C1.a(context, c(context));
    }

    public final String b(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return C1.b(context, c(context));
    }

    public final String c(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return C1.g(context);
    }

    public final ConcurrentHashMap<String, List<String>> d() {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putAll(com.ironsource.mediationsdk.c.b().d());
        concurrentHashMap.putAll(C2469na.b().c());
        return concurrentHashMap;
    }

    public final void e() {
        com.ironsource.mediationsdk.r.m().R();
    }

    public final JSONObject a(boolean z2) {
        JSONObject jSONObjectB = IronSourceUtils.b(z2);
        kotlin.jvm.internal.k.d(jSONObjectB, "getMediationAdditionalData(isDemandOnlyMode)");
        return jSONObjectB;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectB = N6.a().b();
        kotlin.jvm.internal.k.d(jSONObjectB, "getProperties().toJSON()");
        return jSONObjectB;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, AdapterBaseWrapper> networkAdaptersMap = com.ironsource.mediationsdk.c.b().e();
            kotlin.jvm.internal.k.d(networkAdaptersMap, "networkAdaptersMap");
            for (Map.Entry<String, AdapterBaseWrapper> entry : networkAdaptersMap.entrySet()) {
                if (entry.getValue().getAdapterBaseInterface() != null) {
                    Kf kf = f7064a;
                    String key = entry.getKey();
                    kotlin.jvm.internal.k.d(key, "entry.key");
                    String strA = kf.a(key);
                    AdapterBaseInterface adapterBaseInterface = entry.getValue().getAdapterBaseInterface();
                    kotlin.jvm.internal.k.d(adapterBaseInterface, "entry.value.adapterBaseInterface");
                    String adapterVersion = adapterBaseInterface.getAdapterVersion();
                    kotlin.jvm.internal.k.d(adapterVersion, "adapterBaseInterface.adapterVersion");
                    jSONObject.putOpt(strA, kf.a(adapterVersion, adapterBaseInterface.getNetworkSDKVersion()));
                }
            }
            return jSONObject;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return jSONObject;
        }
    }

    public final void a(InterfaceC2361hb interfaceC2361hb) {
        C2358h8.a().b(interfaceC2361hb);
    }

    public final LevelPlayAdSize b(String str, int i2, int i8) {
        if (str != null && str.length() != 0 && !str.equals("CUSTOM")) {
            if (str.equals(com.ironsource.mediationsdk.l.f9206c)) {
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            }
            return LevelPlayAdSize.Companion.createAdSize$mediationsdk_release(str);
        }
        return LevelPlayAdSize.Companion.createCustomSize(i2, i8);
    }

    public final void a(InterfaceC2555sb interfaceC2555sb) {
        Ed.a().b(interfaceC2555sb);
    }

    public final void a(Fa fa) {
        C2580u2.a().b(fa);
    }

    public final int a() {
        return Mb.f7131s.d().i().c();
    }

    public final String a(C2434ld c2434ld) {
        String strC;
        return (c2434ld == null || (strC = c2434ld.c()) == null) ? new String() : strC;
    }

    public final String a(NetworkSettings networkSettings) {
        kotlin.jvm.internal.k.e(networkSettings, "networkSettings");
        String providerDefaultInstance = networkSettings.getProviderDefaultInstance();
        return providerDefaultInstance == null ? new String() : providerDefaultInstance;
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(networkSettings, "networkSettings");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        return networkSettings.isBidder(adUnit);
    }

    public final ISBannerSize a(String str, int i2, int i8) {
        return new ISBannerSize(str, i2, i8);
    }

    public final void b(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        IronLog.INTERNAL.error(message);
    }

    public final com.ironsource.mediationsdk.q a(Activity activity, ISBannerSize size) {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(size, "size");
        com.ironsource.mediationsdk.q qVarB = com.ironsource.mediationsdk.r.m().b(activity, size);
        kotlin.jvm.internal.k.d(qVarB, "getInstance().createBanner(activity, size)");
        return qVarB;
    }

    public final void a(D5 event, JSONObject data) {
        kotlin.jvm.internal.k.e(event, "event");
        kotlin.jvm.internal.k.e(data, "data");
        C2256be.i().a(new C5(event, data));
    }

    private final JSONObject a(String str, String str2) {
        return new JSONObject(r5.x.f0(new q5.i(Df.f6629b, str), new q5.i("sdkVersion", str2)));
    }

    public final String a(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        try {
            if (!n6.m.q0(key, "-", false)) {
                return !n6.m.q0(key, "_", false) ? key : (String) r5.l.X0(n6.m.K0(key, new String[]{"_"}, 6));
            }
            String str = (String) r5.l.d1(n6.m.K0(key, new String[]{"-"}, 6));
            return !n6.m.q0(str, "_", false) ? str : (String) r5.l.X0(n6.m.K0(str, new String[]{"_"}, 6));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.getMessage());
            return key;
        }
    }
}
