package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vSq extends Handler {
    protected WeakReference<IlO> IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(Message message);
    }

    public vSq(IlO ilO) {
        if (ilO != null) {
            this.IlO = new WeakReference<>(ilO);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IlO ilO;
        WeakReference<IlO> weakReference = this.IlO;
        if (weakReference == null || (ilO = weakReference.get()) == null || message == null) {
            return;
        }
        ilO.IlO(message);
    }

    public vSq(Looper looper, IlO ilO) {
        super(looper);
        if (ilO != null) {
            this.IlO = new WeakReference<>(ilO);
        }
    }
}
