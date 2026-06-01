package com.bytedance.adsdk.MY;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private SparseArray<com.bytedance.adsdk.MY.EO.tV> Bc;
    private Map<String, com.bytedance.adsdk.MY.EO.EO> Cc;
    private List<com.bytedance.adsdk.MY.EO.EO.Cc> DmF;
    private Map<String, List<com.bytedance.adsdk.MY.EO.EO.Cc>> EO;
    private float EV;
    private Rect NV;
    private boolean bWL;
    private IlO cL;
    private MY es;
    private float hp;
    private LongSparseArray<com.bytedance.adsdk.MY.EO.EO.Cc> lEW;
    private float rp;
    private Map<String, NV> tV;
    private List<com.bytedance.adsdk.MY.EO.vCE> vCE;
    private EO zPa;
    private final es IlO = new es();
    private final HashSet<String> MY = new HashSet<>();
    private int ea = 0;
    private String cl = "";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO {
        public JSONArray Bc;
        public int[] Cc;
        public String EO;
        public int IlO;
        public String MY;
        public String tV;
        public String vCE;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public JSONArray Bc;
        public int Cc;
        public Map<String, Object> EO;
        public int IlO;
        public Map<String, Object> MY;
        public int tV;
        public String vCE;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        public JSONArray EO;
        public String IlO;
        public int[][] MY;
    }

    public float Bc() {
        return this.rp;
    }

    public float Cc() {
        return (long) ((cl() / this.hp) * 1000.0f);
    }

    public String DmF() {
        return this.cl;
    }

    public es EO() {
        return this.IlO;
    }

    public IlO EV() {
        return this.cL;
    }

    public void IlO(Rect rect, float f4, float f8, float f9, List<com.bytedance.adsdk.MY.EO.EO.Cc> list, LongSparseArray<com.bytedance.adsdk.MY.EO.EO.Cc> longSparseArray, Map<String, List<com.bytedance.adsdk.MY.EO.EO.Cc>> map, Map<String, NV> map2, SparseArray<com.bytedance.adsdk.MY.EO.tV> sparseArray, Map<String, com.bytedance.adsdk.MY.EO.EO> map3, List<com.bytedance.adsdk.MY.EO.vCE> list2, EO eo, String str, IlO ilO, MY my) {
        this.NV = rect;
        this.EV = f4;
        this.rp = f8;
        this.hp = f9;
        this.DmF = list;
        this.lEW = longSparseArray;
        this.EO = map;
        this.tV = map2;
        this.Bc = sparseArray;
        this.Cc = map3;
        this.vCE = list2;
        this.zPa = eo;
        this.cl = str;
        this.cL = ilO;
        this.es = my;
    }

    public int MY() {
        return this.ea;
    }

    public MY NV() {
        return this.es;
    }

    public SparseArray<com.bytedance.adsdk.MY.EO.tV> bWL() {
        return this.Bc;
    }

    public float cl() {
        return this.rp - this.EV;
    }

    public Map<String, com.bytedance.adsdk.MY.EO.EO> ea() {
        return this.Cc;
    }

    public List<com.bytedance.adsdk.MY.EO.EO.Cc> hp() {
        return this.DmF;
    }

    public EO lEW() {
        return this.zPa;
    }

    public float rp() {
        return this.hp;
    }

    public Rect tV() {
        return this.NV;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.MY.EO.EO.Cc> it = this.DmF.iterator();
        while (it.hasNext()) {
            sb.append(it.next().IlO("\t"));
        }
        return sb.toString();
    }

    public float vCE() {
        return this.EV;
    }

    public Map<String, NV> zPa() {
        return this.tV;
    }

    public com.bytedance.adsdk.MY.EO.vCE EO(String str) {
        int size = this.vCE.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.bytedance.adsdk.MY.EO.vCE vce = this.vCE.get(i2);
            if (vce.IlO(str)) {
                return vce;
            }
        }
        return null;
    }

    public void MY(boolean z2) {
        this.IlO.IlO(z2);
    }

    public List<com.bytedance.adsdk.MY.EO.EO.Cc> MY(String str) {
        return this.EO.get(str);
    }

    public void IlO(String str) {
        this.MY.add(str);
    }

    public void IlO(boolean z2) {
        this.bWL = z2;
    }

    public void IlO(int i2) {
        this.ea += i2;
    }

    public boolean IlO() {
        return this.bWL;
    }

    public com.bytedance.adsdk.MY.EO.EO.Cc IlO(long j) {
        return this.lEW.get(j);
    }

    public float IlO(float f4) {
        return com.bytedance.adsdk.MY.vCE.Cc.IlO(this.EV, this.rp, f4);
    }
}
