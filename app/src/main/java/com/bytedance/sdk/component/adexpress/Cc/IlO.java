package com.bytedance.sdk.component.adexpress.Cc;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.adexpress.MY.Bc;
import com.bytedance.sdk.component.adexpress.MY.EV;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.MY.lEW;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.bWL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO implements com.bytedance.sdk.component.adexpress.IlO, EV, com.bytedance.sdk.component.adexpress.MY.tV<vCE>, com.bytedance.sdk.component.adexpress.theme.IlO {
    private String Bc;
    private volatile Bc DmF;
    protected vCE EO;
    private lEW EV;
    protected JSONObject IlO;
    protected boolean MY;
    private boolean NV;
    private int bWL;
    private boolean hp;
    private String lEW;
    private hp rp;
    private Context vCE;
    protected int tV = 8;
    protected AtomicBoolean Cc = new AtomicBoolean(false);
    private boolean ea = false;

    public IlO(Context context, hp hpVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.NV = false;
        this.vCE = context;
        this.rp = hpVar;
        this.Bc = hpVar.tV();
        themeStatusBroadcastReceiver.IlO(this);
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            rp();
            return;
        }
        vCE vceHp = hp();
        this.EO = vceHp;
        if (vceHp != null) {
            this.NV = true;
            Log.d("WebViewRender", "initWebView: reuse WebView");
        } else {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (com.bytedance.sdk.component.adexpress.tV.IlO() != null) {
                this.EO = new vCE(com.bytedance.sdk.component.adexpress.tV.IlO());
            }
        }
    }

    private void bWL() {
        if (this.rp.vAh()) {
            Cc.IlO().MY(this.EO);
        } else {
            Cc.IlO().EO(this.EO);
        }
    }

    private vCE hp() {
        return this.rp.vAh() ? Cc.IlO().IlO(this.vCE, this.Bc) : Cc.IlO().MY(this.vCE, this.Bc);
    }

    private void rp() {
        if (this.vCE == null && com.bytedance.sdk.component.adexpress.tV.IlO() != null) {
            this.vCE = com.bytedance.sdk.component.adexpress.tV.IlO();
        }
        if (this.vCE != null) {
            vCE vceHp = hp();
            this.EO = vceHp;
            if (vceHp == null) {
                Log.d("WebViewRender", "initWebView: create WebView by act");
                this.EO = new vCE(new MutableContextWrapper(this.vCE.getApplicationContext()));
            } else {
                this.NV = true;
                Log.d("WebViewRender", "initWebView: reuse WebView");
            }
        }
    }

    public abstract void Bc();

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public int EO() {
        return 0;
    }

    public hp EV() {
        return this.rp;
    }

    public abstract void IlO(int i2);

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public vCE Cc() {
        return IlO();
    }

    public void lEW() {
        DmF();
        Activity activityIlO = com.bytedance.sdk.component.utils.MY.IlO(this.EO);
        if (activityIlO != null) {
            this.bWL = MY(activityIlO);
        }
    }

    public void tV() {
        if (this.Cc.get()) {
            return;
        }
        this.Cc.set(true);
        Bc();
        if (this.EO.getParent() != null) {
            ((ViewGroup) this.EO.getParent()).removeView(this.EO);
        }
        if (this.MY) {
            bWL();
        } else {
            Cc.IlO().Cc(this.EO);
        }
    }

    public void vCE() {
        if (IlO() == null) {
            return;
        }
        try {
            IlO().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    private int MY(Activity activity) {
        return activity.hashCode();
    }

    public void IlO(String str) {
        this.lEW = str;
    }

    public vCE IlO() {
        return this.EO;
    }

    public void MY(boolean z2) {
        this.ea = z2;
    }

    public void IlO(lEW lew) {
        this.EV = lew;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(Bc bc) {
        this.DmF = bc;
        if (IlO() != null && IlO().getWebView() != null) {
            if (TextUtils.isEmpty(this.lEW)) {
                this.DmF.IlO(102, "url is empty");
                return;
            }
            if (!this.rp.vAh()) {
                if (!this.ea && !com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(this.IlO)) {
                    Bc bc2 = this.DmF;
                    StringBuilder sb = new StringBuilder("data null is ");
                    sb.append(this.IlO == null);
                    bc2.IlO(103, sb.toString());
                    return;
                }
                if (this.ea && !com.bytedance.sdk.component.adexpress.IlO.MY.MY.EO(this.IlO)) {
                    Bc bc3 = this.DmF;
                    StringBuilder sb2 = new StringBuilder("choice ad data null is ");
                    sb2.append(this.IlO == null);
                    bc3.IlO(103, sb2.toString());
                    return;
                }
            } else if (EO() == 9 && !com.bytedance.sdk.component.adexpress.IlO.MY.MY.MY(this.IlO)) {
                Bc bc4 = this.DmF;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.IlO == null);
                bc4.IlO(103, sb3.toString());
                return;
            }
            this.rp.Cc().IlO(this.NV);
            if (this.NV) {
                try {
                    this.EO.cl();
                    this.rp.Cc();
                    bWL.IlO(this.EO.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception e) {
                    Cc.IlO().Cc(this.EO);
                    this.DmF.IlO(102, "load exception is " + e.getMessage());
                    return;
                }
            }
            vCE vceIlO = IlO();
            vceIlO.cl();
            this.rp.Cc();
            vceIlO.a_(this.lEW);
            return;
        }
        Bc bc5 = this.DmF;
        StringBuilder sb4 = new StringBuilder("SSWebview null is ");
        sb4.append(IlO() == null);
        sb4.append(" or Webview is null");
        bc5.IlO(102, sb4.toString());
    }

    public void DmF() {
    }

    public void NV() {
    }

    public void IlO(boolean z2) {
        this.hp = z2;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(final com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        if (bwl == null) {
            if (this.DmF != null) {
                this.DmF.IlO(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zEO = bwl.EO();
        final float fTV = (float) bwl.tV();
        final float fCc = (float) bwl.Cc();
        if (EO() == 0 && (fTV <= 0.0f || fCc <= 0.0f)) {
            if (this.DmF != null) {
                this.DmF.IlO(105, "width is " + fTV + "height is " + fCc);
                return;
            }
            return;
        }
        this.MY = zEO;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IlO(bwl, fTV, fCc);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.Cc.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.IlO(bwl, fTV, fCc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl, float f4, float f8) {
        bwl.EV();
        boolean z2 = this.MY;
        if (z2 && !this.hp) {
            IlO(f4, f8);
            IlO(this.tV);
            if (this.DmF != null) {
                this.DmF.IlO(IlO(), bwl);
                return;
            }
            return;
        }
        if (!z2) {
            Cc.IlO().Cc(this.EO);
        }
        IlO(bwl.EV(), bwl.NV());
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
        lEW lew = this.EV;
        if (lew != null) {
            lew.IlO(view, i2, eo);
        }
    }

    @UiThread
    private void IlO(float f4, float f8) {
        this.rp.Cc().Cc();
        if (EO() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) IlO().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            IlO().setLayoutParams(layoutParams);
            return;
        }
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.vCE, f4);
        int iIlO2 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.vCE, f8);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) IlO().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iIlO, iIlO2);
        }
        layoutParams2.width = iIlO;
        layoutParams2.height = iIlO2;
        IlO().setLayoutParams(layoutParams2);
    }

    private void IlO(int i2, String str) {
        if (this.DmF != null) {
            this.DmF.IlO(i2, str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.IlO
    public void IlO(Activity activity) {
        if (this.bWL == 0 || activity == null || activity.hashCode() != this.bWL) {
            return;
        }
        tV();
        NV();
    }

    public void IlO(JSONObject jSONObject) {
        this.IlO = jSONObject;
    }
}
