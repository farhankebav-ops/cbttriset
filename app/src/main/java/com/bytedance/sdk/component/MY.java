package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import com.bytedance.sdk.component.IlO;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {

    @GuardedBy("sLock")
    private static volatile Handler MY;
    private static final Object IlO = new Object();

    @GuardedBy("sLock")
    private static final LinkedList<Runnable> EO = new LinkedList<>();
    private static Object tV = new Object();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends Handler {
        public IlO(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    MY.EO();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO() {
        LinkedList linkedList;
        synchronized (tV) {
            try {
                synchronized (IlO) {
                    LinkedList<Runnable> linkedList2 = EO;
                    linkedList = (LinkedList) linkedList2.clone();
                    linkedList2.clear();
                    MY().removeMessages(1);
                }
                if (linkedList.size() > 0) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Handler MY() {
        Handler handler;
        if (MY != null) {
            return MY;
        }
        synchronized (IlO) {
            try {
                if (MY == null) {
                    IlO.InterfaceC0046IlO interfaceC0046IlO = com.bytedance.sdk.component.IlO.IlO;
                    HandlerThread safeHandlerThread = interfaceC0046IlO != null ? interfaceC0046IlO.getSafeHandlerThread("queued-work-looper", -2) : null;
                    if (safeHandlerThread == null) {
                        safeHandlerThread = new HandlerThread("queued-work-looper", -2);
                        safeHandlerThread.start();
                    }
                    MY = new IlO(safeHandlerThread.getLooper());
                }
                handler = MY;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public static void IlO(Runnable runnable, boolean z2) {
        try {
            Handler handlerMY = MY();
            synchronized (IlO) {
                try {
                    EO.add(runnable);
                    if (z2) {
                        handlerMY.sendEmptyMessageDelayed(1, 100L);
                    } else {
                        handlerMY.sendEmptyMessage(1);
                    }
                } finally {
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }
}
