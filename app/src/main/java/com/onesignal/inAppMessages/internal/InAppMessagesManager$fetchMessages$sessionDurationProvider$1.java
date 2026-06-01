package com.onesignal.inAppMessages.internal;

import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessagesManager$fetchMessages$sessionDurationProvider$1 extends l implements e6.a {
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$fetchMessages$sessionDurationProvider$1(InAppMessagesManager inAppMessagesManager) {
        super(0);
        this.this$0 = inAppMessagesManager;
    }

    @Override // e6.a
    public final Long invoke() {
        return Long.valueOf(this.this$0._time.getCurrentTimeMillis() - this.this$0._sessionService.getStartTime());
    }
}
