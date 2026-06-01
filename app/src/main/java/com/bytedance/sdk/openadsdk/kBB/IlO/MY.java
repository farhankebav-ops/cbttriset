package com.bytedance.sdk.openadsdk.kBB.IlO;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private final oeT MY;
    private int IlO = EO.MY;
    private final AtomicBoolean EO = new AtomicBoolean(false);
    private final AtomicBoolean tV = new AtomicBoolean(true);
    private final AtomicInteger Cc = new AtomicInteger(0);
    private long vCE = 0;
    private long Bc = 0;
    private final Runnable lEW = new Runnable() { // from class: com.bytedance.sdk.openadsdk.kBB.IlO.MY.3
        @Override // java.lang.Runnable
        public void run() {
            MY.this.tV();
        }
    };

    public MY(oeT oet) {
        this.MY = oet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vCE() {
        if (this.Cc.get() != 1 || this.vCE == 0) {
            return;
        }
        Handler handlerIlO = IlO.IlO();
        if (handlerIlO != null) {
            handlerIlO.removeCallbacks(this.lEW);
        }
        this.Bc = (SystemClock.elapsedRealtime() - this.vCE) + this.Bc;
        this.vCE = 0L;
        this.Cc.set(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        if (this.Cc.get() == 2) {
            this.vCE = SystemClock.elapsedRealtime();
            Handler handlerIlO = IlO.IlO();
            if (handlerIlO != null) {
                handlerIlO.postDelayed(this.lEW, ((long) this.IlO) - this.Bc);
            }
            this.Cc.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        if (this.EO.compareAndSet(false, true)) {
            MY();
            final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.vCE) + this.Bc;
            this.Bc = jElapsedRealtime;
            mmj.EO(new lEW("ev_tracker") { // from class: com.bytedance.sdk.openadsdk.kBB.IlO.MY.1
                @Override // java.lang.Runnable
                public void run() {
                    String strIlO = zLG.IlO(MY.this.MY);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ev_wait_time_server", MY.this.MY.nu() * 1000);
                        jSONObject.put("ev_wait_time_client", jElapsedRealtime);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.oeT.EO("EvTracker", e.getMessage());
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(MY.this.MY, strIlO, MY.this.MY.VVb(), jSONObject);
                }
            });
        }
    }

    public boolean EO() {
        return this.Cc.get() == 3;
    }

    public void IlO() {
        if (this.Cc.get() != 0) {
            return;
        }
        this.IlO = this.MY.nu() * 1000;
        this.Cc.set(1);
        this.vCE = SystemClock.elapsedRealtime();
        Handler handlerIlO = IlO.IlO();
        if (handlerIlO != null) {
            handlerIlO.postDelayed(this.lEW, this.IlO);
        }
    }

    public void MY() {
        this.Cc.set(3);
        Handler handlerIlO = IlO.IlO();
        if (handlerIlO != null) {
            handlerIlO.removeCallbacks(this.lEW);
        }
    }

    public void IlO(final int i2) {
        Handler handlerIlO;
        if (this.Cc.get() == 3 || (handlerIlO = IlO.IlO()) == null) {
            return;
        }
        handlerIlO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.kBB.IlO.MY.2
            @Override // java.lang.Runnable
            public void run() {
                if (i2 == 4 && MY.this.tV.get()) {
                    MY.this.Cc();
                    return;
                }
                int i8 = i2;
                if (i8 == 8) {
                    MY.this.vCE();
                } else if (i8 == 5) {
                    MY.this.tV();
                }
            }
        });
    }

    public void IlO(boolean z2) {
        this.tV.set(z2);
    }
}
