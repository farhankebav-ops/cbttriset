package com.instagram.common.viewpoint.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1732hZ implements S7 {
    public final NB A00;
    public final NP A01;
    public final SF A02;
    public final C1477dL A03;
    public final boolean A04;

    public C1732hZ(C1477dL c1477dL, NP np, SF sf, NB nb, boolean z2) {
        this.A03 = c1477dL;
        this.A01 = np;
        this.A02 = sf;
        this.A00 = nb;
        this.A04 = z2;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        NQ playableWebViewClient = new NQ(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0F());
        playableWebViewClient.A03();
    }

    private void A01(boolean z2) {
        if (this.A00.A0A() == NC.A05) {
            A00();
            return;
        }
        String strA0F = this.A00.A0F();
        if (z2) {
            SF sf = this.A02;
            String markupUrlResult = this.A00.A0F();
            strA0F = sf.A0S(markupUrlResult);
        }
        this.A00.A0K(strA0F);
        this.A01.AEa();
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACh() {
        if (this.A04) {
            this.A01.AEZ(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACq() {
        A01(true);
    }
}
