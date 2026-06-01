package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class yg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10584c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Double f10585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f10586b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final b a() {
            return new b();
        }

        public final yg b() {
            return a().a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Double f10587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Double f10588b;

        public final void a(Double d8) {
            this.f10588b = d8;
        }

        public final void b(Double d8) {
            this.f10587a = d8;
        }

        public final Double c() {
            return this.f10587a;
        }

        public final b a(double d8) {
            this.f10588b = Double.valueOf(d8);
            return this;
        }

        public final Double b() {
            return this.f10588b;
        }

        public final yg a() {
            return new yg(this, null);
        }

        public final b b(double d8) {
            this.f10587a = Double.valueOf(d8);
            return this;
        }
    }

    public /* synthetic */ yg(b bVar, kotlin.jvm.internal.f fVar) {
        this(bVar);
    }

    public static final b a() {
        return f10584c.a();
    }

    public static final yg b() {
        return f10584c.b();
    }

    public final Double c() {
        return this.f10586b;
    }

    public final Double d() {
        return this.f10585a;
    }

    public final String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ceiling", this.f10586b);
            jSONObject.put("floor", this.f10585a);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.getMessage());
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.k.d(string, "json.toString()");
        return string;
    }

    public String toString() {
        return a1.a.l("WaterfallConfiguration", e());
    }

    private yg(b bVar) {
        this.f10585a = bVar.c();
        this.f10586b = bVar.b();
    }
}
