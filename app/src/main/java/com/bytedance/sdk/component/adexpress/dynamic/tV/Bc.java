package com.bytedance.sdk.component.adexpress.dynamic.tV;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.adexpress.dynamic.Cc.EV;
import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.unity3d.services.core.device.MimeTypes;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private Cc Cc;
    public JSONObject EO;
    public int IlO;
    public String MY;
    private vCE tV;
    private String vCE;

    public Bc(Cc cc) {
        this.Cc = cc;
        this.IlO = cc.IlO();
        this.MY = cc.EO();
        this.EO = cc.Cc().qvT();
        this.vCE = cc.tV();
        if (com.bytedance.sdk.component.adexpress.tV.EO() == 1) {
            this.tV = cc.Bc();
        } else {
            this.tV = cc.Cc();
        }
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            this.tV = cc.Cc();
        }
    }

    private boolean VH() {
        return (com.bytedance.sdk.component.adexpress.tV.MY() && (this.Cc.MY().contains("logo-union") || this.Cc.MY().contains("logounion") || this.Cc.MY().contains("logoad"))) || "logo-union".equals(this.Cc.MY()) || "logounion".equals(this.Cc.MY()) || "logoad".equals(this.Cc.MY());
    }

    private boolean zTS() {
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.MY) && this.MY.contains("adx:")) || EV.MY();
    }

    public int AK() {
        return this.tV.Bc();
    }

    public String AXM() {
        return this.tV.kBB();
    }

    public boolean BO() {
        return this.tV.OW();
    }

    public int BS() {
        return this.tV.gm();
    }

    public int Bc() {
        return IlO(this.tV.oeT());
    }

    public float Cc() {
        return this.tV.cL();
    }

    public String DM() {
        return this.tV.BS();
    }

    public int DmF() {
        int iLEW = lEW();
        if (iLEW == 4) {
            return 17;
        }
        return iLEW == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public boolean Dxv() {
        return this.tV.BES();
    }

    public boolean ED() {
        return this.tV.BES();
    }

    public int EO() {
        return (int) this.tV.ea();
    }

    public String EV() {
        return this.IlO == 1 ? this.MY : "";
    }

    public int Ea() {
        return this.tV.cJK();
    }

    public boolean HSR() {
        return this.tV.jM();
    }

    public int HTA() {
        return this.tV.lMM();
    }

    public double Hg() {
        return this.tV.mmj();
    }

    public int IlO() {
        return (int) this.tV.bWL();
    }

    public String Jz() {
        return this.tV.Os();
    }

    public int KC() {
        return this.tV.eeU();
    }

    public int MY() {
        return (int) this.tV.cl();
    }

    public String NV() {
        int i2 = this.IlO;
        return (i2 == 2 || i2 == 13) ? this.MY : "";
    }

    public int OOq() {
        String strZLG = this.tV.zLG();
        if ("skip-with-time-skip-btn".equals(this.Cc.MY()) || "skip".equals(this.Cc.MY()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.Cc.MY())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.Cc.MY()) && !"skip-with-time".equals(this.Cc.MY())) {
            if (this.IlO == 10 && TextUtils.equals(this.tV.BS(), C2318f4.f8523d)) {
                return 5;
            }
            if (VH() && zTS()) {
                return 0;
            }
            if (VH()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.Cc.MY())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strZLG) && !strZLG.equals("none")) {
                if (strZLG.equals(MimeTypes.BASE_TYPE_VIDEO) || (this.Cc.IlO() == 7 && TextUtils.equals(strZLG, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.tV.MY() && this.Cc.Cc() != null && this.Cc.Cc().xJ()) ? 11 : 4;
                }
                if (strZLG.equals("normal")) {
                    return 1;
                }
                return (strZLG.equals("creative") || "slide".equals(this.tV.BS())) ? 2 : 0;
            }
        }
        return 0;
    }

    public String PTq() {
        return this.tV.pP();
    }

    public int Tx() {
        return this.tV.nvX();
    }

    public int YA() {
        return this.tV.DmF();
    }

    public int aa() {
        return this.tV.tf();
    }

    public double bWL() {
        return this.tV.es();
    }

    public int cL() {
        return this.tV.ao();
    }

    public float cl() {
        return this.tV.rp();
    }

    public int dY() {
        return this.tV.MY();
    }

    public int dm() {
        return this.tV.vZk();
    }

    public float ea() {
        return this.tV.EV();
    }

    public int es() {
        return this.tV.IRy();
    }

    public String fdM() {
        return this.tV.oc();
    }

    public String gQ() {
        return this.tV.DM();
    }

    public int gm() {
        return this.tV.tN();
    }

    public String hL() {
        return this.tV.La();
    }

    public double hp() {
        if (this.IlO == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.tV.MY() ? (int) r0 : Double.parseDouble(this.MY);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public String ii() {
        return this.tV.vSq();
    }

    public String kBB() {
        return this.tV.zLG();
    }

    public int lEW() {
        String strAXM = this.tV.AXM();
        if ("left".equals(strAXM)) {
            return 17;
        }
        if ("center".equals(strAXM)) {
            return 4;
        }
        return "right".equals(strAXM) ? 3 : 2;
    }

    public int lMM() {
        return this.tV.Cc();
    }

    public String mmj() {
        return this.tV.NV();
    }

    public boolean nm() {
        return this.tV.dY();
    }

    public int nvX() {
        return this.tV.tV();
    }

    public double oc() {
        return this.tV.lEW();
    }

    public boolean oeT() {
        return this.tV.HSR();
    }

    public double pFe() {
        return this.tV.YA();
    }

    public String pP() {
        return this.tV.NI();
    }

    public int quf() {
        return this.tV.aP();
    }

    public String qvT() {
        return this.tV.qyG();
    }

    public int qz() {
        return this.tV.Aw();
    }

    public String rp() {
        return this.vCE;
    }

    public int ssS() {
        return this.tV.dm();
    }

    public int tV() {
        return (int) this.tV.zPa();
    }

    public long tl() {
        return this.tV.dM();
    }

    public String ts() {
        return this.tV.tU();
    }

    public int uvo() {
        return this.tV.QfH();
    }

    public int vAh() {
        return this.tV.AK();
    }

    public String vCE() {
        return this.IlO == 0 ? !TextUtils.isEmpty(this.MY) ? this.MY : this.EO.optString(com.bytedance.sdk.component.adexpress.tV.Bc.EO(com.bytedance.sdk.component.adexpress.tV.IlO())) : "";
    }

    public int vSq() {
        return this.tV.EO();
    }

    public boolean wD() {
        return this.tV.hp();
    }

    public int wPn() {
        return IlO(this.tV.vAh());
    }

    public boolean xF() {
        return this.tV.XvI();
    }

    public boolean zLG() {
        return this.tV.BO();
    }

    public int zPa() {
        return IlO(this.tV.tl());
    }

    public static float[] MY(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public void IlO(float f4) {
        this.tV.IlO(f4);
    }

    public static int IlO(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals(C2300e4.h.T)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean IlO(int i2) {
        Cc cc = this.Cc;
        if (cc == null) {
            return false;
        }
        if (i2 == 1) {
            this.tV = cc.Bc();
        } else {
            this.tV = cc.Cc();
        }
        return this.tV != null;
    }
}
