package com.ironsource.adapters.admob.banner;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.ironsource.adapters.admob.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobNativeBannerViewBinder {
    private NativeAdView mAdView;
    private NativeAd mNativeAd;
    private NativeTemplateType mTemplateType;

    private void populateAdvertiserView() {
        TextView textView = (TextView) this.mAdView.findViewById(R.id.ad_advertiser);
        if (textView != null) {
            if (this.mNativeAd.getAdvertiser() == null) {
                textView.setVisibility(8);
                return;
            }
            this.mAdView.setAdvertiserView(textView);
            textView.setText(this.mNativeAd.getAdvertiser());
            textView.setVisibility(0);
        }
    }

    private void populateBodyView() {
        TextView textView = (TextView) this.mAdView.findViewById(R.id.ad_body);
        if (textView != null) {
            if (this.mNativeAd.getBody() == null) {
                textView.setVisibility(8);
                return;
            }
            this.mAdView.setBodyView(textView);
            textView.setText(this.mNativeAd.getBody());
            textView.setVisibility(0);
        }
    }

    private void populateCallToActionView() {
        Button button = (Button) this.mAdView.findViewById(R.id.ad_call_to_action);
        if (button != null) {
            if (this.mNativeAd.getCallToAction() == null || this.mTemplateType.shouldHideCallToAction()) {
                button.setVisibility(8);
                return;
            }
            this.mAdView.setCallToActionView(button);
            button.setText(this.mNativeAd.getCallToAction());
            button.setVisibility(0);
        }
    }

    private void populateHeadlineView() {
        TextView textView = (TextView) this.mAdView.findViewById(R.id.ad_headline);
        if (textView != null) {
            if (this.mNativeAd.getHeadline() == null) {
                textView.setVisibility(8);
                return;
            }
            this.mAdView.setHeadlineView(textView);
            textView.setText(this.mNativeAd.getHeadline());
            textView.setVisibility(0);
        }
    }

    private void populateIconView() {
        ImageView imageView = (ImageView) this.mAdView.findViewById(R.id.ad_app_icon);
        if (imageView != null) {
            this.mAdView.setIconView(imageView);
            if (this.mNativeAd.getIcon() == null || this.mNativeAd.getIcon().getDrawable() == null) {
                this.mAdView.getIconView().setVisibility(8);
            } else {
                imageView.setImageDrawable(this.mNativeAd.getIcon().getDrawable());
                this.mAdView.getIconView().setVisibility(0);
            }
        }
    }

    private void populateMediaView() {
        MediaView mediaView = (MediaView) this.mAdView.findViewById(R.id.ad_media);
        if (mediaView != null) {
            if (this.mNativeAd.getMediaContent() == null) {
                mediaView.setVisibility(8);
                return;
            }
            boolean z2 = this.mNativeAd.getMediaContent().hasVideoContent() && this.mTemplateType.shouldHideVideoContent();
            this.mAdView.setMediaView(mediaView);
            mediaView.setMediaContent(this.mNativeAd.getMediaContent());
            mediaView.setVisibility(z2 ? 8 : 0);
        }
    }

    private void populateView() {
        populateIconView();
        populateHeadlineView();
        populateAdvertiserView();
        populateBodyView();
        populateMediaView();
        populateCallToActionView();
    }

    public void bindView(NativeAd nativeAd, NativeAdView nativeAdView, NativeTemplateType nativeTemplateType) {
        this.mAdView = nativeAdView;
        this.mNativeAd = nativeAd;
        this.mTemplateType = nativeTemplateType;
        populateView();
        this.mAdView.setNativeAd(nativeAd);
    }
}
