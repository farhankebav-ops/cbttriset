package com.bytedance.sdk.component.vCE.IlO.Cc;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Cc implements Comparable<Cc>, Runnable {
    private String EO;
    private int IlO = 5;
    private String MY = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public Cc(String str) {
        this.EO = str;
    }

    public void IlO(int i2) {
        this.IlO = i2;
    }

    public int IlO() {
        return this.IlO;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(Cc cc) {
        if (IlO() < cc.IlO()) {
            return 1;
        }
        return IlO() >= cc.IlO() ? -1 : 0;
    }
}
