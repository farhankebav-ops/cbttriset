package com.bytedance.sdk.component.Cc.MY;

import com.bytedance.sdk.component.Cc.Bc;
import com.bytedance.sdk.component.Cc.vCE;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO<T> implements vCE {
    private Bc Cc;
    private T EO;
    Map<String, String> IlO;
    private int MY;
    private String tV;

    public EO(int i2, T t3, String str) {
        this.MY = i2;
        this.EO = t3;
        this.tV = str;
    }

    @Override // com.bytedance.sdk.component.Cc.vCE
    public Map<String, String> Cc() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.Cc.vCE
    public T EO() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.Cc.vCE
    public Bc IlO() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.component.Cc.vCE
    public int MY() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.Cc.vCE
    public String tV() {
        return this.tV;
    }

    public void IlO(Bc bc) {
        this.Cc = bc;
    }

    public EO(int i2, T t3, String str, Map<String, String> map) {
        this(i2, t3, str);
        this.IlO = map;
    }
}
