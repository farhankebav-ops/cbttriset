package com.bytedance.sdk.component.vCE.IlO.tV.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private int IlO;
    private int MY;

    public IlO(int i2, int i8, long j) {
        if (i8 < i2) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.IlO = i2;
        this.MY = i8;
    }

    public static IlO Cc() {
        return new IlO(3, 100, 172800000L);
    }

    public static IlO EO() {
        return new IlO(1, 100, 172800000L);
    }

    public static IlO tV() {
        return new IlO(1, 100, -1L);
    }

    public int IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }
}
