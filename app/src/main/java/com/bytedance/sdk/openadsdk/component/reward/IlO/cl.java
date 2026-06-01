package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.tV.IlO;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.mlkit.common.MlKitException;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;
import r.c;
import v.a;
import w.b;
import w.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {
    private boolean AXM;
    private final Activity Bc;
    private FrameLayout DmF;
    boolean EO;
    private long EV;
    private final String NV;
    private com.bytedance.sdk.openadsdk.tV.Bc OOq;
    private String cl;
    private long ea;
    private boolean es;
    private final oeT lEW;
    private long rp;
    final boolean tV;
    private IlO.InterfaceC0108IlO tl;
    e vCE;
    private final IlO xF;
    private long zPa;
    protected boolean IlO = false;
    boolean MY = false;
    protected boolean Cc = false;
    private long hp = -1;
    private int bWL = -1;
    private boolean oeT = false;
    private int vAh = 0;
    private float kBB = 1.0f;
    private boolean pP = false;
    private HashSet<String> cL = new HashSet<>();

    public cl(IlO ilO) {
        this.xF = ilO;
        this.Bc = ilO.BS;
        this.lEW = ilO.MY;
        this.tV = ilO.tV;
        this.NV = ilO.Cc;
    }

    private void ssS() {
        e eVar = this.vCE;
        if (eVar == null || eVar.NV() == null) {
            return;
        }
        this.EV = this.vCE.Cc();
        if (this.vCE.NV().EO() || !this.vCE.NV().MY()) {
            this.vCE.IlO();
            this.vCE.EO();
            this.IlO = true;
        }
    }

    public long AXM() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.lEW();
        }
        return 0L;
    }

    public void BS() {
        e eVar = this.vCE;
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
            ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar).BS();
        }
    }

    public a Bc() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar instanceof com.bytedance.sdk.openadsdk.component.reward.EO ? ((com.bytedance.sdk.openadsdk.component.reward.EO) eVar).zPa() : eVar.EV();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.tV.Bc Cc() {
        return this.OOq;
    }

    public View DM() {
        e eVar = this.vCE;
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
            return (View) ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar).DM();
        }
        return null;
    }

    public boolean DmF() {
        e eVar = this.vCE;
        return eVar != null && eVar.hp();
    }

    public long EV() {
        e eVar = this.vCE;
        return eVar != null ? eVar.Cc() : this.EV;
    }

    public boolean NV() {
        return this.IlO;
    }

    public boolean OOq() {
        return this.vCE != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double YA() {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r5.lEW
            com.bytedance.sdk.openadsdk.core.model.xF r0 = r0.ea()
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r5.lEW
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.es.tV(r1)
            if (r1 == 0) goto L16
            if (r0 == 0) goto L16
            long r0 = r0.MY()
        L14:
            double r0 = (double) r0
            goto L37
        L16:
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r5.lEW
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.es.Cc(r1)
            if (r1 == 0) goto L25
            if (r0 == 0) goto L25
            long r0 = r0.tV()
            goto L14
        L25:
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r5.lEW
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.c r0 = r0.fdM()
            if (r0 == 0) goto L35
            double r1 = r0.f4688d
            int r0 = r0.f4694r
            double r3 = (double) r0
            double r0 = r1 * r3
            goto L37
        L35:
            r0 = 0
        L37:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r2 = r5.xF
            com.bytedance.sdk.openadsdk.component.reward.EV r2 = r2.PTq
            if (r2 == 0) goto L41
            long r3 = (long) r0
            r2.IlO(r3)
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.IlO.cl.YA():double");
    }

    public void bWL() {
        try {
            if (vCE()) {
                this.vCE.IlO();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage(), new Object[0]);
        }
    }

    public void cL() {
        e eVar = this.vCE;
        if (eVar != null) {
            eVar.tV();
        }
    }

    public void cl() {
        e eVar = this.vCE;
        if (eVar == null) {
            return;
        }
        eVar.EO();
        this.vCE = null;
    }

    public void dY() {
        this.oeT = false;
        cl();
    }

    public long ea() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.vCE();
        }
        return 0L;
    }

    public void es() {
        e eVar = this.vCE;
        if (eVar != null) {
            eVar.MY();
        }
    }

    public long hp() {
        return this.EV;
    }

    public long kBB() {
        e eVar = this.vCE;
        if (eVar == null) {
            return 0L;
        }
        return this.vCE.vCE() + eVar.lEW();
    }

    public boolean lEW() {
        e eVar = this.vCE;
        return (eVar == null || eVar.NV() == null || !this.vCE.NV().Bc()) ? false : true;
    }

    public void lMM() {
        try {
            if (vCE()) {
                this.Cc = true;
                xF();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e.getMessage());
        }
    }

    public void mmj() {
        e eVar = this.vCE;
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
            ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar).YA();
        }
    }

    public boolean nvX() {
        e eVar = this.vCE;
        if (eVar == null || eVar.NV() == null) {
            return false;
        }
        return this.vCE.NV().IlO();
    }

    public void oc() {
        int i2 = this.vAh;
        if (i2 == 1 || i2 == 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("switch", 0);
                IlO(jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFVideoPlayerMag", "onStopPlaySpeed: ", th);
            }
        }
    }

    public int oeT() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.DmF();
        }
        return 0;
    }

    public long pP() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.lEW();
        }
        return 0L;
    }

    public long rp() {
        return this.rp;
    }

    public boolean tV() {
        int i2;
        return this.pP ? this.oeT && this.vAh == 1 : this.oeT && ((i2 = this.vAh) == 2 || i2 == 1);
    }

    public boolean tl() {
        e eVar = this.vCE;
        if (eVar != null) {
            if (eVar.NV() != null) {
                c cVarNV = this.vCE.NV();
                if (cVarNV.Bc() || cVarNV.lEW()) {
                    e eVar2 = this.vCE;
                    if (eVar2 instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
                        ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar2).mmj();
                    }
                    return true;
                }
            } else if (NV()) {
                IlO(false);
                e eVar3 = this.vCE;
                if (eVar3 instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
                    ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar3).mmj();
                }
                return true;
            }
        }
        return false;
    }

    public int vAh() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.Bc();
        }
        return 0;
    }

    public boolean vCE() {
        e eVar = this.vCE;
        return (eVar == null || eVar.NV() == null || !this.vCE.NV().vCE()) ? false : true;
    }

    public boolean vSq() {
        return this.EO;
    }

    public boolean wPn() {
        e eVar = this.vCE;
        return eVar != null && eVar.NV() == null;
    }

    public void xF() {
        e eVar = this.vCE;
        if (eVar != null) {
            eVar.IlO();
        }
    }

    public void zLG() {
        e eVar = this.vCE;
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
            ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) eVar).zLG();
        }
    }

    public c zPa() {
        e eVar = this.vCE;
        if (eVar != null) {
            return eVar.NV();
        }
        return null;
    }

    public boolean EO() {
        return this.oeT;
    }

    public long IlO() {
        return this.hp;
    }

    public long MY() {
        return this.ea;
    }

    private void MY(long j, long j3) {
        int iAbs = (int) Math.abs(((long) this.bWL) - j);
        int i2 = this.bWL;
        if (i2 < 0 || iAbs > 500 || i2 > j3 || iAbs >= 500 || this.cL.contains(this.cl)) {
            return;
        }
        if (this.bWL > j) {
            com.bytedance.sdk.openadsdk.core.bWL.EO().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.cl.1
                @Override // java.lang.Runnable
                public void run() {
                    cl.this.lMM();
                    cl.this.xF.tl.IlO(cl.this.bWL, cl.this.cl);
                }
            }, iAbs);
        } else {
            lMM();
            this.xF.tl.IlO(this.bWL, this.cl);
        }
        this.cL.add(this.cl);
    }

    public void EO(boolean z2) {
        this.AXM = z2;
        if (this.vCE instanceof com.bytedance.sdk.openadsdk.core.rp.tV.IlO) {
            if (z2) {
                ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) this.vCE).MY(this.lEW.fdM().f4694r);
            } else {
                com.bykv.vk.openvk.IlO.IlO.IlO.EO.c cVarFdM = this.lEW.fdM();
                cVarFdM.getClass();
                cVarFdM.f4694r = Math.min(4, Math.max(1, 1));
                ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) this.vCE).MY(1);
            }
        }
    }

    public void IlO(long j) {
        this.hp = j;
    }

    public void IlO(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.tV.Bc bc) {
        if (this.es) {
            return;
        }
        this.es = true;
        this.DmF = frameLayout;
        if (this.lEW.eeU() != null) {
            this.vAh = this.lEW.eeU().MY();
            this.kBB = this.lEW.eeU().IlO();
        }
        this.OOq = bc;
        if (oeT.Cc(this.lEW)) {
            this.pP = true;
            this.vCE = new com.bytedance.sdk.openadsdk.core.rp.tV.IlO(this.Bc, this.DmF, this.lEW, bc);
            EO(this.AXM);
            IlO.InterfaceC0108IlO interfaceC0108IlO = this.tl;
            if (interfaceC0108IlO != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.tV.IlO) this.vCE).IlO(interfaceC0108IlO);
                return;
            }
            return;
        }
        this.pP = false;
        com.bytedance.sdk.openadsdk.component.reward.EO eo = new com.bytedance.sdk.openadsdk.component.reward.EO(this.lEW, bc);
        this.vCE = eo;
        IlO.InterfaceC0108IlO interfaceC0108IlO2 = this.tl;
        if (interfaceC0108IlO2 != null) {
            eo.IlO(interfaceC0108IlO2);
        }
    }

    public void MY(long j) {
        this.EV = j;
    }

    public void MY(boolean z2) {
        this.EO = z2;
    }

    public void MY(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        if (!tl() || my == null) {
            return;
        }
        my.IlO(hp(), true);
    }

    public void IlO(com.bytedance.sdk.openadsdk.tV.Bc bc) {
        this.OOq = bc;
    }

    public void IlO(long j, long j3) {
        this.rp = j;
        MY(j, j3);
    }

    public void IlO(int i2, String str) {
        this.bWL = i2;
        this.cl = str;
    }

    public void IlO(boolean z2) {
        this.IlO = z2;
    }

    public void IlO(int i2, int i8) {
        if (this.vCE != null) {
            ea.IlO ilO = new ea.IlO();
            ilO.EO(ea());
            ilO.tV(kBB());
            ilO.MY(EV());
            ilO.IlO(i2);
            ilO.MY(i8);
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.tV(this.vCE.EV(), ilO);
        }
    }

    public void IlO(b bVar) {
        e eVar = this.vCE;
        if (eVar != null) {
            eVar.IlO(bVar);
        }
    }

    public void IlO(boolean z2, String str) {
        e eVar = this.vCE;
        if (eVar != null) {
            eVar.IlO(z2, str);
        }
    }

    public void IlO(String str, boolean z2) {
        if (this.vCE != null) {
            long jEV = EV();
            if (this.lEW.FNH()) {
                jEV = this.xF.EO();
            }
            long j = jEV;
            JSONObject jSONObjectIlO = zLG.IlO(this.lEW, this.vCE.vCE(), this.vCE.NV());
            try {
                jSONObjectIlO.put("auto_click", z2);
                if (!z2) {
                    IlO ilO = this.xF;
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(jSONObjectIlO, ilO.tV ? ilO.MY.MY() : ilO.MY.IlO(), (int) j);
                }
            } catch (Exception unused) {
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.lEW, this.NV, str, j, oeT(), jSONObjectIlO, this.OOq);
            kBB();
            oeT();
        }
        zLG();
    }

    public boolean IlO(long j, boolean z2, Map<String, Object> map, com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        boolean zIlO = false;
        if (!OOq()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.es.tV(this.xF.MY) || com.bytedance.sdk.openadsdk.core.model.es.Cc(this.xF.MY)) {
            return true;
        }
        if (!z2 || !wPn()) {
            IlO(my);
        }
        try {
            zIlO = IlO(j, this.xF.uvo);
        } catch (Exception e) {
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e);
        }
        if (zIlO && !z2) {
            this.xF.wPn.IlO(map);
        }
        return zIlO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        if (this.xF.NV.get()) {
            return;
        }
        IlO ilO = this.xF;
        if (!ilO.KC || OOq.EO(ilO.MY)) {
            return;
        }
        if ((!oeT.Cc(this.xF.MY) && com.bytedance.sdk.openadsdk.core.cl.tV().rp(String.valueOf(this.xF.vCE)) == 1 && this.xF.tl.tV()) || com.bytedance.sdk.openadsdk.core.model.es.tV(this.xF.MY) || com.bytedance.sdk.openadsdk.core.model.es.Cc(this.xF.MY) || this.Cc || !my.vCE()) {
            return;
        }
        this.xF.HSR.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
        Message messageObtain = Message.obtain();
        messageObtain.what = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
        this.xF.HSR.sendMessageDelayed(messageObtain, 5000L);
    }

    public boolean IlO(JSONObject jSONObject) {
        int i2;
        if (this.vCE != null && jSONObject != null && ((i2 = this.vAh) == 1 || i2 == 2)) {
            int iOptInt = jSONObject.optInt("switch", 0);
            float fOptDouble = (float) jSONObject.optDouble("speed", 0.0d);
            this.kBB = fOptDouble;
            if (fOptDouble <= 0.0f && this.xF.MY.eeU() != null) {
                this.kBB = this.xF.MY.eeU().IlO();
            }
            if (iOptInt == 0) {
                this.kBB = 1.0f;
                if (this.oeT) {
                    long jCurrentTimeMillis = (System.currentTimeMillis() - this.zPa) + this.ea;
                    this.ea = jCurrentTimeMillis;
                    e eVar = this.vCE;
                    if (eVar != null) {
                        eVar.IlO(jCurrentTimeMillis);
                    }
                    com.bytedance.sdk.openadsdk.core.rp.tV.MY my = this.xF.ssS;
                    if (my != null) {
                        my.EO(false);
                    }
                }
            } else if (iOptInt == 1 && !this.oeT) {
                this.zPa = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.rp.tV.MY my2 = this.xF.ssS;
                if (my2 != null) {
                    my2.EO(true);
                }
            }
            this.oeT = iOptInt == 1;
            if (this.vAh == 1) {
                return true;
            }
            e eVar2 = this.vCE;
            if (eVar2 == null) {
                return false;
            }
            return eVar2.IlO(this.kBB);
        }
        this.oeT = false;
        return false;
    }

    private boolean IlO(long j, boolean z2) {
        if (this.vCE == null || this.lEW.fdM() == null) {
            return false;
        }
        String strC = ((b0.b) CacheDirFactory.getICacheDir(this.lEW.hHv())).c();
        File file = new File(strC, this.lEW.fdM().a());
        if (file.exists() && file.length() > 0) {
            this.MY = true;
        }
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(strC, this.lEW);
        myIlO.MY(this.lEW.ED());
        myIlO.MY(this.DmF.getWidth());
        myIlO.EO(this.DmF.getHeight());
        myIlO.EO(this.lEW.KT());
        myIlO.IlO(j);
        myIlO.IlO(z2);
        return this.vCE.IlO(myIlO);
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        try {
            this.Cc = false;
            if (NV()) {
                ssS();
                MY(my);
            } else if (lEW()) {
                es();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void IlO(boolean z2, com.bytedance.sdk.openadsdk.core.rp.tV.MY my, boolean z7) {
        if (!z7 || z2 || this.Cc) {
            return;
        }
        if (lEW()) {
            es();
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
        } else {
            ssS();
            MY(my);
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
        }
    }

    public void IlO(IlO.InterfaceC0108IlO interfaceC0108IlO) {
        this.tl = interfaceC0108IlO;
    }
}
