package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.adexpress.MY.hp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private double Bc;
    private double Cc;
    private hp DmF;
    private String lEW;
    private int vCE;
    public Map<String, EO> IlO = new HashMap();
    public Map<String, EO> MY = new HashMap();
    public Map<String, EO> EO = new HashMap();
    private double tV = Math.random();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO {
        float IlO;
        float MY;

        public EO() {
        }

        public String toString() {
            return "UnitSize{width=" + this.IlO + ", height=" + this.MY + '}';
        }

        public EO(float f4, float f8) {
            this.IlO = f4;
            this.MY = f8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements Cloneable {
        float EO;
        float IlO;
        boolean MY;

        public Object clone() {
            try {
                return (IlO) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.Cc.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0050MY {
        float Cc;
        int EO;
        float IlO;
        int MY;
        double tV;

        public static JSONObject IlO(C0050MY c0050my) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0050my.IlO);
                jSONObject.put("letterSpacing", c0050my.MY);
                jSONObject.put("lineHeight", c0050my.tV);
                jSONObject.put("maxWidth", c0050my.Cc);
                jSONObject.put("fontWeight", c0050my.EO);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public MY(double d8, int i2, double d9, String str, hp hpVar) {
        this.Cc = d8;
        this.vCE = i2;
        this.Bc = d9;
        this.lEW = str;
        this.DmF = hpVar;
    }

    private EO Cc(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        String str = lew.EO() + "_" + f4 + "_" + f8;
        if (this.EO.containsKey(str)) {
            return this.EO.get(str);
        }
        EO eoVCE = vCE(lew, f4, f8);
        this.EO.put(str, eoVCE);
        return eoVCE;
    }

    private EO vCE(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        new EO();
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = lew.NV().Cc();
        lew.NV().EO();
        vceCc.hL();
        float fCL = vceCc.cL();
        int iFdM = vceCc.fdM();
        double dDxv = vceCc.Dxv();
        int iJz = vceCc.Jz();
        boolean zHSR = vceCc.HSR();
        boolean zWD = vceCc.wD();
        int iAK = vceCc.AK();
        C0050MY c0050my = new C0050MY();
        c0050my.IlO = fCL;
        c0050my.MY = iFdM;
        c0050my.EO = iJz;
        c0050my.tV = dDxv;
        c0050my.Cc = f4;
        return IlO(lew.NV().EO(), c0050my, zHSR, zWD, iAK, lew);
    }

    public EO EO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        if (lew == null) {
            return null;
        }
        EO eoIlO = IlO(lew);
        if (eoIlO != null && (eoIlO.IlO != 0.0f || eoIlO.MY != 0.0f)) {
            return eoIlO;
        }
        EO eoTV = tV(lew, f4, f8);
        IlO(lew, eoTV);
        return eoTV;
    }

    public EO IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        float f9;
        if (TextUtils.isEmpty(lew.NV().EO()) && lew.NV().Cc().qz() == null) {
            return new EO(0.0f, 0.0f);
        }
        if (a.B(lew, "creative-playable-bait")) {
            return new EO(0.0f, 0.0f);
        }
        float fLEW = lew.lEW();
        float fDmF = lew.DmF();
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = lew.NV().Cc();
        String strWPn = vceCc.wPn();
        String strOOq = vceCc.OOq();
        float fHp = lew.hp();
        float fBWL = lew.bWL();
        float fEa = lew.ea();
        float fZPa = lew.zPa();
        if (TextUtils.equals(strWPn, "fixed")) {
            f4 = Math.min(fLEW, f4);
            if (TextUtils.equals(strOOq, "auto")) {
                f9 = MY(lew, f4 - fEa, f8 - fZPa).MY;
                fDmF = f9 + fZPa;
            }
        } else if (TextUtils.equals(strWPn, "auto")) {
            EO eoMY = MY(lew, f4 - fEa, f8 - fZPa);
            f4 = eoMY.IlO + fEa;
            if (TextUtils.equals(strOOq, "auto")) {
                f9 = eoMY.MY;
                fDmF = f9 + fZPa;
            }
        } else if (!TextUtils.equals(strWPn, "flex")) {
            f4 = fLEW;
        } else if (TextUtils.equals(strOOq, "auto")) {
            f9 = MY(lew, f4 - fEa, f8 - fZPa).MY;
            fDmF = f9 + fZPa;
        }
        if (TextUtils.equals(strOOq, "scale")) {
            float fRound = Math.round((f4 - fHp) / fDmF) + fBWL;
            if (fRound > f8) {
                f4 = Math.round((f8 - fBWL) * fDmF) + fHp;
            } else {
                f8 = fRound;
            }
        } else if (TextUtils.equals(strOOq, "fixed")) {
            f8 = Math.min(fDmF + fBWL, f8);
        } else if (!TextUtils.equals(strOOq, "flex")) {
            f8 = fDmF;
        }
        EO eo = new EO();
        eo.IlO = f4;
        eo.MY = f8;
        return eo;
    }

    public EO MY(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        EO eo = new EO();
        if (lew.NV().Cc() == null) {
            return eo;
        }
        EO eoCc = Cc(lew, f4, f8);
        float f9 = eoCc.IlO;
        float f10 = eoCc.MY;
        eo.IlO = Math.min(f9, f4);
        eo.MY = Math.min(f10, f8);
        return eo;
    }

    public EO tV(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        float fMin;
        float f9;
        float f10;
        EO eo = new EO();
        float f11 = 0.0f;
        if (f8 <= 0.0f || f4 <= 0.0f) {
            eo.IlO = 0.0f;
            eo.MY = 0.0f;
            return eo;
        }
        if (lew.cL()) {
            return IlO(lew, f4, f8);
        }
        float fLEW = lew.lEW();
        float fDmF = lew.DmF();
        float fEa = lew.ea();
        float fZPa = lew.zPa();
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = lew.NV().Cc();
        String strWPn = vceCc.wPn();
        String strOOq = vceCc.OOq();
        float fMin2 = ((TextUtils.equals(strWPn, "flex") || TextUtils.equals(strWPn, "auto")) ? f4 : Math.min(fLEW, f4)) - fEa;
        if (TextUtils.equals(strOOq, "scale")) {
            fMin = Math.round(fMin2 / fDmF) + fZPa;
            if (fMin > f8) {
                fMin2 = Math.round((f8 - fZPa) * fDmF);
            }
        } else {
            fMin = (TextUtils.equals(strOOq, "auto") || TextUtils.equals(strOOq, "flex")) ? f8 : Math.min(fDmF, f8);
        }
        float f12 = fMin - fZPa;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> listCl = lew.cl();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        for (List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list : listCl) {
            float f13 = f11;
            float f14 = fEa;
            EO eoMY = MY(list, fMin2, f12);
            if (MY(list)) {
                f10 = f13 + 1.0f;
            } else {
                fMax = Math.max(fMax, eoMY.IlO);
                f10 = f13;
            }
            float f15 = f10;
            float f16 = fMin2;
            fMax2 = lew.NV().MY().equals("carousel") ? Math.max(lew.DmF(), eoMY.MY) : fMax2 + eoMY.MY;
            fEa = f14;
            f11 = f15;
            fMin2 = f16;
        }
        float f17 = f11;
        float f18 = fMin2;
        float f19 = fEa;
        if (!TextUtils.equals(strWPn, "auto")) {
            f9 = f18;
        } else if (f17 == listCl.size()) {
            f9 = f4;
        } else {
            for (List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list2 : listCl) {
                EO(list2);
                MY(list2, fMax, f12);
            }
            f9 = fMax;
        }
        if (TextUtils.equals(strOOq, "auto")) {
            if (fMax2 <= f8) {
                f12 = fMax2;
            } else {
                IlO(listCl, f9, f12);
            }
        } else if ((TextUtils.equals(strOOq, "fixed") || TextUtils.equals(strOOq, "flex")) && f12 < fMax2) {
            IlO(listCl, f9, f12);
        }
        eo.IlO = Math.min(f9 + f19, f4);
        eo.MY = Math.min(f12 + fZPa, f8);
        return eo;
    }

    private EO EO(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list, float f4, float f8) {
        float fMax;
        tV(list);
        EO eo = new EO();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew : list) {
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = lew.NV().Cc();
            if (vceCc.nm() == 1 || vceCc.nm() == 2) {
                arrayList.add(lew);
            }
            if (vceCc.nm() != 1 && vceCc.nm() != 2) {
                arrayList2.add(lew);
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            EO((com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) obj, f4, f8);
        }
        if (arrayList2.size() <= 0) {
            return eo;
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            arrayList3.add(Float.valueOf(EO((com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) obj2, f4, f8).IlO));
        }
        ArrayList arrayList4 = new ArrayList();
        int i9 = 0;
        while (true) {
            if (i9 >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2 = (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) arrayList2.get(i9);
            String strWPn = lew2.NV().Cc().wPn();
            float fLEW = lew2.lEW();
            boolean zEquals = TextUtils.equals(strWPn, "flex");
            if (TextUtils.equals(strWPn, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> listCl = lew2.cl();
                if (listCl == null || listCl.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> it = listCl.iterator();
                    while (it.hasNext()) {
                        if (MY(it.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            IlO ilO = new IlO();
            if (!zEquals) {
                fLEW = ((Float) arrayList3.get(i9)).floatValue();
            }
            ilO.IlO = fLEW;
            ilO.MY = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i9)).floatValue();
            }
            ilO.EO = fMax;
            arrayList4.add(ilO);
            i9++;
        }
        IlO(arrayList4, f4, arrayList2);
        List<IlO> listIlO = NV.IlO(f4, arrayList4);
        float f9 = 0.0f;
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            f9 += listIlO.get(i10).IlO;
            if (((Float) arrayList3.get(i10)).floatValue() != listIlO.get(i10).IlO) {
                tV((com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) arrayList2.get(i10));
            }
        }
        int size3 = arrayList2.size();
        int i11 = 0;
        boolean z2 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= size3) {
                break;
            }
            Object obj3 = arrayList2.get(i12);
            i12++;
            i11++;
            if (!MY((com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) obj3)) {
                z2 = false;
                break;
            }
            if (i11 == arrayList2.size()) {
                z2 = true;
            }
        }
        fMax = z2 ? f8 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew3 = (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) arrayList2.get(i13);
            EO EO2 = EO(lew3, listIlO.get(i13).IlO, f8);
            if (!MY(lew3)) {
                fMax = Math.max(fMax, EO2.MY);
            }
            arrayList5.add(EO2);
        }
        ArrayList arrayList6 = new ArrayList();
        int size4 = arrayList5.size();
        int i14 = 0;
        while (i14 < size4) {
            Object obj4 = arrayList5.get(i14);
            i14++;
            arrayList6.add(Float.valueOf(((EO) obj4).MY));
        }
        if (!z2) {
            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew4 = (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) arrayList2.get(i15);
                if (MY(lew4) && ((Float) arrayList6.get(i15)).floatValue() != fMax) {
                    tV(lew4);
                    EO(lew4, listIlO.get(i15).IlO, fMax);
                }
            }
        }
        eo.IlO = f9;
        eo.MY = fMax;
        return eo;
    }

    private boolean MY(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> listCl;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().NV().Cc().wPn(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z2 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew : list) {
                if (TextUtils.equals(lew.NV().Cc().wPn(), "auto") && (listCl = lew.cl()) != null) {
                    int i2 = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list2 : listCl) {
                        i2++;
                        if (!MY(list2)) {
                            break;
                        }
                        if (i2 == list2.size()) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private String Cc(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        return lew.EO();
    }

    private EO MY(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list, float f4, float f8) {
        EO eoIlO = IlO(list);
        if (eoIlO != null && (eoIlO.IlO != 0.0f || eoIlO.MY != 0.0f)) {
            return eoIlO;
        }
        EO EO2 = EO(list, f4, f8);
        IlO(list, EO2);
        return EO2;
    }

    private boolean MY(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        if (lew == null) {
            return false;
        }
        if (TextUtils.equals(lew.NV().Cc().OOq(), "flex")) {
            return true;
        }
        return EO(lew);
    }

    private EO IlO(String str, C0050MY c0050my, boolean z2, boolean z7, int i2, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        return EV.IlO(str, lew.NV().MY(), C0050MY.IlO(c0050my).toString(), z2, z7, i2, lew, this.Cc, this.vCE, this.Bc, this.lEW, this.DmF);
    }

    private void tV(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        this.IlO.remove(Cc(lew));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> listCl = lew.cl();
        if (listCl == null || listCl.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> it = listCl.iterator();
        while (it.hasNext()) {
            EO(it.next());
        }
    }

    private void IlO(List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> list, float f4, float f8) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (IlO(it.next(), false)) {
                z2 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list2 : list) {
            IlO ilO = new IlO();
            boolean zIlO = IlO(list2, !z2);
            ilO.IlO = zIlO ? 1.0f : MY(list2, f4, f8).MY;
            ilO.MY = !zIlO;
            arrayList.add(ilO);
        }
        List<IlO> listIlO = NV.IlO(f8, arrayList);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((IlO) arrayList.get(i2)).IlO != listIlO.get(i2).IlO) {
                List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list3 = list.get(i2);
                EO(list3);
                MY(list3, f4, listIlO.get(i2).IlO);
            }
        }
    }

    private String tV(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String strEO = list.get(i2).EO();
            if (i2 < list.size() - 1) {
                sb.append(strEO);
                sb.append("-");
            } else {
                sb.append(strEO);
            }
        }
        return sb.toString();
    }

    private boolean IlO(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list, boolean z2) {
        for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew : list) {
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = lew.NV().Cc();
            String strOOq = vceCc.OOq();
            if (TextUtils.equals(strOOq, "flex") || (z2 && ((TextUtils.equals(vceCc.wPn(), "flex") && TextUtils.equals(vceCc.OOq(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.tV.Cc.IlO.get(lew.NV().MY()).intValue() == 7) || TextUtils.equals(strOOq, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = list.iterator();
        while (it.hasNext()) {
            if (EO(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean EO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> listCl;
        if (!lew.cL() && TextUtils.equals(lew.NV().Cc().OOq(), "auto") && (listCl = lew.cl()) != null && listCl.size() > 0) {
            if (listCl.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = listCl.get(0).iterator();
                while (it.hasNext()) {
                    if (!MY(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>> it2 = listCl.iterator();
            while (it2.hasNext()) {
                if (IlO(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void IlO(List<IlO> list, float f4, List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list2) {
        float f8 = 0.0f;
        for (IlO ilO : list) {
            if (ilO.MY) {
                f8 += ilO.IlO;
            }
        }
        if (f8 > f4) {
            int i2 = 0;
            for (int i8 = 0; i8 < list2.size(); i8++) {
                if (list.get(i8).MY && list2.get(i8).oeT()) {
                    i2++;
                }
            }
            if (i2 > 0) {
                float fCeil = (float) (Math.ceil(((f8 - f4) / i2) * 1000.0f) / 1000.0d);
                for (int i9 = 0; i9 < list2.size(); i9++) {
                    IlO ilO2 = list.get(i9);
                    if (ilO2.MY && list2.get(i9).oeT()) {
                        ilO2.IlO -= fCeil;
                    }
                }
            }
        }
    }

    private void EO(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.MY.remove(tV(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = list.iterator();
        while (it.hasNext()) {
            tV(it.next());
        }
    }

    public void IlO() {
        this.EO.clear();
        this.IlO.clear();
        this.MY.clear();
    }

    public EO IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        return this.IlO.get(Cc(lew));
    }

    public EO IlO(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list) {
        return this.MY.get(tV(list));
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, EO eo) {
        this.IlO.put(Cc(lew), eo);
    }

    private void IlO(List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> list, EO eo) {
        this.MY.put(tV(list), eo);
    }
}
