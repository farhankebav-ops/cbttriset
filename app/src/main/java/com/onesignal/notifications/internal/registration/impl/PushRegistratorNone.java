package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushRegistratorNone implements IPushRegistrator, IPushRegistratorCallback {
    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, c<? super x> cVar) {
        return x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(c<? super IPushRegistrator.RegisterResult> cVar) {
        return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.ERROR);
    }
}
