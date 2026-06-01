package com.ironsource;

import android.app.Activity;
import com.ironsource.C2300e4;
import com.ironsource.C2328fe;
import com.ironsource.C2569t8;
import com.ironsource.I8;
import com.ironsource.J8;
import com.ironsource.Vb;
import com.ironsource.sdk.IronSourceNetwork;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class E8 implements I8 {
    public static final a j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Vb f6665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2620w8 f6666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private G8 f6667d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6668f;
    private Long g;
    private I8.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private J8 f6669i;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final E8 a() {
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.k.d(string, "randomUUID().toString()");
            com.ironsource.sdk.controller.e controllerManager = IronSourceNetwork.getControllerManager();
            kotlin.jvm.internal.k.d(controllerManager, "controllerManager");
            return new E8(string, new Ub(string, controllerManager, null, null, 12, null), new C2637x8());
        }

        private a() {
        }
    }

    public E8(String id, Vb controller, InterfaceC2620w8 eventTracker) {
        kotlin.jvm.internal.k.e(id, "id");
        kotlin.jvm.internal.k.e(controller, "controller");
        kotlin.jvm.internal.k.e(eventTracker, "eventTracker");
        this.f6664a = id;
        this.f6665b = controller;
        this.f6666c = eventTracker;
        controller.a(f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2603v8 d() {
        C2603v8 c2603v8A = new C2603v8().a(G5.f6817x, this.f6668f).a(G5.f6815v, this.e).a(G5.f6816w, C2569t8.e.NativeAd.toString()).a(G5.I, Long.valueOf(j()));
        kotlin.jvm.internal.k.d(c2603v8A, "ISNEventParams()\n       …CUSTOM_C, loadDuration())");
        return c2603v8A;
    }

    public static final E8 e() {
        return j.a();
    }

    private final b f() {
        return new b();
    }

    private final c g() {
        return new c();
    }

    private final long j() {
        Long l = this.g;
        if (l == null) {
            return -1L;
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue();
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f6668f;
    }

    @Override // com.ironsource.I8
    public I8.a b() {
        return this.h;
    }

    @Override // com.ironsource.I8
    public G8 c() {
        return this.f6667d;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements Vb.a {
        public b() {
        }

        @Override // com.ironsource.Vb.a
        public void a(G8 adData) {
            kotlin.jvm.internal.k.e(adData, "adData");
            E8.this.f6667d = adData;
            InterfaceC2620w8 interfaceC2620w8 = E8.this.f6666c;
            C2328fe.a loadAdSuccess = C2328fe.l;
            kotlin.jvm.internal.k.d(loadAdSuccess, "loadAdSuccess");
            HashMap<String, Object> mapA = E8.this.d().a();
            kotlin.jvm.internal.k.d(mapA, "baseEventParams().data");
            interfaceC2620w8.a(loadAdSuccess, mapA);
            I8.a aVarB = E8.this.b();
            if (aVarB != null) {
                aVarB.onNativeAdLoadSuccess(adData);
            }
        }

        @Override // com.ironsource.Vb.a
        public void g() {
            I8.a aVarB = E8.this.b();
            if (aVarB != null) {
                aVarB.onNativeAdClicked();
            }
        }

        @Override // com.ironsource.Vb.a
        public void a(String reason) {
            kotlin.jvm.internal.k.e(reason, "reason");
            C2603v8 c2603v8A = E8.this.d().a(G5.A, reason);
            InterfaceC2620w8 interfaceC2620w8 = E8.this.f6666c;
            C2328fe.a loadAdFailed = C2328fe.g;
            kotlin.jvm.internal.k.d(loadAdFailed, "loadAdFailed");
            HashMap<String, Object> mapA = c2603v8A.a();
            kotlin.jvm.internal.k.d(mapA, "eventParams.data");
            interfaceC2620w8.a(loadAdFailed, mapA);
            I8.a aVarB = E8.this.b();
            if (aVarB != null) {
                aVarB.onNativeAdLoadFailed(reason);
            }
        }

        @Override // com.ironsource.Vb.a
        public void a() {
            I8.a aVarB = E8.this.b();
            if (aVarB != null) {
                aVarB.onNativeAdShown();
            }
        }
    }

    @Override // com.ironsource.I8
    public void a(I8.a aVar) {
        this.h = aVar;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements J8.a {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6672a;

            static {
                int[] iArr = new int[J8.b.values().length];
                try {
                    iArr[J8.b.PrivacyIcon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f6672a = iArr;
            }
        }

        public c() {
        }

        @Override // com.ironsource.J8.a
        public void a(J8.b viewName) throws JSONException {
            kotlin.jvm.internal.k.e(viewName, "viewName");
            if (a.f6672a[viewName.ordinal()] == 1) {
                E8.this.f6665b.c();
                return;
            }
            JSONObject clickParams = new JSONObject().put("viewName", viewName.b());
            Vb vb = E8.this.f6665b;
            kotlin.jvm.internal.k.d(clickParams, "clickParams");
            vb.a(clickParams);
        }

        @Override // com.ironsource.J8.a
        public void a(rg viewVisibilityParams) {
            kotlin.jvm.internal.k.e(viewVisibilityParams, "viewVisibilityParams");
            E8.this.f6665b.a(viewVisibilityParams);
        }
    }

    @Override // com.ironsource.I8
    public void a(Activity activity, JSONObject loadParams) throws JSONException {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(loadParams, "loadParams");
        this.g = Long.valueOf(Calendar.getInstance().getTimeInMillis());
        this.e = loadParams.optString("demandSourceName");
        this.f6668f = loadParams.optString("inAppBidding");
        InterfaceC2620w8 interfaceC2620w8 = this.f6666c;
        C2328fe.a loadAd = C2328fe.f8537f;
        kotlin.jvm.internal.k.d(loadAd, "loadAd");
        HashMap<String, Object> mapA = d().a();
        kotlin.jvm.internal.k.d(mapA, "baseEventParams().data");
        interfaceC2620w8.a(loadAd, mapA);
        JSONObject jSONObject = new JSONObject(loadParams.toString());
        jSONObject.put(C2300e4.h.f8394y0, String.valueOf(this.g));
        this.f6665b.a(activity, jSONObject);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ E8(String str, Vb vb, InterfaceC2620w8 interfaceC2620w8, int i2, kotlin.jvm.internal.f fVar) {
        if ((i2 & 1) != 0) {
            str = UUID.randomUUID().toString();
            kotlin.jvm.internal.k.d(str, "randomUUID().toString()");
        }
        this(str, vb, interfaceC2620w8);
    }

    @Override // com.ironsource.I8
    public void a(J8 viewHolder) {
        kotlin.jvm.internal.k.e(viewHolder, "viewHolder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> mapA = d().a();
        kotlin.jvm.internal.k.d(mapA, "baseEventParams().data");
        linkedHashMap.putAll(mapA);
        String string = viewHolder.t().toString();
        kotlin.jvm.internal.k.d(string, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put(G5.y, string);
        InterfaceC2620w8 interfaceC2620w8 = this.f6666c;
        C2328fe.a registerAd = C2328fe.f8539n;
        kotlin.jvm.internal.k.d(registerAd, "registerAd");
        interfaceC2620w8.a(registerAd, linkedHashMap);
        this.f6669i = viewHolder;
        viewHolder.a(g());
        this.f6665b.a(viewHolder);
    }

    @Override // com.ironsource.I8
    public void a() {
        J8 j8 = this.f6669i;
        if (j8 != null) {
            j8.a((J8.a) null);
        }
        this.f6665b.a();
    }
}
