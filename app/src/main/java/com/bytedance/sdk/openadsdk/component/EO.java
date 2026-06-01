package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.webkit.internal.b;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.DmF.Cc;
import com.bytedance.sdk.openadsdk.component.vCE;
import com.bytedance.sdk.openadsdk.core.Cc.lEW;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.cl;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private float AXM;
    protected int Bc;
    protected final com.bytedance.sdk.openadsdk.component.IlO Cc;
    protected View DmF;
    protected final boolean EO;
    protected lEW EV;
    protected final Activity IlO;
    protected final oeT MY;
    protected com.bytedance.sdk.openadsdk.core.Cc.tV NV;
    private ea OOq;
    private ImageView bWL;
    private zPa cL;
    private ImageView cl;
    private PAGLogoView ea;
    private lEW es;
    private RelativeLayout hp;
    private com.bytedance.sdk.openadsdk.component.lEW.EO kBB;
    protected FrameLayout lEW;
    private float oeT;
    private lEW pP;
    protected final com.bytedance.sdk.openadsdk.component.lEW.IlO rp;
    protected final FrameLayout tV;
    private com.bytedance.sdk.openadsdk.core.Cc.tV tl;

    @NonNull
    private final com.bytedance.sdk.openadsdk.component.DmF.lEW vAh = new com.bytedance.sdk.openadsdk.component.DmF.lEW();
    protected final int vCE;
    private View wPn;
    private lEW xF;
    private lEW zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements vCE.tV {
        WeakReference<Activity> IlO;
        private final WeakReference<EO> MY;

        public IlO(Activity activity, EO eo) {
            this.IlO = new WeakReference<>(activity);
            this.MY = new WeakReference<>(eo);
        }

        @Override // com.bytedance.sdk.openadsdk.component.vCE.tV
        public void IlO(Object obj) {
            EO eo;
            if (this.IlO.get() == null || this.IlO.get().isFinishing() || (eo = this.MY.get()) == null) {
                return;
            }
            eo.IlO(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements cl.IlO {
        private final WeakReference<EO> IlO;

        public MY(EO eo) {
            this.IlO = new WeakReference<>(eo);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.cl.IlO
        public void IlO() {
        }

        @Override // com.bytedance.sdk.openadsdk.utils.cl.IlO
        public void IlO(com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
            EO eo2;
            if (!eo.Cc() || (eo2 = this.IlO.get()) == null) {
                return;
            }
            eo2.IlO(eo);
            if (eo.MY() != null) {
                eo2.IlO(eo.IlO());
            }
        }
    }

    public EO(Activity activity, oeT oet, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.IlO ilO, int i2, boolean z2, com.bytedance.sdk.openadsdk.component.lEW.IlO ilO2) {
        this.IlO = activity;
        this.MY = oet;
        this.tV = frameLayout;
        this.Bc = i2;
        this.EO = z2;
        this.Cc = ilO;
        this.vCE = oet.hFV();
        this.rp = ilO2;
    }

    private void DmF() {
        if (this.es != null) {
            if (this.MY.VH() != null && !TextUtils.isEmpty(this.MY.VH().MY())) {
                this.es.setText(this.MY.VH().MY());
            } else if (TextUtils.isEmpty(this.MY.hL())) {
                this.es.setVisibility(8);
            } else {
                this.es.setText(this.MY.hL());
            }
        }
        if (this.xF != null) {
            if (TextUtils.isEmpty(this.MY.dm())) {
                this.xF.setVisibility(8);
            } else {
                this.xF.setText(this.MY.dm());
            }
        }
        if (this.cL != null && this.MY.HTA() != null && !TextUtils.isEmpty(this.MY.HTA().IlO())) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.MY.HTA().IlO(), this.MY.HTA().MY(), this.MY.HTA().EO(), this.cL, this.MY);
        }
        this.Cc.EO();
    }

    private void NV() {
        com.bytedance.sdk.openadsdk.core.model.zPa zpa = this.MY.Hg().get(0);
        cl.IlO(new com.bytedance.sdk.openadsdk.cL.vCE(zpa.IlO(), zpa.Bc()), zpa.MY(), zpa.EO(), new MY(this), com.bytedance.sdk.openadsdk.component.Bc.IlO.MY(TextUtils.isEmpty(zpa.Bc()) ? com.bytedance.sdk.component.utils.Cc.IlO(zpa.IlO()) : zpa.Bc()).getParent(), 25);
    }

    private void lEW() {
        boolean z2;
        this.vAh.IlO();
        this.zPa.setText(this.MY.aa());
        if (this.MY.mV()) {
            DmF();
            return;
        }
        if (this.EO) {
            MY(0);
            IlO(8);
            if (IlO(this.lEW)) {
                this.Cc.EO();
            } else {
                this.Cc.tV();
            }
            vCE.IlO(this.MY, new IlO(this.IlO, this), 25);
        } else {
            MY(8);
            IlO(0);
            NV();
            this.Cc.EO();
        }
        boolean z7 = true;
        if (this.pP == null) {
            z2 = false;
        } else {
            if (TextUtils.isEmpty(this.MY.hL())) {
                if (this.MY.VH() != null) {
                    this.pP.setText(this.MY.VH().MY());
                }
                z2 = false;
            } else {
                this.pP.setText(this.MY.hL());
            }
            z2 = true;
        }
        if (this.tl != null) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.MY.HTA(), this.tl, this.MY);
        }
        ea eaVar = this.OOq;
        if (eaVar != null) {
            BS.IlO((TextView) null, eaVar, this.MY);
            if (this.MY.VH() == null || this.MY.VH().tV() < 0.0d) {
                this.OOq.setVisibility(8);
                z7 = z2;
            }
        } else {
            z7 = z2;
        }
        View view = this.wPn;
        if (view != null) {
            view.setVisibility(z7 ? 0 : 8);
        }
    }

    public com.bytedance.sdk.openadsdk.component.lEW.EO Bc() {
        return this.kBB;
    }

    public void EO() {
        com.bytedance.sdk.openadsdk.component.lEW.EO eo = this.kBB;
        if (eo != null) {
            eo.rp();
        }
    }

    public JSONObject IlO(JSONObject jSONObject) {
        return null;
    }

    public void MY() {
        if (this.MY.Os()) {
            this.Cc.EO();
        } else {
            lEW();
        }
    }

    public int tV() {
        return -1;
    }

    public void vCE() {
        this.DmF.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.EO.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.component.IlO ilO = EO.this.Cc;
                if (ilO != null) {
                    ilO.MY(view);
                }
            }
        });
        this.NV.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.EO.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.component.IlO ilO = EO.this.Cc;
                if (ilO != null) {
                    ilO.IlO(view);
                }
            }
        });
    }

    public void IlO(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.component.DmF.EO tVVar = new com.bytedance.sdk.openadsdk.component.DmF.tV(this.IlO, this.MY);
        int iXF = this.MY.xF();
        if (iXF == 5) {
            tVVar = new com.bytedance.sdk.openadsdk.component.DmF.vCE(this.IlO, this.MY);
        } else if (iXF == 4) {
            tVVar = new com.bytedance.sdk.openadsdk.component.DmF.Cc(this.IlO, this.MY);
        }
        com.bytedance.sdk.openadsdk.component.DmF.EO eo = tVVar;
        this.hp = eo;
        viewGroup.addView(eo);
        this.cl = eo.getBackImage();
        this.lEW = eo.getVideoContainer();
        this.bWL = eo.getImageView();
        this.zPa = eo.getClickButton();
        this.ea = eo.getAdLogo();
        this.pP = eo.getAdTitleTextView();
        this.tl = eo.getAdIconView();
        this.OOq = eo.getScoreBar();
        this.wPn = eo.getOverlayLayout();
        if (this.MY.mV()) {
            this.cL = eo.getIconOnlyView();
            this.es = eo.getTitle();
            this.xF = eo.getContent();
        }
        if (eo.getDspAdChoice() != null) {
            eo.getDspAdChoice().IlO(14, this.MY);
        }
        if (!this.MY.Os()) {
            this.vAh.IlO(eo, this.MY, this.oeT, this.AXM, this.EO);
        }
        this.DmF = eo.getTopDisLike();
        this.NV = eo.getTopSkip();
        this.EV = eo.getTopCountDown();
        if (eo instanceof com.bytedance.sdk.openadsdk.component.DmF.Cc) {
            ((com.bytedance.sdk.openadsdk.component.DmF.Cc) eo).setRenderListener(new Cc.IlO() { // from class: com.bytedance.sdk.openadsdk.component.EO.1
                @Override // com.bytedance.sdk.openadsdk.component.DmF.Cc.IlO
                public void IlO(View view, int i2) {
                    EO.this.Cc.Cc();
                }
            });
        }
    }

    private void MY(int i2) {
        BS.IlO((View) this.lEW, i2);
    }

    public void Cc() {
    }

    public void IlO() {
        this.ea.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.EO.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    EO eo = EO.this;
                    TTWebsiteActivity.IlO(eo.IlO, eo.MY, "open_ad");
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("AppOpenAdNativeManager", th.getMessage());
                }
            }
        });
        vCE();
        if (this.MY.Os()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.IlO.IlO IlO2 = com.bytedance.sdk.openadsdk.component.IlO.MY.IlO(this.MY, this.IlO, this.rp);
        IlO2.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.EO.3
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                EO.this.Cc.Cc();
            }
        });
        IlO2.IlO(this.kBB);
        if (this.MY.es() == 1) {
            this.hp.setOnClickListener(IlO2);
            this.hp.setOnTouchListener(IlO2);
        }
        this.zPa.setOnClickListener(IlO2);
        this.zPa.setOnTouchListener(IlO2);
    }

    public boolean IlO(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.lEW.EO eo = new com.bytedance.sdk.openadsdk.component.lEW.EO(this.IlO);
        this.kBB = eo;
        return eo.IlO(frameLayout, this.Cc, this.MY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Object obj) {
        try {
            if (obj instanceof Bitmap) {
                this.cl.setImageDrawable(new BitmapDrawable(com.bytedance.sdk.openadsdk.core.cl.IlO().getResources(), (Bitmap) obj));
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.oeT.EO("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
        if (eo.MY() != null) {
            this.bWL.setImageBitmap(eo.MY());
            return;
        }
        Drawable drawableTV = eo.tV();
        if (drawableTV != null) {
            this.bWL.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (Build.VERSION.SDK_INT >= 28 && b.x(drawableTV)) {
                b.g(drawableTV).start();
            }
            this.bWL.setImageDrawable(drawableTV);
            return;
        }
        if (this.MY.Hg() == null || this.MY.Hg().get(0) == null) {
            return;
        }
        Drawable drawableIlO = cl.IlO(eo.EO(), this.MY.Hg().get(0).MY());
        this.bWL.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.bWL.setImageDrawable(drawableIlO);
    }

    public void IlO(int i2) {
        BS.IlO((View) this.bWL, i2);
    }

    public void IlO(float f4, float f8) {
        this.oeT = f4;
        this.AXM = f8;
    }

    public void IlO(int i2, boolean z2) {
        lEW lew;
        if (this.NV == null || (lew = this.EV) == null) {
            return;
        }
        if (z2) {
            if (lew.getVisibility() != 8) {
                this.EV.setVisibility(8);
            }
            if (this.NV.getVisibility() != 0) {
                this.NV.setVisibility(0);
                return;
            }
            return;
        }
        this.EV.setText(i2 + "s");
        if (this.EV.getVisibility() != 0) {
            this.EV.setVisibility(0);
        }
    }
}
