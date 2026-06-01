package com.bytedance.adsdk.MY.IlO.IlO;

import com.bytedance.adsdk.MY.EO.MY.xF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT implements EO, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> Bc;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> Cc;
    private final List<IlO.InterfaceC0025IlO> EO = new ArrayList();
    private final String IlO;
    private final boolean MY;
    private final xF.IlO tV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> vCE;

    public oeT(com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.xF xFVar) {
        this.IlO = xFVar.IlO();
        this.MY = xFVar.vCE();
        this.tV = xFVar.MY();
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = xFVar.tV().IlO();
        this.Cc = IlO;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO2 = xFVar.EO().IlO();
        this.vCE = IlO2;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO3 = xFVar.Cc().IlO();
        this.Bc = IlO3;
        ilO.IlO(IlO);
        ilO.IlO(IlO2);
        ilO.IlO(IlO3);
        IlO.IlO(this);
        IlO2.IlO(this);
        IlO3.IlO(this);
    }

    public com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> Cc() {
        return this.Bc;
    }

    public com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> EO() {
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
    }

    public xF.IlO MY() {
        return this.tV;
    }

    public com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> tV() {
        return this.vCE;
    }

    public boolean vCE() {
        return this.MY;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        for (int i2 = 0; i2 < this.EO.size(); i2++) {
            this.EO.get(i2).IlO();
        }
    }

    public void IlO(IlO.InterfaceC0025IlO interfaceC0025IlO) {
        this.EO.add(interfaceC0025IlO);
    }
}
