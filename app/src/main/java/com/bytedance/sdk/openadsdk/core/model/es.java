package com.bytedance.sdk.openadsdk.core.model;

import a1.a;
import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements Handler.Callback {
    private String AK;
    private TextView AXM;
    private ValueAnimator BO;
    private boolean BS;
    final oeT Bc;
    View Cc;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE DM;
    ObjectAnimator DmF;
    private int Dxv;
    TextView EO;
    ObjectAnimator EV;
    private com.bytedance.sdk.openadsdk.core.widget.IlO.Cc HSR;
    private AtomicBoolean HTA;
    private LinearLayout.LayoutParams Hg;
    ImageView IlO;
    private com.bytedance.sdk.openadsdk.core.Cc.tV Jz;
    FrameLayout MY;
    ValueAnimator NV;
    private ImageView OOq;
    private com.bytedance.sdk.openadsdk.core.widget.zPa Tx;
    private final View YA;
    com.bytedance.sdk.openadsdk.core.MY.MY bWL;
    private TextView cL;
    private View cl;
    private final Activity dY;
    private Handler ea;
    private TextView es;
    private int fdM;
    private boolean gQ;
    private com.bytedance.sdk.openadsdk.common.tV hL;
    com.bytedance.sdk.openadsdk.core.MY.IlO hp;
    private FrameLayout kBB;
    FrameLayout lEW;
    private String lMM;
    private int mmj;
    private FrameLayout nm;
    private final com.bytedance.sdk.openadsdk.core.rp.tV.MY nvX;
    private long oc;
    private com.bytedance.sdk.openadsdk.core.vSq oeT;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW pFe;
    private com.bytedance.sdk.openadsdk.common.rp pP;
    private ILoader quf;
    b rp;
    FrameLayout tV;
    private View tl;
    private MY ts;
    private com.bytedance.sdk.component.DmF.vCE vAh;
    RelativeLayout vCE;
    private com.bytedance.sdk.openadsdk.core.lEW.xF wD;
    private View wPn;
    private com.bytedance.sdk.openadsdk.core.widget.zPa xF;
    private com.bytedance.sdk.openadsdk.tV.EV zLG;
    private View zPa;
    private final AtomicBoolean vSq = new AtomicBoolean(false);
    private final AtomicBoolean ssS = new AtomicBoolean(false);
    private volatile int uvo = 0;
    private volatile int KC = 0;
    private volatile int Ea = 0;
    private float ii = -1.0f;
    private final AtomicBoolean qz = new AtomicBoolean(false);
    private long qvT = -1;
    private final AtomicBoolean dm = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.lEW {
        @Override // com.bytedance.sdk.component.Cc.lEW
        public Bitmap IlO(Bitmap bitmap) {
            return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), bitmap, 25);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements com.bytedance.sdk.openadsdk.tV.NV {
        private final String EO;
        private final int IlO;
        private final oeT MY;
        private final WeakReference<es> tV;

        public MY(int i2, oeT oet, String str, es esVar) {
            this.IlO = i2;
            this.MY = oet;
            this.EO = str;
            this.tV = new WeakReference<>(esVar);
        }

        @Override // com.bytedance.sdk.openadsdk.tV.NV
        public void IlO(int i2) {
            es esVar = this.tV.get();
            if (esVar != null) {
                EO.IlO.IlO(this.IlO, esVar.Ea, esVar.KC, esVar.uvo - esVar.KC, this.MY, this.EO, i2);
            }
        }
    }

    public es(Activity activity, final oeT oet, String str, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.core.rp.tV.MY my, View view) {
        this.dY = activity;
        this.Bc = oet;
        this.lMM = str;
        this.nvX = my;
        this.YA = view;
        this.mmj = zLG.IlO(str);
        if (oet != null) {
            this.AK = oet.tU();
        }
        if (!TextUtils.isEmpty(this.AK)) {
            this.quf = com.bytedance.sdk.openadsdk.Bc.MY.IlO().MY();
            int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.quf, this.AK);
            this.Dxv = iIlO;
            this.fdM = iIlO > 0 ? 2 : 0;
        }
        boolean zTV = tV(oet);
        boolean zCc = Cc(oet);
        boolean zMY = MY(oet);
        if (zMY) {
            this.lMM = "landingpage_split_screen";
        } else if (zTV) {
            this.lMM = "landingpage_direct";
        } else if (zCc) {
            this.lMM = "aggregate_page";
        } else if (EO(oet)) {
            this.lMM = "landingpage_split_ceiling";
        }
        this.hp = new com.bytedance.sdk.openadsdk.core.MY.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), oet, this.lMM, zLG.IlO(str));
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        this.hp.IlO(map);
        View viewFindViewById = activity.findViewById(R.id.content);
        this.hp.IlO(viewFindViewById);
        com.bytedance.sdk.openadsdk.core.MY.MY my2 = new com.bytedance.sdk.openadsdk.core.MY.MY(activity, oet, this.lMM, zLG.IlO(str), true) { // from class: com.bytedance.sdk.openadsdk.core.model.es.1
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY
            public boolean IlO(NV nv, Map<String, Object> map2) {
                if (es.lEW(oet) && es.this.HSR != null) {
                    es.this.HSR.IlO(nv);
                    es.this.HSR.IlO(map2);
                    if (es.Bc(es.this.Bc) || es.this.gQ) {
                        return true;
                    }
                }
                return super.IlO(nv, map2);
            }
        };
        this.bWL = my2;
        my2.IlO(map);
        this.bWL.IlO(viewFindViewById);
        this.lEW = frameLayout;
        if (zMY || zTV || zCc) {
            try {
                this.ea = new Handler(Looper.getMainLooper(), this);
            } catch (Exception e) {
                Log.e("LandingPageModel", "LandingPageModel: ", e);
                return;
            }
        }
        if (!zTV && !zCc) {
            return;
        }
        Handler handler = this.ea;
        handler.sendMessage(handler.obtainMessage(100, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MY(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5;
    }

    public static /* synthetic */ int bWL(es esVar) {
        int i2 = esVar.KC;
        esVar.KC = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int ea(es esVar) {
        int i2 = esVar.Ea;
        esVar.Ea = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int rp(es esVar) {
        int i2 = esVar.uvo;
        esVar.uvo = i2 + 1;
        return i2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        oeT oet;
        oeT oet2;
        int i2 = message.what;
        if (i2 == 100) {
            int i8 = message.arg1;
            long jTV = (!tV(this.Bc) || (oet2 = this.Bc) == null || oet2.ea() == null) ? (!Cc(this.Bc) || (oet = this.Bc) == null || oet.ea() == null) ? 20L : this.Bc.ea().tV() : this.Bc.ea().MY();
            b bVar = this.rp;
            if (bVar != null) {
                bVar.IlO(((long) i8) * 1000, jTV * 1000);
            }
            long j = i8;
            if (j >= jTV) {
                b bVar2 = this.rp;
                if (bVar2 != null) {
                    bVar2.IlO(jTV * 1000, 100);
                }
            } else if (j < jTV && this.ea != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i8 + 1;
                this.ea.sendMessageDelayed(messageObtain, 1000L);
            }
        } else if (i2 == 101) {
            NV();
        }
        return true;
    }

    public static boolean Bc(oeT oet) {
        return (oet == null || oet.LO() == 1 || !lEW(oet)) ? false : true;
    }

    public static boolean Cc(oeT oet) {
        return oet != null && oet.vAh() == 33;
    }

    public static boolean DmF(oeT oet) {
        return oet != null && oet.vAh() == 19;
    }

    private void EV() {
        es esVar;
        com.bytedance.sdk.component.DmF.vCE vce = this.vAh;
        if (vce == null || vce.getWebView() == null) {
            esVar = this;
        } else {
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()).IlO(false).MY(false).IlO(this.vAh.getWebView());
            com.bytedance.sdk.component.DmF.vCE vce2 = this.vAh;
            if (vce2 != null && vce2.getWebView() != null) {
                this.ts = new MY(this.Dxv, this.Bc, this.lMM, this);
                if (this.vAh.j_() && (this.vAh.getWebViewClient() instanceof com.bytedance.sdk.openadsdk.core.widget.IlO.Cc)) {
                    com.bytedance.sdk.openadsdk.tV.EV evMY = ((com.bytedance.sdk.openadsdk.core.widget.IlO.Cc) this.vAh.getWebViewClient()).MY();
                    this.zLG = evMY;
                    if (evMY != null) {
                        evMY.IlO(this.ts);
                        this.zLG.MY(true);
                    }
                } else {
                    this.zLG = new com.bytedance.sdk.openadsdk.tV.EV(this.Bc, this.vAh.getWebView(), this.ts, this.fdM).MY(true);
                }
                this.zLG.IlO(this.lMM);
                com.bytedance.sdk.openadsdk.common.tV tVVarIlO = zLG.IlO(this.Bc, this.vAh, this.dY, this.lMM);
                this.hL = tVVarIlO;
                if (tVVarIlO != null) {
                    tVVarIlO.IlO(this.lMM);
                }
                zLG.IlO(this.Bc, this.vAh);
            }
            rp();
            if (this.vAh.j_()) {
                xF();
            }
            this.vAh.setLandingPage(true);
            this.vAh.setTag(this.lMM);
            this.vAh.setMaterialMeta(this.Bc.Ct());
            esVar = this;
            com.bytedance.sdk.openadsdk.core.widget.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO(), this.oeT, this.Bc.ED(), this.hL, this.zLG, true) { // from class: com.bytedance.sdk.openadsdk.core.model.es.12
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    es.this.hp();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    es.this.nvX.EV();
                    es.this.oc = System.currentTimeMillis();
                    if (!es.MY(es.this.Bc) || es.this.ea == null || oeT.Cc(es.this.Bc)) {
                        return;
                    }
                    es.this.ea.sendEmptyMessageDelayed(101, 2000L);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    super.onReceivedError(webView, i2, str, str2);
                    String strTV = com.bytedance.sdk.openadsdk.core.widget.IlO.Cc.tV(str2);
                    boolean z2 = false;
                    if (this.vCE != null) {
                        this.vCE.IlO(webView, i2, str, str2, com.bytedance.sdk.openadsdk.core.widget.IlO.Cc.tV(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
                    }
                    boolean z7 = strTV != null && strTV.startsWith("image");
                    if (strTV != null && strTV.startsWith("mp4")) {
                        z2 = true;
                    }
                    if (z7 || z2 || es.this.vSq.get()) {
                        return;
                    }
                    es.this.ea();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        es.this.ea();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(es.this.AK)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        es.rp(es.this);
                        WebResourceResponseModel webResourceResponseModelIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(es.this.quf, es.this.AK, str);
                        if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getWebResourceResponse() != null) {
                            es.bWL(es.this);
                            return webResourceResponseModelIlO.getWebResourceResponse();
                        }
                        if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                            es.ea(es.this);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.IlO("LandingPageModel", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (!es.EO(es.this.Bc) || zLG.IlO(webView) != 1) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    Intent intent = new Intent(es.this.dY, (Class<?>) TTCeilingLandingPageActivity.class);
                    intent.putExtra("second_url", str);
                    com.bytedance.sdk.openadsdk.core.pP.IlO().vCE();
                    com.bytedance.sdk.openadsdk.core.pP.IlO().IlO(es.this.Bc);
                    com.bytedance.sdk.component.utils.MY.IlO(this.tV, intent, null);
                    return true;
                }
            };
            esVar.HSR = cc;
            esVar.vAh.setWebViewClient(cc);
            esVar.HSR.IlO(esVar.Bc);
            esVar.HSR.IlO(esVar.lMM);
            esVar.HSR.IlO(esVar.nvX);
            esVar.vAh.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(esVar.oeT, esVar.zLG, esVar.hL) { // from class: com.bytedance.sdk.openadsdk.core.model.es.13
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    super.onProgressChanged(webView, i2);
                    if (es.this.dY != null && !es.this.dY.isFinishing() && i2 == 100) {
                        es.this.hp();
                    }
                    if (es.this.pP != null) {
                        es.this.pP.IlO(i2);
                    }
                }
            });
            if (esVar.DM == null) {
                esVar.DM = com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), esVar.Bc, esVar.lMM);
            }
            esVar.vAh.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.14
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (es.this.DM != null) {
                        es.this.DM.tV();
                    }
                }
            });
            com.bytedance.sdk.component.DmF.vCE vce3 = esVar.vAh;
            vce3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.xF.IlO(vce3.getWebView(), BuildConfig.VERSION_CODE));
            esVar.vAh.setMixedContentMode(0);
            esVar.vAh.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.15
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i2, int i8, int i9, int i10) {
                    if (es.this.zLG != null) {
                        es.this.zLG.MY(i8);
                    }
                }
            });
            esVar.vAh.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.16
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (es.this.DmF()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            es.this.ii = motionEvent.getY();
                        } else if (action == 1) {
                            if (BS.IlO(es.this.ii, motionEvent.getY(), es.this.dY)) {
                                es.this.IlO(5);
                            }
                        } else if (action == 2) {
                            motionEvent.setAction(3);
                        }
                    }
                    if ((!es.this.gQ || es.lEW(es.this.Bc)) && !es.Cc(es.this.Bc)) {
                        es.this.bWL.onTouch(view, motionEvent);
                    }
                    if ((!es.this.gQ || es.lEW(es.this.Bc)) && !es.Cc(es.this.Bc) && motionEvent.getAction() == 1 && es.this.bWL.Bc()) {
                        es.this.vAh.getWebView().performClick();
                        es.this.gQ = true;
                    }
                    if (es.this.zLG != null) {
                        es.this.zLG.IlO(motionEvent);
                    }
                    if (es.this.hL == null) {
                        return false;
                    }
                    es.this.hL.IlO(motionEvent);
                    return false;
                }
            });
            esVar.vAh.getWebView().setOnClickListener(esVar.bWL);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(esVar.Bc, esVar.lMM, esVar.fdM);
            if (!esVar.vAh.j_()) {
                com.bytedance.sdk.openadsdk.utils.oeT.IlO(esVar.vAh, esVar.Bc.pFe());
            }
            esVar.BS = true;
        }
        com.bytedance.sdk.component.DmF.vCE vce4 = esVar.vAh;
        if (vce4 == null || esVar.pP == null || vce4.EO()) {
            return;
        }
        esVar.pP.IlO();
    }

    public static boolean NV(oeT oet) {
        return (oet == null || !com.bytedance.sdk.openadsdk.core.cl.tV().xF() || !oet.AK() || MY(oet) || tV(oet) || Cc(oet)) ? false : true;
    }

    private void bWL() {
        this.vCE.setVisibility(8);
        if (tV(this.Bc) || Cc(this.Bc) || !tV() || EO(this.Bc)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "timeVisible", 0.0f, 1.0f);
        this.EV = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(100L);
        this.EV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) es.this.kBB.getLayoutParams();
                layoutParams.weight = (float) (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.25d);
                es.this.IlO((float) (1.0d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2d)));
                es.this.kBB.setLayoutParams(layoutParams);
            }
        });
        this.EV.start();
    }

    private void cL() {
        if (tV()) {
            this.tl.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.OOq, "translationY", 16.0f, 0.0f).setDuration(500L);
            this.DmF = duration;
            duration.setRepeatMode(2);
            this.DmF.setRepeatCount(-1);
            this.DmF.start();
            this.tl.setClickable(true);
            this.tl.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!es.this.gQ) {
                        es.this.bWL.onTouch(view, motionEvent);
                    }
                    if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    es.this.NV = ObjectAnimator.ofFloat(this, "timeSlide", 0.0f, 1.0f);
                    es.this.NV.setDuration(200L);
                    es.this.NV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) es.this.kBB.getLayoutParams();
                            layoutParams.weight = (float) (((double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f)) + 0.25d);
                            es.this.IlO((float) (0.800000011920929d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.5d)));
                            es.this.kBB.setLayoutParams(layoutParams);
                        }
                    });
                    if (es.this.bWL.Bc()) {
                        es.this.tl.performClick();
                        es.this.gQ = true;
                    }
                    es.this.NV.start();
                    es.this.tl.setVisibility(8);
                    return true;
                }
            });
            this.tl.setOnClickListener(this.bWL);
        }
        if (!es()) {
            this.lEW.setVisibility(8);
            this.MY.setVisibility(0);
            this.IlO.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.IlO.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    es esVar = es.this;
                    com.bytedance.sdk.openadsdk.tV.EO.MY(esVar.Bc, esVar.lMM);
                }
            });
            oeT oet = this.Bc;
            if (oet != null && oet.Hg() != null && this.Bc.Hg().size() > 0 && this.Bc.Hg().get(0) != null && !TextUtils.isEmpty(this.Bc.Hg().get(0).IlO())) {
                com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.Bc.Hg().get(0), this.IlO, this.Bc, new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.core.model.es.7
                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
                        if (es.this.ea != null) {
                            es.this.ea.removeMessages(101);
                        }
                    }

                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(int i2, String str, @Nullable Throwable th) {
                        if (es.this.ea != null) {
                            es.this.ea.removeMessages(101);
                        }
                        es.this.NV();
                    }
                });
            }
        }
        try {
            String strIlO = this.Bc.Hg().get(0).IlO();
            com.bytedance.sdk.openadsdk.DmF.tV.IlO().IlO(strIlO).IlO(this.Bc.Hg().get(0).MY()).MY(this.Bc.Hg().get(0).EO()).Cc(BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO())).tV(BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO())).EO(1).IlO(new IlO()).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(this.Bc, strIlO, new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.core.model.es.8
                @Override // com.bytedance.sdk.component.Cc.zPa
                public void IlO(int i2, String str, @Nullable Throwable th) {
                }

                @Override // com.bytedance.sdk.component.Cc.zPa
                public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
                    Drawable bitmapDrawable;
                    try {
                        Object objMY = ev.MY();
                        if (objMY != null && ev.EO() != null) {
                            if (objMY instanceof Bitmap) {
                                bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.cl.IlO().getResources(), (Bitmap) objMY);
                            } else if (objMY instanceof Drawable) {
                                if (Build.VERSION.SDK_INT >= 28 && androidx.webkit.internal.b.y(objMY)) {
                                    androidx.webkit.internal.b.h(objMY).start();
                                }
                                bitmapDrawable = (Drawable) objMY;
                            } else {
                                bitmapDrawable = null;
                            }
                            if (!es.this.es()) {
                                es.this.MY.setBackground(bitmapDrawable);
                                return;
                            }
                            es.this.tV.setBackground(bitmapDrawable);
                            View viewNV = es.this.nvX.NV();
                            if (viewNV == null || !(viewNV.getParent() instanceof View)) {
                                return;
                            }
                            ((View) viewNV.getParent()).setBackground(bitmapDrawable);
                        }
                    } catch (Exception unused) {
                    }
                }
            }));
        } catch (Exception unused) {
        }
    }

    private void cl() {
        com.bytedance.sdk.openadsdk.common.EV loadingStyle;
        com.bytedance.sdk.openadsdk.common.rp rpVar = this.pP;
        if (rpVar != null && (loadingStyle = rpVar.getLoadingStyle()) != null) {
            this.Tx = loadingStyle.MY();
            this.pFe = loadingStyle.EO();
        }
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = this.Jz;
        if (tVVar != null) {
            tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (es.this.Jz.getTag() != null) {
                        if (es.this.Jz.getTag().equals(1)) {
                            es.this.IlO(3);
                        } else if (es.this.Jz.getTag().equals(2)) {
                            es.this.IlO(4);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        LinearLayout.LayoutParams layoutParams;
        if (this.vSq.get()) {
            return;
        }
        zPa();
        this.ssS.set(true);
        this.nvX.lEW();
        com.bytedance.sdk.openadsdk.common.rp rpVar = this.pP;
        if (rpVar != null) {
            rpVar.MY();
        }
        if (Cc(this.Bc)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.Bc, this.lMM, "show_agg_backup");
            View view = this.cl;
            if (view != null) {
                view.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cl.getLayoutParams();
                layoutParams2.addRule(13);
                layoutParams2.addRule(10, 0);
                this.cl.setLayoutParams(layoutParams2);
                RelativeLayout relativeLayout = this.vCE;
                if (relativeLayout != null) {
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        this.zPa.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.zPa.getLayoutParams();
        layoutParams3.addRule(13);
        layoutParams3.addRule(10, 0);
        this.zPa.setLayoutParams(layoutParams3);
        if (this.Bc.HTA() != null && !TextUtils.isEmpty(this.Bc.HTA().IlO())) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.Bc.HTA().IlO(), this.Bc.HTA().MY(), this.Bc.HTA().EO(), this.xF, this.Bc);
        }
        this.cL.setText(this.Bc.hL());
        this.es.setText(this.Bc.gm());
        if (this.AXM != null) {
            MY();
            this.AXM.setClickable(true);
            this.AXM.setOnClickListener(this.hp);
            this.AXM.setOnTouchListener(this.hp);
        }
        if (!EO(this.Bc) || (layoutParams = this.Hg) == null) {
            return;
        }
        if (layoutParams.weight < 30.0f) {
            EO(8);
        } else {
            EO(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean es() {
        return oeT.Cc(this.Bc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp() {
        if (this.vSq.get() || this.ssS.get()) {
            return;
        }
        this.vSq.set(true);
        long jElapsedRealtime = this.qvT == -1 ? 0L : SystemClock.elapsedRealtime() - this.qvT;
        if (EO(this.Bc)) {
            com.bytedance.sdk.openadsdk.tV.EO.EO(this.Bc, this.lMM, jElapsedRealtime);
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.Bc, this.lMM, System.currentTimeMillis() - this.oc, true);
        bWL();
    }

    public static boolean lEW(oeT oet) {
        if (oet != null) {
            return oet.vAh() == 19 || oet.vAh() == 20;
        }
        return false;
    }

    private void rp() {
        com.bytedance.sdk.openadsdk.core.vSq vsq = new com.bytedance.sdk.openadsdk.core.vSq(this.dY);
        this.oeT = vsq;
        vsq.IlO(this.nvX);
        this.oeT.MY(this.vAh).IlO(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.Bc)).EO(this.Bc.ED()).tV(this.Bc.KT()).IlO(this.Bc).MY(Cc(this.Bc) ? this.mmj : -1).IlO(this.Bc.quf()).MY(this.lMM).Cc(this.Bc.tcT()).IlO(this.vAh).IlO(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.core.model.es.17
            @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
            public void IlO() {
                if (es.Cc(es.this.Bc) && (es.this.dY instanceof com.bytedance.sdk.openadsdk.core.rp.tV.MY)) {
                    ((com.bytedance.sdk.openadsdk.core.rp.tV.MY) es.this.dY).c_();
                } else if (es.this.HSR != null) {
                    es.this.HSR.EO();
                }
            }
        });
    }

    public static boolean vCE(oeT oet) {
        return tV(oet) && !DmF(oet);
    }

    private void xF() {
        com.bytedance.sdk.component.DmF.vCE vce = this.vAh;
        if (vce == null || vce.getWebView() == null) {
            return;
        }
        this.uvo = this.vAh.IlO;
        this.KC = this.vAh.MY;
        this.Ea = this.vAh.EO;
        if (this.vAh.MY()) {
            this.nvX.EV();
            this.oc = System.currentTimeMillis();
        }
        if (this.vAh.tV()) {
            hp();
        }
        if (this.vAh.EO()) {
            hp();
            int iIlO = zLG.IlO(this.vAh.getWebView());
            MY my = this.ts;
            if (my != null) {
                my.IlO(iIlO != 1 ? 0 : 1);
            }
        }
    }

    private void zPa() {
        if ((tV(this.Bc) || Cc(this.Bc)) && (this.dY instanceof com.bytedance.sdk.openadsdk.core.rp.tV.MY)) {
            this.nvX.EV();
            this.nvX.rp();
        }
    }

    public void EO() {
        if (es()) {
            try {
                String str = this.Bc.fdM().f4689f;
                com.bytedance.sdk.openadsdk.DmF.tV.IlO().IlO(str).IlO(this.Bc.fdM().f4686b).MY(this.Bc.fdM().f4685a).Cc(BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO())).tV(BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO())).EO(2).IlO(new IlO()).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(this.Bc, str, new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.core.model.es.4
                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(int i2, String str2, @Nullable Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.Cc.zPa
                    public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
                        try {
                            Object objMY = ev.MY();
                            if (objMY != null && ev.EO() != null) {
                                BitmapDrawable bitmapDrawable = objMY instanceof Bitmap ? new BitmapDrawable(com.bytedance.sdk.openadsdk.core.cl.IlO().getResources(), (Bitmap) objMY) : null;
                                View viewNV = es.this.nvX.NV();
                                if (bitmapDrawable == null || viewNV == null || !(viewNV.getParent() instanceof View)) {
                                    return;
                                }
                                ((View) viewNV.getParent()).setBackground(bitmapDrawable);
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.oeT.EO("LandingPageModel", th.getMessage());
                        }
                    }
                }));
            } catch (Exception unused) {
            }
        }
    }

    public boolean tV() {
        return this.Bc.uI() == 15 || this.Bc.uI() == 16;
    }

    public void Cc() {
        FrameLayout frameLayout = this.kBB;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.wPn;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public boolean DmF() {
        AtomicBoolean atomicBoolean;
        return (!EO(this.Bc) || (atomicBoolean = this.HTA) == null || atomicBoolean.get()) ? false : true;
    }

    public void vCE() {
        com.bytedance.sdk.component.DmF.vCE vce;
        com.bytedance.sdk.openadsdk.tV.EV ev = this.zLG;
        if (ev != null && (vce = this.vAh) != null) {
            ev.IlO(vce);
        }
        Handler handler = this.ea;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.BO;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.BO.cancel();
        }
        ValueAnimator valueAnimator2 = this.NV;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.NV.cancel();
        }
        ObjectAnimator objectAnimator = this.EV;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.EV.cancel();
        }
        com.bytedance.sdk.openadsdk.common.rp rpVar = this.pP;
        if (rpVar != null) {
            rpVar.MY();
        }
        ObjectAnimator objectAnimator2 = this.DmF;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = this.vAh;
        if (vce2 != null) {
            nvX.IlO(vce2.getWebView());
        }
        this.vAh = null;
        com.bytedance.sdk.openadsdk.core.vSq vsq = this.oeT;
        if (vsq != null) {
            vsq.rp();
        }
        com.bytedance.sdk.openadsdk.tV.EV ev2 = this.zLG;
        if (ev2 != null) {
            ev2.tV(true);
        }
        if (!TextUtils.isEmpty(this.AK) && this.BS) {
            EO.IlO.IlO(this.KC, this.uvo, this.Bc);
        }
        com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.quf);
    }

    public static boolean tV(oeT oet) {
        if (oet == null) {
            return false;
        }
        if (DmF(oet)) {
            return true;
        }
        return oet.Jz() == 3 && oet.vAh() == 5 && !OOq.MY(oet) && (oet.La() == 0.0f || oet.La() == 100.0f);
    }

    public void Bc() {
        com.bytedance.sdk.openadsdk.core.vSq vsq = this.oeT;
        if (vsq != null) {
            vsq.EV();
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.zLG;
        if (ev != null) {
            ev.Bc();
        }
    }

    public void MY() {
        oeT oet = this.Bc;
        if (oet == null || TextUtils.isEmpty(oet.aa())) {
            return;
        }
        this.AXM.setText(this.Bc.aa());
    }

    public void NV() {
        if ("landingpage_split_screen".equals(this.lMM) && com.bytedance.sdk.openadsdk.AXM.IlO.IlO("default_split_style", false) && this.dm.compareAndSet(false, true)) {
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.es.10
                @Override // java.lang.Runnable
                public void run() {
                    es.this.BO = ValueAnimator.ofFloat(1.0f, 0.0f);
                    es.this.BO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.10.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (es.this.wPn != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) es.this.wPn.getLayoutParams();
                                layoutParams.weight = fFloatValue;
                                es.this.wPn.setLayoutParams(layoutParams);
                            }
                        }
                    });
                    es.this.BO.setDuration(500L);
                    es.this.BO.start();
                    if (es.this.tl != null) {
                        es.this.tl.setVisibility(8);
                    }
                }
            });
        }
    }

    public void lEW() {
        com.bytedance.sdk.openadsdk.tV.EV ev = this.zLG;
        if (ev != null) {
            ev.lEW();
        }
    }

    public static boolean MY(oeT oet) {
        return oet != null && oet.Jz() == 3 && oet.vAh() == 6 && !OOq.MY(oet) && oet.BES() == 1 && (oet.La() == 0.0f || oet.La() == 100.0f);
    }

    public void IlO(b bVar) {
        this.rp = bVar;
    }

    public void IlO() {
        long jIlO;
        View view;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.component.DmF.vCE vce = (com.bytedance.sdk.component.DmF.vCE) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.AXM);
        this.vAh = vce;
        if (vce != null && !oeT.IlO(this.Bc)) {
            if (!this.vAh.j_()) {
                this.vAh.Cc();
            }
        } else {
            BS.IlO((View) this.vAh, 8);
        }
        this.kBB = (FrameLayout) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.xF);
        this.pP = (com.bytedance.sdk.openadsdk.common.rp) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.pP);
        this.tl = this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.oeT);
        this.OOq = (ImageView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.vAh);
        this.wPn = this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.nvX);
        this.MY = (FrameLayout) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.cL);
        this.IlO = (ImageView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.es);
        this.vCE = (RelativeLayout) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.kBB);
        this.EO = (TextView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.lQ);
        this.tV = (FrameLayout) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.NV);
        View viewFindViewById = this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.tl);
        this.zPa = viewFindViewById;
        if (viewFindViewById == null) {
            this.zPa = this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.mmj);
        }
        this.cl = this.dY.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.OOq);
        this.cL = (TextView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.oc);
        this.es = (TextView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.vSq);
        this.xF = (com.bytedance.sdk.openadsdk.core.widget.zPa) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.wPn);
        this.AXM = (TextView) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.dY);
        if (this.EO != null && this.Bc.ea() != null) {
            this.EO.setText(this.Bc.ea().Cc());
        }
        this.Cc = this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.lMM);
        this.Jz = (com.bytedance.sdk.openadsdk.core.Cc.tV) this.YA.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.TkD);
        if ((tV(this.Bc) || MY(this.Bc) || Cc(this.Bc) || EO(this.Bc)) && this.Bc.ea() != null) {
            View view2 = this.Cc;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (Cc(this.Bc)) {
                jIlO = this.Bc.ea().EO();
            } else {
                jIlO = this.Bc.ea().IlO();
            }
            com.bytedance.sdk.openadsdk.core.bWL.EO().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.es.11
                @Override // java.lang.Runnable
                public void run() {
                    if (es.this.vSq.get()) {
                        return;
                    }
                    es esVar = es.this;
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(esVar.Bc, esVar.lMM, System.currentTimeMillis() - es.this.oc, false);
                    es.this.ea();
                }
            }, jIlO * 1000);
        }
        EV();
        if (MY(this.Bc)) {
            cL();
            if (!tV()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kBB.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.kBB.setLayoutParams(layoutParams);
            }
        }
        if ((tV(this.Bc) || Cc(this.Bc)) && (view = this.wPn) != null) {
            view.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.common.rp rpVar = this.pP;
        if (rpVar != null) {
            rpVar.IlO(this.Bc);
        }
        if (EO(this.Bc)) {
            cl();
        }
        EO.IlO.IlO(SystemClock.elapsedRealtime() - jElapsedRealtime, this.Bc, this.lMM, this.quf, this.AK);
    }

    public static boolean EO(oeT oet) {
        return oet != null && oet.Jz() == 3 && oet.kBB() == 38 && oet.BES() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(int i2) {
        BS.IlO((View) this.Tx, i2);
        BS.IlO((View) this.pFe, i2);
        if (this.ssS.get()) {
            BS.IlO((View) this.cL, i2);
            BS.IlO((View) this.es, i2);
            BS.IlO((View) this.xF, i2);
            BS.IlO((View) this.AXM, 0);
        }
    }

    public static boolean IlO(oeT oet) {
        if (oet == null || DmF(oet)) {
            return false;
        }
        return tV(oet) || MY(oet) || Cc(oet);
    }

    public void IlO(float f4) {
        try {
            this.nvX.DmF();
        } catch (Throwable unused) {
        }
    }

    public void IlO(@NonNull com.bytedance.sdk.openadsdk.core.lEW.xF xFVar, FrameLayout frameLayout) {
        this.wD = xFVar;
        this.nm = frameLayout;
    }

    public void IlO(int i2) {
        com.bytedance.sdk.openadsdk.core.lEW.xF xFVar = this.wD;
        if (xFVar != null) {
            xFVar.Cc(i2);
        }
    }

    public void IlO(final int i2, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        float f4;
        int iVCE;
        if ((i2 != 3 && !MY(i2)) || this.nm == null || bwl == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.HTA;
        if (atomicBoolean != null) {
            if (i2 == 1) {
                return;
            }
            if (i2 == 5 && atomicBoolean.get()) {
                return;
            }
        }
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.wPn.getLayoutParams();
        this.Hg = (LinearLayout.LayoutParams) this.kBB.getLayoutParams();
        final float f8 = layoutParams.weight;
        cl clVarZPa = this.Bc.zPa();
        if (MY(i2)) {
            if (clVarZPa != null) {
                iVCE = clVarZPa.Cc();
                f4 = iVCE;
            } else {
                f4 = 30.0f;
            }
        } else if (clVarZPa != null) {
            iVCE = clVarZPa.vCE();
            f4 = iVCE;
        } else {
            f4 = 70.0f;
        }
        final float f9 = f4;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nm.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        }
        final FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        final int i8 = layoutParams3.height;
        final int i9 = layoutParams3.width;
        final int i10 = layoutParams3.leftMargin;
        final int i11 = layoutParams3.topMargin;
        final int iMY = BS.MY(this.dY, (float) bwl.lEW());
        final int iMY2 = BS.MY(this.dY, (float) bwl.DmF());
        final int iMY3 = BS.MY(this.dY, (float) bwl.vCE());
        final int iMY4 = BS.MY(this.dY, (float) bwl.Bc());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.NV = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.NV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.es.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams4 = layoutParams;
                float f10 = f8;
                layoutParams4.weight = a.a(f9, f10, fFloatValue, f10);
                es.this.Hg.weight = 100.0f - layoutParams.weight;
                if (es.this.wPn != null) {
                    es.this.wPn.setLayoutParams(layoutParams);
                }
                if (es.this.kBB != null) {
                    es.this.kBB.setLayoutParams(es.this.Hg);
                }
                if (es.this.Hg.weight < 30.0f) {
                    es.this.EO(8);
                } else {
                    es.this.EO(0);
                }
                FrameLayout.LayoutParams layoutParams5 = layoutParams3;
                layoutParams5.width = i9 + ((int) ((iMY - r2) * fFloatValue));
                layoutParams5.height = i8 + ((int) ((iMY2 - r2) * fFloatValue));
                layoutParams5.leftMargin = i10 + ((int) ((iMY3 - r2) * fFloatValue));
                layoutParams5.topMargin = i11 + ((int) ((iMY4 - r2) * fFloatValue));
                if (es.this.nm != null) {
                    es.this.nm.setLayoutParams(layoutParams3);
                }
                es.this.IlO(0.0f);
                if (fFloatValue == 1.0f) {
                    if (es.this.Jz != null) {
                        BS.IlO((View) es.this.Jz, 0);
                        if (es.this.MY(i2)) {
                            es.this.Jz.setImageDrawable(com.bytedance.sdk.component.utils.pP.EO(es.this.dY, "tt_ad_zoom_down"));
                            es.this.Jz.setTag(1);
                        } else {
                            es.this.Jz.setImageDrawable(com.bytedance.sdk.component.utils.pP.EO(es.this.dY, "tt_ad_zoom_up"));
                            es.this.Jz.setTag(2);
                        }
                    }
                    if (es.this.HTA == null) {
                        es.this.HTA = new AtomicBoolean();
                    }
                    es.this.HTA.set(es.this.MY(i2));
                }
            }
        });
        com.bytedance.sdk.openadsdk.tV.EO.tV(this.Bc, this.lMM, i2);
        this.NV.start();
        if (this.qz.compareAndSet(false, true)) {
            this.qvT = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.zLG;
        if (ev != null) {
            ev.IlO(true, SystemClock.elapsedRealtime());
        }
        BS.IlO((View) this.Jz, 8);
    }
}
