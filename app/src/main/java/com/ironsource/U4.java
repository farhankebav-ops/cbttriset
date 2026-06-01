package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface U4 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Object> f7668a;

        public a(String providerName) {
            kotlin.jvm.internal.k.e(providerName, "providerName");
            this.f7668a = r5.x.g0(new q5.i(IronSourceConstants.EVENTS_PROVIDER, providerName), new q5.i(IronSourceConstants.EVENTS_DEMAND_ONLY, 1));
        }

        public final void a(String key, Object value) {
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(value, "value");
            this.f7668a.put(key, value);
        }

        public final Map<String, Object> a() {
            return r5.x.o0(this.f7668a);
        }
    }

    void a(D5 d52, Be be);

    void a(D5 d52, String str);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements U4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final F7 f7669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f7670b;

        public b(F7 eventManager, a eventBaseData) {
            kotlin.jvm.internal.k.e(eventManager, "eventManager");
            kotlin.jvm.internal.k.e(eventBaseData, "eventBaseData");
            this.f7669a = eventManager;
            this.f7670b = eventBaseData;
        }

        @Override // com.ironsource.U4
        public void a(D5 eventName, String instanceId) {
            kotlin.jvm.internal.k.e(eventName, "eventName");
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            Map<String, Object> mapA = this.f7670b.a();
            mapA.put("spId", instanceId);
            this.f7669a.a(new C5(eventName, new JSONObject(r5.x.n0(mapA))));
        }

        @Override // com.ironsource.U4
        public void a(D5 eventName, Be be) {
            kotlin.jvm.internal.k.e(eventName, "eventName");
            Map<String, Object> mapA = this.f7670b.a();
            if (be != null) {
                mapA.put(IronSourceConstants.EVENTS_EXT1, be.toString());
            }
            this.f7669a.a(new C5(eventName, new JSONObject(r5.x.n0(mapA))));
        }
    }
}
