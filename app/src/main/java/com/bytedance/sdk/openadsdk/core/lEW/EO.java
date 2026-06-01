package com.bytedance.sdk.openadsdk.core.lEW;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.lEW.Cc;
import com.bytedance.sdk.openadsdk.core.tl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private int Bc;
    private xF Cc;
    private int DmF;
    private IlO EO;
    com.bytedance.sdk.openadsdk.core.model.oeT IlO;
    private final Context MY;
    private ScheduledFuture<?> lEW;
    private com.bytedance.sdk.component.adexpress.MY.ea tV;
    private int vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.lEW.EO$EO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0099EO {
        void IlO();

        void IlO(int i2, int i8);

        void IlO(String str);

        void MY(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.adexpress.MY.tV<View>, Cc.MY {
        private final int Bc;
        private final Context Cc;
        private com.bytedance.sdk.openadsdk.core.model.oeT DmF;
        private TTDislikeDialogAbstract EO;
        private String EV;
        AtomicBoolean IlO = new AtomicBoolean(false);
        private com.bytedance.sdk.openadsdk.EO.EO MY;
        private final int NV;
        private com.bytedance.sdk.component.adexpress.MY.Bc bWL;
        private PAGExpressAdWrapperListener ea;
        private int hp;
        private FrameLayout lEW;
        private Cc rp;
        private String tV;
        private final int vCE;

        public IlO(Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, int i8, String str, int i9) {
            this.EV = str;
            if (oet != null && oet.pS()) {
                this.EV = "fullscreen_interstitial_ad";
            }
            this.Cc = context;
            this.vCE = i2;
            this.Bc = i8;
            this.DmF = oet;
            this.NV = BS.MY(context, 3.0f);
            this.hp = i9;
            vCE();
        }

        private View Bc() {
            PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.Cc, this.DmF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.DmF;
            if (oet == null || !oet.pS()) {
                int i2 = this.NV;
                layoutParams.topMargin = i2;
                layoutParams.leftMargin = i2;
            } else {
                layoutParams.leftMargin = BS.MY(this.Cc, 20.0f);
                layoutParams.bottomMargin = BS.MY(this.Cc, 20.0f);
                layoutParams.gravity = 8388691;
            }
            pAGLogoViewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams);
            pAGLogoViewCreatePAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.lEW.EO.IlO.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebsiteActivity.IlO(IlO.this.Cc, IlO.this.DmF, IlO.this.EV);
                }
            });
            return pAGLogoViewCreatePAGLogoViewByMaterial;
        }

        private Cc lEW() {
            Cc ccMY = tV.IlO().MY();
            this.rp = ccMY;
            if (ccMY == null) {
                this.rp = new Cc(this.Cc);
            }
            tV.IlO().EO(this.rp);
            this.rp.IlO(this.DmF, this, this.EV);
            this.rp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.rp;
        }

        private void vCE() {
            FrameLayout frameLayout = new FrameLayout(this.Cc);
            this.lEW = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.vCE, this.Bc);
            }
            layoutParams.width = this.vCE;
            layoutParams.height = this.Bc;
            layoutParams.gravity = 17;
            this.lEW.setLayoutParams(layoutParams);
            Cc ccLEW = lEW();
            this.lEW.addView(ccLEW);
            View viewBc = Bc();
            this.lEW.addView(viewBc);
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.DmF;
            if (oet != null && oet.pS()) {
                ccLEW.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                ccLEW.IlO(((Activity) this.Cc).findViewById(com.bytedance.sdk.openadsdk.utils.zPa.pS), FriendlyObstructionPurpose.OTHER);
            }
            FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
            ccLEW.IlO(viewBc, friendlyObstructionPurpose);
            Context context = this.Cc;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View viewFindViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Ei);
            if (viewFindViewById != null) {
                ccLEW.IlO(viewFindViewById, friendlyObstructionPurpose);
            }
            View viewFindViewById2 = ((Activity) this.Cc).findViewById(com.bytedance.sdk.openadsdk.utils.zPa.OyN);
            if (viewFindViewById2 != null) {
                ccLEW.IlO(viewFindViewById2, friendlyObstructionPurpose);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.MY.tV
        public View Cc() {
            return this.lEW;
        }

        @Override // com.bytedance.sdk.component.adexpress.MY.tV
        public int EO() {
            return 5;
        }

        @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
        public View IlO() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
        public void i_() {
            if (this.bWL != null) {
                com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
                bwl.IlO(true);
                bwl.IlO(BS.EO(this.Cc, this.vCE));
                bwl.MY(BS.EO(this.Cc, this.Bc));
                this.bWL.IlO(this.lEW, bwl);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
        public View MY() {
            FrameLayout frameLayout = this.lEW;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        public void tV() {
            this.lEW = null;
            this.MY = null;
            this.EO = null;
            this.bWL = null;
            this.DmF = null;
            Cc cc = this.rp;
            if (cc != null) {
                cc.zPa();
                tV.IlO().IlO(this.rp);
            }
            this.IlO.set(true);
        }

        @Override // com.bytedance.sdk.component.adexpress.MY.tV
        public void IlO(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet;
            if (this.IlO.get()) {
                return;
            }
            if (this.Cc != null && (oet = this.DmF) != null) {
                this.bWL = bc;
                if (TextUtils.isEmpty(oet.KS())) {
                    bc.IlO(106, "dsp data is null");
                    return;
                } else {
                    this.rp.xF();
                    return;
                }
            }
            bc.IlO(106, "material null");
        }

        public void IlO(tl tlVar) {
            if (tlVar instanceof com.bytedance.sdk.openadsdk.EO.EO) {
                this.MY = (com.bytedance.sdk.openadsdk.EO.EO) tlVar;
            }
        }

        public void IlO(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet;
            if (tTDislikeDialogAbstract != null && (oet = this.DmF) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(oet.KT(), this.DmF.cJK());
            }
            this.EO = tTDislikeDialogAbstract;
        }

        public void IlO(String str) {
            this.tV = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
        public void IlO(View view, int i2) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ea;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.lEW.Cc.MY
        public void IlO(int i2, int i8) {
            com.bytedance.sdk.component.adexpress.MY.Bc bc = this.bWL;
            if (bc != null) {
                bc.IlO(i2, "render fail");
            }
        }

        public void IlO(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.ea = pAGExpressAdWrapperListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements Runnable {
        InterfaceC0099EO IlO;

        public MY(InterfaceC0099EO interfaceC0099EO) {
            this.IlO = interfaceC0099EO;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0099EO interfaceC0099EO = this.IlO;
            if (interfaceC0099EO != null) {
                interfaceC0099EO.IlO(107, 107);
            }
        }
    }

    public EO(Context context, xF xFVar, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str) {
        this.IlO = oet;
        this.MY = context;
        this.Cc = xFVar;
        IlO(xFVar);
        this.EO = new IlO(context, oet, this.vCE, this.Bc, str, this.DmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        try {
            ScheduledFuture<?> scheduledFuture = this.lEW;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.lEW.cancel(false);
            this.lEW = null;
        } catch (Throwable unused) {
        }
    }

    private void IlO(xF xFVar) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO;
        if (oet != null && oet.pS()) {
            this.vCE = -1;
            this.Bc = -1;
            return;
        }
        cl clVarIlO = com.bytedance.sdk.openadsdk.core.EO.MY.IlO(xFVar.getExpectExpressWidth(), xFVar.getExpectExpressHeight());
        this.DmF = clVarIlO.IlO;
        if (xFVar.getExpectExpressWidth() <= 0 || xFVar.getExpectExpressHeight() <= 0) {
            int iEO = BS.EO(this.MY);
            this.vCE = iEO;
            this.Bc = Float.valueOf(iEO / clVarIlO.MY).intValue();
        } else {
            this.vCE = BS.MY(this.MY, xFVar.getExpectExpressWidth());
            this.Bc = BS.MY(this.MY, xFVar.getExpectExpressHeight());
        }
        int i2 = this.vCE;
        if (i2 <= 0 || i2 <= BS.EO(this.MY)) {
            return;
        }
        this.vCE = BS.EO(this.MY);
        this.Bc = Float.valueOf(this.Bc * (BS.EO(this.MY) / this.vCE)).intValue();
    }

    public void MY() {
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.tV();
            this.EO = null;
        }
        EO();
        this.tV = null;
        this.Cc = null;
    }

    public void IlO(com.bytedance.sdk.component.adexpress.MY.ea eaVar) {
        this.tV = eaVar;
    }

    public void IlO() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO;
        if (oet != null && oet.pS()) {
            this.lEW = mmj.IlO().schedule(new MY(this.EO.rp), com.bytedance.sdk.openadsdk.core.cl.tV().pP(), TimeUnit.MILLISECONDS);
        }
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(new com.bytedance.sdk.component.adexpress.MY.Bc() { // from class: com.bytedance.sdk.openadsdk.core.lEW.EO.1
                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(View view, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
                    if (EO.this.Cc == null || view == null) {
                        if (EO.this.tV != null) {
                            EO.this.tV.a_(106);
                        }
                    } else if (EO.this.tV != null) {
                        EO.this.tV.IlO(EO.this.EO, bwl);
                    }
                    EO.this.EO();
                }

                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(int i2, String str) {
                    if (EO.this.tV != null) {
                        EO.this.tV.a_(106);
                    }
                    EO.this.EO();
                }
            });
            View viewCc = this.EO.Cc();
            this.Cc.removeView(viewCc);
            if (viewCc.getParent() != null) {
                ((ViewGroup) viewCc.getParent()).removeView(viewCc);
            }
            this.Cc.addView(viewCc, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        com.bytedance.sdk.component.adexpress.MY.ea eaVar = this.tV;
        if (eaVar != null) {
            eaVar.a_(106);
        }
    }

    public void IlO(tl tlVar) {
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(tlVar);
        }
    }

    public void IlO(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(tTDislikeDialogAbstract);
        }
    }

    public void IlO(String str) {
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(str);
        }
    }

    public void IlO(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(pAGExpressAdWrapperListener);
        }
    }
}
