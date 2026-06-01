package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.Y1;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class wPn extends oeT {
    private String AK;
    private int AXM;
    private String Aw;
    private int BC;
    private int BES;
    private volatile boolean BK;
    private oeT.IlO BO;
    private EV BS;
    private xF CQo;
    private String Ct;
    private String DYs;
    private boolean EJ;
    private boolean EeJ;
    private int Ei;
    private com.bytedance.sdk.openadsdk.core.EV.IlO Fv;
    private String HSR;
    private boolean HTA;
    private int Hg;
    private int IRy;
    private boolean JAC;
    private int Jz;
    private int KS;
    private AdSlot KT;
    private String Kn;
    private Cc LO;
    private int LT;
    private String La;
    private JSONObject NI;
    private String OOq;
    private String Pbh;
    private hp QLG;
    private cl QtY;
    private int TU;
    private com.bytedance.sdk.openadsdk.core.NV.Bc.IlO Tgn;
    private vCE TkD;
    private boolean Tx;
    private int VC;
    private boolean VFH;
    private int XvI;
    private String YA;
    private String aP;
    private int ao;
    public long bWL;
    private int bYL;
    private String ct;
    private ea dM;
    private String dY;
    private String dm;
    private String ey;
    private int fHv;
    private long fdM;
    private dY fo;
    private String gQ;
    private PAGBannerSize gYU;
    private JSONObject gm;
    private JSONObject hFV;
    private int hHv;
    private int hL;
    private com.bytedance.sdk.openadsdk.core.NV.Bc.IlO hS;
    private int hjY;
    private c ii;
    private JSONObject jM;
    private oc jS;
    private String jk;
    private zPa kBB;
    private tl kw;
    private String lMM;
    private boolean lQ;
    private kBB mV;
    private int mmj;
    private c nm;
    private String nvX;
    private int oeT;
    private boolean pFe;
    private zPa pP;
    private boolean pS;
    private String pbX;
    private String qIK;
    private int qvT;
    private OOq qyG;
    private boolean qz;
    private int ssS;
    private String tU;
    private String tl;
    private Map<String, Object> ts;
    private rp uF;
    private int uI;
    private int vAh;
    private String vSq;
    private JSONObject vZk;
    private c wD;
    private String xqE;
    private tV zLG;
    private final List<zPa> cl = new ArrayList();
    private final List<String> cL = new ArrayList();
    private final List<FilterWord> es = new ArrayList();
    private final DM xF = DM.EO();
    public boolean hp = false;
    private List<String> wPn = new ArrayList();
    private List<String> oc = new ArrayList();
    private String DM = "0";
    private String quf = "";
    private int uvo = 0;
    private int KC = 2;
    private int Ea = -1;
    private int Dxv = 0;
    private int aa = 0;
    private int ED = 1;
    private DmF PTq = new DmF();
    private int VH = -200;
    private int zTS = 0;
    private int cJK = 1;
    private int OW = 0;
    private int tf = 0;
    private int tN = 0;
    private int eeU = 1;
    private int eDn = 1;
    private float NST = 100.0f;
    private int xJ = 2;
    private int QfH = 1;
    private int Os = 0;
    private int XfO = -1;
    private long IK = -1;
    private int OyN = 0;
    private boolean ZUt = false;
    private int tcT = 0;
    private int SU = 50;
    private int NLy = -1;
    private final MY PR = new MY();
    private boolean QNg = false;
    private com.bytedance.sdk.openadsdk.kBB.IlO.MY eVC = null;
    protected int ea = -1;
    protected int zPa = -1;

    private com.bytedance.sdk.openadsdk.core.NV.Bc.IlO Hlg() {
        dY dYVarEa = Ea();
        if (dYVarEa == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.NV.Bc.IlO().IlO(dYVarEa.IlO()).MY(dYVarEa.MY()).EO(dYVarEa.EO()).tV(dYVarEa.tV()).Cc(hFV() + "_v3");
    }

    private com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ZAb() {
        oeT.IlO ilOUvo = uvo();
        if (ilOUvo == null) {
            return null;
        }
        return oeT.IlO.MY(ilOUvo, String.valueOf(hFV()));
    }

    public static boolean lEW(oeT oet) {
        if (oet == null) {
            return false;
        }
        int iUI = oet.uI();
        return oet.xJ() || iUI == 5 || iUI == 15 || iUI == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void AK(int i2) {
        this.fHv = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean AXI() {
        return this.pS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public long AXM() {
        Cc cc = this.LO;
        if (cc == null) {
            return 0L;
        }
        return cc.tV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean Aw() {
        if (this.cl.isEmpty()) {
            return false;
        }
        if (this.ssS == 4 && this.cl.size() < 3) {
            return false;
        }
        Iterator<zPa> it = this.cl.iterator();
        while (it.hasNext()) {
            if (!it.next().Cc()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int BC() {
        return this.BC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int BES() {
        if (this.eDn != 2) {
            this.eDn = 1;
        }
        return this.eDn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int BK() {
        return this.LT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public List<String> BO() {
        return this.cL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public DmF BS() {
        return this.PTq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Bc(boolean z2) {
        this.VFH = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public PAGBannerSize Bq() {
        return this.gYU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean CL() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int CQo() {
        JSONObject jSONObject = this.NI;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Cc(String str) {
        this.Pbh = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public com.bytedance.sdk.component.DmF.MY.IlO Ct() {
        com.bytedance.sdk.component.DmF.MY.IlO ilO = new com.bytedance.sdk.component.DmF.MY.IlO();
        ilO.IlO(this.qvT);
        ilO.MY(this.DM);
        ilO.IlO(KT());
        return ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean CuC() {
        cl clVar;
        if (this.KT == null || (clVar = this.QtY) == null) {
            return false;
        }
        return clVar.IlO(!TextUtils.isEmpty(r0.getBidAdm()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int DM() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject DYs() {
        if (this.gm == null) {
            try {
                if (!TextUtils.isEmpty(this.AK)) {
                    this.gm = new JSONObject(this.AK);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO("MaterialMeta", e.getMessage());
            }
        }
        return this.gm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int DmF() {
        return this.EV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int Dxv() {
        rp rpVar = this.uF;
        if (rpVar == null) {
            return 0;
        }
        return rpVar.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String ED() {
        return this.DM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean EJ() {
        return OyN() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(int i2) {
        this.EV = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean EV() {
        return this.Tx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public dY Ea() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean EeJ() {
        int i2 = this.oeT;
        return (i2 == 2 || i2 == 1) && 3 == this.AXM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Ei() {
        this.xF.Cc();
        Bc(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int Emj() {
        try {
            JSONObject jSONObjectDYs = DYs();
            if (jSONObjectDYs != null) {
                return jSONObjectDYs.optInt("rec_clk", 0);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean FNH() {
        if (this.XfO <= 0) {
            this.XfO = OyN();
        }
        int i2 = this.XfO;
        return (i2 == 7 || i2 == 8) && !lEW(this) && kBB() != 21 && this.hjY == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public ea Fv() {
        return this.dM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String HSR() {
        return this.dm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public zPa HTA() {
        return this.kBB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public List<zPa> Hg() {
        return this.cl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int IK() {
        return this.Hg;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int IRy() {
        return this.IRy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public tl IWr() {
        return this.kw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(boolean z2) {
        this.HTA = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int Ipx() {
        return this.SU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String JAC() {
        JSONObject jSONObjectDYs;
        String strOptString = this.Ct;
        if (TextUtils.isEmpty(strOptString) && (jSONObjectDYs = DYs()) != null) {
            strOptString = jSONObjectDYs.optString("req_id", "");
            dY(strOptString);
        }
        return strOptString == null ? "" : strOptString;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String Jm() {
        JSONObject jSONObjectDYs;
        if (this.pbX == null && (jSONObjectDYs = DYs()) != null) {
            this.pbX = jSONObjectDYs.optString("cid", "");
        }
        return this.pbX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int Jz() {
        return this.AXM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void KC(int i2) {
        this.hjY = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String KS() {
        return this.ct;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String KT() {
        return this.AK;
    }

    public int Klw() {
        return this.uI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean Kn() {
        return OyN() == 3 || OyN() == 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int LO() {
        return this.mmj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int LT() {
        return this.KS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public float La() {
        if (this.NST <= 0.0f) {
            this.NST = 100.0f;
        }
        return (this.NST * 1000.0f) / 1000.0f;
    }

    public int LqZ() {
        return this.cJK;
    }

    public int ML() {
        return this.Dxv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(boolean z2) {
        this.Tx = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void NI() {
        this.BK = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean NLy() {
        return this.xF.IlO > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject NST() {
        JSONObject jSONObjectEDn = eDn();
        JSONObject jSONObjectCl = com.bytedance.sdk.openadsdk.core.settings.hp.aP().cl(String.valueOf(hFV()));
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObjectEDn);
            jSONObject.put("creatives", jSONArray);
            jSONObject.put("did", 1);
            jSONObject.put("processing_time_ms", 100);
            jSONObject.put("request_id", "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
            jSONObject.put("s_receive_ts", 1);
            jSONObject.put("s_send_ts", 1);
            jSONObject.put("status_code", AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            jSONObject.put("core_settings", jSONObjectCl);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("MaterialMeta", "toJsonObjPlus", e.getMessage());
            return jSONObject;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean NV() {
        return this.HTA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void OOq(String str) {
        this.jk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public long OW() {
        return this.fdM;
    }

    public int OZE() {
        return this.BES;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean Os() {
        return this.OyN == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int OyN() {
        if (this.XfO < 0) {
            JSONObject jSONObjectDYs = DYs();
            if (jSONObjectDYs != null) {
                this.XfO = jSONObjectDYs.optInt("ad_slot_type", 0);
            } else {
                this.XfO = 0;
            }
        }
        return this.XfO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void PR() {
        c cVar = this.wD;
        if (cVar == null || TextUtils.isEmpty(cVar.h)) {
            return;
        }
        try {
            if (!this.wD.h.contains("style_id")) {
                this.EJ = false;
            } else {
                this.EJ = true;
                this.Kn = Uri.parse(this.wD.h).getQueryParameters("style_id").get(0);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String PTq() {
        return this.HSR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public c Pbh() {
        return this.nm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public c QLG() {
        return this.ii;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean QNg() {
        return this.EJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public com.bytedance.sdk.openadsdk.core.EV.IlO QfH() {
        return this.Fv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public com.bytedance.sdk.openadsdk.core.NV.Bc.IlO QtY() {
        return this.hS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean SU() {
        hp hpVar;
        return xJ() && !NLy() && (hpVar = this.QLG) != null && hpVar.IlO() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void SZ() {
        this.pS = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int TU() {
        return this.hHv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean Tgn() {
        return OyN() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean TkD() {
        return this.VFH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public zPa Tx() {
        return this.pP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public MY Uj() {
        return this.PR;
    }

    public int Un() {
        return this.hL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public long VC() {
        return this.bWL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean VFH() {
        c cVar = this.wD;
        return cVar == null || cVar.m != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public tV VH() {
        return this.zLG;
    }

    public String VNi() {
        return this.tU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String VVb() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean WIv() {
        return this.EeJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public hp XfO() {
        return this.QLG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int XvI() {
        int i2 = this.XvI;
        if (i2 > 0) {
            return i2;
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int YA() {
        return this.ED;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public com.bytedance.sdk.openadsdk.kBB.IlO.MY Yq() {
        return this.eVC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public double ZUt() {
        return lEW(DYs());
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int aP() {
        return this.ao;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int aQ() {
        if (this.NLy < 0) {
            try {
                JSONObject jSONObjectDYs = DYs();
                if (jSONObjectDYs != null) {
                    this.NLy = jSONObjectDYs.optInt("is_drop_to_retargeting_sample", 0);
                } else {
                    this.NLy = 0;
                }
            } catch (Throwable unused) {
                this.NLy = 0;
            }
        }
        return this.NLy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String aa() {
        if (!TextUtils.isEmpty(this.lMM)) {
            return this.lMM;
        }
        Context contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        int iJz = Jz();
        if (iJz != 2 && iJz != 3) {
            if (iJz == 4) {
                return contextIlO != null ? com.bytedance.sdk.component.utils.pP.IlO(contextIlO, "tt_video_download_apk") : this.lMM;
            }
            if (iJz != 8) {
                return this.lMM;
            }
        }
        return contextIlO != null ? com.bytedance.sdk.component.utils.pP.IlO(contextIlO, "tt_video_mobile_go_detail") : this.lMM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean ao() {
        return this.ZUt;
    }

    public int ar() {
        return this.eeU;
    }

    public String aw() {
        return this.YA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean bWL() {
        return (TextUtils.isEmpty(rp()) || TextUtils.isEmpty(hp())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean bYL() {
        return this.hp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public List<FilterWord> cJK() {
        return this.es;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public Cc cL() {
        return this.LO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public vCE cl() {
        return this.TkD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean ct() {
        return this.TU == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean dM() {
        return this.BK;
    }

    public int dX() {
        return this.VC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean dY() {
        return this.OW == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String dm() {
        return this.vSq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int drv() {
        String strValueOf;
        if (ie() != null && ie().EO() >= 0) {
            return ie().EO();
        }
        if (ssS() != null) {
            strValueOf = ssS().getCodeId();
        } else {
            int iHFV = hFV();
            strValueOf = iHFV != 0 ? String.valueOf(iHFV) : null;
        }
        if (strValueOf != null) {
            return com.bytedance.sdk.openadsdk.core.cl.tV().NV(strValueOf);
        }
        return 30;
    }

    public String dvD() {
        return this.aP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject eDn() {
        Object objTV;
        Object objNV;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_response_info", rv());
            jSONObject.put("interaction_type", Jz());
            jSONObject.put("iv_skip_time", this.ea);
            jSONObject.put("rv_skip_time", this.zPa);
            jSONObject.put(oeT.tV, qq());
            jSONObject.put("interaction_method", kBB());
            jSONObject.put("lp_click_type", su());
            jSONObject.put("lp_click_interval", sr());
            jSONObject.put("proportion_watching", vSq());
            jSONObject.put(oeT.EO, dX());
            jSONObject.put(oeT.Cc, ii());
            jSONObject.put("target_url", pFe());
            jSONObject.put("app_log_url", PTq());
            jSONObject.put("gecko_id", tU());
            jSONObject.put("extension", qyG());
            jSONObject.put("ad_id", ED());
            jSONObject.put("source", hL());
            jSONObject.put("app_name", aw());
            jSONObject.put("screenshot", tf());
            jSONObject.put("dislike_control", ML());
            jSONObject.put("play_bar_show_time", gQ());
            jSONObject.put("play_bar_style", zLG());
            jSONObject.put("if_block_lp", iuH());
            jSONObject.put("cache_sort", ar());
            jSONObject.put("if_sp_cache", OZE());
            jSONObject.put("render_control", oc());
            jSONObject.put("mrc_report", this.TU);
            jSONObject.put("isMrcReportFinish", this.BK);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C2300e4.h.G0, tl());
            jSONObject2.put(Y1.f7807d, pP());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", OOq());
            jSONObject3.put("reward_amount", wPn());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(rp()) && !TextUtils.isEmpty(hp())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", rp());
                jSONObject4.put("adchoices_url", hp());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            zPa zpaHTA = HTA();
            if (zpaHTA != null && !TextUtils.isEmpty(zpaHTA.IlO())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("url", zpaHTA.IlO());
                jSONObject5.put("height", zpaHTA.EO());
                jSONObject5.put("width", zpaHTA.MY());
                jSONObject.put(C2300e4.h.H0, jSONObject5);
            }
            zPa zpaTx = Tx();
            if (zpaTx != null && !TextUtils.isEmpty(zpaTx.IlO())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", zpaTx.IlO());
                jSONObject6.put("height", zpaTx.EO());
                jSONObject6.put("width", zpaTx.MY());
                jSONObject.put("cover_image", jSONObject6);
            }
            Object objVZk = vZk();
            if (objVZk != null) {
                jSONObject.put("session_params", objVZk);
            }
            Object objJM = jM();
            if (objJM != null) {
                jSONObject.put("dynamic_configs", objJM);
            }
            DmF dmFBS = BS();
            if (dmFBS != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", dmFBS.IlO);
                jSONObject7.put("click_upper_non_content_area", dmFBS.MY);
                jSONObject7.put("click_lower_content_area", dmFBS.EO);
                jSONObject7.put("click_lower_non_content_area", dmFBS.tV);
                jSONObject7.put("click_button_area", dmFBS.Cc);
                jSONObject7.put("click_video_area", dmFBS.vCE);
                jSONObject.put("click_area", jSONObject7);
            }
            vCE vceCl = cl();
            if (vceCl != null) {
                jSONObject.put("arbitrage_interceptor_params", vceCl.Bc());
            }
            AdSlot adSlotSsS = ssS();
            if (adSlotSsS != null) {
                jSONObject.put("adslot", adSlotSsS.toJsonObj());
            }
            List<zPa> listHg = Hg();
            if (listHg != null) {
                JSONArray jSONArray = new JSONArray();
                for (zPa zpa : listHg) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("url", zpa.IlO());
                    jSONObject8.put("height", zpa.EO());
                    jSONObject8.put("width", zpa.MY());
                    jSONObject8.put("image_preview", zpa.vCE());
                    jSONObject8.put("image_key", zpa.Bc());
                    jSONArray.put(jSONObject8);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listQvT = qvT();
            if (listQvT != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listQvT.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listTs = ts();
            if (listTs != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listTs.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            List<String> listBO = BO();
            if (listBO != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<String> it3 = listBO.iterator();
                while (it3.hasNext()) {
                    jSONArray4.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", qz());
            jSONObject.put("title", dm());
            jSONObject.put("description", gm());
            jSONObject.put("ext", KT());
            jSONObject.put("image_mode", uI());
            jSONObject.put("cover_click_area", qqU());
            jSONObject.put("intercept_flag", Klw());
            jSONObject.put("button_text", aa());
            jSONObject.put("ad_logo", LqZ());
            jSONObject.put("video_adaptation", DM());
            jSONObject.put("feed_video_opentype", lMM());
            jSONObject.put("orientation", BES());
            jSONObject.put("aspect_ratio", La());
            tV tVVarVH = VH();
            if (tVVarVH != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("app_name", tVVarVH.MY());
                jSONObject9.put(C2300e4.h.V, tVVarVH.EO());
                jSONObject9.put("download_url", tVVarVH.IlO());
                jSONObject9.put(FirebaseAnalytics.Param.SCORE, tVVarVH.tV());
                jSONObject9.put("comment_num", tVVarVH.Cc());
                jSONObject9.put("app_size", tVVarVH.vCE());
                jSONObject9.put("app_category", tVVarVH.Bc());
                jSONObject.put("app", jSONObject9);
            }
            EV evZTS = zTS();
            if (evZTS != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("deeplink_url", evZTS.IlO());
                jSONObject10.put("fallback_url", evZTS.MY());
                jSONObject10.put("fallback_type", evZTS.EO());
                jSONObject.put("deep_link", jSONObject10);
            }
            jSONObject.put("is_web_jump_ip", this.EV);
            tl tlVarIWr = IWr();
            if (tlVarIWr != null && (objNV = tlVarIWr.NV()) != null) {
                jSONObject.put("oem", objNV);
            }
            kBB kbbIe = ie();
            if (kbbIe != null && (objTV = kbbIe.tV()) != null) {
                jSONObject.put("multi_ad_scene", objTV);
            }
            List<FilterWord> listCJK = cJK();
            if (listCJK != null) {
                JSONArray jSONArray5 = new JSONArray();
                Iterator<FilterWord> it4 = listCJK.iterator();
                while (it4.hasNext()) {
                    JSONObject jSONObjectMY = MY(it4.next());
                    if (jSONObjectMY != null) {
                        jSONArray5.put(jSONObjectMY);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            oeT().IlO(jSONObject);
            jSONObject.put("count_down", Un());
            jSONObject.put("expiration_time", OW());
            c cVarQLG = QLG();
            if (cVarQLG != null) {
                jSONObject.put(MimeTypes.BASE_TYPE_VIDEO, cVarQLG.b());
            }
            c cVarPbh = Pbh();
            if (cVarPbh != null) {
                jSONObject.put("h265_video", cVarPbh.b());
            }
            jSONObject.put("video_encode_type", LT());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("if_send_click", Dxv());
            jSONObject.put("download_conf", jSONObject11);
            if (tN() != null) {
                JSONObject jSONObject12 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = tN().entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject12.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject12);
            }
            oeT.IlO ilOUvo = uvo();
            if (ilOUvo != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", ilOUvo.vCE());
                jSONObject13.put("md5", ilOUvo.Bc());
                jSONObject13.put("url", ilOUvo.lEW());
                jSONObject13.put("data", ilOUvo.DmF());
                jSONObject13.put("diff_data", ilOUvo.NV());
                jSONObject13.put("version", ilOUvo.Cc());
                jSONObject13.put("dynamic_creative", ilOUvo.EV());
                jSONObject13.put("engine_version", ilOUvo.hp());
                jSONObject13.put("ugen_data", ilOUvo.cl());
                jSONObject13.put("ugen_md5", ilOUvo.zPa());
                jSONObject13.put("ugen_url", ilOUvo.ea());
                jSONObject.put("tpl_info", jSONObject13);
            }
            dY dYVar = this.fo;
            if (dYVar != null) {
                jSONObject.put("tpl_info_v3", dYVar.vCE());
            }
            jSONObject.put("dynamic_creative", jdn());
            jSONObject.put("creative_extra", HSR());
            jSONObject.put("market_url", VNi());
            jSONObject.put("auction_price", mmj());
            jSONObject.put("ad_info", dvD());
            jSONObject.put("is_package_open", aP());
            jSONObject.put("playable_duration_time", XvI());
            jSONObject.put("playable_endcard_close_time", IRy());
            jSONObject.put("endcard_close_time", BC());
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("render_sequence", nvX());
            jSONObject14.put("backup_render_control", YA());
            jSONObject14.put("reserve_time", TU());
            jSONObject14.put("render_thread", BK());
            jSONObject.put("render", jSONObject14);
            if (this.CQo == null) {
                xF xFVar = new xF();
                this.CQo = xFVar;
                xFVar.IlO("");
                this.CQo.IlO(10L);
                this.CQo.MY(20L);
                this.CQo.EO(10L);
                this.CQo.tV(20L);
            }
            JSONObject jSONObject15 = new JSONObject();
            jSONObject15.put("onlylp_loading_maxtime", this.CQo.IlO());
            jSONObject15.put("straight_lp_showtime", this.CQo.MY());
            jSONObject15.put("onlyagg_loading_maxtime", this.CQo.EO());
            jSONObject15.put("straight_agg_showtime", this.CQo.tV());
            jSONObject15.put("loading_text", this.CQo.Cc());
            cl clVar = this.QtY;
            if (clVar != null) {
                jSONObject15 = clVar.IlO(jSONObject15);
            }
            jSONObject.put("interaction_method_params", jSONObject15);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("splash_clickarea", es());
            jSONObject16.put("splash_layout_id", xF());
            jSONObject16.put("load_wait_time", AXM());
            Cc cc = this.LO;
            jSONObject16.put("skip_time", cc != null ? cc.IlO() : 0);
            jSONObject.put("splash_control", jSONObject16);
            if (Os()) {
                jSONObject.put("dsp_html", this.ct);
            }
            if (xJ()) {
                jSONObject.put("vast_json", this.Fv.NV());
            }
            jSONObject.put("dsp_material_type", lQ());
            jSONObject.put("deep_link_appname", this.nvX);
            jSONObject.put("landing_page_download_clicktype", this.mmj);
            hp hpVar = this.QLG;
            if (hpVar != null) {
                jSONObject.put("dsp_style", hpVar.Cc());
            }
            jSONObject.put("jump_probability", this.fHv);
            jSONObject.put("identificationOverlayContent", this.jk);
            if (this.hS != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("endcard", this.hS.IlO(this.Tgn));
                jSONObject.put("ugen", jSONObject17);
            }
            jSONObject.put("preload_h5_type", eVC());
            jSONObject.put("hasReportShow", this.lQ);
            jSONObject.put("endcard_creative", this.ey);
            jSONObject.put("image_stay", this.hjY);
            jSONObject.put("ad_label", this.PR.vCE());
            JSONObject jSONObject18 = new JSONObject();
            jSONObject18.put(a.j, this.vCE);
            jSONObject18.put("wait_time", this.Bc);
            jSONObject18.put("label", this.lEW);
            jSONObject.put("ev", jSONObject18);
            jSONObject.put("ad_label", this.PR.vCE());
            if (this.gYU != null) {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("width", this.gYU.getWidth());
                jSONObject19.put("height", this.gYU.getHeight());
                jSONObject.put("banner", jSONObject19);
            }
            if (!TextUtils.isEmpty(this.DYs)) {
                jSONObject.put("gdid_encrypted", this.DYs);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int eVC() {
        return this.tcT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public xF ea() {
        return this.CQo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public oc eeU() {
        return this.jS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            oeT oet = (oeT) obj;
            if (this.DM.equals(oet.ED()) && this.AK.equals(oet.KT())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int es() {
        Cc cc = this.LO;
        if (cc == null) {
            return 2;
        }
        return cc.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean ey() {
        if (xJ() && !NLy()) {
            int iNextInt = new Random().nextInt(100);
            hp hpVar = this.QLG;
            if (hpVar != null && iNextInt < hpVar.EO()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int fHv() {
        return this.XfO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public c fdM() {
        return this.wD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean fnd() {
        return this.JAC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean fo() {
        return OyN() == 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int gQ() {
        return this.VH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String gYU() {
        return this.DYs;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String gm() {
        return this.dY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int hFV() {
        JSONObject jSONObjectDYs = DYs();
        if (jSONObjectDYs != null) {
            return jSONObjectDYs.optInt("rit", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int hHv() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String hL() {
        return this.gQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean hS() {
        return OyN() == 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public DM hjY() {
        return this.xF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String hp() {
        return this.qIK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public kBB ie() {
        return this.mV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int ii() {
        return this.bYL;
    }

    public int iuH() {
        return this.OW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject jM() {
        return this.jM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String jS() {
        return this.Kn;
    }

    public JSONObject jdn() {
        return this.hFV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public long jk() {
        if (this.IK < 0) {
            JSONObject jSONObjectDYs = DYs();
            if (jSONObjectDYs != null) {
                this.IK = jSONObjectDYs.optLong("ad_id", 0L);
            } else {
                this.IK = 0L;
            }
        }
        return this.IK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean jm() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int kBB() {
        return this.vAh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String kw() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int lMM() {
        return this.tN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int lQ() {
        return this.OyN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean mV() {
        List<Integer> listEO;
        return (uvo() == null || (listEO = uvo().EO()) == null || !listEO.contains(57)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String mmj() {
        return this.La;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean nm() {
        return this.VC == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean nt() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int nu() {
        return this.Bc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int nvX() {
        return this.aa;
    }

    public com.bytedance.sdk.component.adexpress.IlO.EO.tV oAy() {
        oeT.IlO ilOUvo = uvo();
        if (ilOUvo == null) {
            return null;
        }
        return oeT.IlO.IlO(ilOUvo, String.valueOf(hFV()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int oc() {
        int i2 = this.oeT;
        if (i2 == 5 || i2 == 6 || i2 == 33) {
            return 1;
        }
        if (pS()) {
            return 2;
        }
        return this.KC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public OOq oeT() {
        return this.qyG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String pFe() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int pP() {
        return this.QfH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean pS() {
        return ssS() != null && ssS().getDurationSlotType() == 8 && Os();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean pbX() {
        /*
            r3 = this;
            boolean r0 = r3.NLy()
            r1 = 0
            if (r0 != 0) goto L2f
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r2 = 100
            int r0 = r0.nextInt(r2)
            boolean r2 = r3.xJ()
            if (r2 == 0) goto L21
            com.bytedance.sdk.openadsdk.core.model.hp r2 = r3.QLG
            if (r2 == 0) goto L2a
            int r2 = r2.MY()
            goto L2b
        L21:
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.OOq.MY(r3)
            if (r2 != 0) goto L2a
            int r2 = r3.fHv
            goto L2b
        L2a:
            r2 = r1
        L2b:
            if (r0 >= r2) goto L2f
            r0 = 1
            return r0
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.model.wPn.pbX():boolean");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int ps() {
        Map<String, Object> map = this.ts;
        if (map == null) {
            return 0;
        }
        try {
            Object obj = map.get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null) {
                return Integer.parseInt(obj.toString());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String qIK() {
        return this.nvX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void qX() {
        this.JAC = true;
    }

    public int qq() {
        return this.Ei;
    }

    public int qqU() {
        return this.Jz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void quf(int i2) {
        this.tcT = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public List<String> qvT() {
        return this.wPn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject qyG() {
        return this.NI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String qz() {
        return this.OOq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String rHm() {
        return this.ey;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String rp() {
        return this.Pbh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String rv() {
        return this.xqE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public long sr() {
        return this.NV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public AdSlot ssS() {
        return this.KT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int su() {
        return this.DmF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public Map<String, Object> tN() {
        return this.ts;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String tU() {
        return this.Aw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tV(int i2) {
        IlO(i2, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    @Nullable
    public String tcT() {
        tV tVVarVH = VH();
        if (tVVarVH == null || TextUtils.isEmpty(tVVarVH.IlO())) {
            return null;
        }
        return tVVarVH.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean tf() {
        return this.qz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tl(String str) {
        this.DYs = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public List<String> ts() {
        return this.oc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean uAj() {
        return this.QNg;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean uF() {
        return !xJ() && ML() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int uI() {
        return this.ssS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void uvo(int i2) {
        this.SU = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int vAh() {
        return this.oeT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vCE(String str) {
        this.qIK = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int vSq() {
        return this.Ea;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public JSONObject vZk() {
        return this.vZk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean vh() {
        return this.lQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean wD() {
        return this.Ei == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void wPn(String str) {
        this.ey = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int xF() {
        if (mV()) {
            return 5;
        }
        if (Os()) {
            return 4;
        }
        Cc cc = this.LO;
        if (cc == null) {
            return 1;
        }
        return cc.EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean xJ() {
        int i2 = this.OyN;
        return (i2 == 1 || i2 == 3) && QfH() != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public com.bytedance.sdk.openadsdk.core.NV.Bc.IlO xqE() {
        return this.Tgn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int zLG() {
        if (xJ()) {
            return 5;
        }
        if (La() != 100.0f || oc() == 2) {
            return 0;
        }
        return this.zTS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public cl zPa() {
        return this.QtY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public EV zTS() {
        return this.BS;
    }

    private String lMM(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.bytedance.sdk.component.utils.zPa.IlO(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("MaterialMeta", "generate icon key error", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean AK() {
        return qqU() == 100 || this.oeT == 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void AXM(int i2) {
        this.qvT = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void BS(int i2) {
        this.Os = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Bc(String str) {
        this.quf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Cc(int i2) {
        this.oeT = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void DM(int i2) {
        this.LT = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void DmF(boolean z2) {
        this.EeJ = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Dxv(int i2) {
        if (i2 < 0 || i2 > 30) {
            i2 = 6;
        }
        this.Bc = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(boolean z2) {
        this.pFe = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EV(int i2) {
        this.aa = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Ea(int i2) {
        this.DmF = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void HSR(int i2) {
        this.OyN = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(vCE vce) {
        this.TkD = vce;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public boolean KC() {
        oeT.IlO ilO = this.BO;
        if (ilO != null) {
            return !TextUtils.isEmpty(ilO.hp());
        }
        int i2 = this.aa;
        return i2 == 9 || i2 == 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO) {
        this.Tgn = ilO;
        com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO(ilO, "endcard");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void NV(int i2) {
        this.tN = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String OOq() {
        return this.quf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void YA(int i2) {
        this.TU = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void bWL(int i2) {
        this.cJK = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void cL(int i2) {
        this.eeU = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void cl(int i2) {
        this.VH = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void dY(int i2) {
        this.XvI = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void ea(int i2) {
        this.zTS = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void es(int i2) {
        this.BES = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void gQ(int i2) {
        this.mmj = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void hp(int i2) {
        this.tf = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void kBB(int i2) {
        this.VC = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void mmj(int i2) {
        this.hHv = Math.max(0, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void nvX(int i2) {
        this.BC = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void oeT(int i2) {
        this.Ei = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void pP(int i2) {
        this.bYL = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int quf() {
        return this.qvT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void rp(int i2) {
        this.ED = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void ssS(int i2) {
        this.KS = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tV(boolean z2) {
        this.qz = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int tl() {
        return this.xJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public oeT.IlO uvo() {
        return this.BO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vAh(int i2) {
        this.AXM = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vCE(int i2) {
        this.uvo = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vSq(int i2) {
        this.ao = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int wPn() {
        return this.uvo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void zPa(int i2) {
        this.uI = i2;
    }

    private static double lEW(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void AXM(String str) {
        this.Aw = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Bc(int i2) {
        this.KC = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Cc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.AXM = 4;
        this.DM = jSONObject.optString("id");
        this.gQ = jSONObject.optString("source");
        tV tVVar = new tV();
        this.zLG = tVVar;
        tVVar.EO(jSONObject.optString("pkg_name"));
        this.zLG.MY(jSONObject.optString("name"));
        this.zLG.IlO(jSONObject.optString("download_url"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void DmF(int i2) {
        this.OW = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(zPa zpa) {
        this.cl.add(zpa);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EV(String str) {
        this.gQ = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(xF xFVar) {
        this.CQo = xFVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void NV(String str) {
        this.dm = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void OOq(int i2) {
        this.hL = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void bWL(String str) {
        this.OOq = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void cL(String str) {
        this.DM = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void cl(String str) {
        this.lMM = str;
    }

    public void dY(String str) {
        this.Ct = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void ea(String str) {
        this.vSq = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void es(String str) {
        this.HSR = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void hp(String str) {
        this.tl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void kBB(String str) {
        this.nvX = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void oeT(String str) {
        this.tU = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public String pP(String str) {
        JSONObject jSONObjectDYs = DYs();
        return jSONObjectDYs != null ? jSONObjectDYs.optString("rit", str) : str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void rp(String str) {
        this.YA = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tV(JSONObject jSONObject) {
        this.vZk = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tl(int i2) {
        this.ssS = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vAh(String str) {
        this.ct = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vCE(JSONObject jSONObject) {
        this.NI = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vSq(String str) {
        this.xqE = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void wPn(int i2) {
        this.eDn = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void zPa(String str) {
        this.dY = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Bc(JSONObject jSONObject) {
        this.PR.IlO(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void DmF(String str) {
        this.La = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(JSONObject jSONObject) {
        this.jM = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EV(boolean z2) {
        this.QNg = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(cl clVar) {
        this.QtY = clVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(double d8) {
        if (d8 != 2.0d && d8 != 1.0d) {
            this.xJ = 2;
        } else {
            this.xJ = (int) d8;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void NV(boolean z2) {
        this.MY = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void lEW(boolean z2) {
        this.lQ = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void oc(int i2) {
        this.Dxv = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void rp(boolean z2) {
        this.vCE = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void tV(long j) {
        this.NV = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void vCE(boolean z2) {
        this.hp = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void xF(int i2) {
        this.Jz = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void zLG(int i2) {
        this.Hg = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(c cVar) {
        this.nm = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO) {
        this.hS = ilO;
        com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO(ilO, "endcard");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void lEW(int i2) {
        this.Ea = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void lMM(int i2) {
        this.IRy = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void oc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lEW = com.bytedance.sdk.openadsdk.kBB.IlO.EO.EO;
        } else {
            this.lEW = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void xF(String str) {
        this.AK = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void EO(long j) {
        this.bWL = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(JSONObject jSONObject) {
        this.hFV = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void lEW(String str) {
        this.aP = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int EO() {
        return this.zPa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(Cc cc) {
        this.LO = cc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(zPa zpa) {
        this.pP = zpa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(OOq oOq) {
        this.qyG = oOq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(long j) {
        this.fdM = j;
    }

    private JSONObject MY(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(MY(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(int i2, int i8) {
        this.vAh = i2;
        this.oeT = i2;
        if (this.KT == null) {
            this.oeT = 0;
            return;
        }
        if (i8 <= 0) {
            i8 = OyN();
        }
        if (this.KT.getNativeAdType() != 3 && this.KT.getDurationSlotType() != 3 && i8 != 3) {
            if (this.KT.getNativeAdType() != 7 && this.KT.getNativeAdType() != 8 && this.KT.getDurationSlotType() != 7 && this.KT.getDurationSlotType() != 8 && i8 != 7 && i8 != 8) {
                if (OOq.MY(this)) {
                    this.oeT = 4;
                    return;
                }
                if (this.vAh == 4 && !OOq.MY(this)) {
                    this.oeT = 0;
                }
                int i9 = this.vAh;
                if (i9 == 41) {
                    this.oeT = 41;
                    return;
                }
                if (i2 >= 5) {
                    this.oeT = 0;
                    return;
                }
                if (i9 == 2 && Jz() != 3) {
                    this.oeT = 0;
                    return;
                } else {
                    if (i2 == 0 || (i2 == 1 && Jz() != 3)) {
                        this.oeT = 0;
                        return;
                    }
                    return;
                }
            }
            if (OOq.EO(this)) {
                this.oeT = 12;
                return;
            }
            if (OOq.MY(this)) {
                this.oeT = 9;
                return;
            }
            if (this.vAh == 5 && !es.tV(this)) {
                this.oeT = 7;
            }
            if (this.vAh == 6 && !es.MY(this)) {
                this.oeT = 7;
            }
            if (this.vAh == 8 && qqU() != 100) {
                this.oeT = 7;
            }
            if (this.vAh == 19 && TextUtils.isEmpty(this.tl)) {
                this.oeT = 7;
            }
            if (this.vAh == 20 && TextUtils.isEmpty(this.tl)) {
                this.oeT = 7;
            }
            if (this.vAh == 38 && !es.EO(this)) {
                this.oeT = 7;
            }
            if (i2 < 5) {
                this.oeT = 7;
                return;
            }
            return;
        }
        this.oeT = 14;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void Cc(boolean z2) {
        this.ZUt = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(c cVar) {
        this.ii = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void MY(int i2) {
        this.zPa = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int MY() {
        int i2 = this.zPa;
        return i2 >= 0 ? i2 : com.bytedance.sdk.openadsdk.core.cl.tV().DmF(String.valueOf(hFV()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(double d8) {
        if (d8 != 2.0d && d8 != 1.0d) {
            this.QfH = 1;
        } else {
            this.QfH = (int) d8;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(DmF dmF) {
        this.PTq = dmF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(AdSlot adSlot) {
        this.KT = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(oeT.IlO ilO) {
        this.BO = ilO;
        com.bytedance.sdk.component.adexpress.IlO.EO.tV tVVarOAy = oAy();
        if (tVVarOAy != null && !KC()) {
            com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(tVVarOAy);
        }
        if (ilO == null || TextUtils.isEmpty(ilO.ea())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO(ZAb(), "ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(dY dYVar) {
        this.fo = dYVar;
        if (dYVar == null || TextUtils.isEmpty(dYVar.EO())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO(Hlg(), "adv3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(c cVar) {
        this.wD = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(rp rpVar) {
        this.uF = rpVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(zPa zpa) {
        IlO(zpa, oeT.rp);
        String strLMM = lMM(zpa.IlO());
        if (!TextUtils.isEmpty(strLMM)) {
            zpa.MY(strLMM);
        }
        this.kBB = zpa;
    }

    private void IlO(zPa zpa, int i2) {
        if (zpa != null) {
            try {
                if (TextUtils.isEmpty(zpa.IlO())) {
                    return;
                }
                if (zpa.MY() == 0 && zpa.EO() == 0) {
                    zpa.IlO(i2);
                    zpa.MY(i2);
                    return;
                }
                if (zpa.MY() == 0) {
                    if (zpa.EO() > i2) {
                        zpa.MY(i2);
                        zpa.IlO(i2);
                        return;
                    } else {
                        zpa.IlO(zpa.EO());
                        return;
                    }
                }
                if (zpa.EO() == 0) {
                    if (zpa.MY() > i2) {
                        zpa.MY(i2);
                        zpa.IlO(i2);
                        return;
                    } else {
                        zpa.MY(zpa.MY());
                        return;
                    }
                }
                if (zpa.MY() > zpa.EO()) {
                    if (zpa.MY() > i2) {
                        zpa.MY((int) (i2 / (zpa.MY() / zpa.EO())));
                        zpa.IlO(i2);
                        return;
                    }
                    return;
                }
                if (zpa.EO() > i2) {
                    zpa.IlO((int) (i2 * (zpa.MY() / zpa.EO())));
                    zpa.MY(i2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(tV tVVar) {
        this.zLG = tVVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(EV ev) {
        this.BS = ev;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(FilterWord filterWord) {
        this.es.add(filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(Map<String, Object> map) {
        this.ts = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(float f4) {
        this.NST = f4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(com.bytedance.sdk.openadsdk.core.EV.IlO ilO) {
        this.Fv = ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(ea eaVar) {
        this.dM = eaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(hp hpVar) {
        this.QLG = hpVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(tl tlVar) {
        this.kw = tlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(PAGBannerSize pAGBannerSize) {
        this.gYU = pAGBannerSize;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(kBB kbb) {
        this.mV = kbb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(com.bytedance.sdk.openadsdk.kBB.IlO.MY my) {
        this.eVC = my;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(int i2) {
        this.ea = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public int IlO() {
        int i2 = this.ea;
        return i2 >= 0 ? i2 : com.bytedance.sdk.openadsdk.core.cl.tV().cL(String.valueOf(hFV()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.oeT
    public void IlO(oc ocVar) {
        this.jS = ocVar;
    }
}
