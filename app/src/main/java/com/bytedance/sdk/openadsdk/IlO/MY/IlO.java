package com.bytedance.sdk.openadsdk.IlO.MY;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.DmF;
import com.bytedance.sdk.openadsdk.core.lEW.es;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.zPa;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO Bc;
    private WeakReference<com.bytedance.sdk.openadsdk.core.rp.MY.vCE> Cc;
    private xF DmF;
    private final String EO;
    private com.bytedance.sdk.openadsdk.core.MY.IlO EV;
    protected final oeT IlO;
    private final Context MY;
    private PAGMediaView NV;
    private WeakReference<com.bytedance.sdk.openadsdk.core.EV.vCE> bWL;
    private boolean hp = false;
    private PAGMediaView lEW;
    private com.bytedance.sdk.openadsdk.core.MY.MY rp;
    private boolean tV;
    private MY vCE;

    public IlO(Context context, oeT oet, String str) {
        this.MY = context;
        this.IlO = oet;
        this.EO = str;
    }

    private PAGMediaView bWL() {
        if (!oeT.Cc(this.IlO)) {
            com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO eo = this.Bc;
            if (eo == null) {
                return null;
            }
            xF xFVarTV = eo.tV();
            xFVarTV.setTag(520093762, Boolean.TRUE);
            if (!this.hp) {
                this.Bc.Cc();
            }
            this.hp = true;
            return IlO(xFVarTV);
        }
        com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO eo2 = this.Bc;
        if (eo2 == null || !(eo2 instanceof com.bytedance.sdk.openadsdk.IlO.MY.IlO.MY)) {
            return null;
        }
        es esVar = (es) eo2.tV();
        esVar.setTag(520093762, Boolean.TRUE);
        if (!this.hp) {
            this.Bc.Cc();
        }
        this.hp = true;
        return IlO(esVar);
    }

    public PAGMediaView Bc() {
        PAGMediaView pAGMediaViewDmF;
        com.bytedance.sdk.openadsdk.utils.MY.IlO(this.IlO);
        if (this.IlO.oc() == 2) {
            pAGMediaViewDmF = bWL();
            IlO(pAGMediaViewDmF);
        } else {
            pAGMediaViewDmF = DmF();
        }
        if (pAGMediaViewDmF != null) {
            pAGMediaViewDmF.setMrcTrackerKey(com.bytedance.sdk.openadsdk.kBB.MY.Cc.MY(this.IlO));
        } else {
            pAGMediaViewDmF = new PAGMediaView(this.MY) { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.1
                @Override // android.view.ViewGroup, android.view.View
                public void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    com.bytedance.sdk.openadsdk.utils.tV.IlO(this, IlO.this.IlO);
                }
            };
        }
        if (pAGMediaViewDmF instanceof PAGVideoMediaView) {
            ((PAGVideoMediaView) pAGMediaViewDmF).setMaterialMeta(this.IlO);
        }
        this.NV = pAGMediaViewDmF;
        return pAGMediaViewDmF;
    }

    public String Cc() {
        oeT oet = this.IlO;
        if (oet != null) {
            return MY(oet);
        }
        return null;
    }

    public PAGMediaView DmF() {
        if (!oeT.Cc(this.IlO)) {
            List<zPa> listHg = this.IlO.Hg();
            if (listHg == null || listHg.isEmpty()) {
                ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
                return null;
            }
            ImageView imageView = new ImageView(this.MY);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            zPa zpa = listHg.get(0);
            if (zpa != null) {
                com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(com.bytedance.sdk.openadsdk.DmF.EO.IlO(this.IlO, zpa.IlO(), imageView));
            }
            PAGMediaView pAGMediaViewIlO = IlO(imageView);
            if (this.EV == null || !hp.aP().EO(String.valueOf(this.IlO.hFV()))) {
                pAGMediaViewIlO.setOnClickListener(null);
                pAGMediaViewIlO.setOnTouchListener(null);
            } else {
                pAGMediaViewIlO.setOnClickListener(this.EV);
                pAGMediaViewIlO.setOnTouchListener(this.EV);
            }
            pAGMediaViewIlO.setTag(520093762, Boolean.TRUE);
            PAGMediaView pAGMediaView = this.lEW;
            if (pAGMediaView != null) {
                pAGMediaView.setOnClickListener(null);
                this.lEW.setOnTouchListener(null);
            }
            this.lEW = pAGMediaViewIlO;
            return pAGMediaViewIlO;
        }
        MY my = this.vCE;
        if (my == null) {
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
            return null;
        }
        View viewCc = my.Cc();
        if (viewCc == null) {
            ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
            return null;
        }
        if (viewCc.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewCc.getParent()).removeView(viewCc);
        }
        PAGMediaView pAGMediaView2 = this.lEW;
        if (pAGMediaView2 != null) {
            pAGMediaView2.setOnClickListener(null);
            this.lEW.setOnTouchListener(null);
        }
        PAGVideoMediaView pAGVideoMediaView = new PAGVideoMediaView(this.MY, viewCc, this);
        pAGVideoMediaView.setTag(520093762, Boolean.TRUE);
        if (this.EV == null || !hp.aP().EO(String.valueOf(this.IlO.hFV()))) {
            com.bytedance.sdk.openadsdk.core.MY.EO eo = new com.bytedance.sdk.openadsdk.core.MY.EO() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.2
                @Override // com.bytedance.sdk.openadsdk.core.MY.EO
                public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                    try {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    } catch (Exception unused) {
                    }
                }
            };
            pAGVideoMediaView.setOnClickListener(eo);
            pAGVideoMediaView.setOnTouchListener(eo);
        } else {
            pAGVideoMediaView.setOnClickListener(this.EV);
            pAGVideoMediaView.setOnTouchListener(this.EV);
        }
        this.lEW = pAGVideoMediaView;
        pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return pAGVideoMediaView;
    }

    public PAGImageItem EO() {
        oeT oet = this.IlO;
        if (oet == null || oet.HTA() == null) {
            return null;
        }
        return new PAGImageItem(this.IlO.HTA().EO(), this.IlO.HTA().MY(), this.IlO.HTA().IlO(), (float) this.IlO.HTA().tV());
    }

    public View EV() {
        oeT oet;
        if (cl.IlO() == null || (oet = this.IlO) == null || !oet.xJ() || !this.IlO.bWL()) {
            return null;
        }
        ImageView imageView = new ImageView(cl.IlO());
        com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO((int) BS.IlO(cl.IlO(), 14.0f, true), imageView, this.IlO);
        return imageView;
    }

    public void IlO(MY my) {
        this.vCE = my;
    }

    public xF MY() {
        return this.DmF;
    }

    public View NV() {
        if (cl.IlO() == null) {
            return null;
        }
        PAGLogoView pAGLogoView = new PAGLogoView(cl.IlO()) { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.4
            int IlO = 0;
            int MY = 0;

            @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
            public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
                super.onLayout(z2, i2, i8, i9, i10);
                try {
                    Object parent = getParent();
                    if (parent == null || this.IlO == 0 || this.MY == 0) {
                        return;
                    }
                    int width = ((View) parent).getWidth();
                    int height = ((View) parent).getHeight();
                    int i11 = this.IlO;
                    if (width < i11 || height < this.MY) {
                        float fMin = Math.min(height / this.MY, width / i11);
                        int i12 = (width - this.IlO) / 2;
                        if (fMin != 1.0f) {
                            setScaleX(fMin);
                            setScaleY(fMin);
                            setTranslationX(i12);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.PAGLogoView, android.widget.LinearLayout, android.view.View
            public void onMeasure(int i2, int i8) {
                if (this.IlO == 0) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE), i8);
                    this.IlO = getMeasuredWidth();
                    this.MY = this.containerHeight;
                }
                setMeasuredDimension(this.IlO, this.MY);
            }
        };
        pAGLogoView.initData(this.IlO);
        pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IlO.this.rp();
            }
        });
        return pAGLogoView;
    }

    public void hp() {
        com.bytedance.sdk.openadsdk.core.EV.vCE vce;
        WeakReference<com.bytedance.sdk.openadsdk.core.EV.vCE> weakReference = this.bWL;
        if (weakReference == null || (vce = weakReference.get()) == null) {
            return;
        }
        vce.IlO(13);
    }

    public PAGMediaView lEW() {
        return this.NV;
    }

    public void rp() {
        Context context = this.MY;
        if (context != null) {
            TTWebsiteActivity.IlO(context, this.IlO, this.EO);
        }
    }

    public String tV() {
        oeT oet = this.IlO;
        if (oet != null) {
            return IlO(oet);
        }
        return null;
    }

    public String vCE() {
        oeT oet = this.IlO;
        if (oet != null) {
            return oet.aa();
        }
        return null;
    }

    private String MY(oeT oet) {
        return !TextUtils.isEmpty(oet.dm()) ? oet.dm() : !TextUtils.isEmpty(oet.gm()) ? oet.gm() : "";
    }

    public void IlO(com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO eo) {
        this.Bc = eo;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce) {
        this.Cc = new WeakReference<>(vce);
    }

    public void IlO(boolean z2) {
        this.tV = z2;
    }

    public PAGMediaView IlO() {
        return this.lEW;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        this.EV = ilO;
    }

    private String IlO(oeT oet) {
        if (oet.VH() != null && !TextUtils.isEmpty(oet.VH().MY())) {
            return oet.VH().MY();
        }
        if (!TextUtils.isEmpty(oet.hL())) {
            return oet.hL();
        }
        if (!TextUtils.isEmpty(oet.dm())) {
            return oet.dm();
        }
        return "";
    }

    private EO MY(final PAGVideoAdListener pAGVideoAdListener) {
        return new EO() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.6
            @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
            public void EO(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
            public void IlO(int i2, int i8) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
            public void MY(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
            public void IlO(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }
        };
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.MY my) {
        this.rp = my;
    }

    private void IlO(PAGMediaView pAGMediaView) {
        if (pAGMediaView == null) {
            return;
        }
        try {
            pAGMediaView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } catch (Exception unused) {
        }
    }

    private PAGMediaView IlO(final View view) {
        int i2;
        if (view == null) {
            return null;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        xF xFVar = this.DmF;
        if (xFVar != null) {
            xFVar.setClickListener(null);
            this.DmF.setClickCreativeListener(null);
        }
        com.bytedance.sdk.openadsdk.core.MY.MY my = this.rp;
        if (my != null && (my instanceof DmF) && (view instanceof xF)) {
            ((xF) view).setClickListener((DmF) my);
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = this.EV;
        if (ilO != null && (ilO instanceof com.bytedance.sdk.openadsdk.core.lEW.lEW) && (view instanceof xF)) {
            ((xF) view).setClickCreativeListener((com.bytedance.sdk.openadsdk.core.lEW.lEW) ilO);
        }
        PAGMediaView pAGMediaView = new PAGMediaView(this.MY) { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.3
            private void IlO(boolean z2) {
                Integer num = this.IlO;
                if (num != null) {
                    com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(num), z2 ? 4 : 8);
                }
                oeT oet = IlO.this.IlO;
                if (oet != null) {
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(oet, z2);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                com.bytedance.sdk.openadsdk.utils.tV.IlO(this, IlO.this.IlO);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z2) {
                super.onWindowFocusChanged(z2);
                if (view instanceof xF) {
                    return;
                }
                IlO(z2);
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
            public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
                super.setVideoAdListener(pAGVideoAdListener);
                IlO.this.IlO(pAGVideoAdListener);
            }
        };
        int i8 = -1;
        pAGMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i8 = layoutParams.width;
            i2 = layoutParams.height;
        } else {
            i2 = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i8, i2);
        layoutParams2.gravity = 17;
        pAGMediaView.addView(view, layoutParams2);
        if (view instanceof xF) {
            this.DmF = (xF) view;
        }
        return pAGMediaView;
    }

    public void IlO(PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO eo;
        if (this.IlO.oc() == 2 && oeT.Cc(this.IlO) && (eo = this.Bc) != null && (eo instanceof com.bytedance.sdk.openadsdk.IlO.MY.IlO.MY)) {
            es esVar = (es) eo.tV();
            if (esVar != null) {
                esVar.setVideoAdListener(MY(pAGVideoAdListener));
                return;
            }
            return;
        }
        MY my = this.vCE;
        if (my != null) {
            my.IlO(MY(pAGVideoAdListener));
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.EV.vCE vce) {
        this.bWL = new WeakReference<>(vce);
    }
}
