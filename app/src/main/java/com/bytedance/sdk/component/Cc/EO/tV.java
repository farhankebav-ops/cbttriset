package com.bytedance.sdk.component.Cc.EO;

import com.bytedance.sdk.component.Cc.EV;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV<T> implements EV {
    private Map<String, String> Bc;
    private int Cc;
    private boolean DmF;
    private T EO;
    private int EV;
    private String IlO;
    private String MY;
    private com.bytedance.sdk.component.Cc.Bc NV;
    private boolean lEW;
    private T tV;
    private int vCE;

    @Override // com.bytedance.sdk.component.Cc.EV
    public int Bc() {
        return this.EV;
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public boolean Cc() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public T EO() {
        return this.tV;
    }

    public tV IlO(EO eo, T t3) {
        this.EO = t3;
        this.IlO = eo.NV();
        this.MY = eo.IlO();
        this.Cc = eo.MY();
        this.vCE = eo.EO();
        this.DmF = eo.ea();
        this.NV = eo.zPa();
        this.EV = eo.cl();
        return this;
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public T MY() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public Map<String, String> tV() {
        return this.Bc;
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public boolean vCE() {
        return this.DmF;
    }

    public tV IlO(EO eo, T t3, Map<String, String> map, boolean z2) {
        this.Bc = map;
        this.lEW = z2;
        return IlO(eo, t3);
    }

    @Override // com.bytedance.sdk.component.Cc.EV
    public String IlO() {
        return this.MY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.Cc.EV
    public void IlO(Object obj) {
        this.tV = this.EO;
        this.EO = obj;
    }
}
