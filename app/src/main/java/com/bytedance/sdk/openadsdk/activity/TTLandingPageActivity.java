package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.bWL;
import com.bytedance.sdk.openadsdk.common.ea;
import com.bytedance.sdk.openadsdk.common.rp;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.core.pP;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.tV.NV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DmF;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.xF;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTLandingPageActivity extends TTBaseLandingPageActivity {
    private String AXM;
    private TextView DmF;
    TTAdDislikeToast EO;
    private bWL EV;
    EV IlO;
    ea MY;
    private Context NV;
    private int OOq;
    private com.bytedance.sdk.openadsdk.common.tV YA;
    private String bWL;
    private String cL;
    private int cl;
    private boolean dY;
    private String ea;
    private oeT es;
    private com.bytedance.sdk.openadsdk.core.Cc.vCE hp;
    private ILoader kBB;
    private ImageView lEW;
    private com.bytedance.sdk.openadsdk.utils.bWL lMM;
    private com.bytedance.sdk.openadsdk.core.widget.IlO.Cc mmj;
    private vCE.IlO nvX;
    private Button rp;
    private String vAh;
    private com.bytedance.sdk.component.DmF.vCE vCE;
    private rp vSq;
    private int wPn;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE xF;
    private vSq zPa;
    private final AtomicBoolean oeT = new AtomicBoolean(true);
    private final AtomicInteger pP = new AtomicInteger(0);
    private final AtomicInteger tl = new AtomicInteger(0);
    private final AtomicInteger oc = new AtomicInteger(0);
    final AtomicBoolean tV = new AtomicBoolean(false);
    final AtomicBoolean Cc = new AtomicBoolean(false);
    private String DM = "ダウンロード";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements View.OnTouchListener {
        private final WeakReference<EV> IlO;
        private final WeakReference<com.bytedance.sdk.openadsdk.common.tV> MY;

        public EO(EV ev, com.bytedance.sdk.openadsdk.common.tV tVVar) {
            this.IlO = new WeakReference<>(ev);
            this.MY = new WeakReference<>(tVVar);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EV ev = this.IlO.get();
            if (ev != null) {
                ev.IlO(motionEvent);
            }
            com.bytedance.sdk.openadsdk.common.tV tVVar = this.MY.get();
            if (tVVar == null) {
                return false;
            }
            tVVar.IlO(motionEvent);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements NV {
        private final String EO;
        private final int IlO;
        private final oeT MY;
        private final WeakReference<TTLandingPageActivity> tV;

        public IlO(int i2, oeT oet, String str, TTLandingPageActivity tTLandingPageActivity) {
            this.IlO = i2;
            this.MY = oet;
            this.EO = str;
            this.tV = new WeakReference<>(tTLandingPageActivity);
        }

        @Override // com.bytedance.sdk.openadsdk.tV.NV
        public void IlO(int i2) {
            TTLandingPageActivity tTLandingPageActivity = this.tV.get();
            if (tTLandingPageActivity != null) {
                EO.IlO.IlO(this.IlO, tTLandingPageActivity.tl.get(), tTLandingPageActivity.oc.get(), tTLandingPageActivity.pP.get() - tTLandingPageActivity.oc.get(), this.MY, this.EO, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements View.OnScrollChangeListener {
        private final WeakReference<EV> IlO;

        public MY(EV ev) {
            this.IlO = new WeakReference<>(ev);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i2, int i8, int i9, int i10) {
            EV ev = this.IlO.get();
            if (ev != null) {
                ev.MY(i8);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (Bc() && !this.oeT.getAndSet(true)) {
            lEW();
            MY(0);
        } else {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("TTAD.LandingPageAct", "onBackPressed: ", th.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable unused) {
        }
        EO();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IlO(3);
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.bWL.Cc()) {
            finish();
            return;
        }
        try {
            cl.MY(this);
        } catch (Throwable unused) {
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            setContentView(MY());
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("sdk_version", 1);
            this.bWL = intent.getStringExtra("adid");
            this.ea = intent.getStringExtra("log_extra");
            this.cl = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.AXM = stringExtra;
            MY(4);
            String stringExtra2 = intent.getStringExtra("web_title");
            this.cL = intent.getStringExtra("event_tag");
            this.vAh = intent.getStringExtra("gecko_id");
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.es = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(stringExtra3));
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
            } else {
                this.es = pP.IlO().MY();
                pP.IlO().vCE();
            }
            if (this.es == null) {
                finish();
                return;
            }
            Cc();
            if (!TextUtils.isEmpty(this.vAh)) {
                this.kBB = com.bytedance.sdk.openadsdk.Bc.MY.IlO().MY();
                int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.kBB, this.vAh);
                this.OOq = iIlO;
                this.wPn = iIlO > 0 ? 2 : 0;
            }
            this.NV = this;
            if (this.vCE != null) {
                com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this).IlO(false).MY(false).IlO(this.vCE.getWebView());
            }
            com.bytedance.sdk.component.DmF.vCE vce = this.vCE;
            if (vce != null && vce.getWebView() != null) {
                EV evMY = new EV(this.es, this.vCE.getWebView(), new IlO(this.OOq, this.es, "landingpage", this), this.wPn).MY(true);
                this.IlO = evMY;
                this.nvX = evMY.IlO;
                this.YA = zLG.IlO(this.es, this.vCE, this.NV, this.cL);
            }
            vCE();
            com.bytedance.sdk.component.DmF.vCE vce2 = this.vCE;
            if (vce2 != null) {
                vce2.setLandingPage(true);
                this.vCE.setTag("landingpage");
                this.vCE.setMaterialMeta(this.es.Ct());
            }
            com.bytedance.sdk.openadsdk.core.widget.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this.NV, this.zPa, this.bWL, this.YA, this.IlO, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTLandingPageActivity.this.hp != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.hp.setVisibility(8);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (TTLandingPageActivity.this.vSq != null) {
                        TTLandingPageActivity.this.vSq.MY();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(TTLandingPageActivity.this.vAh)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTLandingPageActivity.this.pP.incrementAndGet();
                        WebResourceResponseModel webResourceResponseModelIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(TTLandingPageActivity.this.kBB, TTLandingPageActivity.this.vAh, str);
                        if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getWebResourceResponse() != null) {
                            TTLandingPageActivity.this.oc.incrementAndGet();
                            return webResourceResponseModelIlO.getWebResourceResponse();
                        }
                        if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                            TTLandingPageActivity.this.tl.incrementAndGet();
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.LandingPageAct", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            this.mmj = cc;
            cc.IlO(this.es);
            this.mmj.IlO("landingpage");
            com.bytedance.sdk.component.DmF.vCE vce3 = this.vCE;
            if (vce3 != null) {
                vce3.setWebViewClient(this.mmj);
                com.bytedance.sdk.component.DmF.vCE vce4 = this.vCE;
                if (vce4 != null) {
                    vce4.setUserAgentString(xF.IlO(vce4.getWebView(), intExtra));
                }
                com.bytedance.sdk.component.DmF.vCE vce5 = this.vCE;
                if (vce5 != null) {
                    vce5.setMixedContentMode(0);
                }
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.es, "landingpage", this.wPn);
            com.bytedance.sdk.component.DmF.vCE vce6 = this.vCE;
            if (vce6 != null) {
                com.bytedance.sdk.openadsdk.utils.oeT.IlO(vce6, stringExtra);
                this.vCE.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.zPa, this.IlO, this.YA) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i2) {
                        super.onProgressChanged(webView, i2);
                        if (TTLandingPageActivity.this.vSq != null) {
                            TTLandingPageActivity.this.vSq.IlO(i2);
                        }
                        if (TTLandingPageActivity.this.hp == null || TTLandingPageActivity.this.isFinishing()) {
                            return;
                        }
                        if (i2 == 100 && TTLandingPageActivity.this.hp.isShown()) {
                            TTLandingPageActivity.this.hp.setVisibility(8);
                        } else {
                            TTLandingPageActivity.this.hp.setProgress(i2);
                        }
                    }
                });
                if (this.vCE.getWebView() != null) {
                    this.vCE.getWebView().setOnScrollChangeListener(new MY(this.IlO));
                    this.vCE.getWebView().setOnTouchListener(new EO(this.IlO, this.YA));
                }
                this.vCE.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                    @Override // android.webkit.DownloadListener
                    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                        if (TTLandingPageActivity.this.xF != null) {
                            TTLandingPageActivity.this.xF.tV();
                        }
                    }
                });
            }
            TextView textView = this.DmF;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            EO();
            com.bytedance.sdk.openadsdk.utils.bWL bwlIlO = DmF.IlO(this, new DmF.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
                public View IlO() {
                    return TTLandingPageActivity.this.lEW;
                }

                @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
                public void MY() {
                }
            });
            this.lMM = bwlIlO;
            bwlIlO.IlO(0L);
            EO.IlO.IlO(SystemClock.elapsedRealtime() - jElapsedRealtime, this.es, "landingpage", this.kBB, this.vAh);
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        com.bytedance.sdk.component.DmF.vCE vce;
        super.onDestroy();
        EV ev = this.IlO;
        if (ev != null && (vce = this.vCE) != null) {
            ev.IlO(vce);
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = this.vCE;
        if (vce2 != null) {
            nvX.IlO(vce2.getWebView());
        }
        this.vCE = null;
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.rp();
        }
        EV ev2 = this.IlO;
        if (ev2 != null) {
            ev2.tV(true);
        }
        if (!TextUtils.isEmpty(this.vAh)) {
            EO.IlO.IlO(this.oc.get(), this.pP.get(), this.es);
        }
        com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.kBB);
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.lMM;
        if (bwl != null) {
            bwl.EO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.lMM;
        if (bwl != null) {
            bwl.MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.EV();
        }
        EV ev = this.IlO;
        if (ev != null) {
            ev.Bc();
        }
        if (!this.dY) {
            this.dY = true;
            IlO(4);
        }
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.lMM;
        if (bwl != null) {
            bwl.IlO();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(this, this.es);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        EV ev = this.IlO;
        if (ev != null) {
            ev.lEW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bc() {
        return !TextUtils.isEmpty(this.AXM) && this.AXM.contains("__luban_sdk");
    }

    private void Cc() {
        com.bytedance.sdk.component.DmF.vCE vce = (com.bytedance.sdk.component.DmF.vCE) findViewById(zPa.quf);
        this.vCE = vce;
        zLG.IlO(this.es, vce);
        this.EV = (bWL) findViewById(zPa.wD);
        bWL bwl = (bWL) findViewById(zPa.ii);
        rp rpVar = (rp) findViewById(520093721);
        this.vSq = rpVar;
        if (rpVar != null) {
            rpVar.IlO(this.es);
            this.vSq.IlO();
        }
        if (bwl != null) {
            bwl.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.vCE != null) {
                        if (TTLandingPageActivity.this.nvX != null) {
                            TTLandingPageActivity.this.nvX.IlO();
                        }
                        if (TTLandingPageActivity.this.vCE.DmF()) {
                            TTLandingPageActivity.this.vCE.NV();
                        } else if (TTLandingPageActivity.this.Bc()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.lEW = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.DmF = (TextView) findViewById(zPa.KT);
        com.bytedance.sdk.openadsdk.core.Cc.vCE vce2 = (com.bytedance.sdk.openadsdk.core.Cc.vCE) findViewById(zPa.pFe);
        this.hp = vce2;
        if (vce2 != null) {
            vce2.setVisibility(0);
        }
        View viewFindViewById = findViewById(zPa.zTS);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.IlO();
                }
            });
        }
    }

    private void DmF() {
        try {
            if (this.MY == null) {
                ea eaVar = new ea(this.NV, this.es);
                this.MY = eaVar;
                eaVar.setDislikeSource("landing_page");
                this.MY.setCallback(new ea.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(View view) {
                        TTLandingPageActivity.this.tV.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void MY(View view) {
                        TTLandingPageActivity.this.tV.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(FilterWord filterWord) {
                        if (TTLandingPageActivity.this.Cc.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTLandingPageActivity.this.Cc.set(true);
                        TTLandingPageActivity.this.EV();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.MY);
            if (this.EO == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.NV);
                this.EO = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "LandingPageActivity", th);
        }
    }

    private void EO() {
        oeT oet = this.es;
        if (oet == null || oet.Jz() != 4) {
            return;
        }
        bWL bwl = this.EV;
        if (bwl != null) {
            bwl.setVisibility(0);
        }
        Button button = (Button) findViewById(zPa.VH);
        this.rp = button;
        if (button != null) {
            IlO(tV());
            if (this.xF == null) {
                this.xF = Bc.IlO(this, this.es, TextUtils.isEmpty(this.cL) ? zLG.MY(this.cl) : this.cL);
            }
            com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(this, this.es, this.cL, this.cl);
            ilO.IlO(false);
            this.rp.setOnClickListener(ilO);
            this.rp.setOnTouchListener(ilO);
            ilO.EO(true);
            ilO.IlO(this.xF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.EO) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    private void IlO(int i2) {
        int i8;
        if (i2 == 1 || (i8 = Build.VERSION.SDK_INT) == 26) {
            return;
        }
        if (i8 != 27) {
            setRequestedOrientation(i2);
        } else {
            try {
                setRequestedOrientation(i2);
            } catch (Throwable unused) {
            }
        }
    }

    private View MY() {
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        if (Build.VERSION.SDK_INT >= 35) {
            eo.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this);
        cc.setOrientation(1);
        eo.addView(cc, new FrameLayout.LayoutParams(-1, -1));
        View bwl = new bWL(this, new bWL.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.common.bWL.IlO
            public View IlO(Context context) {
                return new com.bytedance.sdk.openadsdk.common.NV(context);
            }
        });
        bwl.setId(zPa.ii);
        cc.addView(bwl, new LinearLayout.LayoutParams(-1, BS.MY(this, 44.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        cc.addView(eo2, layoutParams);
        com.bytedance.sdk.component.DmF.vCE vce = new com.bytedance.sdk.component.DmF.vCE(this);
        vce.setId(zPa.quf);
        eo2.addView(vce, new FrameLayout.LayoutParams(-1, -1));
        bWL bwl2 = new bWL(this, new bWL.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.common.bWL.IlO
            public View IlO(Context context) {
                return new com.bytedance.sdk.openadsdk.common.Bc(context);
            }
        });
        bwl2.setId(zPa.wD);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        eo2.addView(bwl2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.vCE vce2 = new com.bytedance.sdk.openadsdk.core.Cc.vCE(this, null, R.style.Widget.ProgressBar.Horizontal);
        vce2.setId(zPa.pFe);
        vce2.setProgress(1);
        vce2.setVisibility(8);
        vce2.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, BS.MY(this, 3.0f));
        layoutParams3.gravity = 49;
        eo2.addView(vce2, layoutParams3);
        View rpVar = new rp(this);
        rpVar.setId(520093721);
        eo.addView(rpVar, new FrameLayout.LayoutParams(-1, -1));
        return eo;
    }

    private void NV() {
        TTAdDislikeToast tTAdDislikeToast = this.EO;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    private void lEW() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.zPa.IlO("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    private String tV() {
        oeT oet = this.es;
        if (oet != null && !TextUtils.isEmpty(oet.aa())) {
            this.DM = this.es.aa();
        }
        return this.DM;
    }

    private void vCE() {
        vSq vsq = new vSq(this);
        this.zPa = vsq;
        vsq.MY(this.vCE).EO(this.bWL).tV(this.ea).IlO(this.es).MY(this.cl).IlO(this.es.quf()).Cc(this.es.tcT()).IlO(this.vCE).MY("landingpage");
    }

    private void IlO(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.rp) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.rp == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.rp.setText(str);
            }
        });
    }

    public void IlO() {
        if (isFinishing()) {
            return;
        }
        if (this.Cc.get()) {
            NV();
            return;
        }
        if (this.MY == null) {
            DmF();
        }
        ea eaVar = this.MY;
        if (eaVar != null) {
            eaVar.IlO();
        }
    }

    private void MY(final int i2) {
        if (this.lEW == null || !Bc()) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                BS.IlO((View) TTLandingPageActivity.this.lEW, i2);
            }
        });
    }
}
