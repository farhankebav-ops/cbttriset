package com.ironsource;

import com.ironsource.D0;
import com.ironsource.InterfaceC2432lb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.mb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2450mb extends AbstractC2656ya implements Wb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UUID f8958d;
    private final C2414kb e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Tb f8959f;
    private String g;
    private C2434ld h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC2488ob f8960i;
    private AdapterNativeAdData j;
    private AdapterNativeAdViewBinder k;

    public /* synthetic */ C2450mb(UUID uuid, C2414kb c2414kb, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? C2670z7.f10631a.a() : uuid, c2414kb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2450mb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.API.info(String.valueOf(this$0));
        try {
            Tb tb = this$0.f8959f;
            if (tb == null) {
                kotlin.jvm.internal.k.l("nativeAdController");
                throw null;
            }
            tb.q();
            this$0.f8960i = null;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2450mb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        if (this$0.c()) {
            IronLog.INTERNAL.warning(C2459n0.a(this$0.a(), "Native ad load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            Tb tb = this$0.f8959f;
            if (tb != null) {
                tb.r();
            } else {
                kotlin.jvm.internal.k.l("nativeAdController");
                throw null;
            }
        }
    }

    @Override // com.ironsource.AbstractC2656ya
    public boolean d() {
        this.f8959f = e();
        return true;
    }

    public final AdapterNativeAdViewBinder l() {
        return this.k;
    }

    public final String m() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    public final void n() {
        a(new li(this, 1));
    }

    @Override // com.ironsource.Wb
    public void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        String string = this.f8958d.toString();
        kotlin.jvm.internal.k.d(string, "adId.toString()");
        b(new ti(18, this, new LevelPlayAdError(ironSourceError, string, b())));
    }

    private final Tb e() {
        this.h = a().c(this.g);
        UUID uuid = this.f8958d;
        String strB = b();
        C2434ld c2434ld = this.h;
        if (c2434ld == null) {
            kotlin.jvm.internal.k.l("placement");
            throw null;
        }
        C2290dc c2290dc = new C2290dc(uuid, strB, c2434ld);
        a(c2290dc);
        return new Tb(this, a(), c2290dc);
    }

    public final void f() {
        a(new li(this, 0));
    }

    public final UUID g() {
        return this.f8958d;
    }

    public final String h() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    public final String i() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    public final String j() {
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    public final InterfaceC2432lb.a k() {
        NativeAdDataInterface.Image icon;
        AdapterNativeAdData adapterNativeAdData = this.j;
        if (adapterNativeAdData == null || (icon = adapterNativeAdData.getIcon()) == null) {
            return null;
        }
        return new InterfaceC2432lb.a(icon.getDrawable(), icon.getUri());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2450mb(UUID adId, C2414kb nativeAd) {
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(nativeAd, "nativeAd");
        IronSource.a aVar = IronSource.a.NATIVE_AD;
        super(new C2459n0(aVar, D0.b.MEDIATION));
        this.f8958d = adId;
        this.e = nativeAd;
        this.g = "";
        a().e().a(new C2458n(aVar, adId, b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2450mb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        InterfaceC2488ob interfaceC2488ob = this$0.f8960i;
        if (interfaceC2488ob != null) {
            interfaceC2488ob.b(this$0.e, adInfo);
        }
    }

    public final void a(InterfaceC2488ob interfaceC2488ob) {
        a(new ti(20, this, interfaceC2488ob));
    }

    @Override // com.ironsource.Wb
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        b(new mi(this, adInfo, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2450mb this$0, InterfaceC2488ob interfaceC2488ob) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f8960i = interfaceC2488ob;
    }

    public final void b(String placementName) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        a(new ti(19, this, placementName));
    }

    @Override // com.ironsource.Wb
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        IronLog.CALLBACK.info(String.valueOf(this));
        Qb qb = new Qb();
        Tb tb = this.f8959f;
        if (tb != null) {
            tb.a(qb);
            this.j = qb.a();
            this.k = qb.b();
            b(new mi(this, adInfo, 1));
            return;
        }
        kotlin.jvm.internal.k.l("nativeAdController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2450mb this$0, LevelPlayAdError levelPlayError) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(levelPlayError, "$levelPlayError");
        InterfaceC2488ob interfaceC2488ob = this$0.f8960i;
        if (interfaceC2488ob != null) {
            interfaceC2488ob.a(this$0.e, levelPlayError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2450mb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        InterfaceC2488ob interfaceC2488ob = this$0.f8960i;
        if (interfaceC2488ob != null) {
            interfaceC2488ob.c(this$0.e, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2450mb this$0, String placementName) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(placementName, "$placementName");
        this$0.g = placementName;
    }
}
