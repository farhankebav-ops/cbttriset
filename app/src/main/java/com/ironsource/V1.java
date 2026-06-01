package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.p;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface V1 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements V1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f7708a;

        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.V1
        public com.ironsource.mediationsdk.demandOnly.p a(String instanceId) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            JSONObject jSONObject = this.f7708a;
            JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject(instanceId) : null;
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("plumbus") : null;
            return strOptString != null ? new p.a(strOptString) : new p.b();
        }

        public a(JSONObject jSONObject) {
            this.f7708a = jSONObject;
        }

        public /* synthetic */ a(JSONObject jSONObject, int i2, kotlin.jvm.internal.f fVar) {
            this((i2 & 1) != 0 ? new JSONObject() : jSONObject);
        }
    }

    com.ironsource.mediationsdk.demandOnly.p a(String str);
}
