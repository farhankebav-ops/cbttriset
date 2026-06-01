package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.lEW.cl;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.core.widget.EV;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import w.a;
import w.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends com.bytedance.sdk.openadsdk.core.lEW.IlO implements a, d {
    public boolean IlO;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE bWL;
    private PAGBannerAdWrapperListener cL;
    private long cl;
    private com.bytedance.sdk.openadsdk.core.rp.MY.vCE ea;
    private xF hp;
    private String zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public com.bytedance.sdk.openadsdk.core.Cc.tV Cc;
        public com.bytedance.sdk.openadsdk.core.Cc.tV EO;
        public FrameLayout IlO;
        public EV MY;
        public PAGLogoView tV;

        private IlO() {
        }
    }

    public DmF(@NonNull Context context) {
        super(context);
        this.IlO = true;
        this.MY = context;
    }

    private void Cc() {
        cl clVarIlO = MY.IlO(this.hp.getExpectExpressWidth(), this.hp.getExpectExpressHeight());
        if (this.hp.getExpectExpressWidth() <= 0 || this.hp.getExpectExpressHeight() <= 0) {
            int iEO = BS.EO(this.MY);
            this.Bc = iEO;
            this.lEW = Float.valueOf(iEO / clVarIlO.MY).intValue();
        } else {
            this.Bc = BS.MY(this.MY, this.hp.getExpectExpressWidth());
            this.lEW = BS.MY(this.MY, this.hp.getExpectExpressHeight());
        }
        int i2 = this.Bc;
        if (i2 > 0 && i2 > BS.EO(this.MY)) {
            this.Bc = BS.EO(this.MY);
            this.lEW = Float.valueOf(this.lEW * (BS.EO(this.MY) / this.Bc)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.Bc, this.lEW);
        }
        layoutParams.width = this.Bc;
        layoutParams.height = this.lEW;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        IlO(clVarIlO);
    }

    @Override // w.d
    public void IlO(int i2, int i8) {
    }

    public long getVideoProgress() {
        return this.cl;
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.cL = pAGBannerAdWrapperListener;
    }

    public void setClosedListenerKey(String str) {
        this.zPa = str;
    }

    private IlO MY(cl clVar) {
        IlO ilO = new IlO();
        ilO.IlO = new FrameLayout(this.MY);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        ilO.IlO.setLayoutParams(layoutParams);
        ilO.MY = new EV(this.MY);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        ilO.MY.setLayoutParams(layoutParams2);
        ilO.IlO.addView(ilO.MY);
        int iMY = BS.MY(this.MY, 5.0f);
        if (clVar == null || clVar.IlO != 1) {
            ilO.EO = com.bytedance.sdk.openadsdk.core.widget.vCE.MY(getContext());
        } else {
            ilO.EO = com.bytedance.sdk.openadsdk.core.widget.vCE.IlO(getContext());
        }
        ilO.EO.setId(520093697);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = GravityCompat.END;
        layoutParams3.setMargins(iMY, iMY, iMY, iMY);
        ilO.EO.setLayoutParams(layoutParams3);
        ilO.IlO.addView(ilO.EO);
        ilO.tV = PAGLogoView.createPAGLogoViewByMaterial(this.MY, this.EO);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 8388691;
        layoutParams4.setMargins(iMY, iMY, iMY, iMY);
        ilO.tV.setLayoutParams(layoutParams4);
        ilO.IlO.addView(ilO.tV);
        ilO.Cc = new com.bytedance.sdk.openadsdk.core.Cc.tV(this.MY);
        int iMY2 = BS.MY(this.MY, 11.0f);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iMY2, iMY2);
        layoutParams5.gravity = 8388693;
        layoutParams5.rightMargin = iMY;
        layoutParams5.bottomMargin = iMY;
        ilO.Cc.setVisibility(8);
        ilO.Cc.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ilO.Cc.setLayoutParams(layoutParams5);
        ilO.IlO.addView(ilO.Cc);
        return ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.IlO
    public void IlO(View view, int i2, bWL bwl) {
        xF xFVar = this.hp;
        if (xFVar != null) {
            xFVar.IlO(view, i2, bwl);
            com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.ea;
            if (vce == null || vce.getNativeVideoController() == null) {
                return;
            }
            this.ea.getNativeVideoController().mmj();
        }
    }

    public void IlO(oeT oet, xF xFVar, com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce) {
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.EO = oet;
        this.hp = xFVar;
        this.bWL = vce;
        this.vCE = "banner_ad";
        xFVar.addView(this, new ViewGroup.LayoutParams(-2, -2));
        Cc();
    }

    private void IlO(cl clVar) {
        View view;
        oeT oet = this.EO;
        if (oet != null) {
            int iUI = oet.uI();
            IlO ilOMY = MY(clVar);
            if (ilOMY == null || (view = ilOMY.IlO) == null) {
                return;
            }
            addView(view);
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = ilOMY.EO;
            PAGLogoView pAGLogoView = ilOMY.tV;
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = ilOMY.Cc;
            if (tVVar2 != null && this.EO.bWL()) {
                BS.IlO((View) tVVar2, 0);
                com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO((int) BS.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), 11.0f, true), tVVar2, this.EO);
            }
            com.bytedance.sdk.openadsdk.core.rp.MY.vCE videoView = getVideoView();
            if (videoView != null) {
                this.ea = videoView;
                videoView.setVideoAdLoadListener(this);
                this.ea.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(tVVar, FriendlyObstructionPurpose.CLOSE_AD));
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                arrayList.add(new Pair(pAGLogoView, friendlyObstructionPurpose));
                arrayList.add(new Pair(tVVar2, friendlyObstructionPurpose));
                this.ea.IlO(arrayList);
                this.ea.setAdCreativeClickListener(new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.DmF.1
                    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.IlO
                    public void IlO(View view2, int i2) {
                        if (DmF.this.cL != null) {
                            DmF.this.cL.onAdClicked();
                        }
                    }
                });
            }
            if (pAGLogoView != null) {
                pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.DmF.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.IlO(((com.bytedance.sdk.openadsdk.core.lEW.IlO) DmF.this).MY, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) DmF.this).EO, ((com.bytedance.sdk.openadsdk.core.lEW.IlO) DmF.this).vCE);
                    }
                });
            }
            if (tVVar != null) {
                tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.DmF.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        DmF.this.IlO();
                    }
                });
                xF xFVar = this.hp;
                if (xFVar != null) {
                    if (xFVar.getClickListener() != null) {
                        this.hp.getClickListener().MY(tVVar);
                    }
                    if (this.hp.getClickCreativeListener() != null) {
                        this.hp.getClickCreativeListener().MY(tVVar);
                    }
                }
            }
            EV ev = ilOMY.MY;
            oeT oet2 = this.EO;
            if (oet2 != null && oet2.QfH() != null && ev != null) {
                int iRp = this.EO.QfH().rp();
                float fHp = this.EO.QfH().hp();
                if (iRp > 0 && fHp > 0.0f) {
                    ev.setRatio(iRp / fHp);
                } else if (iUI == 15) {
                    ev.setRatio(0.5625f);
                } else if (iUI == 5) {
                    ev.setRatio(1.7777778f);
                } else {
                    ev.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && ev != null) {
                ev.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            IlO((View) videoView, true);
            IlO((View) this, true);
            IlO(ev);
        }
    }

    @Override // w.a
    public void e_() {
    }

    @Override // w.a
    public void f_() {
    }

    @Override // w.a
    public void g_() {
    }

    @Override // w.a
    public void h_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.IlO
    public void IlO() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.Cc;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.EO.EO eo = this.tV;
        if (eo != null) {
            eo.IlO();
        } else {
            TTDelegateActivity.IlO(this.EO, this.zPa);
        }
    }

    @Override // w.a
    public void IlO(long j, long j3) {
        this.cl = j;
    }
}
