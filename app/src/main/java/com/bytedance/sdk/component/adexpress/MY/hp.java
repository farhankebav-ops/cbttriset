package com.bytedance.sdk.component.adexpress.MY;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp {
    private int AXM;
    private String Bc;
    private int Cc;
    private boolean DmF;
    private String EO;
    private long EV;
    private JSONObject IlO;
    private Cc MY;
    private int NV;
    private JSONObject OOq;
    private final String YA;
    private Map<String, String> bWL;
    private int cL;
    private String cl;
    private String dY;
    private int ea;
    private int es;
    private String hp;
    private double kBB;
    private String lEW;
    private final boolean lMM;
    private final String nvX;
    private JSONObject oc;
    private int oeT;
    private int pP;
    private int rp;
    private DmF tV;
    private boolean tl;
    private String vAh;
    private String vCE;
    private boolean vSq;
    private JSONObject wPn;
    private int xF;
    private boolean zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private int AXM;
        private String Bc;
        private int Cc;
        private boolean DmF;
        private String EO;
        private long EV;
        private JSONObject IlO;
        private Cc MY;
        private int NV;
        private JSONObject OOq;
        private String YA;
        private Map<String, String> bWL;
        private int cL;
        private String cl;
        private String dY;
        private int ea;
        private int es;
        private String hp;
        private double kBB;
        private String lEW;
        private String nvX;
        private JSONObject oc;
        private int oeT;
        private int pP;
        private int rp;
        private DmF tV;
        private String vAh;
        private String vCE;
        private boolean vSq;
        private JSONObject wPn;
        private int xF;
        private boolean zPa;
        private boolean tl = true;
        private boolean lMM = true;

        public IlO Bc(String str) {
            this.nvX = str;
            return this;
        }

        public IlO Cc(String str) {
            this.cl = str;
            return this;
        }

        public IlO EO(String str) {
            this.Bc = str;
            return this;
        }

        public IlO IlO(Cc cc) {
            this.MY = cc;
            return this;
        }

        public IlO MY(String str) {
            this.vCE = str;
            return this;
        }

        public IlO lEW(String str) {
            this.YA = str;
            return this;
        }

        public IlO tV(String str) {
            this.lEW = str;
            return this;
        }

        public IlO vCE(String str) {
            this.dY = str;
            return this;
        }

        public IlO Cc(int i2) {
            this.pP = i2;
            return this;
        }

        public IlO EO(boolean z2) {
            this.lMM = z2;
            return this;
        }

        public IlO IlO(boolean z2) {
            this.tl = z2;
            return this;
        }

        public IlO MY(boolean z2) {
            this.DmF = z2;
            return this;
        }

        public IlO tV(int i2) {
            this.ea = i2;
            return this;
        }

        public IlO Cc(boolean z2) {
            this.vSq = z2;
            return this;
        }

        public IlO EO(int i2) {
            this.rp = i2;
            return this;
        }

        public IlO IlO(String str) {
            this.EO = str;
            return this;
        }

        public IlO MY(int i2) {
            this.NV = i2;
            return this;
        }

        public IlO tV(boolean z2) {
            this.zPa = z2;
            return this;
        }

        public IlO IlO(DmF dmF) {
            this.tV = dmF;
            return this;
        }

        public IlO IlO(int i2) {
            this.Cc = i2;
            return this;
        }

        public IlO IlO(long j) {
            this.EV = j;
            return this;
        }

        public IlO IlO(Map<String, String> map) {
            this.bWL = map;
            return this;
        }

        public hp IlO() {
            return new hp(this);
        }

        public IlO IlO(double d8) {
            this.kBB = d8;
            return this;
        }
    }

    public hp(IlO ilO) {
        this.IlO = ilO.IlO;
        this.MY = ilO.MY;
        this.EO = ilO.EO;
        this.tV = ilO.tV;
        this.Cc = ilO.Cc;
        this.vCE = ilO.vCE;
        this.Bc = ilO.Bc;
        this.lEW = ilO.lEW;
        this.DmF = ilO.DmF;
        this.NV = ilO.NV;
        this.EV = ilO.EV;
        this.rp = ilO.rp;
        this.hp = ilO.hp;
        this.bWL = ilO.bWL;
        this.ea = ilO.ea;
        this.zPa = ilO.zPa;
        this.cl = ilO.cl;
        this.cL = ilO.cL;
        this.es = ilO.es;
        this.xF = ilO.xF;
        this.AXM = ilO.AXM;
        this.oeT = ilO.oeT;
        this.vAh = ilO.vAh;
        this.kBB = ilO.kBB;
        this.pP = ilO.pP;
        this.tl = ilO.tl;
        this.OOq = ilO.OOq;
        this.wPn = ilO.wPn;
        this.oc = ilO.oc;
        this.vSq = ilO.vSq;
        this.dY = ilO.dY;
        this.lMM = ilO.lMM;
        this.nvX = ilO.nvX;
        this.YA = ilO.YA;
    }

    public int AXM() {
        return this.AXM;
    }

    public int Bc() {
        return this.pP;
    }

    public DmF Cc() {
        return this.tV;
    }

    public long DmF() {
        return this.EV;
    }

    public JSONObject EO() {
        Cc cc;
        if (this.IlO == null && (cc = this.MY) != null) {
            this.IlO = cc.IlO();
        }
        return this.IlO;
    }

    public Map<String, String> EV() {
        return this.bWL;
    }

    public boolean IlO() {
        return this.tl;
    }

    public double MY() {
        return this.kBB;
    }

    public int NV() {
        return this.rp;
    }

    public String OOq() {
        return this.YA;
    }

    public String bWL() {
        return this.cl;
    }

    public JSONObject cL() {
        return this.OOq;
    }

    public int cl() {
        return this.xF;
    }

    public int ea() {
        return this.cL;
    }

    public JSONObject es() {
        return this.wPn;
    }

    public boolean hp() {
        return this.zPa;
    }

    public String kBB() {
        return this.dY;
    }

    public boolean lEW() {
        return this.DmF;
    }

    public int oeT() {
        return this.oeT;
    }

    public boolean pP() {
        return this.lMM;
    }

    public int rp() {
        return this.ea;
    }

    public String tV() {
        return this.EO;
    }

    public String tl() {
        return this.nvX;
    }

    public boolean vAh() {
        return this.vSq;
    }

    public int vCE() {
        return this.Cc;
    }

    public JSONObject xF() {
        return this.oc;
    }

    public int zPa() {
        return this.es;
    }
}
