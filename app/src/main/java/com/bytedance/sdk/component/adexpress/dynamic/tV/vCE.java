package com.bytedance.sdk.component.adexpress.dynamic.tV;

import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private int AK;
    private String AXM;
    private int Aw;
    private int BC;
    private JSONObject BES;
    private String BK;
    private int BO;
    private int BS;
    private float Bc;
    private boolean CQo;
    private boolean Cc;
    private int DM;
    private float DmF;
    private String Dxv;
    private int ED;
    private float EO;
    private double EV;
    private int Ea;
    private int Fv;
    private double HSR;
    private int HTA;
    private int Hg;
    private int IRy;
    private float IlO;
    private boolean Jz;
    private boolean KC;
    private String KS;
    private int KT;
    private JSONObject La;
    private float MY;
    private String NI;
    private JSONObject NST;
    private float NV;
    private int OOq;
    private boolean OW;
    private boolean Os;
    private int PTq;
    private int QfH;
    private long TU = -1;
    private boolean Tx;
    private int VH;
    private String XfO;
    private int XvI;
    private String YA;
    private int aP;
    private boolean aa;
    private int ao;
    private String bWL;
    private int cJK;
    private String cL;
    private String cl;
    private int ct;
    private String dM;
    private String dY;
    private String dm;
    private boolean eDn;
    private String ea;
    private double eeU;
    private String es;
    private boolean fdM;
    private int gQ;
    private String gm;
    private boolean hL;
    private String hp;
    private JSONObject ii;
    private boolean jM;
    private String kBB;
    private float lEW;
    private String lMM;
    private boolean mmj;
    private String nm;
    private String nvX;
    private double oc;
    private String oeT;
    private int pFe;
    private boolean pP;
    private boolean quf;
    private int qvT;
    private int qyG;
    private int qz;
    private double rp;
    private int ssS;
    private boolean tN;
    private int tU;
    private float tV;
    private boolean tf;
    private int tl;
    private int ts;
    private String uF;
    private int uI;
    private int uvo;
    private String vAh;
    private float vCE;
    private String vSq;
    private int vZk;
    private boolean wD;
    private double wPn;
    private String xF;
    private String xJ;
    private int zLG;
    private String zPa;
    private List<IlO> zTS;

    public static vCE IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        vCE vce = new vCE();
        vce.MY(jSONObject.optString("adType", "embeded"));
        vce.ea(jSONObject.optString("clickArea", "creative"));
        vce.zPa(jSONObject.optString("clickTigger", C2318f4.f8523d));
        vce.EO(jSONObject.optString("fontFamily", "PingFangSC"));
        vce.tV(jSONObject.optString("textAlign", "left"));
        vce.Cc(jSONObject.optString("color", "#999999"));
        vce.vCE(jSONObject.optString("bgColor", C2300e4.h.T));
        vce.Bc(jSONObject.optString("bgImgUrl", ""));
        vce.OOq(jSONObject.optString("bgImgData", ""));
        vce.lEW(jSONObject.optString("borderColor", "#000000"));
        vce.DmF(jSONObject.optString("borderStyle", "solid"));
        vce.NV(jSONObject.optString("heightMode", "auto"));
        vce.EV(jSONObject.optString("widthMode", "fixed"));
        vce.rp(jSONObject.optString("interactText", ""));
        vce.EO(jSONObject.optBoolean("isShowBgControl", false));
        vce.hp(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            vce.Bc(jSONObjectOptJSONObject.optInt("translateY", 0));
            vce.lEW(jSONObjectOptJSONObject.optInt("translateX", 0));
            vce.tV(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            vce.Cc(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        vce.bWL(jSONObject.optString("interactType", ""));
        vce.Cc(jSONObject.optInt("interactSlideDirection", -1));
        vce.cl(jSONObject.optString("justifyHorizontal", "space-around"));
        vce.cL(jSONObject.optString("justifyVertical", "flex-start"));
        vce.MY(jSONObject.optDouble("timingStart"));
        vce.EO(jSONObject.optDouble("timingEnd"));
        vce.tV((float) jSONObject.optDouble("width", 0.0d));
        vce.EO((float) jSONObject.optDouble("height", 0.0d));
        vce.IlO((float) jSONObject.optDouble("borderRadius", 0.0d));
        vce.MY((float) jSONObject.optDouble("borderSize", 0.0d));
        vce.MY(jSONObject.optBoolean("interactValidate", false));
        vce.DmF((float) jSONObject.optDouble("fontSize", 0.0d));
        vce.Cc((float) jSONObject.optDouble("paddingBottom", 0.0d));
        vce.vCE((float) jSONObject.optDouble("paddingLeft", 0.0d));
        vce.Bc((float) jSONObject.optDouble("paddingRight", 0.0d));
        vce.lEW((float) jSONObject.optDouble("paddingTop", 0.0d));
        vce.tV(jSONObject.optBoolean("lineFeed", false));
        vce.DmF(jSONObject.optInt("lineCount", 0));
        vce.vCE(jSONObject.optDouble("lineHeight", 1.2d));
        vce.bWL(jSONObject.optInt("letterSpacing", 0));
        vce.Cc(jSONObject.optBoolean("isDataFixed", false));
        vce.ea(jSONObject.optInt("fontWeight"));
        vce.vCE(jSONObject.optBoolean("lineLimit"));
        vce.zPa(jSONObject.optInt(C2300e4.h.L));
        vce.es(jSONObject.optString("align"));
        vce.Bc(jSONObject.optBoolean("useLeft"));
        vce.lEW(jSONObject.optBoolean("useRight"));
        vce.DmF(jSONObject.optBoolean("useTop"));
        vce.NV(jSONObject.optBoolean("useBottom"));
        vce.xF(jSONObject.optString("data"));
        vce.MY(jSONObject.optJSONObject("i18n"));
        vce.rp(jSONObject.optInt("marginLeft"));
        vce.hp(jSONObject.optInt("marginRight"));
        vce.NV(jSONObject.optInt("marginTop"));
        vce.EV(jSONObject.optInt("marginBottom"));
        vce.cl(jSONObject.optInt("tagMaxCount"));
        vce.EV(jSONObject.optBoolean("allowTextFlow"));
        vce.cL(jSONObject.optInt("textFlowType"));
        vce.es(jSONObject.optInt("textFlowDuration"));
        vce.xF(jSONObject.optInt("left"));
        vce.AXM(jSONObject.optInt("right"));
        vce.oeT(jSONObject.optInt("top"));
        vce.vAh(jSONObject.optInt("bottom"));
        vce.AXM(jSONObject.optString("alignItems", "flex-start"));
        vce.oeT(jSONObject.optString("direction", ""));
        vce.IlO(jSONObject.optBoolean("loop", false));
        vce.kBB(jSONObject.optInt("zIndex"));
        vce.oc(jSONObject.optInt("interactVisibleTime"));
        vce.pP(jSONObject.optInt("interactHiddenTime"));
        vce.hp(jSONObject.optBoolean("interactEnableMask"));
        vce.bWL(jSONObject.optBoolean("interactWontHide"));
        vce.IlO(jSONObject.optString("bgGradient"));
        vce.dY(jSONObject.optInt("areaType"));
        vce.lMM(jSONObject.optInt("interactSlideThreshold", 0));
        vce.mmj(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.tV.MY() ? 0 : 120));
        vce.cL(jSONObject.optBoolean("openPlayableLandingPage", false));
        vce.EO(jSONObject.optJSONObject(MimeTypes.BASE_TYPE_VIDEO));
        vce.tV(jSONObject.optJSONObject("image"));
        vce.nvX(jSONObject.optInt("borderShadowExtent"));
        vce.ea(jSONObject.optBoolean("bgGauseBlur"));
        vce.YA(jSONObject.optInt("bgGauseBlurRadius"));
        vce.zPa(jSONObject.optBoolean("showTimeProgress", false));
        vce.cl(jSONObject.optBoolean("showPlayButton", false));
        vce.IlO(jSONObject.optDouble("bgColorCg", 0.0d));
        vce.vCE(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        vce.MY(jSONObject.optInt("borderTopLeftRadius", 0));
        vce.IlO(jSONObject.optInt("borderTopRightRadius", 0));
        vce.tV(jSONObject.optInt("borderBottomLeftRadius", 0));
        vce.EO(jSONObject.optInt("borderBottomRightRadius", 0));
        vce.Cc(jSONObject.optJSONObject("interactI18n"));
        vce.kBB(jSONObject.optString("imageObjectFit"));
        vce.pP(jSONObject.optString("interactTitle"));
        vce.vSq(jSONObject.optInt("interactTextPositionTop"));
        vce.vAh(jSONObject.optString("imageLottieTosPath"));
        vce.rp(jSONObject.optBoolean("animationsLoop"));
        vce.tl(jSONObject.optInt("lottieAppNameMaxLength"));
        vce.wPn(jSONObject.optInt("lottieAdDescMaxLength"));
        vce.OOq(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    IlO ilO = new IlO();
                    ilO.EO(jSONObject2.optString("animationType"));
                    ilO.IlO(jSONObject2.optDouble("animationDuration"));
                    ilO.MY(jSONObject2.optDouble("animationScaleX"));
                    ilO.EO(jSONObject2.optDouble("animationScaleY"));
                    ilO.tV(jSONObject2.optString("animationTimeFunction"));
                    ilO.tV(jSONObject2.optDouble("animationDelay"));
                    ilO.vCE(jSONObject2.optInt("animationIterationCount"));
                    ilO.Cc(jSONObject2.optString("animationDirection"));
                    ilO.Cc(jSONObject2.optDouble("animationInterval"));
                    ilO.IlO(jSONObject2.optInt("animationBorderWidth"));
                    ilO.IlO(jSONObject2.optLong(C2300e4.h.W));
                    ilO.MY(jSONObject2.optInt("animationEffectWidth"));
                    ilO.EO(jSONObject2.optInt("animationSwing", 1));
                    ilO.tV(jSONObject2.optInt("animationTranslateX"));
                    ilO.Cc(jSONObject2.optInt("animationTranslateY"));
                    ilO.MY(jSONObject2.optString("animationRippleBackgroundColor"));
                    ilO.IlO(jSONObject2.optString("animationScaleDirection"));
                    ilO.Bc(jSONObject2.optInt("animationFadeStart"));
                    ilO.lEW(jSONObject2.optInt("animationFadeEnd"));
                    ilO.vCE(jSONObject2.optString("animationFillMode"));
                    ilO.DmF(jSONObject2.optInt("animationBounceHeight"));
                    if (vce.es() > 0.0d) {
                        ilO.tV(ilO.bWL() + vce.es());
                    }
                    arrayList.add(ilO);
                }
                vce.IlO(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                vce.tl(jSONObject.optString("triggerSlideDirection", "0"));
                vce.IlO(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return vce;
    }

    private void OOq(String str) {
        this.BK = str;
    }

    public int AK() {
        return this.DM;
    }

    public String AXM() {
        return this.ea;
    }

    public int Aw() {
        return this.QfH;
    }

    public boolean BC() {
        return this.tf;
    }

    public boolean BES() {
        return this.eDn;
    }

    public boolean BO() {
        return this.Tx;
    }

    public String BS() {
        return this.lMM;
    }

    public int Bc() {
        return this.Aw;
    }

    public JSONObject CQo() {
        return this.La;
    }

    public int Cc() {
        return this.BC;
    }

    public String DM() {
        return this.vSq;
    }

    public int DmF() {
        return this.aP;
    }

    public double Dxv() {
        return this.HSR;
    }

    public int ED() {
        return this.qvT;
    }

    public int EO() {
        return this.XvI;
    }

    public float EV() {
        return this.IlO;
    }

    public int Ea() {
        return this.gQ;
    }

    public void Fv() {
        IlO(this, this.BES);
    }

    public boolean HSR() {
        return this.mmj;
    }

    public boolean HTA() {
        return this.fdM;
    }

    public boolean Hg() {
        return this.wD;
    }

    public int IRy() {
        return this.tU;
    }

    public int Jz() {
        return this.uvo;
    }

    public int KC() {
        return this.ssS;
    }

    public boolean KS() {
        return this.jM;
    }

    public String KT() {
        return this.gm;
    }

    public String La() {
        return this.xJ;
    }

    public int MY() {
        return this.ao;
    }

    public String NI() {
        return this.dM;
    }

    public int NST() {
        return this.KT;
    }

    public String NV() {
        return this.XfO;
    }

    public boolean OW() {
        return this.CQo;
    }

    public String Os() {
        return this.uF;
    }

    public int PTq() {
        return this.ts;
    }

    public int QfH() {
        return this.vZk;
    }

    public boolean Tx() {
        return this.hL;
    }

    public int VH() {
        return this.BO;
    }

    public boolean XvI() {
        return this.OW;
    }

    public double YA() {
        return this.wPn;
    }

    public int aP() {
        return this.uI;
    }

    public int aa() {
        return this.qz;
    }

    public int ao() {
        return this.cJK;
    }

    public float bWL() {
        return this.vCE;
    }

    public int cJK() {
        return this.PTq;
    }

    public float cL() {
        return this.NV;
    }

    public float cl() {
        return this.DmF;
    }

    public void ct() {
        IlO(this, this.La);
    }

    public long dM() {
        return this.TU;
    }

    public boolean dY() {
        return this.pP;
    }

    public int dm() {
        return this.pFe;
    }

    public int eDn() {
        List<IlO> list = this.zTS;
        if (list == null) {
            return 0;
        }
        for (IlO ilO : list) {
            if ("translate".equals(ilO.DmF()) && ilO.Bc() < 0) {
                return -ilO.Bc();
            }
        }
        return 0;
    }

    public float ea() {
        return this.Bc;
    }

    public int eeU() {
        return this.VH;
    }

    public double es() {
        return this.EV;
    }

    public int fdM() {
        return this.AK;
    }

    public String gQ() {
        return this.YA;
    }

    public int gm() {
        return this.Hg;
    }

    public boolean hL() {
        return this.quf;
    }

    public boolean hp() {
        return this.Cc;
    }

    public String ii() {
        return this.Dxv;
    }

    public boolean jM() {
        return this.Os;
    }

    public String kBB() {
        return this.cL;
    }

    public double lEW() {
        return this.eeU;
    }

    public int lMM() {
        return this.tl;
    }

    public double mmj() {
        return this.oc;
    }

    public int nm() {
        return this.Ea;
    }

    public int nvX() {
        return this.OOq;
    }

    public String oc() {
        return this.vAh;
    }

    public String oeT() {
        return this.zPa;
    }

    public boolean pFe() {
        return this.Jz;
    }

    public String pP() {
        return this.BK;
    }

    public int quf() {
        return this.zLG;
    }

    public JSONObject qvT() {
        return this.ii;
    }

    public String qyG() {
        return this.NI;
    }

    public String qz() {
        return this.nm;
    }

    public float rp() {
        return this.MY;
    }

    public String ssS() {
        return this.nvX;
    }

    public int tN() {
        return this.Fv;
    }

    public String tU() {
        return this.KS;
    }

    public int tV() {
        return this.IRy;
    }

    public int tf() {
        return this.qyG;
    }

    public String tl() {
        return this.es;
    }

    public int ts() {
        return this.HTA;
    }

    public List<IlO> uF() {
        return this.zTS;
    }

    public int uI() {
        return this.ED;
    }

    public int uvo() {
        return this.BS;
    }

    public String vAh() {
        return this.cl;
    }

    public JSONObject vCE() {
        return this.NST;
    }

    public String vSq() {
        return this.kBB;
    }

    public int vZk() {
        return this.ct;
    }

    public boolean wD() {
        return this.KC;
    }

    public String wPn() {
        return this.oeT;
    }

    public double xF() {
        return this.rp;
    }

    public boolean xJ() {
        return this.tN;
    }

    public String zLG() {
        return this.dY;
    }

    public float zPa() {
        return this.lEW;
    }

    public String zTS() {
        return this.dm;
    }

    public void AXM(int i2) {
        this.qvT = i2;
    }

    public void Bc(float f4) {
        this.lEW = f4;
    }

    public void Cc(int i2) {
        this.Aw = i2;
    }

    public void DmF(float f4) {
        this.NV = f4;
    }

    public void EO(int i2) {
        this.IRy = i2;
    }

    public void EV(String str) {
        this.oeT = str;
    }

    public void MY(int i2) {
        this.XvI = i2;
    }

    public void NV(String str) {
        this.AXM = str;
    }

    public String OOq() {
        return this.AXM;
    }

    public void YA(int i2) {
        this.tU = i2;
    }

    public void bWL(String str) {
        this.vSq = str;
    }

    public void cL(String str) {
        this.YA = str;
    }

    public void cl(String str) {
        this.nvX = str;
    }

    public void dY(int i2) {
        this.KT = i2;
    }

    public void ea(String str) {
        this.dY = str;
    }

    public void es(String str) {
        this.Dxv = str;
    }

    public void hp(String str) {
        this.kBB = str;
    }

    public void kBB(int i2) {
        this.ED = i2;
    }

    public void lEW(float f4) {
        this.DmF = f4;
    }

    public void lMM(int i2) {
        this.uI = i2;
    }

    public void mmj(int i2) {
        this.vZk = i2;
    }

    public void nvX(int i2) {
        this.cJK = i2;
    }

    public void oc(int i2) {
        this.VH = i2;
    }

    public void oeT(int i2) {
        this.ts = i2;
    }

    public void pP(int i2) {
        this.PTq = i2;
    }

    public void rp(String str) {
        this.vAh = str;
    }

    public void tV(int i2) {
        this.BC = i2;
    }

    public void tl(int i2) {
        this.qyG = i2;
    }

    public void vAh(int i2) {
        this.BO = i2;
    }

    public void vCE(int i2) {
        this.aP = i2;
    }

    public void vSq(int i2) {
        this.QfH = i2;
    }

    public void wPn(int i2) {
        this.ct = i2;
    }

    public void xF(String str) {
        this.nm = str;
    }

    public void zPa(String str) {
        this.lMM = str;
    }

    public void AXM(String str) {
        this.dm = str;
    }

    public void Bc(String str) {
        this.cL = str;
    }

    public void Cc(float f4) {
        this.vCE = f4;
    }

    public void DmF(String str) {
        this.xF = str;
    }

    public void EO(float f4) {
        this.EO = f4;
    }

    public void EV(int i2) {
        this.BS = i2;
    }

    public void MY(float f4) {
        this.MY = f4;
    }

    public void NV(int i2) {
        this.zLG = i2;
    }

    public void OOq(int i2) {
        this.Fv = i2;
    }

    public void bWL(int i2) {
        this.AK = i2;
    }

    public void cL(int i2) {
        this.pFe = i2;
    }

    public void cl(int i2) {
        this.HTA = i2;
    }

    public void ea(int i2) {
        this.uvo = i2;
    }

    public void es(int i2) {
        this.Hg = i2;
    }

    public void hp(int i2) {
        this.gQ = i2;
    }

    public void kBB(String str) {
        this.xJ = str;
    }

    public void lEW(String str) {
        this.es = str;
    }

    public void oeT(String str) {
        this.gm = str;
    }

    public void pP(String str) {
        this.NI = str;
    }

    public void rp(int i2) {
        this.ssS = i2;
    }

    public void tV(float f4) {
        this.tV = f4;
    }

    public void tl(String str) {
        this.dM = str;
    }

    public void vAh(String str) {
        this.KS = str;
    }

    public void vCE(float f4) {
        this.Bc = f4;
    }

    public void xF(int i2) {
        this.qz = i2;
    }

    public void zPa(int i2) {
        this.Ea = i2;
    }

    public void Bc(int i2) {
        this.tl = i2;
    }

    public void Cc(String str) {
        this.zPa = str;
    }

    public void DmF(int i2) {
        this.DM = i2;
    }

    public void EO(double d8) {
        this.rp = d8;
    }

    public void EV(boolean z2) {
        this.Tx = z2;
    }

    public void MY(boolean z2) {
        this.Cc = z2;
    }

    public void NV(boolean z2) {
        this.wD = z2;
    }

    public void bWL(boolean z2) {
        this.eDn = z2;
    }

    public void cL(boolean z2) {
        this.jM = z2;
    }

    public void cl(boolean z2) {
        this.tN = z2;
    }

    public void ea(boolean z2) {
        this.OW = z2;
    }

    public void hp(boolean z2) {
        this.Os = z2;
    }

    public void lEW(int i2) {
        this.OOq = i2;
    }

    public void rp(boolean z2) {
        this.CQo = z2;
    }

    public void tV(String str) {
        this.ea = str;
    }

    public void vCE(String str) {
        this.cl = str;
    }

    public void zPa(boolean z2) {
        this.tf = z2;
    }

    public void Bc(boolean z2) {
        this.fdM = z2;
    }

    public void Cc(double d8) {
        this.oc = d8;
    }

    public void DmF(boolean z2) {
        this.Jz = z2;
    }

    public void EO(String str) {
        this.bWL = str;
    }

    public void MY(double d8) {
        this.EV = d8;
    }

    public void lEW(boolean z2) {
        this.hL = z2;
    }

    public void tV(double d8) {
        this.wPn = d8;
    }

    public void vCE(double d8) {
        this.HSR = d8;
    }

    public void Cc(boolean z2) {
        this.quf = z2;
    }

    public void EO(boolean z2) {
        this.pP = z2;
    }

    public void MY(String str) {
        this.hp = str;
    }

    public void tV(boolean z2) {
        this.mmj = z2;
    }

    public void vCE(boolean z2) {
        this.KC = z2;
    }

    public void Cc(JSONObject jSONObject) {
        this.NST = jSONObject;
    }

    public void EO(JSONObject jSONObject) {
        this.BES = jSONObject;
    }

    public void MY(JSONObject jSONObject) {
        this.ii = jSONObject;
    }

    public void tV(JSONObject jSONObject) {
        this.La = jSONObject;
    }

    public boolean IlO() {
        return this.aa;
    }

    public void IlO(boolean z2) {
        this.aa = z2;
    }

    public void IlO(int i2) {
        this.ao = i2;
    }

    public void IlO(double d8) {
        this.eeU = d8;
    }

    public void IlO(String str) {
        this.XfO = str;
    }

    public void IlO(float f4) {
        this.IlO = f4;
    }

    public void IlO(List<IlO> list) {
        this.zTS = list;
    }

    public void IlO(long j) {
        this.TU = j;
    }

    private void IlO(vCE vce, JSONObject jSONObject) {
        String next;
        if (vce == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            next = itKeys.next();
            next.getClass();
            switch (next) {
                case "isShowBgControl":
                    vce.EO(jSONObject.optBoolean(next, false));
                    break;
                case "clickArea":
                    vce.ea(jSONObject.optString(next));
                    break;
                case "triggerSlideDirection":
                    vce.tl(jSONObject.optString(next));
                    break;
                case "bgImgUrl":
                    vce.Bc(jSONObject.optString(next));
                    break;
                case "lineCount":
                    vce.DmF(jSONObject.optInt(next));
                    break;
                case "openPlayableLandingPage":
                    vce.cL(jSONObject.optBoolean(next));
                    break;
                case "lineLimit":
                    vce.vCE(jSONObject.optBoolean(next));
                    break;
                case "interactBgColor":
                    vce.hp(jSONObject.optString(next));
                    break;
                case "paddingLeft":
                    vce.vCE((float) jSONObject.optDouble(next));
                    break;
                case "adType":
                    vce.MY(jSONObject.optString(next));
                    break;
                case "bottom":
                    vce.vAh(jSONObject.optInt(next));
                    break;
                case "fontFamily":
                    vce.EO(jSONObject.optString(next));
                    break;
                case "height":
                    vce.EO((float) jSONObject.optDouble(next));
                    break;
                case "textAlign":
                    vce.tV(jSONObject.optString(next));
                    break;
                case "alignItems":
                    vce.AXM(jSONObject.optString(next));
                    break;
                case "interactValidate":
                    vce.MY(jSONObject.optBoolean(next));
                    break;
                case "marginTop":
                    vce.NV(jSONObject.optInt(next));
                    break;
                case "useBottom":
                    vce.NV(jSONObject.optBoolean(next));
                    break;
                case "triggerSlideMinDistance":
                    vce.IlO(jSONObject.optLong(next));
                    break;
                case "direction":
                    vce.oeT(jSONObject.optString(next));
                    break;
                case "tagMaxCount":
                    vce.cl(jSONObject.optInt(next));
                    break;
                case "interactHiddenTime":
                    vce.pP(jSONObject.optInt(next));
                    break;
                case "useTop":
                    vce.DmF(jSONObject.optBoolean(next));
                    break;
                case "fontWeight":
                    vce.ea(jSONObject.optInt(next));
                    break;
                case "zIndex":
                    vce.kBB(jSONObject.optInt(next));
                    break;
                case "timingStart":
                    vce.MY(jSONObject.optDouble(next));
                    break;
                case "lineHeight":
                    vce.vCE(jSONObject.optDouble(next));
                    break;
                case "textFlowDuration":
                    vce.es(jSONObject.optInt(next));
                    break;
                case "useRight":
                    vce.lEW(jSONObject.optBoolean(next));
                    break;
                case "marginBottom":
                    vce.EV(jSONObject.optInt(next));
                    break;
                case "bgColor":
                    vce.vCE(jSONObject.optString(next));
                    break;
                case "useLeft":
                    vce.Bc(jSONObject.optBoolean(next));
                    break;
                case "widthMode":
                    vce.EV(jSONObject.optString(next));
                    break;
                case "top":
                    vce.oeT(jSONObject.optInt(next));
                    break;
                case "data":
                    vce.xF(jSONObject.optString(next));
                    break;
                case "left":
                    vce.xF(jSONObject.optInt(next));
                    break;
                case "loop":
                    vce.IlO(jSONObject.optBoolean(next));
                    break;
                case "paddingTop":
                    vce.lEW((float) jSONObject.optDouble(next));
                    break;
                case "align":
                    vce.es(jSONObject.optString(next));
                    break;
                case "color":
                    vce.Cc(jSONObject.optString(next));
                    break;
                case "right":
                    vce.AXM(jSONObject.optInt(next));
                    break;
                case "width":
                    vce.tV((float) jSONObject.optDouble(next));
                    break;
                case "timingEnd":
                    vce.EO(jSONObject.optDouble(next));
                    break;
                case "paddingBottom":
                    vce.Cc((float) jSONObject.optDouble(next));
                    break;
                case "allowTextFlow":
                    vce.EV(jSONObject.optBoolean(next));
                    break;
                case "interactWontHide":
                    vce.bWL(jSONObject.optBoolean(next));
                    break;
                case "fontSize":
                    vce.DmF((float) jSONObject.optDouble(next));
                    break;
                case "justifyVertical":
                    vce.cL(jSONObject.optString(next));
                    break;
                case "interactVisibleTime":
                    vce.oc(jSONObject.optInt(next));
                    break;
                case "paddingRight":
                    vce.Bc((float) jSONObject.optDouble(next));
                    break;
                case "borderColor":
                    vce.lEW(jSONObject.optString(next));
                    break;
                case "borderStyle":
                    vce.DmF(jSONObject.optString(next));
                    break;
                case "position":
                    vce.zPa(jSONObject.optInt(next));
                    break;
                case "isDataFixed":
                    vce.Cc(jSONObject.optBoolean(next));
                    break;
                case "marginRight":
                    vce.hp(jSONObject.optInt(next));
                    break;
                case "justifyHorizontal":
                    vce.cl(jSONObject.optString(next));
                    break;
                case "interactPosition":
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject == null) {
                        break;
                    } else {
                        vce.Bc(jSONObjectOptJSONObject.optInt("translateY", 0));
                        vce.lEW(jSONObjectOptJSONObject.optInt("translateX", 0));
                        vce.tV(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        vce.Cc(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                    break;
                case "lineFeed":
                    vce.tV(jSONObject.optBoolean(next));
                    break;
                case "interactText":
                    vce.rp(jSONObject.optString(next));
                    break;
                case "interactType":
                    vce.bWL(jSONObject.optString(next));
                    break;
                case "borderRadius":
                    vce.IlO((float) jSONObject.optDouble(next));
                    break;
                case "clickTigger":
                    vce.zPa(jSONObject.optString(next));
                    break;
                case "heightMode":
                    vce.NV(jSONObject.optString(next));
                    break;
                case "textFlowType":
                    vce.cL(jSONObject.optInt(next));
                    break;
                case "borderSize":
                    vce.MY((float) jSONObject.optDouble(next));
                    break;
                case "marginLeft":
                    vce.rp(jSONObject.optInt(next));
                    break;
                case "letterSpacing":
                    vce.bWL(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
