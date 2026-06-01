package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import b0.b;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.a;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.activity.MY;
import com.bytedance.sdk.openadsdk.component.reward.IlO.Cc;
import com.bytedance.sdk.openadsdk.component.reward.IlO.EV;
import com.bytedance.sdk.openadsdk.component.reward.IlO.cl;
import com.bytedance.sdk.openadsdk.component.reward.MY.Bc;
import com.bytedance.sdk.openadsdk.component.reward.view.lEW;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.tV.IlO;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.ea;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import t.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends vCE implements vSq.IlO, Cc.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY {
    private Bundle Bc;
    private final AtomicBoolean Cc;
    protected com.bytedance.sdk.openadsdk.component.reward.IlO.IlO EO;
    protected final vSq IlO;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.MY.MY MY;
    private int bWL;
    private boolean ea;
    protected int tV;
    private int vCE;
    private boolean zPa;

    public IlO(MY my, oeT oet, int i2, int i8) {
        super(my, oet, i2, i8);
        this.IlO = new vSq(Looper.getMainLooper(), this);
        this.Cc = new AtomicBoolean(false);
        this.vCE = 1;
        this.bWL = 0;
        this.ea = false;
    }

    private void YA() {
        if (this.lEW.vCE()) {
            return;
        }
        if (OOq.cL(this.EO.MY)) {
            IlO(false, MY.C0120MY.EO);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my != null) {
            my.IlO(this.EO.DM.vCE());
            this.MY.tl();
        }
    }

    private void dY() {
        this.MY.IlO(this.hp);
        this.tV = (int) this.EO.vAh.YA();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO.BO) {
            IlO(ilO.wPn.Cc());
            IlO(this.EO.wPn.tV());
        }
        EO();
        YA();
        if (this.EO.MY.QfH() == null || this.EO.MY.QfH().IlO() == null) {
            return;
        }
        this.EO.MY.QfH().IlO().IlO(0L);
    }

    private boolean lMM() {
        if (this.EO.NV.get() && this.EO.Bc) {
            return false;
        }
        if (this.lEW.vCE()) {
            return this.EO.NV.get();
        }
        return true;
    }

    private void nvX() {
        if (this.lEW.vCE() && !this.ea) {
            this.ea = true;
            IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.IlO.2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    IlO ilO = IlO.this;
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = ilO.EO;
                    com.bytedance.sdk.openadsdk.component.reward.IlO.vCE vce = ilO2.oc;
                    float[] fArrIlO = ilO2.OOq.IlO(ilO.vCE);
                    IlO ilO3 = IlO.this;
                    vce.IlO(fArrIlO, ilO3, ilO3.MY);
                }
            });
        }
    }

    private void vAh() {
        this.EO.zLG.IlO(this.MY);
        this.MY.IlO(this, this.IlO);
        this.MY.EV();
    }

    public void AXM() {
        pP().IlO(this, MY(MY.C0120MY.MY));
    }

    public abstract void Bc();

    public final void Cc() {
        Message message = new Message();
        message.what = 400;
        if (this.lEW.EJ()) {
            IlO(10000);
        }
        this.IlO.sendMessageDelayed(message, 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void DmF() {
        this.EO.vAh.mmj();
    }

    public abstract void EO();

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void EO(Activity activity) {
        super.EO(activity);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.AXM();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void EV() {
        if (!this.EO.bWL.getAndSet(true) || OOq.EO(this.EO.MY)) {
            this.EO.wPn.IlO();
        }
    }

    public void IlO(int i2) {
    }

    public abstract void IlO(Bundle bundle);

    public abstract void MY();

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void MY(Activity activity) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my;
        super.MY(activity);
        if (this.EO == null || (my = this.MY) == null) {
            return;
        }
        my.cl();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        ilO.KC = true;
        ilO.OOq.MY(this.IlO);
        if (lMM()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
            ilO2.YA.IlO(ilO2.MY.uF());
        }
        this.EO.DM.ea();
        this.EO.lMM.oeT();
        this.EO.pP.hp();
        if (this.MY.MY()) {
            this.EO.vAh.IlO(this.MY);
            this.EO.vAh.IlO(false, this, this.bWL != 0);
        }
        this.bWL++;
        nvX();
        lEW lew = this.EO.tl;
        if (lew != null) {
            lew.Bc();
        }
        this.EO.OOq.IlO(this.IlO);
        this.MY.es();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final View NV() {
        return this.EO.vAh.DM();
    }

    public void cL() {
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b) CacheDirFactory.getICacheDir(this.lEW.hHv())).c(), this.lEW);
        myIlO.IlO("material_meta", this.lEW);
        myIlO.IlO("ad_slot", this.lEW.ssS());
        com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new c() { // from class: com.bytedance.sdk.openadsdk.activity.IlO.3
            @Override // t.a
            public void IlO(a aVar, int i2) {
            }

            @Override // t.a
            public void IlO(a aVar, int i2, String str) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void cl() {
        super.cl();
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my != null) {
            my.vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void ea() {
        super.ea();
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.oeT();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public boolean es() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        return ilO != null && ilO.vAh.vSq();
    }

    public final void hp() {
        this.IlO.removeMessages(400);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void lEW() {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.hp();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public com.bytedance.sdk.openadsdk.component.reward.IlO.IlO oeT() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void tV() {
        vSq();
        this.EO.MY.Ei();
        this.EO.MY.IlO(true);
        if (oeT.Cc(this.EO.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
            oeT oet = ilO.MY;
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, ilO.Cc, oet.VC());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void vCE() {
        if (this.Cc.compareAndSet(false, true)) {
            com.bytedance.sdk.component.utils.oeT.IlO("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            Bc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public String xF() {
        return this.EO.quf;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.Cc.IlO
    public void zPa() {
        EO eoBc;
        MY myPP = pP();
        if (myPP == null || (eoBc = myPP.Bc()) == null) {
            return;
        }
        eoBc.Bc();
    }

    public void IlO(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void EO(boolean z2) {
        if (pP() != null) {
            pP().IlO(this, z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void IlO(Activity activity, Bundle bundle) {
        this.Bc = bundle;
        super.IlO(activity, bundle);
        IlO(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void Cc(Activity activity) {
        super.Cc(activity);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.xF();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void tV(Activity activity) {
        super.tV(activity);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO == null) {
            return;
        }
        ilO.lMM.lMM();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(activity, this.EO.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final View IlO() {
        return this.EO.zLG;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(Activity activity, MY.Cc cc) {
        super.IlO(activity, cc);
        this.vCE = this.lEW.BES();
        IlO(this.lEW, this.Bc);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO.BO && this.DmF > 0) {
            ilO.uvo = cc.tV;
        }
        try {
            vAh();
            dY();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AdScene", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.ea.EO.MY();
            OOq();
        }
    }

    private void IlO(oeT oet, Bundle bundle) {
        Activity activityTl = tl();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.component.reward.IlO.IlO(activityTl, this.IlO, oet, this, 1);
        this.EO = ilO;
        ilO.BO = pP().EO();
        this.EO.dm = pP().MY();
        this.EO.gm = pP().IlO();
        this.EO.aa = pP().NV();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        ilO2.ED = this;
        ilO2.dY = pP().es();
        Intent intent = activityTl.getIntent();
        com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(this.EO, intent, bundle);
        if (intent != null) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(intent, this.EO);
            oet.IlO(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.EO.ii) {
            MY();
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY myIlO = Bc.IlO(this.EO);
        this.MY = myIlO;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.EO;
        ilO3.qz = myIlO;
        ilO3.mmj.IlO(this);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = this.EO;
        if (ilO4.BO) {
            ilO4.vAh.IlO(new IlO.InterfaceC0108IlO() { // from class: com.bytedance.sdk.openadsdk.activity.IlO.1
                @Override // com.bytedance.sdk.openadsdk.core.rp.tV.IlO.InterfaceC0108IlO
                public void IlO(int i2) {
                    MY myPP = IlO.this.pP();
                    if (myPP == null) {
                        return;
                    }
                    myPP.IlO(i2);
                }
            });
            pP().NV().setShowSound(oeT.Cc(oet));
        }
        ea.IlO(this.EO);
        Objects.toString(this.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void bWL() {
    }

    public void rp() {
    }

    public MY.Cc MY(int i2) {
        MY.Cc cc = new MY.Cc(i2, this.EO);
        cc.tV = this.EO.uvo;
        return cc;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void MY(boolean z2) {
        EV ev;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO != null && (ev = ilO.wPn) != null) {
            ev.MY(z2);
            this.EO.wPn.EO(z2);
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        if (ilO2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.MY.MY my = ilO2.qz;
            if (my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.vCE) {
                ((com.bytedance.sdk.openadsdk.component.reward.MY.vCE) my).MY(z2);
            }
        }
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.MY.MY my) {
        if (my != null) {
            HashMap map = new HashMap();
            try {
                int i2 = this.NV + 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i2);
                map.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            my.IlO(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(Activity activity) {
        super.IlO(activity);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO == null) {
            return;
        }
        ilO.OOq.IlO();
    }

    public final void IlO(boolean z2, int i2) {
        IlO(z2, false, i2);
    }

    public final void IlO(boolean z2, boolean z7, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        ilO.mmj.IlO(z2, z7, false, ilO.qz, i2);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public final void IlO(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.IlO(message);
    }

    public void IlO(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || pP() == null) {
            return;
        }
        pP().MY(this, MY(7));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.Cc.IlO
    public void IlO(boolean z2, boolean z7, boolean z8, com.bytedance.sdk.openadsdk.component.reward.MY.MY my, int i2) {
        IlO(z2, z7, z8, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(vCE vce, vCE vce2, MY.Cc cc) {
        super.IlO(vce, vce2, cc);
        if (vce == this && (vce2 instanceof EO)) {
            int i2 = cc.MY;
            if (i2 == 3) {
                cl clVar = this.EO.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, 2);
            } else if (i2 == 6) {
                cl clVar2 = this.EO.vAh;
                clVar2.IlO(!clVar2.nvX() ? 1 : 0, !this.EO.vAh.nvX() ? 1 : 0);
            } else if (i2 == 5 && !oeT.Cc(this.EO.MY) && cc.Cc) {
                this.EO.vAh.IlO("skip", true);
            }
            this.EO.YA.IlO(false);
            this.EO.YA.tV(false);
        }
        if (vce2.DmF != 0 || this.DmF == 0) {
            return;
        }
        if (!TextUtils.isEmpty(this.lEW.mmj())) {
            this.lEW.DmF("0");
        }
        Map<String, Object> mapTN = this.lEW.tN();
        if (mapTN == null || !mapTN.containsKey("price")) {
            return;
        }
        mapTN.put("price", "0");
    }

    public void IlO(float f4) {
        MY myPP = pP();
        if (myPP == null) {
            return;
        }
        myPP.IlO(f4);
        if (this.zPa || f4 < this.lEW.Ipx() / 100.0f) {
            return;
        }
        this.zPa = true;
        IlO ilOLEW = myPP.lEW();
        if (ilOLEW != null) {
            ilOLEW.cL();
        }
    }
}
