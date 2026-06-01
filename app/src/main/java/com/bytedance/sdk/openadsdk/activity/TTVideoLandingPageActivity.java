package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.bWL;
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
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import w.c;
import w.e;
import w.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseLandingPageActivity implements com.bytedance.sdk.openadsdk.NV.tV {
    protected vCE.IlO AK;
    protected EV BS;
    protected Context Cc;
    protected int DM;
    protected String DmF;
    protected ImageView EO;
    protected int EV;
    protected String HSR;
    protected com.bytedance.sdk.component.DmF.vCE IlO;
    protected ImageView MY;
    protected vSq NV;
    protected bWL OOq;
    protected com.bytedance.sdk.openadsdk.core.rp.MY.vCE bWL;
    protected String dY;
    protected long ea;
    private int fdM;
    private int hL;
    protected com.bytedance.sdk.openadsdk.core.widget.IlO kBB;
    protected String lEW;
    protected com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE oc;
    protected RelativeLayout oeT;
    protected TextView pP;
    protected FrameLayout rp;
    protected TextView tV;
    protected TextView tl;
    private ILoader uvo;
    protected TextView vAh;
    protected int vCE;
    protected Button wPn;
    protected com.bytedance.sdk.openadsdk.multipro.MY.IlO zLG;
    protected oeT zPa;
    protected int hp = -1;
    protected int cl = 0;
    protected int cL = 0;
    protected int es = 0;
    protected int xF = 0;
    protected String AXM = "ダウンロード";
    protected boolean vSq = false;
    protected boolean lMM = false;
    protected boolean nvX = true;
    protected boolean YA = false;
    protected String mmj = null;
    protected AtomicBoolean ssS = new AtomicBoolean(true);
    protected JSONArray gQ = null;
    private final AtomicInteger KC = new AtomicInteger(0);
    private final AtomicInteger Ea = new AtomicInteger(0);
    private final AtomicInteger Dxv = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.MY.IlO quf = null;
    private final c Jz = new c() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.11
        @Override // w.c
        public void IlO(boolean z2) {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity.vSq = z2;
            if (tTVideoLandingPageActivity.isFinishing()) {
                return;
            }
            if (!z2) {
                BS.IlO((View) TTVideoLandingPageActivity.this.IlO, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.rp.getLayoutParams();
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                marginLayoutParams.width = tTVideoLandingPageActivity2.es;
                marginLayoutParams.height = tTVideoLandingPageActivity2.xF;
                marginLayoutParams.leftMargin = tTVideoLandingPageActivity2.cL;
                marginLayoutParams.topMargin = tTVideoLandingPageActivity2.cl;
                tTVideoLandingPageActivity2.rp.setLayoutParams(marginLayoutParams);
                return;
            }
            BS.IlO((View) TTVideoLandingPageActivity.this.IlO, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.rp.getLayoutParams();
            TTVideoLandingPageActivity tTVideoLandingPageActivity3 = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity3.cL = marginLayoutParams2.leftMargin;
            tTVideoLandingPageActivity3.cl = marginLayoutParams2.topMargin;
            tTVideoLandingPageActivity3.es = marginLayoutParams2.width;
            tTVideoLandingPageActivity3.xF = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            tTVideoLandingPageActivity3.rp.setLayoutParams(marginLayoutParams2);
        }
    };
    private final wPn.IlO wD = new wPn.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
        @Override // com.bytedance.sdk.component.utils.wPn.IlO
        public void IlO(Context context, Intent intent, boolean z2, final int i2) {
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO(i2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void IlO(int i2) {
            com.bytedance.sdk.component.DmF.vCE vce;
            String str;
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            if (tTVideoLandingPageActivity.DM == 0 && i2 != 0 && (vce = tTVideoLandingPageActivity.IlO) != null && (str = tTVideoLandingPageActivity.mmj) != null) {
                vce.a_(str);
            }
            com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce2 = TTVideoLandingPageActivity.this.bWL;
            if (vce2 != null && vce2.getNativeVideoController() != null) {
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                if (!tTVideoLandingPageActivity2.lMM && tTVideoLandingPageActivity2.DM != i2) {
                    tTVideoLandingPageActivity2.bWL.getNativeVideoController().EO(i2);
                }
            }
            TTVideoLandingPageActivity.this.DM = i2;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends AsyncTask<Void, Void, Drawable> {
        private final Bitmap IlO;
        private final WeakReference<g> MY;

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap bitmapIlO = com.bytedance.sdk.component.adexpress.tV.IlO.IlO(cl.IlO(), this.IlO, 25);
                if (bitmapIlO == null) {
                    return null;
                }
                return new BitmapDrawable(cl.IlO().getResources(), bitmapIlO);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        private IlO(Bitmap bitmap, g gVar) {
            this.IlO = bitmap;
            this.MY = new WeakReference<>(gVar);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<g> weakReference;
            if (drawable == null || (weakReference = this.MY) == null || weakReference.get() == null) {
                return;
            }
            this.MY.get().IlO(drawable);
        }
    }

    private void bWL() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce == null || vce.getNativeVideoController() == null || zPa()) {
            return;
        }
        this.bWL.bWL();
    }

    private void cL() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.NV.IlO("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cl() {
        return !TextUtils.isEmpty(this.mmj) && this.mmj.contains("__luban_sdk");
    }

    private void ea() {
        if (this.bWL == null || zPa()) {
            return;
        }
        this.bWL.bWL();
    }

    private void hp() {
        vSq vsq = new vSq(this);
        this.NV = vsq;
        vsq.MY(this.IlO).EO(this.lEW).tV(this.DmF).MY(this.EV).IlO(this.zPa).IlO(this.zPa.quf()).IlO(this.IlO).MY("landingpage_split_screen").Cc(this.zPa.tcT());
    }

    private void rp() {
        oeT oet = this.zPa;
        if (oet == null || oet.Jz() != 4) {
            return;
        }
        this.OOq.setVisibility(0);
        Button button = (Button) findViewById(zPa.VH);
        this.wPn = button;
        if (button != null) {
            IlO(MY());
            this.wPn.setOnClickListener(this.quf);
            this.wPn.setOnTouchListener(this.quf);
        }
    }

    private boolean zPa() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce == null || vce.getNativeVideoController() == null) {
            return true;
        }
        return this.bWL.getNativeVideoController().rp();
    }

    public int Bc() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce == null || vce.getNativeVideoController() == null) {
            return 0;
        }
        return this.bWL.getNativeVideoController().DmF();
    }

    public abstract boolean Cc();

    public void DmF() {
        oeT oet = this.zPa;
        if (oet == null) {
            return;
        }
        this.oc = Bc.IlO(this, oet, this.dY);
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(this, this.zPa, this.dY, this.EV);
        this.quf = ilO;
        ilO.IlO(false);
        this.quf.EO(true);
        this.tl.setOnClickListener(this.quf);
        this.tl.setOnTouchListener(this.quf);
        this.quf.IlO(this.oc);
    }

    public void EV() {
        try {
            wPn.IlO(this.wD);
        } catch (Exception unused) {
        }
    }

    public abstract View IlO();

    public void NV() {
        wPn.IlO(this.wD, this.Cc);
    }

    public void lEW() {
        oeT oet = this.zPa;
        if (oet == null || oet.Jz() != 4) {
            return;
        }
        BS.IlO((View) this.oeT, 0);
        String strDm = !TextUtils.isEmpty(this.zPa.dm()) ? this.zPa.dm() : !TextUtils.isEmpty(this.zPa.gm()) ? this.zPa.gm() : !TextUtils.isEmpty(this.zPa.hL()) ? this.zPa.hL() : "";
        if (this.zPa.HTA() != null && this.zPa.HTA().IlO() != null) {
            BS.IlO((View) this.kBB, 0);
            BS.IlO((View) this.vAh, 4);
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.zPa.HTA(), this.kBB, this.zPa);
        } else if (!TextUtils.isEmpty(strDm)) {
            BS.IlO((View) this.kBB, 4);
            BS.IlO((View) this.vAh, 0);
            this.vAh.setText(strDm.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.zPa.aa())) {
            this.tl.setText(this.zPa.aa());
        }
        if (!TextUtils.isEmpty(strDm)) {
            this.pP.setText(strDm);
        }
        BS.IlO((View) this.pP, 0);
        BS.IlO((View) this.tl, 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce;
        if (this.vSq && (vce = this.bWL) != null && vce.getNativeVideoController() != null) {
            this.bWL.getNativeVideoController().Cc(null, null);
            this.vSq = false;
        } else if (!cl() || this.ssS.getAndSet(true)) {
            super.onBackPressed();
        } else {
            cL();
            IlO(0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        rp();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.bWL.Cc()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            cl.MY(this);
        } catch (Throwable unused2) {
        }
        this.DM = xF.EO(getApplicationContext());
        try {
            setContentView(IlO());
            this.Cc = this;
            Intent intent = getIntent();
            this.vCE = intent.getIntExtra("sdk_version", 1);
            this.lEW = intent.getStringExtra("adid");
            this.DmF = intent.getStringExtra("log_extra");
            this.EV = intent.getIntExtra("source", -1);
            this.mmj = intent.getStringExtra("url");
            String stringExtra = intent.getStringExtra("web_title");
            this.dY = intent.getStringExtra("event_tag");
            this.HSR = intent.getStringExtra("gecko_id");
            this.YA = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.ea = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.zPa = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(stringExtra3));
                    } catch (Exception unused3) {
                    }
                }
                oeT oet = this.zPa;
                if (oet != null) {
                    this.hp = oet.uI();
                }
            } else {
                oeT oetMY = pP.IlO().MY();
                this.zPa = oetMY;
                if (oetMY != null) {
                    this.hp = oetMY.uI();
                }
                pP.IlO().vCE();
            }
            if (this.zPa == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.HSR)) {
                this.uvo = com.bytedance.sdk.openadsdk.Bc.MY.IlO().MY();
                int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.uvo, this.HSR);
                this.fdM = iIlO;
                this.hL = iIlO > 0 ? 2 : 0;
            }
            if (stringExtra2 != null) {
                try {
                    this.zLG = com.bytedance.sdk.openadsdk.multipro.MY.IlO.IlO(new JSONObject(stringExtra2));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.MY.IlO ilO = this.zLG;
                if (ilO != null) {
                    this.ea = ilO.Bc;
                }
            }
            if (bundle != null) {
                String string = bundle.getString("material_meta");
                if (this.zPa == null) {
                    try {
                        this.zPa = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(string));
                    } catch (Throwable unused5) {
                    }
                }
                long j = bundle.getLong("video_play_position");
                if (j > 0) {
                    this.ea = j;
                }
            }
            EO();
            DmF();
            hp();
            IlO(4);
            if (this.IlO != null) {
                com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.Cc).IlO(true).MY(false).IlO(this.IlO.getWebView());
                EV evMY = new EV(this.zPa, this.IlO.getWebView(), new NV() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
                    @Override // com.bytedance.sdk.openadsdk.tV.NV
                    public void IlO(int i2) {
                        EO.IlO.IlO(TTVideoLandingPageActivity.this.fdM, TTVideoLandingPageActivity.this.Dxv.get(), TTVideoLandingPageActivity.this.Ea.get(), TTVideoLandingPageActivity.this.KC.get() - TTVideoLandingPageActivity.this.Ea.get(), TTVideoLandingPageActivity.this.zPa, "landingpage_split_screen", i2);
                    }
                }, this.hL).MY(true);
                this.BS = evMY;
                this.AK = evMY.IlO;
                evMY.IlO("landingpage_split_screen");
            }
            com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
            if (vce != null) {
                vce.setLandingPage(true);
                this.IlO.setTag("landingpage_split_screen");
                this.IlO.setMaterialMeta(this.zPa.Ct());
                this.IlO.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this.Cc, this.NV, this.lEW, this.BS, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        try {
                            if (TextUtils.isEmpty(TTVideoLandingPageActivity.this.HSR)) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTVideoLandingPageActivity.this.KC.incrementAndGet();
                            WebResourceResponseModel webResourceResponseModelIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(TTVideoLandingPageActivity.this.uvo, TTVideoLandingPageActivity.this.HSR, str);
                            if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getWebResourceResponse() != null) {
                                TTVideoLandingPageActivity.this.Ea.incrementAndGet();
                                return webResourceResponseModelIlO.getWebResourceResponse();
                            }
                            if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                                TTVideoLandingPageActivity.this.Dxv.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(webView, str);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.oeT.IlO("TTVideoLandingPage", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                com.bytedance.sdk.component.DmF.vCE vce2 = this.IlO;
                vce2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.xF.IlO(vce2.getWebView(), this.vCE));
            }
            com.bytedance.sdk.component.DmF.vCE vce3 = this.IlO;
            if (vce3 != null) {
                vce3.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.zPa, "landingpage_split_screen", this.hL);
            com.bytedance.sdk.openadsdk.utils.oeT.IlO(this.IlO, this.mmj);
            this.IlO.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.NV, this.BS) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    super.onProgressChanged(webView, i2);
                }
            });
            this.IlO.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
                    com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce4 = TTVideoLandingPageActivity.this.oc;
                    if (vce4 != null) {
                        vce4.tV();
                    }
                }
            });
            TextView textView = this.tV;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            NV();
            tV();
            rp();
            EO.IlO.IlO(SystemClock.elapsedRealtime() - jElapsedRealtime, this.zPa, "landingpage_split_screen", this.uvo, this.HSR);
        } catch (Throwable unused6) {
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EV();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.zPa.vCE(false);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
        if (vce != null) {
            nvX.IlO(vce.getWebView());
        }
        this.IlO = null;
        vSq vsq = this.NV;
        if (vsq != null) {
            vsq.rp();
        }
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce2 = this.bWL;
        if (vce2 != null && vce2.getNativeVideoController() != null) {
            this.bWL.getNativeVideoController().tV();
        }
        this.bWL = null;
        this.zPa = null;
        EV ev = this.BS;
        if (ev != null) {
            ev.tV(true);
        }
        if (!TextUtils.isEmpty(this.HSR)) {
            EO.IlO.IlO(this.Ea.get(), this.KC.get(), this.zPa);
        }
        com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.uvo);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ea();
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce == null || vce.getNativeVideoController() == null) {
            return;
        }
        IlO(this.bWL.getNativeVideoController());
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.nvX) {
            bWL();
        }
        this.nvX = false;
        vSq vsq = this.NV;
        if (vsq != null) {
            vsq.EV();
        }
        EV ev = this.BS;
        if (ev != null) {
            ev.Bc();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        oeT oet = this.zPa;
        bundle.putString("material_meta", oet != null ? oet.eDn().toString() : null);
        bundle.putLong("video_play_position", this.ea);
        bundle.putBoolean("is_complete", this.lMM);
        long jCc = this.ea;
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce != null && vce.getNativeVideoController() != null) {
            jCc = this.bWL.getNativeVideoController().Cc();
        }
        bundle.putLong("video_play_position", jCc);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(this, this.zPa);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        EV ev = this.BS;
        if (ev != null) {
            ev.lEW();
        }
    }

    private void IlO(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.wPn) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
            @Override // java.lang.Runnable
            public void run() {
                TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                if (tTVideoLandingPageActivity.wPn == null || tTVideoLandingPageActivity.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.wPn.setText(str);
            }
        });
    }

    public void EO() {
        this.OOq = (bWL) findViewById(zPa.wD);
        this.IlO = (com.bytedance.sdk.component.DmF.vCE) findViewById(zPa.quf);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.MY = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObjectIlO;
                    TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                    if (tTVideoLandingPageActivity.IlO != null) {
                        vCE.IlO ilO = tTVideoLandingPageActivity.AK;
                        if (ilO != null) {
                            ilO.IlO();
                        }
                        if (TTVideoLandingPageActivity.this.IlO.DmF()) {
                            TTVideoLandingPageActivity.this.IlO.NV();
                            return;
                        }
                        if (TTVideoLandingPageActivity.this.cl()) {
                            TTVideoLandingPageActivity.this.onBackPressed();
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = TTVideoLandingPageActivity.this.bWL;
                        if (vce == null || vce.getNativeVideoController() == null) {
                            jSONObjectIlO = null;
                        } else {
                            TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                            jSONObjectIlO = zLG.IlO(tTVideoLandingPageActivity2.zPa, tTVideoLandingPageActivity2.bWL.getNativeVideoController().vCE(), TTVideoLandingPageActivity.this.bWL.getNativeVideoController().NV());
                        }
                        JSONObject jSONObject = jSONObjectIlO;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity3 = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(tTVideoLandingPageActivity3.zPa, "embeded_ad", "detail_back", tTVideoLandingPageActivity3.vCE(), TTVideoLandingPageActivity.this.Bc(), jSONObject, (com.bytedance.sdk.openadsdk.tV.Bc) null);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce != null) {
            vce.setIsAutoPlay(this.YA);
        }
        ImageView imageView2 = (ImageView) findViewById(zPa.zLG);
        this.EO = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObjectIlO;
                    com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce2 = TTVideoLandingPageActivity.this.bWL;
                    if (vce2 != null) {
                        if (vce2.getNativeVideoController() != null) {
                            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                            jSONObjectIlO = zLG.IlO(tTVideoLandingPageActivity.zPa, tTVideoLandingPageActivity.bWL.getNativeVideoController().vCE(), TTVideoLandingPageActivity.this.bWL.getNativeVideoController().NV());
                        } else {
                            jSONObjectIlO = null;
                        }
                        JSONObject jSONObject = jSONObjectIlO;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(tTVideoLandingPageActivity2.zPa, "embeded_ad", "detail_skip", tTVideoLandingPageActivity2.vCE(), TTVideoLandingPageActivity.this.Bc(), jSONObject, (com.bytedance.sdk.openadsdk.tV.Bc) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.tV = (TextView) findViewById(zPa.KT);
        this.rp = (FrameLayout) findViewById(zPa.DM);
        this.oeT = (RelativeLayout) findViewById(zPa.BS);
        this.vAh = (TextView) findViewById(zPa.gQ);
        this.pP = (TextView) findViewById(zPa.HSR);
        this.tl = (TextView) findViewById(zPa.AK);
        this.kBB = (com.bytedance.sdk.openadsdk.core.widget.IlO) findViewById(zPa.ssS);
        lEW();
    }

    public String MY() {
        oeT oet = this.zPa;
        if (oet != null && !TextUtils.isEmpty(oet.aa())) {
            this.AXM = this.zPa.aa();
        }
        return this.AXM;
    }

    public void tV() {
        if (Cc()) {
            try {
                com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = new com.bytedance.sdk.openadsdk.core.rp.MY.vCE(this.Cc, this.zPa, true, null);
                this.bWL = vce;
                if (vce.getNativeVideoController() != null) {
                    this.bWL.getNativeVideoController().IlO(false);
                }
                if (this.lMM) {
                    this.rp.setVisibility(0);
                    this.rp.removeAllViews();
                    this.rp.addView(this.bWL);
                    this.bWL.MY(true);
                } else {
                    if (!this.YA) {
                        this.ea = 0L;
                    }
                    if (this.zLG != null && this.bWL.getNativeVideoController() != null) {
                        this.bWL.getNativeVideoController().EO(this.zLG.Bc);
                        this.bWL.getNativeVideoController().tV(this.zLG.Cc);
                        this.bWL.IlO(cl.tV().MY(String.valueOf(this.zPa.hFV())), "landingPageInit");
                    }
                    if (this.bWL.IlO(this.ea, this.nvX, this.lMM)) {
                        this.rp.setVisibility(0);
                        this.rp.removeAllViews();
                        this.rp.addView(this.bWL);
                    }
                    if (this.bWL.getNativeVideoController() != null) {
                        this.bWL.getNativeVideoController().IlO(false);
                        this.bWL.getNativeVideoController().IlO(this.Jz);
                    }
                }
                String strIlO = this.zPa.Hg().get(0).IlO();
                com.bytedance.sdk.openadsdk.DmF.tV.IlO().IlO(strIlO).IlO(this.zPa.Hg().get(0).MY()).MY(this.zPa.Hg().get(0).EO()).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).EO(2).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(this.zPa, strIlO, new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.10
                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(int i2, String str, @Nullable Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
                        try {
                            Object objMY = ev.MY();
                            if (objMY instanceof Bitmap) {
                                new IlO((Bitmap) objMY, TTVideoLandingPageActivity.this.bWL.getNativeVideoController().EV()).execute(new Void[0]);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }), 4);
                this.bWL.findViewById(520093726).setOnTouchListener(null);
                this.bWL.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("TTVideoLandingPage", e.getMessage());
                if (this.bWL == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e);
                }
            }
            if (this.DM == 0) {
                try {
                    Toast.makeText(this, com.bytedance.sdk.component.utils.pP.IlO(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public long vCE() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce == null || vce.getNativeVideoController() == null) {
            return 0L;
        }
        return this.bWL.getNativeVideoController().lEW();
    }

    private void IlO(e eVar) {
        this.lMM = this.lMM || eVar.rp();
        Boolean bool = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_is_update_flag", bool);
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.lMM));
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(eVar.Cc()));
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(eVar.vCE() + eVar.lEW()));
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_duration", Long.valueOf(eVar.lEW()));
    }

    private void IlO(final int i2) {
        if (this.EO == null || !cl()) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                BS.IlO((View) TTVideoLandingPageActivity.this.EO, i2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.NV.tV
    public void IlO(boolean z2, JSONArray jSONArray) {
        if (!z2 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.gQ = jSONArray;
    }
}
