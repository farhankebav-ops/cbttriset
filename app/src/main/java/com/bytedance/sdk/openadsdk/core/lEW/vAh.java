package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh extends GestureDetector {
    private final IlO IlO;
    private final com.bytedance.sdk.openadsdk.core.MY.vCE MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends GestureDetector.SimpleOnGestureListener {
        boolean IlO = false;

        public void IlO() {
            this.IlO = false;
        }

        public boolean MY() {
            return this.IlO;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.IlO = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public vAh(Context context) {
        this(context, new IlO());
    }

    public void IlO() {
        this.IlO.IlO();
    }

    public boolean MY() {
        return this.IlO.MY();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.MY.IlO(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public vAh(Context context, IlO ilO) {
        super(context, ilO);
        this.IlO = ilO;
        this.MY = new com.bytedance.sdk.openadsdk.core.MY.vCE();
        setIsLongpressEnabled(false);
    }

    public com.bytedance.sdk.openadsdk.core.model.NV IlO(Context context, View view, View view2) {
        if (this.MY == null) {
            return new NV.IlO().IlO();
        }
        return new NV.IlO().vCE(this.MY.IlO).Cc(this.MY.MY).tV(this.MY.EO).EO(this.MY.tV).MY(this.MY.Cc).IlO(this.MY.vCE).MY(BS.IlO(view)).IlO(BS.IlO(view2)).EO(BS.EO(view)).tV(BS.EO(view2)).tV(this.MY.Bc).Cc(this.MY.lEW).vCE(this.MY.DmF).IlO(this.MY.rp).MY(com.bytedance.sdk.openadsdk.core.DmF.MY().IlO() ? 1 : 2).IlO("vessel").IlO(BS.Bc(context)).EO(BS.DmF(context)).MY(BS.lEW(context)).IlO();
    }
}
