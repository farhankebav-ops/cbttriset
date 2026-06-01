package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.lEW.IlO {
    private float IlO;
    private int bWL;
    private View cL;
    private View cl;
    private int ea;
    private FrameLayout es;
    private boolean hp;
    private com.bytedance.sdk.openadsdk.core.MY.Cc xF;
    private int zPa;

    public IlO(@NonNull Context context, String str) {
        super(context, str);
        this.zPa = 1;
        this.MY = context;
    }

    private void Bc() {
        com.bytedance.sdk.openadsdk.bWL.MY my = new com.bytedance.sdk.openadsdk.bWL.MY(this.MY);
        this.cl = my;
        MY(my);
        tV();
        vCE();
    }

    private void DmF() {
        com.bytedance.sdk.openadsdk.bWL.vCE vce = new com.bytedance.sdk.openadsdk.bWL.vCE(this.MY);
        this.cl = vce;
        MY(vce);
        tV();
        vCE();
    }

    private void EV() {
        View cc = new com.bytedance.sdk.openadsdk.bWL.Cc(this.MY);
        this.cl = cc;
        MY(cc);
        this.es = (FrameLayout) this.cl.findViewById(zPa.Aw);
        ImageView imageView = (ImageView) this.cl.findViewById(zPa.uF);
        TextView textView = (TextView) this.cl.findViewById(zPa.eDn);
        View viewFindViewById = this.cl.findViewById(520093739);
        IlO(this.es, imageView);
        textView.setText(getDescription());
        EO(this.es);
        EO(imageView);
        EO(textView);
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.EO);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.IlO.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.IlO(((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).MY, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).EO, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).vCE);
                } catch (Throwable th) {
                    oeT.EO("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void NV() {
        com.bytedance.sdk.openadsdk.bWL.lEW lew = new com.bytedance.sdk.openadsdk.bWL.lEW(this.MY);
        this.cl = lew;
        MY(lew);
        tV();
    }

    private float getHeightDp() {
        return BS.EO(this.MY, BS.EV(this.MY));
    }

    private float getWidthDp() {
        return BS.EO(this.MY, BS.rp(this.MY));
    }

    private void hp() {
        com.bytedance.sdk.openadsdk.bWL.DmF dmF = new com.bytedance.sdk.openadsdk.bWL.DmF(this.MY);
        this.cl = dmF;
        MY(dmF);
        tV();
        vCE();
    }

    private void lEW() {
        com.bytedance.sdk.openadsdk.bWL.tV tVVar = new com.bytedance.sdk.openadsdk.bWL.tV(this.MY);
        this.cl = tVVar;
        MY(tVVar);
        tV();
    }

    private void rp() {
        com.bytedance.sdk.openadsdk.bWL.Bc bc = new com.bytedance.sdk.openadsdk.bWL.Bc(this.MY);
        this.cl = bc;
        MY(bc);
        tV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.IlO
    public void IlO(View view, int i2, bWL bwl) {
    }

    public FrameLayout getVideoContainer() {
        return this.es;
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        this.xF = cc;
    }

    public void setIsMute(boolean z2) {
        this.hp = z2;
        View view = this.cL;
        if (view != null && (view instanceof com.bytedance.sdk.openadsdk.core.rp.MY.vCE)) {
            ((com.bytedance.sdk.openadsdk.core.rp.MY.vCE) view).IlO(z2, "interactionStyle");
        }
    }

    private void Cc() {
        com.bytedance.sdk.openadsdk.bWL.EO eo = new com.bytedance.sdk.openadsdk.bWL.EO(this.MY);
        this.cl = eo;
        MY(eo);
        tV();
        vCE();
    }

    private void EO() {
        com.bytedance.sdk.openadsdk.bWL.IlO ilO = new com.bytedance.sdk.openadsdk.bWL.IlO(this.MY);
        this.cl = ilO;
        MY(ilO);
        tV();
        vCE();
    }

    private void MY() {
        this.Bc = BS.MY(this.MY, this.bWL);
        this.lEW = BS.MY(this.MY, this.ea);
        int i2 = (int) (this.IlO * 1000.0f);
        if (this.zPa == 1) {
            if (i2 == 666) {
                Cc();
                return;
            }
            if (i2 == 1000) {
                EO();
                return;
            }
            if (i2 == 1500) {
                EV();
                return;
            } else if (i2 == 1777) {
                hp();
                return;
            } else {
                IlO(0.562f);
                rp();
                return;
            }
        }
        if (i2 == 562) {
            DmF();
            return;
        }
        if (i2 == 666) {
            Bc();
            return;
        }
        if (i2 == 1000) {
            EO();
        } else if (i2 == 1500) {
            lEW();
        } else {
            IlO(1.777f);
            NV();
        }
    }

    private void tV() {
        this.es = (FrameLayout) this.cl.findViewById(zPa.Aw);
        ImageView imageView = (ImageView) this.cl.findViewById(zPa.La);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpa = (com.bytedance.sdk.openadsdk.core.widget.zPa) this.cl.findViewById(zPa.OW);
        TextView textView = (TextView) this.cl.findViewById(zPa.eeU);
        TextView textView2 = (TextView) this.cl.findViewById(zPa.tf);
        View viewFindViewById = this.cl.findViewById(520093739);
        if (!TextUtils.isEmpty(this.EO.aa())) {
            textView2.setText(this.EO.aa());
        }
        IlO(this.es, imageView);
        if (this.EO.HTA() != null && !TextUtils.isEmpty(this.EO.HTA().IlO())) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.EO.HTA().IlO(), this.EO.HTA().MY(), this.EO.HTA().EO(), zpa, this.EO);
        }
        textView.setText(getTitle());
        EO(this.es);
        EO(imageView);
        EO(zpa);
        EO(textView);
        EO(textView2);
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.EO);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.IlO.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.IlO(((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).MY, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).EO, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) IlO.this).vCE);
                } catch (Throwable th) {
                    oeT.EO("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void vCE() {
        TextView textView = (TextView) this.cl.findViewById(zPa.BES);
        if (textView != null) {
            textView.setText(getDescription());
            EO(textView);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, float f4, int i2, int i8, int i9) {
        this.IlO = f4;
        this.zPa = i2;
        this.EO = oet;
        this.vCE = "fullscreen_interstitial_ad";
        this.bWL = i8;
        this.ea = i9;
        IlO(this.DmF);
        MY();
    }

    private void EO(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.MY.MY ilO = this.xF;
        if (ilO == null) {
            Context context = this.MY;
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
            String str = this.vCE;
            ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(context, oet, str, zLG.IlO(str));
            ilO.IlO(IlO(this.EO, this.MY));
        }
        view.setOnTouchListener(ilO);
        view.setOnClickListener(ilO);
    }

    private void IlO(FrameLayout frameLayout, ImageView imageView) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
        if (oet == null) {
            return;
        }
        boolean zCc = com.bytedance.sdk.openadsdk.core.model.oeT.Cc(oet);
        if (this.EO.fdM() != null && zCc) {
            BS.IlO((View) imageView, 8);
            BS.IlO((View) frameLayout, 0);
        } else {
            IlO(imageView);
            BS.IlO((View) imageView, 0);
            BS.IlO((View) frameLayout, 8);
        }
    }

    private void MY(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void IlO(ImageView imageView) {
        List<com.bytedance.sdk.openadsdk.core.model.zPa> listHg;
        com.bytedance.sdk.openadsdk.core.model.zPa zpa;
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
        if (oet == null || (listHg = oet.Hg()) == null || listHg.size() <= 0 || (zpa = listHg.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(com.bytedance.sdk.openadsdk.DmF.EO.IlO(this.EO, zpa.IlO(), imageView));
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, Context context) {
        if (oet != null && oet.Jz() == 4) {
            return new com.bytedance.sdk.openadsdk.es.IlO.IlO.tV(context, oet, this.vCE);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(float r10) {
        /*
            r9 = this;
            float r0 = r9.getHeightDp()
            float r1 = r9.getWidthDp()
            int r2 = r9.zPa
            r3 = 2
            if (r2 != r3) goto L16
            float r2 = java.lang.Math.max(r0, r1)
            float r0 = java.lang.Math.min(r0, r1)
            goto L1e
        L16:
            float r2 = java.lang.Math.min(r0, r1)
            float r0 = java.lang.Math.max(r0, r1)
        L1e:
            int r1 = r9.zPa
            if (r1 == r3) goto L38
            android.content.Context r1 = r9.MY
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = com.bytedance.sdk.openadsdk.utils.BS.EO(r1)
            if (r1 == 0) goto L38
            android.content.Context r1 = r9.MY
            float r4 = com.bytedance.sdk.openadsdk.utils.BS.IlO()
            int r1 = com.bytedance.sdk.openadsdk.utils.BS.EO(r1, r4)
            float r1 = (float) r1
            float r0 = r0 - r1
        L38:
            int r1 = r9.zPa
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1120403456(0x42c80000, float:100.0)
            r6 = 1101004800(0x41a00000, float:20.0)
            r7 = 20
            r8 = 0
            if (r1 == r3) goto L5b
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L71
            int r1 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r1 == 0) goto L71
            float r2 = r2 - r6
            float r2 = r2 - r6
            float r2 = r2 / r10
            float r0 = r0 - r2
            float r0 = r0 / r4
            float r10 = java.lang.Math.max(r0, r8)
            int r10 = (int) r10
            r0 = r7
            r1 = r0
            r7 = r10
            goto L75
        L5b:
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L71
            int r1 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r1 == 0) goto L71
            float r0 = r0 - r6
            float r0 = r0 - r6
            float r0 = r0 * r10
            float r2 = r2 - r0
            float r2 = r2 / r4
            float r10 = java.lang.Math.max(r2, r8)
            int r10 = (int) r10
            r0 = r10
            r1 = r0
            r10 = r7
            goto L75
        L71:
            r7 = 0
            r10 = r7
            r0 = r10
            r1 = r0
        L75:
            android.content.Context r2 = r9.MY
            float r3 = (float) r7
            int r2 = com.bytedance.sdk.openadsdk.utils.BS.MY(r2, r3)
            android.content.Context r3 = r9.MY
            float r10 = (float) r10
            int r10 = com.bytedance.sdk.openadsdk.utils.BS.MY(r3, r10)
            android.content.Context r3 = r9.MY
            float r0 = (float) r0
            int r0 = com.bytedance.sdk.openadsdk.utils.BS.MY(r3, r0)
            android.content.Context r3 = r9.MY
            float r1 = (float) r1
            int r1 = com.bytedance.sdk.openadsdk.utils.BS.MY(r3, r1)
            android.content.Context r3 = r9.MY
            android.app.Activity r3 = (android.app.Activity) r3
            android.view.Window r3 = r3.getWindow()
            android.view.View r3 = r3.getDecorView()
            r3.setPadding(r0, r2, r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.view.IlO.IlO(float):void");
    }
}
