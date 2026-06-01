package com.bytedance.sdk.component.vCE.IlO.IlO.MY;

import com.bytedance.sdk.component.vCE.IlO.tV.IlO;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tV<T extends com.bytedance.sdk.component.vCE.IlO.tV.IlO> {
    private Queue<String> EO;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO IlO;
    private Queue<T> MY = new ConcurrentLinkedQueue();
    private String tV;

    public tV(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO, Queue<String> queue, String str) {
        this.IlO = ilO;
        this.EO = queue;
        this.tV = str;
    }

    public void IlO(T t3) {
        Queue<T> queue = this.MY;
        if (queue == null || t3 == null) {
            return;
        }
        queue.offer(t3);
    }

    public synchronized boolean MY(int i2, int i8) {
        int size = this.MY.size();
        int iIlO = this.IlO.IlO();
        return (i2 == 2 || i2 == 1) ? com.bytedance.sdk.component.vCE.IlO.EO.IlO.EO() ? size > 0 : size >= iIlO : size >= iIlO;
    }

    public synchronized List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int i2, int i8) {
        if (!MY(i2, i8)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.IlO.IlO());
        do {
            T tPoll = this.MY.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.IlO.MY());
        return arrayList;
    }

    public synchronized void IlO(int i2, List<T> list) {
        if (i2 != -1 && i2 != 200 && i2 != 509) {
            this.MY.addAll(list);
        } else {
            this.MY.size();
        }
    }
}
