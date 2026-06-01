package com.instagram.common.viewpoint.core;

import android.app.Activity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ze, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1251Ze extends WebView {
    public static byte[] A01;
    public static final String A02;
    public boolean A00;

    public static String A0B(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A01 = new byte[]{-31, -4, 4, 7, 0, -1, -69, 15, 10, -69, 4, 9, 4, 15, 4, -4, 7, 4, 21, 0, -69, -34, 10, 10, 6, 4, 0, -24, -4, 9, -4, 2, 0, 13, -55, -70, -71, -125, -58, -43, -60, -42, -53, -56, -57, 63, 54, 75, 54, 72, 56, 71, 62, 69, 73, 15, -4, -22, -25, -28, -5, -18, -22, -4};
    }

    public abstract WebChromeClient A0G();

    public abstract WebViewClient A0H();

    static {
        A0C();
        A02 = AbstractC1251Ze.class.getSimpleName();
    }

    public AbstractC1251Ze(Activity activity, C1477dL c1477dL) {
        super(activity);
        A0E(c1477dL);
    }

    public AbstractC1251Ze(C1477dL c1477dL) {
        super(c1477dL);
        A0E(c1477dL);
    }

    public static void A0D(int i2) {
        C1451cu context = SP.A00();
        if (context != null) {
            context.A08().AAy(A0B(56, 8, 37), i2, new C1091Sw(A0B(35, 10, 3)));
        }
    }

    private void A0E(SQ sq) {
        setWebChromeClient(A0G());
        setWebViewClient(A0H());
        AbstractC1257Zk.A04(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        if (sq.A05().AAF()) {
            setWebContentsDebuggingEnabled(true);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        try {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        } catch (Exception unused) {
            Log.w(A02, A0B(0, 35, 59));
        }
    }

    private void A0F(String str) {
        loadUrl(A0B(45, 11, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) + str);
    }

    public final void A0I(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException unused) {
            A0F(str);
        }
    }

    public final boolean A0J() {
        return this.A00;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.A00 = true;
        super.destroy();
    }
}
