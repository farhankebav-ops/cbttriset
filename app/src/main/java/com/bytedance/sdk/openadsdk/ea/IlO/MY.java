package com.bytedance.sdk.openadsdk.ea.IlO;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private int Bc;
    private boolean Cc;
    private String EO;
    private String IlO;
    private oeT MY;
    private int tV;
    private String vCE;
    private int lEW = 0;
    private int DmF = 0;

    public int Bc() {
        return this.Bc;
    }

    public boolean Cc() {
        return this.Cc;
    }

    public int DmF() {
        return this.DmF;
    }

    public String EO() {
        oeT oet;
        if (TextUtils.isEmpty(this.EO) && (oet = this.MY) != null) {
            this.EO = zLG.IlO(oet);
        }
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public oeT MY() {
        return this.MY;
    }

    public int lEW() {
        return this.lEW;
    }

    public int tV() {
        return this.tV;
    }

    public String vCE() {
        return this.vCE;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(String str) {
        this.EO = str;
    }

    public void tV(int i2) {
        this.DmF = i2;
    }

    public void IlO(oeT oet) {
        this.MY = oet;
    }

    public void MY(int i2) {
        this.Bc = i2;
    }

    public void IlO(int i2) {
        this.tV = i2;
    }

    public void EO(String str) {
        this.vCE = str;
    }

    public void IlO(boolean z2) {
        this.Cc = z2;
    }

    public void EO(int i2) {
        this.lEW = i2;
    }
}
