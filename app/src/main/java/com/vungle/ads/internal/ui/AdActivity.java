package com.vungle.ads.internal.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.ironsource.C2300e4;
import com.vungle.ads.AdCantPlayWithoutWebView;
import com.vungle.ads.AdConfig;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ConcurrentPlaybackUnsupported;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.presenter.AdEventListener;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.presenter.PresenterDelegate;
import com.vungle.ads.internal.presenter.WebViewManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.RingerModeReceiver;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.g;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AdActivity extends Activity {
    public static final String AD_INVISIBLE_LOGGED_KEY = "ad_invisible_logged";
    public static final Companion Companion = new Companion(null);
    public static final String REQUEST_KEY_EVENT_ID_EXTRA = "request_eventId";
    public static final String REQUEST_KEY_EXTRA = "request";
    private static final String TAG = "AdActivity";
    private static AdPayload advertisement;
    private static BidPayload bidPayload;
    private static AdEventListener eventListener;
    private static PresenterDelegate presenterDelegate;
    private MRAIDAdWidget mraidAdWidget;
    private MRAIDPresenter mraidPresenter;
    private UnclosedAd unclosedAd;
    private String placementRefId = "";
    private final RingerModeReceiver ringerModeReceiver = new RingerModeReceiver();
    private final AdActivity$lifeCycleCallback$1 lifeCycleCallback = new ActivityManager.LifeCycleCallback() { // from class: com.vungle.ads.internal.ui.AdActivity$lifeCycleCallback$1
        @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
        public void onBackground() throws Throwable {
            MRAIDPresenter mraidPresenter$vungle_ads_release = this.this$0.getMraidPresenter$vungle_ads_release();
            Long viewStatus = mraidPresenter$vungle_ads_release != null ? mraidPresenter$vungle_ads_release.getViewStatus() : null;
            Logger.Companion.d("AdActivity", "App is in background, status: " + viewStatus);
            if (viewStatus != null) {
                long jLongValue = viewStatus.longValue();
                AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                Sdk.SDKMetric.SDKMetricType sDKMetricType = Sdk.SDKMetric.SDKMetricType.AD_BACKGROUND_BEFORE_IMPRESSION;
                AdPayload advertisement$vungle_ads_release = AdActivity.Companion.getAdvertisement$vungle_ads_release();
                AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, sDKMetricType, jLongValue, advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getLogEntry$vungle_ads_release() : null, null, 8, null);
            }
        }

        @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
        public void onForeground() {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getEventId(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(AdActivity.REQUEST_KEY_EVENT_ID_EXTRA);
                }
            } catch (Exception unused) {
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getPlacement(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(AdActivity.REQUEST_KEY_EXTRA);
                }
            } catch (Exception unused) {
            }
            return null;
        }

        public final Intent createIntent(Context context, String placement, String str) {
            k.e(placement, "placement");
            Intent intent = new Intent(context, (Class<?>) VungleActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putString(AdActivity.REQUEST_KEY_EXTRA, placement);
            bundle.putString(AdActivity.REQUEST_KEY_EVENT_ID_EXTRA, str);
            intent.putExtras(bundle);
            return intent;
        }

        public final AdPayload getAdvertisement$vungle_ads_release() {
            return AdActivity.advertisement;
        }

        public final BidPayload getBidPayload$vungle_ads_release() {
            return AdActivity.bidPayload;
        }

        @VisibleForTesting
        public final AdEventListener getEventListener$vungle_ads_release() {
            return AdActivity.eventListener;
        }

        public final PresenterDelegate getPresenterDelegate$vungle_ads_release() {
            return AdActivity.presenterDelegate;
        }

        public final void setAdvertisement$vungle_ads_release(AdPayload adPayload) {
            AdActivity.advertisement = adPayload;
        }

        public final void setBidPayload$vungle_ads_release(BidPayload bidPayload) {
            AdActivity.bidPayload = bidPayload;
        }

        public final void setEventListener$vungle_ads_release(AdEventListener adEventListener) {
            AdActivity.eventListener = adEventListener;
        }

        public final void setPresenterDelegate$vungle_ads_release(PresenterDelegate presenterDelegate) {
            AdActivity.presenterDelegate = presenterDelegate;
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getREQUEST_KEY_EVENT_ID_EXTRA$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getREQUEST_KEY_EXTRA$vungle_ads_release$annotations() {
        }
    }

    private final void hideSystemUi() {
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        k.d(insetsController, "getInsetsController(window, window.decorView)");
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
    }

    private final void onConcurrentPlaybackError(String str) {
        ConcurrentPlaybackUnsupported concurrentPlaybackUnsupported = new ConcurrentPlaybackUnsupported(a1.a.r(a1.a.y("Trying to show ", str, " but "), this.placementRefId, " is already showing"));
        AdPayload adPayload = advertisement;
        VungleError vungleErrorLogError$vungle_ads_release = concurrentPlaybackUnsupported.setLogEntry$vungle_ads_release(adPayload != null ? adPayload.getLogEntry$vungle_ads_release() : null).logError$vungle_ads_release();
        AdEventListener adEventListener = eventListener;
        if (adEventListener != null) {
            adEventListener.onError(vungleErrorLogError$vungle_ads_release, str);
        }
        Logger.Companion.e(TAG, "onConcurrentPlaybackError: " + vungleErrorLogError$vungle_ads_release.getLocalizedMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-1, reason: not valid java name */
    public static final SignalManager m3358onCreate$lambda1(q5.f fVar) {
        return (SignalManager) fVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-5, reason: not valid java name */
    private static final Executors m3359onCreate$lambda5(q5.f fVar) {
        return (Executors) fVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-6, reason: not valid java name */
    private static final Platform m3360onCreate$lambda6(q5.f fVar) {
        return (Platform) fVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-7, reason: not valid java name */
    private static final OMTracker.Factory m3361onCreate$lambda7(q5.f fVar) {
        return (OMTracker.Factory) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-9, reason: not valid java name */
    public static final WindowInsetsCompat m3362onCreate$lambda9(View v2, WindowInsetsCompat insets) {
        k.e(v2, "v");
        k.e(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        k.d(insets2, "insets.getInsets(\n      …utout()\n                )");
        v2.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    @VisibleForTesting(otherwise = 4)
    public boolean canRotate$vungle_ads_release() {
        return false;
    }

    public final MRAIDAdWidget getMraidAdWidget$vungle_ads_release() {
        return this.mraidAdWidget;
    }

    public final MRAIDPresenter getMraidPresenter$vungle_ads_release() {
        return this.mraidPresenter;
    }

    public final String getPlacementRefId$vungle_ads_release() {
        return this.placementRefId;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.handleExit();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        k.e(newConfig, "newConfig");
        try {
            super.onConfigurationChanged(newConfig);
            int i2 = newConfig.orientation;
            if (i2 == 2) {
                Logger.Companion.d(TAG, C2300e4.h.C);
            } else if (i2 == 1) {
                Logger.Companion.d(TAG, C2300e4.h.D);
            }
            MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.onViewConfigurationChanged();
            }
        } catch (Exception e) {
            Logger.Companion.e(TAG, "onConfigurationChanged: " + e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String, kotlin.jvm.internal.f] */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        String watermark$vungle_ads_release;
        View decorView;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        Companion companion = Companion;
        Intent intent = getIntent();
        k.d(intent, "intent");
        String placement = companion.getPlacement(intent);
        if (placement == null) {
            placement = "";
        }
        this.placementRefId = placement;
        AdPayload adPayload = advertisement;
        Placement placement2 = ConfigManager.INSTANCE.getPlacement(placement);
        frameLayout = null;
        FrameLayout frameLayout = null;
        if (placement2 == null || adPayload == null) {
            AdEventListener adEventListener = eventListener;
            if (adEventListener != null) {
                adEventListener.onError(new AdNotLoadedCantPlay("Can not play fullscreen ad. placement=" + placement2 + " adv=" + adPayload).setLogEntry$vungle_ads_release(adPayload != null ? adPayload.getLogEntry$vungle_ads_release() : 0).logError$vungle_ads_release(), this.placementRefId);
            }
            finish();
            return;
        }
        try {
            MRAIDAdWidget mRAIDAdWidget = new MRAIDAdWidget(this, adPayload.eventId());
            long j = getIntent().getBooleanExtra(AD_INVISIBLE_LOGGED_KEY, false) ? 3L : 2L;
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            SingleValueMetric singleValueMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_VISIBILITY);
            singleValueMetric.setValue(Long.valueOf(j));
            AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, singleValueMetric, adPayload.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            Logger.Companion.d(TAG, "Log metric AD_VISIBILITY: " + j);
            ServiceLocator.Companion companion2 = ServiceLocator.Companion;
            g gVar = g.f13494a;
            final q5.f fVarB = b.B(gVar, new AdActivity$onCreate$$inlined$inject$1(this));
            Intent intent2 = getIntent();
            k.d(intent2, "intent");
            String eventId = companion.getEventId(intent2);
            UnclosedAd unclosedAd = eventId != null ? new UnclosedAd(eventId, (String) logEntry, 2, (f) logEntry) : null;
            this.unclosedAd = unclosedAd;
            if (unclosedAd != null) {
                m3358onCreate$lambda1(fVarB).recordUnclosedAd(unclosedAd);
            }
            mRAIDAdWidget.setCloseDelegate(new MRAIDAdWidget.CloseDelegate() { // from class: com.vungle.ads.internal.ui.AdActivity$onCreate$4$1
                @Override // com.vungle.ads.internal.ui.view.MRAIDAdWidget.CloseDelegate
                public void close() throws Throwable {
                    MRAIDPresenter mraidPresenter$vungle_ads_release = this.this$0.getMraidPresenter$vungle_ads_release();
                    Long viewStatus = mraidPresenter$vungle_ads_release != null ? mraidPresenter$vungle_ads_release.getViewStatus() : null;
                    if (viewStatus != null) {
                        long jLongValue = viewStatus.longValue();
                        AnalyticsClient analyticsClient2 = AnalyticsClient.INSTANCE;
                        Sdk.SDKMetric.SDKMetricType sDKMetricType = Sdk.SDKMetric.SDKMetricType.AD_CLOSED_BEFORE_IMPRESSION;
                        AdPayload advertisement$vungle_ads_release = AdActivity.Companion.getAdvertisement$vungle_ads_release();
                        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient2, sDKMetricType, jLongValue, advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getLogEntry$vungle_ads_release() : null, null, 8, null);
                    }
                    UnclosedAd unclosedAd2 = this.this$0.unclosedAd;
                    if (unclosedAd2 != null) {
                        AdActivity.m3358onCreate$lambda1(fVarB).removeUnclosedAd(unclosedAd2);
                    }
                    this.this$0.finish();
                }
            });
            mRAIDAdWidget.setOnViewTouchListener(new MRAIDAdWidget.OnViewTouchListener() { // from class: com.vungle.ads.internal.ui.AdActivity$onCreate$4$2
                @Override // com.vungle.ads.internal.ui.view.MRAIDAdWidget.OnViewTouchListener
                public boolean onTouch(MotionEvent motionEvent) {
                    MRAIDPresenter mraidPresenter$vungle_ads_release = this.this$0.getMraidPresenter$vungle_ads_release();
                    if (mraidPresenter$vungle_ads_release == null) {
                        return false;
                    }
                    mraidPresenter$vungle_ads_release.onViewTouched(motionEvent);
                    return false;
                }
            });
            mRAIDAdWidget.setOrientationDelegate(new MRAIDAdWidget.OrientationDelegate() { // from class: com.vungle.ads.internal.ui.AdActivity$onCreate$4$3
                @Override // com.vungle.ads.internal.ui.view.MRAIDAdWidget.OrientationDelegate
                public void setOrientation(int i2) {
                    this.this$0.setRequestedOrientation(i2);
                }
            });
            q5.f fVarB2 = b.B(gVar, new AdActivity$onCreate$$inlined$inject$2(this));
            q5.f fVarB3 = b.B(gVar, new AdActivity$onCreate$$inlined$inject$3(this));
            VungleWebClient orCreateWebViewClient = WebViewManager.INSTANCE.getOrCreateWebViewClient(adPayload, placement2, m3359onCreate$lambda5(fVarB2).getOffloadExecutor(), m3360onCreate$lambda6(fVarB3));
            OMTracker oMTrackerMake = m3361onCreate$lambda7(b.B(gVar, new AdActivity$onCreate$$inlined$inject$4(this))).make(adPayload.omEnabled());
            VungleThreadPoolExecutor jobExecutor = m3359onCreate$lambda5(fVarB2).getJobExecutor();
            orCreateWebViewClient.setWebViewObserver(oMTrackerMake);
            this.ringerModeReceiver.setWebClient(orCreateWebViewClient);
            MRAIDPresenter mRAIDPresenter = new MRAIDPresenter(mRAIDAdWidget, adPayload, placement2, orCreateWebViewClient, jobExecutor, oMTrackerMake, m3360onCreate$lambda6(fVarB3));
            mRAIDPresenter.setEventListener(eventListener);
            mRAIDPresenter.setPresenterDelegate$vungle_ads_release(presenterDelegate);
            mRAIDPresenter.prepare();
            setContentView(mRAIDAdWidget, mRAIDAdWidget.getLayoutParams());
            try {
                getWindow().getDecorView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } catch (Throwable th) {
                q.M(th);
            }
            ViewCompat.setOnApplyWindowInsetsListener(mRAIDAdWidget, new com.mimikridev.utilmanager.config.b(3));
            AdConfig adConfig = adPayload.getAdConfig();
            if (adConfig != null && (watermark$vungle_ads_release = adConfig.getWatermark$vungle_ads_release()) != null) {
                Window window = getWindow();
                if (window != null && (decorView = window.getDecorView()) != null) {
                    frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
                }
                if (frameLayout != null) {
                    WatermarkView watermarkView = new WatermarkView(this, watermark$vungle_ads_release);
                    frameLayout.addView(watermarkView);
                    watermarkView.bringToFront();
                }
            }
            this.mraidAdWidget = mRAIDAdWidget;
            this.mraidPresenter = mRAIDPresenter;
            ActivityManager.Companion.addLifecycleListener(this.lifeCycleCallback);
            try {
                registerReceiver(this.ringerModeReceiver, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
            } catch (Throwable th2) {
                q.M(th2);
            }
        } catch (InstantiationException e) {
            AdEventListener adEventListener2 = eventListener;
            if (adEventListener2 != null) {
                adEventListener2.onError(new AdCantPlayWithoutWebView(e.getMessage()).setLogEntry$vungle_ads_release(adPayload.getLogEntry$vungle_ads_release()).logError$vungle_ads_release(), this.placementRefId);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.detach((isChangingConfigurations() ? 1 : 0) | 2);
        }
        ActivityManager.Companion.removeLifecycleListener(this.lifeCycleCallback);
        try {
            unregisterReceiver(this.ringerModeReceiver);
        } catch (Throwable th) {
            q.M(th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        k.e(intent, "intent");
        super.onNewIntent(intent);
        Companion companion = Companion;
        Intent intent2 = getIntent();
        k.d(intent2, "getIntent()");
        String placement = companion.getPlacement(intent2);
        String placement2 = companion.getPlacement(intent);
        Intent intent3 = getIntent();
        k.d(intent3, "getIntent()");
        String eventId = companion.getEventId(intent3);
        String eventId2 = companion.getEventId(intent);
        if ((placement == null || placement2 == null || placement.equals(placement2)) && (eventId == null || eventId2 == null || eventId.equals(eventId2))) {
            return;
        }
        Logger.Companion.d(TAG, a1.a.n("Tried to play another placement ", placement2, " while playing ", placement));
        onConcurrentPlaybackError(placement2);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.stop();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        hideSystemUi();
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.start();
        }
    }

    public final void setMraidAdWidget$vungle_ads_release(MRAIDAdWidget mRAIDAdWidget) {
        this.mraidAdWidget = mRAIDAdWidget;
    }

    public final void setMraidPresenter$vungle_ads_release(MRAIDPresenter mRAIDPresenter) {
        this.mraidPresenter = mRAIDPresenter;
    }

    public final void setPlacementRefId$vungle_ads_release(String str) {
        k.e(str, "<set-?>");
        this.placementRefId = str;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (canRotate$vungle_ads_release()) {
            super.setRequestedOrientation(i2);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidAdWidget$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidPresenter$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPlacementRefId$vungle_ads_release$annotations() {
    }
}
