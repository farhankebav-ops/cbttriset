package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private boolean Cc;
    private int EO;
    private String IlO;
    private int MY;
    private double tV;
    private String vCE;

    public String Bc() {
        return this.vCE;
    }

    public boolean Cc() {
        return !TextUtils.isEmpty(this.IlO) && this.MY > 0 && this.EO > 0;
    }

    public int EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public double tV() {
        return this.tV;
    }

    public boolean vCE() {
        return this.Cc;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(int i2) {
        this.EO = i2;
    }

    public void IlO(int i2) {
        this.MY = i2;
    }

    public void MY(String str) {
        this.vCE = str;
    }

    public void IlO(boolean z2) {
        this.Cc = z2;
    }
}
