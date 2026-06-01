package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Bc;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.core.lEW.es;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.ssS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private PAGBannerAdWrapperListener Cc;
    private boolean DmF;
    private xF EV;
    protected tV IlO;
    protected AdSlot MY;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE NV;
    private boolean bWL;
    private long es;
    private final boolean lEW;
    private Bc rp;
    private oeT tV;
    private final Context vCE;
    private String EO = "banner_ad";
    private long Bc = 0;
    private final AtomicBoolean hp = new AtomicBoolean(false);
    private final int ea = 1;
    private final int zPa = 0;
    private int cl = -1;
    private final View.OnAttachStateChangeListener cL = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (IlO.this.cl == 0 || IlO.this.DmF) {
                return;
            }
            IlO ilO = IlO.this;
            ilO.IlO(ilO.IlO.getCurView(), IlO.this.tV);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (IlO.this.bWL) {
                IlO.this.cl = 0;
            } else {
                IlO.this.vCE();
            }
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.EO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0081IlO extends com.bytedance.sdk.component.lEW.lEW {
        WeakReference<IlO> EO;
        boolean IlO;
        oeT MY;

        public C0081IlO(boolean z2, oeT oet, IlO ilO) {
            super("ReportWindowFocusChangedAdShow");
            this.IlO = z2;
            this.MY = oet;
            this.EO = new WeakReference<>(ilO);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<IlO> weakReference = this.EO;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.EO.get().MY(this.IlO, this.MY);
        }
    }

    public IlO(Context context, oeT oet, AdSlot adSlot, Bc bc, boolean z2) {
        this.bWL = false;
        this.vCE = context;
        this.tV = oet;
        this.MY = adSlot;
        this.rp = bc;
        this.bWL = z2;
        IlO(context, oet, adSlot);
        this.lEW = false;
        this.DmF = false;
    }

    private void rp() {
        this.tV.IlO(SystemClock.elapsedRealtime());
        this.IlO.Cc();
    }

    private Bc.IlO EV() {
        return new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.7
            @Override // com.bytedance.sdk.openadsdk.core.EO.Bc.IlO
            public void IlO() {
                int width = IlO.this.EV.getWidth();
                int height = IlO.this.EV.getHeight();
                View viewIlO = IlO(((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d));
                IlO.this.EV.es();
                IlO.this.EV.removeAllViews();
                IlO.this.EV.addView(viewIlO, new ViewGroup.LayoutParams(width, height));
                IlO.this.EV.setClickCreativeListener(null);
                IlO.this.EV.setClickListener(null);
                if (IlO.this.Cc != null) {
                    IlO.this.Cc.onAdDismissed();
                }
                IlO.this.DmF = true;
            }

            private View IlO(boolean z2) {
                com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(IlO.this.vCE);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                eo.setBackgroundColor(-1);
                eo.setLayoutParams(layoutParams);
                View view = new View(IlO.this.vCE);
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                view.setAlpha(0.3f);
                view.setBackgroundColor(Color.parseColor("#F3F7F8"));
                eo.addView(view, layoutParams2);
                com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(IlO.this.vCE);
                ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                if (z2) {
                    eo2.setBackground(pP.EO(IlO.this.vCE, "tt_ad_closed_background_300_250"));
                } else {
                    eo2.setBackground(pP.EO(IlO.this.vCE, "tt_ad_closed_background_320_50"));
                }
                eo.addView(eo2, layoutParams3);
                PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(IlO.this.vCE, IlO.this.tV);
                pAGLogoViewCreatePAGLogoViewByMaterial.setId(520093739);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                if (z2) {
                    int iMY = BS.MY(IlO.this.vCE, 16.0f);
                    layoutParams4.width = BS.MY(IlO.this.vCE, 77.0f);
                    layoutParams4.height = BS.MY(IlO.this.vCE, 14.0f);
                    layoutParams4.leftMargin = iMY;
                    layoutParams4.topMargin = iMY;
                } else {
                    int iMY2 = BS.MY(IlO.this.vCE, 8.0f);
                    layoutParams4.width = BS.MY(IlO.this.vCE, 45.0f);
                    layoutParams4.height = BS.MY(IlO.this.vCE, 8.18f);
                    layoutParams4.leftMargin = iMY2;
                    layoutParams4.topMargin = iMY2;
                }
                eo2.addView(pAGLogoViewCreatePAGLogoViewByMaterial, layoutParams4);
                com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(IlO.this.vCE);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 17;
                lew.setAlpha(0.5f);
                lew.setLines(1);
                lew.setText(pP.IlO(IlO.this.vCE, "tt_ad_is_closed"));
                if (z2) {
                    lew.setTextSize(18.0f);
                } else {
                    lew.setTextSize(12.0f);
                }
                eo2.addView(lew, layoutParams5);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.IlO(IlO.this.vCE, IlO.this.tV, IlO.this.EO);
                    }
                };
                pAGLogoViewCreatePAGLogoViewByMaterial.setOnClickListener(onClickListener);
                lew.setOnClickListener(onClickListener);
                return eo;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NV() {
        rp();
    }

    public void Bc() {
        if (this.IlO != null) {
            try {
                vCE();
                this.IlO.removeOnAttachStateChangeListener(this.cL);
            } catch (Throwable unused) {
            }
        }
    }

    public void Cc() {
        this.Bc = System.currentTimeMillis();
    }

    public void DmF() {
        tV tVVar = this.IlO;
        if (tVVar instanceof EO) {
            ((EO) tVVar).IlO();
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.MY.IlO EO() {
        tV tVVar = this.IlO;
        if (tVVar instanceof EO) {
            return ((EO) tVVar).getVideoModel();
        }
        return null;
    }

    public void lEW() {
        tV tVVar = this.IlO;
        if (tVVar instanceof EO) {
            ((EO) tVVar).MY();
        }
    }

    public void tV() {
        MY(this.tV);
        this.Bc = 0L;
    }

    public void vCE() {
        this.cl = 1;
        this.IlO.tV();
    }

    public boolean MY() {
        return this.IlO instanceof EO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(boolean z2, oeT oet) {
        try {
            if (z2) {
                this.Bc = System.currentTimeMillis();
            } else {
                if (this.Bc <= 0 || this.EV == null) {
                    return;
                }
                String strValueOf = String.valueOf(System.currentTimeMillis() - this.Bc);
                this.Bc = 0L;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(strValueOf, oet, this.EO, this.EV.getAdShowTime());
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("PAGBannerAdImpl", e.getMessage());
        }
    }

    public void IlO(int i2) {
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.setCurrentIndex(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(oeT oet) {
        if (this.Bc <= 0 || oet == null) {
            return;
        }
        try {
            if (this.EV != null) {
                String strValueOf = String.valueOf(System.currentTimeMillis() - this.Bc);
                this.Bc = 0L;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(strValueOf, oet, this.EO, this.EV.getAdShowTime());
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("PAGBannerAdImpl", e.getMessage());
        }
    }

    public void IlO(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        lEW lew = new lEW(pAGBannerAdInteractionCallback);
        this.Cc = lew;
        this.IlO.setExpressInteractionListener(lew);
    }

    public void IlO(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        lEW lew = new lEW(pAGBannerAdInteractionListener);
        this.Cc = lew;
        this.IlO.setExpressInteractionListener(lew);
    }

    public View IlO() {
        com.bytedance.sdk.openadsdk.utils.MY.IlO(this.tV);
        IPMiBroadcastReceiver.IlO(this.vCE, this.tV);
        return this.IlO;
    }

    private void IlO(Context context, oeT oet, AdSlot adSlot) {
        if (oet.fdM() != null) {
            EO eo = new EO(context, oet, adSlot, this.bWL);
            this.IlO = eo;
            eo.addOnAttachStateChangeListener(this.cL);
        } else {
            tV tVVar = new tV(context, oet, adSlot, this.bWL);
            this.IlO = tVVar;
            tVVar.addOnAttachStateChangeListener(this.cL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2, oeT oet) {
        if (z2 && this.tV.NLy() && !this.tV.TkD()) {
            this.tV.Bc(true);
            oeT oet2 = this.tV;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet2, this.EO, oet2.hjY());
        }
        mmj.MY(new C0081IlO(z2, oet, this), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(View view, xF xFVar, oeT oet, String str, Bc.IlO ilO) {
        com.bytedance.sdk.openadsdk.core.DmF.MY().IlO(str, ilO);
        this.Bc = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            if (xFVar != null) {
                jSONObject.put("dynamic_show_type", xFVar.getDynamicShowType());
                xFVar.IlO(jSONObject, oet);
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", view.getWidth());
                    jSONObject2.put("height", view.getHeight());
                    jSONObject2.put("alpha", view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, this.EO, jSONObject);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(oet);
        } catch (JSONException unused2) {
            com.bytedance.sdk.component.utils.oeT.EO("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.Cc;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, oet.Jz());
        }
        if (oet.tf()) {
            zLG.IlO(oet, view);
        }
    }

    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE IlO(oeT oet) {
        if (oet.Jz() == 4) {
            return com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.vCE, oet, this.EO);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(@NonNull final xF xFVar, @NonNull final oeT oet) {
        IlO ilO;
        oeT oet2;
        final xF xFVar2;
        com.bytedance.sdk.openadsdk.core.Bc bc;
        if (xFVar == null || oet == null) {
            return;
        }
        this.tV = oet;
        this.NV = IlO(oet);
        this.EV = xFVar;
        final String strIlO = com.bytedance.sdk.openadsdk.utils.pP.IlO();
        final Bc.IlO ilOEV = EV();
        xFVar.setClosedListenerKey(strIlO);
        xFVar.setBannerClickClosedListener(ilOEV);
        xFVar.setBackupListener(new com.bytedance.sdk.component.adexpress.MY.EO() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.2
            @Override // com.bytedance.sdk.component.adexpress.MY.EO
            public boolean IlO(ViewGroup viewGroup, int i2) {
                try {
                    xFVar.cl();
                    if (!IlO.this.tV.xJ()) {
                        MY my = new MY(xFVar.getContext());
                        my.setClosedListenerKey(strIlO);
                        my.IlO(IlO.this.tV, xFVar, IlO.this.NV);
                        my.setAdInteractionListener(IlO.this.Cc);
                        return true;
                    }
                    DmF dmF = new DmF(xFVar.getContext());
                    dmF.setClosedListenerKey(strIlO);
                    dmF.IlO(IlO.this.tV, xFVar, IlO.this.NV);
                    dmF.setAdInteractionListener(IlO.this.Cc);
                    xFVar.setVastVideoHelper(dmF);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        if (!this.lEW) {
            com.bytedance.sdk.openadsdk.core.Bc bcIlO = IlO(xFVar);
            if (bcIlO == null) {
                bcIlO = new com.bytedance.sdk.openadsdk.core.Bc(this.vCE, xFVar, this.rp.IlO());
                xFVar.addView(bcIlO);
            }
            bcIlO.setAdType(1);
            xFVar2 = xFVar;
            bcIlO.setCallback(new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.3
                @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
                public void IlO(boolean z2) {
                    IlO.this.IlO(z2, oet);
                }

                @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
                public void MY() {
                    IlO ilO2 = IlO.this;
                    ilO2.MY(ilO2.tV);
                }

                @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
                public void IlO() {
                    if (IlO.this.cl != 0) {
                        IlO.this.NV();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
                public void IlO(View view) {
                    if (IlO.this.hp.compareAndSet(false, true)) {
                        IlO.this.IlO(view, xFVar2, oet, strIlO, ilOEV);
                    }
                    tV tVVar = IlO.this.IlO;
                    if (tVVar == null || tVVar.getCurView() == null) {
                        return;
                    }
                    IlO.this.IlO.getCurView().ea();
                    IlO.this.IlO.getCurView().hp();
                    IlO.this.IlO.setIsShow(true);
                }
            });
            bc = bcIlO;
            ilO = this;
            oet2 = oet;
        } else {
            boolean zIlO = this.rp.IlO();
            ssS.MY my = new ssS.MY() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.4
                @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
                public void IlO(boolean z2) {
                    IlO.this.IlO(z2, oet);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
                public void MY() {
                    IlO ilO2 = IlO.this;
                    ilO2.MY(ilO2.tV);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
                public void IlO() {
                    if (IlO.this.cl != 0) {
                        IlO.this.NV();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
                public void IlO(View view, boolean z2) {
                    if (!z2) {
                        com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(IlO.this.tV, 8);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(IlO.this.tV, 4);
                    if (IlO.this.hp.compareAndSet(false, true)) {
                        IlO.this.IlO(view, xFVar, oet, strIlO, ilOEV);
                    }
                    tV tVVar = IlO.this.IlO;
                    if (tVVar == null || tVVar.getCurView() == null) {
                        return;
                    }
                    IlO.this.IlO.getCurView().ea();
                    IlO.this.IlO.getCurView().hp();
                    IlO.this.IlO.setIsShow(true);
                }
            };
            ilO = this;
            oet2 = oet;
            ssS.IlO(xFVar, true, 1, zIlO, my, null);
            xFVar2 = xFVar;
            bc = null;
        }
        Context contextIlO = com.bytedance.sdk.component.utils.MY.IlO(xFVar2);
        if (contextIlO == null) {
            contextIlO = ilO.vCE;
        }
        com.bytedance.sdk.openadsdk.core.lEW.DmF dmF = new com.bytedance.sdk.openadsdk.core.lEW.DmF(contextIlO, oet2, ilO.EO, 2);
        dmF.IlO(xFVar2);
        dmF.IlO(this);
        dmF.IlO(ilO.NV);
        dmF.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.5
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                if (IlO.this.Cc != null) {
                    IlO.this.Cc.onAdClicked();
                }
            }
        });
        xFVar2.setClickListener(dmF);
        com.bytedance.sdk.openadsdk.core.lEW.lEW lew = new com.bytedance.sdk.openadsdk.core.lEW.lEW(ilO.vCE, oet2, ilO.EO, 2);
        lew.IlO((View) xFVar2);
        lew.IlO(this);
        lew.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.6
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                if (IlO.this.Cc != null) {
                    IlO.this.Cc.onAdClicked();
                }
            }
        });
        xF xFVar3 = ilO.EV;
        if (xFVar3 instanceof es) {
            lew.IlO(((es) xFVar3).getVideoController());
        }
        lew.IlO(ilO.NV);
        xFVar2.setClickCreativeListener(lew);
        if (ilO.lEW) {
            return;
        }
        bc.setNeedCheckingShow(true);
    }

    private com.bytedance.sdk.openadsdk.core.Bc IlO(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            try {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof com.bytedance.sdk.openadsdk.core.Bc) {
                    return (com.bytedance.sdk.openadsdk.core.Bc) childAt;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return null;
    }

    public void IlO(final com.bytedance.sdk.openadsdk.IlO.IlO.MY my) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.es > 500) {
            this.es = jCurrentTimeMillis;
            tV tVVar = this.IlO;
            if (tVVar instanceof EO) {
                tVVar.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EO.IlO.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ((EO) IlO.this.IlO).IlO(my);
                    }
                }, 500L);
            }
        }
    }
}
