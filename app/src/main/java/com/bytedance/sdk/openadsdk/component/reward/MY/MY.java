package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.hp;
import com.bytedance.sdk.openadsdk.component.reward.IlO.rp;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.bWL;
import com.bytedance.sdk.openadsdk.utils.zPa;
import com.google.mlkit.common.MlKitException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MY extends com.bytedance.sdk.openadsdk.component.reward.MY.IlO {
    protected String EV;
    public LinearLayout bWL;
    private com.bytedance.sdk.openadsdk.rp.vCE ea;
    public com.bytedance.sdk.openadsdk.core.widget.MY hp;
    protected com.bytedance.sdk.openadsdk.core.MY.Cc rp;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(boolean z2);
    }

    public MY(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    public void AXM() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        if (ilO == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.NV nv = ilO.DM;
        if (nv != null) {
            nv.zPa();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        boolean z2 = ilO2.uvo;
        ilO2.dY.IlO();
        DeviceUtils.Bc();
        this.IlO.lMM.xF();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        if (ilO3.uvo) {
            ilO3.BS.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.MY.MY.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MY.this.IlO.dY.IlO() > 0) {
                        MY.this.IlO.dY.IlO(false);
                    }
                }
            });
        }
    }

    public abstract void Bc();

    public abstract boolean Cc();

    /* JADX WARN: Removed duplicated region for block: B:8:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View DmF() {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.MY.MY.DmF():android.view.View");
    }

    public void EV() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        ilO.OOq.IlO(ilO.tV);
        this.IlO.DM.MY();
        this.IlO.mmj.IlO();
        if (!this.IlO.MY.xJ()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
            if (ilO2.Bc && TextUtils.isEmpty(oeT.IlO(ilO2.gQ, this.MY))) {
                rp();
            }
            this.IlO.lMM.IlO();
            this.IlO.nvX.IlO();
        }
        this.IlO.pP.ea();
        this.IlO.YA.IlO();
        if (OOq.Bc(this.IlO.MY)) {
            com.bytedance.sdk.component.DmF.vCE vceNV = this.IlO.lMM.NV();
            if (vceNV != null) {
                vceNV.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.IlO.lMM.EV().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.IlO.YA.EO(true);
            if (OOq.cL(this.IlO.MY)) {
                this.IlO.DM.tV();
                BS.IlO((View) vceNV, 4);
                BS.IlO((View) this.IlO.lMM.EV(), 0);
            }
        }
        if (OOq.vCE(this.IlO.MY)) {
            this.IlO.DM.tV();
            BS.IlO((View) this.IlO.lMM.NV(), 4);
        }
        if (es.tV(this.IlO.MY) || es.MY(this.IlO.MY) || es.Cc(this.IlO.MY)) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        ilO3.DM.IlO(BS.MY(ilO3.gQ, ilO3.Jz), BS.MY(this.IlO.gQ, r4.wD));
        this.IlO.kBB.IlO();
        if (OOq.cL(this.IlO.MY)) {
            this.IlO.lMM.IlO(true);
            this.IlO.lMM.Cc();
            IlO(false, false, false, MY.C0120MY.EO);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = this.IlO;
            if (ilO4.Hg) {
                ilO4.DM.IlO(0);
            }
        }
    }

    public abstract void IlO(FrameLayout frameLayout);

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.IlO
    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my, vSq vsq) {
        super.IlO(my, vsq);
        if (this.IlO.MY.vCE()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            if (ilO.qvT) {
                ilO.lMM.IlO(false);
            }
        }
        if (OOq.cL(this.IlO.MY)) {
            this.IlO.pP.rp();
        }
    }

    public View NV() {
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc;
        if (this.MY.zLG() != 5) {
            bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(this.IlO.BS);
            bc.setId(zPa.OyN);
        } else {
            bc = null;
        }
        Objects.toString(bc);
        return bc;
    }

    public final void OOq() {
        if (this.IlO.BS.isFinishing()) {
            return;
        }
        this.IlO.lMM.ea();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        String str = ilO.tV ? "reward_endcard" : "fullscreen_endcard";
        ilO.lMM.IlO(this.ea, str, ilO.ssS);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        ilO2.pP.IlO(this.ea, ilO2.uvo);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        ilO3.lMM.IlO(str, ilO3.ssS);
        this.IlO.lMM.Cc();
    }

    public void bWL() {
        com.bytedance.sdk.openadsdk.core.widget.MY my = this.hp;
        if (my == null || !my.isShowing()) {
            return;
        }
        this.hp.dismiss();
    }

    public void cL() {
        int i2;
        if (this.IlO.NV.get()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            if (!ilO.Bc && ilO.AXM.getAndSet(false) && ((i2 = this.IlO.lEW) >= 0 || i2 == -1)) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
                messageObtain.arg1 = ilO2.lEW;
                ilO2.HSR.sendMessage(messageObtain);
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        if (ilO3.DmF <= 0 || !ilO3.oeT.getAndSet(false)) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        messageObtain2.what = 900;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = this.IlO;
        messageObtain2.arg1 = ilO4.DmF;
        ilO4.HSR.sendMessage(messageObtain2);
    }

    public void cl() {
        if (!OOq.NV(this.MY) || this.IlO.lMM.zLG()) {
            cL();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        if (ilO == null) {
            return;
        }
        bWL bwl = ilO.ts;
        if (bwl != null) {
            bwl.IlO();
        }
        this.IlO.IlO();
    }

    public void ea() {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        if (ilO.Bc) {
            return;
        }
        ilO.YA.Cc();
        if (!this.IlO.tV() || (vce = this.IlO.ED) == null || vce.kBB()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
            if (ilO2.BO && (ilO2.ED instanceof com.bytedance.sdk.openadsdk.activity.IlO)) {
                return;
            }
            ilO2.DM.Cc(0);
        }
    }

    public void kBB() {
        this.IlO.YA.EO();
        this.IlO.YA.Cc(true);
    }

    public RFEndCardBackUpLayout lEW() {
        return new RFEndCardBackUpLayout(this.IlO.gQ);
    }

    public void oeT() {
        com.bytedance.sdk.openadsdk.component.reward.view.lEW lew = this.IlO.tl;
        if (lew != null) {
            lew.vCE();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.NV nv = this.IlO.DM;
        if (nv != null) {
            nv.bWL();
        }
        this.IlO.vAh.dY();
        if (!Cc()) {
            this.IlO.NV.get();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.es esVar = this.IlO.lMM;
        if (esVar != null) {
            esVar.zPa();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.lEW lew2 = this.IlO.pP;
        if (lew2 != null) {
            lew2.Bc(com.bytedance.sdk.openadsdk.component.reward.IlO.lEW.IlO);
        }
        com.bytedance.sdk.openadsdk.component.reward.view.NV nv2 = this.IlO.DM;
        if (nv2 != null) {
            nv2.rp();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.Cc cc = this.IlO.mmj;
        if (cc != null) {
            cc.EO();
        }
        rp rpVar = this.IlO.OOq;
        if (rpVar != null) {
            rpVar.MY();
        }
        bWL bwl = this.IlO.ts;
        if (bwl != null) {
            bwl.EO();
        }
    }

    public void pP() {
        this.rp = this.IlO.wPn.EO();
    }

    public void rp() {
        LinearLayout linearLayout = (LinearLayout) this.IlO.zLG.findViewById(zPa.hp);
        this.bWL = linearLayout;
        BS.IlO((View) linearLayout, 8);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        ilO.pFe = new hp(ilO.BS, ilO.MY, "landingpage_endcard");
        this.IlO.pFe.EO().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.MY.MY.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MY.this.IlO.DM.NV().performClick();
            }
        });
        this.bWL.addView(this.IlO.pFe.Cc(), new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        ilO2.lMM.IlO(ilO2.pFe);
    }

    public IlO tV() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void tl() {
        /*
            r4 = this;
            boolean r0 = r4.vCE()
            if (r0 != 0) goto L16
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.component.reward.MY.lEW
            if (r0 != 0) goto Le
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.component.reward.MY.DmF
            if (r0 == 0) goto L16
        Le:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r4.IlO
            com.bytedance.sdk.openadsdk.component.reward.IlO.EV r0 = r0.wPn
            r0.MY()
            return
        L16:
            com.bytedance.sdk.openadsdk.core.rp.tV.MY r0 = r4.DmF
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r4.Cc
            long r1 = r1.hp()
            r3 = 0
            boolean r0 = r0.IlO(r1, r3)
            if (r0 != 0) goto L4f
            com.bytedance.sdk.component.utils.vSq r0 = r4.NV
            r1 = 300(0x12c, float:4.2E-43)
            r0.removeMessages(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r4.IlO
            boolean r1 = r0.BO
            if (r1 == 0) goto L3e
            com.bytedance.sdk.openadsdk.activity.vCE r0 = r0.ED
            boolean r1 = r0 instanceof com.bytedance.sdk.openadsdk.activity.IlO
            if (r1 == 0) goto L3e
            com.bytedance.sdk.openadsdk.activity.IlO r0 = (com.bytedance.sdk.openadsdk.activity.IlO) r0
            r0.AXM()
            goto L4f
        L3e:
            int r0 = com.bytedance.sdk.openadsdk.tV.MY.C0120MY.IlO
            r4.IlO(r0)
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r0 = r4.Cc
            boolean r1 = r0.nvX()
            r1 = r1 ^ 1
            r2 = 4
            r0.IlO(r1, r2)
        L4f:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r4.IlO
            if (r0 == 0) goto L6e
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r0.MY
            if (r1 == 0) goto L6e
            com.bytedance.sdk.openadsdk.utils.bWL r0 = r0.ts
            if (r0 == 0) goto L6e
            boolean r0 = r1.pS()
            if (r0 == 0) goto L6e
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r4.IlO
            com.bytedance.sdk.openadsdk.utils.bWL r1 = r0.ts
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r0 = r0.vAh
            long r2 = r0.pP()
            r1.IlO(r2)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.MY.MY.tl():void");
    }

    public void vAh() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.lEW lew;
        com.bytedance.sdk.openadsdk.component.reward.IlO.bWL bwl;
        if (cl.tV().xF(String.valueOf(this.IlO.vCE)) == 1) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            int iIlO = ilO.tV ? OOq.EO(ilO.MY) ? cl.tV().IlO(String.valueOf(this.IlO.vCE), true) : this.IlO.MY.MY() : OOq.EO(ilO.MY) ? cl.tV().IlO(String.valueOf(this.IlO.vCE), false) : this.IlO.MY.IlO();
            com.bytedance.sdk.openadsdk.component.reward.view.NV nv = this.IlO.DM;
            if (nv != null && nv.DmF()) {
                com.bytedance.sdk.openadsdk.component.reward.view.NV nv2 = this.IlO.DM;
                if (nv2 != null) {
                    nv2.NV().performClick();
                    return;
                }
                return;
            }
            if ((!this.IlO.NV.get() || OOq.EO(this.IlO.MY)) && iIlO != -1) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = this.IlO.vAh;
                if (((clVar == null || clVar.rp() < ((long) iIlO) * 1000) && ((lew = this.IlO.pP) == null || !lew.tV(iIlO))) || (bwl = this.IlO.YA) == null) {
                    return;
                }
                bwl.tV();
            }
        }
    }

    public abstract boolean vCE();

    public boolean wPn() {
        return true;
    }

    public void xF() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        if (ilO == null) {
            return;
        }
        ilO.KC = false;
        boolean z2 = ilO.uvo;
        if (!ilO.EV.get()) {
            this.IlO.vAh.bWL();
        }
        zPa();
        this.IlO.lMM.AXM();
        this.IlO.pP.zPa();
        this.IlO.oeT.set(true);
        if (this.IlO.NV.get()) {
            this.IlO.AXM.set(true);
        }
        bWL bwl = this.IlO.ts;
        if (bwl != null) {
            bwl.MY();
        }
        this.IlO.MY();
    }

    public void zPa() {
        this.NV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        IlO(bc, this.IlO);
    }

    public void IlO(boolean z2, boolean z7, boolean z8, int i2) {
        this.IlO.mmj.IlO(z2, z7, z8, this, i2);
    }

    public void IlO(int i2) {
        this.Cc.cL();
        IlO(false, true, false, i2);
        if (this.IlO.tV) {
            this.DmF.IlO(10000);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.rp.vCE vce) {
        this.ea = vce;
        EO();
        if (!this.IlO.MY.xJ() && wPn()) {
            OOq();
        }
        if (wPn()) {
            this.IlO.mmj.MY();
        }
        if (es.tV(this.IlO.MY) || es.Cc(this.IlO.MY)) {
            this.NV.sendEmptyMessageDelayed(500, 100L);
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        ilO.DM.IlO(ilO.hL == 100.0f);
        pP();
        Bc();
    }

    public void es() {
    }

    public void hp() {
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(android.os.Message r13) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.MY.MY.IlO(android.os.Message):void");
    }

    private void IlO(long j, long j3) {
        long j8 = j3 - j;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        Activity activity = ilO.BS;
        if (activity instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) activity).MY(j8, j3);
            return;
        }
        com.bytedance.sdk.openadsdk.core.rp.tV.MY my = ilO.ssS;
        if (my instanceof com.bytedance.sdk.openadsdk.activity.Cc) {
            ((com.bytedance.sdk.openadsdk.activity.Cc) my).IlO(j8, j3);
        }
    }

    public static void IlO(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        final com.bytedance.sdk.openadsdk.core.Cc.tV tVVar;
        Context context = frameLayout.getContext();
        if (ilO.qvT) {
            com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
            eo.setId(zPa.NV);
            frameLayout.addView(eo, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayoutIlO = IlO(context);
            String strIlO = "";
            if (oeT.Cc(ilO.MY)) {
                c cVarFdM = ilO.MY.fdM();
                if (cVarFdM != null) {
                    strIlO = cVarFdM.f4689f;
                }
            } else {
                List<com.bytedance.sdk.openadsdk.core.model.zPa> listHg = ilO.MY.Hg();
                if (listHg != null && !listHg.isEmpty()) {
                    strIlO = listHg.get(0).IlO();
                }
            }
            if (TextUtils.isEmpty(strIlO)) {
                tVVar = null;
            } else {
                tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
                int i2 = zPa.VC;
                tVVar.setId(i2);
                tVVar.setTag(i2, strIlO);
                tVVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayoutIlO.addView(tVVar);
            }
            eo.addView(frameLayoutIlO);
            View eo2 = new com.bytedance.sdk.openadsdk.component.reward.view.EO(context);
            eo2.setId(zPa.rp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(eo2, layoutParams);
            eo2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.MY.MY.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View viewFindViewById = ilO.zLG.findViewById(520093757);
                    if (viewFindViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View viewFindViewById2 = ilO.zLG.findViewById(zPa.fHv);
                    if (viewFindViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = viewFindViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View viewFindViewById3 = ilO.zLG.findViewById(zPa.hjY);
                    if (viewFindViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = viewFindViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = tVVar;
                    if (tVVar2 != null) {
                        ViewGroup.LayoutParams layoutParams5 = tVVar2.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            tVVar.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
            cc.setId(zPa.hp);
            cc.setOrientation(1);
            cc.setVisibility(8);
            frameLayout.addView(cc, new FrameLayout.LayoutParams(-1, -1));
        }
        if (ilO.AK) {
            View vce = new com.bytedance.sdk.component.DmF.vCE(context, true);
            vce.setId(zPa.bWL);
            vce.setLayerType(2, null);
            vce.setVisibility(4);
            frameLayout.addView(vce, new FrameLayout.LayoutParams(-1, -1));
            View frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(zPa.ea);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (OOq.MY(ilO.MY)) {
                View eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
                eo3.setId(zPa.bYL);
                eo3.setVisibility(4);
                frameLayout.addView(eo3, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        View vce2 = new com.bytedance.sdk.component.DmF.vCE(context, true);
        vce2.setId(zPa.zPa);
        vce2.setVisibility(8);
        frameLayout.addView(vce2, new FrameLayout.LayoutParams(-1, -1));
    }

    public static FrameLayout IlO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo.setId(zPa.EV);
        eo.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        eo.setLayoutParams(layoutParams);
        return eo;
    }
}
