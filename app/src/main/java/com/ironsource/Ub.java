package com.ironsource;

import android.app.Activity;
import com.ironsource.C2300e4;
import com.ironsource.G8;
import com.ironsource.Vb;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ub implements Vb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.sdk.controller.e f7676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X8 f7677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2225a1 f7678d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Vb.a f7679f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7680a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f7681b = "nativeAd.load";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7682c = "nativeAd.loadReport";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7683d = "nativeAd.register";
        public static final String e = "nativeAd.click";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7684f = "nativeAd.privacyClick";
        public static final String g = "nativeAd.visibilityChanged";
        public static final String h = "nativeAd.destroy";

        private a() {
        }
    }

    public Ub(String id, com.ironsource.sdk.controller.e controllerManager, X8 imageLoader, InterfaceC2225a1 adViewManagement) {
        kotlin.jvm.internal.k.e(id, "id");
        kotlin.jvm.internal.k.e(controllerManager, "controllerManager");
        kotlin.jvm.internal.k.e(imageLoader, "imageLoader");
        kotlin.jvm.internal.k.e(adViewManagement, "adViewManagement");
        this.f7675a = id;
        this.f7676b = controllerManager;
        this.f7677c = imageLoader;
        this.f7678d = adViewManagement;
        this.e = "Ub";
        controllerManager.a(id, d());
    }

    @Override // com.ironsource.Vb
    public void a(Vb.a aVar) {
        this.f7679f = aVar;
    }

    private final l.b d() {
        return new l.b() { // from class: com.ironsource.th
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(Ob ob) {
                Ub.a(this.f10313a, ob);
            }
        };
    }

    private final JSONObject e() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(f.b.g, a.e).put("sdkCallback", C2300e4.g.U);
        kotlin.jvm.internal.k.d(jSONObjectPut, "JSONObject()\n        .pu…hods.ON_RECEIVED_MESSAGE)");
        return jSONObjectPut;
    }

    @Override // com.ironsource.Vb
    public void a(Activity activity, JSONObject loadParams) {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(loadParams, "loadParams");
        this.f7676b.a(activity);
        this.f7676b.a(new f.c(this.f7675a, a.f7681b, loadParams), new sh(this, activity, 0));
    }

    @Override // com.ironsource.Vb
    public Vb.a b() {
        return this.f7679f;
    }

    @Override // com.ironsource.Vb
    public void c() {
        this.f7676b.a(new f.c(this.f7675a, a.f7684f, new JSONObject()), (l.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ub this$0, f.a it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(it, "it");
        this$0.b(it);
    }

    private final void b(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle show on native ad: missing params");
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String strOptString = aVar.d().optString("reason", "unexpected error");
            Logger.i(this.e, "failed to handle show on native ad: " + strOptString);
            return;
        }
        Vb.a aVarB = b();
        if (aVarB != null) {
            aVarB.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ub this$0, Activity activity, f.a it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(activity, "$activity");
        kotlin.jvm.internal.k.e(it, "it");
        this$0.a(activity, it);
    }

    private final void a(Activity activity, f.a aVar) {
        if (aVar.d() == null) {
            Vb.a aVarB = b();
            if (aVarB != null) {
                aVarB.a("failed to load native ad: missing params");
                return;
            }
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            Vb.a aVarB2 = b();
            if (aVarB2 != null) {
                kotlin.jvm.internal.k.d(reason, "reason");
                aVarB2.a(reason);
                return;
            }
            return;
        }
        G8.b bVarA = new G8.a(this.f7677c, this.f7678d).a(activity, aVar.d());
        a(bVarA, bVarA.a().h());
    }

    public /* synthetic */ Ub(String str, com.ironsource.sdk.controller.e eVar, X8 x8, InterfaceC2225a1 interfaceC2225a1, int i2, kotlin.jvm.internal.f fVar) {
        if ((i2 & 4) != 0) {
            x8 = new W8(null, 1, 0 == true ? 1 : 0);
        }
        if ((i2 & 8) != 0) {
            interfaceC2225a1 = C2519q8.a();
            kotlin.jvm.internal.k.d(interfaceC2225a1, "getInstance()");
        }
        this(str, eVar, x8, interfaceC2225a1);
    }

    private final void a(G8.b bVar, G8 g8) {
        this.f7676b.a(new f.c(this.f7675a, a1.a.l("nativeAd.loadReport.", this.f7675a), bVar.b()), new sh(this, g8, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ub this$0, G8 adData, f.a it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adData, "$adData");
        kotlin.jvm.internal.k.e(it, "it");
        this$0.a(adData, it);
    }

    private final void a(G8 g8, f.a aVar) {
        if (aVar.d() == null) {
            Vb.a aVarB = b();
            if (aVarB != null) {
                aVarB.a("failed to load native ad: missing report params");
                return;
            }
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            Vb.a aVarB2 = b();
            if (aVarB2 != null) {
                kotlin.jvm.internal.k.d(reason, "reason");
                aVarB2.a(reason);
                return;
            }
            return;
        }
        Vb.a aVarB3 = b();
        if (aVarB3 != null) {
            aVarB3.a(g8);
        }
    }

    @Override // com.ironsource.Vb
    public void a() {
        this.f7676b.a(new f.c(this.f7675a, a.h, new JSONObject()), (l.a) null);
    }

    @Override // com.ironsource.Vb
    public void a(J8 viewHolder) throws JSONException {
        kotlin.jvm.internal.k.e(viewHolder, "viewHolder");
        JSONObject params = new JSONObject().put("assetViews", viewHolder.t()).put("adViewClickCommand", e());
        String str = this.f7675a;
        kotlin.jvm.internal.k.d(params, "params");
        this.f7676b.a(new f.c(str, a.f7683d, params), (l.a) null);
    }

    @Override // com.ironsource.Vb
    public void a(rg viewVisibilityParams) {
        kotlin.jvm.internal.k.e(viewVisibilityParams, "viewVisibilityParams");
        this.f7676b.a(new f.c(this.f7675a, a.g, viewVisibilityParams.g()), new uh(this, 1));
    }

    @Override // com.ironsource.Vb
    public void a(JSONObject clickParams) {
        kotlin.jvm.internal.k.e(clickParams, "clickParams");
        this.f7676b.a(new f.c(this.f7675a, a.e, clickParams), new uh(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ub this$0, f.a it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(it, "it");
        this$0.a(it);
    }

    private final void a(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String strOptString = aVar.d().optString("reason", "unexpected error");
            Logger.i(this.e, "failed to handle click on native ad: " + strOptString);
            return;
        }
        Vb.a aVarB = b();
        if (aVarB != null) {
            aVarB.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ub this$0, Ob msg) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(msg, "msg");
        if (kotlin.jvm.internal.k.a(msg.e(), a.e)) {
            this$0.a(msg);
        }
    }

    private final void a(Ob ob) {
        if (ob.f() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
            return;
        }
        if (!ob.f().optBoolean("success", false)) {
            String strOptString = ob.f().optString("reason", "unexpected error");
            Logger.i(this.e, "failed to handle click on native ad: " + strOptString);
            return;
        }
        Vb.a aVarB = b();
        if (aVarB != null) {
            aVarB.g();
        }
    }
}
