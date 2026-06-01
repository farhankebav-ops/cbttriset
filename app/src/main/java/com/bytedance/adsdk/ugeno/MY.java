package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.core.NV;
import com.bytedance.adsdk.ugeno.tV.DmF;
import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.adsdk.ugeno.MY.IlO<com.bytedance.adsdk.ugeno.vCE.MY> implements com.bytedance.adsdk.ugeno.vCE.EO {
    private float Aw;
    private boolean BC;
    private boolean BES;
    private boolean BK;
    private JSONArray CQo;
    private int Ct;
    private float Fv;
    private boolean IK;
    private float IRy;
    private float KS;
    private boolean La;
    private int NI;
    private String NST;
    private String Os;
    private int QfH;
    private boolean TU;
    private boolean XfO;
    private float XvI;
    private float aP;
    private float ao;
    private float ct;
    private int dM;
    private String eDn;
    private int eeU;
    private float qyG;
    private float uF;
    private int xJ;

    public MY(Context context) {
        super(context);
        this.eeU = 0;
        this.BES = true;
        this.La = true;
        this.Aw = 500.0f;
        this.uF = 2000.0f;
        this.eDn = "slide";
        this.NST = "dot";
        this.aP = 8.0f;
        this.ao = 8.0f;
        this.XvI = 50.0f;
        this.IRy = 90.0f;
        this.BC = false;
        this.xJ = Color.parseColor("#666666");
        this.QfH = Color.parseColor("#ffffff");
        this.Os = "row";
        this.KS = 1.0f;
        this.qyG = 0.0f;
        this.Fv = 0.0f;
        this.ct = 0.0f;
        this.NI = 0;
        this.dM = 0;
        this.TU = true;
        this.BK = false;
        this.XfO = true;
        float fIlO = lEW.IlO(this.MY, 8.0f);
        this.aP = fIlO;
        this.ao = fIlO;
    }

    private void Bc(int i2) {
        if (this.vZk == null) {
            return;
        }
        if (this.Ct == 0 && i2 == fdM() - 1) {
            this.vZk.IlO("SwiperView://reloop", 1);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor FIRST_TO_LAST");
        }
        if (this.Ct == fdM() - 1 && i2 == 0) {
            this.vZk.IlO("SwiperView://reloop", 0);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor LAST_TO_FIRST");
        }
    }

    private void Dxv() {
        for (int i2 = 0; i2 < ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.size(); i2++) {
            com.bytedance.adsdk.ugeno.MY.EO<View> eo = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.get(i2);
            if (eo != null) {
                NV nv = new NV(this.MY);
                IlO(nv);
                nv.IlO(this.cJK);
                ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).IlO(nv.IlO(eo.wPn(), this.tV, (JSONObject) null));
            }
        }
    }

    private void Ea() {
        List<com.bytedance.adsdk.ugeno.MY.EO<View>> list = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.get(0);
        if (this.CQo == null) {
            return;
        }
        for (int i2 = 0; i2 < this.CQo.length(); i2++) {
            NV nv = new NV(this.MY);
            IlO(nv);
            nv.IlO(this.cJK);
            try {
                JSONObject jSONObjectOptJSONObject = this.CQo.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.tV.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.tV.put("$item", jSONObjectOptJSONObject);
                    }
                    ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).IlO(nv.IlO(eo.wPn(), this.tV, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private int fdM() {
        if (this.NI == 1) {
            List<com.bytedance.adsdk.ugeno.MY.EO<View>> list = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.CQo;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    private void lEW(int i2) {
        DmF dmF = this.vZk;
        if (dmF == null) {
            return;
        }
        dmF.IlO("SwiperView://slide", Integer.valueOf(this.Ct), Integer.valueOf(i2), Integer.valueOf(!this.IK ? 1 : 0));
    }

    public void EO() {
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).hp(((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).getCurrentItem() + 1);
    }

    public void tV() {
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).hp(((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).getCurrentItem() - 1);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public View IlO() {
        com.bytedance.adsdk.ugeno.vCE.MY my = new com.bytedance.adsdk.ugeno.vCE.MY(this.MY);
        this.Cc = my;
        my.IlO((tV) this);
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).EO((int) this.Aw).Cc(this.BK).IlO(this.NST).IlO(this.aP).MY(this.ao).EO(this.XvI).tV(this.IRy).MY(this.Os).IlO(this.eeU).MY().tV(this.BES).IlO(this.La).MY((int) this.Aw).tV((int) this.uF).MY(this.TU).EO(this.BC).vCE(this.xJ).Cc(this.QfH).lEW((int) this.Fv).DmF((int) this.ct).Bc((int) this.qyG).Cc(this.KS).EO(this.eDn).hp(this.dM);
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).setOnPageChangeListener(this);
        if (this.NI == 1) {
            Dxv();
        } else {
            Ea();
        }
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).EO();
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        if (eo == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.add(eo);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, ViewGroup.LayoutParams layoutParams) {
        if (eo == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.add(eo);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "startIndex":
                this.dM = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0);
                break;
            case "indicatorColor":
                this.xJ = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2, this.xJ);
                break;
            case "indicatorStyle":
                this.NST = str2;
                break;
            case "indicatorWidth":
                this.aP = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 8.0f));
                break;
            case "indicatorHeight":
                this.ao = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 8.0f));
                break;
            case "nextMargin":
                this.ct = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "driveMode":
                this.NI = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0);
                break;
            case "effect":
                this.eDn = str2;
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.eeU = 1;
                    break;
                } else {
                    this.eeU = 0;
                    break;
                }
                break;
            case "disableOnInteraction":
                this.BK = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "indicator":
                this.BC = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "indicatorX":
                this.XvI = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 50.0f);
                break;
            case "indicatorY":
                this.IRy = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 90.0f);
                break;
            case "previousMargin":
                this.Fv = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "loop":
                this.BES = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "delay":
                this.uF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 2000.0f);
                break;
            case "speed":
                this.Aw = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 500.0f);
                break;
            case "indicatorDirection":
                this.Os = str2;
                break;
            case "allowTouchMove":
                this.TU = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "pageCount":
                this.KS = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                break;
            case "pageMargin":
                this.qyG = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.QfH = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2, this.QfH);
                break;
            case "autoplay":
                this.La = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "dataList":
                this.CQo = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str2, (JSONArray) null);
                break;
        }
    }

    public void IlO(int i2) {
        if (((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).getCurrentItem() != i2) {
            ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).hp(i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.EO
    public void IlO(boolean z2, int i2, float f4, int i8) {
        Log.d("BaseSwiper", "onPageScrolled: loop=" + z2 + "; position=" + i2 + "; positionOffset=" + f4 + "; positionOffsetPixels=" + i8);
        IlO(z2, i2, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.EO
    public void IlO(boolean z2, int i2, int i8, boolean z7, boolean z8) {
        if (this.Ct != i2) {
            Bc(i2);
            lEW(i2);
            this.Ct = i2;
        }
        Log.d("BaseSwiper", "onPageSelected: loop=" + z2 + "; position=" + i2 + "; loopPosition=" + i8 + "; isFirst=" + z7 + "; isLast=" + z8);
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.EO
    public void IlO(boolean z2, int i2) {
        if (i2 == 0) {
            if (!z2) {
                this.XfO = true;
            }
            this.IK = false;
        } else if (i2 == 1) {
            this.IK = true;
        }
        Log.d("BaseSwiper", "onPageScrollStateChanged: loop=" + z2 + "; state=" + i2);
    }

    private void IlO(boolean z2, int i2, float f4) {
        if (this.vZk != null && !z2 && i2 == fdM() - 1 && f4 == 0.0f && this.XfO) {
            this.vZk.IlO("SwiperView://finish", new Object[0]);
            Log.d("BaseSwiper", "onPageScrolled: finish monitor");
            this.XfO = false;
        }
    }

    private void IlO(NV nv) {
        if (this.BK) {
            nv.IlO(new com.bytedance.adsdk.ugeno.core.Cc() { // from class: com.bytedance.adsdk.ugeno.MY.1
                @Override // com.bytedance.adsdk.ugeno.core.Cc
                public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, List<vCE.IlO> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && ((com.bytedance.adsdk.ugeno.MY.EO) MY.this).Cc != null) {
                        ((com.bytedance.adsdk.ugeno.vCE.MY) ((com.bytedance.adsdk.ugeno.MY.EO) MY.this).Cc).vCE();
                    }
                }
            });
        }
    }
}
