package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.component.MY.IlO.tV {
    public static volatile NV IlO;
    private ExecutorService tV;
    private List<com.bytedance.sdk.component.MY.IlO.MY> MY = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.MY.IlO.MY> EO = new CopyOnWriteArrayList();

    public IlO(ExecutorService executorService) {
        this.tV = executorService;
    }

    public boolean Cc() {
        return (IlO == null || IlO.IlO() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public List<com.bytedance.sdk.component.MY.IlO.MY> EO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public int IlO() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public ExecutorService MY() {
        ExecutorService executorServiceIlO = IlO != null ? IlO.IlO() : null;
        return executorServiceIlO != null ? executorServiceIlO : this.tV;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public List<com.bytedance.sdk.component.MY.IlO.MY> tV() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.tV
    public void IlO(int i2) {
    }

    public static void IlO(NV nv) {
        IlO = nv;
    }
}
