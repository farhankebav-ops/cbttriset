package com.onesignal.user.internal.subscriptions;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum SubscriptionStatus {
    SUBSCRIBED(1),
    NO_PERMISSION(0),
    UNSUBSCRIBE(-2),
    MISSING_JETPACK_LIBRARY(-3),
    MISSING_FIREBASE_FCM_LIBRARY(-4),
    OUTDATED_JETPACK_LIBRARY(-5),
    INVALID_FCM_SENDER_ID(-6),
    OUTDATED_GOOGLE_PLAY_SERVICES_APP(-7),
    FIREBASE_FCM_INIT_ERROR(-8),
    FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE(-9),
    FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER(-11),
    FIREBASE_FCM_ERROR_MISC_EXCEPTION(-12),
    HMS_TOKEN_TIMEOUT(-25),
    HMS_ARGUMENTS_INVALID(-26),
    HMS_API_EXCEPTION_OTHER(-27),
    MISSING_HMS_PUSHKIT_LIBRARY(-28),
    FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED(-29),
    DISABLED_FROM_REST_API_DEFAULT_REASON(-30),
    ERROR(9999);

    public static final Companion Companion = new Companion(null);
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final SubscriptionStatus fromInt(int i2) {
            for (SubscriptionStatus subscriptionStatus : SubscriptionStatus.values()) {
                if (subscriptionStatus.getValue() == i2) {
                    return subscriptionStatus;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    SubscriptionStatus(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
