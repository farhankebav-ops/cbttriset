package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C2531r4;
import com.ironsource.C2569t8;
import com.ironsource.InterfaceC2616w4;
import com.ironsource.InterfaceC2633x4;
import com.ironsource.InterfaceC2650y4;
import com.ironsource.V7;
import com.ironsource.Y4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V7 f10003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10004b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f10005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f10006b;

        public a(l.a aVar, f.c cVar) {
            this.f10005a = aVar;
            this.f10006b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f10005a == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", false);
                jSONObject.put("reason", n.this.f10004b);
                this.f10005a.a(new f.a(this.f10006b.f(), jSONObject));
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2650y4 f10008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y4 f10009b;

        public b(InterfaceC2650y4 interfaceC2650y4, Y4 y42) {
            this.f10008a = interfaceC2650y4;
            this.f10009b = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10008a.a(C2569t8.e.RewardedVideo, this.f10009b.h(), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2650y4 f10011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f10012b;

        public c(InterfaceC2650y4 interfaceC2650y4, JSONObject jSONObject) {
            this.f10011a = interfaceC2650y4;
            this.f10012b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10011a.b(this.f10012b.optString("demandSourceName"), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f10014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y4 f10015b;

        public d(InterfaceC2633x4 interfaceC2633x4, Y4 y42) {
            this.f10014a = interfaceC2633x4;
            this.f10015b = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10014a.a(C2569t8.e.Interstitial, this.f10015b.h(), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f10017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10018b;

        public e(InterfaceC2633x4 interfaceC2633x4, String str) {
            this.f10017a = interfaceC2633x4;
            this.f10018b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10017a.a(this.f10018b, n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f10020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y4 f10021b;

        public f(InterfaceC2633x4 interfaceC2633x4, Y4 y42) {
            this.f10020a = interfaceC2633x4;
            this.f10021b = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10020a.a(this.f10021b.h(), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f10023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f10024b;

        public g(InterfaceC2633x4 interfaceC2633x4, JSONObject jSONObject) {
            this.f10023a = interfaceC2633x4;
            this.f10024b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10023a.d(this.f10024b.optString("demandSourceName"), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2633x4 f10026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y4 f10027b;

        public h(InterfaceC2633x4 interfaceC2633x4, Y4 y42) {
            this.f10026a = interfaceC2633x4;
            this.f10027b = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10026a.d(this.f10027b.h(), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2616w4 f10029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f10030b;

        public i(InterfaceC2616w4 interfaceC2616w4, Map map) {
            this.f10029a = interfaceC2616w4;
            this.f10030b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10029a.c((String) this.f10030b.get("demandSourceName"), n.this.f10004b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2616w4 f10032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f10033b;

        public j(InterfaceC2616w4 interfaceC2616w4, JSONObject jSONObject) {
            this.f10032a = interfaceC2616w4;
            this.f10033b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10032a.c(this.f10033b.optString("demandSourceName"), n.this.f10004b);
        }
    }

    public n(String str, V7 v7) {
        this.f10003a = v7;
        this.f10004b = str;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
    }

    @Override // com.ironsource.sdk.controller.l
    public C2569t8.c h() {
        return C2569t8.c.Native;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        if (interfaceC2633x4 != null) {
            a(new f(interfaceC2633x4, y42));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        return false;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2650y4 interfaceC2650y4) {
        if (interfaceC2650y4 != null) {
            a(new b(interfaceC2650y4, y42));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2650y4 interfaceC2650y4) {
        if (interfaceC2650y4 != null) {
            a(new c(interfaceC2650y4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2633x4 interfaceC2633x4) {
        if (interfaceC2633x4 != null) {
            a(new d(interfaceC2633x4, y42));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC2633x4 interfaceC2633x4) {
        if (interfaceC2633x4 != null) {
            a(new e(interfaceC2633x4, str));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2633x4 interfaceC2633x4) {
        if (interfaceC2633x4 != null) {
            a(new g(interfaceC2633x4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        if (interfaceC2633x4 != null) {
            a(new h(interfaceC2633x4, y42));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2616w4 interfaceC2616w4) {
        if (interfaceC2616w4 != null) {
            interfaceC2616w4.a(C2569t8.e.Banner, y42.h(), this.f10004b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2616w4 interfaceC2616w4) {
        if (interfaceC2616w4 != null) {
            a(new i(interfaceC2616w4, map));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2616w4 interfaceC2616w4) {
        if (interfaceC2616w4 != null) {
            a(new j(interfaceC2616w4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        a(new a(aVar, cVar));
    }

    public void a(Runnable runnable) {
        V7 v7 = this.f10003a;
        if (v7 != null) {
            v7.c(runnable);
        }
    }
}
