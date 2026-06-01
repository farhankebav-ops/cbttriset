package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.IlO.zPa;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.hp;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private boolean AXM;
    View Bc;
    ImageView Cc;
    PAGLogoView DmF;
    protected final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO EO;
    RelativeLayout EV;
    final Activity MY;
    ImageView NV;
    private final boolean cL;
    public es ea;
    private final String es;
    View lEW;
    private EO oeT;
    zPa rp;
    final oeT tV;
    FrameLayout vCE;
    private int xF;
    com.bytedance.sdk.openadsdk.core.Cc.vCE zPa;
    int IlO = 3;
    protected int hp = 0;
    protected final AtomicBoolean bWL = new AtomicBoolean(false);
    Runnable cl = new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.NV.2
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            try {
                oeT oet = NV.this.tV;
                if ((oet == null || !oet.pS()) && (imageView = NV.this.Cc) != null) {
                    int[] iArr = new int[2];
                    imageView.getLocationOnScreen(iArr);
                    NV.this.EO.YA.IlO(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };

    public NV(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.EO = ilO;
        this.MY = ilO.BS;
        this.tV = ilO.MY;
        this.es = ilO.Cc;
        this.cL = ilO.tV;
    }

    private void cL() {
        RelativeLayout relativeLayout;
        EO eo = (EO) this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.rp);
        this.oeT = eo;
        eo.IlO(this.EO);
        this.DmF = (PAGLogoView) this.EO.zLG.findViewById(520093757);
        this.NV = (ImageView) this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.fHv);
        this.Cc = (ImageView) this.EO.zLG.findViewById(520093708);
        this.vCE = (FrameLayout) this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.EV);
        this.Bc = this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.cl);
        this.lEW = this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.cJK);
        this.EV = (RelativeLayout) this.EO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.OyN);
        zPa zpa = this.rp;
        if (zpa == null || zpa.tV() == null || (relativeLayout = this.EV) == null) {
            return;
        }
        relativeLayout.addView(this.rp.tV(), new LinearLayout.LayoutParams(-1, -1));
        this.rp.MY();
    }

    public void Bc() {
        if (this.NV.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.NV.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(11);
            this.NV.setLayoutParams(marginLayoutParams);
        }
    }

    public void Cc() {
        int iGQ = this.tV.gQ();
        this.IlO = iGQ;
        if (iGQ == -200) {
            this.IlO = cl.tV().bWL(String.valueOf(this.tV.hFV()));
        }
        if (this.IlO != -1 || IlO()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO.qz;
        if ((my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.tV) || (my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.EO)) {
            return;
        }
        MY(0);
    }

    public boolean DmF() {
        ImageView imageView = this.Cc;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void EO() {
        this.vCE.removeAllViews();
    }

    public View EV() {
        return this.oeT;
    }

    public boolean IlO() {
        return true;
    }

    public void MY() {
        if (this.AXM) {
            return;
        }
        this.AXM = true;
        this.xF = this.EO.fdM;
        if (IlO()) {
            zPa zpa = new zPa(this.EO);
            this.rp = zpa;
            zpa.IlO();
        }
        cL();
        Activity activity = this.MY;
        oeT oet = this.tV;
        String str = this.es;
        FrameLayout frameLayout = this.vCE;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        es esVar = new es(activity, oet, str, frameLayout, ilO.ssS, ilO.zLG);
        this.ea = esVar;
        esVar.IlO();
    }

    public View NV() {
        return this.Cc;
    }

    public void bWL() {
        es esVar = this.ea;
        if (esVar != null) {
            esVar.vCE();
        }
        ImageView imageView = this.Cc;
        if (imageView != null) {
            imageView.removeCallbacks(this.cl);
        }
    }

    public void cl() {
        com.bytedance.sdk.openadsdk.core.MY.Cc Cc = this.EO.wPn.Cc();
        View view = this.oeT;
        if (view == null) {
            view = this.EO.zLG;
        }
        Cc.onClick(view);
    }

    public void ea() {
        es esVar = this.ea;
        if (esVar != null) {
            esVar.Bc();
        }
    }

    public void hp() {
        try {
            Activity activity = this.EO.BS;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(activity, pP.DmF(activity, "tt_fade_out"));
            if (animationLoadAnimation == null) {
                this.EO.DM.rp();
            } else {
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.NV.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        NV.this.EO.DM.rp();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.EO.DM.IlO(animationLoadAnimation);
            }
        } catch (Throwable unused) {
            this.EO.DM.rp();
        }
    }

    public void lEW() {
        EO eo = this.oeT;
        if (eo == null) {
            return;
        }
        eo.IlO();
    }

    public void rp() {
        try {
            zPa zpa = this.rp;
            if (zpa != null) {
                zpa.EO();
            }
            RelativeLayout relativeLayout = this.EV;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.EV;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public void tV() {
        BS.IlO((View) this.vCE, 8);
        BS.IlO(this.Bc, 8);
        BS.IlO(this.lEW, 8);
        MY(8);
        BS.IlO((View) this.Cc, 8);
        BS.IlO((View) this.DmF, 8);
        BS.IlO((View) this.EV, 8);
        BS.IlO((View) this.NV, 8);
    }

    public FrameLayout vCE() {
        return this.vCE;
    }

    public void zPa() {
        es esVar = this.ea;
        if (esVar != null) {
            esVar.lEW();
        }
    }

    public void EO(int i2) {
        BS.IlO((View) this.DmF, i2);
    }

    public void IlO(boolean z2) {
        BS.IlO((View) this.DmF, OOq.EO(this.tV) ? 8 : 0);
        BS.IlO((View) this.NV, (this.tV.xJ() && this.tV.bWL()) ? 0 : 8);
        MY(z2);
        if (this.cL) {
            Cc();
        }
    }

    public void Cc(int i2) {
        BS.IlO((View) this.Cc, i2);
        if (i2 == 0 && !this.EO.NV.get() && OOq.Bc(this.EO.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(ilO.MY, ilO.Cc, "show_close_button", (JSONObject) null, System.currentTimeMillis() - this.EO.Tx);
        }
    }

    public void IlO(int i2) {
        if (this.zPa == null) {
            this.zPa = new com.bytedance.sdk.openadsdk.core.Cc.vCE(this.EO.BS);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.zPa.setLayoutParams(layoutParams);
            this.zPa.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(this.EO.BS, "tt_video_loading_progress_bar"));
            this.EO.DM.vCE().addView(this.zPa);
        }
        this.zPa.setVisibility(i2);
    }

    public void tV(int i2) {
        int i8 = this.IlO;
        if (i8 == -1 || i2 != i8 || this.bWL.get()) {
            return;
        }
        MY(0);
        this.bWL.set(true);
        lEW();
    }

    public void MY(boolean z2) {
        ImageView imageView;
        int iIlO;
        if (this.xF != 1 && (imageView = this.Cc) != null && z2) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (iIlO = IlO("navigation_bar_height")) > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (iIlO > marginLayoutParams.rightMargin) {
                    marginLayoutParams.rightMargin = iIlO;
                }
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO.qz;
        if ((my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.tV) || (my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.EO)) {
            return;
        }
        MY(0);
    }

    public void IlO(int i2, int i8) {
        FrameLayout frameLayout;
        if (this.tV.zLG() == 1 && (frameLayout = this.vCE) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int iEO = BS.EO((Context) this.MY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.vCE.getLayoutParams();
            layoutParams.width = iEO;
            int i9 = (iEO * 9) / 16;
            layoutParams.height = i9;
            this.vCE.setLayoutParams(layoutParams);
            this.hp = (BS.Cc(this.MY) - i9) / 2;
        }
    }

    public void MY(int i2) {
        oeT oet = this.tV;
        if (oet != null && oet.xJ() && hp.IlO(this.tV)) {
            BS.IlO((View) this.oeT, 8);
        } else {
            BS.IlO((View) this.oeT, i2);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.EO eo, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        oeT oet;
        if (this.vCE != null && (oet = this.tV) != null && oet.BS() != null) {
            if (this.tV.BS().vCE && !es.MY(this.tV)) {
                IlO((View.OnClickListener) eo);
                IlO(eo);
            } else {
                IlO(onClickListener);
            }
        }
        oeT oet2 = this.tV;
        if (oet2 != null && oet2.zLG() == 1) {
            if (this.tV.BS() != null && (view2 = this.Bc) != null) {
                BS.IlO(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Bc.getLayoutParams();
                layoutParams.height = this.hp;
                this.Bc.setLayoutParams(layoutParams);
                if (this.tV.BS().MY) {
                    this.Bc.setOnClickListener(eo);
                    this.Bc.setOnTouchListener(onTouchListener);
                } else {
                    this.Bc.setOnClickListener(onClickListener);
                }
            }
            if (this.tV.BS() != null && (view = this.lEW) != null) {
                BS.IlO(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lEW.getLayoutParams();
                layoutParams2.height = this.hp;
                this.lEW.setLayoutParams(layoutParams2);
                if (this.tV.BS().tV) {
                    this.lEW.setOnClickListener(eo);
                    this.lEW.setOnTouchListener(onTouchListener);
                } else {
                    this.lEW.setOnClickListener(onClickListener);
                }
            }
        }
        PAGLogoView pAGLogoView = this.DmF;
        if (pAGLogoView != null) {
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.NV.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    try {
                        NV nv = NV.this;
                        TTWebsiteActivity.IlO(nv.MY, nv.tV, nv.es);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO("TTAD.RFullVideoLayout", th.getMessage());
                    }
                }
            });
        }
        ImageView imageView = this.NV;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO((int) BS.IlO(cl.IlO(), 14.0f, true), this.NV, this.EO.MY);
        }
    }

    private int IlO(String str) {
        Resources resources = this.MY.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    public void IlO(View.OnClickListener onClickListener) {
        BS.IlO(this.vCE, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.MY.EO eo) {
        BS.IlO((View) this.vCE, (View.OnTouchListener) eo, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public void IlO(float f4) {
        BS.IlO(this.Cc, f4);
    }

    public void IlO(Animation animation) {
        RelativeLayout relativeLayout = this.EV;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void IlO(int i2, bWL bwl) {
        es esVar = this.ea;
        if (esVar != null) {
            esVar.IlO(i2, bwl);
        }
    }
}
