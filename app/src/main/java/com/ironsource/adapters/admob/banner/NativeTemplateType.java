package com.ironsource.adapters.admob.banner;

import com.ironsource.adapters.admob.R;
import com.ironsource.mediationsdk.ISBannerSize;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
enum NativeTemplateType {
    NB_TMP_BASIC(R.layout.ad_mob_native_banner_template_basic_layout, true, true, 1, 1),
    NB_TMP_BASIC_LARGE(R.layout.ad_mob_native_banner_template_basic_layout, false, true, 1, 1),
    NB_TMP_ICON_TEXT(R.layout.ad_mob_native_banner_template_icon_text_layout, true, true, 1, 1),
    NB_TMP_TEXT_CTA(R.layout.ad_mob_native_banner_template_text_cta_layout, false, true, 3, 1),
    NB_TMP_RECT(R.layout.ad_mob_native_banner_template_rect_layout, false, false, 1, 1);

    private static final String NATIVE_TEMPLATE_NAME = "nativeBannerTemplateName";
    private final int mAdChoicesPlacement;
    private final boolean mHideCallToAction;
    private final boolean mHideVideoContent;
    private final int mLayoutId;
    private final int mMediaAspectRatio;

    NativeTemplateType(int i2, boolean z2, boolean z7, int i8, int i9) {
        this.mLayoutId = i2;
        this.mHideCallToAction = z2;
        this.mHideVideoContent = z7;
        this.mAdChoicesPlacement = i8;
        this.mMediaAspectRatio = i9;
    }

    public static NativeTemplateType createTemplateType(JSONObject jSONObject, ISBannerSize iSBannerSize) {
        String description = iSBannerSize.getDescription();
        description.getClass();
        switch (description) {
            case "RECTANGLE":
                return NB_TMP_RECT;
            case "LARGE":
                return NB_TMP_BASIC_LARGE;
            case "SMART":
            case "BANNER":
                try {
                    return valueOf(jSONObject.optString(NATIVE_TEMPLATE_NAME, NB_TMP_ICON_TEXT.toString()));
                } catch (IllegalArgumentException unused) {
                    return NB_TMP_ICON_TEXT;
                }
            default:
                return NB_TMP_BASIC;
        }
    }

    public int getAdChoicesPlacement() {
        return this.mAdChoicesPlacement;
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }

    public int getMediaAspectRatio() {
        return this.mMediaAspectRatio;
    }

    public boolean shouldHideCallToAction() {
        return this.mHideCallToAction;
    }

    public boolean shouldHideVideoContent() {
        return this.mHideVideoContent;
    }
}
