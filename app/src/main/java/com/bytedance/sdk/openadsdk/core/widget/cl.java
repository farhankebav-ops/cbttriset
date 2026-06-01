package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {
    private int Bc;
    private float Cc;
    private boolean EV;
    private final IlO IlO;
    private float tV;
    private int vCE;
    private final boolean MY = false;
    private boolean EO = false;
    private boolean lEW = true;
    private boolean DmF = false;
    private final View.OnTouchListener NV = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cl.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (cl.this.IlO.vAh()) {
                return !cl.this.EO;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                cl clVar = cl.this;
                clVar.EV = clVar.IlO(motionEvent);
                cl.this.tV = x2;
                cl.this.Cc = y;
                cl.this.vCE = (int) x2;
                cl.this.Bc = (int) y;
                cl.this.lEW = true;
                if (cl.this.IlO != null && cl.this.EO) {
                    cl.this.IlO.IlO(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x2 - cl.this.vCE) > 20.0f || Math.abs(y - cl.this.Bc) > 20.0f) {
                    cl.this.lEW = false;
                }
                cl.this.lEW = true;
                cl.this.DmF = false;
                cl.this.tV = 0.0f;
                cl.this.Cc = 0.0f;
                cl.this.vCE = 0;
                if (cl.this.IlO != null) {
                    cl.this.IlO.IlO(view, cl.this.lEW);
                }
                cl.this.EV = false;
            } else if (action == 3) {
                cl.this.EV = false;
            }
            return !cl.this.EO;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view, boolean z2);

        boolean vAh();
    }

    public cl(IlO ilO) {
        this.IlO = ilO;
    }

    public void IlO(View view) {
        if (view != null) {
            view.setOnTouchListener(this.NV);
        }
    }

    public void IlO(boolean z2) {
        this.EO = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iEO = BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO().getApplicationContext());
        int iCc = BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f4 = iEO;
        if (rawX <= f4 * 0.01f || rawX >= f4 * 0.99f) {
            return true;
        }
        float f8 = iCc;
        return rawY <= 0.01f * f8 || rawY >= f8 * 0.99f;
    }
}
