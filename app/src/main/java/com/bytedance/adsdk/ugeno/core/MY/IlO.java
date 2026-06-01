package com.bytedance.adsdk.ugeno.core.MY;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public String IlO = "GesThrough_";
    private List<MotionEvent> MY = new ArrayList();
    private Set<String> EO = Collections.synchronizedSet(new HashSet());

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, MotionEvent motionEvent) {
        if (eo == null || motionEvent == null) {
            return;
        }
        this.IlO = "GesThrough_" + eo.dY();
        int[] iArr = new int[2];
        eo.EV().getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i8 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.MY.clear();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i2, i8);
        this.MY.add(motionEventObtain);
    }

    public boolean IlO(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        String str = motionEvent.getDownTime() + "_" + pointerId;
        Log.d(this.IlO, "mock event uniqueId: ".concat(String.valueOf(str)));
        return this.EO.contains(str);
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        if (this.MY.isEmpty() || eo == null || eo.EV() == null || eo.EV().getRootView() == null) {
            return;
        }
        final View rootView = eo.EV().getRootView();
        Log.d(this.IlO, "Re-dispatch motionEvents.size(): " + this.MY.size());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.MY.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : IlO.this.MY) {
                    if (motionEvent != null) {
                        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        IlO.this.EO.add(motionEvent.getDownTime() + "_" + pointerId);
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                IlO.this.MY.clear();
            }
        }, 300L);
    }
}
