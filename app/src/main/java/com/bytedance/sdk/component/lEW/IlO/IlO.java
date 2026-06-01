package com.bytedance.sdk.component.lEW.IlO;

import android.os.Handler;
import com.bytedance.sdk.component.utils.lEW;
import com.bytedance.sdk.component.utils.vSq;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private final tV<MY> IlO;
    private Handler MY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.lEW.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0058IlO {
        private static final IlO IlO = new IlO();
    }

    public Handler MY() {
        if (this.MY == null) {
            synchronized (IlO.class) {
                try {
                    if (this.MY == null) {
                        this.MY = IlO("csj_io_handler");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.MY;
    }

    private IlO() {
        this.IlO = tV.IlO(2);
    }

    public static IlO IlO() {
        return C0058IlO.IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final Handler handler, final Handler handler2) {
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
        } else {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.lEW.IlO.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.IlO(handler, handler2);
                }
            }, 1000L);
        }
    }

    private MY MY(vSq.IlO ilO, String str) {
        return new MY(lEW.IlO(str), ilO);
    }

    public vSq IlO(vSq.IlO ilO, final String str) {
        MY my = (MY) this.IlO.IlO();
        if (my != null) {
            my.IlO(ilO);
            my.post(new Runnable() { // from class: com.bytedance.sdk.component.lEW.IlO.IlO.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return my;
        }
        return MY(ilO, str);
    }

    public vSq IlO(String str) {
        return IlO((vSq.IlO) null, str);
    }

    public boolean IlO(vSq vsq) {
        if (!(vsq instanceof MY)) {
            return false;
        }
        MY my = (MY) vsq;
        if (this.IlO.IlO(my)) {
            return true;
        }
        my.MY();
        return true;
    }
}
