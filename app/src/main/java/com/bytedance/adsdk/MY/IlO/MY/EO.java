package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.MY.IlO.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements IlO.InterfaceC0025IlO {
    private boolean Bc = true;
    private final IlO<Float, Float> Cc;
    private final IlO<Float, Float> EO;
    private final IlO.InterfaceC0025IlO IlO;
    private final IlO<Integer, Integer> MY;
    private final IlO<Float, Float> tV;
    private final IlO<Float, Float> vCE;

    public EO(IlO.InterfaceC0025IlO interfaceC0025IlO, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.Cc.NV nv) {
        this.IlO = interfaceC0025IlO;
        IlO<Integer, Integer> IlO = nv.IlO().IlO();
        this.MY = IlO;
        IlO.IlO(this);
        ilO.IlO(IlO);
        IlO<Float, Float> IlO2 = nv.MY().IlO();
        this.EO = IlO2;
        IlO2.IlO(this);
        ilO.IlO(IlO2);
        IlO<Float, Float> IlO3 = nv.EO().IlO();
        this.tV = IlO3;
        IlO3.IlO(this);
        ilO.IlO(IlO3);
        IlO<Float, Float> IlO4 = nv.tV().IlO();
        this.Cc = IlO4;
        IlO4.IlO(this);
        ilO.IlO(IlO4);
        IlO<Float, Float> IlO5 = nv.Cc().IlO();
        this.vCE = IlO5;
        IlO5.IlO(this);
        ilO.IlO(IlO5);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.Bc = true;
        this.IlO.IlO();
    }

    public void IlO(Paint paint) {
        if (this.Bc) {
            this.Bc = false;
            double dFloatValue = ((double) this.tV.Bc().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.Cc.Bc().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.MY.Bc().intValue();
            paint.setShadowLayer(this.vCE.Bc().floatValue(), fSin, fCos, Color.argb(Math.round(this.EO.Bc().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
