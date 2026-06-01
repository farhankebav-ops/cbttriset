package com.bytedance.adsdk.MY.EO.EO;

import androidx.camera.core.processing.util.a;
import com.bytedance.adsdk.MY.EO.IlO.EV;
import com.bytedance.adsdk.MY.EO.IlO.rp;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private final MY AXM;
    private final String Bc;
    private final IlO Cc;
    private final rp DmF;
    private final String EO;
    private final int EV;
    private final List<com.bytedance.adsdk.MY.EO.MY.EO> IlO;
    private final com.bytedance.adsdk.MY.Bc MY;
    private final int NV;
    private final float bWL;
    private final EV cL;
    private final com.bytedance.adsdk.MY.EO.IlO.NV cl;
    private final float ea;
    private final com.bytedance.adsdk.MY.EO.IlO.MY es;
    private final float hp;
    private final com.bytedance.adsdk.MY.Cc.NV kBB;
    private final List<com.bytedance.adsdk.MY.EO.MY.lEW> lEW;
    private final boolean oeT;
    private final int rp;
    private final long tV;
    private final com.bytedance.adsdk.MY.EO.MY.IlO vAh;
    private final long vCE;
    private final List<com.bytedance.adsdk.MY.Bc.IlO<Float>> xF;
    private final float zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum MY {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Cc(List<com.bytedance.adsdk.MY.EO.MY.EO> list, com.bytedance.adsdk.MY.Bc bc, String str, long j, IlO ilO, long j3, String str2, List<com.bytedance.adsdk.MY.EO.MY.lEW> list2, rp rpVar, int i2, int i8, int i9, float f4, float f8, float f9, float f10, com.bytedance.adsdk.MY.EO.IlO.NV nv, EV ev, List<com.bytedance.adsdk.MY.Bc.IlO<Float>> list3, MY my, com.bytedance.adsdk.MY.EO.IlO.MY my2, boolean z2, com.bytedance.adsdk.MY.EO.MY.IlO ilO2, com.bytedance.adsdk.MY.Cc.NV nv2) {
        this.IlO = list;
        this.MY = bc;
        this.EO = str;
        this.tV = j;
        this.Cc = ilO;
        this.vCE = j3;
        this.Bc = str2;
        this.lEW = list2;
        this.DmF = rpVar;
        this.NV = i2;
        this.EV = i8;
        this.rp = i9;
        this.hp = f4;
        this.bWL = f8;
        this.ea = f9;
        this.zPa = f10;
        this.cl = nv;
        this.cL = ev;
        this.xF = list3;
        this.AXM = my;
        this.es = my2;
        this.oeT = z2;
        this.vAh = ilO2;
        this.kBB = nv2;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY AXM() {
        return this.es;
    }

    public String Bc() {
        return this.Bc;
    }

    public long Cc() {
        return this.tV;
    }

    public float DmF() {
        return this.zPa;
    }

    public float EO() {
        return this.bWL / this.MY.cl();
    }

    public IlO EV() {
        return this.Cc;
    }

    public String IlO(String str) {
        StringBuilder sbR = a.r(str);
        sbR.append(vCE());
        sbR.append("\n");
        Cc ccIlO = this.MY.IlO(hp());
        if (ccIlO != null) {
            sbR.append("\t\tParents: ");
            sbR.append(ccIlO.vCE());
            Cc ccIlO2 = this.MY.IlO(ccIlO.hp());
            while (ccIlO2 != null) {
                sbR.append("->");
                sbR.append(ccIlO2.vCE());
                ccIlO2 = this.MY.IlO(ccIlO2.hp());
            }
            sbR.append(str);
            sbR.append("\n");
        }
        if (!NV().isEmpty()) {
            sbR.append(str);
            sbR.append("\tMasks: ");
            sbR.append(NV().size());
            sbR.append("\n");
        }
        if (cL() != 0 && cl() != 0) {
            sbR.append(str);
            sbR.append("\tBackground: ");
            sbR.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(cL()), Integer.valueOf(cl()), Integer.valueOf(zPa())));
        }
        if (!this.IlO.isEmpty()) {
            sbR.append(str);
            sbR.append("\tShapes:\n");
            for (com.bytedance.adsdk.MY.EO.MY.EO eo : this.IlO) {
                sbR.append(str);
                sbR.append("\t\t");
                sbR.append(eo);
                sbR.append("\n");
            }
        }
        return sbR.toString();
    }

    public float MY() {
        return this.hp;
    }

    public List<com.bytedance.adsdk.MY.EO.MY.lEW> NV() {
        return this.lEW;
    }

    public List<com.bytedance.adsdk.MY.EO.MY.EO> bWL() {
        return this.IlO;
    }

    public int cL() {
        return this.NV;
    }

    public int cl() {
        return this.EV;
    }

    public rp ea() {
        return this.DmF;
    }

    public com.bytedance.adsdk.MY.EO.IlO.NV es() {
        return this.cl;
    }

    public long hp() {
        return this.vCE;
    }

    public com.bytedance.adsdk.MY.Cc.NV kBB() {
        return this.kBB;
    }

    public float lEW() {
        return this.ea;
    }

    public boolean oeT() {
        return this.oeT;
    }

    public MY rp() {
        return this.AXM;
    }

    public List<com.bytedance.adsdk.MY.Bc.IlO<Float>> tV() {
        return this.xF;
    }

    public String toString() {
        return IlO("");
    }

    public com.bytedance.adsdk.MY.EO.MY.IlO vAh() {
        return this.vAh;
    }

    public String vCE() {
        return this.EO;
    }

    public EV xF() {
        return this.cL;
    }

    public int zPa() {
        return this.rp;
    }

    public com.bytedance.adsdk.MY.Bc IlO() {
        return this.MY;
    }
}
