package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp {
    private es Bc;
    private ImageView Cc;
    private final Context EO;
    private final oeT IlO;
    private RelativeLayout MY;
    private zPa lEW;
    private com.bytedance.sdk.component.DmF.vCE tV;
    private final String vCE;

    public hp(Context context, oeT oet, String str) {
        this.EO = context;
        this.IlO = oet;
        this.vCE = str;
        vCE();
    }

    private static RelativeLayout IlO(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new DmF(context));
        com.bytedance.sdk.component.DmF.vCE vce = new com.bytedance.sdk.component.DmF.vCE(context);
        vce.setId(com.bytedance.sdk.openadsdk.utils.zPa.quf);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, com.bytedance.sdk.openadsdk.utils.zPa.Hg);
        relativeLayout.addView(vce, layoutParams);
        lEW lew = new lEW(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(lew.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(lew, layoutParams2);
        return relativeLayout;
    }

    private void vCE() {
        RelativeLayout relativeLayoutIlO = IlO(this.EO);
        this.MY = relativeLayoutIlO;
        this.tV = (com.bytedance.sdk.component.DmF.vCE) relativeLayoutIlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.quf);
        es esVar = new es(this.EO, (RelativeLayout) this.MY.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Hg), this.IlO);
        this.Bc = esVar;
        this.Cc = esVar.EO();
        this.lEW = new zPa(this.EO, (LinearLayout) this.MY.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.dm), this.tV, this.IlO, this.vCE);
    }

    public View Cc() {
        return this.MY;
    }

    public ImageView EO() {
        return this.Cc;
    }

    public void MY() {
        es esVar = this.Bc;
        if (esVar != null) {
            esVar.MY();
        }
        zPa zpa = this.lEW;
        if (zpa != null) {
            zpa.MY();
        }
    }

    public com.bytedance.sdk.component.DmF.vCE tV() {
        return this.tV;
    }

    public void IlO() {
        es esVar = this.Bc;
        if (esVar != null) {
            esVar.IlO();
        }
        zPa zpa = this.lEW;
        if (zpa != null) {
            zpa.IlO();
        }
    }

    public void IlO(WebView webView, int i2, vCE.IlO ilO) {
        es esVar = this.Bc;
        if (esVar != null) {
            esVar.IlO(i2);
        }
        zPa zpa = this.lEW;
        if (zpa != null) {
            zpa.IlO(webView, ilO);
        }
    }
}
