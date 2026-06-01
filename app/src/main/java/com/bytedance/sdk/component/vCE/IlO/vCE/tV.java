package com.bytedance.sdk.component.vCE.IlO.vCE;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private String Bc;
    private final int Cc;
    private final boolean EO;
    private boolean EV;
    private final String IlO;
    private final String MY;
    private String lEW;
    private final String vCE;
    private int tV = -1;
    private int DmF = 0;
    private String NV = null;

    public tV(String str, String str2, boolean z2, int i2, String str3) {
        this.IlO = str;
        this.MY = str2;
        this.EO = z2;
        this.Cc = i2;
        this.vCE = str3;
    }

    public String Bc() {
        return this.Bc;
    }

    public int Cc() {
        return this.Cc;
    }

    public String DmF() {
        return this.lEW;
    }

    public boolean EO() {
        return this.EO;
    }

    public boolean EV() {
        return this.tV == -1;
    }

    public String IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    public boolean NV() {
        return this.EV;
    }

    public int lEW() {
        return this.DmF;
    }

    public int tV() {
        return this.tV;
    }

    public String vCE() {
        return this.vCE;
    }

    public void EO(String str) {
        this.NV = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.lEW)) {
            this.lEW = String.valueOf(this.NV);
            return;
        }
        this.lEW += "," + this.NV;
    }

    public void IlO(int i2) {
        this.tV = i2;
    }

    public void MY(int i2) {
        this.DmF = i2;
        if (i2 == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.Bc)) {
            this.Bc = String.valueOf(this.DmF);
            return;
        }
        this.Bc += "," + this.DmF;
    }

    public void IlO(String str) {
        this.Bc = str;
    }

    public void IlO(boolean z2) {
        this.EV = z2;
    }

    public Runnable IlO(String str, Map<String, String> map) {
        return IlO.IlO().IlO(this, str, map);
    }

    public void MY(String str) {
        this.lEW = str;
    }
}
