package com.onesignal.notifications.internal.registration;

import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IPushRegistrator {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class RegisterResult {
        private final String id;
        private final SubscriptionStatus status;

        public RegisterResult(String str, SubscriptionStatus status) {
            k.e(status, "status");
            this.id = str;
            this.status = status;
        }

        public final String getId() {
            return this.id;
        }

        public final SubscriptionStatus getStatus() {
            return this.status;
        }
    }

    Object registerForPush(c<? super RegisterResult> cVar);
}
