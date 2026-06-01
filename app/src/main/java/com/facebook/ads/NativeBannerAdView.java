package com.facebook.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class NativeBannerAdView {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Keep
    public enum Type {
        HEIGHT_50(4),
        HEIGHT_100(0),
        HEIGHT_120(1);

        private final int mEnumCode;

        @Nullable
        private NativeAdViewTypeApi mNativeAdViewTypeApi;

        Type(int i2) {
            this.mEnumCode = i2;
        }

        private NativeAdViewTypeApi getNativeAdViewTypeApi() {
            if (this.mNativeAdViewTypeApi == null) {
                this.mNativeAdViewTypeApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewTypeApi(this.mEnumCode);
            }
            return this.mNativeAdViewTypeApi;
        }

        public int getEnumCode() {
            return this.mEnumCode;
        }

        public int getHeight() {
            return getNativeAdViewTypeApi().getHeight();
        }

        public int getValue() {
            return getNativeAdViewTypeApi().getValue();
        }

        public int getWidth() {
            return getNativeAdViewTypeApi().getWidth();
        }
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeBannerAd, "nativeBannerAd must be not null");
        Preconditions.checkNotNull(type, "type must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeBannerAdViewApi().render(context, nativeBannerAd, type, null);
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeBannerAd, "nativeBannerAd must be not null");
        Preconditions.checkNotNull(type, "type must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeBannerAdViewApi().render(context, nativeBannerAd, type, nativeAdViewAttributes);
    }
}
