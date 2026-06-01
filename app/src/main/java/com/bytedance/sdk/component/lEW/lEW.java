package com.bytedance.sdk.component.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class lEW implements Comparable<lEW>, Runnable {
    private int IlO;
    private String MY;

    public lEW(String str, int i2) {
        this.IlO = 0;
        this.IlO = i2 == 0 ? 5 : i2;
        this.MY = str;
    }

    public String getName() {
        return this.MY;
    }

    public int getPriority() {
        return this.IlO;
    }

    public void setPriority(int i2) {
        this.IlO = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(lEW lew) {
        if (getPriority() < lew.getPriority()) {
            return 1;
        }
        return getPriority() >= lew.getPriority() ? -1 : 0;
    }

    public lEW(String str) {
        this.IlO = 5;
        this.MY = str;
    }
}
