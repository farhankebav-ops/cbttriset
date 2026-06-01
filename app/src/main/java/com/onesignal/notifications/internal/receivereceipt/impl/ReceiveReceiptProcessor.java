package com.onesignal.notifications.internal.receivereceipt.impl;

import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ReceiveReceiptProcessor implements IReceiveReceiptProcessor {
    private final INotificationBackendService _backend;
    private final IDeviceService _deviceService;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor", f = "ReceiveReceiptProcessor.kt", l = {21}, m = "sendReceiveReceipt")
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReceiveReceiptProcessor.this.sendReceiveReceipt(null, null, null, this);
        }
    }

    public ReceiveReceiptProcessor(IDeviceService _deviceService, INotificationBackendService _backend) {
        k.e(_deviceService, "_deviceService");
        k.e(_backend, "_backend");
        this._deviceService = _deviceService;
        this._backend = _backend;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendReceiveReceipt(java.lang.String r8, java.lang.String r9, java.lang.String r10, v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1 r0 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1 r0 = new com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            w5.a r0 = w5.a.f17774a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            r2.q.z0(r11)     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            goto L6e
        L29:
            r0 = move-exception
            r8 = r0
            goto L4b
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            r2.q.z0(r11)
            com.onesignal.core.internal.device.IDeviceService r11 = r7._deviceService
            com.onesignal.core.internal.device.IDeviceService$DeviceType r5 = r11.getDeviceType()
            com.onesignal.notifications.internal.backend.INotificationBackendService r1 = r7._backend     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            r6.label = r2     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            r2 = r8
            r4 = r9
            r3 = r10
            java.lang.Object r8 = r1.updateNotificationAsReceived(r2, r3, r4, r5, r6)     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            if (r8 != r0) goto L6e
            return r0
        L4b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Receive receipt failed with statusCode: "
            r9.<init>(r10)
            int r10 = r8.getStatusCode()
            r9.append(r10)
            java.lang.String r10 = " response: "
            r9.append(r10)
            java.lang.String r8 = r8.getResponse()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 2
            r10 = 0
            com.onesignal.debug.internal.logging.Logging.error$default(r8, r10, r9, r10)
        L6e:
            q5.x r8 = q5.x.f13520a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.sendReceiveReceipt(java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }
}
