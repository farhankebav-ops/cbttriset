package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.zPa;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends MY {
    private String cL;
    private com.bytedance.sdk.openadsdk.component.reward.view.Cc cl;
    private final int ea;
    private ViewGroup zPa;

    public lEW(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
        this.cL = "fullscreen_interstitial_ad";
        this.ea = this.MY.uI();
    }

    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE EO(oeT oet) {
        if (oet.Jz() == 4) {
            return new com.bytedance.sdk.openadsdk.es.IlO.IlO.tV(cl.IlO(), oet, this.cL);
        }
        return null;
    }

    private void IlO(ImageView imageView) {
        List<zPa> listHg;
        zPa zpa;
        oeT oet = this.MY;
        if (oet == null || (listHg = oet.Hg()) == null || listHg.size() <= 0 || (zpa = listHg.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(listHg.get(0)).EO(1).IlO(com.bytedance.sdk.openadsdk.DmF.EO.IlO(this.MY, zpa.IlO(), imageView));
    }

    private void MY(oeT oet) {
        if (oet == null || this.cl == null) {
            return;
        }
        dY();
        IlO((ImageView) this.cl);
    }

    private void dY() {
        zPa zpa;
        List<zPa> listHg = this.MY.Hg();
        if (listHg == null || listHg.size() <= 0 || (zpa = listHg.get(0)) == null) {
            return;
        }
        try {
            int iMY = zpa.MY();
            int iEO = zpa.EO();
            if (iMY != 0 && iEO != 0) {
                this.cl.setRatio(iMY / iEO);
                return;
            }
            int i2 = this.ea;
            if (i2 == 33) {
                this.cl.setRatio(1.0f);
            } else if (i2 == 3) {
                this.cl.setRatio(1.91f);
            } else {
                this.cl.setRatio(0.56f);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.RFTI", e.getMessage());
        }
    }

    private boolean lMM() {
        oeT oet = this.MY;
        return oet != null && oet.oc() == 2;
    }

    private void oc() {
        FrameLayout frameLayout = new FrameLayout(this.IlO.BS);
        this.zPa = frameLayout;
        frameLayout.setId(com.bytedance.sdk.openadsdk.utils.zPa.hjY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.zPa.setLayoutParams(layoutParams);
        View viewEV = this.IlO.DM.EV();
        if (viewEV != null) {
            layoutParams.bottomMargin = viewEV.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.Cc cc = new com.bytedance.sdk.openadsdk.component.reward.view.Cc(this.IlO.BS);
        this.cl = cc;
        cc.setId(com.bytedance.sdk.openadsdk.utils.zPa.tN);
        FrameLayout.LayoutParams layoutParams2 = this.IlO.MY.BES() == 1 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        this.cl.setLayoutParams(layoutParams2);
        this.zPa.addView(this.cl);
        vSq();
    }

    private void vSq() {
        if (this.zPa == null) {
            return;
        }
        IlO((View) this.cl);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
        if (es.MY(this.MY)) {
            this.vCE.MY(8);
        }
        this.lEW.EO(false);
        this.lEW.tV(false);
        if (this.MY.oc() == 2) {
            this.lEW.IlO(false);
            this.vCE.Cc(8);
            return;
        }
        this.lEW.IlO(this.MY.uF());
        if (this.IlO.qvT) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            int iYA = (int) (ilO.vAh.YA() * 1000.0d);
            ilO.DmF = iYA;
            messageObtain.arg1 = iYA;
            this.IlO.HSR.sendMessage(messageObtain);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return lMM() || OOq.Bc(this.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        return lMM();
    }

    public void IlO(View view) {
        if (view == null || this.IlO.BS == null || this.MY == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.MY.MY ilO = this.rp;
        if (ilO == null) {
            Activity activity = this.IlO.BS;
            oeT oet = this.MY;
            String str = this.cL;
            ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(activity, oet, str, zLG.IlO(str));
            ilO.IlO(EO(this.MY));
            HashMap map = new HashMap();
            if (OOq.cL(this.MY)) {
                map.put("click_scence", 3);
            } else {
                map.put("click_scence", 1);
            }
            ilO.IlO(map);
        }
        Activity activity2 = this.IlO.BS;
        if (activity2 != null) {
            ilO.IlO(activity2);
        }
        view.setOnTouchListener(ilO);
        view.setOnClickListener(ilO);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
        try {
            oc();
            MY(this.MY);
            frameLayout.addView(this.zPa);
        } catch (Exception e) {
            Log.e("TTAD.RFTI", "bindAd: ", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        if (es.MY(this.MY)) {
            tV.IlO(bc, this.MY);
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            ilO.ts.IlO((long) (ilO.vAh.YA() * 1000.0d));
        } else {
            if (!es.tV(this.MY) && !es.Cc(this.MY)) {
                super.IlO(bc);
                return;
            }
            tV.MY(bc, this.MY);
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
            ilO2.ts.IlO((long) (ilO2.vAh.YA() * 1000.0d));
        }
    }

    public static boolean IlO(oeT oet) {
        return !oeT.Cc(oet) && oet.La() == 100.0f;
    }
}
