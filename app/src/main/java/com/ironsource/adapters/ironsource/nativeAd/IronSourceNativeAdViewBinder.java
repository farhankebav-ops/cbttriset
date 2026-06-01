package com.ironsource.adapters.ironsource.nativeAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.F8;
import com.ironsource.G8;
import com.ironsource.I8;
import com.ironsource.J8;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.mediation.R;
import e2.s;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IronSourceNativeAdViewBinder extends AdapterNativeAdViewBinder {
    private final I8 nativeAd;
    private final NativeAdProperties nativeAdProperties;
    private F8 networkNativeAdView;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdOptionsPosition.values().length];
            try {
                iArr[AdOptionsPosition.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdOptionsPosition.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdOptionsPosition.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdOptionsPosition.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IronSourceNativeAdViewBinder(I8 nativeAd, NativeAdProperties nativeAdProperties) {
        k.e(nativeAd, "nativeAd");
        k.e(nativeAdProperties, "nativeAdProperties");
        this.nativeAd = nativeAd;
        this.nativeAdProperties = nativeAdProperties;
    }

    private final FrameLayout.LayoutParams getPrivacyIconLayoutParams() {
        int i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i8 = WhenMappings.$EnumSwitchMapping$0[this.nativeAdProperties.getAdOptionsPosition().ordinal()];
        if (i8 == 1) {
            i2 = 51;
        } else if (i8 == 2) {
            i2 = 53;
        } else if (i8 == 3) {
            i2 = 83;
        } else {
            if (i8 != 4) {
                throw new s(3);
            }
            i2 = 85;
        }
        layoutParams.gravity = i2;
        return layoutParams;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinderInterface
    public void setNativeAdView(View view) {
        if (view == null) {
            IronLog.INTERNAL.error("nativeAdView is null");
            return;
        }
        if (this.nativeAd.c() == null) {
            IronLog.INTERNAL.error("nativeAd.adData is null");
            return;
        }
        LevelPlayMediaView mediaView = getNativeAdViewHolder().getMediaView();
        if (mediaView != null) {
            G8 g8C = this.nativeAd.c();
            k.b(g8C);
            WebView webViewL = g8C.l();
            if (webViewL != null) {
                mediaView.addView(webViewL, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        G8 g8C2 = this.nativeAd.c();
        k.b(g8C2);
        View viewM = g8C2.m();
        viewM.setId(R.id.privacy_icon_button);
        viewM.setLayoutParams(getPrivacyIconLayoutParams());
        Context context = view.getContext();
        k.d(context, "context");
        F8 f8 = new F8(context);
        f8.addView(view);
        f8.addView(viewM);
        this.networkNativeAdView = f8;
        F8 networkNativeAdView = getNetworkNativeAdView();
        k.b(networkNativeAdView);
        this.nativeAd.a(new J8(networkNativeAdView, getNativeAdViewHolder().getTitleView(), getNativeAdViewHolder().getAdvertiserView(), getNativeAdViewHolder().getIconView(), getNativeAdViewHolder().getBodyView(), getNativeAdViewHolder().getMediaView(), getNativeAdViewHolder().getCallToActionView(), viewM));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinderInterface
    public F8 getNetworkNativeAdView() {
        return this.networkNativeAdView;
    }
}
