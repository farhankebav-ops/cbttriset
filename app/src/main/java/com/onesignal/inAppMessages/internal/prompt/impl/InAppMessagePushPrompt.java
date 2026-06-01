package com.onesignal.inAppMessages.internal.prompt.impl;

import com.onesignal.inAppMessages.internal.prompt.InAppMessagePromptTypes;
import com.onesignal.notifications.INotificationsManager;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessagePushPrompt extends InAppMessagePrompt {
    private final INotificationsManager _notificationsManager;

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt$handlePrompt$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt", f = "InAppMessagePushPrompt.kt", l = {10}, m = "handlePrompt")
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
            return InAppMessagePushPrompt.this.handlePrompt(this);
        }
    }

    public InAppMessagePushPrompt(INotificationsManager _notificationsManager) {
        k.e(_notificationsManager, "_notificationsManager");
        this._notificationsManager = _notificationsManager;
    }

    @Override // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    public String getPromptKey() {
        return InAppMessagePromptTypes.PUSH_PROMPT_KEY;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handlePrompt(v5.c<? super com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt$handlePrompt$1 r0 = (com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt$handlePrompt$1 r0 = new com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt$handlePrompt$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            r2.q.z0(r5)
            com.onesignal.notifications.INotificationsManager r5 = r4._notificationsManager
            r0.label = r3
            java.lang.Object r5 = r5.requestPermission(r3, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L48
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r5 = com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult.PERMISSION_GRANTED
            return r5
        L48:
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r5 = com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult.PERMISSION_DENIED
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.handlePrompt(v5.c):java.lang.Object");
    }
}
