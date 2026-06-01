package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.EO.DmF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements View.OnTouchListener {
    private DmF Cc;
    private long EO;
    private float IlO;
    private float MY;
    private boolean tV;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW vCE;

    public MY(DmF dmF, com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew) {
        this.Cc = dmF;
        this.vCE = lew;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.EO = System.currentTimeMillis();
            this.IlO = motionEvent.getX();
            this.MY = motionEvent.getY();
            this.Cc.Cc();
        } else if (action != 1) {
            if (action == 2) {
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x2 - this.IlO) >= com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), 10.0f) || Math.abs(y - this.MY) >= com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), 10.0f)) {
                    this.tV = true;
                    this.Cc.vCE();
                }
            }
        } else {
            if (this.tV) {
                return false;
            }
            if (System.currentTimeMillis() - this.EO >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew = this.vCE;
                if (lew != null) {
                    lew.IlO();
                }
            } else {
                this.Cc.vCE();
            }
        }
        return true;
    }
}
