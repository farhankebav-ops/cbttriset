package com.ironsource;

import android.content.Context;
import com.ironsource.C2300e4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class S5 implements Mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7589a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7590b = T5.j;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2392j7 {
        @Override // com.ironsource.InterfaceC2392j7
        public void a(boolean z2) {
            if (z2) {
                return;
            }
            IronLog.API.error("failed to send impression data");
        }
    }

    private final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(C2253bb.f8071o, "android");
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            jSONObject.put("deviceType", IronSourceUtils.b(applicationContext));
            R9 r9D = IronSourceUtils.d(applicationContext);
            if (r9D != null) {
                jSONObject.put("advId", r9D.c());
                jSONObject.put("advIdType", r9D.d());
            }
        }
        String strN = com.ironsource.mediationsdk.r.m().n();
        if (strN != null) {
            jSONObject.put(C2300e4.i.g, strN);
        }
        return jSONObject;
    }

    @Override // com.ironsource.Mc
    public void a() {
    }

    public final void a(String dataSource, JSONObject impressionData) {
        kotlin.jvm.internal.k.e(dataSource, "dataSource");
        kotlin.jvm.internal.k.e(impressionData, "impressionData");
        if (!this.f7589a) {
            IronLog.INTERNAL.verbose("disabled from server");
            return;
        }
        try {
            JSONObject jSONObjectB = b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("externalMediationSource", dataSource);
            jSONObject.putOpt("externalMediationData", impressionData);
            jSONObject.putOpt("clientParams", jSONObjectB);
            IronLog.API.info("impressionData: " + jSONObject);
            C2375i7.a(this.f7590b, jSONObject.toString(), new a());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.API.error("exception " + e.getMessage() + " sending impression data");
        }
    }

    @Override // com.ironsource.Mc
    public void a(List<IronSource.a> list, boolean z2, V3 v32) {
        if (v32 != null) {
            A1 a1B = v32.b();
            K1 k1F = a1B != null ? a1B.f() : null;
            kotlin.jvm.internal.k.b(k1F);
            this.f7589a = k1F.l();
            this.f7590b = v32.b().f().d();
        }
    }

    @Override // com.ironsource.Mc
    public void h(String str) {
    }
}
