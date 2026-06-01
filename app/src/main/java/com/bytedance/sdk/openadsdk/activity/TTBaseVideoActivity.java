package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.component.reward.IlO.EV;
import com.bytedance.sdk.openadsdk.component.reward.IlO.lEW;
import com.bytedance.sdk.openadsdk.component.reward.MY.Bc;
import com.bytedance.sdk.openadsdk.component.reward.hp;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oc;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.dY;
import com.bytedance.sdk.openadsdk.utils.ea;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements vSq.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY {
    protected IListenerManager Cc;
    protected dY DmF;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.MY.MY EO;
    protected com.bytedance.sdk.openadsdk.rp.vCE EV;
    public final String IlO;
    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO MY;
    int NV;
    private final AtomicBoolean bWL;
    private int hp;
    boolean lEW;
    private boolean rp;
    final vSq tV;
    int vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements Runnable {
        boolean IlO;
        AdSlot MY;

        public IlO(boolean z2, AdSlot adSlot) {
            this.IlO = z2;
            this.MY = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.IlO) {
                hp.IlO(cl.IlO()).IlO(this.MY);
            } else {
                com.bytedance.sdk.openadsdk.component.reward.Cc.IlO(cl.IlO()).IlO(this.MY);
            }
        }
    }

    public TTBaseVideoActivity() {
        this.IlO = xF() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.tV = new vSq(Looper.getMainLooper(), this);
        this.rp = false;
        this.hp = 0;
        this.NV = 1;
        this.bWL = new AtomicBoolean(false);
        this.EV = new com.bytedance.sdk.openadsdk.rp.vCE() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.rp.vCE
            public void IlO() {
                TTBaseVideoActivity.this.bWL();
            }
        };
    }

    private boolean kBB() {
        if (this.MY.NV.get() && this.MY.Bc) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.MY.NV.get();
        }
        return true;
    }

    private void vAh() {
        this.EO.IlO(this.EV);
        this.vCE = (int) this.MY.vAh.YA();
        es();
        Bc();
        if (this.MY.MY.QfH() == null || this.MY.MY.QfH().IlO() == null) {
            return;
        }
        this.MY.MY.QfH().IlO().IlO(0L);
    }

    public boolean AXM() {
        return false;
    }

    public void Bc() {
        if (OOq.EO(this.MY.MY)) {
            IlO(false, MY.C0120MY.EO);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my != null) {
            my.IlO(this.MY.DM.vCE());
            this.EO.tl();
        }
    }

    public abstract void Cc();

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void DmF() {
        this.MY.vAh.mmj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void EV() {
        if (!this.MY.bWL.getAndSet(true) || OOq.EO(this.MY.MY)) {
            this.MY.wPn.IlO();
        }
    }

    public void IlO(@NonNull Intent intent) {
    }

    public IListenerManager MY(int i2) {
        if (this.Cc == null) {
            this.Cc = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().IlO(i2));
        }
        return this.Cc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public View NV() {
        return this.MY.vAh.DM();
    }

    public void cL() {
        this.tV.removeMessages(400);
    }

    public void cl() {
        Message message = new Message();
        message.what = 400;
        if (xF()) {
            IlO(10000);
        }
        this.tV.sendMessageDelayed(message, 2000L);
    }

    public void ea() {
        if (AXM() && !this.rp) {
            this.rp = true;
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
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
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = tTBaseVideoActivity.MY;
                    com.bytedance.sdk.openadsdk.component.reward.IlO.vCE vce = ilO.oc;
                    float[] fArrIlO = ilO.OOq.IlO(tTBaseVideoActivity.NV);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    vce.IlO(fArrIlO, tTBaseVideoActivity2, tTBaseVideoActivity2.EO);
                    TTBaseVideoActivity.this.zPa();
                }
            });
        }
    }

    public abstract void es();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.MY == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.utils.OOq.Cc()) {
            BS.MY((Activity) this);
        }
        if (OOq.Bc(this.MY.MY) && !this.MY.NV.get()) {
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        } else {
            if (!OOq.Cc(this.MY.MY) || this.MY.pP.lEW(lEW.MY)) {
                return;
            }
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        }
    }

    public abstract void hp();

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void lEW() {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.hp();
    }

    public void oeT() {
        oeT oet;
        oc ocVarEeU;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (oet = ilO.MY) == null || (ocVarEeU = oet.eeU()) == null) {
            return;
        }
        if (ocVarEeU.MY() == 1 || ocVarEeU.MY() == 2) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
            dY dYVar = new dY(ilO2, ilO2.MY);
            this.DmF = dYVar;
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = this.MY.vAh;
            if (clVar != null) {
                clVar.IlO(dYVar);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null) {
            return;
        }
        ilO.OOq.IlO();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my;
        if (this.MY == null || (my = this.EO) == null) {
            super.onBackPressed();
        } else {
            my.vAh();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        super.onCreate(bundle);
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onCreate ".concat(String.valueOf(this)));
        cl.MY(getApplicationContext());
        if (!bWL.Cc()) {
            finish();
            return;
        }
        oeT oetIlO = com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(getIntent(), bundle, this);
        if (oetIlO == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.MY.IlO(oetIlO);
        this.NV = oetIlO.BES();
        IlO(oetIlO, bundle);
        if (bundle != null) {
            if (oetIlO.fnd()) {
                this.bWL.set(true);
            }
            if (oetIlO.vh() && (ilO = this.MY) != null) {
                ilO.hp.set(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
            if (ilO2 != null) {
                ilO2.wPn.Bc();
            }
        }
        try {
            IlO();
            vAh();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.BVA", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.ea.EO.MY();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onDestroy ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || this.EO == null) {
            return;
        }
        if (ilO.Tx > 0 && ilO.hp.get()) {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.MY.Tx);
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(strValueOf, ilO2.MY, this.IlO, ilO2.vAh.Cc());
            this.MY.Tx = 0L;
        }
        this.MY.vSq.MY();
        this.tV.removeCallbacksAndMessages(null);
        this.EO.oeT();
        com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.MY.MY);
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY(this.MY.MY);
        AdSlot adSlotSsS = this.MY.MY.ssS();
        if (!this.MY.vAh.vSq() && adSlotSsS != null && TextUtils.isEmpty(adSlotSsS.getBidAdm()) && !this.MY.MY.uAj()) {
            bWL.MY().post(new IlO(xF(), adSlotSsS));
        }
        ea.IlO();
        dY dYVar = this.DmF;
        if (dYVar != null) {
            dYVar.Cc();
            this.DmF = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onPause ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.xF();
    }

    @Override // android.app.Activity
    public void onRestart() {
        oeT oet;
        super.onRestart();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (oet = ilO.MY) == null) {
            return;
        }
        if (this.Bc && !oet.ao() && !TextUtils.isEmpty(oeT.IlO(this, oet))) {
            finish();
        }
        if (oet.ao()) {
            oet.Cc(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my;
        super.onResume();
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onResume ".concat(String.valueOf(this)));
        if (this.MY == null || (my = this.EO) == null) {
            return;
        }
        my.cl();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        ilO.KC = true;
        ilO.OOq.MY(this.tV);
        if (kBB()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
            ilO2.YA.IlO(ilO2.MY.uF());
        }
        this.MY.DM.ea();
        this.MY.lMM.oeT();
        this.MY.pP.hp();
        if (this.EO.MY()) {
            this.MY.vAh.IlO(this.EO);
            this.MY.vAh.IlO(false, this, this.hp != 0);
        }
        this.hp++;
        ea();
        com.bytedance.sdk.openadsdk.component.reward.view.lEW lew = this.MY.tl;
        if (lew != null) {
            lew.Bc();
        }
        this.MY.OOq.IlO(this.tV);
        this.EO.es();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        if (ilO.hp.get()) {
            this.MY.MY.lEW(true);
        }
        if (this.bWL.get()) {
            this.MY.MY.qX();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(this.MY, bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onStart ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null) {
            return;
        }
        ilO.lMM.lMM();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(this, this.MY.MY);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "onStop ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.AXM();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        EV ev;
        super.onWindowFocusChanged(z2);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO != null && (ev = ilO.wPn) != null) {
            ev.MY(z2);
            this.MY.wPn.EO(z2);
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
        if (ilO2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.MY.MY my = ilO2.qz;
            if (my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.vCE) {
                ((com.bytedance.sdk.openadsdk.component.reward.MY.vCE) my).MY(z2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void vCE() {
        if (this.bWL.compareAndSet(false, true)) {
            com.bytedance.sdk.component.utils.oeT.IlO("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            hp();
        }
    }

    public abstract boolean xF();

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
    }

    private void IlO(oeT oet, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.component.reward.IlO.IlO(this, this.tV, oet, this, 0);
        this.MY = ilO;
        com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(ilO, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            IlO(intent);
            oet.IlO(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.MY.ii) {
            Cc();
        }
        com.bytedance.sdk.openadsdk.component.reward.MY.MY myIlO = Bc.IlO(this.MY);
        this.EO = myIlO;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
        ilO2.qz = myIlO;
        ea.IlO(ilO2);
        Objects.toString(this.EO);
    }

    public void IlO() {
        setContentView(this.MY.zLG);
        this.MY.zLG.IlO(this.EO);
        this.EO.IlO(this, this.tV);
        this.EO.EV();
    }

    public void IlO(boolean z2, int i2) {
        IlO(z2, false, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void rp() {
    }

    public void zPa() {
    }

    public void IlO(boolean z2, boolean z7, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.IlO(z2, z7, false, i2);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.IlO(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void EO(boolean z2) {
    }
}
