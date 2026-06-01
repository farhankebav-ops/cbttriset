package com.ironsource.adapters.admob.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.mlkit.common.MlKitException;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobNativeBannerViewHandler {
    private final NativeAdView mAdView;
    private FrameLayout.LayoutParams mLayoutParams;
    private NativeTemplateType mTemplateType;

    public AdMobNativeBannerViewHandler(ISBannerSize iSBannerSize, NativeTemplateType nativeTemplateType, Context context) {
        this.mTemplateType = nativeTemplateType;
        String description = iSBannerSize.getDescription();
        description.getClass();
        switch (description) {
            case "RECTANGLE":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE), AdapterUtils.dpToPixels(context, 250));
                break;
            case "LARGE":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 90));
                break;
            case "SMART":
            case "BANNER":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                break;
        }
        this.mLayoutParams.gravity = 17;
        this.mAdView = (NativeAdView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.mTemplateType.getLayoutId(), (ViewGroup) null);
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public NativeAdView getNativeAdView() {
        return this.mAdView;
    }
}
