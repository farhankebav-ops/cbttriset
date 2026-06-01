package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2094nq implements InterfaceC04603u {
    public Message A00;
    public C2093np A01;

    public C2094nq() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C2093np.A01(this);
    }

    public final C2094nq A01(Message message, C2093np c2093np) {
        this.A00 = message;
        this.A01 = c2093np;
        return this;
    }

    public final void A02() {
        ((Message) C3M.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) C3M.A01(this.A00));
        A00();
        return success;
    }
}
