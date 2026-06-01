package com.bytedance.sdk.openadsdk.activity;

import a1.a;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.component.reward.EV;
import com.bytedance.sdk.openadsdk.component.reward.hp;
import com.bytedance.sdk.openadsdk.core.Cc.lEW;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.rp.NV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DmF;
import com.bytedance.sdk.openadsdk.utils.bWL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static com.bytedance.sdk.openadsdk.IlO.Cc.IlO EO;
    private static com.bytedance.sdk.openadsdk.IlO.EO.MY tV;
    private Bundle AXM;
    private com.bytedance.sdk.openadsdk.IlO.EO.MY DmF;
    private boolean EV;
    public bWL IlO;
    public EV MY;
    private boolean NV;
    private int OOq;
    private vCE bWL;
    private com.bytedance.sdk.openadsdk.core.Cc.EO cL;
    private com.bytedance.sdk.openadsdk.activity.EO cl;
    private int ea;
    private lEW es;
    private Activity hp;
    private AbstractC0072MY kBB;
    private com.bytedance.sdk.openadsdk.IlO.Cc.IlO lEW;
    private final NV oc;
    private com.bytedance.sdk.openadsdk.bWL.EV oeT;
    private boolean pP;
    private boolean rp;
    private boolean tl;
    private com.bytedance.sdk.openadsdk.component.reward.top.EO vAh;
    private final oeT vCE;
    private boolean vSq;
    private Runnable wPn;
    private int xF;
    private com.bytedance.sdk.openadsdk.core.Cc.EO zPa;
    private final List<vCE> Cc = new ArrayList();
    private final Bundle Bc = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Cc {
        public boolean Cc;
        public final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO EO;
        public final Bundle IlO = new Bundle();
        public final int MY;
        public boolean tV;

        public Cc(int i2, com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
            this.MY = i2;
            this.EO = ilO;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements Runnable {
        private final oeT IlO;

        public EO(oeT oet) {
            this.IlO = oet;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.IlO.uAj()) {
                return;
            }
            if (this.IlO.EJ()) {
                hp.IlO(cl.IlO()).IlO(this.IlO.ssS());
            } else {
                com.bytedance.sdk.openadsdk.component.reward.Cc.IlO(cl.IlO()).IlO(this.IlO.ssS());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends AbstractC0072MY {
        public IlO(MY my, oeT oet, com.bytedance.sdk.openadsdk.component.reward.top.EO eo) {
            super(my, oet, eo);
        }

        @Override // com.bytedance.sdk.openadsdk.activity.MY.AbstractC0072MY
        public int IlO(oeT oet) {
            if (oet != null) {
                return oet.IlO();
            }
            return 5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.activity.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class AbstractC0072MY implements Handler.Callback {
        protected int Cc;
        private final Context DmF;
        protected float EO;
        private boolean EV;
        protected final MY IlO;
        protected final oeT MY;
        private boolean NV;
        private float hp;
        private final com.bytedance.sdk.openadsdk.component.reward.top.EO lEW;
        private boolean rp;
        protected int tV;
        private final Handler Bc = new Handler(Looper.getMainLooper(), this);
        protected int vCE = -1;
        private final int bWL = 1000;
        private int ea = 1000;

        public AbstractC0072MY(MY my, oeT oet, com.bytedance.sdk.openadsdk.component.reward.top.EO eo) {
            this.IlO = my;
            this.MY = oet;
            this.lEW = eo;
            this.DmF = eo.getContext();
            this.tV = IlO(oet);
        }

        private void Cc() {
            if (this.IlO.kBB()) {
                this.lEW.showSkipButton();
                this.NV = true;
            } else {
                this.EV = true;
                this.lEW.showCloseButton();
            }
        }

        private void tV() {
            int i2 = this.vCE;
            if (i2 > 0) {
                this.vCE = i2 - 1;
            }
            if (this.vCE == 0 && this.rp) {
                this.rp = false;
                MY my = this.IlO;
                if (my == null || my.vAh() == null) {
                    return;
                }
                vCE vceVAh = this.IlO.vAh();
                if (vceVAh instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                    ((com.bytedance.sdk.openadsdk.activity.EO) vceVAh).cL();
                }
            }
        }

        public void EO() {
            this.Bc.removeMessages(this.Cc);
        }

        public abstract int IlO(oeT oet);

        public void IlO() {
            this.Bc.removeMessages(this.Cc);
        }

        public void MY() {
            if (this.tV < 0 || this.NV || this.EV) {
                return;
            }
            this.Bc.removeMessages(this.Cc);
            this.Bc.sendEmptyMessage(this.Cc);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (this.tV > 0) {
                    com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.lEW;
                    StringBuilder sb = new StringBuilder();
                    int i8 = this.tV;
                    this.tV = i8 - 1;
                    sb.append(i8);
                    sb.append("s");
                    eo.setSkipText(sb.toString());
                    tV();
                    if (this.tV >= 0) {
                        this.Bc.removeMessages(message.what);
                        this.Bc.sendEmptyMessageDelayed(message.what, this.ea);
                    }
                } else {
                    MY(3);
                    Cc();
                }
            } else if (i2 == 2) {
                if (this.tV > 0) {
                    com.bytedance.sdk.openadsdk.component.reward.top.EO eo2 = this.lEW;
                    StringBuilder sb2 = new StringBuilder();
                    int i9 = this.tV;
                    this.tV = i9 - 1;
                    sb2.append(i9);
                    sb2.append("s");
                    eo2.setSkipText(sb2.toString());
                    tV();
                    if (this.tV >= 0) {
                        this.Bc.removeMessages(message.what);
                        this.Bc.sendEmptyMessageDelayed(message.what, this.ea);
                    }
                } else {
                    MY(3);
                    Cc();
                }
            } else if (i2 == 3 && this.vCE > 0) {
                tV();
                if (this.vCE >= 0) {
                    this.Bc.removeMessages(message.what);
                    this.Bc.sendEmptyMessageDelayed(message.what, 1000L);
                }
            }
            return true;
        }

        public void IlO(boolean z2) {
            if (z2) {
                this.ea = (int) (1000.0f / this.hp);
            } else {
                this.ea = 1000;
            }
        }

        private void MY(int i2) {
            if (this.vCE > 0 && this.rp && i2 == 3) {
                this.Bc.removeMessages(i2);
                this.Bc.sendEmptyMessageDelayed(i2, 1000L);
            }
        }

        public void IlO(int i2) {
            this.vCE = i2;
            if (i2 > 0) {
                this.rp = true;
                if (this.tV <= 0 || this.NV) {
                    MY(3);
                }
            }
        }

        public void IlO(int i2, oeT oet) {
            if (oet != null && oet.eeU() != null) {
                this.hp = oet.eeU().IlO();
            }
            StringBuilder sbV = a.v(i2, "onSceneChanged: newTotalVideoDuration=", ", countDownSeconds=");
            sbV.append(this.tV);
            sbV.append(", hasShowSkip=");
            sbV.append(this.NV);
            sbV.append(", hasShowClose=");
            sbV.append(this.EV);
            sbV.append(", msgType=");
            sbV.append(this.Cc);
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AdSceneManager", sbV.toString());
            if (this.NV || this.EV) {
                return;
            }
            float f4 = i2;
            this.EO = f4;
            int i8 = this.Cc;
            if (f4 <= this.tV) {
                this.Cc = 2;
                this.tV = (int) f4;
            } else if (i8 == 0) {
                this.Cc = 1;
            }
            int i9 = this.Cc;
            if (i8 == i9 && this.Bc.hasMessages(i9)) {
                return;
            }
            this.Bc.removeCallbacksAndMessages(null);
            this.Bc.sendEmptyMessage(this.Cc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class tV extends AbstractC0072MY {
        private final int Bc;
        private boolean DmF;
        private int lEW;

        public tV(MY my, oeT oet, com.bytedance.sdk.openadsdk.component.reward.top.EO eo) {
            super(my, oet, eo);
            if (oet == null) {
                this.Bc = 100;
            } else if (oet.vSq() >= 0) {
                this.Bc = Math.min(100, oet.vSq());
            } else {
                this.Bc = cl.tV().tl(String.valueOf(oet.hFV())).vCE;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.activity.MY.AbstractC0072MY
        public int IlO(oeT oet) {
            if (oet != null) {
                return oet.drv();
            }
            return 30;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.MY.AbstractC0072MY, android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (!this.DmF && this.tV <= this.lEW) {
                this.DmF = true;
                vCE vceVAh = this.IlO.vAh();
                if (vceVAh instanceof com.bytedance.sdk.openadsdk.activity.Cc) {
                    ((com.bytedance.sdk.openadsdk.activity.Cc) vceVAh).vAh();
                } else if ((this.IlO.MY() || this.IlO.IlO()) && !vceVAh.kBB() && (vceVAh instanceof com.bytedance.sdk.openadsdk.activity.EO)) {
                    ((com.bytedance.sdk.openadsdk.activity.EO) vceVAh).Cc();
                }
            }
            super.handleMessage(message);
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.MY.AbstractC0072MY
        public void IlO(int i2, oeT oet) {
            boolean z2 = this.Cc == 0;
            int i8 = this.tV;
            super.IlO(i2, oet);
            if (!z2) {
                if (this.EO < i8) {
                    this.lEW = (int) ((1.0f - (this.Bc / 100.0f)) * this.tV);
                    return;
                }
                return;
            }
            if (this.Cc == 1) {
                this.lEW = 3;
            } else {
                this.lEW = (int) ((1.0f - (this.Bc / 100.0f)) * this.EO);
            }
            EV ev = this.IlO.MY;
            if (ev != null) {
                ev.IlO(this.tV);
            }
        }
    }

    public MY(Activity activity, oeT oet) {
        this.vCE = oet;
        this.hp = activity;
        this.oc = new NV(activity.getApplicationContext());
        xF();
    }

    private void AXM() {
        this.IlO = DmF.IlO(this.hp, new DmF.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.MY.2
            @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
            public View IlO() {
                if (MY.this.vAh != null) {
                    return MY.this.vAh.getCloseButton();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
            public void MY() {
                if (MY.this.vAh != null) {
                    MY.this.vAh.setSkipInvisiable();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kBB() {
        if (this.Cc.isEmpty()) {
            return false;
        }
        return this.Cc.get(r0.size() - 1) instanceof com.bytedance.sdk.openadsdk.activity.EO;
    }

    private boolean oeT() {
        com.bytedance.sdk.openadsdk.core.model.IlO ilOIuH;
        oeT oet = this.vCE;
        boolean z2 = false;
        if (!(oet instanceof vAh) || (ilOIuH = ((vAh) oet).iuH()) == null) {
            return false;
        }
        boolean z7 = ilOIuH.hp() && com.bytedance.sdk.openadsdk.core.settings.hp.aP().tU();
        this.NV = z7;
        this.EV = z7 && 39 == this.vCE.vAh();
        if (this.NV && 40 == this.vCE.vAh()) {
            z2 = true;
        }
        this.rp = z2;
        return this.NV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public vCE vAh() {
        return this.bWL;
    }

    private void xF() {
        boolean zHp = com.bytedance.sdk.openadsdk.core.settings.hp.aP().hp(String.valueOf(this.vCE.hFV()));
        int iMY = oeT() ? MY(0, zHp) : 0;
        if (this.Cc.isEmpty() && !OOq.EO(this.vCE)) {
            int i2 = iMY + 1;
            this.Cc.add(IlO(this, this.vCE, iMY, i2));
            iMY = i2;
        }
        IlO(iMY, zHp);
        if (this.vCE.EJ()) {
            this.MY = new EV(new EV.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.MY.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.EV.IlO
                public void IlO() {
                    if (MY.this.EV().getBoolean("reward_verify", false) || MY.this.ea() || MY.this.EV().getBoolean("user_has_give_up_reward", false)) {
                        return;
                    }
                    for (vCE vce : MY.this.Cc) {
                        if (vce instanceof com.bytedance.sdk.openadsdk.activity.Cc) {
                            ((com.bytedance.sdk.openadsdk.activity.Cc) vce).EO(1);
                            return;
                        } else if (vce instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                            ((com.bytedance.sdk.openadsdk.activity.EO) vce).MY(1);
                            return;
                        }
                    }
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.activity.EO Bc() {
        com.bytedance.sdk.openadsdk.activity.EO eo = this.cl;
        if (eo != null) {
            return eo;
        }
        vCE vce = this.bWL;
        int i2 = vce != null ? vce.DmF : -1;
        int size = this.Cc.size() - 1;
        while (true) {
            if (size <= i2) {
                break;
            }
            vCE vce2 = this.Cc.get(size);
            if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                this.cl = (com.bytedance.sdk.openadsdk.activity.EO) vce2;
                break;
            }
            size--;
        }
        return this.cl;
    }

    public int DmF() {
        return this.ea;
    }

    public Bundle EV() {
        return this.Bc;
    }

    public com.bytedance.sdk.openadsdk.component.reward.top.EO NV() {
        return this.vAh;
    }

    public void bWL() {
        if (cl()) {
            return;
        }
        cL();
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.lEW;
        if (ilO != null) {
            ilO.IlO();
        } else {
            com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.DmF;
            if (my != null) {
                my.IlO();
            }
        }
        Runnable runnable = this.wPn;
        if (runnable != null) {
            runnable.run();
            this.wPn = null;
        }
    }

    public void cL() {
        this.pP = true;
    }

    public boolean cl() {
        return this.pP;
    }

    public boolean ea() {
        return this.tl;
    }

    public NV es() {
        return this.oc;
    }

    public void hp() {
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.lEW;
        if (ilO != null) {
            ilO.MY();
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.DmF;
        if (my != null) {
            my.MY();
        }
    }

    public com.bytedance.sdk.openadsdk.activity.IlO lEW() {
        vCE vce;
        vCE vce2 = this.bWL;
        if (vce2 == null) {
            return null;
        }
        int i2 = vce2.DmF;
        do {
            i2++;
            if (i2 >= this.Cc.size()) {
                return null;
            }
            vce = this.Cc.get(i2);
        } while (!(vce instanceof com.bytedance.sdk.openadsdk.activity.IlO));
        return (com.bytedance.sdk.openadsdk.activity.IlO) vce;
    }

    public void rp() {
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.lEW;
        if (ilO != null) {
            ilO.onAdClicked();
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.DmF;
        if (my != null) {
            my.onAdClicked();
        }
    }

    public void vCE() {
        vCE vce = this.bWL;
        if (vce != null) {
            vce.cl();
        }
    }

    public void zPa() {
        this.tl = true;
        EV ev = this.MY;
        if (ev != null) {
            ev.EO();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[PHI: r6
  0x0079: PHI (r6v3 int) = (r6v0 int), (r6v2 int), (r6v2 int), (r6v0 int) binds: [B:14:0x003c, B:21:0x0059, B:23:0x0063, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int MY(int r10, boolean r11) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r9.vCE
            com.bytedance.sdk.openadsdk.core.model.vAh r0 = (com.bytedance.sdk.openadsdk.core.model.vAh) r0
            com.bytedance.sdk.openadsdk.core.model.IlO r0 = r0.iuH()
            java.util.List r0 = r0.tV()
            if (r0 == 0) goto L7d
            int r1 = r0.size()
            r9.OOq = r1
            r2 = 0
            r3 = r2
        L16:
            if (r3 >= r1) goto L7d
            java.lang.Object r4 = r0.get(r3)
            com.bytedance.sdk.openadsdk.core.model.oeT r4 = (com.bytedance.sdk.openadsdk.core.model.oeT) r4
            java.util.List<com.bytedance.sdk.openadsdk.activity.vCE> r5 = r9.Cc
            int r6 = r10 + 1
            com.bytedance.sdk.openadsdk.activity.vCE r7 = IlO(r9, r4, r10, r3)
            r5.add(r7)
            boolean r5 = r9.MY()
            if (r5 != 0) goto L35
            boolean r5 = r9.IlO()
            if (r5 == 0) goto L79
        L35:
            int r5 = r1 + (-1)
            if (r3 != r5) goto L3b
            r5 = 1
            goto L3c
        L3b:
            r5 = r2
        L3c:
            if (r11 == 0) goto L79
            if (r5 == 0) goto L46
            boolean r7 = r9.IlO()
            if (r7 == 0) goto L59
        L46:
            boolean r7 = r9.IlO(r4)
            if (r7 == 0) goto L59
            java.util.List<com.bytedance.sdk.openadsdk.activity.vCE> r7 = r9.Cc
            com.bytedance.sdk.openadsdk.activity.EO r8 = new com.bytedance.sdk.openadsdk.activity.EO
            int r10 = r10 + 2
            r8.<init>(r9, r4, r6, r3)
            r7.add(r8)
            r6 = r10
        L59:
            if (r5 == 0) goto L79
            com.bytedance.sdk.openadsdk.core.model.oeT r10 = r9.vCE
            com.bytedance.sdk.openadsdk.core.model.vAh r10 = (com.bytedance.sdk.openadsdk.core.model.vAh) r10
            com.bytedance.sdk.openadsdk.core.model.IlO r10 = r10.iuH()
            if (r10 == 0) goto L79
            com.bytedance.sdk.openadsdk.activity.EO r5 = new com.bytedance.sdk.openadsdk.activity.EO
            com.bytedance.sdk.openadsdk.core.model.vAh r7 = new com.bytedance.sdk.openadsdk.core.model.vAh
            r7.<init>(r10, r4)
            int r10 = r6 + 1
            r5.<init>(r9, r7, r6, r3)
            r9.cl = r5
            java.util.List<com.bytedance.sdk.openadsdk.activity.vCE> r4 = r9.Cc
            r4.add(r5)
            goto L7a
        L79:
            r10 = r6
        L7a:
            int r3 = r3 + 1
            goto L16
        L7d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.MY.MY(int, boolean):int");
    }

    public void Cc(TTAdActivity tTAdActivity) {
        this.xF = 6;
        int iTV = tV();
        for (vCE vce : this.Cc) {
            if (vce.DmF >= iTV) {
                vce.ea();
            }
        }
        vCE vce2 = this.bWL;
        if (vce2 != null) {
            vce2.wPn();
        }
        vCE vce3 = this.bWL;
        if (vce3 != null && !vce3.es() && !this.vCE.uAj()) {
            com.bytedance.sdk.openadsdk.core.bWL.MY().post(new EO(this.vCE));
        }
        AbstractC0072MY abstractC0072MY = this.kBB;
        if (abstractC0072MY != null) {
            abstractC0072MY.EO();
        }
        bWL bwl = this.IlO;
        if (bwl != null) {
            bwl.EO();
        }
        this.bWL = null;
        this.hp = null;
    }

    public boolean EO() {
        return this.NV;
    }

    public boolean IlO() {
        return this.rp;
    }

    public void tV(TTAdActivity tTAdActivity) {
        this.xF = 5;
        vCE vce = this.bWL;
        if (vce != null) {
            vce.EO(tTAdActivity);
        }
    }

    private void EO(vCE vce, Cc cc) {
        if (this.hp == null) {
            return;
        }
        tV();
        if (vce == null) {
            vCE vce2 = this.bWL;
            int i2 = vce2 != null ? vce2.DmF + 1 : 0;
            if (i2 < this.Cc.size()) {
                vce = this.Cc.get(i2);
            }
            if (vce == null) {
                IlO(this.bWL);
                return;
            }
        }
        vCE vce3 = this.bWL;
        if (vce3 != null) {
            if (vce3 == vce) {
                return;
            }
            vce3.Cc(this.hp);
            this.bWL.EO(this.hp);
            View viewIlO = this.bWL.IlO();
            if (viewIlO != null) {
                this.cL.removeView(viewIlO);
            }
            this.bWL.ea();
            this.bWL.EV = false;
            if (MY() || IlO()) {
                vCE vce4 = this.bWL;
                if (vce4 instanceof com.bytedance.sdk.openadsdk.activity.IlO) {
                    int i8 = vce4.DmF + 1;
                    vCE vce5 = i8 < this.Cc.size() ? this.Cc.get(i8) : null;
                    if ((vce5 instanceof com.bytedance.sdk.openadsdk.activity.EO) && vce5 != vce) {
                        View viewIlO2 = vce5.IlO();
                        if (viewIlO2 != null && viewIlO2.getParent() != null && (viewIlO2.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) viewIlO2.getParent()).removeView(viewIlO2);
                        }
                        vce5.ea();
                    }
                }
            }
        }
        vce.EV = true;
        vce.IlO(this.hp, cc);
        View viewIlO3 = vce.IlO();
        if (viewIlO3 != null) {
            ViewParent parent = viewIlO3.getParent();
            if (parent != null) {
                if (parent == this.cL) {
                    viewIlO3.setVisibility(0);
                } else if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewIlO3);
                }
            }
            if (viewIlO3.getParent() == null) {
                this.cL.addView(viewIlO3, new ViewGroup.LayoutParams(-1, -1));
            }
            if (!this.vSq) {
                ViewParent parent2 = this.zPa.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(this.zPa);
                }
                this.hp.setContentView(this.zPa);
                this.vSq = true;
            }
        }
        vCE vce6 = this.bWL;
        this.bWL = vce;
        IlO(vce6, vce, cc);
    }

    private void IlO(int i2, boolean z2) {
        if ((IlO() || MY()) && Bc() != null) {
            return;
        }
        if (!z2 && !OOq.EO(this.vCE)) {
            if (EO()) {
                AXM();
                return;
            }
            return;
        }
        this.Cc.add(new com.bytedance.sdk.openadsdk.activity.EO(this, this.vCE, i2, i2));
    }

    public int tV() {
        vCE vce = this.bWL;
        if (vce != null) {
            return vce.DmF;
        }
        return -1;
    }

    public boolean IlO(oeT oet) {
        return (oet == null || oet.ie() == null || oet.ie().MY() <= 0) ? false : true;
    }

    private static vCE IlO(MY my, oeT oet, int i2, int i8) {
        boolean zEJ = oet.EJ();
        AdSlot adSlotSsS = oet.ssS();
        if (adSlotSsS != null) {
            zEJ = adSlotSsS.getDurationSlotType() == 7;
        }
        if (zEJ) {
            return new com.bytedance.sdk.openadsdk.activity.Cc(my, oet, i2, i8);
        }
        return new com.bytedance.sdk.openadsdk.activity.tV(my, oet, i2, i8);
    }

    public boolean MY() {
        return this.EV;
    }

    private void MY(vCE vce) {
        com.bytedance.sdk.openadsdk.bWL.EV ev = this.oeT;
        if (ev != null) {
            BS.Bc(ev);
            this.oeT = null;
        }
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.vAh;
        if (eo != null) {
            BS.Bc(eo);
            BS.Bc(this.vAh.getITopLayout());
            this.vAh = null;
        }
        AbstractC0072MY abstractC0072MY = this.kBB;
        if (abstractC0072MY != null) {
            abstractC0072MY.EO();
        }
        if (vce instanceof com.bytedance.sdk.openadsdk.activity.Cc) {
            ((com.bytedance.sdk.openadsdk.activity.Cc) vce).vAh();
        }
        bWL bwl = this.IlO;
        if (bwl != null) {
            bwl.EO();
        }
    }

    public void IlO(TTAdActivity tTAdActivity, Bundle bundle, com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO, com.bytedance.sdk.openadsdk.IlO.EO.MY my) {
        this.AXM = bundle;
        this.xF = 1;
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(tTAdActivity);
        this.zPa = eo;
        if (Build.VERSION.SDK_INT >= 35) {
            eo.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(tTAdActivity);
        this.cL = eo2;
        this.zPa.addView(eo2, new FrameLayout.LayoutParams(-1, -1));
        if (this.NV) {
            this.oeT = new com.bytedance.sdk.openadsdk.bWL.EV(tTAdActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, BS.MY(tTAdActivity, 2.0f));
            layoutParams.gravity = 80;
            this.zPa.addView(this.oeT, layoutParams);
            lEW lew = new lEW(tTAdActivity);
            this.es = lew;
            lew.setTextColor(-1);
            this.es.setTextSize(15.0f);
            this.es.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = BS.MY(tTAdActivity, 60.0f);
            layoutParams2.rightMargin = BS.MY(tTAdActivity, 16.0f);
            layoutParams2.gravity = 8388661;
            this.zPa.addView(this.es, layoutParams2);
            com.bytedance.sdk.openadsdk.component.reward.top.EO eo3 = new com.bytedance.sdk.openadsdk.component.reward.top.EO(tTAdActivity);
            this.vAh = eo3;
            this.zPa.addView(eo3, new FrameLayout.LayoutParams(-1, -2));
            this.vAh.IlO(this.vCE);
            this.vAh.setShowDislike(true);
        }
        this.lEW = ilO;
        this.DmF = my;
        if (ilO == null && bundle != null) {
            this.lEW = EO;
            EO = null;
        }
        if (my == null && bundle != null) {
            this.DmF = tV;
            tV = null;
        }
        EO(null, new Cc(1, null));
    }

    public Activity Cc() {
        return this.hp;
    }

    public void MY(TTAdActivity tTAdActivity) {
        this.xF = 3;
        vCE vce = this.bWL;
        if (vce != null) {
            vce.MY(tTAdActivity);
        }
        AbstractC0072MY abstractC0072MY = this.kBB;
        if (abstractC0072MY != null) {
            abstractC0072MY.MY();
        }
        bWL bwl = this.IlO;
        if (bwl != null) {
            bwl.IlO();
        }
        EV ev = this.MY;
        if (ev != null) {
            ev.MY();
        }
    }

    public void MY(vCE vce, Cc cc) {
        vCE vce2 = this.bWL;
        if (vce2 == null || vce2 == vce) {
            if (vce2 != null && (vce2 instanceof com.bytedance.sdk.openadsdk.activity.IlO)) {
                final long jRp = (vce2.oeT() == null || this.bWL.oeT().vAh == null) ? 0L : this.bWL.oeT().vAh.rp();
                final int i2 = this.bWL.NV + 1;
                long jCurrentTimeMillis = System.currentTimeMillis();
                vCE vce3 = this.bWL;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(jCurrentTimeMillis, vce3.lEW, vce3.b_(), "dislike_skip", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.MY.3
                    @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                    public JSONObject IlO() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("duration", jRp);
                            com.bytedance.sdk.openadsdk.tV.EO.IlO(i2, jSONObject);
                            return jSONObject;
                        } catch (Throwable th) {
                            th.getMessage();
                            return jSONObject;
                        }
                    }
                });
            }
            vCE vceLEW = lEW();
            if (vceLEW == null) {
                vceLEW = Bc();
            }
            EO(vceLEW, cc);
        }
    }

    public void EO(TTAdActivity tTAdActivity) {
        this.xF = 4;
        vCE vce = this.bWL;
        if (vce != null) {
            vce.Cc(tTAdActivity);
        }
        AbstractC0072MY abstractC0072MY = this.kBB;
        if (abstractC0072MY != null) {
            abstractC0072MY.IlO();
        }
        bWL bwl = this.IlO;
        if (bwl != null) {
            bwl.MY();
        }
        EV ev = this.MY;
        if (ev != null) {
            ev.IlO();
        }
    }

    public boolean MY(int i2) {
        return i2 == this.Cc.size() - 1 && this.Cc.get(i2) != null && (this.Cc.get(i2) instanceof com.bytedance.sdk.openadsdk.activity.EO);
    }

    private void IlO(vCE vce, vCE vce2, Cc cc) {
        if (this.NV) {
            if (!MY() && !IlO()) {
                boolean z2 = vce2 instanceof com.bytedance.sdk.openadsdk.activity.IlO;
                if (z2) {
                    this.ea++;
                    IlO(0.0f);
                    if (this.kBB == null) {
                        if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.tV) {
                            this.kBB = new IlO(this, this.vCE, this.vAh);
                        } else {
                            this.kBB = new tV(this, this.vCE, this.vAh);
                        }
                    }
                    int i2 = 0;
                    for (int i8 = vce2.DmF; i8 < this.Cc.size(); i8++) {
                        vCE vce3 = this.Cc.get(i8);
                        if (vce3 instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                            break;
                        }
                        c cVarFdM = vce3.lEW.fdM();
                        i2 = cVarFdM != null ? (int) (((double) i2) + cVarFdM.f4688d) : (int) (((long) i2) + 10);
                    }
                    this.kBB.IlO(i2, vce2.lEW);
                    bWL bwl = this.IlO;
                    if (bwl != null && vce == null) {
                        bwl.IlO(i2 * 1000);
                    }
                } else if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                    MY(vce);
                }
                if (z2) {
                    this.es.setText(this.hp.getString(pP.MY(cl.IlO(), "tt_multiple_ad_indicator"), Integer.valueOf(vce2.DmF + 1), Integer.valueOf(this.OOq)));
                } else {
                    this.es.setVisibility(8);
                }
            } else {
                if (this.kBB == null) {
                    if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.tV) {
                        this.kBB = new IlO(this, this.vCE, this.vAh);
                    } else {
                        this.kBB = new tV(this, this.vCE, this.vAh);
                    }
                }
                int iMY = 0;
                for (int i9 = vce2.DmF; i9 < this.Cc.size(); i9++) {
                    vCE vce4 = this.Cc.get(i9);
                    if (vce4.kBB()) {
                        break;
                    }
                    if (vce4 instanceof com.bytedance.sdk.openadsdk.activity.IlO) {
                        c cVarFdM2 = vce4.lEW.fdM();
                        iMY = cVarFdM2 != null ? (int) (((double) iMY) + cVarFdM2.f4688d) : (int) (((long) iMY) + 10);
                    } else if (vce4 instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                        iMY += vce4.lEW.ie().MY();
                    }
                }
                this.kBB.IlO(iMY, vce2.lEW);
                if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.EO) {
                    if (!vce2.kBB()) {
                        this.kBB.IlO(vce2.lEW.ie().MY());
                    } else {
                        MY(vce);
                    }
                }
                bWL bwl2 = this.IlO;
                if (bwl2 != null && vce == null) {
                    bwl2.IlO(iMY * 1000);
                }
                if (vce2 instanceof com.bytedance.sdk.openadsdk.activity.IlO) {
                    this.ea++;
                    IlO(0.0f);
                    this.es.setText(this.hp.getString(pP.MY(cl.IlO(), "tt_multiple_ad_indicator"), Integer.valueOf(vce2.NV + 1), Integer.valueOf(this.OOq)));
                    this.es.setVisibility(0);
                } else {
                    this.es.setVisibility(8);
                }
            }
        }
        for (int i10 = vce != null ? vce.DmF : 0; i10 < this.Cc.size(); i10++) {
            this.Cc.get(i10).IlO(vce, vce2, cc);
        }
        vce2.IlO(this.hp, this.AXM);
        int i11 = this.xF;
        if (i11 == 2) {
            vce2.tV(this.hp);
            return;
        }
        if (i11 == 3) {
            vce2.tV(this.hp);
            vce2.MY(this.hp);
            vce2.MY(true);
        } else if (i11 != 4) {
            if (i11 != 5) {
                return;
            }
            vce2.EO(this.hp);
        } else {
            vce2.MY(false);
            vce2.Cc(this.hp);
        }
    }

    public void IlO(TTAdActivity tTAdActivity) {
        this.xF = 2;
        vCE vce = this.bWL;
        if (vce != null) {
            vce.tV(tTAdActivity);
        }
    }

    public void IlO(boolean z2) {
        vCE vce = this.bWL;
        if (vce != null) {
            vce.MY(z2);
        }
    }

    public void IlO(TTAdActivity tTAdActivity, Bundle bundle) {
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.lEW;
        if (ilO != null) {
            EO = ilO;
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.DmF;
        if (my != null) {
            tV = my;
        }
    }

    public void IlO(vCE vce, Cc cc) {
        vCE vce2 = this.bWL;
        if (vce2 == null || vce2 == vce) {
            EO(null, cc);
        }
    }

    public void IlO(vCE vce) {
        Activity activity = this.hp;
        if (activity != null) {
            activity.finish();
        }
    }

    public void IlO(vCE vce, boolean z2, boolean z7, boolean z8, int i2) {
        com.bytedance.sdk.openadsdk.activity.EO eoBc;
        vCE vce2 = this.bWL;
        if ((vce2 == null || vce2 == vce) && (eoBc = Bc()) != null) {
            Cc cc = new Cc(i2, vce != null ? vce.oeT() : null);
            cc.IlO.putBoolean("isSkip", z2);
            cc.IlO.putBoolean("force", z7);
            cc.IlO.putBoolean("isFromLandingPage", z8);
            EO(eoBc, cc);
        }
    }

    public void IlO(Activity activity) {
        vCE vce = this.bWL;
        if (vce != null) {
            vce.IlO(activity);
        }
    }

    public void IlO(float f4) {
        com.bytedance.sdk.openadsdk.bWL.EV ev = this.oeT;
        if (ev == null) {
            return;
        }
        ev.setProgress(f4);
        if (f4 == 0.0f && this.oeT.getVisibility() == 0) {
            this.oeT.setVisibility(4);
        } else {
            if (f4 <= 0.0f || this.oeT.getVisibility() == 0) {
                return;
            }
            this.oeT.setVisibility(0);
        }
    }

    public void IlO(int i2) {
        AbstractC0072MY abstractC0072MY = this.kBB;
        if (abstractC0072MY == null) {
            return;
        }
        if (i2 == 2) {
            abstractC0072MY.IlO();
            bWL bwl = this.IlO;
            if (bwl != null) {
                bwl.MY();
                return;
            }
            return;
        }
        if (i2 == 1) {
            abstractC0072MY.MY();
            bWL bwl2 = this.IlO;
            if (bwl2 != null) {
                bwl2.IlO();
                return;
            }
            return;
        }
        if (i2 == 3 || i2 == 4) {
            try {
                this.bWL.oeT().vAh.oc();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdSceneManager", th);
            }
        }
    }

    public void IlO(final vCE vce, final boolean z2, final int i2, final String str, final int i8, final String str2) {
        Activity activity;
        if (!this.pP) {
            this.wPn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.MY.4
                @Override // java.lang.Runnable
                public void run() {
                    MY.this.IlO(vce, z2, i2, str, i8, str2);
                }
            };
            return;
        }
        if (ea()) {
            return;
        }
        zPa();
        if (this.lEW == null || (activity = this.hp) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.MY.5
            @Override // java.lang.Runnable
            public void run() {
                MY.this.lEW.IlO(z2, i2, str, i8, str2);
            }
        });
        if (EO()) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), vce.lEW, vce.b_(), z2 ? "reward_success" : "reward_fail");
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.activity.IlO ilO, boolean z2) {
        AbstractC0072MY abstractC0072MY;
        if (ilO == null || ilO != this.bWL || (abstractC0072MY = this.kBB) == null) {
            return;
        }
        abstractC0072MY.IlO(z2);
    }

    public void IlO(View view) {
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.cL.addView(view, 0);
    }

    public void IlO(View view, boolean z2) {
        if (view.getParent() == null && this.cL != null) {
            view.setVisibility(4);
            int childCount = this.cL.getChildCount();
            if (z2) {
                this.cL.addView(view, 0);
            } else {
                this.cL.addView(view, childCount - 1);
            }
        }
    }
}
