package com.onesignal.notifications.internal.receivereceipt.impl;

import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker", f = "ReceiveReceiptWorkManager.kt", l = {85}, m = "doWork")
public final class ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiveReceiptWorkManager.ReceiveReceiptWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1(ReceiveReceiptWorkManager.ReceiveReceiptWorker receiveReceiptWorker, v5.c<? super ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1> cVar) {
        super(cVar);
        this.this$0 = receiveReceiptWorker;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
