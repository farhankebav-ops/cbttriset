package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.model.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.pP;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTCeilingLandingPageActivity extends TTBaseLandingPageActivity {
    private String Cc;
    private EV DmF;
    private vSq EO;
    private com.bytedance.sdk.component.DmF.vCE EV;
    IlO IlO;
    private oeT MY;
    private com.bytedance.sdk.openadsdk.common.tV NV;
    private String lEW;
    private String tV;
    private int vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!bWL.Cc()) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.lEW = intent.getStringExtra("second_url");
        this.vCE = intent.getIntExtra("source", -1);
        this.MY = pP.IlO().MY();
        pP.IlO().vCE();
        oeT oet = this.MY;
        if (oet == null) {
            finish();
            return;
        }
        this.tV = oet.ED();
        this.Cc = this.MY.KT();
        this.vCE = this.MY.ssS().getDurationSlotType() != 7 ? 5 : 7;
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        IlO(this, eo);
        setContentView(eo);
        IlO();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        EV ev = this.DmF;
        if (ev != null) {
            ev.lEW();
        }
    }

    private void IlO(Context context, FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar;
        this.EV = new com.bytedance.sdk.component.DmF.vCE(context);
        frameLayout.addView(this.EV, new FrameLayout.LayoutParams(-1, -1));
        View viewMY = com.bytedance.sdk.openadsdk.core.widget.vCE.MY(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = BS.MY(context, 18.0f);
        layoutParams.rightMargin = BS.MY(context, 18.0f);
        frameLayout.addView(viewMY, layoutParams);
        final int iBc = this.MY.zPa().Bc();
        if (iBc != 3) {
            tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BS.MY(context, 28.0f), BS.MY(context, 28.0f));
            layoutParams2.gravity = 8388659;
            layoutParams2.topMargin = BS.MY(context, 18.0f);
            layoutParams2.leftMargin = BS.MY(context, 18.0f);
            int iMY = BS.MY(context, 5.0f);
            tVVar.setPadding(iMY, iMY, iMY, iMY);
            tVVar.setScaleType(ImageView.ScaleType.FIT_XY);
            tVVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.IlO());
            tVVar.setImageDrawable(com.bytedance.sdk.component.utils.pP.EO(context, "tt_white_lefterbackicon_titlebar"));
            frameLayout.addView(tVVar, layoutParams2);
        } else {
            tVVar = null;
        }
        com.bytedance.sdk.openadsdk.utils.oeT.IlO(this.EV, this.lEW);
        final WebView webView = this.EV.getWebView();
        viewMY.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTCeilingLandingPageActivity.this.finish();
            }
        });
        EV ev = new EV(this.MY, webView, true);
        this.DmF = ev;
        ev.IlO("landingpage_split_ceiling");
        final vCE.IlO ilO = this.DmF.IlO;
        if (tVVar != null) {
            tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i2 = iBc;
                    if (i2 == 1) {
                        TTCeilingLandingPageActivity.this.finish();
                    } else if (i2 != 2) {
                        return;
                    }
                    WebView webView2 = webView;
                    if (webView2 == null || !webView2.canGoBack()) {
                        TTCeilingLandingPageActivity.this.finish();
                        return;
                    }
                    webView.goBack();
                    vCE.IlO ilO2 = ilO;
                    if (ilO2 != null) {
                        ilO2.IlO();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.common.tV tVVarIlO = zLG.IlO(this.MY, this.EV, this, "landingpage_split_ceiling");
        this.NV = tVVarIlO;
        if (tVVarIlO != null) {
            tVVarIlO.IlO("landingpage_split_ceiling");
            this.NV.IlO();
        }
        zLG.IlO(this.MY, this.EV, true);
        this.IlO = new IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.3
            @Override // com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.IlO
            public void IlO() {
                if (TTCeilingLandingPageActivity.this.MY.zPa().lEW() == cl.MY) {
                    TTCeilingLandingPageActivity.this.finish();
                }
            }
        };
        com.bytedance.sdk.openadsdk.core.widget.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this, this.EO, this.tV, this.NV, this.DmF, true, true, this.IlO) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }
        };
        cc.IlO(this.MY);
        com.bytedance.sdk.openadsdk.core.widget.IlO.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.EO, this.DmF, this.NV) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                super.onProgressChanged(webView2, i2);
            }
        };
        com.bytedance.sdk.component.DmF.vCE vce = this.EV;
        if (vce != null) {
            vce.setWebViewClient(cc);
            this.EV.setWebChromeClient(tVVar2);
        }
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTCeilingLandingPageActivity.this.DmF == null) {
                        return false;
                    }
                    TTCeilingLandingPageActivity.this.DmF.IlO(motionEvent);
                    return false;
                }
            });
            webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.7
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i2, int i8, int i9, int i10) {
                    if (TTCeilingLandingPageActivity.this.DmF != null) {
                        TTCeilingLandingPageActivity.this.DmF.MY(i8);
                    }
                }
            });
        }
    }

    private void IlO() {
        vSq vsq = new vSq(this);
        this.EO = vsq;
        vsq.MY(this.EV).EO(this.tV).tV(this.Cc).IlO(this.MY).MY(this.vCE).IlO(this.MY.quf()).Cc(this.MY.tcT()).IlO(this.EV).MY("landingpage_split_ceiling");
    }
}
