package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.lEW.Cc;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends EO {
    IlO hp;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view, int i2);
    }

    public Cc(Context context, oeT oet) {
        super(context);
        IlO(context, oet);
    }

    private void IlO(Context context, oeT oet) {
        com.bytedance.sdk.openadsdk.core.lEW.Cc cc = new com.bytedance.sdk.openadsdk.core.lEW.Cc(context);
        com.bytedance.sdk.openadsdk.core.lEW.tV.IlO().EO(cc);
        cc.IlO(oet, new Cc.MY() { // from class: com.bytedance.sdk.openadsdk.component.DmF.Cc.1
            @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
            public void IlO(int i2, int i8) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
            public View MY() {
                return Cc.this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
            public View IlO() {
                Bc bc = Cc.this.lEW;
                if (bc != null) {
                    return bc.getTopDislike();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
            public void IlO(View view, int i2) {
                IlO ilO = Cc.this.hp;
                if (ilO != null) {
                    ilO.IlO(view, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
            public void i_() {
            }
        }, "open_ad");
        addView(cc, new ViewGroup.LayoutParams(-1, -1));
        cc.xF();
        int iMY = BS.MY(context, 9.0f);
        int iMY2 = BS.MY(context, 10.0f);
        this.tV = PAGLogoView.createPAGLogoViewByMaterial(context, oet);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams.leftMargin = iMY2;
        layoutParams.bottomMargin = iMY2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        addView(this.tV, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.EO eo = new com.bytedance.sdk.openadsdk.core.widget.EO(context);
        this.rp = eo;
        eo.setPadding(iMY, 0, iMY, 0);
        this.rp.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BS.MY(context, 32.0f), BS.MY(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, iMY2, iMY2);
        addView(this.rp, layoutParams2);
        View view = this.lEW;
        if (view != null) {
            addView(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.tV getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.lEW getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public ea getScoreBar() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public View getUserInfo() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hp = null;
    }

    public void setRenderListener(IlO ilO) {
        this.hp = ilO;
    }
}
