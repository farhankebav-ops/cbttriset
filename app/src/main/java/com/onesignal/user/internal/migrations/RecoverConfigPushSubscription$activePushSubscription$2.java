package com.onesignal.user.internal.migrations;

import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import e6.a;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RecoverConfigPushSubscription$activePushSubscription$2 extends l implements a {
    final /* synthetic */ RecoverConfigPushSubscription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoverConfigPushSubscription$activePushSubscription$2(RecoverConfigPushSubscription recoverConfigPushSubscription) {
        super(0);
        this.this$0 = recoverConfigPushSubscription;
    }

    @Override // e6.a
    public final SubscriptionModel invoke() {
        Object next;
        Iterator it = this.this$0._subscriptionModelStore.list().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SubscriptionModel) next).getType() == SubscriptionType.PUSH) {
                break;
            }
        }
        return (SubscriptionModel) next;
    }
}
