package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.A4;
import com.ironsource.A8;
import com.ironsource.B4;
import com.ironsource.B8;
import com.ironsource.C2230a6;
import com.ironsource.C2300e4;
import com.ironsource.C2328fe;
import com.ironsource.C2354h4;
import com.ironsource.C2390j5;
import com.ironsource.C2506pc;
import com.ironsource.C2528r1;
import com.ironsource.C2531r4;
import com.ironsource.C2569t8;
import com.ironsource.C2586u8;
import com.ironsource.C2603v8;
import com.ironsource.EnumC2285d7;
import com.ironsource.G5;
import com.ironsource.InterfaceC2249b7;
import com.ironsource.InterfaceC2616w4;
import com.ironsource.InterfaceC2633x4;
import com.ironsource.InterfaceC2650y4;
import com.ironsource.L;
import com.ironsource.Lg;
import com.ironsource.Mb;
import com.ironsource.Ob;
import com.ironsource.Pb;
import com.ironsource.T3;
import com.ironsource.V7;
import com.ironsource.Y4;
import com.ironsource.Z4;
import com.ironsource.Z5;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e implements com.ironsource.sdk.controller.c, com.ironsource.sdk.controller.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.sdk.controller.l f9904b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownTimer f9906d;
    private final V7 g;
    private final Lg h;
    private final C2506pc k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9903a = "e";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2569t8.b f9905c = C2569t8.b.None;
    private final T3 e = new T3("NativeCommandExecutor");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T3 f9907f = new T3("ControllerCommandsExecutor");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, l.a> f9908i = new HashMap();
    private final Map<String, l.b> j = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f9909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f9910b;

        public a(JSONObject jSONObject, InterfaceC2633x4 interfaceC2633x4) {
            this.f9909a = jSONObject;
            this.f9910b = interfaceC2633x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9909a, this.f9910b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f9912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f9913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f9914c;

        public b(Y4 y42, Map map, InterfaceC2633x4 interfaceC2633x4) {
            this.f9912a = y42;
            this.f9913b = map;
            this.f9914c = interfaceC2633x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9912a, this.f9913b, this.f9914c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Y4 f9918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC2616w4 f9919d;

        public c(String str, String str2, Y4 y42, InterfaceC2616w4 interfaceC2616w4) {
            this.f9916a = str;
            this.f9917b = str2;
            this.f9918c = y42;
            this.f9919d = interfaceC2616w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9916a, this.f9917b, this.f9918c, this.f9919d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f9920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2616w4 f9921b;

        public d(JSONObject jSONObject, InterfaceC2616w4 interfaceC2616w4) {
            this.f9920a = jSONObject;
            this.f9921b = interfaceC2616w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9920a, this.f9921b);
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class RunnableC0196e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f9923a;

        public RunnableC0196e(Y4 y42) {
            this.f9923a = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9923a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f9925a;

        public f(Y4 y42) {
            this.f9925a = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.b(this.f9925a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f9927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f9928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC2616w4 f9929c;

        public g(Y4 y42, Map map, InterfaceC2616w4 interfaceC2616w4) {
            this.f9927a = y42;
            this.f9928b = map;
            this.f9929c = interfaceC2616w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9927a, this.f9928b, this.f9929c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f9931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f9932b;

        public h(l.a aVar, f.c cVar) {
            this.f9931a = aVar;
            this.f9932b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.f9904b != null) {
                if (this.f9931a != null) {
                    eVar.f9908i.put(this.f9932b.f(), this.f9931a);
                }
                e.this.f9904b.a(this.f9932b, this.f9931a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f9934a;

        public i(JSONObject jSONObject) {
            this.f9934a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.b(this.f9934a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a();
                e.this.f9904b = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class k extends CountDownTimer {
        public k(long j, long j3) {
            super(j, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f9903a, "Global Controller Timer Finish");
            e.this.d(C2300e4.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f9903a, "Global Controller Timer Tick " + j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9940b;

        public m(String str, String str2) {
            this.f9939a = str;
            this.f9940b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.f9904b = eVar.b(eVar.h.b(), e.this.h.d(), e.this.h.f(), e.this.h.e(), e.this.h.g(), e.this.h.c(), this.f9939a, this.f9940b);
                e.this.f9904b.b();
            } catch (Throwable th) {
                C2531r4.d().a(th);
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class n extends CountDownTimer {
        public n(long j, long j3) {
            super(j, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f9903a, "Recovered Controller | Global Controller Timer Finish");
            e.this.d(C2300e4.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f9903a, "Recovered Controller | Global Controller Timer Tick " + j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Y4 f9945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC2650y4 f9946d;

        public o(String str, String str2, Y4 y42, InterfaceC2650y4 interfaceC2650y4) {
            this.f9943a = str;
            this.f9944b = str2;
            this.f9945c = y42;
            this.f9946d = interfaceC2650y4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9943a, this.f9944b, this.f9945c, this.f9946d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f9947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2650y4 f9948b;

        public p(JSONObject jSONObject, InterfaceC2650y4 interfaceC2650y4) {
            this.f9947a = jSONObject;
            this.f9948b = interfaceC2650y4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9947a, this.f9948b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Y4 f9952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f9953d;

        public q(String str, String str2, Y4 y42, InterfaceC2633x4 interfaceC2633x4) {
            this.f9950a = str;
            this.f9951b = str2;
            this.f9952c = y42;
            this.f9953d = interfaceC2633x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9950a, this.f9951b, this.f9952c, this.f9953d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f9955b;

        public r(String str, InterfaceC2633x4 interfaceC2633x4) {
            this.f9954a = str;
            this.f9955b = interfaceC2633x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.a(this.f9954a, this.f9955b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f9957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f9958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f9959c;

        public s(Y4 y42, Map map, InterfaceC2633x4 interfaceC2633x4) {
            this.f9957a = y42;
            this.f9958b = map;
            this.f9959c = interfaceC2633x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            A8.a(C2328fe.j, new C2603v8().a(G5.f6815v, this.f9957a.f()).a(G5.f6816w, B8.a(this.f9957a, C2569t8.e.Interstitial)).a(G5.f6817x, Boolean.valueOf(B8.a(this.f9957a))).a(G5.I, Long.valueOf(L.f7071a.b(this.f9957a.h()))).a());
            com.ironsource.sdk.controller.l lVar = e.this.f9904b;
            if (lVar != null) {
                lVar.b(this.f9957a, this.f9958b, this.f9959c);
            }
        }
    }

    public e(Context context, C2354h4 c2354h4, Z4 z42, V7 v7, int i2, JSONObject jSONObject, String str, String str2, C2506pc c2506pc) {
        this.k = c2506pc;
        this.g = v7;
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        C2390j5 c2390j5A = C2390j5.a(networkStorageDir, v7, jSONObject);
        this.h = new Lg(context, c2354h4, z42, i2, c2390j5A, networkStorageDir);
        a(context, c2354h4, z42, i2, c2390j5A, networkStorageDir, str, str2);
    }

    private void l() {
        Logger.i(this.f9903a, "handleReadyState");
        this.f9905c = C2569t8.b.Ready;
        CountDownTimer countDownTimer = this.f9906d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        n();
        this.f9907f.c();
        this.f9907f.a();
        com.ironsource.sdk.controller.l lVar = this.f9904b;
        if (lVar != null) {
            lVar.f();
        }
    }

    private boolean m() {
        return C2569t8.b.Ready.equals(this.f9905c);
    }

    private void n() {
        this.h.a(true);
        com.ironsource.sdk.controller.l lVar = this.f9904b;
        if (lVar != null) {
            lVar.a(this.h.i());
        }
    }

    public com.ironsource.sdk.controller.l k() {
        return this.f9904b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context, C2354h4 c2354h4, Z4 z42, int i2, C2390j5 c2390j5, String str, String str2, String str3) {
        v vVarB;
        try {
            vVarB = b(context, c2354h4, z42, i2, c2390j5, str, str2, str3);
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f9904b = vVarB;
            vVarB.b();
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            C2531r4.d().a(th3);
            d(Log.getStackTraceString(th3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        A8.a(C2328fe.f8536d, new C2603v8().a(G5.A, str).a());
        this.f9905c = C2569t8.b.Loading;
        this.f9904b = new com.ironsource.sdk.controller.n(str, this.g);
        this.e.c();
        this.e.a();
        V7 v7 = this.g;
        if (v7 != null) {
            v7.c(new l());
        }
    }

    private void e(String str) {
        IronSourceNetwork.updateInitFailed(new C2586u8(1001, str));
    }

    private l.a i() {
        return new l.a() { // from class: com.ironsource.sdk.controller.x
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                this.f10204a.a(aVar);
            }
        };
    }

    private l.b j() {
        return new l.b() { // from class: com.ironsource.sdk.controller.y
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(Ob ob) {
                this.f10205a.a(ob);
            }
        };
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
    }

    @Override // com.ironsource.sdk.controller.l
    @Deprecated
    public void f() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.f9904b) == null) {
            return;
        }
        lVar.g();
    }

    @Override // com.ironsource.sdk.controller.l
    public C2569t8.c h() {
        com.ironsource.sdk.controller.l lVar = this.f9904b;
        return lVar != null ? lVar.h() : C2569t8.c.None;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(f.a aVar) {
        l.a aVarRemove = this.f9908i.remove(aVar.c());
        if (aVarRemove != null) {
            aVarRemove.a(aVar);
        }
    }

    private void b(Runnable runnable) {
        a(runnable, 0L);
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.f9904b) == null) {
            return;
        }
        lVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v b(Context context, C2354h4 c2354h4, Z4 z42, int i2, C2390j5 c2390j5, String str, String str2, String str3) throws Throwable {
        A8.a(C2328fe.f8535c);
        v vVar = new v(context, z42, c2354h4, this, this.g, i2, c2390j5, str, i(), j(), str2, str3);
        C2230a6 c2230a6 = new C2230a6(context, c2390j5, new Z5(this.g.a()), new Pb(c2390j5.a()));
        vVar.a(new u(context));
        vVar.a(new com.ironsource.sdk.controller.o(context));
        vVar.a(new com.ironsource.sdk.controller.q(context));
        vVar.a(new com.ironsource.sdk.controller.i(context));
        vVar.a(new com.ironsource.sdk.controller.a(context));
        vVar.a(new com.ironsource.sdk.controller.j(c2390j5.a(), c2230a6));
        vVar.a(new C2528r1());
        vVar.a(new B4(context, new A4()));
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Ob ob) {
        l.b bVar = this.j.get(ob.d());
        if (bVar != null) {
            bVar.a(ob);
        }
    }

    @Override // com.ironsource.sdk.controller.c
    public void c() {
        Logger.i(this.f9903a, "handleControllerLoaded");
        this.f9905c = C2569t8.b.Loaded;
        this.e.c();
        this.e.a();
    }

    private void a(Runnable runnable, long j3) {
        V7 v7 = this.g;
        if (v7 != null) {
            v7.d(runnable, j3);
        } else {
            Logger.e(this.f9903a, "mThreadManager = null");
        }
    }

    private void a(final Context context, final C2354h4 c2354h4, final Z4 z42, final int i2, final C2390j5 c2390j5, final String str, final String str2, final String str3) {
        int iH = Mb.U().g().h();
        if (iH > 0) {
            A8.a(C2328fe.B, new C2603v8().a(G5.y, String.valueOf(iH)).a());
        }
        a(new Runnable() { // from class: com.ironsource.sdk.controller.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f10198a.c(context, c2354h4, z42, i2, c2390j5, str, str2, str3);
            }
        }, iH);
        this.f9906d = new k(200000L, 1000L).start();
    }

    @Override // com.ironsource.sdk.controller.c
    public void c(String str) {
        Logger.i(this.f9903a, "handleControllerFailed ");
        C2603v8 c2603v8 = new C2603v8();
        c2603v8.a(G5.A, str);
        c2603v8.a(G5.y, String.valueOf(this.h.l()));
        A8.a(C2328fe.f8540o, c2603v8.a());
        this.h.a(false);
        e(str);
        if (this.f9906d != null) {
            Logger.i(this.f9903a, "cancel timer mControllerReadyTimer");
            this.f9906d.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.c
    public void d() {
        Logger.i(this.f9903a, "handleControllerReady ");
        this.k.a(h());
        if (C2569t8.c.Web.equals(h())) {
            A8.a(C2328fe.e, new C2603v8().a(G5.y, String.valueOf(this.h.l())).a());
            IronSourceNetwork.updateInitSucceeded();
        }
        l();
    }

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    @Override // com.ironsource.InterfaceC2321f7
    public void a(InterfaceC2249b7 interfaceC2249b7) {
        EnumC2285d7 enumC2285d7B = interfaceC2249b7.b();
        if (enumC2285d7B == EnumC2285d7.SendEvent) {
            A8.a(C2328fe.A, new C2603v8().a(G5.y, interfaceC2249b7.a() + " : strategy: " + enumC2285d7B).a());
            return;
        }
        if (enumC2285d7B == EnumC2285d7.NativeController) {
            com.ironsource.sdk.controller.n nVar = new com.ironsource.sdk.controller.n(interfaceC2249b7.a(), this.g);
            this.f9904b = nVar;
            this.k.a(nVar.h());
            A8.a(C2328fe.f8536d, new C2603v8().a(G5.A, interfaceC2249b7.a() + " : strategy: " + enumC2285d7B).a());
            A8.a(C2328fe.A, new C2603v8().a(G5.y, interfaceC2249b7.a() + " : strategy: " + enumC2285d7B).a());
        }
    }

    @Override // com.ironsource.sdk.controller.c
    public void b(String str) {
        A8.a(C2328fe.y, new C2603v8().a(G5.y, str).a());
        CountDownTimer countDownTimer = this.f9906d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        this.f9907f.a(new s(y42, map, interfaceC2633x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42) {
        this.f9907f.a(new f(y42));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        this.f9907f.a(new i(jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.f9904b) == null) {
            return;
        }
        lVar.b(context);
    }

    private void a(C2569t8.e eVar, Y4 y42, String str, String str2) {
        Logger.i(this.f9903a, "recoverWebController for product: " + eVar.toString());
        C2603v8 c2603v8 = new C2603v8();
        c2603v8.a(G5.f6816w, eVar.toString());
        c2603v8.a(G5.f6815v, y42.f());
        A8.a(C2328fe.f8534b, c2603v8.a());
        this.h.n();
        a();
        b(new m(str, str2));
        this.f9906d = new n(200000L, 1000L).start();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2650y4 interfaceC2650y4) {
        if (this.h.a(h(), this.f9905c)) {
            a(C2569t8.e.RewardedVideo, y42, str, str2);
        }
        this.f9907f.a(new o(str, str2, y42, interfaceC2650y4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2650y4 interfaceC2650y4) {
        this.f9907f.a(new p(jSONObject, interfaceC2650y4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2633x4 interfaceC2633x4) {
        if (this.h.a(h(), this.f9905c)) {
            a(C2569t8.e.Interstitial, y42, str, str2);
        }
        this.f9907f.a(new q(str, str2, y42, interfaceC2633x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC2633x4 interfaceC2633x4) {
        Logger.i(this.f9903a, "load interstitial");
        this.f9907f.a(new r(str, interfaceC2633x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2633x4 interfaceC2633x4) {
        this.f9907f.a(new a(jSONObject, interfaceC2633x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        this.f9907f.a(new b(y42, map, interfaceC2633x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        if (this.f9904b == null || !m()) {
            return false;
        }
        return this.f9904b.a(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2616w4 interfaceC2616w4) {
        if (this.h.a(h(), this.f9905c)) {
            a(C2569t8.e.Banner, y42, str, str2);
        }
        this.f9907f.a(new c(str, str2, y42, interfaceC2616w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2616w4 interfaceC2616w4) {
        this.f9907f.a(new d(jSONObject, interfaceC2616w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42) {
        this.f9907f.a(new RunnableC0196e(y42));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2616w4 interfaceC2616w4) {
        this.f9907f.a(new g(y42, map, interfaceC2616w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        this.f9907f.a(new h(aVar, cVar));
    }

    public void a(String str, l.b bVar) {
        this.j.put(str, bVar);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.f9904b) == null) {
            return;
        }
        lVar.a(context);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
        Logger.i(this.f9903a, "destroy controller");
        CountDownTimer countDownTimer = this.f9906d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        T3 t3 = this.f9907f;
        if (t3 != null) {
            t3.b();
        }
        this.f9906d = null;
        b(new j());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.f9904b.a(activity);
    }
}
