package com.ironsource;

import android.text.TextUtils;
import com.ironsource.C2513q2;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.q2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2513q2 extends Ag {
    private final V0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AbstractC2595v0 f9687f;
    private final C2529r2 g;
    private final Xc h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC2546s2 f9688i;

    /* JADX INFO: renamed from: com.ironsource.q2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2546s2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C f9690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bg f9691c;

        public a(C c7, Bg bg) {
            this.f9690b = c7;
            this.f9691c = bg;
        }

        @Override // com.ironsource.InterfaceC2546s2
        public void a(final List<C2461n2> newWaterfall, final Map<String, G> adInstancePayloads, final String auctionId, final C2461n2 c2461n2, final JSONObject jSONObject, final JSONObject jSONObject2, final int i2, final long j, final int i8, final String str) {
            kotlin.jvm.internal.k.e(newWaterfall, "newWaterfall");
            kotlin.jvm.internal.k.e(adInstancePayloads, "adInstancePayloads");
            kotlin.jvm.internal.k.e(auctionId, "auctionId");
            V0 v02 = C2513q2.this.e;
            final C2513q2 c2513q2 = C2513q2.this;
            final C c7 = this.f9690b;
            final Bg bg = this.f9691c;
            v02.a(new Runnable() { // from class: com.ironsource.oi
                @Override // java.lang.Runnable
                public final void run() {
                    C2513q2.a.a(c2513q2, c7, bg, newWaterfall, adInstancePayloads, auctionId, c2461n2, jSONObject, jSONObject2, i2, j, i8, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C2513q2 this$0, C adInstanceFactory, Bg waterfallFetcherListener, List newWaterfall, Map adInstancePayloads, String auctionId, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(adInstanceFactory, "$adInstanceFactory");
            kotlin.jvm.internal.k.e(waterfallFetcherListener, "$waterfallFetcherListener");
            kotlin.jvm.internal.k.e(newWaterfall, "$newWaterfall");
            kotlin.jvm.internal.k.e(adInstancePayloads, "$adInstancePayloads");
            kotlin.jvm.internal.k.e(auctionId, "$auctionId");
            this$0.f9688i = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, newWaterfall, adInstancePayloads, auctionId, c2461n2, jSONObject, jSONObject2, i2, j, i8, str);
        }

        @Override // com.ironsource.InterfaceC2546s2
        public void a(final int i2, final String str, final int i8, final String auctionFallback, final long j) {
            kotlin.jvm.internal.k.e(auctionFallback, "auctionFallback");
            V0 v02 = C2513q2.this.e;
            final C2513q2 c2513q2 = C2513q2.this;
            final C c7 = this.f9690b;
            final Bg bg = this.f9691c;
            v02.a(new Runnable() { // from class: com.ironsource.pi
                @Override // java.lang.Runnable
                public final void run() {
                    C2513q2.a.a(c2513q2, c7, bg, i2, str, i8, auctionFallback, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C2513q2 this$0, C adInstanceFactory, Bg waterfallFetcherListener, int i2, String str, int i8, String auctionFallback, long j) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(adInstanceFactory, "$adInstanceFactory");
            kotlin.jvm.internal.k.e(waterfallFetcherListener, "$waterfallFetcherListener");
            kotlin.jvm.internal.k.e(auctionFallback, "$auctionFallback");
            this$0.f9688i = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, i2, str, i8, auctionFallback, j);
        }

        @Override // com.ironsource.InterfaceC2546s2
        public void a(int i2, String errorReason) {
            kotlin.jvm.internal.k.e(errorReason, "errorReason");
            this.f9691c.a(i2, errorReason);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2513q2(V0 adTools, AbstractC2595v0 adUnitData) {
        super(adTools, adUnitData);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.e = adTools;
        this.f9687f = adUnitData;
        C2529r2 c2529r2 = new C2529r2(adTools, adUnitData);
        this.g = c2529r2;
        this.h = c2529r2.b();
    }

    @Override // com.ironsource.Ag
    public Xc a() {
        return this.h;
    }

    @Override // com.ironsource.Ag
    public void a(C adInstanceFactory, Bg waterfallFetcherListener) {
        kotlin.jvm.internal.k.e(adInstanceFactory, "adInstanceFactory");
        kotlin.jvm.internal.k.e(waterfallFetcherListener, "waterfallFetcherListener");
        a aVar = new a(adInstanceFactory, waterfallFetcherListener);
        this.g.a(aVar);
        this.f9688i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C c7, Bg bg, List<C2461n2> list, Map<String, G> map, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.e, (String) null, (String) null, 3, (Object) null));
        C2405k2 c2405k2 = new C2405k2(str, jSONObject, c2461n2, i2, "");
        if (!TextUtils.isEmpty(str2)) {
            this.e.e().h().a(i8, str2);
        }
        a(jSONObject2);
        Cg cgA = a(list, map, c2405k2, c7);
        this.e.e().a(new U1(c2405k2));
        this.e.e().b().a(j, this.f9687f.v() + ";wtf=" + cgA.c());
        this.e.e().b().c(cgA.d());
        a(cgA, bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C c7, Bg bg, int i2, String str, int i8, String str2, long j) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.e, "Auction failed (error " + i2 + " - " + str + ")", (String) null, 2, (Object) null));
        boolean zN = this.f9687f.e().n();
        String strA = Y1.f7804a.a(zN);
        C2405k2 c2405k2 = new C2405k2(strA, null, null, i8, str2);
        E5 e5E = this.e.e();
        e5E.a(new U1(c2405k2));
        e5E.b().a(j, i2, str);
        if (zN) {
            a(c7, bg, i8, str2, strA);
        } else {
            a(bg);
        }
    }

    private final void a(Cg cg, Bg bg) {
        this.e.h().a(cg);
        bg.a(cg);
    }

    private final void a(JSONObject jSONObject) {
        int i2;
        try {
            if (jSONObject == null) {
                this.f9687f.b(false);
                IronLog.INTERNAL.verbose(C2459n0.a(this.e, a1.a.l("loading configuration from auction response is null, using the following: ", this.f9687f.v()), (String) null, 2, (Object) null));
                return;
            }
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.f9048x) && (i2 = jSONObject.getInt(com.ironsource.mediationsdk.d.f9048x)) > 0) {
                    this.f9687f.a(i2);
                }
                if (jSONObject.has(com.ironsource.mediationsdk.d.y)) {
                    this.f9687f.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.y));
                }
                this.f9687f.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.f9049z, false));
                IronLog.INTERNAL.verbose(C2459n0.a(this.e, this.f9687f.v(), (String) null, 2, (Object) null));
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.f9687f.b().a() + " Error: " + e.getMessage());
                ironLog.verbose(C2459n0.a(this.e, this.f9687f.v(), (String) null, 2, (Object) null));
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.verbose(C2459n0.a(this.e, this.f9687f.v(), (String) null, 2, (Object) null));
            throw th;
        }
    }

    private final void a(C c7, Bg bg, int i2, String str, String str2) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.e, "Moving to fallback waterfall", (String) null, 2, (Object) null));
        new Fc(this.e, this.f9687f).a(bg, i2, str, str2, c7);
    }

    private final void a(Bg bg) {
        bg.a(509, "Mediation No fill");
    }
}
