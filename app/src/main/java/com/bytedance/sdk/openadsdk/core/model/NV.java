package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private final float Bc;
    private final float Cc;
    private final long DmF;
    private final int[] EO;
    private final int EV;
    private final int[] IlO;
    private final int[] MY;
    private final long NV;
    private final int bWL;
    private final String cL;
    private final JSONObject cl;
    private final SparseArray<EO.IlO> ea;
    private final JSONObject es;
    private final int hp;
    private final float lEW;
    private final int rp;
    private final int[] tV;
    private final float vCE;
    private final int zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private JSONObject AXM;
        private float Bc;
        private long Cc;
        private float DmF;
        float EO;
        private int[] EV;
        float IlO;
        int MY;
        private int[] NV;
        private int bWL;
        private int cL;
        private SparseArray<EO.IlO> cl;
        private int ea;
        private String es;
        private int[] hp;
        private float lEW;
        private JSONObject oeT;
        private int[] rp;
        private long tV;
        private float vCE;
        private int xF;
        private int zPa;

        public IlO Cc(float f4) {
            this.lEW = f4;
            return this;
        }

        public IlO EO(int i2) {
            this.MY = i2;
            return this;
        }

        public IlO IlO(int i2) {
            this.xF = i2;
            return this;
        }

        public IlO MY(JSONObject jSONObject) {
            this.oeT = jSONObject;
            return this;
        }

        public IlO tV(float f4) {
            this.Bc = f4;
            return this;
        }

        public IlO vCE(float f4) {
            this.DmF = f4;
            return this;
        }

        public IlO Cc(int i2) {
            this.ea = i2;
            return this;
        }

        public IlO EO(float f4) {
            this.vCE = f4;
            return this;
        }

        public IlO IlO(JSONObject jSONObject) {
            this.AXM = jSONObject;
            return this;
        }

        public IlO MY(int i2) {
            this.cL = i2;
            return this;
        }

        public IlO tV(int[] iArr) {
            this.hp = iArr;
            return this;
        }

        public IlO vCE(int i2) {
            this.zPa = i2;
            return this;
        }

        public IlO EO(int[] iArr) {
            this.rp = iArr;
            return this;
        }

        public IlO IlO(SparseArray<EO.IlO> sparseArray) {
            this.cl = sparseArray;
            return this;
        }

        public IlO MY(float f4) {
            this.EO = f4;
            return this;
        }

        public IlO tV(int i2) {
            this.bWL = i2;
            return this;
        }

        public IlO IlO(float f4) {
            this.IlO = f4;
            return this;
        }

        public IlO MY(long j) {
            this.Cc = j;
            return this;
        }

        public IlO IlO(long j) {
            this.tV = j;
            return this;
        }

        public IlO MY(int[] iArr) {
            this.EV = iArr;
            return this;
        }

        public IlO IlO(int[] iArr) {
            this.NV = iArr;
            return this;
        }

        public IlO IlO(String str) {
            this.es = str;
            return this;
        }

        public NV IlO() {
            return new NV(this);
        }
    }

    public JSONObject IlO() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.es;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.es.opt(next));
                    }
                } catch (Exception unused) {
                }
            }
            int[] iArr = this.IlO;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.IlO[1]));
            }
            int[] iArr2 = this.MY;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.MY[1]));
            }
            int[] iArr3 = this.EO;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.EO[1]));
            }
            int[] iArr4 = this.tV;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.tV[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.Cc)).putOpt("down_y", Float.toString(this.vCE)).putOpt("up_x", Float.toString(this.Bc)).putOpt("up_y", Float.toString(this.lEW)).putOpt("down_time", Long.valueOf(this.DmF)).putOpt("up_time", Long.valueOf(this.NV)).putOpt("toolType", Integer.valueOf(this.EV)).putOpt("deviceId", Integer.valueOf(this.rp)).putOpt("source", Integer.valueOf(this.hp)).putOpt("ft", IlO(this.ea, this.bWL)).putOpt("click_area_type", this.cL);
            int i2 = this.zPa;
            if (i2 > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i2));
            }
            JSONObject jSONObject3 = this.cl;
            if (jSONObject3 != null) {
                jSONObject.putOpt("rectInfo", jSONObject3);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private NV(@NonNull IlO ilO) {
        this.IlO = ilO.EV;
        this.MY = ilO.rp;
        this.tV = ilO.hp;
        this.EO = ilO.NV;
        this.Cc = ilO.DmF;
        this.vCE = ilO.lEW;
        this.Bc = ilO.Bc;
        this.lEW = ilO.vCE;
        this.DmF = ilO.Cc;
        this.NV = ilO.tV;
        this.EV = ilO.bWL;
        this.rp = ilO.ea;
        this.hp = ilO.zPa;
        this.bWL = ilO.cL;
        this.ea = ilO.cl;
        this.cL = ilO.es;
        this.zPa = ilO.xF;
        this.cl = ilO.AXM;
        this.es = ilO.oeT;
    }

    public static JSONObject IlO(SparseArray<EO.IlO> sparseArray, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                    EO.IlO ilOValueAt = sparseArray.valueAt(i8);
                    if (ilOValueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(ilOValueAt.EO)).putOpt("mr", Double.valueOf(ilOValueAt.MY)).putOpt(TypedValues.CycleType.S_WAVE_PHASE, Integer.valueOf(ilOValueAt.IlO)).putOpt("ts", Long.valueOf(ilOValueAt.tV));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i2)).putOpt("info", jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
