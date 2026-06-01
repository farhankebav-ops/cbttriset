package com.unity3d.ironsourceads.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.Q2;
import com.ironsource.R2;
import com.ironsource.mediationsdk.logger.IronLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerAdView extends FrameLayout implements R2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Q2 f10880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BannerAdViewListener f10881b;

    private BannerAdView(Context context) {
        super(context);
    }

    public final BannerAdInfo getAdInfo() {
        Q2 q22 = this.f10880a;
        if (q22 != null) {
            return q22.c();
        }
        k.l("bannerAdViewInternal");
        throw null;
    }

    public final BannerAdViewListener getListener() {
        return this.f10881b;
    }

    @Override // com.ironsource.R2
    public void onBannerAdClicked() {
        IronLog.CALLBACK.info("BannerAdViewListener onBannerAdClicked adInfo: " + getAdInfo());
        BannerAdViewListener bannerAdViewListener = this.f10881b;
        if (bannerAdViewListener != null) {
            bannerAdViewListener.onBannerAdClicked(this);
        }
    }

    @Override // com.ironsource.R2
    public void onBannerAdShown() {
        IronLog.CALLBACK.info("BannerAdViewListener onBannerAdShown adInfo: " + getAdInfo());
        BannerAdViewListener bannerAdViewListener = this.f10881b;
        if (bannerAdViewListener != null) {
            bannerAdViewListener.onBannerAdShown(this);
        }
    }

    public final void setListener(BannerAdViewListener bannerAdViewListener) {
        this.f10881b = bannerAdViewListener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BannerAdView(Q2 bannerAdViewInternal) {
        k.e(bannerAdViewInternal, "bannerAdViewInternal");
        Context context = bannerAdViewInternal.d().getContext();
        k.d(context, "bannerAdViewInternal.container.context");
        this(context);
        this.f10880a = bannerAdViewInternal;
        bannerAdViewInternal.a(new WeakReference<>(this));
        bannerAdViewInternal.b(new WeakReference<>(this));
    }
}
