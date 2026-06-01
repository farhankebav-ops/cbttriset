package com.vungle.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ImpressionTracker;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.presenter.AdEventListener;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.WatermarkView;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import q5.f;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerView extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BannerView";
    private MRAIDAdWidget adWidget;
    private final AdPayload advertisement;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;
    private final AtomicBoolean destroyed;
    private WatermarkView imageView;
    private final f impressionTracker$delegate;
    private final AtomicBoolean isInvisibleLogged;
    private boolean isOnImpressionCalled;
    private final Placement placement;
    private MRAIDPresenter presenter;
    private final AtomicBoolean presenterStarted;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(Context context, final Placement placement, AdPayload advertisement, VungleAdSize adSize, AdConfig adConfig, final AdPlayCallback adPlayCallback, BidPayload bidPayload) throws InstantiationException {
        super(context);
        k.e(context, "context");
        k.e(placement, "placement");
        k.e(advertisement, "advertisement");
        k.e(adSize, "adSize");
        k.e(adConfig, "adConfig");
        k.e(adPlayCallback, "adPlayCallback");
        this.placement = placement;
        this.advertisement = advertisement;
        this.destroyed = new AtomicBoolean(false);
        this.presenterStarted = new AtomicBoolean(false);
        this.isInvisibleLogged = new AtomicBoolean(false);
        this.impressionTracker$delegate = n7.b.C(new BannerView$impressionTracker$2(context));
        ViewUtility viewUtility = ViewUtility.INSTANCE;
        this.calculatedPixelHeight = viewUtility.dpToPixels(context, adSize.getHeight());
        this.calculatedPixelWidth = viewUtility.dpToPixels(context, adSize.getWidth());
        AdEventListener adEventListener = new AdEventListener(adPlayCallback, placement) { // from class: com.vungle.ads.BannerView$adEventListener$1
        };
        byte b8 = 0;
        byte b9 = 0;
        try {
            MRAIDAdWidget mRAIDAdWidget = new MRAIDAdWidget(context, null, 2, 0 == true ? 1 : 0);
            this.adWidget = mRAIDAdWidget;
            mRAIDAdWidget.setCloseDelegate(new MRAIDAdWidget.CloseDelegate() { // from class: com.vungle.ads.BannerView.1
                @Override // com.vungle.ads.internal.ui.view.MRAIDAdWidget.CloseDelegate
                public void close() {
                    BannerView.this.finishAdInternal(false);
                }
            });
            mRAIDAdWidget.setOnViewTouchListener(new MRAIDAdWidget.OnViewTouchListener() { // from class: com.vungle.ads.BannerView.2
                @Override // com.vungle.ads.internal.ui.view.MRAIDAdWidget.OnViewTouchListener
                public boolean onTouch(MotionEvent motionEvent) {
                    MRAIDPresenter mRAIDPresenter = BannerView.this.presenter;
                    if (mRAIDPresenter == null) {
                        return false;
                    }
                    mRAIDPresenter.onViewTouched(motionEvent);
                    return false;
                }
            });
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            g gVar = g.f13494a;
            f fVarB = n7.b.B(gVar, new BannerView$special$$inlined$inject$1(context));
            OMTracker oMTrackerMake = m3254_init_$lambda3(n7.b.B(gVar, new BannerView$special$$inlined$inject$2(context))).make(advertisement.omEnabled());
            f fVarB2 = n7.b.B(gVar, new BannerView$special$$inlined$inject$3(context));
            VungleWebClient vungleWebClient = new VungleWebClient(advertisement, placement, m3253_init_$lambda2(fVarB).getOffloadExecutor(), m3255_init_$lambda4(fVarB2), null, null, 48, null);
            vungleWebClient.setWebViewObserver(oMTrackerMake);
            MRAIDPresenter mRAIDPresenter = new MRAIDPresenter(mRAIDAdWidget, advertisement, placement, vungleWebClient, m3253_init_$lambda2(fVarB).getJobExecutor(), oMTrackerMake, m3255_init_$lambda4(fVarB2));
            mRAIDPresenter.setEventListener(adEventListener);
            this.presenter = mRAIDPresenter;
            String watermark$vungle_ads_release = adConfig.getWatermark$vungle_ads_release();
            if (watermark$vungle_ads_release != null) {
                this.imageView = new WatermarkView(context, watermark$vungle_ads_release);
            }
        } catch (InstantiationException e) {
            adEventListener.onError(new AdCantPlayWithoutWebView(b9 == true ? 1 : 0, 1, b8 == true ? 1 : 0).setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logError$vungle_ads_release(), this.placement.getReferenceId());
            throw e;
        }
    }

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final Executors m3253_init_$lambda2(f fVar) {
        return (Executors) fVar.getValue();
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final OMTracker.Factory m3254_init_$lambda3(f fVar) {
        return (OMTracker.Factory) fVar.getValue();
    }

    /* JADX INFO: renamed from: _init_$lambda-4, reason: not valid java name */
    private static final Platform m3255_init_$lambda4(f fVar) {
        return (Platform) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHardwareAcceleration() throws Throwable {
        Logger.Companion.w(TAG, "hardwareAccelerated = " + isHardwareAccelerated());
        if (isHardwareAccelerated()) {
            return;
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.HARDWARE_ACCELERATE_DISABLED, 0L, this.advertisement.getLogEntry$vungle_ads_release(), null, 10, null);
    }

    private final ImpressionTracker getImpressionTracker() {
        return (ImpressionTracker) this.impressionTracker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logViewVisibleOnPlay() throws Throwable {
        long j = this.isInvisibleLogged.get() ? 3L : 2L;
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        SingleValueMetric singleValueMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_VISIBILITY);
        singleValueMetric.setValue(Long.valueOf(j));
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, singleValueMetric, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        Logger.Companion.d(TAG, "Log metric AD_VISIBILITY: " + j);
    }

    private final void renderAd() {
        MRAIDAdWidget mRAIDAdWidget = this.adWidget;
        if (mRAIDAdWidget != null) {
            if (!k.a(mRAIDAdWidget != null ? mRAIDAdWidget.getParent() : null, this)) {
                addView(this.adWidget, this.calculatedPixelWidth, this.calculatedPixelHeight);
                WatermarkView watermarkView = this.imageView;
                if (watermarkView != null) {
                    addView(watermarkView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    WatermarkView watermarkView2 = this.imageView;
                    if (watermarkView2 != null) {
                        watermarkView2.bringToFront();
                    }
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.calculatedPixelHeight;
            layoutParams.width = this.calculatedPixelWidth;
            requestLayout();
        }
    }

    private final void setAdVisibility(boolean z2) {
        MRAIDPresenter mRAIDPresenter;
        if (!this.isOnImpressionCalled || this.destroyed.get() || (mRAIDPresenter = this.presenter) == null) {
            return;
        }
        mRAIDPresenter.setAdVisibility(z2);
    }

    public final void finishAdInternal(boolean z2) {
        if (this.destroyed.get()) {
            return;
        }
        this.destroyed.set(true);
        int i2 = (z2 ? 4 : 0) | 2;
        MRAIDPresenter mRAIDPresenter = this.presenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.stop();
        }
        MRAIDPresenter mRAIDPresenter2 = this.presenter;
        if (mRAIDPresenter2 != null) {
            mRAIDPresenter2.detach(i2);
        }
        getImpressionTracker().destroy();
        try {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
        } catch (Exception e) {
            Logger.Companion.d(TAG, "Removing webView error: " + e);
        }
    }

    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.Companion.d(TAG, "onAttachedToWindow()");
        if (!this.presenterStarted.getAndSet(true)) {
            MRAIDPresenter mRAIDPresenter = this.presenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.prepare();
            }
            getImpressionTracker().addView(this, new ImpressionTracker.ImpressionListener() { // from class: com.vungle.ads.BannerView.onAttachedToWindow.1
                @Override // com.vungle.ads.internal.ImpressionTracker.ImpressionListener
                public void onImpression(View view) throws Throwable {
                    Logger.Companion.d(BannerView.TAG, "ImpressionTracker checked the banner view become visible.");
                    BannerView.this.isOnImpressionCalled = true;
                    BannerView.this.logViewVisibleOnPlay();
                    BannerView.this.checkHardwareAcceleration();
                    MRAIDPresenter mRAIDPresenter2 = BannerView.this.presenter;
                    if (mRAIDPresenter2 != null) {
                        mRAIDPresenter2.start();
                    }
                }

                @Override // com.vungle.ads.internal.ImpressionTracker.ImpressionListener
                public void onViewInvisible(View view) throws Throwable {
                    if (BannerView.this.isInvisibleLogged.getAndSet(true)) {
                        return;
                    }
                    Logger.Companion.d(BannerView.TAG, "ImpressionTracker checked the banner view invisible on play.");
                    AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                    SingleValueMetric singleValueMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_VISIBILITY);
                    singleValueMetric.setValue(1L);
                    AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, singleValueMetric, BannerView.this.getAdvertisement().getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                }
            });
        }
        renderAd();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        setAdVisibility(i2 == 0);
    }
}
