package com.bykv.vk.openvk.IlO.IlO.IlO.EO;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Serializable {
    private int AXM;
    private c Bc;
    private boolean DmF;
    public int EO;
    public String MY;
    private int bWL;
    private boolean cL;
    private long cl;
    private int ea;
    private boolean es;
    private String hp;
    private String lEW;
    private int tl;
    private c vCE;
    private int xF;
    private String zPa;
    private int NV = 204800;
    private int EV = 0;
    private int rp = 0;
    protected float IlO = -1.0f;
    public final HashMap<String, Object> tV = new HashMap<>();
    private int oeT = 10000;
    private int vAh = 10000;
    private int kBB = 10000;
    private int pP = 0;
    public int Cc = 1;
    private JSONObject OOq = new JSONObject();

    public a(String str, c cVar, c cVar2, int i2, int i8) {
        this.xF = 0;
        this.AXM = 0;
        this.lEW = str;
        this.vCE = cVar;
        this.Bc = cVar2;
        this.xF = i2;
        this.AXM = i8;
    }

    public int AXM() {
        return this.kBB;
    }

    public boolean Bc() {
        return this.es;
    }

    public String Cc() {
        return this.lEW;
    }

    public int DmF() {
        return this.ea;
    }

    public JSONObject EO() {
        return this.OOq;
    }

    public boolean EV() {
        return this.cL;
    }

    public void IlO(int i2) {
        this.tl = i2;
    }

    public boolean MY() {
        return this.tl == 2;
    }

    public long NV() {
        return this.cl;
    }

    public boolean bWL() {
        c cVar;
        if (this.AXM != 1 || (cVar = this.Bc) == null || TextUtils.isEmpty(cVar.g)) {
            return false;
        }
        return r.a.e == 2 ? Build.VERSION.SDK_INT >= 26 : this.xF == 1;
    }

    public int cL() {
        return this.xF;
    }

    public String cl() {
        if (bWL()) {
            return this.Bc.a();
        }
        c cVar = this.vCE;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    public float ea() {
        float f4 = this.IlO;
        if (f4 != -1.0f) {
            return f4;
        }
        if (bWL()) {
            this.Bc.getClass();
            return -1.0f;
        }
        c cVar = this.vCE;
        if (cVar != null) {
            cVar.getClass();
        }
        return -1.0f;
    }

    public int es() {
        return this.oeT;
    }

    public boolean hp() {
        if (bWL()) {
            return this.Bc.f4692o == 0;
        }
        c cVar = this.vCE;
        return cVar == null || cVar.f4692o == 0;
    }

    public c kBB() {
        return this.Bc;
    }

    public int lEW() {
        return this.bWL;
    }

    public int oeT() {
        return this.pP;
    }

    public boolean pP() {
        return this.DmF;
    }

    public long rp() {
        if (bWL()) {
            return this.Bc.f4687c;
        }
        c cVar = this.vCE;
        if (cVar != null) {
            return cVar.f4687c;
        }
        return 0L;
    }

    public int tV() {
        return this.OOq.optInt("pitaya_cache_size", 0);
    }

    public c vAh() {
        return this.vCE;
    }

    public int vCE() {
        if (bWL()) {
            return this.Bc.c();
        }
        c cVar = this.vCE;
        if (cVar != null) {
            return cVar.c();
        }
        return 0;
    }

    public int xF() {
        return this.vAh;
    }

    public String zPa() {
        if (bWL()) {
            return this.Bc.g;
        }
        c cVar = this.vCE;
        if (cVar != null) {
            return cVar.g;
        }
        return null;
    }

    public void Bc(int i2) {
        this.kBB = i2;
    }

    public synchronized Object Cc(String str) {
        return this.tV.get(str);
    }

    public void EO(int i2) {
        this.ea = i2;
    }

    public boolean IlO() {
        int i2 = this.tl;
        return i2 == 1 || i2 == 2;
    }

    public void MY(String str) {
        this.hp = str;
    }

    public void lEW(int i2) {
        this.pP = i2;
    }

    public void tV(String str) {
        this.MY = str;
    }

    public void Cc(int i2) {
        this.oeT = i2;
    }

    public void EO(String str) {
        this.zPa = str;
    }

    public void IlO(String str) {
        this.lEW = str;
    }

    public void MY(int i2) {
        this.bWL = i2;
    }

    public void tV(int i2) {
        this.EO = i2;
    }

    public void IlO(long j) {
        this.cl = j;
    }

    public void MY(boolean z2) {
        this.DmF = z2;
    }

    public void IlO(boolean z2) {
        this.cL = z2;
    }

    public void vCE(int i2) {
        this.vAh = i2;
    }

    public synchronized void IlO(String str, Object obj) {
        this.tV.put(str, obj);
    }
}
