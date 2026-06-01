package com.bytedance.sdk.component.DmF;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends EO {
    private long Bc = -1;
    private final vCE Cc;
    private float DmF;
    private final long EO;
    private final View.OnTouchListener IlO;
    private final int MY;
    private String NV;
    private float lEW;
    private final Context tV;
    private View.OnTouchListener vCE;

    public tV(Context context, View.OnTouchListener onTouchListener, int i2, long j, vCE vce) {
        this.tV = context;
        this.IlO = onTouchListener;
        this.MY = i2;
        this.EO = j;
        this.Cc = vce;
    }

    private boolean IlO(long j) {
        long j3 = this.Bc;
        if (j3 == -1) {
            this.Bc = j;
            return false;
        }
        int i2 = this.MY;
        if (i2 == 1) {
            if (j - j3 <= this.EO) {
                return true;
            }
            this.Bc = j;
            return false;
        }
        if (i2 == 2) {
            if (j - j3 <= this.EO) {
                this.Bc = j;
                return true;
            }
            this.Bc = j;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        tV tVVar;
        int action = motionEvent.getAction();
        motionEvent.getX();
        motionEvent.getY();
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            tVVar = this;
            tVVar.lEW = x2;
            tVVar.DmF = y;
        } else if (action != 1) {
            tVVar = this;
        } else {
            tVVar = this;
            if (tVVar.IlO(x2, y, this.lEW, this.DmF, this.tV)) {
                if (IlO(SystemClock.elapsedRealtime())) {
                    motionEvent.setAction(3);
                    IlO(1, x2, y);
                } else {
                    IlO(0, x2, y);
                }
            }
        }
        View.OnTouchListener onTouchListener = tVVar.IlO;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        View.OnTouchListener onTouchListener2 = tVVar.vCE;
        if (onTouchListener2 != null) {
            onTouchListener2.onTouch(view, motionEvent);
        }
        return false;
    }

    private void IlO(int i2, float f4, float f8) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("is_interceptor", i2);
            jSONObject2.put("click_x", f4);
            jSONObject2.put("click_y", f8);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("lp_click_type", this.MY);
            jSONObject3.put("lp_click_interval", this.EO);
            jSONObject2.put("pag_json_data", jSONObject3.toString());
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable th) {
            oeT.IlO("LpClickIntervalTouchListener", "sendLpClickInterceptEvent", th);
        }
        if (com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY() != null) {
            com.bytedance.sdk.component.DmF.IlO.MY MY = com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY();
            vCE vce = this.Cc;
            MY.IlO(vce != null ? vce.getMaterialMeta() : null, this.NV, "click_interval_intercept", jSONObject);
        }
    }

    public void IlO(String str) {
        this.NV = str;
    }

    @Override // com.bytedance.sdk.component.DmF.EO
    public void IlO(View.OnTouchListener onTouchListener) {
        this.vCE = onTouchListener;
    }
}
