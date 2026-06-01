package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import com.ironsource.InterfaceC2562t1;
import com.ironsource.sdk.utils.Logger;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.r1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2528r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9729a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9730b = b.class.getName();

    /* JADX INFO: renamed from: com.ironsource.r1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C2569t8.e f9732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JSONObject f9734d;

        public a(String name, C2569t8.e productType, String demandSourceName, JSONObject params) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(productType, "productType");
            kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
            kotlin.jvm.internal.k.e(params, "params");
            this.f9731a = name;
            this.f9732b = productType;
            this.f9733c = demandSourceName;
            this.f9734d = params;
        }

        public final String a() {
            return this.f9731a;
        }

        public final C2569t8.e b() {
            return this.f9732b;
        }

        public final String c() {
            return this.f9733c;
        }

        public final JSONObject d() {
            return this.f9734d;
        }

        public final String e() {
            return this.f9733c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.k.a(this.f9731a, aVar.f9731a) && this.f9732b == aVar.f9732b && kotlin.jvm.internal.k.a(this.f9733c, aVar.f9733c) && kotlin.jvm.internal.k.a(this.f9734d.toString(), aVar.f9734d.toString());
        }

        public final String f() {
            return this.f9731a;
        }

        public final JSONObject g() {
            return this.f9734d;
        }

        public final C2569t8.e h() {
            return this.f9732b;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public final JSONObject i() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject(this.f9734d.toString()).put(C2300e4.h.m, this.f9732b).put("demandSourceName", this.f9733c);
            kotlin.jvm.internal.k.d(jSONObjectPut, "JSONObject(params.toStri…eName\", demandSourceName)");
            return jSONObjectPut;
        }

        public String toString() {
            return "CallbackResult(name=" + this.f9731a + ", productType=" + this.f9732b + ", demandSourceName=" + this.f9733c + ", params=" + this.f9734d + ")";
        }

        public final a a(String name, C2569t8.e productType, String demandSourceName, JSONObject params) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(productType, "productType");
            kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
            kotlin.jvm.internal.k.e(params, "params");
            return new a(name, productType, demandSourceName, params);
        }

        public static /* synthetic */ a a(a aVar, String str, C2569t8.e eVar, String str2, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = aVar.f9731a;
            }
            if ((i2 & 2) != 0) {
                eVar = aVar.f9732b;
            }
            if ((i2 & 4) != 0) {
                str2 = aVar.f9733c;
            }
            if ((i2 & 8) != 0) {
                jSONObject = aVar.f9734d;
            }
            return aVar.a(str, eVar, str2, jSONObject);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.r1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.r1$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionClick$1", f = "AndroidSandboxJSHandler.kt", l = {80}, m = "invokeSuspend")
    public static final class c extends x5.i implements e6.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9735a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MeasurementManager f9737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f9738d;
        final /* synthetic */ MotionEvent e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, v5.c<? super c> cVar) {
            super(2, cVar);
            this.f9737c = measurementManager;
            this.f9738d = uri;
            this.e = motionEvent;
        }

        @Override // e6.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(q6.a0 a0Var, v5.c<? super q5.x> cVar) {
            return ((c) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
        }

        @Override // x5.a
        public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
            return C2528r1.this.new c(this.f9737c, this.f9738d, this.e, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.f9735a;
            if (i2 == 0) {
                r2.q.z0(obj);
                C2528r1 c2528r1 = C2528r1.this;
                MeasurementManager measurementManager = this.f9737c;
                Uri uri = this.f9738d;
                kotlin.jvm.internal.k.d(uri, "uri");
                MotionEvent motionEvent = this.e;
                this.f9735a = 1;
                if (c2528r1.a(measurementManager, uri, motionEvent, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return q5.x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.r1$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionImpression$1", f = "AndroidSandboxJSHandler.kt", l = {60}, m = "invokeSuspend")
    public static final class d extends x5.i implements e6.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9739a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MeasurementManager f9741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f9742d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MeasurementManager measurementManager, Uri uri, v5.c<? super d> cVar) {
            super(2, cVar);
            this.f9741c = measurementManager;
            this.f9742d = uri;
        }

        @Override // e6.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(q6.a0 a0Var, v5.c<? super q5.x> cVar) {
            return ((d) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
        }

        @Override // x5.a
        public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
            return C2528r1.this.new d(this.f9741c, this.f9742d, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.f9739a;
            if (i2 == 0) {
                r2.q.z0(obj);
                C2528r1 c2528r1 = C2528r1.this;
                MeasurementManager measurementManager = this.f9741c;
                Uri uri = this.f9742d;
                kotlin.jvm.internal.k.d(uri, "uri");
                this.f9739a = 1;
                if (c2528r1.a(measurementManager, uri, null, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return q5.x.f13520a;
        }
    }

    public final a a(Context context, InterfaceC2562t1 message) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(message, "message");
        if (message instanceof InterfaceC2562t1.a) {
            return a(context, (InterfaceC2562t1.a) message);
        }
        throw new e2.s(3);
    }

    private final a a(Context context, InterfaceC2562t1.a aVar) {
        MeasurementManager measurementManagerA = C2385j0.a(context);
        if (measurementManagerA == null) {
            Logger.i(f9730b, "could not obtain measurement manager");
            return a(aVar, "could not obtain measurement manager");
        }
        try {
            if (aVar instanceof InterfaceC2562t1.a.b) {
                return a(aVar, measurementManagerA);
            }
            if (aVar instanceof InterfaceC2562t1.a.C0202a) {
                return a((InterfaceC2562t1.a.C0202a) aVar, measurementManagerA);
            }
            throw new e2.s(3);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return a(aVar, a1.a.l("failed to handle attribution, message: ", e.getMessage()));
        }
    }

    private final a a(InterfaceC2562t1.a aVar, MeasurementManager measurementManager) throws Throwable {
        q6.c0.A(v5.i.f17610a, new d(measurementManager, Uri.parse(aVar.b()), null));
        return a(aVar);
    }

    private final a a(InterfaceC2562t1.a.C0202a c0202a, MeasurementManager measurementManager) throws Throwable {
        Uri uri = Uri.parse(c0202a.b());
        long jUptimeMillis = SystemClock.uptimeMillis();
        q6.c0.A(v5.i.f17610a, new c(measurementManager, uri, MotionEvent.obtain(jUptimeMillis, jUptimeMillis, c0202a.n(), c0202a.o().c(), c0202a.o().d(), c0202a.p()), null));
        return a(c0202a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, v5.c<? super q5.x> cVar) {
        v5.j jVar = new v5.j(a.a.I(cVar));
        measurementManager.registerSource(uri, motionEvent, Executors.newSingleThreadExecutor(), C2545s1.a(jVar));
        Object objA = jVar.a();
        return objA == w5.a.f17774a ? objA : q5.x.f13520a;
    }

    private final a a(InterfaceC2562t1.a aVar) throws JSONException {
        JSONObject params = new JSONObject().put("params", new JSONObject().put("type", aVar instanceof InterfaceC2562t1.a.C0202a ? C2318f4.f8523d : "impression"));
        String strA = aVar.a();
        C2569t8.e eVarD = aVar.d();
        String strE = aVar.e();
        kotlin.jvm.internal.k.d(params, "params");
        return new a(strA, eVarD, strE, params);
    }

    private final a a(InterfaceC2562t1 interfaceC2562t1, String str) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("reason", str).put("type", interfaceC2562t1 instanceof InterfaceC2562t1.a.C0202a ? C2318f4.f8523d : "impression");
        String strC = interfaceC2562t1.c();
        C2569t8.e eVarD = interfaceC2562t1.d();
        String strE = interfaceC2562t1.e();
        JSONObject jSONObjectPut2 = new JSONObject().put("params", jSONObjectPut);
        kotlin.jvm.internal.k.d(jSONObjectPut2, "JSONObject().put(\"params\", payload)");
        return new a(strC, eVarD, strE, jSONObjectPut2);
    }
}
