package com.bytedance.sdk.component.lEW.IlO;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.vSq;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends vSq implements EO {
    private final HandlerThread MY;

    public MY(HandlerThread handlerThread, vSq.IlO ilO) {
        super(handlerThread.getLooper(), ilO);
        this.MY = handlerThread;
    }

    @Override // com.bytedance.sdk.component.lEW.IlO.EO
    public void IlO() {
        removeCallbacksAndMessages(null);
        WeakReference<vSq.IlO> weakReference = this.IlO;
        if (weakReference != null) {
            weakReference.clear();
            this.IlO = null;
        }
    }

    public void MY() {
        HandlerThread handlerThread = this.MY;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void IlO(vSq.IlO ilO) {
        this.IlO = new WeakReference<>(ilO);
    }
}
