package com.bytedance.sdk.component.adexpress.dynamic.tV;

import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private float Bc;
    private float Cc;
    private Cc DmF;
    private float EO;
    private lEW EV;
    private String IlO;
    private float MY;
    private List<lEW> NV;
    private boolean bWL;
    private String hp;
    private float lEW;
    private List<List<lEW>> rp;
    private float tV;
    private float vCE;
    private Map<String, String> ea = new HashMap();
    private Map<Integer, String> zPa = new HashMap();

    public void AXM() {
        List<List<lEW>> list = this.rp;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<lEW> list2 : this.rp) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.rp = arrayList;
    }

    public float Bc() {
        return this.EO;
    }

    public float Cc() {
        return this.Cc;
    }

    public float DmF() {
        return this.Bc;
    }

    public String EO() {
        return this.IlO;
    }

    public List<lEW> EV() {
        return this.NV;
    }

    public String IlO() {
        return this.hp;
    }

    public Map<Integer, String> MY() {
        return this.zPa;
    }

    public Cc NV() {
        return this.DmF;
    }

    public int bWL() {
        vCE vceCc = this.DmF.Cc();
        return vceCc.uvo() + vceCc.quf();
    }

    public boolean cL() {
        List<lEW> list = this.NV;
        return list == null || list.size() <= 0;
    }

    public List<List<lEW>> cl() {
        return this.rp;
    }

    public float ea() {
        vCE vceCc = this.DmF.Cc();
        return (vceCc.rp() * 2.0f) + vceCc.zPa() + vceCc.ea() + hp();
    }

    public boolean es() {
        return this.bWL;
    }

    public int hp() {
        vCE vceCc = this.DmF.Cc();
        return vceCc.Ea() + vceCc.KC();
    }

    public boolean kBB() {
        return this.DmF.Cc().PTq() < 0 || this.DmF.Cc().VH() < 0 || this.DmF.Cc().aa() < 0 || this.DmF.Cc().ED() < 0;
    }

    public float lEW() {
        return this.vCE;
    }

    public boolean oeT() {
        return TextUtils.equals(this.DmF.Cc().wPn(), "flex");
    }

    public lEW rp() {
        return this.EV;
    }

    public float tV() {
        return this.tV;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.IlO + "', x=" + this.MY + ", y=" + this.EO + ", width=" + this.vCE + ", height=" + this.Bc + ", remainWidth=" + this.lEW + ", rootBrick=" + this.DmF + ", childrenBrickUnits=" + this.NV + '}';
    }

    public String vAh() {
        return this.DmF.Cc().vAh();
    }

    public float vCE() {
        return this.MY;
    }

    public Map<String, String> xF() {
        return this.ea;
    }

    public float zPa() {
        vCE vceCc = this.DmF.Cc();
        return (vceCc.rp() * 2.0f) + vceCc.bWL() + vceCc.cl() + bWL();
    }

    public void Bc(float f4) {
        this.lEW = f4;
    }

    public void Cc(float f4) {
        this.vCE = f4;
    }

    public void EO(float f4) {
        this.MY = f4;
    }

    public void IlO(String str) {
        this.hp = str;
    }

    public void MY(String str) {
        this.IlO = str;
    }

    public void tV(float f4) {
        this.EO = f4;
    }

    public void vCE(float f4) {
        this.Bc = f4;
    }

    public void EO(String str) {
        this.DmF.Cc().vCE(str);
    }

    public void IlO(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    this.zPa.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void MY(float f4) {
        this.Cc = f4;
    }

    public void MY(List<List<lEW>> list) {
        this.rp = list;
    }

    public void IlO(float f4) {
        this.tV = f4;
    }

    public void IlO(Cc cc) {
        this.DmF = cc;
    }

    public void IlO(List<lEW> list) {
        this.NV = list;
    }

    public void IlO(lEW lew) {
        this.EV = lew;
    }

    public void IlO(boolean z2) {
        this.bWL = z2;
    }

    public void IlO(String str, String str2) {
        this.ea.put(str, str2);
    }

    public String IlO(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.DmF.MY());
        sb.append(":");
        sb.append(this.IlO);
        if (this.DmF.Cc() != null) {
            sb.append(":");
            sb.append(this.DmF.Cc().NST());
        }
        return a.m(sb, ":", i2);
    }
}
