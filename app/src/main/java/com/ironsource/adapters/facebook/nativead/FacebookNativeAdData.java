package com.ironsource.adapters.facebook.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.ads.NativeAd;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookNativeAdData extends AdapterNativeAdData {
    private Drawable mIconDrawable;
    private final NativeAd mNativeAd;

    public FacebookNativeAdData(NativeAd nativeAd, Drawable drawable) {
        this.mNativeAd = nativeAd;
        this.mIconDrawable = drawable;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getAdvertiser() {
        IronLog.ADAPTER_CALLBACK.verbose("advertiser = " + this.mNativeAd.getAdvertiserName());
        return this.mNativeAd.getAdvertiserName();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getBody() {
        IronLog.ADAPTER_CALLBACK.verbose("body = " + this.mNativeAd.getAdBodyText());
        return this.mNativeAd.getAdBodyText();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getCallToAction() {
        IronLog.ADAPTER_CALLBACK.verbose("cta = " + this.mNativeAd.getAdCallToAction());
        return this.mNativeAd.getAdCallToAction();
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public NativeAdDataInterface.Image getIcon() {
        Uri uri = this.mNativeAd.getAdIcon() != null ? Uri.parse(this.mNativeAd.getAdIcon().getUrl()) : null;
        IronLog.ADAPTER_CALLBACK.verbose("icon uri = " + uri);
        if (this.mNativeAd.getPreloadedIconViewDrawable() != null) {
            this.mIconDrawable = this.mNativeAd.getPreloadedIconViewDrawable();
        }
        return new NativeAdDataInterface.Image(this.mIconDrawable, uri);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getTitle() {
        IronLog.ADAPTER_CALLBACK.verbose("headline = " + this.mNativeAd.getAdHeadline());
        return this.mNativeAd.getAdHeadline();
    }
}
