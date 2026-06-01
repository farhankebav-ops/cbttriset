package com.ironsource;

import com.ironsource.Q1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.r2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2529r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f9743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC2595v0 f9744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.ironsource.mediationsdk.e f9745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2298e2 f9746d;

    /* JADX INFO: renamed from: com.ironsource.r2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements Q1.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC2546s2 f9748b;

        public a(InterfaceC2546s2 interfaceC2546s2) {
            this.f9748b = interfaceC2546s2;
        }

        @Override // com.ironsource.Q1.d
        public void a(Q1 auction) {
            kotlin.jvm.internal.k.e(auction, "auction");
            C2529r2.this.b(auction, this.f9748b);
        }

        @Override // com.ironsource.Q1.d
        public void a(Q1 auction, String error) {
            kotlin.jvm.internal.k.e(auction, "auction");
            kotlin.jvm.internal.k.e(error, "error");
            C2529r2.this.b(auction, this.f9748b);
        }
    }

    public C2529r2(V0 adTools, AbstractC2595v0 adUnitData) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.f9743a = adTools;
        this.f9744b = adUnitData;
        C2496p2 c2496p2E = adUnitData.e();
        String strD = IronSourceUtils.d();
        kotlin.jvm.internal.k.d(strD, "getSessionId()");
        com.ironsource.mediationsdk.e eVar = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(c2496p2E, strD));
        this.f9745c = eVar;
        this.f9746d = new C2298e2(adTools, eVar);
    }

    public final C2298e2 b() {
        return this.f9746d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Q1 q12, InterfaceC2546s2 interfaceC2546s2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(com.google.android.gms.ads.internal.client.a.i(q12.d().c(), "auction waterfallString = ")));
        if (!q12.g()) {
            ironLog.verbose(a("auction failed - no candidates"));
            this.f9743a.e().b().a(1005, "No candidates available for auctioning");
            interfaceC2546s2.a(C2663z0.e(this.f9744b.b().a()), "no available ad to load");
        } else {
            this.f9743a.e().b().b(q12.d().c().toString());
            int iF = this.f9743a.f();
            this.f9745c.a(ContextProvider.getInstance().getApplicationContext(), a(q12, iF), new b(interfaceC2546s2, q12));
        }
    }

    public void a(InterfaceC2546s2 completionListener) {
        kotlin.jvm.internal.k.e(completionListener, "completionListener");
        IronLog.INTERNAL.verbose(a());
        this.f9743a.e().b().a(this.f9744b.b().d());
        a(new Q1(this.f9743a, this.f9744b), completionListener);
    }

    /* JADX INFO: renamed from: com.ironsource.r2$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements S1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2546s2 f9749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Q1 f9750b;

        public b(InterfaceC2546s2 interfaceC2546s2, Q1 q12) {
            this.f9749a = interfaceC2546s2;
            this.f9750b = q12;
        }

        @Override // com.ironsource.S1
        public void a(List<C2461n2> newWaterfall, String auctionId, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str) {
            kotlin.jvm.internal.k.e(newWaterfall, "newWaterfall");
            kotlin.jvm.internal.k.e(auctionId, "auctionId");
            this.f9749a.a(newWaterfall, this.f9750b.c(), auctionId, c2461n2, jSONObject, jSONObject2, i2, j, i8, str);
        }

        @Override // com.ironsource.S1
        public void a(int i2, String str, int i8, String auctionFallback, long j) {
            kotlin.jvm.internal.k.e(auctionFallback, "auctionFallback");
            this.f9749a.a(i2, str, i8, auctionFallback, j);
        }
    }

    private final void a(Q1 q12, InterfaceC2546s2 interfaceC2546s2) {
        if (!q12.f()) {
            b(q12, interfaceC2546s2);
        } else {
            q12.a(new a(interfaceC2546s2));
        }
    }

    private final com.ironsource.mediationsdk.i a(Q1 q12, int i2) {
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f9744b.b().a());
        iVar.b(IronSourceUtils.g());
        iVar.a(q12.d().a());
        iVar.a(q12.d().b());
        iVar.a(this.f9743a.h());
        iVar.a(i2);
        iVar.a(this.f9743a.k());
        Hf hfG = this.f9744b.b().g();
        iVar.e(hfG != null ? hfG.b() : false);
        iVar.a(this.f9744b.b().d());
        InterfaceC2352h2 interfaceC2352h2I = this.f9743a.i();
        if (interfaceC2352h2I != null) {
            interfaceC2352h2I.a(iVar);
        }
        return iVar;
    }

    private final String a(String str) {
        return C2459n0.a(this.f9743a, str, (String) null, 2, (Object) null);
    }

    private final String a() {
        return C2459n0.a(this.f9743a, (String) null, (String) null, 2, (Object) null);
    }
}
