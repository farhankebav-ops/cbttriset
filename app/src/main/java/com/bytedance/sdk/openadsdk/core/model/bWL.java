package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL implements com.bytedance.sdk.component.adexpress.EO {
    public final int Bc;
    public final long Cc;
    public final int DmF;
    public final float EO;
    public final String EV;
    public final float IlO;
    public final float MY;
    public final int NV;
    public SparseArray<EO.IlO> bWL;
    public boolean cL;
    public JSONObject cl;
    public final boolean ea;
    public int es;
    public JSONObject hp;
    public final int lEW;
    public int rp;
    public final float tV;
    public final long vCE;
    public int zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private float Bc;
        private float Cc;
        private int DmF;
        private long EO;
        private int EV;
        private long MY;
        private int NV;
        private int bWL;
        private JSONObject cl;
        private JSONObject ea;
        private boolean es;
        private String hp;
        private int lEW;
        private int rp;
        private float tV;
        private float vCE;
        private int zPa;
        private boolean cL = false;
        protected SparseArray<EO.IlO> IlO = new SparseArray<>();

        public IlO Bc(int i2) {
            this.EV = i2;
            return this;
        }

        public IlO Cc(int i2) {
            this.DmF = i2;
            return this;
        }

        public IlO EO(int i2) {
            this.rp = i2;
            return this;
        }

        public IlO IlO(int i2) {
            this.zPa = i2;
            return this;
        }

        public IlO MY(int i2) {
            this.bWL = i2;
            return this;
        }

        public IlO tV(float f4) {
            this.Bc = f4;
            return this;
        }

        public IlO vCE(int i2) {
            this.NV = i2;
            return this;
        }

        public IlO EO(float f4) {
            this.vCE = f4;
            return this;
        }

        public IlO IlO(JSONObject jSONObject) {
            this.ea = jSONObject;
            return this;
        }

        public IlO MY(long j) {
            this.EO = j;
            return this;
        }

        public IlO tV(int i2) {
            this.lEW = i2;
            return this;
        }

        public IlO IlO(boolean z2) {
            this.es = z2;
            return this;
        }

        public IlO MY(float f4) {
            this.Cc = f4;
            return this;
        }

        public IlO IlO(long j) {
            this.MY = j;
            return this;
        }

        public IlO MY(JSONObject jSONObject) {
            this.cl = jSONObject;
            return this;
        }

        public IlO IlO(float f4) {
            this.tV = f4;
            return this;
        }

        public IlO MY(boolean z2) {
            this.cL = z2;
            return this;
        }

        public IlO IlO(String str) {
            this.hp = str;
            return this;
        }

        public IlO IlO(SparseArray<EO.IlO> sparseArray) {
            this.IlO = sparseArray;
            return this;
        }

        public bWL IlO() {
            return new bWL(this);
        }
    }

    private bWL(@NonNull IlO ilO) {
        this.cL = false;
        this.IlO = ilO.Bc;
        this.MY = ilO.vCE;
        this.EO = ilO.Cc;
        this.tV = ilO.tV;
        this.Cc = ilO.EO;
        this.vCE = ilO.MY;
        this.Bc = ilO.lEW;
        this.lEW = ilO.DmF;
        this.DmF = ilO.NV;
        this.NV = ilO.EV;
        this.EV = ilO.hp;
        this.bWL = ilO.IlO;
        this.ea = ilO.es;
        this.rp = ilO.bWL;
        this.hp = ilO.ea;
        this.zPa = ilO.zPa;
        this.cl = ilO.cl;
        this.cL = ilO.cL;
        this.es = ilO.rp;
    }
}
