package com.bytedance.sdk.openadsdk.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements vSq.IlO {
    private EO Cc;
    private int DmF;
    private WebView EO;
    private final oeT IlO;
    private final boolean MY;
    private long NV;
    private boolean bWL;
    private long ea;
    private int es;
    private int hp;
    private float lEW;
    private final com.bytedance.sdk.component.DmF.vCE tV;
    private String xF;
    private boolean zPa;
    private String vCE = "landingpage";
    private final Handler Bc = new vSq(com.bytedance.sdk.openadsdk.core.bWL.MY().getLooper(), this);
    private final AtomicBoolean EV = new AtomicBoolean(false);
    private Pattern rp = null;
    private long cL = -1;
    private final List<Integer> cl = new ArrayList();

    public tV(oeT oet, com.bytedance.sdk.component.DmF.vCE vce, String str, boolean z2) {
        this.IlO = oet;
        this.tV = vce;
        this.MY = z2;
        MY();
    }

    private int Bc() {
        try {
            return this.EO.copyBackForwardList().getCurrentIndex() + 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        this.bWL = false;
        if (this.EV.getAndSet(true)) {
            return;
        }
        this.NV = SystemClock.elapsedRealtime();
        this.ea = System.currentTimeMillis();
        lEW();
        if (this.Cc == null) {
            return;
        }
        WebView webView = this.EO;
        if (webView != null) {
            this.xF = webView.getUrl();
        }
        this.Cc.setVisibility(0);
        this.Cc.IlO(this.IlO);
        this.Cc.IlO();
        this.Cc.setAlpha(this.lEW);
        this.Cc.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.common.tV.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        tV();
        EO();
    }

    private void MY() {
        com.bytedance.sdk.component.DmF.vCE vce = this.tV;
        if (vce != null) {
            this.EO = vce.getWebView();
            View arbitrageLoadingView = this.tV.getArbitrageLoadingView();
            if (arbitrageLoadingView instanceof EO) {
                this.Cc = (EO) arbitrageLoadingView;
            }
        }
        this.DmF = com.bytedance.sdk.openadsdk.core.settings.hp.aP().uI();
        this.lEW = com.bytedance.sdk.openadsdk.core.settings.hp.aP().cJK();
    }

    private void lEW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loading_show_interval", SystemClock.elapsedRealtime() - this.cL);
            jSONObject.put("loading_show_timestamp", this.ea);
            WebView webView = this.EO;
            jSONObject.put("arbi_current_url", webView != null ? webView.getUrl() : "");
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.IlO, this.vCE, jSONObject);
    }

    private void tV() {
        Handler handler = this.Bc;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vCE() {
        return Bc() > 0 && !this.EV.get();
    }

    public void EO(WebView webView, String str, boolean z2) {
        this.cl.clear();
        this.zPa = z2;
        if (z2) {
            this.bWL = true;
        }
        this.es = Bc();
    }

    public void IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.vCE = str;
    }

    public void IlO(WebView webView, String str, boolean z2) {
        if (z2 && vCE()) {
            IlO();
        }
    }

    private void EO() {
        Handler handler = this.Bc;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, this.DmF);
        }
    }

    public void IlO(WebView webView, String str) {
        oeT oet = this.IlO;
        if (oet == null || !com.bytedance.sdk.component.DmF.MY.IlO(oet.cl().MY(), str)) {
            return;
        }
        this.hp++;
        com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.tV.1
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.vCE()) {
                    tV.this.IlO();
                }
            }
        });
    }

    public void MY(WebView webView, String str, boolean z2) {
        if (!z2 || this.Cc == null) {
            return;
        }
        IlO(1);
    }

    public void IlO(WebView webView, int i2) {
        EO eo = this.Cc;
        if (eo != null) {
            eo.IlO(i2);
        }
        if (this.zPa) {
            if (IlO(i2, 30)) {
                IlO(30, webView);
            }
            if (IlO(i2, 50)) {
                IlO(50, webView);
            }
            if (IlO(i2, 70)) {
                IlO(70, webView);
            }
        }
        if (this.Cc == null || i2 != 100) {
            return;
        }
        IlO(1);
    }

    public void IlO() {
        if (mmj.vCE()) {
            Cc();
        } else {
            com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.tV.2
                @Override // java.lang.Runnable
                public void run() {
                    tV.this.Cc();
                }
            });
        }
    }

    private void IlO(final int i2) {
        WebView webView = this.EO;
        if (webView != null && i2 == 1) {
            String url = webView.getUrl();
            if (TextUtils.isEmpty(url) || url.equals(this.xF)) {
                return;
            }
        }
        com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.tV.4
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.Cc != null) {
                    tV.this.EV.set(false);
                    tV.this.Cc.IlO(tV.this.IlO, tV.this.vCE, i2, tV.this.xF, tV.this.NV, tV.this.bWL, tV.this.hp, tV.this.ea);
                    tV.this.hp = 0;
                }
            }
        });
        tV();
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what == 1) {
            IlO(0);
        }
    }

    public void IlO(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cL = SystemClock.elapsedRealtime();
        }
    }

    private boolean IlO(int i2, int i8) {
        if (i2 < i8 || this.cl.contains(Integer.valueOf(i8)) || this.es < 2) {
            return false;
        }
        this.cl.add(Integer.valueOf(i8));
        return true;
    }

    private void IlO(int i2, WebView webView) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_progress", i2);
            jSONObject.put("progress_timestamp", System.currentTimeMillis());
            jSONObject.put("arbi_current_url", webView.getUrl());
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.EO(this.IlO, this.vCE, jSONObject);
    }
}
