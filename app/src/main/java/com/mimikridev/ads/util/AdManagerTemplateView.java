package com.mimikridev.ads.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.mimikridev.ads.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdManagerTemplateView extends FrameLayout {
    private static final String MEDIUM_TEMPLATE = "medium_template";
    private static final String SMALL_TEMPLATE = "small_template";
    private LinearLayout background;
    private Button callToActionView;
    private ImageView iconView;
    private MediaView mediaView;
    private NativeAd nativeAd;
    private NativeAdView nativeAdView;
    private TextView primaryView;
    private RatingBar ratingBar;
    private TextView secondaryView;
    private NativeTemplateStyle styles;
    private int templateType;
    private TextView tertiaryView;

    public AdManagerTemplateView(Context context) {
        super(context);
    }

    private boolean adHasOnlyStore(NativeAd nativeAd) {
        return !TextUtils.isEmpty(nativeAd.getStore()) && TextUtils.isEmpty(nativeAd.getAdvertiser());
    }

    private void applyStyles() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Button button;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Button button2;
        Button button3;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        Button button4;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        ColorDrawable mainBackgroundColor = this.styles.getMainBackgroundColor();
        if (mainBackgroundColor != null) {
            this.background.setBackground(mainBackgroundColor);
            TextView textView13 = this.primaryView;
            if (textView13 != null) {
                textView13.setBackground(mainBackgroundColor);
            }
            TextView textView14 = this.secondaryView;
            if (textView14 != null) {
                textView14.setBackground(mainBackgroundColor);
            }
            TextView textView15 = this.tertiaryView;
            if (textView15 != null) {
                textView15.setBackground(mainBackgroundColor);
            }
        }
        Typeface primaryTextTypeface = this.styles.getPrimaryTextTypeface();
        if (primaryTextTypeface != null && (textView12 = this.primaryView) != null) {
            textView12.setTypeface(primaryTextTypeface);
        }
        Typeface secondaryTextTypeface = this.styles.getSecondaryTextTypeface();
        if (secondaryTextTypeface != null && (textView11 = this.secondaryView) != null) {
            textView11.setTypeface(secondaryTextTypeface);
        }
        Typeface tertiaryTextTypeface = this.styles.getTertiaryTextTypeface();
        if (tertiaryTextTypeface != null && (textView10 = this.tertiaryView) != null) {
            textView10.setTypeface(tertiaryTextTypeface);
        }
        Typeface callToActionTextTypeface = this.styles.getCallToActionTextTypeface();
        if (callToActionTextTypeface != null && (button4 = this.callToActionView) != null) {
            button4.setTypeface(callToActionTextTypeface);
        }
        int primaryTextTypefaceColor = this.styles.getPrimaryTextTypefaceColor();
        if (primaryTextTypefaceColor > 0 && (textView9 = this.primaryView) != null) {
            textView9.setTextColor(primaryTextTypefaceColor);
        }
        int secondaryTextTypefaceColor = this.styles.getSecondaryTextTypefaceColor();
        if (secondaryTextTypefaceColor > 0 && (textView8 = this.secondaryView) != null) {
            textView8.setTextColor(secondaryTextTypefaceColor);
        }
        int tertiaryTextTypefaceColor = this.styles.getTertiaryTextTypefaceColor();
        if (tertiaryTextTypefaceColor > 0 && (textView7 = this.tertiaryView) != null) {
            textView7.setTextColor(tertiaryTextTypefaceColor);
        }
        int callToActionTypefaceColor = this.styles.getCallToActionTypefaceColor();
        if (callToActionTypefaceColor > 0 && (button3 = this.callToActionView) != null) {
            button3.setTextColor(callToActionTypefaceColor);
        }
        float callToActionTextSize = this.styles.getCallToActionTextSize();
        if (callToActionTextSize > 0.0f && (button2 = this.callToActionView) != null) {
            button2.setTextSize(callToActionTextSize);
        }
        float primaryTextSize = this.styles.getPrimaryTextSize();
        if (primaryTextSize > 0.0f && (textView6 = this.primaryView) != null) {
            textView6.setTextSize(primaryTextSize);
        }
        float secondaryTextSize = this.styles.getSecondaryTextSize();
        if (secondaryTextSize > 0.0f && (textView5 = this.secondaryView) != null) {
            textView5.setTextSize(secondaryTextSize);
        }
        float tertiaryTextSize = this.styles.getTertiaryTextSize();
        if (tertiaryTextSize > 0.0f && (textView4 = this.tertiaryView) != null) {
            textView4.setTextSize(tertiaryTextSize);
        }
        ColorDrawable callToActionBackgroundColor = this.styles.getCallToActionBackgroundColor();
        if (callToActionBackgroundColor != null && (button = this.callToActionView) != null) {
            button.setBackground(callToActionBackgroundColor);
        }
        ColorDrawable primaryTextBackgroundColor = this.styles.getPrimaryTextBackgroundColor();
        if (primaryTextBackgroundColor != null && (textView3 = this.primaryView) != null) {
            textView3.setBackground(primaryTextBackgroundColor);
        }
        ColorDrawable secondaryTextBackgroundColor = this.styles.getSecondaryTextBackgroundColor();
        if (secondaryTextBackgroundColor != null && (textView2 = this.secondaryView) != null) {
            textView2.setBackground(secondaryTextBackgroundColor);
        }
        ColorDrawable tertiaryTextBackgroundColor = this.styles.getTertiaryTextBackgroundColor();
        if (tertiaryTextBackgroundColor != null && (textView = this.tertiaryView) != null) {
            textView.setBackground(tertiaryTextBackgroundColor);
        }
        invalidate();
        requestLayout();
    }

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TemplateView, 0, 0);
        try {
            this.templateType = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TemplateView_gnt_template_type, R.layout.gnt_ad_manager_medium_template_view);
            typedArrayObtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.templateType, this);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void destroyNativeAd() {
        this.nativeAd.destroy();
    }

    public NativeAdView getNativeAdView() {
        return this.nativeAdView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.nativeAdView = (NativeAdView) findViewById(R.id.native_ad_view);
        this.primaryView = (TextView) findViewById(R.id.primary);
        this.secondaryView = (TextView) findViewById(R.id.secondary);
        this.tertiaryView = (TextView) findViewById(R.id.body);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        this.ratingBar = ratingBar;
        ratingBar.setEnabled(false);
        this.callToActionView = (Button) findViewById(R.id.cta);
        this.iconView = (ImageView) findViewById(R.id.icon);
        this.mediaView = (MediaView) findViewById(R.id.ad_manager_media_view);
        this.background = (LinearLayout) findViewById(R.id.ad_manager_background);
    }

    public void setNativeAd(NativeAd nativeAd) {
        this.nativeAd = nativeAd;
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        String headline = nativeAd.getHeadline();
        String body = nativeAd.getBody();
        String callToAction = nativeAd.getCallToAction();
        Double starRating = nativeAd.getStarRating();
        NativeAd.Image icon = nativeAd.getIcon();
        this.nativeAdView.setCallToActionView(this.callToActionView);
        this.nativeAdView.setHeadlineView(this.primaryView);
        this.nativeAdView.setMediaView(this.mediaView);
        this.secondaryView.setVisibility(0);
        if (adHasOnlyStore(nativeAd)) {
            this.nativeAdView.setStoreView(this.secondaryView);
        } else if (TextUtils.isEmpty(advertiser)) {
            store = "";
        } else {
            this.nativeAdView.setAdvertiserView(this.secondaryView);
            store = advertiser;
        }
        this.primaryView.setText(headline);
        this.callToActionView.setText(callToAction);
        if (starRating == null || starRating.doubleValue() <= 0.0d) {
            this.secondaryView.setText(store);
            this.secondaryView.setVisibility(0);
            this.ratingBar.setVisibility(8);
        } else {
            this.secondaryView.setVisibility(8);
            this.ratingBar.setVisibility(0);
            this.ratingBar.setMax(5);
            this.nativeAdView.setStarRatingView(this.ratingBar);
        }
        if (icon != null) {
            this.iconView.setVisibility(0);
            this.iconView.setImageDrawable(icon.getDrawable());
        } else {
            this.iconView.setVisibility(8);
        }
        TextView textView = this.tertiaryView;
        if (textView != null) {
            textView.setText(body);
            this.nativeAdView.setBodyView(this.tertiaryView);
        }
        this.nativeAdView.setNativeAd(nativeAd);
    }

    public void setStyles(NativeTemplateStyle nativeTemplateStyle) {
        this.styles = nativeTemplateStyle;
        applyStyles();
    }

    public AdManagerTemplateView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public AdManagerTemplateView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public AdManagerTemplateView(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
        initView(context, attributeSet);
    }
}
