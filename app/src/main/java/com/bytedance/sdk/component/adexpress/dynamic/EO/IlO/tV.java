package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements View.OnTouchListener {
    private float Bc;
    private boolean Cc = true;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW DmF;
    private float EO;
    private boolean EV;
    private float IlO;
    private float MY;
    private int NV;
    private boolean lEW;
    private float tV;
    private float vCE;

    public tV(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew, int i2, boolean z2) {
        this.DmF = lew;
        this.NV = i2;
        this.EV = z2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew2;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.IlO = motionEvent.getX();
            this.MY = motionEvent.getY();
            this.vCE = motionEvent.getY();
            this.Cc = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.Bc = y;
                if (Math.abs(y - this.vCE) > 10.0f) {
                    this.lEW = true;
                }
                this.tV = motionEvent.getX();
                this.EO = motionEvent.getY();
                if (Math.abs(this.tV - this.IlO) > 8.0f || Math.abs(this.EO - this.MY) > 8.0f) {
                    this.Cc = false;
                }
            }
        } else {
            if (!this.lEW && !this.Cc) {
                return false;
            }
            if (this.EV || (lew3 = this.DmF) == null) {
                int iMY = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs(this.Bc - this.vCE));
                if (this.Bc - this.vCE < 0.0f && iMY > this.NV && (lew2 = this.DmF) != null) {
                    lew2.IlO();
                } else if (this.Cc && (lew = this.DmF) != null) {
                    lew.IlO();
                }
            } else {
                lew3.IlO();
            }
        }
        return true;
    }
}
