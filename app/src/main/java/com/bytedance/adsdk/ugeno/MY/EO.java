package com.bytedance.adsdk.ugeno.MY;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.adsdk.ugeno.Bc.IlO;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.MY.IlO;
import com.bytedance.adsdk.ugeno.core.Bc;
import com.bytedance.adsdk.ugeno.core.DmF;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.core.MY.Cc;
import com.bytedance.adsdk.ugeno.core.MY.tV;
import com.bytedance.adsdk.ugeno.core.bWL;
import com.bytedance.adsdk.ugeno.core.hp;
import com.bytedance.adsdk.ugeno.core.lEW;
import com.bytedance.adsdk.ugeno.core.rp;
import com.bytedance.adsdk.ugeno.core.vCE;
import com.bytedance.adsdk.ugeno.core.zPa;
import com.bytedance.adsdk.ugeno.tV;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO<T extends View> implements View.OnTouchListener, hp.IlO, hp.MY, tV {
    protected float AK;
    protected float AXM;
    private boolean Aw;
    private com.bytedance.adsdk.ugeno.core.IlO BC;
    private boolean BES;
    private boolean BK;
    protected float BO;
    protected ImageView.ScaleType BS;
    protected IlO<ViewGroup> Bc;

    @Deprecated
    private tV.IlO CQo;
    protected T Cc;
    private boolean Ct;
    protected int DM;
    protected DmF DmF;
    protected boolean Dxv;
    protected float ED;
    protected JSONObject EO;
    protected String EV;
    protected float Ea;
    private String Fv;
    protected boolean HSR;
    protected int HTA;
    protected ViewGroup.LayoutParams Hg;
    private boolean IK;
    private String IRy;
    private boolean IlO;
    protected boolean Jz;
    protected float KC;

    @Deprecated
    private Cc KS;
    protected float KT;
    private boolean LT;
    private boolean La;
    protected Context MY;
    private boolean NI;
    private boolean NST;
    protected boolean NV;
    protected float OOq;
    protected Map<Integer, EV> OW;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.MY.EO Os;
    protected float PTq;
    private com.bytedance.adsdk.ugeno.tV.IlO.IlO Pbh;
    private boolean QLG;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.MY.MY QfH;
    private boolean TU;
    protected float Tx;
    protected float VH;
    private boolean XfO;
    private GradientDrawable XvI;
    protected boolean YA;
    private boolean aP;
    protected float aa;
    private boolean ao;
    protected float bWL;
    protected hp cJK;
    protected float cL;
    protected float cl;
    private boolean ct;
    private zPa dM;
    protected boolean dY;
    protected float dm;
    private boolean eDn;
    protected float ea;
    private boolean eeU;
    protected float es;
    protected boolean fdM;
    protected boolean gQ;
    protected float gm;
    private JSONObject hHv;
    protected boolean hL;
    protected float hp;
    protected String ii;
    protected boolean jM;
    protected boolean kBB;
    protected vCE.IlO lEW;
    protected boolean lMM;
    protected boolean mmj;
    protected int nm;
    protected boolean nvX;
    protected float oc;
    protected boolean oeT;
    protected boolean pFe;
    protected boolean pP;
    private float qIK;
    protected float quf;
    protected float qvT;
    private lEW qyG;
    protected com.bytedance.adsdk.ugeno.IlO.IlO qz;
    protected String rp;
    protected float ssS;
    protected IlO.C0026IlO tN;
    protected bWL tU;
    protected JSONObject tV;
    protected boolean tf;
    protected float tl;
    protected float ts;
    private boolean uF;
    protected Bc uI;
    protected float uvo;
    protected boolean vAh;
    protected IlO<ViewGroup> vCE;
    protected float vSq;
    protected com.bytedance.adsdk.ugeno.tV.DmF vZk;
    protected float wD;
    protected float wPn;
    protected float xF;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.MY.vCE xJ;
    protected String zLG;
    protected float zPa;
    protected float zTS;

    public EO(Context context) {
        this(context, null);
    }

    private void DmF() {
        EV ev;
        if (this.cJK == null || !MY(18) || (ev = this.OW.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectEO = ev.EO();
        if (jSONObjectEO != null) {
            try {
                jSONObjectEO.put("rotateZ", com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectEO.optString("rotateZ"), this.tV));
            } catch (JSONException unused) {
            }
        }
        this.cJK.IlO(ev, this, this);
    }

    private void Dxv() {
        float f4 = this.Dxv ? this.quf : this.AK;
        float f8 = this.fdM ? this.KC : this.AK;
        float f9 = this.hL ? this.uvo : this.AK;
        float f10 = this.Jz ? this.Ea : this.AK;
        this.XvI.setCornerRadii(new float[]{f4, f4, f8, f8, f10, f10, f9, f9});
    }

    private void Ea() {
        if (TextUtils.equals("dashed", this.ii)) {
            GradientDrawable gradientDrawable = this.XvI;
            float f4 = this.wD;
            gradientDrawable.setStroke((int) f4, this.nm, 3.0f * f4, f4);
        } else {
            if (!TextUtils.equals("dotted", this.ii)) {
                this.XvI.setStroke((int) this.wD, this.nm);
                return;
            }
            GradientDrawable gradientDrawable2 = this.XvI;
            float f8 = this.wD;
            gradientDrawable2.setStroke((int) f8, this.nm, f8 / 2.0f, f8);
        }
    }

    private void NV() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.EV);
        this.Cc.setContentDescription(sb);
    }

    @Deprecated
    private void tV() {
        com.bytedance.adsdk.ugeno.core.MY.tV tVVarTV;
        this.Cc.setVisibility(this.HTA);
        float f4 = this.zTS;
        if (f4 != 0.0f) {
            this.Cc.setRotation(f4);
        }
        this.jM = this.tV.optBoolean("gesture_through_enable", false);
        Log.d("GesThrough_UGenWidget", "mGestureThroughEnabled: " + this.jM);
        vCE.IlO ilO = this.lEW;
        if (ilO != null && TextUtils.isEmpty(ilO.MY())) {
            this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.MY.EO.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EO eo = EO.this;
                    if (eo.uI != null) {
                        boolean unused = eo.Ct;
                    }
                }
            });
        } else if (MY(1) && !this.ct && !this.jM) {
            this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.MY.EO.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("GesThrough_UGenWidget", "UGenWidget onClick handling");
                    EO eo = EO.this;
                    if (eo.cJK == null || !eo.Ct) {
                        return;
                    }
                    EO eo2 = EO.this;
                    hp hpVar = eo2.cJK;
                    EV ev = eo2.OW.get(1);
                    EO eo3 = EO.this;
                    hpVar.IlO(ev, eo3, eo3);
                }
            });
        }
        if (this.cJK != null && MY(4)) {
            if (MY(1)) {
                Log.d("GesThrough_UGenWidget", "onSlide & onTap, view.id: " + dY());
                this.NI = true;
                this.KS = new Cc(this.MY, this.OW.get(4), this.OW.get(1), this.NI);
            } else {
                Log.d("GesThrough_UGenWidget", "onSlide only, view.id: " + dY());
                this.KS = new Cc(this.MY, this.OW.get(4), this.NI);
            }
        }
        if (this.cJK != null && MY(1) && (this.ct || this.jM)) {
            Log.d("GesThrough_UGenWidget", "onTap only, mOnlyTap: " + this.ct + ", view.id: " + dY());
            this.Os = new com.bytedance.adsdk.ugeno.core.MY.EO(this.MY, this.OW.get(1));
        }
        DmF();
        if (this.cJK != null && MY(3) && (tVVarTV = com.bytedance.adsdk.ugeno.Cc.IlO().tV()) != null) {
            this.CQo = tVVarTV.IlO(this.MY, this);
            new Object() { // from class: com.bytedance.adsdk.ugeno.MY.EO.3
            };
        }
        if (this.cJK != null && MY(9)) {
            com.bytedance.adsdk.ugeno.core.MY.vCE vce = new com.bytedance.adsdk.ugeno.core.MY.vCE(this.MY, this.OW.get(9), this);
            this.xJ = vce;
            vce.IlO(this.cJK);
        }
        if (MY(10)) {
            com.bytedance.adsdk.ugeno.core.MY.MY my = new com.bytedance.adsdk.ugeno.core.MY.MY(this.MY, this.OW.get(10), this);
            this.QfH = my;
            my.IlO(this.cJK);
        }
    }

    public float AK() {
        T t3 = this.Cc;
        if (t3 instanceof com.bytedance.adsdk.ugeno.IlO.Cc) {
            return ((com.bytedance.adsdk.ugeno.IlO.Cc) t3).getShine();
        }
        return 0.0f;
    }

    public float AXM() {
        return this.KT;
    }

    public void Bc() {
        com.bytedance.adsdk.ugeno.core.IlO ilO = this.BC;
        if (ilO != null) {
            lEW lew = new lEW(this.Cc, ilO);
            this.qyG = lew;
            lew.IlO();
        }
        com.bytedance.adsdk.ugeno.IlO.IlO ilO2 = this.qz;
        if (ilO2 != null) {
            ilO2.IlO();
        }
        com.bytedance.adsdk.ugeno.tV.DmF dmF = this.vZk;
        if (dmF != null) {
            dmF.tV();
        }
        if (this.QfH != null && MY(10)) {
            this.QfH.IlO();
        }
        if (this.xJ == null || !MY(9)) {
            return;
        }
        this.xJ.IlO();
    }

    public void Cc(String str) {
        this.EV = str;
    }

    public int DM() {
        return this.DM;
    }

    public T EV() {
        return this.Cc;
    }

    public float HSR() {
        T t3 = this.Cc;
        if (t3 instanceof com.bytedance.adsdk.ugeno.IlO.Cc) {
            return ((com.bytedance.adsdk.ugeno.IlO.Cc) t3).getRipple();
        }
        return 0.0f;
    }

    public T IlO() {
        return null;
    }

    public boolean KC() {
        return this.ao;
    }

    public void MY(JSONObject jSONObject) {
        this.tV = jSONObject;
    }

    public ViewGroup.LayoutParams OOq() {
        return this.Hg;
    }

    public int YA() {
        return (int) this.bWL;
    }

    public float bWL() {
        return this.ts;
    }

    public float cL() {
        return this.PTq;
    }

    public float cl() {
        return this.aa;
    }

    public String dY() {
        return this.EV;
    }

    public float ea() {
        return this.BO;
    }

    public float es() {
        return this.VH;
    }

    public boolean gQ() {
        return this.Tx > 0.0f;
    }

    public void hp() {
        this.Cc.setPadding((int) (this.lMM ? this.OOq : this.tl), (int) (this.YA ? this.oc : this.tl), (int) (this.nvX ? this.wPn : this.tl), (int) (this.mmj ? this.vSq : this.tl));
    }

    public JSONObject kBB() {
        return this.EO;
    }

    public void lEW() {
        lEW lew = this.qyG;
        if (lew != null) {
            lew.MY();
        }
        com.bytedance.adsdk.ugeno.IlO.IlO ilO = this.qz;
        if (ilO != null) {
            ilO.MY();
        }
    }

    public String lMM() {
        return this.rp;
    }

    public boolean mmj() {
        return this.pFe;
    }

    public int nvX() {
        return (int) this.hp;
    }

    public boolean oc() {
        return this.NV;
    }

    public float oeT() {
        return this.AK;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        hp hpVar;
        com.bytedance.adsdk.ugeno.core.MY.EO eo;
        Cc cc;
        hp hpVar2;
        com.bytedance.adsdk.ugeno.core.MY.EO eo2;
        Log.d("GesThrough_UGenWidget", "UGenWidget onTouch event: " + motionEvent.toString());
        int action = motionEvent.getAction();
        if (action == 0) {
            BS();
        } else if (action == 1 || action == 3) {
            ssS();
        }
        bWL bwl = this.tU;
        if (bwl != null) {
            bwl.IlO(this, motionEvent);
        }
        if (MY(17) && motionEvent.getAction() == 0) {
            this.cJK.IlO(this.OW.get(17), this, this);
        }
        if (MY(1) && this.ct && (hpVar2 = this.cJK) != null && (eo2 = this.Os) != null) {
            return eo2.IlO(hpVar2, this, motionEvent);
        }
        hp hpVar3 = this.cJK;
        if (hpVar3 != null && (cc = this.KS) != null) {
            return cc.IlO(hpVar3, this, motionEvent, this.jM);
        }
        com.bytedance.adsdk.ugeno.tV.DmF dmF = this.vZk;
        if (dmF != null) {
            return dmF.IlO(motionEvent);
        }
        if (!MY(1) || !(z2 = this.jM) || this.ct || (hpVar = this.cJK) == null || !this.Ct || (eo = this.Os) == null) {
            return false;
        }
        return eo.IlO(hpVar, this, motionEvent, z2);
    }

    public void pP() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapIlO;
        if (TextUtils.isEmpty(this.zLG)) {
            if (this.tf) {
                IlO(this.tN);
                return;
            } else {
                this.XvI.setColor(this.DM);
                tV(this.DM);
                return;
            }
        }
        if (!this.zLG.startsWith("local://")) {
            tl();
            return;
        }
        String strReplace = this.zLG.replace("local://", "");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = this.gQ ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.MY.getResources().openRawResource(com.bytedance.adsdk.ugeno.Bc.tV.IlO(this.MY, strReplace)), null, options);
            if (this.gQ && (bitmapIlO = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, bitmapDecodeStream, (int) this.ssS)) != null) {
                bitmapDrawable = new BitmapDrawable(this.MY.getResources(), bitmapIlO);
                IlO(bitmapDrawable);
            } else {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.MY.getResources(), bitmapDecodeStream);
                bitmapDrawable = bitmapDrawable2;
                IlO(bitmapDrawable);
            }
        } catch (Throwable unused) {
        }
    }

    public float quf() {
        T t3 = this.Cc;
        if (t3 instanceof com.bytedance.adsdk.ugeno.IlO.Cc) {
            return ((com.bytedance.adsdk.ugeno.IlO.Cc) t3).getStretch();
        }
        return 0.0f;
    }

    public JSONObject rp() {
        return this.tV;
    }

    public void tl() {
        com.bytedance.adsdk.ugeno.Cc.IlO().MY().IlO(this.DmF, this.zLG, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.adsdk.ugeno.MY.EO.4
            @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
            public void IlO(final Bitmap bitmap) {
                if (bitmap != null) {
                    EO eo = EO.this;
                    if (!eo.gQ) {
                        com.bytedance.adsdk.ugeno.Bc.lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.MY.EO.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                EO.this.IlO(new BitmapDrawable(bitmap));
                            }
                        });
                        return;
                    }
                    final Bitmap bitmapIlO = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(eo.MY, bitmap, (int) eo.ssS);
                    if (bitmapIlO != null) {
                        com.bytedance.adsdk.ugeno.Bc.lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.MY.EO.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EO.this.IlO(new BitmapDrawable(bitmapIlO));
                            }
                        });
                    }
                }
            }
        });
    }

    public float uvo() {
        T t3 = this.Cc;
        if (t3 instanceof com.bytedance.adsdk.ugeno.IlO.Cc) {
            return ((com.bytedance.adsdk.ugeno.IlO.Cc) t3).getRubIn();
        }
        return 0.0f;
    }

    public hp vAh() {
        return this.cJK;
    }

    public void vCE(String str) {
        this.rp = str;
    }

    public IlO vSq() {
        return this.vCE;
    }

    public vCE.IlO wPn() {
        return this.lEW;
    }

    public float xF() {
        return this.zTS;
    }

    public com.bytedance.adsdk.ugeno.tV.IlO.IlO zLG() {
        return this.Pbh;
    }

    public float zPa() {
        return this.gm;
    }

    public EO(Context context, IlO<ViewGroup> ilO) {
        this.hp = -2.0f;
        this.bWL = -2.0f;
        this.ii = "solid";
        this.HTA = 0;
        this.pFe = true;
        this.qvT = 0.0f;
        this.ts = 0.0f;
        this.BO = 0.0f;
        this.dm = 1.0f;
        this.gm = 1.0f;
        this.aa = 1.0f;
        this.ED = 0.0f;
        this.PTq = 0.0f;
        this.VH = 0.0f;
        this.zTS = 0.0f;
        this.KT = 1.0f;
        this.aP = true;
        this.Ct = true;
        this.LT = false;
        this.QLG = false;
        this.jM = false;
        this.qIK = 12.0f;
        this.MY = context;
        this.vCE = ilO;
        this.OW = new HashMap();
        this.XvI = new GradientDrawable();
        this.Cc = (T) IlO();
    }

    private void EO() {
        if (this.IlO) {
            this.Cc.setTranslationX(this.ts);
        }
        if (this.eeU) {
            this.Cc.setTranslationY(this.BO);
        }
        if (this.BES) {
            this.Cc.setScaleX(this.gm);
        }
        if (this.La) {
            this.Cc.setScaleY(this.aa);
        }
        if (this.Aw) {
            this.Cc.setRotation(this.ED);
        }
        if (this.uF) {
            this.Cc.setRotationX(this.PTq);
        }
        if (this.eDn) {
            this.Cc.setRotationY(-this.VH);
        }
        if (this.NST) {
            this.Cc.setAlpha(this.KT);
        }
        float f4 = this.zTS;
        if (f4 != 0.0f) {
            this.Cc.setRotation(f4);
        }
        if (this.Aw || this.uF || this.eDn) {
            this.Cc.setCameraDistance(10000.0f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void Cc() {
        if (this.dM == null || this.TU) {
            return;
        }
        this.TU = true;
    }

    public void IlO(JSONObject jSONObject) {
        this.tV = jSONObject;
        JSONObject jSONObject2 = this.EO;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        IlO<ViewGroup> ilO = this.vCE;
        IlO.C0032IlO c0032IlONV = ilO != null ? ilO.NV() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(this.EO.optString(next), jSONObject);
            IlO(next, strIlO);
            if (c0032IlONV != null) {
                c0032IlONV.IlO(this.MY, next, strIlO);
            }
        }
        if (c0032IlONV != null) {
            IlO(c0032IlONV.IlO());
        }
        if (this.hHv == null || this.tV == null) {
            return;
        }
        try {
            if (!oc()) {
                this.tV.put("i18n", this.hHv);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("i18n", this.hHv);
            this.tV.put("xNode", jSONObject3);
        } catch (JSONException unused) {
        }
    }

    public void MY() {
        pP();
        hp();
        EO(this.HTA);
        EO();
        tV();
        com.bytedance.adsdk.ugeno.tV.DmF dmF = this.vZk;
        if (dmF != null) {
            dmF.IlO();
            this.vZk.MY();
            this.vZk.EO();
        }
        this.Cc.setOnTouchListener(this);
        NV();
        ViewGroup viewGroup = (ViewGroup) this.Cc.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.aP);
        }
        com.bytedance.adsdk.ugeno.IlO.IlO ilO = this.qz;
        if (ilO != null) {
            ilO.EO();
        }
        if (this.cJK == null || !MY(22)) {
            return;
        }
        this.cJK.IlO(this.OW.get(22), this, this);
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void vCE() {
        if (this.dM == null || this.XfO) {
            return;
        }
        this.XfO = true;
    }

    private boolean lEW(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void Cc(int i2) {
        if (oc()) {
            T t3 = this.Cc;
            if (t3 instanceof MY) {
                ((MY) t3).IlO(i2);
                return;
            }
            ViewParent viewParent = (ViewGroup) t3.getParent();
            if (viewParent instanceof MY) {
                ((MY) viewParent).IlO(this.Cc, i2);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.Cc.getLayoutParams();
        layoutParams.width = i2;
        this.Cc.setLayoutParams(layoutParams);
    }

    public void vCE(int i2) {
        if (oc()) {
            T t3 = this.Cc;
            if (t3 instanceof MY) {
                ((MY) t3).MY(i2);
                return;
            }
            ViewParent viewParent = (ViewGroup) t3.getParent();
            if (viewParent instanceof MY) {
                ((MY) viewParent).MY(this.Cc, i2);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.Cc.getLayoutParams();
        layoutParams.height = i2;
        this.Cc.setLayoutParams(layoutParams);
    }

    private ImageView.ScaleType Bc(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.BS = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.BS = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.BS = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.BS = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.BS;
    }

    public void BS() {
    }

    public void IlO(zPa zpa) {
        this.dM = zpa;
    }

    public void ssS() {
    }

    public void IlO(bWL bwl) {
        this.tU = bwl;
    }

    public boolean MY(int i2) {
        Map<Integer, EV> map = this.OW;
        return map != null && map.containsKey(Integer.valueOf(i2));
    }

    public void IlO(hp hpVar) {
        this.cJK = hpVar;
    }

    public EO<T> MY(String str) {
        if (TextUtils.isEmpty(this.rp) || !TextUtils.equals(this.rp, str)) {
            return null;
        }
        return this;
    }

    public void EO(int i2) {
        ViewParent viewParent = (ViewGroup) this.Cc.getParent();
        if (viewParent instanceof MY) {
            ((MY) viewParent).EO(this.Cc, i2);
        } else {
            this.Cc.setVisibility(i2);
        }
    }

    public void IlO(IlO.C0026IlO c0026IlO) {
        if (c0026IlO == null) {
            return;
        }
        this.XvI.setShape(0);
        this.XvI.setOrientation(c0026IlO.IlO);
        if (Build.VERSION.SDK_INT >= 29) {
            this.XvI.setColors(c0026IlO.MY, c0026IlO.EO);
        } else {
            this.XvI.setColors(c0026IlO.MY);
        }
        Dxv();
        Ea();
        this.Cc.setBackground(this.XvI);
    }

    public void MY(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.OW == null) {
            return;
        }
        try {
            int iIlO = rp.IlO(str).IlO();
            EV ev = new EV();
            ev.IlO(iIlO);
            ev.IlO(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (iIlO == 3) {
                try {
                    this.qIK = Float.parseFloat(com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObject.optString("shakeAmplitude"), this.tV));
                } catch (NumberFormatException unused) {
                    this.qIK = 12.0f;
                }
            }
            if (!(this.cJK instanceof com.bytedance.adsdk.ugeno.core.IlO.MY)) {
                IlO(iIlO, jSONObject, ev);
                return;
            }
            throw null;
        } catch (JSONException unused2) {
        }
    }

    public void EO(JSONObject jSONObject) {
        this.EO = jSONObject;
    }

    public EO<T> EO(String str) {
        return IlO(str);
    }

    public void IlO(Drawable drawable) {
        this.Cc.setBackground(drawable);
    }

    public void IlO(ViewGroup.LayoutParams layoutParams) {
        T t3 = this.Cc;
        if (t3 != null) {
            t3.setLayoutParams(layoutParams);
        }
        this.Hg = layoutParams;
    }

    public void IlO(boolean z2, boolean z7) {
        if (this.Cc != null) {
            IlO(this.Hg);
            if (z2) {
                Cc((int) this.hp);
            }
            if (z7) {
                vCE((int) this.bWL);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void MY(Canvas canvas) {
        com.bytedance.adsdk.ugeno.IlO.IlO ilO;
        if (!(this instanceof IlO) || (ilO = this.qz) == null) {
            return;
        }
        ilO.MY(canvas);
    }

    public void tV(int i2) {
        this.XvI.setShape(0);
        this.XvI.setColor(i2);
        Dxv();
        Ea();
        this.Cc.setBackground(this.XvI);
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void MY(int i2, int i8, int i9, int i10) {
        lEW lew = this.qyG;
        if (lew != null) {
            lew.IlO(i2, i8);
        }
        com.bytedance.adsdk.ugeno.IlO.IlO ilO = this.qz;
        if (ilO != null) {
            ilO.IlO(i2, i8);
        }
    }

    public void IlO(vCE.IlO ilO) {
        this.lEW = ilO;
    }

    public EO<T> IlO(String str) {
        if (TextUtils.isEmpty(this.EV) || !TextUtils.equals(this.EV, str)) {
            return null;
        }
        return this;
    }

    public EO<T> tV(String str) {
        return MY(str);
    }

    public void IlO(boolean z2) {
        this.NV = z2;
    }

    public void IlO(IlO ilO) {
        this.vCE = ilO;
    }

    public EO MY(EO eo) {
        return (eo.vSq() == null && (eo instanceof IlO)) ? eo : MY(eo.vSq());
    }

    public void IlO(DmF dmF) {
        this.DmF = dmF;
    }

    public void IlO(Bc bc) {
        this.uI = bc;
    }

    public void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "clickable":
                this.Ct = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "onRenderSuccess":
            case "onDelay":
            case "onShake":
            case "onSlide":
            case "onTimer":
            case "onTwist":
            case "onDown":
            case "onTap":
            case "onLoadMore":
            case "onExposure":
            case "onAnimation":
            case "onPullToRefresh":
            case "onScroll":
            case "onLongTap":
                MY(str, str2);
                break;
            case "translateX":
                this.IlO = true;
                this.ts = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "translateY":
                this.eeU = true;
                this.BO = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "paddingLeft":
                this.OOq = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.lMM = true;
                break;
            case "minWidth":
                this.xF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "background":
            case "backgroundColor":
                if (com.bytedance.adsdk.ugeno.Bc.IlO.EO(str2)) {
                    this.tf = true;
                    this.tN = com.bytedance.adsdk.ugeno.Bc.IlO.MY(str2);
                    break;
                } else {
                    this.DM = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2, 0);
                    this.tf = false;
                    break;
                }
                break;
            case "events":
                this.vZk = com.bytedance.adsdk.ugeno.tV.DmF.IlO(this, str2);
                break;
            case "opacity":
                this.NST = true;
                this.KT = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                break;
            case "borderTopLeftRadius":
                this.quf = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.Dxv = true;
                break;
            case "height":
                if (TextUtils.equals(str2, "match_parent")) {
                    this.bWL = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.bWL = -2.0f;
                } else {
                    this.bWL = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                }
                this.QLG = true;
                break;
            case "margin":
                this.ea = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                break;
            case "marginTop":
                this.cL = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.kBB = true;
                break;
            case "backgroundDrawable":
            case "backgroundImage":
                this.zLG = str2;
                break;
            case "rotate":
                this.Aw = true;
                this.ED = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "scaleX":
                this.BES = true;
                this.gm = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "scaleY":
                this.La = true;
                this.aa = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "padding":
                this.tl = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.dY = true;
                break;
            case "triggerFunc":
                this.Fv = str2;
                break;
            case "marginBottom":
                this.es = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.pP = true;
                break;
            case "minHeight":
                this.AXM = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "id":
                this.EV = str2;
                break;
            case "i18n":
                this.hHv = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str2, (JSONObject) null);
                break;
            case "name":
                this.rp = str2;
                break;
            case "backgroundImageBlur":
                float fIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                this.ssS = fIlO;
                if (fIlO > 0.0f) {
                    this.gQ = true;
                    break;
                }
                break;
            case "paddingTop":
                this.oc = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.YA = true;
                break;
            case "click":
                this.IRy = str2;
                break;
            case "ratio":
                this.Tx = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "scale":
                this.BES = true;
                this.La = true;
                float[] fArrEO = com.bytedance.adsdk.ugeno.IlO.EO.EO(str2);
                this.gm = fArrEO[0];
                this.aa = fArrEO[1];
                break;
            case "width":
                if (TextUtils.equals(str2, "match_parent")) {
                    this.hp = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.hp = -2.0f;
                } else {
                    this.hp = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                }
                this.LT = true;
                break;
            case "paddingBottom":
                this.vSq = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.mmj = true;
                break;
            case "borderTopRightRadius":
                this.KC = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.fdM = true;
                break;
            case "overflow":
                this.aP = lEW(str2);
                break;
            case "borderBottomLeftRadius":
                this.uvo = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.hL = true;
                break;
            case "borderBottomRightRadius":
                this.Ea = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.Jz = true;
                break;
            case "paddingRight":
                this.wPn = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.nvX = true;
                break;
            case "borderColor":
                this.nm = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "borderStyle":
                this.ii = str2;
                break;
            case "borderWidth":
                this.wD = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                break;
            case "marginRight":
                this.cl = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.vAh = true;
                break;
            case "translate":
                this.IlO = true;
                this.eeU = true;
                float[] fArrEO2 = com.bytedance.adsdk.ugeno.IlO.EO.EO(str2);
                this.ts = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, fArrEO2[0]);
                this.BO = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, fArrEO2[1]);
                break;
            case "animation":
                try {
                    this.qz = new com.bytedance.adsdk.ugeno.IlO.IlO(this.MY, this, com.bytedance.adsdk.ugeno.IlO.EO.IlO(new JSONObject(str2)));
                    break;
                } catch (JSONException unused) {
                    return;
                }
                break;
            case "animatorSet":
                this.BC = com.bytedance.adsdk.ugeno.core.IlO.IlO(str2, this);
                break;
            case "backgroundScale":
                this.HSR = true;
                this.BS = Bc(str2);
                break;
            case "borderRadius":
                this.AK = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                break;
            case "rotateX":
                this.uF = true;
                this.PTq = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "rotateY":
                this.eDn = true;
                this.VH = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "rotateZ":
                this.zTS = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "disable":
                this.ao = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "visibility":
                if (TextUtils.equals("visible", str2)) {
                    this.HTA = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.HTA = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.HTA = 8;
                }
                this.Cc.setVisibility(this.HTA);
                break;
            case "marginLeft":
                this.zPa = com.bytedance.adsdk.ugeno.Bc.lEW.IlO(this.MY, str2);
                this.oeT = true;
                break;
            case "availability":
                this.pFe = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    @Deprecated
    public void IlO(int i2, JSONObject jSONObject, EV ev) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            EV ev2 = new EV();
            ev2.IlO(jSONObjectOptJSONObject);
            ev2.IlO(this);
            ev.IlO(ev2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(C2300e4.f.e);
        if (jSONObjectOptJSONObject2 != null) {
            EV ev3 = new EV();
            ev3.IlO(jSONObjectOptJSONObject2);
            ev3.IlO(this);
            ev.MY(ev3);
        }
        ev.IlO(jSONObject);
        this.OW.put(Integer.valueOf(i2), ev);
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public int[] IlO(int i2, int i8) {
        if (this.Tx > 0.0f) {
            if (this.LT) {
                int size = View.MeasureSpec.getSize(i2);
                float f4 = this.Tx;
                if (f4 != 0.0f) {
                    i8 = View.MeasureSpec.makeMeasureSpec((int) (size / f4), BasicMeasure.EXACTLY);
                }
            } else if (this.QLG) {
                int size2 = View.MeasureSpec.getSize(i8);
                float f8 = this.Tx;
                if (f8 != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size2 * f8), BasicMeasure.EXACTLY);
                }
            }
        }
        if (this.dM != null && !this.BK) {
            this.BK = true;
        }
        return new int[]{i2, i8};
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void IlO(int i2, int i8, int i9, int i10) {
        if (this.dM == null || this.IK) {
            return;
        }
        this.IK = true;
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void IlO(Canvas canvas, IAnimation iAnimation) {
        lEW lew = this.qyG;
        if (lew != null) {
            lew.IlO(canvas, iAnimation);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.tV
    public void IlO(Canvas canvas) {
        com.bytedance.adsdk.ugeno.IlO.IlO ilO;
        if ((this instanceof IlO) || (ilO = this.qz) == null) {
            return;
        }
        ilO.IlO(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.core.hp.MY
    public void IlO(EV ev) {
        IlO<ViewGroup> ilO;
        EO<T> EO;
        if (ev == null || ev.EO() == null || !TextUtils.equals(ev.EO().optString("type"), "onDismiss")) {
            return;
        }
        String strOptString = ev.EO().optString("nodeId");
        EO(8);
        this.Bc = (IlO) MY(this);
        if (TextUtils.isEmpty(strOptString) || (ilO = this.Bc) == null || (EO = ilO.EO(strOptString)) == null) {
            return;
        }
        EO.EO(8);
    }

    public void IlO(com.bytedance.adsdk.ugeno.tV.IlO.IlO ilO) {
        this.Pbh = ilO;
    }

    public void IlO(com.bytedance.adsdk.ugeno.core.Cc cc) {
        com.bytedance.adsdk.ugeno.tV.DmF dmF = this.vZk;
        if (dmF != null) {
            dmF.IlO(cc);
        }
    }
}
