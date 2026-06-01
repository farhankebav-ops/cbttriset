package com.bytedance.sdk.openadsdk.core.MY;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Bc extends EO {
    private EO EO;
    private final String IlO;
    private final com.bytedance.sdk.openadsdk.core.EV.IlO MY;

    public Bc(String str, com.bytedance.sdk.openadsdk.core.EV.IlO ilO) {
        this(str, ilO, null);
    }

    public void IlO(EO eo) {
        this.EO = eo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.EO, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    public Bc(String str, com.bytedance.sdk.openadsdk.core.EV.IlO ilO, EO eo) {
        this.IlO = str;
        this.MY = ilO;
        this.EO = eo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.EO
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        com.bytedance.sdk.openadsdk.core.EV.IlO ilO = this.MY;
        if (ilO != null) {
            ilO.Cc(this.IlO);
        }
        if (view != null) {
            if (view.getId() == zPa.EO) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == zPa.Bc) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.IlO);
            }
        }
        EO eo = this.EO;
        if (eo != null) {
            eo.pP = this.pP;
            eo.tl = this.tl;
            eo.OOq = this.OOq;
            int i2 = this.OOq;
            eo.wPn = i2;
            eo.oc = i2;
            eo.IlO(view, f4, f8, f9, f10, sparseArray, z2);
        }
    }
}
