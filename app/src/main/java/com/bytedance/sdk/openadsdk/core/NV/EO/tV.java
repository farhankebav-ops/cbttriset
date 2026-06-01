package com.bytedance.sdk.openadsdk.core.NV.EO;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.adexpress.MY.EV;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.ea;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.core.widget.IlO.Cc;
import com.bytedance.sdk.openadsdk.utils.ssS;
import com.bytedance.sdk.openadsdk.utils.xF;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements EV, EO<vCE> {
    private int Bc;
    private String Cc;
    private vCE EO;
    private Context IlO;
    private oeT MY;
    private vSq tV;
    private IlO vCE;

    public tV(Context context, oeT oet) {
        this.Bc = 1;
        this.IlO = context;
        this.MY = oet;
        this.Bc = oet.BES();
        this.Cc = ea.MY(this.MY).IlO(this.Bc == 1);
    }

    private void Bc() {
        this.EO.setBackgroundColor(0);
        this.EO.setBackgroundResource(R.color.transparent);
        this.EO.setVisibility(8);
        IlO(this.EO);
        if (this.MY != null) {
            this.EO.setWebViewClient(new Cc(this.IlO, this.tV, this.MY.ED(), null, false));
        }
        com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().IlO(this.EO, this.tV);
        this.EO.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.tV));
    }

    private void lEW() {
        vSq vsq = new vSq(this.IlO);
        this.tV = vsq;
        vsq.MY(this.EO).IlO(this.MY).EO(this.MY.ED()).tV(this.MY.KT()).Cc(this.MY.tcT()).IlO(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(0.0f, 0.0f, false, this.MY, null, null)).IlO(this).IlO(this.EO);
    }

    public vSq Cc() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    public void EO() {
        vSq vsq = this.tV;
        if (vsq != null) {
            vsq.EO();
        }
        this.tV = null;
        try {
            vCE vce = this.EO;
            if (vce != null) {
                ViewGroup viewGroup = (ViewGroup) vce.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.EO);
                }
                this.EO.zPa();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    public void MY() {
        if (TextUtils.isEmpty(this.Cc)) {
            this.EO.setVisibility(8);
        } else {
            this.EO.a_(this.Cc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    /* JADX INFO: renamed from: vCE, reason: merged with bridge method [inline-methods] */
    public vCE tV() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(bWL bwl) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    public void IlO() {
        this.EO = new vCE(this.IlO);
        Bc();
        lEW();
        ssS.IlO(this.EO, false, this.MY.fHv(), false, new ssS.MY() { // from class: com.bytedance.sdk.openadsdk.core.NV.EO.tV.1
            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO(View view, boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void MY() {
                tV.this.IlO(false);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO(boolean z2) {
                tV.this.IlO(z2);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO() {
                tV.this.IlO(true);
            }
        }, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    public void IlO(IlO ilO) {
        this.vCE = ilO;
    }

    private void IlO(vCE vce) {
        if (vce == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.IlO).IlO(false).IlO(vce.getWebView());
            vce.setVerticalScrollBarEnabled(false);
            vce.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(vce);
            vce.bWL();
            vce.setUserAgentString(xF.IlO(vce.getWebView(), BuildConfig.VERSION_CODE));
            vce.setMixedContentMode(0);
            vce.setJavaScriptEnabled(true);
            vce.setJavaScriptCanOpenWindowsAutomatically(true);
            vce.setDomStorageEnabled(true);
            vce.setDatabaseEnabled(true);
            vce.setAllowFileAccess(false);
            vce.setSupportZoom(true);
            vce.setBuiltInZoomControls(true);
            vce.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            vce.setUseWideViewPort(true);
            vce.setCacheMode(-1);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.EO.EO
    public void IlO(com.bytedance.sdk.openadsdk.core.lEW.bWL bwl) {
        vSq vsq = this.tV;
        if (vsq != null) {
            vsq.IlO(bwl);
        }
    }

    public void IlO(boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", !z2 ? 1 : 0);
        } catch (Exception e) {
            e.getMessage();
        }
        this.tV.IlO("visibleStateChange", jSONObject);
    }
}
