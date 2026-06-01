package com.bytedance.sdk.openadsdk.kBB.MY;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private static IlO IlO;
    private static HandlerThread MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends Handler {
        public IlO(Looper looper) {
            super(looper);
        }

        public void IlO(MY my) {
            if (my == null) {
                return;
            }
            int iIntValue = my.EV().intValue();
            if (hasMessages(iIntValue)) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = iIntValue;
            messageObtain.obj = my;
            sendMessageDelayed(messageObtain, my.vCE());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MY my = (MY) message.obj;
            if (my == null) {
                return;
            }
            int iMY = my.MY();
            if (iMY == 1) {
                my.Bc();
            } else {
                if (iMY != 2) {
                    Cc.MY(my.EV());
                    return;
                }
                my.lEW();
            }
            if (my.DmF()) {
                Cc.MY(my.EV());
            } else if (my.rp()) {
                IlO(my);
            }
        }
    }

    public static void IlO() {
    }

    public static void MY(MY my) {
        if (my == null || IlO == null) {
            return;
        }
        try {
            int iIntValue = my.EV().intValue();
            if (IlO.hasMessages(iIntValue)) {
                IlO.removeMessages(iIntValue);
            }
        } catch (Exception unused) {
        }
    }

    public static void IlO(MY my) {
        if (my == null) {
            return;
        }
        MY();
        IlO ilO = IlO;
        if (ilO != null) {
            ilO.IlO(my);
        }
    }

    public static void MY() {
        if (IlO != null) {
            return;
        }
        try {
            HandlerThread handlerThread = MY;
            if (handlerThread != null && handlerThread.isAlive()) {
                return;
            }
            synchronized (Bc.class) {
                try {
                    HandlerThread handlerThread2 = MY;
                    if (handlerThread2 == null || !handlerThread2.isAlive()) {
                        MY = com.bytedance.sdk.component.utils.lEW.IlO("csj_MRC");
                        IlO = new IlO(MY.getLooper());
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            oeT.EO("MRC", th.getMessage());
        }
    }
}
