package com.mimikridev.ads.nativead;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.material.card.MaterialCardView;
import com.mimikridev.ads.R;
import com.mimikridev.ads.util.AdManagerTemplateView;
import com.mimikridev.ads.util.NativeTemplateStyle;
import com.mimikridev.ads.util.TemplateView;
import com.mimikridev.ads.util.Tools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class NativeAdView {
    private static final String TAG = "AdNetwork";
    private final Activity activity;
    MediaView adManagerMediaView;
    AdManagerTemplateView adManagerNativeAd;
    LinearLayout adManagerNativeBackground;
    TemplateView admobNativeAd;
    LinearLayout admobNativeBackground;
    com.facebook.ads.NativeAd fanNativeAd;
    NativeAdLayout fanNativeAdLayout;
    MediaView mediaView;
    MaterialCardView nativeAdViewContainer;
    FrameLayout pangleNativeAd;
    View startappNativeAd;
    LinearLayout startappNativeBackground;
    Button startappNativeButton;
    TextView startappNativeDescription;
    ImageView startappNativeIcon;
    ImageView startappNativeImage;
    TextView startappNativeTitle;
    View view;
    private String adStatus = "";
    private String adNetwork = "";
    private String backupAdNetwork = "";
    private String adMobNativeId = "";
    private String adManagerNativeId = "";
    private String fanNativeId = "";
    private String appLovinNativeId = "";
    private String appLovinDiscMrecZoneId = "";
    private String pangleNativeId = "";
    private int placementStatus = 1;
    private boolean darkTheme = false;
    private boolean legacyGDPR = false;
    private String nativeAdStyle = "";
    private int nativeBackgroundLight = R.color.color_native_background_light;
    private int nativeBackgroundDark = R.color.color_native_background_dark;
    private int cornerRadius = 0;
    private int strokeWidth = 0;
    private int strokeColor = android.R.color.transparent;

    public NativeAdView(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBackupNativeAd$2(View view) {
        this.startappNativeAd.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBackupNativeAd$3(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        if (this.darkTheme) {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(this.activity, this.nativeBackgroundDark))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(this.activity, this.nativeBackgroundLight))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundLight);
        }
        this.mediaView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.admobNativeAd.setNativeAd(nativeAd);
        this.admobNativeAd.setVisibility(0);
        this.nativeAdViewContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadNativeAd$0(View view) {
        this.startappNativeAd.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadNativeAd$1(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        if (this.darkTheme) {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(this.activity, this.nativeBackgroundDark))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(this.activity, this.nativeBackgroundLight))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundLight);
        }
        this.mediaView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.admobNativeAd.setNativeAd(nativeAd);
        this.admobNativeAd.setVisibility(0);
        this.nativeAdViewContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populatePangleNativeAdView(View view, PAGNativeAd pAGNativeAd) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pangle_native_background);
        if (this.darkTheme) {
            linearLayout.setBackgroundResource(this.nativeBackgroundDark);
        } else {
            linearLayout.setBackgroundResource(this.nativeBackgroundLight);
        }
        TextView textView = (TextView) view.findViewById(R.id.pangle_native_title);
        TextView textView2 = (TextView) view.findViewById(R.id.pangle_native_description);
        ImageView imageView = (ImageView) view.findViewById(R.id.pangle_native_icon);
        View view2 = (ImageView) view.findViewById(R.id.ad_dislike);
        Button button = (Button) view.findViewById(R.id.pangle_native_button);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pangle_native_image);
        textView.setText(pAGNativeAd.getNativeAdData().getTitle());
        textView2.setText(pAGNativeAd.getNativeAdData().getDescription());
        PAGImageItem icon = pAGNativeAd.getNativeAdData().getIcon();
        if (icon != null && icon.getImageUrl() != null) {
            Glide.with(this.activity).load(icon.getImageUrl()).into(imageView);
        }
        frameLayout.addView(pAGNativeAd.getNativeAdData().getMediaView());
        button.setText(TextUtils.isEmpty(pAGNativeAd.getNativeAdData().getButtonText()) ? "Download" : pAGNativeAd.getNativeAdData().getButtonText());
        ArrayList arrayList = new ArrayList();
        arrayList.add(button);
        arrayList.add(imageView);
        arrayList.add(textView);
        arrayList.add(textView2);
        arrayList.add(frameLayout);
        pAGNativeAd.registerViewForInteraction((ViewGroup) view, arrayList, (List<View>) null, view2, new PAGNativeAdInteractionListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.7
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
            }
        });
    }

    private void setMargins(View view, int i2, int i8, int i9, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(this.activity.getResources().getDimensionPixelSize(i2), this.activity.getResources().getDimensionPixelSize(i8), this.activity.getResources().getDimensionPixelSize(i9), this.activity.getResources().getDimensionPixelSize(i10));
            view.requestLayout();
        }
    }

    private void setNativeAdCornerRadius() {
        MaterialCardView materialCardView = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.nativeAdViewContainer = materialCardView;
        materialCardView.setRadius(this.activity.getResources().getDimensionPixelOffset(this.cornerRadius));
    }

    private void setNativeAdMargin(int i2, int i8, int i9, int i10) {
        MaterialCardView materialCardView = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.nativeAdViewContainer = materialCardView;
        setMargins(materialCardView, i2, i8, i9, i10);
    }

    private void setNativeAdPadding(int i2, int i8, int i9, int i10) {
        MaterialCardView materialCardView = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.nativeAdViewContainer = materialCardView;
        materialCardView.setContentPadding(this.activity.getResources().getDimensionPixelSize(i2), this.activity.getResources().getDimensionPixelSize(i8), this.activity.getResources().getDimensionPixelSize(i9), this.activity.getResources().getDimensionPixelSize(i10));
        if (this.darkTheme) {
            this.nativeAdViewContainer.setCardBackgroundColor(ContextCompat.getColor(this.activity, this.nativeBackgroundDark));
        } else {
            this.nativeAdViewContainer.setCardBackgroundColor(ContextCompat.getColor(this.activity, this.nativeBackgroundLight));
        }
    }

    private void setNativeAdStrokeColor() {
        MaterialCardView materialCardView = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.nativeAdViewContainer = materialCardView;
        materialCardView.setStrokeColor(ContextCompat.getColor(this.activity, this.strokeColor));
    }

    private void setNativeAdStrokeWidth() {
        MaterialCardView materialCardView = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.nativeAdViewContainer = materialCardView;
        materialCardView.setStrokeWidth(this.activity.getResources().getDimensionPixelOffset(this.strokeWidth));
    }

    public NativeAdView build() {
        loadNativeAd();
        return this;
    }

    public void loadBackupNativeAd() {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        this.nativeAdViewContainer = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.admobNativeAd = (TemplateView) this.view.findViewById(R.id.admob_native_ad_container);
        this.mediaView = (MediaView) this.view.findViewById(R.id.media_view);
        this.admobNativeBackground = (LinearLayout) this.view.findViewById(R.id.background);
        this.adManagerNativeAd = (AdManagerTemplateView) this.view.findViewById(R.id.google_ad_manager_native_ad_container);
        this.adManagerMediaView = (MediaView) this.view.findViewById(R.id.ad_manager_media_view);
        this.adManagerNativeBackground = (LinearLayout) this.view.findViewById(R.id.ad_manager_background);
        this.fanNativeAdLayout = (NativeAdLayout) this.view.findViewById(R.id.fan_native_ad_container);
        this.startappNativeAd = this.view.findViewById(R.id.startapp_native_ad_container);
        this.startappNativeImage = (ImageView) this.view.findViewById(R.id.startapp_native_image);
        this.startappNativeIcon = (ImageView) this.view.findViewById(R.id.startapp_native_icon);
        this.startappNativeTitle = (TextView) this.view.findViewById(R.id.startapp_native_title);
        this.startappNativeDescription = (TextView) this.view.findViewById(R.id.startapp_native_description);
        Button button = (Button) this.view.findViewById(R.id.startapp_native_button);
        this.startappNativeButton = button;
        i2 = 0;
        button.setOnClickListener(new c(this, i2));
        this.startappNativeBackground = (LinearLayout) this.view.findViewById(R.id.startapp_native_background);
        this.pangleNativeAd = (FrameLayout) this.view.findViewById(R.id.pangle_native_ad_container);
        String str = this.backupAdNetwork;
        str.getClass();
        switch (str) {
            case "pangle":
                if (this.pangleNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "[Backup] Pangle Native Ad has been loaded");
                    break;
                } else {
                    PAGNativeAd.loadAd(this.pangleNativeId, new PAGNativeRequest(), new PAGNativeAdLoadListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.6
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i8, String str2) {
                            NativeAdView.this.pangleNativeAd.setVisibility(8);
                            NativeAdView.this.nativeAdViewContainer.setVisibility(8);
                            Log.d(NativeAdView.TAG, "[Backup] Pangle Native Ad Error");
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            View viewInflate;
                            Log.d(NativeAdView.TAG, "[Backup] Pangle Native Ad Loaded");
                            String str2 = NativeAdView.this.nativeAdStyle;
                            str2.getClass();
                            switch (str2) {
                                case "medium":
                                case "news":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_news_template_view, (ViewGroup) null);
                                    break;
                                case "radio":
                                case "small":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_radio_template_view, (ViewGroup) null);
                                    break;
                                case "video_large":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_video_large_template_view, (ViewGroup) null);
                                    break;
                                case "video_small":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_video_small_template_view, (ViewGroup) null);
                                    break;
                                default:
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_medium_template_view, (ViewGroup) null);
                                    break;
                            }
                            NativeAdView.this.populatePangleNativeAdView(viewInflate, pAGNativeAd);
                            NativeAdView.this.pangleNativeAd.removeAllViews();
                            NativeAdView.this.pangleNativeAd.addView(viewInflate);
                            NativeAdView.this.pangleNativeAd.setVisibility(0);
                            NativeAdView.this.nativeAdViewContainer.setVisibility(0);
                        }
                    });
                    break;
                }
                break;
            case "admob":
                if (this.admobNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "AdMob Native Ad has been loaded");
                    break;
                } else {
                    new AdLoader.Builder(this.activity, this.adMobNativeId).forNativeAd(new d(this, i2)).withAdListener(new AdListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.4
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            NativeAdView.this.admobNativeAd.setVisibility(8);
                            NativeAdView.this.nativeAdViewContainer.setVisibility(8);
                        }
                    }).build().loadAd(Tools.getAdRequest(this.activity, Boolean.valueOf(this.legacyGDPR)));
                    break;
                }
                break;
            case "facebook":
                this.fanNativeAd = new com.facebook.ads.NativeAd(this.activity, this.fanNativeId);
                this.fanNativeAd.loadAd(this.fanNativeAd.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.5
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        LayoutInflater layoutInflaterFrom;
                        LinearLayout linearLayout;
                        NativeAdView.this.fanNativeAdLayout.setVisibility(0);
                        NativeAdView.this.nativeAdViewContainer.setVisibility(0);
                        com.facebook.ads.NativeAd nativeAd = NativeAdView.this.fanNativeAd;
                        if (nativeAd != ad) {
                            return;
                        }
                        nativeAd.unregisterView();
                        layoutInflaterFrom = LayoutInflater.from(NativeAdView.this.activity);
                        String str2 = NativeAdView.this.nativeAdStyle;
                        str2.getClass();
                        switch (str2) {
                            case "medium":
                            case "news":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_news_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "radio":
                            case "small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_radio_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "video_large":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_large_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "video_small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_small_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            default:
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_medium_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                        }
                        NativeAdView.this.fanNativeAdLayout.addView(linearLayout);
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.ad_choices_container);
                        Activity activity = NativeAdView.this.activity;
                        NativeAdView nativeAdView = NativeAdView.this;
                        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAdView.fanNativeAd, nativeAdView.fanNativeAdLayout);
                        linearLayout2.removeAllViews();
                        linearLayout2.addView(adOptionsView, 0);
                        TextView textView = (TextView) linearLayout.findViewById(R.id.native_ad_title);
                        com.facebook.ads.MediaView mediaView = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_media);
                        com.facebook.ads.MediaView mediaView2 = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_icon);
                        TextView textView2 = (TextView) linearLayout.findViewById(R.id.native_ad_social_context);
                        TextView textView3 = (TextView) linearLayout.findViewById(R.id.native_ad_body);
                        TextView textView4 = (TextView) linearLayout.findViewById(R.id.native_ad_sponsored_label);
                        Button button2 = (Button) linearLayout.findViewById(R.id.native_ad_call_to_action);
                        LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.ad_unit);
                        if (NativeAdView.this.darkTheme) {
                            textView.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_primary_text_color));
                            textView2.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_primary_text_color));
                            textView4.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_secondary_text_color));
                            textView3.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_secondary_text_color));
                            linearLayout3.setBackgroundResource(NativeAdView.this.nativeBackgroundDark);
                        } else {
                            linearLayout3.setBackgroundResource(NativeAdView.this.nativeBackgroundLight);
                        }
                        textView.setText(NativeAdView.this.fanNativeAd.getAdvertiserName());
                        textView3.setText(NativeAdView.this.fanNativeAd.getAdBodyText());
                        textView2.setText(NativeAdView.this.fanNativeAd.getAdSocialContext());
                        button2.setVisibility(NativeAdView.this.fanNativeAd.hasCallToAction() ? 0 : 4);
                        button2.setText(NativeAdView.this.fanNativeAd.getAdCallToAction());
                        textView4.setText(NativeAdView.this.fanNativeAd.getSponsoredTranslation());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(textView);
                        arrayList.add(textView4);
                        arrayList.add(mediaView2);
                        arrayList.add(mediaView);
                        arrayList.add(textView3);
                        arrayList.add(textView2);
                        arrayList.add(button2);
                        NativeAdView.this.fanNativeAd.registerViewForInteraction(linearLayout, mediaView2, mediaView, arrayList);
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }

                    @Override // com.facebook.ads.NativeAdListener
                    public void onMediaDownloaded(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, AdError adError) {
                    }
                }).build());
                break;
            default:
                this.nativeAdViewContainer.setVisibility(8);
                break;
        }
    }

    public void loadNativeAd() {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        this.nativeAdViewContainer = (MaterialCardView) this.view.findViewById(R.id.native_ad_view_container);
        this.admobNativeAd = (TemplateView) this.view.findViewById(R.id.admob_native_ad_container);
        this.mediaView = (MediaView) this.view.findViewById(R.id.media_view);
        this.admobNativeBackground = (LinearLayout) this.view.findViewById(R.id.background);
        this.adManagerNativeAd = (AdManagerTemplateView) this.view.findViewById(R.id.google_ad_manager_native_ad_container);
        this.adManagerMediaView = (MediaView) this.view.findViewById(R.id.ad_manager_media_view);
        this.adManagerNativeBackground = (LinearLayout) this.view.findViewById(R.id.ad_manager_background);
        this.fanNativeAdLayout = (NativeAdLayout) this.view.findViewById(R.id.fan_native_ad_container);
        this.startappNativeAd = this.view.findViewById(R.id.startapp_native_ad_container);
        this.startappNativeImage = (ImageView) this.view.findViewById(R.id.startapp_native_image);
        this.startappNativeIcon = (ImageView) this.view.findViewById(R.id.startapp_native_icon);
        this.startappNativeTitle = (TextView) this.view.findViewById(R.id.startapp_native_title);
        this.startappNativeDescription = (TextView) this.view.findViewById(R.id.startapp_native_description);
        Button button = (Button) this.view.findViewById(R.id.startapp_native_button);
        this.startappNativeButton = button;
        i2 = 1;
        button.setOnClickListener(new c(this, i2));
        this.startappNativeBackground = (LinearLayout) this.view.findViewById(R.id.startapp_native_background);
        this.pangleNativeAd = (FrameLayout) this.view.findViewById(R.id.pangle_native_ad_container);
        String str = this.adNetwork;
        str.getClass();
        switch (str) {
            case "pangle":
                if (this.pangleNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "Pangle Native Ad has been loaded");
                    break;
                } else {
                    PAGNativeAd.loadAd(this.pangleNativeId, new PAGNativeRequest(), new PAGNativeAdLoadListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.3
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i8, String str2) {
                            NativeAdView.this.loadBackupNativeAd();
                            Log.d(NativeAdView.TAG, "Pangle Native Ad Error");
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            View viewInflate;
                            Log.d(NativeAdView.TAG, "Pangle Native Ad Loaded");
                            String str2 = NativeAdView.this.nativeAdStyle;
                            str2.getClass();
                            switch (str2) {
                                case "medium":
                                case "news":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_news_template_view, (ViewGroup) null);
                                    break;
                                case "radio":
                                case "small":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_radio_template_view, (ViewGroup) null);
                                    break;
                                case "video_large":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_video_large_template_view, (ViewGroup) null);
                                    break;
                                case "video_small":
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_video_small_template_view, (ViewGroup) null);
                                    break;
                                default:
                                    viewInflate = NativeAdView.this.activity.getLayoutInflater().inflate(R.layout.gnt_pangle_medium_template_view, (ViewGroup) null);
                                    break;
                            }
                            NativeAdView.this.populatePangleNativeAdView(viewInflate, pAGNativeAd);
                            NativeAdView.this.pangleNativeAd.removeAllViews();
                            NativeAdView.this.pangleNativeAd.addView(viewInflate);
                            NativeAdView.this.pangleNativeAd.setVisibility(0);
                            NativeAdView.this.nativeAdViewContainer.setVisibility(0);
                        }
                    });
                    break;
                }
                break;
            case "admob":
                if (this.admobNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "AdMob Native Ad has been loaded");
                    break;
                } else {
                    new AdLoader.Builder(this.activity, this.adMobNativeId).forNativeAd(new d(this, i2)).withAdListener(new AdListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.1
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            NativeAdView.this.loadBackupNativeAd();
                        }
                    }).build().loadAd(Tools.getAdRequest(this.activity, Boolean.valueOf(this.legacyGDPR)));
                    break;
                }
                break;
            case "facebook":
                this.fanNativeAd = new com.facebook.ads.NativeAd(this.activity, this.fanNativeId);
                this.fanNativeAd.loadAd(this.fanNativeAd.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.mimikridev.ads.nativead.NativeAdView.2
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        LayoutInflater layoutInflaterFrom;
                        LinearLayout linearLayout;
                        NativeAdView.this.fanNativeAdLayout.setVisibility(0);
                        NativeAdView.this.nativeAdViewContainer.setVisibility(0);
                        com.facebook.ads.NativeAd nativeAd = NativeAdView.this.fanNativeAd;
                        if (nativeAd != ad) {
                            return;
                        }
                        nativeAd.unregisterView();
                        layoutInflaterFrom = LayoutInflater.from(NativeAdView.this.activity);
                        String str2 = NativeAdView.this.nativeAdStyle;
                        str2.getClass();
                        switch (str2) {
                            case "medium":
                            case "news":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_news_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "radio":
                            case "small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_radio_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "video_large":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_large_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            case "video_small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_small_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                            default:
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_medium_template_view, (ViewGroup) NativeAdView.this.fanNativeAdLayout, false);
                                break;
                        }
                        NativeAdView.this.fanNativeAdLayout.addView(linearLayout);
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.ad_choices_container);
                        Activity activity = NativeAdView.this.activity;
                        NativeAdView nativeAdView = NativeAdView.this;
                        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAdView.fanNativeAd, nativeAdView.fanNativeAdLayout);
                        linearLayout2.removeAllViews();
                        linearLayout2.addView(adOptionsView, 0);
                        TextView textView = (TextView) linearLayout.findViewById(R.id.native_ad_title);
                        com.facebook.ads.MediaView mediaView = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_media);
                        com.facebook.ads.MediaView mediaView2 = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_icon);
                        TextView textView2 = (TextView) linearLayout.findViewById(R.id.native_ad_social_context);
                        TextView textView3 = (TextView) linearLayout.findViewById(R.id.native_ad_body);
                        TextView textView4 = (TextView) linearLayout.findViewById(R.id.native_ad_sponsored_label);
                        Button button2 = (Button) linearLayout.findViewById(R.id.native_ad_call_to_action);
                        LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.ad_unit);
                        if (NativeAdView.this.darkTheme) {
                            textView.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_primary_text_color));
                            textView2.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_primary_text_color));
                            textView4.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_secondary_text_color));
                            textView3.setTextColor(ContextCompat.getColor(NativeAdView.this.activity, R.color.applovin_dark_secondary_text_color));
                            linearLayout3.setBackgroundResource(NativeAdView.this.nativeBackgroundDark);
                        } else {
                            linearLayout3.setBackgroundResource(NativeAdView.this.nativeBackgroundLight);
                        }
                        textView.setText(NativeAdView.this.fanNativeAd.getAdvertiserName());
                        textView3.setText(NativeAdView.this.fanNativeAd.getAdBodyText());
                        textView2.setText(NativeAdView.this.fanNativeAd.getAdSocialContext());
                        button2.setVisibility(NativeAdView.this.fanNativeAd.hasCallToAction() ? 0 : 4);
                        button2.setText(NativeAdView.this.fanNativeAd.getAdCallToAction());
                        textView4.setText(NativeAdView.this.fanNativeAd.getSponsoredTranslation());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(textView);
                        arrayList.add(textView4);
                        arrayList.add(mediaView2);
                        arrayList.add(mediaView);
                        arrayList.add(textView3);
                        arrayList.add(textView2);
                        arrayList.add(button2);
                        NativeAdView.this.fanNativeAd.registerViewForInteraction(linearLayout, mediaView2, mediaView, arrayList);
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, AdError adError) {
                        NativeAdView.this.loadBackupNativeAd();
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }

                    @Override // com.facebook.ads.NativeAdListener
                    public void onMediaDownloaded(Ad ad) {
                    }
                }).build());
                break;
        }
    }

    public void populateWortiseNativeAdView(com.google.android.gms.ads.nativead.NativeAd nativeAd, com.google.android.gms.ads.nativead.NativeAdView nativeAdView) {
        if (this.darkTheme) {
            this.nativeAdViewContainer.setBackgroundColor(ContextCompat.getColor(this.activity, this.nativeBackgroundDark));
            nativeAdView.findViewById(R.id.background).setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.nativeAdViewContainer.setBackgroundColor(ContextCompat.getColor(this.activity, this.nativeBackgroundLight));
            nativeAdView.findViewById(R.id.background).setBackgroundResource(this.nativeBackgroundLight);
        }
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.media_view));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.primary));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.cta));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.icon));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        nativeAdView.setNativeAd(nativeAd);
    }

    public NativeAdView setAdManagerNativeId(String str) {
        this.adManagerNativeId = str;
        return this;
    }

    public NativeAdView setAdMobNativeId(String str) {
        this.adMobNativeId = str;
        return this;
    }

    public NativeAdView setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public NativeAdView setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public NativeAdView setAppLovinDiscoveryMrecZoneId(String str) {
        this.appLovinDiscMrecZoneId = str;
        return this;
    }

    public NativeAdView setAppLovinNativeId(String str) {
        this.appLovinNativeId = str;
        return this;
    }

    public NativeAdView setBackgroundColor(int i2, int i8) {
        this.nativeBackgroundLight = i2;
        this.nativeBackgroundDark = i8;
        return this;
    }

    public NativeAdView setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public NativeAdView setDarkTheme(boolean z2) {
        this.darkTheme = z2;
        return this;
    }

    public NativeAdView setFanNativeId(String str) {
        this.fanNativeId = str;
        return this;
    }

    public NativeAdView setLegacyGDPR(boolean z2) {
        this.legacyGDPR = z2;
        return this;
    }

    public NativeAdView setMargin(int i2, int i8, int i9, int i10) {
        setNativeAdMargin(i2, i8, i9, i10);
        return this;
    }

    public NativeAdView setNativeAdStyle(String str) {
        this.nativeAdStyle = str;
        return this;
    }

    public NativeAdView setPadding(int i2, int i8, int i9, int i10) {
        setNativeAdPadding(i2, i8, i9, i10);
        return this;
    }

    public NativeAdView setPangleNativeId(String str) {
        this.pangleNativeId = str;
        return this;
    }

    public NativeAdView setPlacementStatus(int i2) {
        this.placementStatus = i2;
        return this;
    }

    public NativeAdView setRadius(int i2) {
        this.cornerRadius = i2;
        setNativeAdCornerRadius();
        return this;
    }

    public NativeAdView setStrokeColor(int i2) {
        this.strokeColor = i2;
        setNativeAdStrokeColor();
        return this;
    }

    public NativeAdView setStrokeWidth(int i2) {
        this.strokeWidth = i2;
        setNativeAdStrokeWidth();
        return this;
    }

    public NativeAdView setView(View view) {
        this.view = view;
        return this;
    }
}
