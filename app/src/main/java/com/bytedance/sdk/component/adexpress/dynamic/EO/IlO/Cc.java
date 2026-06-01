package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements View.OnTouchListener {
    private int Cc;
    private boolean EO;
    private float IlO;
    private float MY;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW tV;

    public Cc(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew, int i2) {
        this.tV = lew;
        this.Cc = i2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.IlO = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.MY = y;
                if (Math.abs(y - this.IlO) > 10.0f) {
                    this.EO = true;
                }
            }
        } else {
            if (!this.EO) {
                return false;
            }
            int iMY = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs(this.MY - this.IlO));
            if (this.MY - this.IlO < 0.0f && iMY > this.Cc && (lew = this.tV) != null) {
                lew.IlO();
                this.IlO = 0.0f;
                this.MY = 0.0f;
                this.EO = false;
            }
        }
        return true;
    }
}
