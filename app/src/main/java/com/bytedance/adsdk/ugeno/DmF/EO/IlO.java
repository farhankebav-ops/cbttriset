package com.bytedance.adsdk.ugeno.DmF.EO;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.DmF.tV.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends EO {
    private int La;

    public IlO(Context context) {
        super(context);
        this.La = ViewCompat.MEASURED_STATE_MASK;
    }

    private String DmF(String str) {
        String strBc = Bc(str);
        return TextUtils.isEmpty(strBc) ? "" : "local://".concat(String.valueOf(strBc));
    }

    public abstract String Bc(String str);

    @Override // com.bytedance.adsdk.ugeno.DmF.tV.EO, com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        if (str.equals("textColor")) {
            this.La = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.tV.EO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        ((EO) this).IlO = DmF(((EO) this).IlO);
        super.MY();
        ((com.bytedance.adsdk.ugeno.DmF.tV.IlO) this.Cc).setColorFilter(this.La);
        ((com.bytedance.adsdk.ugeno.DmF.tV.IlO) this.Cc).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
}
