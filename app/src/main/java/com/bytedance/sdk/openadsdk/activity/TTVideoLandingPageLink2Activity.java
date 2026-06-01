package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.bWL;
import com.bytedance.sdk.openadsdk.common.ea;
import com.bytedance.sdk.openadsdk.common.rp;
import com.bytedance.sdk.openadsdk.common.zPa;
import com.bytedance.sdk.openadsdk.core.Cc.lEW;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.hp;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements com.bytedance.sdk.openadsdk.NV.tV {
    private com.bytedance.sdk.openadsdk.core.widget.IlO.Cc BO;
    private long HTA;
    private zPa Hg;
    private View Jz;
    TTAdDislikeToast KC;
    private rp fdM;
    private View hL;
    private TextView ii;
    private TextView nm;
    private boolean pFe;
    private com.bytedance.sdk.openadsdk.common.tV qvT;
    private LinearLayout qz;
    private PAGLogoView ts;
    ea uvo;
    private boolean wD;
    private boolean Tx = false;
    final AtomicBoolean Ea = new AtomicBoolean(false);
    final AtomicBoolean Dxv = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.KC) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    private void zPa() {
        try {
            if (this.uvo == null) {
                ea eaVar = new ea(this.Cc, this.zPa);
                this.uvo = eaVar;
                eaVar.setDislikeSource("landing_page");
                this.uvo.setCallback(new ea.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.6
                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(View view) {
                        TTVideoLandingPageLink2Activity.this.Ea.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void MY(View view) {
                        TTVideoLandingPageLink2Activity.this.Ea.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(FilterWord filterWord) {
                        if (TTVideoLandingPageLink2Activity.this.Dxv.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTVideoLandingPageLink2Activity.this.Dxv.set(true);
                        TTVideoLandingPageLink2Activity.this.cl();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.uvo);
            if (this.KC == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.Cc);
                this.KC = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTVideoLandingPageLink2Activity", th);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        rp rpVar = this.fdM;
        if (rpVar != null) {
            rpVar.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        oeT oet;
        com.bytedance.sdk.component.DmF.vCE vce;
        super.onCreate(bundle);
        if (!bWL.Cc() || (oet = this.zPa) == null || (vce = ((TTVideoLandingPageActivity) this).IlO) == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.common.tV tVVarIlO = zLG.IlO(oet, vce, this.Cc, this.dY);
        this.qvT = tVVarIlO;
        if (tVVarIlO != null) {
            tVVarIlO.IlO("landingpage_split_screen");
        }
        this.pFe = cl.tV().xF();
        if (((TTVideoLandingPageActivity) this).IlO.getWebView() != null) {
            ((TTVideoLandingPageActivity) this).IlO.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i2, int i8, int i9, int i10) {
                    EV ev = TTVideoLandingPageLink2Activity.this.BS;
                    if (ev != null) {
                        ev.MY(i8);
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this.Cc, this.NV, this.lEW, this.qvT, this.BS, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.hL != null && !TTVideoLandingPageLink2Activity.this.wD) {
                        TTVideoLandingPageLink2Activity.this.hL.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.qz != null) {
                        TTVideoLandingPageLink2Activity.this.qz.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.Tx = true;
                    TTVideoLandingPageLink2Activity.this.bWL();
                    TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(tTVideoLandingPageLink2Activity.zPa, tTVideoLandingPageLink2Activity.dY, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.HTA, true);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                TTVideoLandingPageLink2Activity.this.HTA = System.currentTimeMillis();
            }
        };
        this.BO = cc;
        cc.IlO(this.zPa);
        ((TTVideoLandingPageActivity) this).IlO.setWebViewClient(this.BO);
        ((TTVideoLandingPageActivity) this).IlO.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.NV, this.BS, this.qvT) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.8
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                if (TTVideoLandingPageLink2Activity.this.pFe && TTVideoLandingPageLink2Activity.this.Hg != null && i2 == 100) {
                    TTVideoLandingPageLink2Activity.this.Hg.IlO(webView, TTVideoLandingPageLink2Activity.this.AK);
                }
                if (TTVideoLandingPageLink2Activity.this.fdM != null) {
                    TTVideoLandingPageLink2Activity.this.fdM.IlO(i2);
                }
            }
        });
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.lQ);
        if (textView != null && this.zPa.ea() != null) {
            textView.setText(this.zPa.ea().Cc());
        }
        oeT oet2 = this.zPa;
        bWL.EO().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTVideoLandingPageLink2Activity.this.wD = true;
                    if (TTVideoLandingPageLink2Activity.this.fdM != null) {
                        TTVideoLandingPageLink2Activity.this.fdM.MY();
                    }
                    TTVideoLandingPageLink2Activity.this.Jz.setVisibility(0);
                    if (TTVideoLandingPageLink2Activity.this.ts != null) {
                        TTVideoLandingPageLink2Activity.this.ts.setVisibility(0);
                    }
                    if (TTVideoLandingPageLink2Activity.this.Tx) {
                        return;
                    }
                    TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(tTVideoLandingPageLink2Activity.zPa, tTVideoLandingPageLink2Activity.dY, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.HTA, false);
                } catch (Exception unused) {
                }
            }
        }, (oet2 == null || oet2.ea() == null) ? WorkRequest.MIN_BACKOFF_MILLIS : this.zPa.ea().IlO() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        bWL();
        if (!this.wD && this.BS != null && ((TTVideoLandingPageActivity) this).IlO != null && this.fdM.getVisibility() == 8) {
            this.BS.IlO(((TTVideoLandingPageActivity) this).IlO);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        rp rpVar = this.fdM;
        if (rpVar != null) {
            rpVar.MY();
        }
    }

    private void ea() {
        TTAdDislikeToast tTAdDislikeToast = this.KC;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp() {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.zPa, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public boolean Cc() {
        int i2 = this.hp;
        return i2 == 5 || i2 == 15 || i2 == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void DmF() {
        super.DmF();
        oeT oet = this.zPa;
        if (oet != null) {
            oet.vCE(true);
        }
        TextView textView = this.ii;
        if (textView != null) {
            textView.setText(MY());
            this.ii.setClickable(true);
            this.ii.setOnClickListener(this.quf);
            this.ii.setOnTouchListener(this.quf);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void EO() {
        TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity;
        super.EO();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(pP.IlO(cl.IlO(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoLandingPageLink2Activity.this.rp();
                }
            });
        }
        this.nm = (TextView) findViewById(520093714);
        this.fdM = (rp) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.KC);
        this.hL = findViewById(com.bytedance.sdk.openadsdk.utils.zPa.uvo);
        this.Jz = findViewById(com.bytedance.sdk.openadsdk.utils.zPa.mmj);
        TextView textView2 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Dxv);
        TextView textView3 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.fdM);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpa = (com.bytedance.sdk.openadsdk.core.widget.zPa) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Ea);
        this.ii = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.hL);
        if (this.zPa.HTA() != null && !TextUtils.isEmpty(this.zPa.HTA().IlO())) {
            Bc.IlO().IlO(this.zPa.HTA(), zpa, this.zPa);
        }
        textView2.setText(this.zPa.hL());
        textView3.setText(this.zPa.gm());
        View viewFindViewById = findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Jz);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity2 = TTVideoLandingPageLink2Activity.this;
                TTWebsiteActivity.IlO(tTVideoLandingPageLink2Activity2.Cc, tTVideoLandingPageLink2Activity2.zPa, tTVideoLandingPageLink2Activity2.dY);
            }
        });
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.zPa);
        }
        com.bytedance.sdk.component.DmF.vCE vce = ((TTVideoLandingPageActivity) this).IlO;
        if (vce != null && vce.getWebView() != null) {
            zLG.IlO(this.zPa, ((TTVideoLandingPageActivity) this).IlO);
        }
        boolean zXF = cl.tV().xF();
        this.pFe = zXF;
        if (zXF) {
            ((com.bytedance.sdk.openadsdk.common.bWL) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.nm)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.zPa.dm);
            this.qz = linearLayout;
            linearLayout.setVisibility(8);
            tTVideoLandingPageLink2Activity = this;
            tTVideoLandingPageLink2Activity.Hg = new zPa(tTVideoLandingPageLink2Activity, this.qz, ((TTVideoLandingPageActivity) this).IlO, this.zPa, "landingpage_split_screen");
            if (((TTVideoLandingPageActivity) tTVideoLandingPageLink2Activity).IlO.getWebView() != null) {
                ((TTVideoLandingPageActivity) tTVideoLandingPageLink2Activity).IlO.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.14
                    float IlO = 0.0f;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.IlO = motionEvent.getY();
                        }
                        EV ev = TTVideoLandingPageLink2Activity.this.BS;
                        if (ev != null) {
                            ev.IlO(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.qvT != null) {
                            TTVideoLandingPageLink2Activity.this.qvT.IlO(motionEvent);
                        }
                        if (motionEvent.getAction() == 2) {
                            float y = motionEvent.getY();
                            float f4 = this.IlO;
                            if (y - f4 > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.Hg != null) {
                                    TTVideoLandingPageLink2Activity.this.Hg.IlO();
                                }
                                return false;
                            }
                            if (y - f4 < -8.0f && TTVideoLandingPageLink2Activity.this.Hg != null) {
                                TTVideoLandingPageLink2Activity.this.Hg.MY();
                            }
                        }
                        return false;
                    }
                });
            }
        } else {
            tTVideoLandingPageLink2Activity = this;
            if (((TTVideoLandingPageActivity) tTVideoLandingPageLink2Activity).IlO.getWebView() != null) {
                ((TTVideoLandingPageActivity) tTVideoLandingPageLink2Activity).IlO.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        EV ev = TTVideoLandingPageLink2Activity.this.BS;
                        if (ev != null) {
                            ev.IlO(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.qvT == null) {
                            return false;
                        }
                        TTVideoLandingPageLink2Activity.this.qvT.IlO(motionEvent);
                        return false;
                    }
                });
            }
        }
        rp rpVar = tTVideoLandingPageLink2Activity.fdM;
        if (rpVar != null) {
            rpVar.IlO(tTVideoLandingPageLink2Activity.zPa);
        }
    }

    public void rp() {
        if (isFinishing()) {
            return;
        }
        if (this.Dxv.get()) {
            ea();
            return;
        }
        if (this.uvo == null) {
            zPa();
        }
        ea eaVar = this.uvo;
        if (eaVar != null) {
            eaVar.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void tV() {
        if (!Cc()) {
            try {
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Bc.IlO().IlO(this.zPa.Hg().get(0), imageView, this.zPa);
                this.rp.setVisibility(0);
                this.rp.removeAllViews();
                this.rp.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.bytedance.sdk.openadsdk.tV.EO.MY(TTVideoLandingPageLink2Activity.this.zPa, "landingpage_split_screen");
                    }
                });
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.tV();
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.bWL;
        if (vce != null) {
            if (vce.getNativeVideoController() != null) {
                this.bWL.getNativeVideoController().IlO(false);
                this.bWL.getNativeVideoController().vCE(false);
                this.rp.setClickable(true);
                this.rp.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        TTVideoLandingPageLink2Activity.this.hp();
                        return false;
                    }
                });
            }
            this.bWL.getNativeVideoController().IlO(new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.4
                @Override // w.b
                public void IlO() {
                }

                @Override // w.b
                public void IlO(long j, int i2) {
                }

                @Override // w.b
                public void IlO(long j, long j3) {
                    if (TTVideoLandingPageLink2Activity.this.nm != null) {
                        int iMax = (int) Math.max(0L, (j3 - j) / 1000);
                        TTVideoLandingPageLink2Activity.this.nm.setText(String.valueOf(iMax));
                        if (iMax <= 0) {
                            TTVideoLandingPageLink2Activity.this.nm.setVisibility(8);
                        }
                    }
                }

                @Override // w.b
                public void MY(long j, int i2) {
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public View IlO() {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this);
        if (Build.VERSION.SDK_INT >= 35) {
            cc.setFitsSystemWindows(true);
        }
        cc.setOrientation(1);
        cc.setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        cc.addView(eo, new LinearLayout.LayoutParams(-1, BS.MY(this, 220.0f)));
        View eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        eo2.setId(com.bytedance.sdk.openadsdk.utils.zPa.DM);
        eo.addView(eo2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this);
        cc2.setOrientation(0);
        cc2.setPadding(0, BS.MY(this, 20.0f), 0, 0);
        eo.addView(cc2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        cc2.addView(view, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.bWL bwl = new com.bytedance.sdk.openadsdk.core.widget.bWL(this);
        bwl.setId(520093713);
        bwl.setGravity(17);
        bwl.setText(pP.IlO(this, "tt_reward_feedback"));
        bwl.setTextColor(-1);
        bwl.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, BS.MY(this, 28.0f));
        int iMY = BS.MY(this, 16.0f);
        layoutParams2.rightMargin = iMY;
        layoutParams2.leftMargin = iMY;
        cc2.addView(bwl, layoutParams2);
        hp hpVar = new hp(this);
        hpVar.setId(com.bytedance.sdk.openadsdk.utils.zPa.zLG);
        hpVar.setPadding(BS.MY(this, 7.0f), BS.MY(this, 7.0f), BS.MY(this, 7.0f), BS.MY(this, 7.0f));
        hpVar.setImageResource(pP.tV(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(BS.MY(this, 28.0f), BS.MY(this, 28.0f));
        layoutParams3.rightMargin = BS.MY(this, 12.0f);
        cc2.addView(hpVar, layoutParams3);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(this);
        bc.setVisibility(8);
        bc.setId(com.bytedance.sdk.openadsdk.utils.zPa.BS);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = BS.MY(this, 10.0f);
        cc.addView(bc, layoutParams4);
        com.bytedance.sdk.openadsdk.core.widget.IlO ilO = new com.bytedance.sdk.openadsdk.core.widget.IlO(this);
        ilO.setId(com.bytedance.sdk.openadsdk.utils.zPa.ssS);
        ilO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ilO.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BS.MY(this, 44.0f), BS.MY(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = BS.MY(this, 5.0f);
        bc.addView(ilO, layoutParams5);
        lEW lew = new lEW(this);
        int i2 = com.bytedance.sdk.openadsdk.utils.zPa.gQ;
        lew.setId(i2);
        lew.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_circle_solid_mian"));
        lew.setGravity(17);
        lew.setTextColor(-1);
        lew.setTextSize(2, 19.0f);
        lew.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(BS.MY(this, 44.0f), BS.MY(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = BS.MY(this, 5.0f);
        bc.addView(lew, layoutParams6);
        lEW lew2 = new lEW(this);
        lew2.setId(com.bytedance.sdk.openadsdk.utils.zPa.HSR);
        lew2.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew2.setEllipsize(truncateAt);
        lew2.setTextColor(Color.parseColor("#e5000000"));
        lew2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = BS.MY(this, 5.0f);
        layoutParams7.rightMargin = BS.MY(this, 80.0f);
        layoutParams7.addRule(1, i2);
        bc.addView(lew2, layoutParams7);
        lEW lew3 = new lEW(this);
        lew3.setId(com.bytedance.sdk.openadsdk.utils.zPa.AK);
        lew3.setClickable(true);
        lew3.setMaxLines(1);
        lew3.setEllipsize(truncateAt);
        lew3.setFocusable(true);
        lew3.setGravity(17);
        lew3.setText(pP.IlO(this, "tt_video_mobile_go_detail"));
        lew3.setTextColor(-1);
        lew3.setTextSize(2, 14.0f);
        lew3.setPadding(BS.MY(this, 2.0f), BS.MY(this, 2.0f), BS.MY(this, 2.0f), BS.MY(this, 2.0f));
        lew3.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(BS.MY(this, 90.0f), BS.MY(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = BS.MY(this, 5.0f);
        bc.addView(lew3, layoutParams8);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(this);
        cc.addView(eo3, new LinearLayout.LayoutParams(-1, -1));
        View vce = new com.bytedance.sdk.component.DmF.vCE(this);
        vce.setId(com.bytedance.sdk.openadsdk.utils.zPa.quf);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = BS.MY(this, 2.0f);
        eo3.addView(vce, layoutParams9);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc2 = new com.bytedance.sdk.openadsdk.core.Cc.Bc(this);
        bc2.setId(com.bytedance.sdk.openadsdk.utils.zPa.uvo);
        bc2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        eo3.addView(bc2, new FrameLayout.LayoutParams(-1, -1));
        View rpVar = new rp(this);
        rpVar.setId(com.bytedance.sdk.openadsdk.utils.zPa.KC);
        bc2.addView(rpVar, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this);
        cc3.setId(com.bytedance.sdk.openadsdk.utils.zPa.mmj);
        cc3.setOrientation(1);
        cc3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        bc2.addView(cc3, layoutParams10);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpa = new com.bytedance.sdk.openadsdk.core.widget.zPa(this);
        zpa.setId(com.bytedance.sdk.openadsdk.utils.zPa.Ea);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(BS.MY(this, 80.0f), BS.MY(this, 80.0f));
        layoutParams11.gravity = 17;
        cc3.addView(zpa, layoutParams11);
        lEW lew4 = new lEW(this);
        lew4.setId(com.bytedance.sdk.openadsdk.utils.zPa.Dxv);
        lew4.setTextColor(Color.parseColor("#161823"));
        lew4.setTextSize(0, BS.MY(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = BS.MY(this, 12.0f);
        cc3.addView(lew4, layoutParams12);
        lEW lew5 = new lEW(this);
        lew5.setId(com.bytedance.sdk.openadsdk.utils.zPa.fdM);
        lew5.setTextColor(Color.parseColor("#80161823"));
        lew5.setTextSize(0, BS.MY(this, 16.0f));
        lew5.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int iMY2 = BS.MY(this, 60.0f);
        layoutParams13.rightMargin = iMY2;
        layoutParams13.leftMargin = iMY2;
        layoutParams13.topMargin = BS.MY(this, 8.0f);
        cc3.addView(lew5, layoutParams13);
        lEW lew6 = new lEW(this);
        lew6.setId(com.bytedance.sdk.openadsdk.utils.zPa.hL);
        lew6.setGravity(17);
        lew6.setTextColor(-1);
        lew6.setText(pP.IlO(this, "tt_video_mobile_go_detail"));
        lew6.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(BS.MY(this, 255.0f), BS.MY(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = BS.MY(this, 32.0f);
        cc3.addView(lew6, layoutParams14);
        PAGLogoView pAGLogoView = new PAGLogoView(this);
        this.ts = pAGLogoView;
        pAGLogoView.setId(com.bytedance.sdk.openadsdk.utils.zPa.Jz);
        this.ts.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, BS.MY(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = BS.MY(this, 18.0f);
        layoutParams15.bottomMargin = BS.MY(this, 61.0f);
        bc2.addView(this.ts, layoutParams15);
        View bwl2 = new com.bytedance.sdk.openadsdk.common.bWL(this, new bWL.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.10
            @Override // com.bytedance.sdk.openadsdk.common.bWL.IlO
            public View IlO(Context context) {
                return new com.bytedance.sdk.openadsdk.common.Bc(context);
            }
        });
        bwl2.setId(com.bytedance.sdk.openadsdk.utils.zPa.wD);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, BS.MY(this, 48.0f));
        layoutParams16.gravity = 81;
        eo3.addView(bwl2, layoutParams16);
        View bwl3 = new com.bytedance.sdk.openadsdk.common.bWL(this, new bWL.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.11
            @Override // com.bytedance.sdk.openadsdk.common.bWL.IlO
            public View IlO(Context context) {
                return new com.bytedance.sdk.openadsdk.common.lEW(context);
            }
        });
        bwl3.setId(com.bytedance.sdk.openadsdk.utils.zPa.nm);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, BS.MY(this, 44.0f));
        layoutParams17.gravity = 80;
        eo3.addView(bwl3, layoutParams17);
        return cc;
    }
}
