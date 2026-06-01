package com.bytedance.adsdk.MY;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private final List<IlO> Bc;
    private final String Cc;
    private final int[][] DmF;
    private final String EO;
    private Bitmap EV;
    private final int IlO;
    private final int MY;
    private final JSONArray NV;
    private final String lEW;
    private final String tV;
    private final String vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public String Bc;
        public int Cc;
        public String EO;
        public int IlO;
        public int MY;
        public String tV;
        public int vCE;
    }

    public NV(int i2, int i8, String str, String str2, String str3, String str4, List<IlO> list, String str5, int[][] iArr, JSONArray jSONArray) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = str;
        this.tV = str2;
        this.Cc = str3;
        this.vCE = str4;
        this.Bc = list;
        this.lEW = str5;
        this.DmF = iArr;
        this.NV = jSONArray;
    }

    public JSONArray Bc() {
        return this.NV;
    }

    public String Cc() {
        return this.lEW;
    }

    public String DmF() {
        return this.tV;
    }

    public List<IlO> EO() {
        return this.Bc;
    }

    public Bitmap EV() {
        return this.EV;
    }

    public int IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public String NV() {
        return this.Cc;
    }

    public String lEW() {
        return this.EO;
    }

    public String tV() {
        return this.vCE;
    }

    public int[][] vCE() {
        return this.DmF;
    }

    public void IlO(Bitmap bitmap) {
        this.EV = bitmap;
    }
}
