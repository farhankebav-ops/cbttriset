package com.bytedance.sdk.openadsdk.IlO.MY.IlO;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.lEW.es;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO {
    public MY(@NonNull Context context, oeT oet, AdSlot adSlot) {
        super(context, oet, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO
    public void IlO() {
        es esVar = new es(((EO) this).lEW, this.MY, ((EO) this).DmF, this.EV, false);
        this.NV = esVar;
        this.IlO.IlO(esVar.getVideoController());
        EO();
    }

    public com.bytedance.sdk.openadsdk.multipro.MY.IlO MY() {
        xF xFVar = this.NV;
        if (xFVar != null) {
            return ((es) xFVar).getVideoModel();
        }
        return null;
    }
}
