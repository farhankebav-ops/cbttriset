package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.adexpress.tV.DmF;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.core.tl;
import com.bytedance.sdk.openadsdk.core.widget.DmF;
import com.bytedance.sdk.openadsdk.core.widget.NV;
import com.bytedance.sdk.openadsdk.core.widget.bWL;
import com.bytedance.sdk.openadsdk.core.widget.hp;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.xF;
import com.bytedance.sdk.openadsdk.xF.Bc;
import com.bytedance.sdk.openadsdk.xF.lEW;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTPlayableLandingPageActivity extends TTBaseLandingPageActivity implements vSq.IlO, com.bytedance.sdk.openadsdk.core.MY.tV {
    private static final Bc.IlO quf = new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
    };
    private EV AK;
    private com.bytedance.sdk.openadsdk.core.vSq AXM;
    private lEW BS;
    private com.bytedance.sdk.component.DmF.vCE Cc;
    private int DM;
    private bWL EV;
    private com.bytedance.sdk.openadsdk.xF.IlO.IlO Ea;
    private com.bytedance.sdk.openadsdk.tV.tV.Cc HSR;
    tl IlO;
    private boolean KC;
    TTAdDislikeToast MY;
    private RelativeLayout NV;
    private int bWL;
    private String cL;
    private DmF cl;
    private com.bytedance.sdk.openadsdk.core.Cc.vCE ea;
    private String es;
    private Context hp;
    private String kBB;
    private String lMM;
    private boolean oc;
    private int oeT;
    private hp rp;
    private ILoader ssS;
    private oeT tl;
    private String vAh;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vSq;
    private boolean wPn;
    private com.bytedance.sdk.openadsdk.core.vSq xF;
    private int zLG;
    private NV zPa;
    private boolean vCE = true;
    private boolean lEW = false;
    private boolean DmF = true;
    final AtomicBoolean EO = new AtomicBoolean(false);
    private final String pP = "embeded_ad";
    private final vSq OOq = new vSq(Looper.getMainLooper(), this);
    private final AtomicBoolean dY = new AtomicBoolean(false);
    private final AtomicInteger nvX = new AtomicInteger(0);
    private final AtomicInteger YA = new AtomicInteger(0);
    private final AtomicInteger mmj = new AtomicInteger(0);
    private boolean gQ = false;
    protected com.bytedance.sdk.openadsdk.rp.Cc tV = new com.bytedance.sdk.openadsdk.rp.Cc() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.8
        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void IlO() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && OOq.bWL(TTPlayableLandingPageActivity.this.tl) && OOq.zPa(TTPlayableLandingPageActivity.this.tl)) {
                TTPlayableLandingPageActivity.this.OOq.removeMessages(2);
                TTPlayableLandingPageActivity.this.OOq.sendMessage(TTPlayableLandingPageActivity.this.IlO(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void MY() {
            if (OOq.bWL(TTPlayableLandingPageActivity.this.tl) && OOq.ea(TTPlayableLandingPageActivity.this.tl)) {
                TTPlayableLandingPageActivity.this.OOq.sendMessageDelayed(TTPlayableLandingPageActivity.this.IlO(0, 0), 1000L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void IlO(int i2) {
            if (!OOq.bWL(TTPlayableLandingPageActivity.this.tl) || TTPlayableLandingPageActivity.this.zPa == null) {
                return;
            }
            TTPlayableLandingPageActivity.this.zPa.setProgress(i2);
        }
    };
    private int uvo = 1;

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.HSR;
        if (cc != null) {
            cc.lEW();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO;
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.bWL.Cc()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            cl.MY(this);
        } catch (Throwable unused) {
        }
        IlO(bundle);
        oeT oet = this.tl;
        if (oet == null) {
            return;
        }
        this.KC = oet.nt();
        int iCl = OOq.cl(this.tl);
        if (iCl == 0) {
            setRequestedOrientation(14);
        } else if (iCl == 1) {
            setRequestedOrientation(1);
        } else if (iCl == 2) {
            setRequestedOrientation(0);
            this.uvo = 2;
        }
        this.hp = this;
        try {
            setContentView(tV());
            DmF();
            vCE();
            if (this.KC) {
                bWL();
                this.Ea.IlO(false, (com.bytedance.sdk.openadsdk.rp.vCE) null);
            } else {
                IlO();
                EV();
                if (!TextUtils.isEmpty(this.lMM)) {
                    this.ssS = com.bytedance.sdk.openadsdk.Bc.MY.IlO().MY();
                    int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.ssS, this.lMM);
                    this.DM = iIlO;
                    this.zLG = iIlO > 0 ? 2 : 0;
                }
                lEW();
                com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.HSR;
                if (cc != null) {
                    cc.Bc();
                }
            }
            Bc();
            EO.IlO.IlO(SystemClock.elapsedRealtime() - jElapsedRealtime, this.tl, "embeded_ad", this.ssS, this.lMM);
            if (!this.KC || (ilO = this.Ea) == null) {
                return;
            }
            ilO.IlO();
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.Ea;
        if (ilO != null) {
            ilO.tV();
        }
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.HSR;
        if (cc != null) {
            cc.IlO(true);
            this.HSR.rp();
        }
        this.OOq.removeCallbacksAndMessages(null);
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.lMM)) {
            EO.IlO.IlO(this.YA.get(), this.nvX.get(), this.tl);
        }
        com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.ssS);
        com.bytedance.sdk.component.DmF.vCE vce = this.Cc;
        if (vce != null) {
            nvX.IlO(vce.getWebView());
            this.Cc.zPa();
        }
        this.Cc = null;
        com.bytedance.sdk.openadsdk.core.vSq vsq = this.xF;
        if (vsq != null) {
            vsq.rp();
        }
        com.bytedance.sdk.openadsdk.core.vSq vsq2 = this.AXM;
        if (vsq2 != null) {
            vsq2.rp();
        }
        lEW lew = this.BS;
        if (lew != null) {
            lew.YA();
        }
        EV ev = this.AK;
        if (ev != null) {
            ev.tV(true);
        }
        tl tlVar = this.IlO;
        if (tlVar != null) {
            tlVar.MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.vSq vsq = this.xF;
        if (vsq != null) {
            vsq.MY(false);
        }
        lEW lew = this.BS;
        if (lew != null) {
            lew.IlO(true);
            this.BS.EO(false);
        }
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.Ea;
        if (ilO != null) {
            ilO.EO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.bytedance.sdk.openadsdk.core.vSq vsq = this.xF;
        if (vsq != null) {
            vsq.EV();
            com.bytedance.sdk.component.DmF.vCE vce = this.Cc;
            if (vce != null) {
                this.xF.MY(vce.getVisibility() == 0);
            }
        }
        com.bytedance.sdk.openadsdk.core.vSq vsq2 = this.AXM;
        if (vsq2 != null) {
            vsq2.EV();
        }
        lEW lew = this.BS;
        if (lew != null) {
            lew.EO(true);
        }
        EV ev = this.AK;
        if (ev != null) {
            ev.Bc();
        }
        if (DeviceUtils.Bc() == 0) {
            this.gQ = true;
        }
        EO(this.gQ);
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.Ea;
        if (ilO != null) {
            ilO.MY();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            oeT oet = this.tl;
            bundle.putString("material_meta", oet != null ? oet.eDn().toString() : null);
            bundle.putInt("sdk_version", this.bWL);
            bundle.putString("adid", this.cL);
            bundle.putString("log_extra", this.es);
            bundle.putInt("source", this.oeT);
            bundle.putBoolean("ad_pending_download", this.wPn);
            bundle.putString("url", this.vAh);
            bundle.putString("web_title", this.kBB);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.HSR;
        if (cc != null) {
            cc.NV();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.HSR;
        if (cc != null) {
            cc.DmF();
        }
        EV ev = this.AK;
        if (ev != null) {
            ev.lEW();
        }
    }

    private void Bc() {
        int i2 = cl.tV().tl(String.valueOf(this.tl.hFV())).cl;
        if (i2 >= 0) {
            this.OOq.sendEmptyMessageDelayed(1, ((long) i2) * 1000);
        } else {
            BS.IlO((View) this.NV, 0);
        }
    }

    private void DmF() {
        RelativeLayout relativeLayout = this.NV;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTPlayableLandingPageActivity.this.HSR != null) {
                        TTPlayableLandingPageActivity.this.HSR.lEW();
                    }
                    TTPlayableLandingPageActivity.this.OOq.sendMessage(TTPlayableLandingPageActivity.this.IlO(4, 0));
                    TTPlayableLandingPageActivity.this.IlO("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        bWL bwl = this.EV;
        if (bwl != null) {
            bwl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.MY();
                }
            });
        }
        hp hpVar = this.rp;
        if (hpVar != null) {
            hpVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.gQ = !r2.gQ;
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity.EO(tTPlayableLandingPageActivity.gQ);
                    if (TTPlayableLandingPageActivity.this.BS != null) {
                        TTPlayableLandingPageActivity.this.BS.IlO(TTPlayableLandingPageActivity.this.gQ);
                    }
                }
            });
        }
        if (this.KC) {
            return;
        }
        this.Cc.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        BS.IlO((View) this.Cc, 4);
        this.zPa.MY(this.tl, this.uvo);
    }

    private void EV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.tl);
        this.HSR = new com.bytedance.sdk.openadsdk.tV.cl(3, "embeded_ad", this.tl);
        this.xF = new com.bytedance.sdk.openadsdk.core.vSq(this);
        this.xF.MY(this.Cc).IlO(this.tl).IlO(arrayList).EO(this.cL).tV(this.es).MY("embeded_ad").MY(this.oeT).IlO(this).IlO(this.HSR).IlO(this.tV).IlO(this.Cc).Cc(this.tl.tcT());
        Cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NV() {
        if (this.dY.getAndSet(true)) {
            return;
        }
        if (!OOq.vAh(this.tl) || (this.lEW && this.vCE)) {
            com.bytedance.sdk.component.DmF.vCE vce = this.Cc;
            if (vce == null || this.zPa == null) {
                return;
            }
            BS.IlO((View) vce, 0);
            BS.IlO((View) this.zPa, 8);
            return;
        }
        if (this.cl == null || this.zPa == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(this, this.tl, "embeded_ad", this.oeT);
        ilO.IlO(this.vSq);
        this.cl.IlO(this.tl, "embeded_ad", ilO);
        BS.IlO((View) this.cl, 0);
        BS.IlO((View) this.zPa, 8);
        BS.IlO((View) this.rp, 8);
    }

    private void bWL() {
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(this, this.tl, "embeded_ad", this.oeT) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                oeT oet = ((com.bytedance.sdk.openadsdk.core.MY.MY) this).vCE;
                if (oet == null || oet.tl() != 1 || z2) {
                    super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
                    TTPlayableLandingPageActivity.this.wPn = true;
                    TTPlayableLandingPageActivity.this.oc = true;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.vAh);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTPWPActivity", "onClick JSON ERROR", e);
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(TTPlayableLandingPageActivity.this.tl, ((com.bytedance.sdk.openadsdk.core.MY.MY) this).Bc, "click_playable_download_button_loading", jSONObject);
                }
            }
        };
        ilO.IlO(this.vSq);
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO2 = this.Ea;
        if (ilO2 != null) {
            ilO2.IlO(ilO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp() {
        TTAdDislikeToast tTAdDislikeToast = this.MY;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    private void lEW() {
        com.bytedance.sdk.component.DmF.vCE vce = this.Cc;
        if (vce == null) {
            return;
        }
        vce.setLandingPage(true);
        this.Cc.setTag("landingpage");
        this.Cc.setMaterialMeta(this.tl.Ct());
        EV evMY = new EV(this.tl, this.Cc.getWebView(), new com.bytedance.sdk.openadsdk.tV.NV() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.12
            @Override // com.bytedance.sdk.openadsdk.tV.NV
            public void IlO(int i2) {
                EO.IlO.IlO(TTPlayableLandingPageActivity.this.DM, TTPlayableLandingPageActivity.this.mmj.get(), TTPlayableLandingPageActivity.this.YA.get(), TTPlayableLandingPageActivity.this.nvX.get() - TTPlayableLandingPageActivity.this.YA.get(), TTPlayableLandingPageActivity.this.tl, "embeded_ad", i2);
            }
        }, this.zLG).MY(true);
        this.AK = evMY;
        evMY.IlO("embeded_ad");
        this.AK.IlO(this.HSR);
        this.AK.IlO(this.BS);
        this.Cc.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this.hp, this.xF, this.cL, this.AK, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                TTPlayableLandingPageActivity.this.lEW = true;
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (TTPlayableLandingPageActivity.this.BS != null) {
                    TTPlayableLandingPageActivity.this.BS.DmF(str);
                }
                try {
                    TTPlayableLandingPageActivity.this.tV.MY();
                } catch (Throwable unused) {
                }
                try {
                    if (TTPlayableLandingPageActivity.this.ea != null) {
                        TTPlayableLandingPageActivity.this.ea.setVisibility(8);
                    }
                    if (TTPlayableLandingPageActivity.this.vCE) {
                        TTPlayableLandingPageActivity.this.NV();
                        TTPlayableLandingPageActivity.this.IlO("py_loading_success");
                        com.bytedance.sdk.openadsdk.core.vSq vsq = this.EO;
                        if (vsq != null) {
                            vsq.MY(true);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.vCE = false;
                if (TTPlayableLandingPageActivity.this.BS == null || webResourceError == null || webResourceRequest == null) {
                    return;
                }
                TTPlayableLandingPageActivity.this.BS.IlO(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTPlayableLandingPageActivity.this.vAh != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.vAh.equals(webResourceRequest.getUrl().toString())) {
                    TTPlayableLandingPageActivity.this.vCE = false;
                }
                if (TTPlayableLandingPageActivity.this.BS != null && webResourceRequest != null) {
                    try {
                        TTPlayableLandingPageActivity.this.BS.IlO(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                String str2;
                long jCurrentTimeMillis;
                WebResourceResponseModel webResourceResponseModelIlO;
                long jCurrentTimeMillis2;
                String str3;
                try {
                    if (TTPlayableLandingPageActivity.this.BS != null) {
                        TTPlayableLandingPageActivity.this.BS.NV(str);
                    }
                    if (!TextUtils.isEmpty(TTPlayableLandingPageActivity.this.lMM)) {
                        TTPlayableLandingPageActivity.this.nvX.incrementAndGet();
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.Bc.MY myIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO();
                    ILoader iLoader = TTPlayableLandingPageActivity.this.ssS;
                    str2 = TTPlayableLandingPageActivity.this.lMM;
                    webResourceResponseModelIlO = myIlO.IlO(iLoader, str2, str);
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                } catch (Exception unused) {
                    str2 = str;
                }
                try {
                    if (TTPlayableLandingPageActivity.this.HSR != null) {
                        DmF.IlO IlO = com.bytedance.sdk.component.adexpress.tV.DmF.IlO(str);
                        int i2 = (webResourceResponseModelIlO == null || webResourceResponseModelIlO.getWebResourceResponse() == null) ? 2 : 1;
                        if (IlO == DmF.IlO.HTML) {
                            str3 = str;
                            TTPlayableLandingPageActivity.this.HSR.IlO(str3, jCurrentTimeMillis, jCurrentTimeMillis2, i2);
                        } else {
                            str3 = str;
                            if (IlO == DmF.IlO.JS) {
                                TTPlayableLandingPageActivity.this.HSR.MY(str3, jCurrentTimeMillis, jCurrentTimeMillis2, i2);
                            }
                        }
                    } else {
                        str3 = str;
                    }
                    if (webResourceResponseModelIlO == null || webResourceResponseModelIlO.getWebResourceResponse() == null) {
                        if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                            TTPlayableLandingPageActivity.this.mmj.incrementAndGet();
                        }
                        return super.shouldInterceptRequest(webView, str3);
                    }
                    TTPlayableLandingPageActivity.this.YA.incrementAndGet();
                    if (TTPlayableLandingPageActivity.this.BS != null) {
                        TTPlayableLandingPageActivity.this.BS.EV(str3);
                    }
                    return webResourceResponseModelIlO.getWebResourceResponse();
                } catch (Exception unused2) {
                    return super.shouldInterceptRequest(webView, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
            }
        });
        IlO(this.Cc);
        com.bytedance.sdk.openadsdk.utils.oeT.IlO(this.Cc, this.vAh);
        lEW lew = this.BS;
        if (lew != null) {
            lew.lEW(this.vAh);
        }
        this.Cc.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.xF, this.AK) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TTPlayableLandingPageActivity.this.tV.IlO(i2);
                } catch (Throwable unused) {
                }
                if (TTPlayableLandingPageActivity.this.ea != null) {
                    if (i2 != 100) {
                        TTPlayableLandingPageActivity.this.ea.setProgress(i2);
                        return;
                    }
                    TTPlayableLandingPageActivity.this.lEW = true;
                    TTPlayableLandingPageActivity.this.ea.setVisibility(8);
                    TTPlayableLandingPageActivity.this.NV();
                }
            }
        });
        this.Cc.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTPlayableLandingPageActivity.this.AK == null) {
                    return false;
                }
                TTPlayableLandingPageActivity.this.AK.IlO(motionEvent);
                return false;
            }
        });
    }

    private void rp() {
        TTAdDislikeToast tTAdDislikeToast = this.MY;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
        }
    }

    private void vCE() {
        if (this.tl.Jz() == 4) {
            this.vSq = com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.hp, this.tl, "interaction");
        }
    }

    private void Cc() {
        if (this.BS != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.DmF.MY().es()) {
            Bc.IlO(quf);
        }
        com.bytedance.sdk.openadsdk.xF.IlO ilO = new com.bytedance.sdk.openadsdk.xF.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public void IlO(int i2, String str) {
                super.IlO(i2, str);
                if (OOq.vAh(TTPlayableLandingPageActivity.this.tl)) {
                    TTPlayableLandingPageActivity.this.OOq.sendMessage(TTPlayableLandingPageActivity.this.IlO(3, OOq.IlO(i2)));
                    TTPlayableLandingPageActivity.this.NV();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public com.bytedance.sdk.openadsdk.xF.tV IlO() {
                String strVCE = com.bytedance.sdk.openadsdk.common.MY.vCE();
                strVCE.getClass();
                switch (strVCE) {
                    case "2g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_2G;
                    case "3g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_3G;
                    case "4g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_4G;
                    case "5g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_5G;
                    case "wifi":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_WIFI;
                    default:
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_UNKNOWN;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public void IlO(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.tV.EO.MY(TTPlayableLandingPageActivity.this.tl, "embeded_ad", "playable_track", jSONObject);
            }
        };
        com.bytedance.sdk.openadsdk.xF.EO eo = new com.bytedance.sdk.openadsdk.xF.EO() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.xF.EO
            public void IlO(String str, JSONObject jSONObject) {
                TTPlayableLandingPageActivity.this.xF.IlO(str, jSONObject);
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.cL);
            jSONObject.put("log_extra", this.es);
            this.BS = lEW.IlO(getApplicationContext(), this.Cc.getWebView(), eo, ilO).Bc(this.vAh).Cc(com.bytedance.sdk.openadsdk.common.MY.IlO(cl.IlO())).IlO(com.bytedance.sdk.openadsdk.common.MY.IlO()).EO(jSONObject).MY(com.bytedance.sdk.openadsdk.common.MY.Cc()).IlO("sdkEdition", com.bytedance.sdk.openadsdk.common.MY.EO()).tV(com.bytedance.sdk.openadsdk.common.MY.tV()).tV(false).IlO(this.gQ).IlO(OOq.xF(this.tl)).MY(OOq.xF(this.tl)).Cc(true);
        } catch (Throwable unused) {
        }
        if (this.BS == null) {
            return;
        }
        if (!TextUtils.isEmpty(OOq.EV(this.tl))) {
            this.BS.EO(OOq.EV(this.tl));
        }
        Set<String> setEV = this.BS.EV();
        final WeakReference weakReference = new WeakReference(this.BS);
        for (String str : setEV) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.xF.MY().IlO(str, new com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.11
                    @Override // com.bytedance.sdk.component.IlO.Cc
                    public JSONObject IlO(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.IlO.vCE vce) {
                        try {
                            lEW lew = (lEW) weakReference.get();
                            if (lew == null) {
                                return null;
                            }
                            return lew.tV(IlO(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    private View tV() {
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        eo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.KC) {
            this.Ea = new com.bytedance.sdk.openadsdk.xF.IlO.IlO(this.hp, this.tl, this.uvo, this.gQ, eo, true);
        } else {
            this.Cc = new com.bytedance.sdk.component.DmF.vCE(this);
            this.Cc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Cc.setVisibility(4);
            this.ea = new com.bytedance.sdk.openadsdk.core.Cc.vCE(this, null, R.style.Widget.ProgressBar.Horizontal);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, BS.MY(this, 3.0f));
            layoutParams.gravity = 49;
            this.ea.setLayoutParams(layoutParams);
            this.ea.setProgress(1);
            this.ea.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_browser_progress_style"));
            this.zPa = new NV(this);
            this.zPa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.zPa.setClickable(true);
            this.zPa.setFocusable(true);
            this.cl = new com.bytedance.sdk.openadsdk.core.widget.DmF(this);
            this.cl.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.rp = new hp(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BS.MY(this, 28.0f), BS.MY(this, 28.0f));
        layoutParams2.leftMargin = BS.MY(this, 12.0f);
        layoutParams2.topMargin = BS.MY(this, 20.0f);
        this.rp.setLayoutParams(layoutParams2);
        this.rp.setScaleType(ImageView.ScaleType.CENTER);
        this.rp.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_unmute_wrapper"));
        this.EV = new bWL(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, BS.MY(this, 28.0f));
        layoutParams3.gravity = 8388661;
        layoutParams3.leftMargin = BS.MY(this, 16.0f);
        layoutParams3.rightMargin = BS.MY(this, 80.0f);
        layoutParams3.topMargin = BS.MY(this, 20.0f);
        this.EV.setLayoutParams(layoutParams3);
        this.EV.setGravity(17);
        this.EV.setText(pP.IlO(this, "tt_reward_feedback"));
        this.EV.setTextColor(-1);
        this.EV.setTextSize(14.0f);
        this.NV = new com.bytedance.sdk.openadsdk.core.Cc.Bc(this);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(BS.MY(this, 28.0f), BS.MY(this, 28.0f));
        layoutParams4.gravity = 8388661;
        layoutParams4.topMargin = BS.MY(this, 20.0f);
        layoutParams4.rightMargin = BS.MY(this, 24.0f);
        this.NV.setLayoutParams(layoutParams4);
        this.NV.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_mute_btn_bg"));
        this.NV.setGravity(17);
        this.NV.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(this);
        tVVar.setLayoutParams(new RelativeLayout.LayoutParams(BS.MY(this, 12.0f), BS.MY(this, 12.0f)));
        tVVar.setImageDrawable(pP.EO(this, "tt_video_close_drawable"));
        tVVar.setVisibility(0);
        this.NV.addView(tVVar);
        if (!this.KC) {
            eo.addView(this.Cc);
            eo.addView(this.ea);
            eo.addView(this.cl);
            eo.addView(this.zPa);
        }
        eo.addView(this.rp);
        eo.addView(this.EV);
        eo.addView(this.NV);
        return eo;
    }

    public void EO() {
        TTPlayableLandingPageActivity tTPlayableLandingPageActivity;
        oeT oet = this.tl;
        if (oet != null) {
            tTPlayableLandingPageActivity = this;
            tTPlayableLandingPageActivity.IlO = new com.bytedance.sdk.openadsdk.EO.EO(tTPlayableLandingPageActivity, oet.KT(), this.tl.cJK(), this.tl.eDn().toString(), "playable");
        } else {
            tTPlayableLandingPageActivity = this;
        }
        if (tTPlayableLandingPageActivity.MY == null) {
            tTPlayableLandingPageActivity.MY = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(tTPlayableLandingPageActivity.MY);
        }
    }

    public void MY() {
        if (this.tl == null || isFinishing()) {
            return;
        }
        if (this.EO.get()) {
            rp();
            return;
        }
        if (this.IlO == null) {
            EO();
        }
        this.IlO.IlO(new tl.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.tl.IlO
            public void IlO() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.tl.IlO
            public void IlO(int i2, String str) {
                if (TTPlayableLandingPageActivity.this.EO.get() || TextUtils.isEmpty(str)) {
                    return;
                }
                TTPlayableLandingPageActivity.this.EO.set(true);
                TTPlayableLandingPageActivity.this.hp();
            }
        });
        tl tlVar = this.IlO;
        if (tlVar != null) {
            tlVar.IlO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message IlO(int i2, int i8) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i2;
        if (i2 == 3) {
            messageObtain.arg2 = i8;
        }
        return messageObtain;
    }

    private void IlO(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bWL = intent.getIntExtra("sdk_version", 1);
            this.cL = intent.getStringExtra("adid");
            this.es = intent.getStringExtra("log_extra");
            this.oeT = intent.getIntExtra("source", -1);
            this.wPn = intent.getBooleanExtra("ad_pending_download", false);
            this.vAh = intent.getStringExtra("url");
            this.lMM = intent.getStringExtra("gecko_id");
            this.kBB = intent.getStringExtra("web_title");
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.tl = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
            } else {
                this.tl = com.bytedance.sdk.openadsdk.core.pP.IlO().MY();
                com.bytedance.sdk.openadsdk.core.pP.IlO().vCE();
            }
        }
        if (bundle != null) {
            try {
                this.bWL = bundle.getInt("sdk_version", 1);
                this.cL = bundle.getString("adid");
                this.es = bundle.getString("log_extra");
                this.oeT = bundle.getInt("source", -1);
                this.wPn = bundle.getBoolean("ad_pending_download", false);
                this.vAh = bundle.getString("url");
                this.kBB = bundle.getString("web_title");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.tl = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.tl == null) {
            finish();
            return;
        }
        try {
            this.gQ = cl.tV().zPa(this.tl.ssS().getCodeId());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTPWPActivity", th.getMessage());
        }
    }

    public void EO(boolean z2) {
        Drawable drawableIlO;
        try {
            this.gQ = z2;
            if (z2) {
                drawableIlO = com.bytedance.sdk.openadsdk.utils.EV.IlO(this.hp, "tt_mute_wrapper");
            } else {
                drawableIlO = com.bytedance.sdk.openadsdk.utils.EV.IlO(this.hp, "tt_unmute_wrapper");
            }
            this.rp.setImageDrawable(drawableIlO);
            lEW lew = this.BS;
            if (lew != null) {
                lew.IlO(z2);
            }
            com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.Ea;
            if (ilO != null) {
                ilO.IlO(z2);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTPWPActivity", e.getMessage());
        }
    }

    public void IlO() {
        TTPlayableLandingPageActivity tTPlayableLandingPageActivity;
        if (this.zPa == null) {
            return;
        }
        oeT oet = this.tl;
        if (oet != null && !OOq.bWL(oet)) {
            this.zPa.EO();
            return;
        }
        this.zPa.MY(this.tl, this.uvo);
        if (this.zPa.getDownloadButton() != null) {
            tTPlayableLandingPageActivity = this;
            com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(this, this.tl, "embeded_ad", this.oeT) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
                public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                    oeT oet2 = ((com.bytedance.sdk.openadsdk.core.MY.MY) this).vCE;
                    if (oet2 == null || oet2.tl() != 1 || z2) {
                        super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
                        TTPlayableLandingPageActivity.this.wPn = true;
                        TTPlayableLandingPageActivity.this.oc = true;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.vAh);
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.oeT.IlO("TTPWPActivity", "onClick JSON ERROR", e);
                        }
                        com.bytedance.sdk.openadsdk.tV.EO.MY(TTPlayableLandingPageActivity.this.tl, ((com.bytedance.sdk.openadsdk.core.MY.MY) this).Bc, "click_playable_download_button_loading", jSONObject);
                    }
                }
            };
            ilO.IlO(tTPlayableLandingPageActivity.vSq);
            tTPlayableLandingPageActivity.zPa.getDownloadButton().setOnClickListener(ilO);
        } else {
            tTPlayableLandingPageActivity = this;
        }
        if (OOq.zPa(tTPlayableLandingPageActivity.tl)) {
            tTPlayableLandingPageActivity.OOq.sendMessageDelayed(IlO(2, OOq.IlO(2)), OOq.AXM(tTPlayableLandingPageActivity.tl));
        }
    }

    private void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.hp).IlO(false).MY(false).IlO(vce.getWebView());
        vce.setUserAgentString(xF.IlO(vce.getWebView(), this.bWL));
        vce.setMixedContentMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.tl, "embeded_ad", str);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            BS.IlO((View) this.NV, 0);
            return;
        }
        if (i2 != 2) {
            return;
        }
        NV nv = this.zPa;
        if (nv == null || !nv.tV()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                int i8 = message.arg2;
                if (i8 != 0) {
                    jSONObject.put("remove_loading_page_reason", i8);
                }
                jSONObject.put("playable_url", this.vAh);
                NV nv2 = this.zPa;
                jSONObject.put("duration", nv2 != null ? nv2.getDisplayDuration() : 0L);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTPWPActivity", "handleMsg json error", e);
            }
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.tl, "embeded_ad", "remove_loading_page", jSONObject);
            this.OOq.removeMessages(2);
            NV nv3 = this.zPa;
            if (nv3 != null) {
                nv3.EO();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.tV
    public void IlO(boolean z2) {
        com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce;
        this.wPn = true;
        this.oc = z2;
        if (!z2) {
            try {
                Toast.makeText(this.hp, "Download later", 0).show();
            } catch (Throwable unused) {
            }
        }
        if (!this.oc || (vce = this.vSq) == null) {
            return;
        }
        vce.tV();
    }
}
