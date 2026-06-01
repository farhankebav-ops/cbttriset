package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.bWL;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends MY {
    public tV(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    private static ImageView EO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        tVVar.setImageResource(pP.tV(context, "tt_up_slide"));
        tVVar.setId(zPa.vAh);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BS.MY(context, 18.0f), BS.MY(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = BS.MY(context, 45.0f);
        tVVar.setLayoutParams(layoutParams);
        return tVVar;
    }

    public static boolean IlO(oeT oet) {
        return es.MY(oet) || es.tV(oet) || es.Cc(oet);
    }

    private static LinearLayout MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setId(zPa.oeT);
        cc.setOrientation(1);
        cc.setVisibility(8);
        cc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return cc;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void hp() {
        com.bytedance.sdk.openadsdk.component.reward.view.NV nv;
        es esVar;
        if (es.MY(this.IlO.MY) && (nv = this.IlO.DM) != null && (esVar = nv.ea) != null) {
            if (esVar.tV()) {
                this.IlO.DM.MY(0);
                this.IlO.zPa.set(true);
            } else {
                this.IlO.cl.set(true);
                IlO(true, false, true, 80);
            }
        }
        if (es.tV(this.IlO.MY) || es.Cc(this.IlO.MY)) {
            IlO(true, false, true, 70);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public RFEndCardBackUpLayout lEW() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        if (es.MY(this.IlO.MY)) {
            return true;
        }
        return (es.tV(this.IlO.MY) || es.Cc(this.IlO.MY)) ? false : true;
    }

    public static void IlO(oeT oet, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        if (es.MY(oet)) {
            IlO(frameLayout, oet);
        } else if (es.tV(oet) || es.Cc(oet)) {
            MY(frameLayout, oet);
        } else {
            MY.IlO(frameLayout, ilO);
        }
    }

    public static void MY(FrameLayout frameLayout, oeT oet) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo.setId(zPa.xF);
        frameLayout.addView(eo, new FrameLayout.LayoutParams(-1, -1));
        eo.addView(IlO(context, oet));
        LinearLayout linearLayoutMY = MY(context);
        linearLayoutMY.setBackgroundColor(Color.parseColor("#99161823"));
        eo.addView(linearLayoutMY);
        linearLayoutMY.addView(EO(context));
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo, oet);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo2.setId(zPa.nvX);
        frameLayout.addView(eo2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo3.setId(zPa.NV);
        eo2.addView(eo3, new FrameLayout.LayoutParams(-1, -1));
        eo3.addView(MY.IlO(context));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo4 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo4.setId(zPa.cL);
        eo4.setVisibility(8);
        eo4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        eo3.addView(eo4, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(zPa.es);
        tVVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        eo4.addView(tVVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo2);
        View nv = new com.bytedance.sdk.openadsdk.core.widget.NV(context);
        nv.setId(zPa.YA);
        nv.setClickable(true);
        nv.setFocusable(true);
        frameLayout.addView(nv, new FrameLayout.LayoutParams(-1, -1));
    }

    public static void IlO(FrameLayout frameLayout, oeT oet) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(1);
        frameLayout.addView(cc, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo.setId(zPa.nvX);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        cc.addView(eo, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo2.setId(zPa.NV);
        eo.addView(eo2, new FrameLayout.LayoutParams(-1, -1));
        eo2.addView(MY.IlO(context));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo3.setId(zPa.cL);
        eo3.setVisibility(8);
        eo3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        eo2.addView(eo3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(zPa.es);
        tVVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        eo3.addView(tVVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo4 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo4.setId(zPa.xF);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        cc.addView(eo4, layoutParams3);
        eo4.addView(IlO(context, oet));
        LinearLayout linearLayoutMY = MY(context);
        linearLayoutMY.setBackgroundColor(Color.parseColor("#70161823"));
        eo4.addView(linearLayoutMY);
        linearLayoutMY.addView(EO(context));
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo4, oet);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
    }

    public static com.bytedance.sdk.component.DmF.vCE IlO(Context context, oeT oet) {
        com.bytedance.sdk.component.DmF.vCE vceMY = com.bytedance.sdk.openadsdk.hp.IlO.IlO().MY(oet);
        if (vceMY != null) {
            vceMY.setLpPreRender(true);
            ViewGroup viewGroup = (ViewGroup) vceMY.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(vceMY);
            }
        } else {
            vceMY = new com.bytedance.sdk.component.DmF.vCE(context, true);
            vceMY.setLayerType(2, null);
        }
        BS.IlO((View) vceMY, 0);
        vceMY.setId(zPa.AXM);
        vceMY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return vceMY;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        IlO(this.MY, bc, this.IlO);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        bWL bwl;
        if (!es.tV(this.IlO.MY) || (bwl = (ilO = this.IlO).ts) == null) {
            return;
        }
        bwl.IlO(ilO.MY.ea().MY() * 1000);
    }
}
