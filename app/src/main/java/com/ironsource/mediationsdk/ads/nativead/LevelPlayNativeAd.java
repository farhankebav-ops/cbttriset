package com.ironsource.mediationsdk.ads.nativead;

import a3.a;
import a3.b;
import a3.c;
import a3.d;
import android.app.Activity;
import com.ironsource.C2236ac;
import com.ironsource.C2272cc;
import com.ironsource.C2434ld;
import com.ironsource.C2531r4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.r;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayNativeAd implements NativeAdInterface, NativeAdDataInterface, InternalNativeAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C2434ld f9004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LevelPlayNativeAdListener f9005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C2236ac f9006d;
    private AdapterNativeAdData e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AdapterNativeAdViewBinder f9007f;
    private final AtomicBoolean g;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LevelPlayNativeAdListener f9009b;

        public final LevelPlayNativeAd build() {
            return new LevelPlayNativeAd(this, null);
        }

        public final LevelPlayNativeAdListener getMListener$mediationsdk_release() {
            return this.f9009b;
        }

        public final String getMPlacementName$mediationsdk_release() {
            return this.f9008a;
        }

        public final void setMListener$mediationsdk_release(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            this.f9009b = levelPlayNativeAdListener;
        }

        public final void setMPlacementName$mediationsdk_release(String str) {
            this.f9008a = str;
        }

        public final Builder withActivity(Activity activity) {
            ContextProvider.getInstance().updateActivity(activity);
            IronLog.INTERNAL.verbose("activity is updated to: " + (activity != null ? activity.hashCode() : 0));
            return this;
        }

        public final Builder withListener(LevelPlayNativeAdListener listener) {
            k.e(listener, "listener");
            this.f9009b = listener;
            return this;
        }

        public final Builder withPlacementName(String str) {
            this.f9008a = str;
            return this;
        }
    }

    public /* synthetic */ LevelPlayNativeAd(Builder builder, f fVar) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0) {
        x xVar;
        k.e(this$0, "this$0");
        this$0.b();
        C2236ac c2236ac = this$0.f9006d;
        if (c2236ac != null) {
            c2236ac.a(this$0.f9004b);
            xVar = x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            this$0.a();
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void destroyAd() {
        IronLog.API.info(String.valueOf(this));
        try {
            C2236ac c2236ac = this.f9006d;
            if (c2236ac != null) {
                c2236ac.M();
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getAdvertiser() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getBody() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getCallToAction() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public NativeAdDataInterface.Image getIcon() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getIcon();
        }
        return null;
    }

    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.f9007f;
    }

    public final UUID getObjectId() {
        C2236ac c2236ac = this.f9006d;
        if (c2236ac != null) {
            return c2236ac.k();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getTitle() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void loadAd() {
        IronLog.API.info(String.valueOf(this));
        String initError = r.m().e();
        k.d(initError, "initError");
        if (initError.length() <= 0) {
            IronSourceThreadManager.INSTANCE.getInitHandler().post(new b(this, 0));
            return;
        }
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("loadAd(): ".concat(initError), IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdClicked(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new a(this, adInfo, 0), 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdImpression(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new a(this, adInfo, 1), 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new c(0, this, ironSourceError), 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoaded(AdInfo adInfo, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        k.e(adapterNativeAdData, "adapterNativeAdData");
        k.e(nativeAdViewBinder, "nativeAdViewBinder");
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new d(this, adapterNativeAdData, nativeAdViewBinder, adInfo, 0), 0L, 2, null);
    }

    public final void setListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
        this.f9005c = levelPlayNativeAdListener;
    }

    private LevelPlayNativeAd(Builder builder) {
        this.g = new AtomicBoolean(false);
        this.f9003a = builder.getMPlacementName$mediationsdk_release();
        this.f9005c = builder.getMListener$mediationsdk_release();
    }

    private final void b() {
        if (this.g.compareAndSet(false, true)) {
            C2236ac c2236acF = r.m().f();
            this.f9006d = c2236acF;
            if (c2236acF != null) {
                c2236acF.a(this);
                C2272cc c2272ccM = r.m().m(this.f9003a);
                k.d(c2272ccM, "getInstance().getNativeAdPlacement(mPlacementName)");
                this.f9004b = new C2434ld(c2272ccM);
            }
        }
    }

    private final void a() {
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("init() has failed", IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder, AdInfo adInfo) {
        k.e(this$0, "this$0");
        k.e(adapterNativeAdData, "$adapterNativeAdData");
        k.e(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.e = adapterNativeAdData;
        this$0.f9007f = nativeAdViewBinder;
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoaded(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LevelPlayNativeAd this$0, AdInfo adInfo) {
        k.e(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdImpression(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, IronSourceError ironSourceError) {
        k.e(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this$0, ironSourceError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdInfo adInfo) {
        k.e(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f9005c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdClicked(this$0, adInfo);
        }
    }
}
