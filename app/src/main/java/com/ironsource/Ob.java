package com.ironsource;

import com.ironsource.sdk.controller.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ob {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f7337d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f7340c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Ob a(String jsonStr) throws JSONException {
            kotlin.jvm.internal.k.e(jsonStr, "jsonStr");
            JSONObject jSONObject = new JSONObject(jsonStr);
            String adId = jSONObject.getString(f.b.f9966c);
            String command = jSONObject.getString(f.b.g);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            kotlin.jvm.internal.k.d(adId, "adId");
            kotlin.jvm.internal.k.d(command, "command");
            return new Ob(adId, command, jSONObjectOptJSONObject);
        }

        private a() {
        }
    }

    public Ob(String adId, String command, JSONObject jSONObject) {
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(command, "command");
        this.f7338a = adId;
        this.f7339b = command;
        this.f7340c = jSONObject;
    }

    public final String a() {
        return this.f7338a;
    }

    public final String b() {
        return this.f7339b;
    }

    public final JSONObject c() {
        return this.f7340c;
    }

    public final String d() {
        return this.f7338a;
    }

    public final String e() {
        return this.f7339b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ob)) {
            return false;
        }
        Ob ob = (Ob) obj;
        return kotlin.jvm.internal.k.a(this.f7338a, ob.f7338a) && kotlin.jvm.internal.k.a(this.f7339b, ob.f7339b) && kotlin.jvm.internal.k.a(this.f7340c, ob.f7340c);
    }

    public final JSONObject f() {
        return this.f7340c;
    }

    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(this.f7338a.hashCode() * 31, 31, this.f7339b);
        JSONObject jSONObject = this.f7340c;
        return iB + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        String str = this.f7338a;
        String str2 = this.f7339b;
        JSONObject jSONObject = this.f7340c;
        StringBuilder sbZ = a1.a.z("MessageToNative(adId=", str, ", command=", str2, ", params=");
        sbZ.append(jSONObject);
        sbZ.append(")");
        return sbZ.toString();
    }

    public final Ob a(String adId, String command, JSONObject jSONObject) {
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(command, "command");
        return new Ob(adId, command, jSONObject);
    }

    public static /* synthetic */ Ob a(Ob ob, String str, String str2, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ob.f7338a;
        }
        if ((i2 & 2) != 0) {
            str2 = ob.f7339b;
        }
        if ((i2 & 4) != 0) {
            jSONObject = ob.f7340c;
        }
        return ob.a(str, str2, jSONObject);
    }

    public static final Ob a(String str) throws JSONException {
        return f7337d.a(str);
    }
}
