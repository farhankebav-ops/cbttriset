package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Qe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2284d6 f7524a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class a extends Pe {
        public a() {
        }

        @Override // com.ironsource.Pe, java.lang.Runnable
        public void run() {
            JSONObject jSONObjectB = IronSourceUtils.b(false);
            try {
                jSONObjectB.put("duration", a());
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            C2381id.O.a(new C5(D5.APP_ENTER_BACKGROUND, jSONObjectB));
        }
    }

    public final void a(InterfaceC2466n7 applicationLifecycleService) {
        kotlin.jvm.internal.k.e(applicationLifecycleService, "applicationLifecycleService");
        this.f7524a = new C2284d6(applicationLifecycleService, new a());
    }
}
