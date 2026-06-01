package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class oeT {
    public static final String Cc;
    public static final String EO;
    protected static int rp;
    public static final String tV;
    protected int DmF;
    protected boolean IlO;
    protected long NV;
    private long hp = 0;
    protected boolean MY = false;
    protected boolean vCE = com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO;
    protected int Bc = com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY;
    protected String lEW = com.bytedance.sdk.openadsdk.kBB.IlO.EO.EO;
    protected int EV = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private String Bc;
        private String Cc;
        private String DmF;
        private String EO;
        private String EV;
        private String IlO;
        private String MY;
        private String NV;
        private String bWL;
        private String hp;
        private List<Integer> lEW;
        private String rp;
        private String tV;
        private String vCE;

        @NonNull
        public static com.bytedance.sdk.component.adexpress.IlO.EO.tV IlO(IlO ilO, String str) {
            return com.bytedance.sdk.component.adexpress.IlO.EO.tV.IlO().IlO(ilO.vCE()).MY(ilO.Bc()).EO(ilO.lEW()).tV(ilO.DmF()).Cc(ilO.Cc()).vCE(str);
        }

        @NonNull
        public static com.bytedance.sdk.openadsdk.core.NV.Bc.IlO MY(IlO ilO, String str) {
            return new com.bytedance.sdk.openadsdk.core.NV.Bc.IlO().IlO(ilO.vCE()).MY(ilO.zPa()).EO(ilO.ea()).tV(ilO.cl()).Cc(str);
        }

        public String Bc() {
            return this.MY;
        }

        public String Cc() {
            return this.vCE;
        }

        public String DmF() {
            return this.tV;
        }

        public List<Integer> EO() {
            return this.lEW;
        }

        public String EV() {
            return this.Bc;
        }

        public String NV() {
            return this.Cc;
        }

        public boolean bWL() {
            return !TextUtils.isEmpty(this.NV) && this.NV.equals("v3");
        }

        public String cl() {
            return this.bWL;
        }

        public String ea() {
            return this.rp;
        }

        public String hp() {
            return this.NV;
        }

        public String lEW() {
            return this.EO;
        }

        public String rp() {
            return this.EV;
        }

        public String tV() {
            return this.DmF;
        }

        public String vCE() {
            return this.IlO;
        }

        public String zPa() {
            return this.hp;
        }

        public void Bc(String str) {
            this.Cc = str;
        }

        public void Cc(String str) {
            this.EO = str;
        }

        public void DmF(String str) {
            this.EV = str;
        }

        public void EO(String str) {
            this.IlO = str;
        }

        public void EV(String str) {
            this.rp = str;
        }

        public void NV(String str) {
            this.NV = str;
        }

        public void hp(String str) {
            this.bWL = str;
        }

        public void lEW(String str) {
            this.Bc = str;
        }

        public void rp(String str) {
            this.hp = str;
        }

        public void tV(String str) {
            this.MY = str;
        }

        public void vCE(String str) {
            this.tV = str;
        }

        public void MY(String str) {
            this.vCE = str;
        }

        public void IlO(List<Integer> list) {
            this.lEW = list;
        }

        public void IlO(String str) {
            this.DmF = str;
        }
    }

    static {
        CharSequence[] charSequenceArr = {"is", zLG.kBB()};
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceArr[0]);
        sb.append((CharSequence) "_");
        sb.append(charSequenceArr[1]);
        EO = sb.toString();
        CharSequence[] charSequenceArr2 = {"is", zLG.kBB(), "sample"};
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequenceArr2[0]);
        for (int i2 = 1; i2 < 3; i2++) {
            sb2.append((CharSequence) "_");
            sb2.append(charSequenceArr2[i2]);
        }
        tV = sb2.toString();
        CharSequence[] charSequenceArr3 = {zLG.kBB(), "strategy"};
        StringBuilder sb3 = new StringBuilder();
        sb3.append(charSequenceArr3[0]);
        sb3.append((CharSequence) "_");
        sb3.append(charSequenceArr3[1]);
        Cc = sb3.toString();
        rp = 330;
    }

    public oeT() {
        this.IlO = false;
        this.IlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("is_new_playable", false);
    }

    private static double DmF(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static boolean EO(oeT oet) {
        return (oet == null || oet.fdM() == null || oet.fdM().l != 7 || OOq.Bc(oet)) ? false : true;
    }

    public static String MY(Context context, oeT oet) {
        return null;
    }

    private static long lEW(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public abstract void AK(int i2);

    public abstract boolean AK();

    public abstract boolean AXI();

    public abstract long AXM();

    public abstract void AXM(int i2);

    public abstract void AXM(String str);

    public abstract boolean Aw();

    public abstract int BC();

    public abstract int BES();

    public abstract int BK();

    public abstract List<String> BO();

    public abstract DmF BS();

    public abstract void BS(int i2);

    public long Bc() {
        return this.hp;
    }

    public abstract void Bc(int i2);

    public abstract void Bc(String str);

    public abstract void Bc(JSONObject jSONObject);

    public abstract void Bc(boolean z2);

    public abstract PAGBannerSize Bq();

    public abstract boolean CL();

    public abstract int CQo();

    public String Cc() {
        int iFHv = fHv();
        return iFHv != 1 ? iFHv != 3 ? iFHv != 5 ? iFHv != 7 ? iFHv != 8 ? "unknown" : "fullscreen_interstitial_ad" : "rewarded_video" : "embeded_ad" : "open_ad" : "banner_ad";
    }

    public abstract void Cc(int i2);

    public abstract void Cc(String str);

    public abstract void Cc(JSONObject jSONObject);

    public abstract void Cc(boolean z2);

    public abstract com.bytedance.sdk.component.DmF.MY.IlO Ct();

    public abstract boolean CuC();

    public abstract int DM();

    public abstract void DM(int i2);

    public abstract JSONObject DYs();

    public abstract int DmF();

    public abstract void DmF(int i2);

    public abstract void DmF(String str);

    public abstract void DmF(boolean z2);

    public abstract int Dxv();

    public abstract void Dxv(int i2);

    public abstract String ED();

    public abstract boolean EJ();

    public abstract int EO();

    public abstract void EO(int i2);

    public abstract void EO(long j);

    public abstract void EO(c cVar);

    public abstract void EO(zPa zpa);

    public abstract void EO(JSONObject jSONObject);

    public abstract void EO(boolean z2);

    public abstract void EV(int i2);

    public abstract void EV(String str);

    public abstract void EV(boolean z2);

    public abstract boolean EV();

    public abstract dY Ea();

    public abstract void Ea(int i2);

    public abstract boolean EeJ();

    public abstract void Ei();

    public abstract int Emj();

    public abstract boolean FNH();

    public abstract ea Fv();

    public abstract String HSR();

    public abstract void HSR(int i2);

    public abstract zPa HTA();

    public abstract List<zPa> Hg();

    public abstract int IK();

    public abstract int IRy();

    public abstract tl IWr();

    public abstract int IlO();

    public abstract void IlO(double d8);

    public abstract void IlO(float f4);

    public abstract void IlO(int i2);

    public abstract void IlO(int i2, int i8);

    public void IlO(long j) {
        this.hp = j;
    }

    public abstract void IlO(c cVar);

    public abstract void IlO(AdSlot adSlot);

    public abstract void IlO(FilterWord filterWord);

    public abstract void IlO(PAGBannerSize pAGBannerSize);

    public abstract void IlO(com.bytedance.sdk.openadsdk.core.EV.IlO ilO);

    public abstract void IlO(com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO);

    public abstract void IlO(Cc cc);

    public abstract void IlO(DmF dmF);

    public abstract void IlO(EV ev);

    public abstract void IlO(OOq oOq);

    public abstract void IlO(cl clVar);

    public abstract void IlO(dY dYVar);

    public abstract void IlO(ea eaVar);

    public abstract void IlO(hp hpVar);

    public abstract void IlO(kBB kbb);

    public abstract void IlO(oc ocVar);

    public abstract void IlO(IlO ilO);

    public abstract void IlO(rp rpVar);

    public abstract void IlO(tV tVVar);

    public abstract void IlO(tl tlVar);

    public abstract void IlO(vCE vce);

    public abstract void IlO(xF xFVar);

    public abstract void IlO(zPa zpa);

    public abstract void IlO(com.bytedance.sdk.openadsdk.kBB.IlO.MY my);

    public abstract void IlO(Map<String, Object> map);

    public abstract void IlO(boolean z2);

    public abstract int Ipx();

    public abstract String JAC();

    public abstract String Jm();

    public abstract int Jz();

    public abstract void KC(int i2);

    public abstract boolean KC();

    public abstract String KS();

    public abstract String KT();

    public abstract boolean Kn();

    public abstract int LO();

    public abstract int LT();

    public abstract float La();

    public abstract int MY();

    public abstract void MY(double d8);

    public abstract void MY(int i2);

    public abstract void MY(long j);

    public abstract void MY(c cVar);

    public abstract void MY(com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO);

    public abstract void MY(zPa zpa);

    public abstract void MY(JSONObject jSONObject);

    public abstract void MY(boolean z2);

    public abstract void NI();

    public abstract boolean NLy();

    public abstract JSONObject NST();

    public abstract void NV(int i2);

    public abstract void NV(String str);

    public abstract void NV(boolean z2);

    public abstract boolean NV();

    public abstract String OOq();

    public abstract void OOq(int i2);

    public abstract void OOq(String str);

    public abstract long OW();

    public abstract boolean Os();

    public abstract int OyN();

    public abstract void PR();

    public abstract String PTq();

    public abstract c Pbh();

    public abstract c QLG();

    public abstract boolean QNg();

    public abstract com.bytedance.sdk.openadsdk.core.EV.IlO QfH();

    public abstract com.bytedance.sdk.openadsdk.core.NV.Bc.IlO QtY();

    public abstract boolean SU();

    public abstract void SZ();

    public abstract int TU();

    public abstract boolean Tgn();

    public abstract boolean TkD();

    public abstract zPa Tx();

    public abstract MY Uj();

    public abstract long VC();

    public abstract boolean VFH();

    public abstract tV VH();

    public abstract String VVb();

    public abstract boolean WIv();

    public abstract hp XfO();

    public abstract int XvI();

    public abstract int YA();

    public abstract void YA(int i2);

    public abstract com.bytedance.sdk.openadsdk.kBB.IlO.MY Yq();

    public abstract double ZUt();

    public abstract int aP();

    public abstract int aQ();

    public abstract String aa();

    public abstract boolean ao();

    public abstract void bWL(int i2);

    public abstract void bWL(String str);

    public boolean bWL() {
        return (TextUtils.isEmpty(rp()) || TextUtils.isEmpty(hp())) ? false : true;
    }

    public abstract boolean bYL();

    public abstract List<FilterWord> cJK();

    public abstract Cc cL();

    public abstract void cL(int i2);

    public abstract void cL(String str);

    public abstract vCE cl();

    public abstract void cl(int i2);

    public abstract void cl(String str);

    public abstract boolean ct();

    public abstract boolean dM();

    public abstract void dY(int i2);

    public abstract boolean dY();

    public abstract String dm();

    public abstract int drv();

    public abstract JSONObject eDn();

    public abstract int eVC();

    public abstract xF ea();

    public abstract void ea(int i2);

    public abstract void ea(String str);

    public abstract oc eeU();

    public abstract int es();

    public abstract void es(int i2);

    public abstract void es(String str);

    public abstract boolean ey();

    public abstract int fHv();

    public abstract c fdM();

    public abstract boolean fnd();

    public abstract boolean fo();

    public abstract int gQ();

    public abstract void gQ(int i2);

    public abstract String gYU();

    public abstract String gm();

    public abstract int hFV();

    public abstract int hHv();

    public abstract String hL();

    public abstract boolean hS();

    public abstract DM hjY();

    public abstract String hp();

    public abstract void hp(int i2);

    public abstract void hp(String str);

    public abstract kBB ie();

    public abstract int ii();

    public abstract JSONObject jM();

    public abstract String jS();

    public abstract long jk();

    public abstract boolean jm();

    public abstract int kBB();

    public abstract void kBB(int i2);

    public abstract void kBB(String str);

    public abstract String kw();

    public abstract void lEW(int i2);

    public abstract void lEW(String str);

    public abstract void lEW(boolean z2);

    public abstract int lMM();

    public abstract void lMM(int i2);

    public abstract int lQ();

    public abstract boolean mV();

    public abstract String mmj();

    public abstract void mmj(int i2);

    public abstract boolean nm();

    public abstract boolean nt();

    public abstract int nu();

    public abstract int nvX();

    public abstract void nvX(int i2);

    public abstract int oc();

    public abstract void oc(int i2);

    public abstract void oc(String str);

    public abstract OOq oeT();

    public abstract void oeT(int i2);

    public abstract void oeT(String str);

    public abstract String pFe();

    public abstract int pP();

    public abstract String pP(String str);

    public abstract void pP(int i2);

    public abstract boolean pS();

    public abstract boolean pbX();

    public abstract int ps();

    public abstract String qIK();

    public abstract void qX();

    public abstract int quf();

    public abstract void quf(int i2);

    public abstract List<String> qvT();

    public abstract JSONObject qyG();

    public abstract String qz();

    public abstract String rHm();

    public abstract String rp();

    public abstract void rp(int i2);

    public abstract void rp(String str);

    public abstract void rp(boolean z2);

    public abstract String rv();

    public abstract long sr();

    public abstract AdSlot ssS();

    public abstract void ssS(int i2);

    public abstract int su();

    public abstract Map<String, Object> tN();

    public abstract String tU();

    public int tV() {
        Cc ccCL = cL();
        if (ccCL != null) {
            return ccCL.IlO();
        }
        return -1;
    }

    public abstract void tV(int i2);

    public abstract void tV(long j);

    public abstract void tV(JSONObject jSONObject);

    public abstract void tV(boolean z2);

    @Nullable
    public abstract String tcT();

    public abstract boolean tf();

    public abstract int tl();

    public abstract void tl(int i2);

    public abstract void tl(String str);

    public abstract List<String> ts();

    public abstract boolean uAj();

    public abstract boolean uF();

    public abstract int uI();

    public abstract IlO uvo();

    public abstract void uvo(int i2);

    public abstract int vAh();

    public abstract void vAh(int i2);

    public abstract void vAh(String str);

    public abstract void vCE(int i2);

    public abstract void vCE(String str);

    public abstract void vCE(JSONObject jSONObject);

    public abstract void vCE(boolean z2);

    public boolean vCE() {
        int iVAh = vAh();
        return (oc() != 2 || iVAh == 5 || iVAh == 6 || iVAh == 19 || iVAh == 12) ? false : true;
    }

    public abstract int vSq();

    public abstract void vSq(int i2);

    public abstract void vSq(String str);

    public abstract JSONObject vZk();

    public abstract boolean vh();

    public abstract boolean wD();

    public abstract int wPn();

    public abstract void wPn(int i2);

    public abstract void wPn(String str);

    public abstract int xF();

    public abstract void xF(int i2);

    public abstract void xF(String str);

    public abstract boolean xJ();

    public abstract com.bytedance.sdk.openadsdk.core.NV.Bc.IlO xqE();

    public abstract int zLG();

    public abstract void zLG(int i2);

    public abstract cl zPa();

    public abstract void zPa(int i2);

    public abstract void zPa(String str);

    public abstract EV zTS();

    public static boolean Bc(oeT oet) {
        Object obj;
        if (oet == null) {
            return false;
        }
        try {
            Map<String, Object> mapTN = oet.tN();
            if (mapTN == null || (obj = mapTN.get(TTAdConstant.SDK_BIDDING_TYPE)) == null) {
                return false;
            }
            return 2 == Integer.parseInt(obj.toString());
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public static boolean IlO(oeT oet, boolean z2, boolean z7, boolean z8, boolean z9) {
        if (IlO(oet) || z9 || oet == null || oet.fdM() == null || TextUtils.isEmpty(oet.fdM().h)) {
            return false;
        }
        return EO(oet) ? z8 : (oet.fdM() == null || oet.fdM().k != 1) ? z2 : z7;
    }

    public static boolean MY(oeT oet) {
        return (IlO(oet) || EO(oet)) ? false : true;
    }

    public static oeT lEW() {
        return new wPn();
    }

    public static double MY(String str) {
        return DmF(EO(str));
    }

    public static boolean tV(oeT oet) {
        return (oet == null || oet.fdM() == null || oet.fdM().k != 1) ? false : true;
    }

    public static boolean vCE(oeT oet) {
        if (oet == null) {
            return false;
        }
        int iUI = oet.uI();
        return iUI == 5 || iUI == 15 || iUI == 50;
    }

    public static JSONObject EO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("MaterialMeta", e.getMessage());
            return null;
        }
    }

    public static int tV(String str) {
        return IlO(EO(str));
    }

    public static boolean Cc(oeT oet) {
        if (oet == null) {
            return false;
        }
        int iUI = oet.uI();
        return oet.xJ() || iUI == 5 || iUI == 15 || iUI == 50;
    }

    public static boolean IlO(oeT oet) {
        return (oet == null || oet.fdM() == null || oet.fdM().l != 1) ? false : true;
    }

    public static com.bytedance.sdk.openadsdk.core.rp.IlO.MY IlO(String str, oeT oet) {
        oet.BS(0);
        int iOyN = oet.OyN();
        int i2 = 3;
        if (iOyN == 3) {
            i2 = 4;
        } else if (iOyN == 7) {
            i2 = 1;
        } else if (iOyN == 8) {
            i2 = 2;
        }
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY my = new com.bytedance.sdk.openadsdk.core.rp.IlO.MY(str, oet.QLG(), oet.Pbh(), oet.hHv(), oet.LT(), i2);
        my.IlO(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("video_error_conf", 0));
        return my;
    }

    public static long IlO(String str) {
        return lEW(EO(str));
    }

    public static int IlO(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static String IlO(Context context, oeT oet) {
        if (context == null || oet == null || !((oet.OyN() == 8 || oet.OyN() == 7) && oet.AK())) {
            return null;
        }
        String strMY = MY(context, oet);
        if (TextUtils.isEmpty(strMY) || com.bytedance.sdk.openadsdk.core.act.IlO.IlO() != 1) {
            return null;
        }
        return strMY;
    }
}
