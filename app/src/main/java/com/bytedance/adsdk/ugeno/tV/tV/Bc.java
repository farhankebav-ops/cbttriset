package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends IlO {
    private float EV;
    private boolean hp;
    private float rp;

    public Bc(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        return IlO(this.MY, (MotionEvent) objArr[0]);
    }

    public boolean IlO(com.bytedance.adsdk.ugeno.MY.EO eo, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.EV = motionEvent.getRawX();
            this.rp = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.EV) >= 15.0f || Math.abs(rawY - this.rp) >= 15.0f) {
                    this.hp = true;
                }
            } else if (action == 3) {
                this.hp = false;
            }
        } else {
            if (this.hp) {
                this.hp = false;
                this.EV = 0.0f;
                this.rp = 0.0f;
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.EV) < 15.0f && Math.abs(rawY2 - this.rp) < 15.0f) {
                com.bytedance.adsdk.ugeno.tV.EV ev = this.IlO;
                if (ev != null) {
                    ev.IlO(eo, this.vCE, this.EO.MY());
                    this.EV = 0.0f;
                    this.rp = 0.0f;
                    return true;
                }
            } else {
                this.hp = false;
            }
        }
        return true;
    }
}
