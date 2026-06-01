package com.bytedance.sdk.component.lEW.IlO;

import com.bytedance.sdk.component.lEW.IlO.EO;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV<T extends EO> {
    private int IlO;
    private BlockingQueue<T> MY = new LinkedBlockingQueue();

    private tV(int i2) {
        this.IlO = i2;
    }

    public static tV IlO(int i2) {
        return new tV(i2);
    }

    public T IlO() {
        return this.MY.poll();
    }

    public boolean IlO(T t3) {
        if (t3 == null) {
            return false;
        }
        t3.IlO();
        if (this.MY.size() >= this.IlO) {
            return false;
        }
        return this.MY.offer(t3);
    }
}
