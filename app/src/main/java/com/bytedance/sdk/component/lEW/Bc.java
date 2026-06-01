package com.bytedance.sdk.component.lEW;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc<V> extends FutureTask<V> implements Comparable<Bc<V>> {
    private int IlO;
    private int MY;

    public Bc(Callable<V> callable, int i2, int i8) {
        super(callable);
        this.IlO = i2 == -1 ? 5 : i2;
        this.MY = i8;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(Bc bc) {
        if (IlO() < bc.IlO()) {
            return 1;
        }
        return IlO() > bc.IlO() ? -1 : 0;
    }

    public int IlO() {
        return this.IlO;
    }
}
