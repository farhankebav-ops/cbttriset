package com.bytedance.adsdk.ugeno.DmF.Cc;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.MY.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO<IlO> {
    private float Aw;
    private float BES;
    private int IlO;
    private float La;
    private int eeU;
    private static final int uF = Color.parseColor("#FFC642");
    private static final int eDn = Color.parseColor("#e3e3e4");

    public MY(Context context) {
        super(context);
        this.IlO = uF;
        this.eeU = eDn;
        this.BES = 4.0f;
        this.La = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public IlO IlO() {
        IlO ilO = new IlO(this.MY);
        ilO.IlO(this);
        return ilO;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        if (oc()) {
            ((IlO) this.Cc).IlO(this.BES, this.IlO, this.eeU, this.La, (int) this.Aw);
        } else {
            ((IlO) this.Cc).IlO(this.BES, this.IlO, this.eeU, this.La, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.IlO = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.eeU = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2, eDn);
                break;
            case "gap":
                this.Aw = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "size":
                this.La = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 20.0f);
                break;
            case "score":
                this.BES = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 4.0f);
                break;
        }
    }
}
