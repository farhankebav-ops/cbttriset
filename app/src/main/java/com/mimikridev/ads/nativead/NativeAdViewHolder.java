package com.mimikridev.ads.nativead;

import android.app.Activity;
import android.content.Context;
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
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.cbt.exam.browser.activity.o;
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
public class NativeAdViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "AdNetwork";
    MediaView adManagerMediaView;
    AdManagerTemplateView adManagerNativeAd;
    LinearLayout adManagerNativeBackground;
    private String adManagerNativeId;
    private String adMobNativeId;
    private String adNetwork;
    private String adStatus;
    TemplateView admobNativeAd;
    LinearLayout admobNativeBackground;
    private String appLovinDiscMrecZoneId;
    private String appLovinNativeId;
    private String backupAdNetwork;
    private int cornerRadius;
    private boolean darkTheme;
    com.facebook.ads.NativeAd fanNativeAd;
    NativeAdLayout fanNativeAdLayout;
    private String fanNativeId;
    FrameLayout huaweiNativeAd;
    private boolean legacyGDPR;
    MediaView mediaView;
    private String nativeAdStyle;
    MaterialCardView nativeAdViewContainer;
    private int nativeBackgroundDark;
    private int nativeBackgroundLight;
    FrameLayout pangleNativeAd;
    private String pangleNativeId;
    private int placementStatus;
    View startappNativeAd;
    LinearLayout startappNativeBackground;
    Button startappNativeButton;
    TextView startappNativeDescription;
    ImageView startappNativeIcon;
    ImageView startappNativeImage;
    TextView startappNativeTitle;
    private int strokeColor;
    private int strokeWidth;

    public NativeAdViewHolder(View view) {
        super(view);
        this.adStatus = "";
        this.adNetwork = "";
        this.backupAdNetwork = "";
        this.adMobNativeId = "";
        this.adManagerNativeId = "";
        this.fanNativeId = "";
        this.appLovinNativeId = "";
        this.appLovinDiscMrecZoneId = "";
        this.pangleNativeId = "";
        this.placementStatus = 1;
        this.darkTheme = false;
        this.nativeAdStyle = "";
        this.legacyGDPR = false;
        this.nativeBackgroundLight = R.color.color_native_background_light;
        this.nativeBackgroundDark = R.color.color_native_background_dark;
        this.cornerRadius = 0;
        this.strokeWidth = 0;
        this.strokeColor = android.R.color.transparent;
        this.nativeAdViewContainer = (MaterialCardView) view.findViewById(R.id.native_ad_view_container);
        this.admobNativeAd = (TemplateView) view.findViewById(R.id.admob_native_ad_container);
        this.mediaView = (MediaView) view.findViewById(R.id.media_view);
        this.admobNativeBackground = (LinearLayout) view.findViewById(R.id.background);
        this.adManagerNativeAd = (AdManagerTemplateView) view.findViewById(R.id.google_ad_manager_native_ad_container);
        this.adManagerMediaView = (MediaView) view.findViewById(R.id.ad_manager_media_view);
        this.adManagerNativeBackground = (LinearLayout) view.findViewById(R.id.ad_manager_background);
        this.fanNativeAdLayout = (NativeAdLayout) view.findViewById(R.id.fan_native_ad_container);
        this.startappNativeAd = view.findViewById(R.id.startapp_native_ad_container);
        this.startappNativeImage = (ImageView) view.findViewById(R.id.startapp_native_image);
        this.startappNativeIcon = (ImageView) view.findViewById(R.id.startapp_native_icon);
        this.startappNativeTitle = (TextView) view.findViewById(R.id.startapp_native_title);
        this.startappNativeDescription = (TextView) view.findViewById(R.id.startapp_native_description);
        Button button = (Button) view.findViewById(R.id.startapp_native_button);
        this.startappNativeButton = button;
        button.setOnClickListener(new o(this, 2));
        this.startappNativeBackground = (LinearLayout) view.findViewById(R.id.startapp_native_background);
        this.pangleNativeAd = (FrameLayout) view.findViewById(R.id.pangle_native_ad_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBackupNativeAd$2(Context context, com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        if (this.darkTheme) {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(context, this.nativeBackgroundDark))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(context, this.nativeBackgroundLight))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundLight);
        }
        this.mediaView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.admobNativeAd.setNativeAd(nativeAd);
        this.admobNativeAd.setVisibility(0);
        this.nativeAdViewContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadNativeAd$1(Context context, com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        if (this.darkTheme) {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(context, this.nativeBackgroundDark))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.admobNativeAd.setStyles(new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(ContextCompat.getColor(context, this.nativeBackgroundLight))).build());
            this.admobNativeBackground.setBackgroundResource(this.nativeBackgroundLight);
        }
        this.mediaView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.admobNativeAd.setNativeAd(nativeAd);
        this.admobNativeAd.setVisibility(0);
        this.nativeAdViewContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.itemView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBackupNativeAd(final Context context) {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.backupAdNetwork;
        str.getClass();
        i2 = 1;
        switch (str) {
            case "pangle":
                if (this.pangleNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "Pangle Native Ad has been loaded");
                    break;
                } else {
                    PAGNativeAd.loadAd(this.pangleNativeId, new PAGNativeRequest(), new PAGNativeAdLoadListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.6
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i8, String str2) {
                            Log.d(NativeAdViewHolder.TAG, "Pangle Native Ad Error");
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            LayoutInflater layoutInflater;
                            View viewInflate;
                            Log.d(NativeAdViewHolder.TAG, "Pangle Native Ad Loaded");
                            layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
                            String str2 = NativeAdViewHolder.this.nativeAdStyle;
                            str2.getClass();
                            switch (str2) {
                                case "medium":
                                case "news":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_news_template_view, (ViewGroup) null);
                                    break;
                                case "radio":
                                case "small":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_radio_template_view, (ViewGroup) null);
                                    break;
                                case "video_large":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_video_large_template_view, (ViewGroup) null);
                                    break;
                                case "video_small":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_video_small_template_view, (ViewGroup) null);
                                    break;
                                default:
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_medium_template_view, (ViewGroup) null);
                                    break;
                            }
                            NativeAdViewHolder.this.populatePangleNativeAdView(context, viewInflate, pAGNativeAd);
                            NativeAdViewHolder.this.pangleNativeAd.removeAllViews();
                            NativeAdViewHolder.this.pangleNativeAd.addView(viewInflate);
                            NativeAdViewHolder.this.pangleNativeAd.setVisibility(0);
                            NativeAdViewHolder.this.nativeAdViewContainer.setVisibility(0);
                        }
                    });
                    break;
                }
                break;
            case "admob":
                if (this.admobNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "AdMob native ads has been loaded");
                    break;
                } else {
                    new AdLoader.Builder(context, this.adMobNativeId).forNativeAd(new e(this, context, i2)).withAdListener(new AdListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.4
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            NativeAdViewHolder.this.admobNativeAd.setVisibility(8);
                            NativeAdViewHolder.this.nativeAdViewContainer.setVisibility(8);
                        }
                    }).build().loadAd(Tools.getAdRequest((Activity) context, Boolean.valueOf(this.legacyGDPR)));
                    break;
                }
                break;
            case "facebook":
                this.fanNativeAd = new com.facebook.ads.NativeAd(context, this.fanNativeId);
                this.fanNativeAd.loadAd(this.fanNativeAd.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.5
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        LayoutInflater layoutInflaterFrom;
                        LinearLayout linearLayout;
                        NativeAdViewHolder.this.fanNativeAdLayout.setVisibility(0);
                        NativeAdViewHolder.this.nativeAdViewContainer.setVisibility(0);
                        com.facebook.ads.NativeAd nativeAd = NativeAdViewHolder.this.fanNativeAd;
                        if (nativeAd != ad) {
                            return;
                        }
                        nativeAd.unregisterView();
                        layoutInflaterFrom = LayoutInflater.from(context);
                        String str2 = NativeAdViewHolder.this.nativeAdStyle;
                        str2.getClass();
                        switch (str2) {
                            case "medium":
                            case "news":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_news_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "radio":
                            case "small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_radio_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "video_large":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_large_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "video_small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_small_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            default:
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_medium_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                        }
                        NativeAdViewHolder.this.fanNativeAdLayout.addView(linearLayout);
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.ad_choices_container);
                        Context context2 = context;
                        NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.this;
                        AdOptionsView adOptionsView = new AdOptionsView(context2, nativeAdViewHolder.fanNativeAd, nativeAdViewHolder.fanNativeAdLayout);
                        linearLayout2.removeAllViews();
                        linearLayout2.addView(adOptionsView, 0);
                        TextView textView = (TextView) linearLayout.findViewById(R.id.native_ad_title);
                        com.facebook.ads.MediaView mediaView = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_media);
                        com.facebook.ads.MediaView mediaView2 = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_icon);
                        TextView textView2 = (TextView) linearLayout.findViewById(R.id.native_ad_social_context);
                        TextView textView3 = (TextView) linearLayout.findViewById(R.id.native_ad_body);
                        TextView textView4 = (TextView) linearLayout.findViewById(R.id.native_ad_sponsored_label);
                        Button button = (Button) linearLayout.findViewById(R.id.native_ad_call_to_action);
                        LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.ad_unit);
                        if (NativeAdViewHolder.this.darkTheme) {
                            textView.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_primary_text_color));
                            textView2.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_primary_text_color));
                            textView4.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_secondary_text_color));
                            textView3.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_secondary_text_color));
                            linearLayout3.setBackgroundResource(NativeAdViewHolder.this.nativeBackgroundDark);
                        } else {
                            linearLayout3.setBackgroundResource(NativeAdViewHolder.this.nativeBackgroundLight);
                        }
                        textView.setText(NativeAdViewHolder.this.fanNativeAd.getAdvertiserName());
                        textView3.setText(NativeAdViewHolder.this.fanNativeAd.getAdBodyText());
                        textView2.setText(NativeAdViewHolder.this.fanNativeAd.getAdSocialContext());
                        button.setVisibility(NativeAdViewHolder.this.fanNativeAd.hasCallToAction() ? 0 : 4);
                        button.setText(NativeAdViewHolder.this.fanNativeAd.getAdCallToAction());
                        textView4.setText(NativeAdViewHolder.this.fanNativeAd.getSponsoredTranslation());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(textView);
                        arrayList.add(textView4);
                        arrayList.add(mediaView2);
                        arrayList.add(mediaView);
                        arrayList.add(textView3);
                        arrayList.add(textView2);
                        arrayList.add(button);
                        NativeAdViewHolder.this.fanNativeAd.registerViewForInteraction(linearLayout, mediaView2, mediaView, arrayList);
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

    private void loadNativeAd(final Context context) {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.adNetwork;
        str.getClass();
        i2 = 0;
        switch (str) {
            case "pangle":
                if (this.pangleNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "Pangle Native Ad has been loaded");
                    break;
                } else {
                    PAGNativeAd.loadAd(this.pangleNativeId, new PAGNativeRequest(), new PAGNativeAdLoadListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.3
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i8, String str2) {
                            NativeAdViewHolder.this.loadBackupNativeAd(context);
                            Log.d(NativeAdViewHolder.TAG, "Pangle Native Ad Error");
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            LayoutInflater layoutInflater;
                            View viewInflate;
                            Log.d(NativeAdViewHolder.TAG, "Pangle Native Ad Loaded");
                            layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
                            String str2 = NativeAdViewHolder.this.nativeAdStyle;
                            str2.getClass();
                            switch (str2) {
                                case "medium":
                                case "news":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_news_template_view, (ViewGroup) null);
                                    break;
                                case "radio":
                                case "small":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_radio_template_view, (ViewGroup) null);
                                    break;
                                case "video_large":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_video_large_template_view, (ViewGroup) null);
                                    break;
                                case "video_small":
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_video_small_template_view, (ViewGroup) null);
                                    break;
                                default:
                                    viewInflate = layoutInflater.inflate(R.layout.gnt_pangle_medium_template_view, (ViewGroup) null);
                                    break;
                            }
                            NativeAdViewHolder.this.populatePangleNativeAdView(context, viewInflate, pAGNativeAd);
                            NativeAdViewHolder.this.pangleNativeAd.removeAllViews();
                            NativeAdViewHolder.this.pangleNativeAd.addView(viewInflate);
                            NativeAdViewHolder.this.pangleNativeAd.setVisibility(0);
                            NativeAdViewHolder.this.nativeAdViewContainer.setVisibility(0);
                        }
                    });
                    break;
                }
                break;
            case "admob":
                if (this.admobNativeAd.getVisibility() == 0) {
                    Log.d(TAG, "AdMob native ads has been loaded");
                    break;
                } else {
                    new AdLoader.Builder(context, this.adMobNativeId).forNativeAd(new e(this, context, i2)).withAdListener(new AdListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.1
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            NativeAdViewHolder.this.loadBackupNativeAd(context);
                        }
                    }).build().loadAd(Tools.getAdRequest((Activity) context, Boolean.valueOf(this.legacyGDPR)));
                    break;
                }
                break;
            case "facebook":
                this.fanNativeAd = new com.facebook.ads.NativeAd(context, this.fanNativeId);
                this.fanNativeAd.loadAd(this.fanNativeAd.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.2
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        LayoutInflater layoutInflaterFrom;
                        LinearLayout linearLayout;
                        NativeAdViewHolder.this.fanNativeAdLayout.setVisibility(0);
                        NativeAdViewHolder.this.nativeAdViewContainer.setVisibility(0);
                        com.facebook.ads.NativeAd nativeAd = NativeAdViewHolder.this.fanNativeAd;
                        if (nativeAd != ad) {
                            return;
                        }
                        nativeAd.unregisterView();
                        layoutInflaterFrom = LayoutInflater.from(context);
                        String str2 = NativeAdViewHolder.this.nativeAdStyle;
                        str2.getClass();
                        switch (str2) {
                            case "medium":
                            case "news":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_news_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "radio":
                            case "small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_radio_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "video_large":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_large_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            case "video_small":
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_video_small_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                            default:
                                linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.gnt_fan_medium_template_view, (ViewGroup) NativeAdViewHolder.this.fanNativeAdLayout, false);
                                break;
                        }
                        NativeAdViewHolder.this.fanNativeAdLayout.addView(linearLayout);
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.ad_choices_container);
                        Context context2 = context;
                        NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.this;
                        AdOptionsView adOptionsView = new AdOptionsView(context2, nativeAdViewHolder.fanNativeAd, nativeAdViewHolder.fanNativeAdLayout);
                        linearLayout2.removeAllViews();
                        linearLayout2.addView(adOptionsView, 0);
                        TextView textView = (TextView) linearLayout.findViewById(R.id.native_ad_title);
                        com.facebook.ads.MediaView mediaView = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_media);
                        com.facebook.ads.MediaView mediaView2 = (com.facebook.ads.MediaView) linearLayout.findViewById(R.id.native_ad_icon);
                        TextView textView2 = (TextView) linearLayout.findViewById(R.id.native_ad_social_context);
                        TextView textView3 = (TextView) linearLayout.findViewById(R.id.native_ad_body);
                        TextView textView4 = (TextView) linearLayout.findViewById(R.id.native_ad_sponsored_label);
                        Button button = (Button) linearLayout.findViewById(R.id.native_ad_call_to_action);
                        LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.ad_unit);
                        if (NativeAdViewHolder.this.darkTheme) {
                            textView.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_primary_text_color));
                            textView2.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_primary_text_color));
                            textView4.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_secondary_text_color));
                            textView3.setTextColor(ContextCompat.getColor(context, R.color.applovin_dark_secondary_text_color));
                            linearLayout3.setBackgroundResource(NativeAdViewHolder.this.nativeBackgroundDark);
                        } else {
                            linearLayout3.setBackgroundResource(NativeAdViewHolder.this.nativeBackgroundLight);
                        }
                        textView.setText(NativeAdViewHolder.this.fanNativeAd.getAdvertiserName());
                        textView3.setText(NativeAdViewHolder.this.fanNativeAd.getAdBodyText());
                        textView2.setText(NativeAdViewHolder.this.fanNativeAd.getAdSocialContext());
                        button.setVisibility(NativeAdViewHolder.this.fanNativeAd.hasCallToAction() ? 0 : 4);
                        button.setText(NativeAdViewHolder.this.fanNativeAd.getAdCallToAction());
                        textView4.setText(NativeAdViewHolder.this.fanNativeAd.getSponsoredTranslation());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(textView);
                        arrayList.add(textView4);
                        arrayList.add(mediaView2);
                        arrayList.add(mediaView);
                        arrayList.add(textView3);
                        arrayList.add(textView2);
                        arrayList.add(button);
                        NativeAdViewHolder.this.fanNativeAd.registerViewForInteraction(linearLayout, mediaView2, mediaView, arrayList);
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, AdError adError) {
                        NativeAdViewHolder.this.loadBackupNativeAd(context);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void populatePangleNativeAdView(Context context, View view, PAGNativeAd pAGNativeAd) {
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
            Glide.with(context).load(icon.getImageUrl()).into(imageView);
        }
        frameLayout.addView(pAGNativeAd.getNativeAdData().getMediaView());
        button.setText(TextUtils.isEmpty(pAGNativeAd.getNativeAdData().getButtonText()) ? "Download" : pAGNativeAd.getNativeAdData().getButtonText());
        ArrayList arrayList = new ArrayList();
        arrayList.add(button);
        arrayList.add(imageView);
        arrayList.add(textView);
        arrayList.add(textView2);
        arrayList.add(frameLayout);
        pAGNativeAd.registerViewForInteraction((ViewGroup) view, arrayList, (List<View>) null, view2, new PAGNativeAdInteractionListener() { // from class: com.mimikridev.ads.nativead.NativeAdViewHolder.7
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

    public static View setLayoutInflater(ViewGroup viewGroup, String str) {
        str.getClass();
        switch (str) {
            case "news":
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_native_ad_news, viewGroup, false);
            case "radio":
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_native_ad_radio, viewGroup, false);
            case "video_large":
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_native_ad_video_large, viewGroup, false);
            case "video_small":
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_native_ad_video_small, viewGroup, false);
            default:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_native_ad_medium, viewGroup, false);
        }
    }

    private void setMargins(Context context, View view, int i2, int i8, int i9, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(context.getResources().getDimensionPixelSize(i2), context.getResources().getDimensionPixelSize(i8), context.getResources().getDimensionPixelSize(i9), context.getResources().getDimensionPixelSize(i10));
            view.requestLayout();
        }
    }

    private void setNativeAdCornerRadius(Context context) {
        this.nativeAdViewContainer.setRadius(context.getResources().getDimensionPixelOffset(this.cornerRadius));
    }

    private void setNativeAdMargin(Context context, int i2, int i8, int i9, int i10) {
        setMargins(context, this.nativeAdViewContainer, i2, i8, i9, i10);
    }

    private void setNativeAdPadding(Context context, int i2, int i8, int i9, int i10) {
        this.nativeAdViewContainer.setContentPadding(context.getResources().getDimensionPixelSize(i2), context.getResources().getDimensionPixelSize(i8), context.getResources().getDimensionPixelSize(i9), context.getResources().getDimensionPixelSize(i10));
        if (this.darkTheme) {
            this.nativeAdViewContainer.setCardBackgroundColor(ContextCompat.getColor(context, this.nativeBackgroundDark));
        } else {
            this.nativeAdViewContainer.setCardBackgroundColor(ContextCompat.getColor(context, this.nativeBackgroundLight));
        }
    }

    private void setNativeAdStrokeColor(Context context) {
        this.nativeAdViewContainer.setStrokeColor(ContextCompat.getColor(context, this.strokeColor));
    }

    private void setNativeAdStrokeWidth(Context context) {
        this.nativeAdViewContainer.setStrokeWidth(context.getResources().getDimensionPixelOffset(this.strokeWidth));
    }

    public NativeAdViewHolder buildNativeAd(Context context) {
        loadNativeAd(context);
        return this;
    }

    public void populateWortiseNativeAdView(Context context, com.google.android.gms.ads.nativead.NativeAd nativeAd, com.google.android.gms.ads.nativead.NativeAdView nativeAdView) {
        if (this.darkTheme) {
            this.nativeAdViewContainer.setBackgroundColor(ContextCompat.getColor(context, this.nativeBackgroundDark));
            nativeAdView.findViewById(R.id.background).setBackgroundResource(this.nativeBackgroundDark);
        } else {
            this.nativeAdViewContainer.setBackgroundColor(ContextCompat.getColor(context, this.nativeBackgroundLight));
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

    public NativeAdViewHolder setAdManagerNativeId(String str) {
        this.adManagerNativeId = str;
        return this;
    }

    public NativeAdViewHolder setAdMobNativeId(String str) {
        this.adMobNativeId = str;
        return this;
    }

    public NativeAdViewHolder setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public NativeAdViewHolder setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public NativeAdViewHolder setAppLovinDiscoveryMrecZoneId(String str) {
        this.appLovinDiscMrecZoneId = str;
        return this;
    }

    public NativeAdViewHolder setAppLovinNativeId(String str) {
        this.appLovinNativeId = str;
        return this;
    }

    public NativeAdViewHolder setBackgroundColor(int i2, int i8) {
        this.nativeBackgroundLight = i2;
        this.nativeBackgroundDark = i8;
        return this;
    }

    public NativeAdViewHolder setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public NativeAdViewHolder setDarkTheme(boolean z2) {
        this.darkTheme = z2;
        return this;
    }

    public NativeAdViewHolder setFanNativeId(String str) {
        this.fanNativeId = str;
        return this;
    }

    public NativeAdViewHolder setMargin(Context context, int i2, int i8, int i9, int i10) {
        setNativeAdMargin(context, i2, i8, i9, i10);
        return this;
    }

    public NativeAdViewHolder setNativeAdStyle(String str) {
        this.nativeAdStyle = str;
        return this;
    }

    public NativeAdViewHolder setPadding(Context context, int i2, int i8, int i9, int i10) {
        setNativeAdPadding(context, i2, i8, i9, i10);
        return this;
    }

    public NativeAdViewHolder setPangleNativeId(String str) {
        this.pangleNativeId = str;
        return this;
    }

    public NativeAdViewHolder setPlacementStatus(int i2) {
        this.placementStatus = i2;
        return this;
    }

    public NativeAdViewHolder setRadius(Context context, int i2) {
        this.cornerRadius = i2;
        setNativeAdCornerRadius(context);
        return this;
    }

    public NativeAdViewHolder setStrokeColor(Context context, int i2) {
        this.strokeColor = i2;
        setNativeAdStrokeColor(context);
        return this;
    }

    public NativeAdViewHolder setStrokeWidth(Context context, int i2) {
        this.strokeWidth = i2;
        setNativeAdStrokeWidth(context);
        return this;
    }
}
