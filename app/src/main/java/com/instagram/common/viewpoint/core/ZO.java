package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZO extends LinearLayout {
    public static byte[] A0F;
    public static String[] A0G = {"SfnKd94fp0LIHLn5JRYBcVoydcWvvWC", "zcIUR0bnd2fDOpnzxhHInmQw6nqRGEtO", "", "Rlzv6bB7Czucpp1t79MjvCXFuIOZg8dc", "c1MACJD11uXVhN3Ickl6ZqMudEgzXQA", "WTgVZUaV9yT0hbCJXLqGbS", "77CVi", "3ZIeaeVMqGSC8jDTqrHFXNca0PmxnycW"};
    public static final int A0H;
    public static final int A0I;
    public static final Uri A0J;
    public static final View.OnTouchListener A0K;
    public ImageView A00;
    public ImageView A01;
    public ImageView A02;
    public ImageView A03;
    public LinearLayout A04;
    public ZN A05;
    public ZV A06;
    public String A07;
    public final float A08;
    public final WebView A09;
    public final C1477dL A0A;
    public final ZZ A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0F = new byte[]{-23, 8, 10, 18, -114, -73, -70, -66, -80, -22, 19, 22, 27, 5, 22, 8, -74, -41, -52, -43, -121, -43, -56, -37, -48, -35, -52, -121, -55, -39, -42, -34, -38, -52, -39, -6, -5, 8, 14, 13, -45, -5, 5, -6, 7, 4, 23, 36, 26, 40, 37, 31, 26, -28, 31, 36, 42, 27, 36, 42, -28, 23, 25, 42, 31, 37, 36, -28, 12, -1, -5, 13, 18, 30, 28, -35, 16, 29, 19, 33, 30, 24, 19, -35, 18, 23, 33, 30, 28, 20, -68, -56, -56, -60, -114, -125, -125, -53, -53, -53, -126, -70, -75, -73, -71, -74, -61, -61, -65, -126, -73, -61, -63};
    }

    static {
        A0A();
        A0H = Color.rgb(Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE);
        A0J = WQ.A00(A06(90, 23, 25));
        A0K = new ZI();
        A0I = Color.argb(34, 0, 0, 0);
    }

    public ZO(C1477dL c1477dL, WebView webView) {
        this(c1477dL, webView, false, false);
    }

    public ZO(C1477dL c1477dL, WebView webView, boolean z2, boolean z7) {
        super(c1477dL);
        this.A08 = getResources().getDisplayMetrics().density;
        this.A0B = new LQ(this);
        this.A09 = webView;
        this.A0A = c1477dL;
        this.A0C = U8.A06(c1477dL);
        this.A0E = z2;
        this.A0D = z7;
        A08();
        if (z7) {
            A0C(false);
        }
    }

    private void A08() {
        int buttonSizePx;
        int i2 = (int) (this.A08 * 50.0f);
        XP.A0K(this, -1);
        setGravity(16);
        this.A01 = new ImageView(this.A0A);
        this.A01.setContentDescription(A06(4, 5, 16));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(XY.A01(XX.BROWSER_CLOSE));
        this.A01.setOnTouchListener(A0K);
        this.A01.setOnClickListener(new ZJ(this));
        addView(this.A01, layoutParams);
        if (this.A0C && !U7.A2o(this.A0A)) {
            this.A00 = new ImageView(this.A0A);
            this.A00.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A06(0, 4, 108));
            ViewGroup.LayoutParams backButtonParams = new LinearLayout.LayoutParams(i2, i2);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(XY.A01(XX.BACK_ARROW));
            this.A00.setOnTouchListener(A0K);
            this.A00.setOnClickListener(new ZK(this));
            addView(this.A00, backButtonParams);
        }
        this.A06 = new ZV(this.A0A);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        if (this.A0C || U7.A2o(this.A0A)) {
            buttonSizePx = 1056964608;
        } else {
            buttonSizePx = 1065353216;
        }
        layoutParams2.weight = buttonSizePx;
        this.A06.setGravity(17);
        if (U7.A2o(this.A0A) && !this.A0E) {
            this.A04 = new LinearLayout(this.A0A);
            this.A04.setOrientation(1);
            LinearLayout linearLayout = this.A04;
            int i8 = (int) (this.A08 * 2.0f);
            int buttonSizePx2 = (int) (this.A08 * 2.0f);
            linearLayout.setPadding(0, i8, 0, buttonSizePx2);
            layoutParams2.setMarginStart(0);
            addView(this.A04, layoutParams2);
            ImageView imageView = new ImageView(this.A0A);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageBitmap(XY.A01(XX.HANDLER));
            int i9 = (int) (this.A08 * 4.0f);
            int buttonSizePx3 = (int) (this.A08 * 4.0f);
            imageView.setPadding(0, i9, 0, buttonSizePx3);
            this.A04.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout.LayoutParams titleViewsParams = new LinearLayout.LayoutParams(-1, -2);
            this.A04.addView(this.A06, titleViewsParams);
        } else {
            addView(this.A06, layoutParams2);
        }
        if (this.A0C && !U7.A2o(this.A0A)) {
            this.A02 = new ImageView(this.A0A);
            this.A02.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A06(9, 7, 105));
            ViewGroup.LayoutParams titleViewsParams2 = new LinearLayout.LayoutParams(i2, i2);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(XY.A02(XX.BACK_ARROW));
            this.A02.setOnTouchListener(A0K);
            this.A02.setOnClickListener(new ZL(this));
            addView(this.A02, titleViewsParams2);
        }
        this.A03 = new ImageView(this.A0A);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i2);
        this.A03.setContentDescription(A06(16, 19, 44));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(A0K);
        this.A03.setOnClickListener(new ZM(this));
        addView(this.A03, layoutParams3);
        A09();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09() {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.ZO.A09():void");
    }

    private void A0C(boolean z2) {
        int i2 = z2 ? 0 : 8;
        ImageView imageView = this.A00;
        if (A0G[1].charAt(15) == 'W') {
            throw new RuntimeException();
        }
        A0G[2] = "nknH3C2";
        if (imageView != null) {
            this.A00.setVisibility(i2);
        }
        if (this.A02 != null) {
            this.A02.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(boolean z2) {
        if (z2) {
            A0C(true);
        }
    }

    public ZZ getBrowserNavigationListener() {
        return this.A0B;
    }

    private Bitmap getExternalBrowserBitmap() {
        if (this.A0D) {
            return XY.A01(XX.BROWSER_LAUNCH_NATIVE_V2);
        }
        return XY.A01(XX.BROWSER_LAUNCH_NATIVE);
    }

    public void setCloseButtonVisibility(int i2) {
        this.A01.setVisibility(i2);
    }

    public void setListener(ZN zn) {
        this.A05 = zn;
    }

    public void setTitle(String str) {
        this.A06.setTitle(str);
    }

    public void setUrl(String str) {
        this.A07 = str;
        if (TextUtils.isEmpty(this.A07) || A06(35, 11, 94).equals(this.A07)) {
            this.A06.setSubtitle(null);
            this.A03.setEnabled(false);
            this.A03.setColorFilter(new PorterDuffColorFilter(A0H, PorterDuff.Mode.SRC_IN));
        } else {
            this.A06.setSubtitle(this.A07);
            this.A03.setEnabled(true);
            this.A03.setColorFilter((ColorFilter) null);
        }
    }
}
