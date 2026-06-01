package com.bytedance.adsdk.ugeno.Bc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends Handler {
    private final WeakReference<IlO> IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(Message message);
    }

    public DmF(Looper looper, IlO ilO) {
        super(looper);
        this.IlO = new WeakReference<>(ilO);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IlO ilO = this.IlO.get();
        if (ilO == null || message == null) {
            return;
        }
        ilO.IlO(message);
    }
}
