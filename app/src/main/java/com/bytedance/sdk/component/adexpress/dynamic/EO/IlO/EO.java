package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements View.OnTouchListener {
    private int Bc;
    private boolean Cc;
    private boolean DmF;
    private float EO;
    private float IlO;
    private float MY;
    private boolean lEW;
    private float tV;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW vCE;

    public EO(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew) {
        this(lew, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew2;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew3;
        if (this.DmF) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.IlO = motionEvent.getX();
            this.MY = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.tV = motionEvent.getX();
                this.EO = motionEvent.getY();
                if (Math.abs(this.tV - this.IlO) > 10.0f) {
                    this.Cc = true;
                }
                if (Math.abs(this.tV - this.IlO) > 8.0f || Math.abs(this.EO - this.MY) > 8.0f) {
                    this.lEW = false;
                }
                int iMY = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs(this.tV - this.IlO));
                if (this.tV > this.IlO && iMY > this.Bc && (lew3 = this.vCE) != null) {
                    lew3.IlO();
                    this.DmF = true;
                }
            }
        } else {
            if (!this.Cc && !this.lEW) {
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int iMY2 = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs(this.tV - this.IlO));
            if (this.tV > this.IlO && iMY2 > this.Bc && (lew2 = this.vCE) != null) {
                lew2.IlO();
                this.DmF = true;
            }
            float fAbs = Math.abs(x2 - this.IlO);
            float fAbs2 = Math.abs(y - this.MY);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (lew = this.vCE) != null) {
                lew.MY();
                this.DmF = true;
            }
        }
        return true;
    }

    public EO(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew, int i2) {
        this.Bc = 5;
        this.lEW = true;
        this.vCE = lew;
        if (i2 > 0) {
            this.Bc = i2;
        }
    }
}
