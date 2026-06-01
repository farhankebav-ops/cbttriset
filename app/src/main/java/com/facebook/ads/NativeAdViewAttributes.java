package com.facebook.ads;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class NativeAdViewAttributes {
    private final NativeAdViewAttributesApi mNativeAdViewAttributesApi;

    public NativeAdViewAttributes(Context context) {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoader(context).createNativeAdViewAttributesApi();
    }

    @Deprecated
    public boolean getAutoplay() {
        return AdSettings.isVideoAutoplay();
    }

    @Deprecated
    public boolean getAutoplayOnMobile() {
        return AdSettings.isVideoAutoplayOnMobile();
    }

    @Deprecated
    public int getBackgroundColor() {
        return 0;
    }

    @Deprecated
    public int getButtonBorderColor() {
        return 0;
    }

    @Deprecated
    public int getButtonColor() {
        return 0;
    }

    @Deprecated
    public int getButtonTextColor() {
        return 0;
    }

    @Deprecated
    public int getDescriptionTextColor() {
        return 0;
    }

    @Deprecated
    public int getDescriptionTextSize() {
        return 0;
    }

    public NativeAdViewAttributesApi getInternalAttributes() {
        return this.mNativeAdViewAttributesApi;
    }

    @Deprecated
    public int getTitleTextColor() {
        return 0;
    }

    @Deprecated
    public int getTitleTextSize() {
        return 0;
    }

    @Nullable
    @Deprecated
    public Typeface getTypeface() {
        return null;
    }

    public NativeAdViewAttributes setBackgroundColor(int i2) {
        this.mNativeAdViewAttributesApi.setBackgroundColor(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i2) {
        this.mNativeAdViewAttributesApi.setCTABorderColor(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i2) {
        this.mNativeAdViewAttributesApi.setCTABackgroundColor(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i2) {
        this.mNativeAdViewAttributesApi.setCTATextColor(i2);
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i2) {
        this.mNativeAdViewAttributesApi.setSecondaryTextColor(i2);
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i2) {
        this.mNativeAdViewAttributesApi.setPrimaryTextColor(i2);
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.mNativeAdViewAttributesApi.setTypeface(typeface);
        return this;
    }

    @Deprecated
    public NativeAdViewAttributes() {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewAttributesApi();
    }

    @Deprecated
    public NativeAdViewAttributes setAutoplay(boolean z2) {
        return this;
    }

    @Deprecated
    public NativeAdViewAttributes setAutoplayOnMobile(boolean z2) {
        return this;
    }
}
