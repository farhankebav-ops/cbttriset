package com.bytedance.sdk.component.lEW.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MY implements Comparable<MY>, Runnable {
    private long Cc;
    private Runnable EO;
    private int IlO;
    private String MY;
    private long tV;
    private long vCE;

    public MY(String str) {
        this.IlO = 5;
        this.MY = str;
    }

    public long Bc() {
        return this.vCE - this.Cc;
    }

    public long Cc() {
        return this.vCE;
    }

    public long EO() {
        return this.tV;
    }

    public void IlO(int i2) {
        this.IlO = i2;
    }

    public String MY() {
        return this.MY;
    }

    public Runnable lEW() {
        return this.EO;
    }

    public long tV() {
        return this.Cc;
    }

    public long vCE() {
        return this.Cc - this.tV;
    }

    public void EO(long j) {
        this.vCE = j;
    }

    public int IlO() {
        return this.IlO;
    }

    public void MY(long j) {
        this.Cc = j;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(MY my) {
        if (IlO() < my.IlO()) {
            return 1;
        }
        return IlO() >= my.IlO() ? -1 : 0;
    }

    public MY(int i2, String str) {
        this.IlO = i2;
        this.MY = str;
    }

    public void IlO(long j) {
        this.tV = j;
    }

    public MY(String str, Runnable runnable) {
        this.IlO = 5;
        this.MY = str;
        this.EO = runnable;
    }
}
