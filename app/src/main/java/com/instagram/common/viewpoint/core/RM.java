package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.api.NativeAdViewApi;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RM implements NativeAdViewApi {
    public static View A00(C1477dL c1477dL, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C1137Ur c1137Ur = (C1137Ur) nativeAdViewAttributes.getInternalAttributes();
        C1020Qc internalNativeAd = C1020Qc.A0L(nativeAd.getInternalNativeAd());
        internalNativeAd.A1a(EnumC1138Us.A00(type.getEnumCode()));
        internalNativeAd.A1Z(c1137Ur);
        C6Q c6q = new C6Q();
        NativeAdLayout mediumRectTemplateLayout = new NativeAdLayout(c1477dL, c6q);
        c6q.A06(mediumRectTemplateLayout, c1477dL, nativeAd, c1137Ur);
        mediumRectTemplateLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (AbstractC1180Wl.A02 * type.getHeight())));
        return mediumRectTemplateLayout;
    }

    public static View A01(C1477dL c1477dL, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C1020Qc c1020QcA0L = C1020Qc.A0L(nativeAd.getInternalNativeAd());
        C1137Ur c1137Ur = (C1137Ur) nativeAdViewAttributes.getInternalAttributes();
        c1020QcA0L.A1a(EnumC1138Us.A0B);
        c1020QcA0L.A1Z(c1137Ur);
        C6Q c6q = new C6Q();
        NativeAdLayout nativeAdLayout = new NativeAdLayout(c1477dL, c6q);
        c6q.A06(nativeAdLayout, c1477dL, nativeAd, c1137Ur);
        return nativeAdLayout;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd) {
        return render(context, nativeAd, (NativeAdViewAttributes) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
        return render(context, nativeAd, type, null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A00(RB.A03(context), nativeAd, type, nativeAdViewAttributes);
        } catch (Throwable th) {
            return YB.A00(RB.A03(context), th);
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        C1477dL contextWrapper;
        try {
            if (context instanceof C1477dL) {
                contextWrapper = (C1477dL) context;
            } else {
                contextWrapper = RB.A03(context);
            }
            return A01(contextWrapper, nativeAd, nativeAdViewAttributes);
        } catch (Throwable th) {
            return YB.A00(RB.A03(context), th);
        }
    }
}
