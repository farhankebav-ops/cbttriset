package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ironsource.D0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.mediation.R;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Da implements InterfaceC2631x2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f6611n = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f6612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X2 f6614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LevelPlayBannerAdView.Config f6615d;
    private final C2459n0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final U8 f6616f;
    private final LevelPlayAdSize g;
    private LevelPlayBannerAdViewListener h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f6617i;
    private InterfaceC2484o7 j;
    private Boolean k;
    private C2434ld l;
    private boolean m;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final q5.i a(Context context, AttributeSet attributeSet) {
            kotlin.jvm.internal.k.e(context, "context");
            String str = "";
            if (attributeSet == null) {
                return new q5.i("", LevelPlayBannerAdView.Config.Companion.empty());
            }
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LevelPlayBannerAdView);
            kotlin.jvm.internal.k.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.LevelPlayBannerAdView)");
            try {
                LevelPlayBannerAdView.Config.Builder builder = new LevelPlayBannerAdView.Config.Builder();
                if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LevelPlayBannerAdView_bidFloor)) {
                    builder.setBidFloor(typedArrayObtainStyledAttributes.getFloat(R.styleable.LevelPlayBannerAdView_bidFloor, -1.0f));
                }
                String string = typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adSize);
                if (string != null) {
                    builder.setAdSize(LevelPlayAdSize.Companion.createAdSize$mediationsdk_release(string));
                }
                String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adUnitId);
                if (string2 != null) {
                    str = string2;
                }
                q5.i iVar = new q5.i(str, builder.build());
                typedArrayObtainStyledAttributes.recycle();
                return iVar;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }

        private a() {
        }
    }

    public Da(UUID adId, String adUnitId, X2 bannerContainer, LevelPlayBannerAdView.Config config, C2459n0 adTools) {
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        this.f6612a = adId;
        this.f6613b = adUnitId;
        this.f6614c = bannerContainer;
        this.f6615d = config;
        this.e = adTools;
        this.f6616f = Mb.f7131s.d().A();
        LevelPlayAdSize adSize = config.getAdSize();
        this.g = adSize == null ? LevelPlayAdSize.BANNER : adSize;
        String placementName = config.getPlacementName();
        this.f6617i = placementName == null ? "" : placementName;
        adTools.e().a(new C2458n(IronSource.a.BANNER, adId, adUnitId));
        Double bidFloor = config.getBidFloor();
        if (bidFloor != null) {
            adTools.e().f().a(bidFloor.doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Da this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        if (!this$0.m) {
            IronLog.INTERNAL.warning(C2459n0.a(this$0.e, "Banner not loaded", (String) null, 2, (Object) null));
            return;
        }
        if (this$0.j == null) {
            IronLog.INTERNAL.warning(C2459n0.a(this$0.e, "Banner already destroyed", (String) null, 2, (Object) null));
            return;
        }
        C2623wb.a(this$0.e, new gh(this$0, 1), 0L, 2, (Object) null);
        InterfaceC2484o7 interfaceC2484o7 = this$0.j;
        if (interfaceC2484o7 != null) {
            interfaceC2484o7.c();
        }
        this$0.j = null;
        this$0.k = null;
        this$0.h = null;
    }

    public final void b() {
        IronLog.API.info("LevelPlayBannerAdView.destroyBanner()");
        this.e.d(new gh(this, 0));
    }

    private final boolean h() {
        if (this.f6613b.length() == 0) {
            String string = this.f6612a.toString();
            kotlin.jvm.internal.k.d(string, "adId.toString()");
            a(new LevelPlayAdError(string, this.f6613b, LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"));
            return false;
        }
        if (!this.e.g()) {
            String string2 = this.f6612a.toString();
            kotlin.jvm.internal.k.d(string2, "adId.toString()");
            a(new LevelPlayAdError(string2, this.f6613b, LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "load must be called after init success callback"));
            return false;
        }
        C2235ab c2235abA = Mb.f7131s.d().e().a();
        if (c2235abA != null && c2235abA.a(this.f6613b, LevelPlay.AdFormat.BANNER)) {
            return true;
        }
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this.h;
        if (levelPlayBannerAdViewListener != null) {
            String string3 = this.f6612a.toString();
            kotlin.jvm.internal.k.d(string3, "adId.toString()");
            levelPlayBannerAdViewListener.onAdLoadFailed(new LevelPlayAdError(string3, this.f6613b, LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
        }
        return false;
    }

    public final UUID c() {
        return this.f6612a;
    }

    public final LevelPlayAdSize d() {
        return this.g;
    }

    public final String e() {
        return this.f6613b;
    }

    public final LevelPlayBannerAdViewListener f() {
        return this.h;
    }

    public final String g() {
        return this.f6617i;
    }

    public final void i() {
        IronLog.API.info("LevelPlayBannerAdView.loadAd()");
        this.e.d(new gh(this, 2));
    }

    public final void j() {
        q5.x xVar;
        IronLog.API.info("LevelPlayBannerAdView.pauseAutoRefresh()");
        InterfaceC2484o7 interfaceC2484o7 = this.j;
        if (interfaceC2484o7 != null) {
            this.e.d(new hh(this, interfaceC2484o7, 1));
            xVar = q5.x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            this.k = Boolean.FALSE;
        }
    }

    public final void k() {
        q5.x xVar;
        IronLog.API.info("LevelPlayBannerAdView.resumeAutoRefresh()");
        InterfaceC2484o7 interfaceC2484o7 = this.j;
        if (interfaceC2484o7 != null) {
            this.e.d(new hh(this, interfaceC2484o7, 0));
            xVar = q5.x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            this.k = Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Da this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f6614c.removeAllViews();
        ViewParent parent = this$0.f6614c.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this$0.f6614c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Da this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        if (this$0.m) {
            IronLog.INTERNAL.warning(C2459n0.a(this$0.e, "Banner load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.m = true;
        if (this$0.h()) {
            InterfaceC2484o7 interfaceC2484o7A = this$0.a();
            this$0.j = interfaceC2484o7A;
            Boolean bool = this$0.k;
            if (bool != null) {
                if (bool.booleanValue()) {
                    interfaceC2484o7A.e();
                } else {
                    interfaceC2484o7A.d();
                }
            }
            interfaceC2484o7A.b();
        }
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void d(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new fh(adInfo, this, 2));
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void e(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new fh(adInfo, this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdScreenDismissed() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdCollapsed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdScreenPresented() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdExpanded(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Da this$0, InterfaceC2484o7 it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(it, "$it");
        this$0.e.e().f().c();
        it.e();
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void b(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new fh(adInfo, this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdDisplayed() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayed(adInfo);
        }
    }

    public final void a(LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        IronLog.API.info("LevelPlayBannerAdView.setBannerListener()");
        this.e.d(new ti(4, this, levelPlayBannerAdViewListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Da this$0, LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.h = levelPlayBannerAdViewListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLeftApplication() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLeftApplication(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Da this$0, InterfaceC2484o7 it) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(it, "$it");
        this$0.e.e().f().b();
        it.d();
    }

    public /* synthetic */ Da(UUID uuid, String str, X2 x2, LevelPlayBannerAdView.Config config, C2459n0 c2459n0, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? C2670z7.f10631a.a() : uuid, str, x2, config, (i2 & 16) != 0 ? new C2459n0(IronSource.a.BANNER, D0.b.MEDIATION) : c2459n0);
    }

    private final InterfaceC2484o7 a() {
        this.l = this.e.a(this.f6617i);
        Context context = this.f6614c.getContext();
        if (context instanceof Activity) {
            ContextProvider.getInstance().updateActivity((Activity) context);
        }
        UUID uuid = this.f6612a;
        String str = this.f6613b;
        C2434ld c2434ld = this.l;
        if (c2434ld != null) {
            K2 k22 = new K2(uuid, str, c2434ld, this.g, null, null, this.f6616f.a(), this.f6615d.getBidFloor(), 48, null);
            this.e.e().a(new B0(this.e, k22, null, 4, 0 == true ? 1 : 0));
            ISBannerSize iSBannerSizeA = this.e.a(k22.h());
            E5 e5E = this.e.e();
            C2459n0 c2459n0 = this.e;
            C2434ld c2434ld2 = this.l;
            if (c2434ld2 != null) {
                e5E.a(new Z2(c2459n0, iSBannerSizeA, c2434ld2.c()));
                if (Mb.f7131s.d().g().c()) {
                    IronLog.INTERNAL.verbose(C2459n0.a(this.e, "Using legacy BannerAdController", (String) null, 2, (Object) null));
                    return new C2614w2(this, this.e, k22, this.f6614c);
                }
                IronLog.INTERNAL.verbose(C2459n0.a(this.e, "Using new LevelPlayBannerAdController", (String) null, 2, (Object) null));
                return new Aa(this, this.e, k22, this.f6614c);
            }
            kotlin.jvm.internal.k.l("bannerPlacement");
            throw null;
        }
        kotlin.jvm.internal.k.l("bannerPlacement");
        throw null;
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void c(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new fh(adInfo, this, 0));
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void a(LevelPlayAdInfo adInfo, boolean z2) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new androidx.work.impl.a(z2, adInfo, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(boolean z2, LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLoaded() isReload: " + z2 + " adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoaded(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void a(LevelPlayAdError levelPlayAdError) {
        if (levelPlayAdError != null) {
            this.e.e(new ti(3, levelPlayAdError, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError it, Da this$0) {
        kotlin.jvm.internal.k.e(it, "$it");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdLoadFailed() error: " + it);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoadFailed(it);
        }
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void a(LevelPlayAdInfo adInfo, LevelPlayAdError levelPlayAdError) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (levelPlayAdError != null) {
            this.e.e(new androidx.camera.core.processing.c(adInfo, levelPlayAdError, this, 11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdInfo adInfo, LevelPlayAdError it, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(it, "$it");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdDisplayFailed() adInfo " + adInfo + " error: " + it);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayFailed(adInfo, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdInfo adInfo, Da this$0) {
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("LevelPlayBannerAdViewListener.onBannerAdClicked() adInfo: " + adInfo);
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.h;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdClicked(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC2631x2
    public void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.e(new fh(adInfo, this, 3));
    }
}
