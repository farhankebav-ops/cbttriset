package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RS implements NativeBannerAdApi {
    public static byte[] A01;
    public static String[] A02 = {"068yMtBHtCdtzUYBTQD9IwnMWW1doBJF", "2l8Hok5ewW", "SqMVYGMc7AyphtDxx4DkXGESiOtqp3Wk", "n7xht10RjuH04nLwyOxbbpbZUJ6bFNP5", "hemUdCIRyaFDmP64bLQtQG29khNbMpFH", "0krrnlsRXu", "j9YMm5Kfv7iMZif7VGfsQGY8YQ9Z0I42", "SiUubuHC3Y"};
    public final C1020Qc A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A02[0].charAt(2) != '8') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "SDJ7CqIuYGJEmotuvG7btG7Q2tCK4c6p";
            strArr[6] = "3TZdd6KNeaSFSkmrHNZK7GULPPfkGOEa";
            bArrCopyOfRange[i10] = (byte) ((b8 - i9) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-50, -54, -55, -3, -20, -15, -19, -10, -21, -19, -42, -19, -4, -1, -9, -6, -13};
    }

    static {
        A01();
    }

    public RS(NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = C1020Qc.A0L(nativeAdBaseApi);
        this.A00.A1b(V6.A05);
    }

    private void A02(ImageView imageView, NativeAdBaseApi nativeAdBaseApi) {
        C1020Qc c1020QcA0L = C1020Qc.A0L(nativeAdBaseApi);
        C1613fZ c1613fZ = new C1613fZ(this, imageView, c1020QcA0L);
        C1135Up adIcon = c1020QcA0L.getAdIcon();
        if (adIcon != null) {
            Bitmap bitmapA0N = c1020QcA0L.A11().A0N(adIcon.getUrl());
            Context context = imageView.getContext();
            String[] strArr = A02;
            if (strArr[2].charAt(21) == strArr[6].charAt(21)) {
                A02[4] = "oesEo3u5gOmbsNZfXjsimFyw8pPXYbZZ";
                C1477dL c1477dLA03 = RB.A03(context);
                if (bitmapA0N != null) {
                    Drawable drawableA05 = C1020Qc.A05(c1477dLA03, bitmapA0N, c1020QcA0L.A1g(), c1020QcA0L.A1D());
                    C1020Qc.A0f(drawableA05, imageView);
                    imageView.post(new C1612fY(this, c1020QcA0L, drawableA05));
                    return;
                } else {
                    C1613fZ c1613fZ2 = null;
                    RP loadImageTask = new RP(c1477dLA03, c1613fZ, c1020QcA0L.A1g(), c1613fZ2);
                    loadImageTask.execute(new RR(adIcon.getUrl(), c1020QcA0L.A1D(), c1613fZ2));
                    return;
                }
            }
        } else {
            QQ qqA16 = c1020QcA0L.A16();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            if (A02[4].charAt(17) != 't') {
                A02[4] = "aFZFEDb6phUkMJAuumeHd9ws0nVx9tBY";
                c1020QcA0L.A12().A0F().A3F(-1L, adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
                if (qqA16 != null) {
                    qqA16.ADB(V1.A00(adErrorType));
                }
                Log.e(A00(0, 17, 86), adErrorType.getDefaultErrorMessage());
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView) {
        registerViewForInteraction(view, imageView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView, List<View> list) {
        if (imageView != null) {
            A02(imageView, this.A00);
        }
        if (list != null) {
            C1020Qc c1020Qc = this.A00;
            if (A02[1].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "ll9cTRtW3a";
            strArr[7] = "WGLVGgKdvO";
            c1020Qc.A1N(view, imageView, list);
            return;
        }
        this.A00.A1M(view, imageView);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, List<View> clickableViews) {
        if (mediaView != null) {
            ((C1621fh) mediaView.getMediaViewApi()).A0M(this.A00, true);
        }
        if (clickableViews != null) {
            this.A00.A1Q(view, mediaView, clickableViews, true);
        } else {
            this.A00.A1R(view, mediaView, true);
        }
    }
}
