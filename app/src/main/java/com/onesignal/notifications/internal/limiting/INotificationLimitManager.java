package com.onesignal.notifications.internal.limiting;

import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationLimitManager {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Constants {
        public static final Constants INSTANCE = new Constants();
        private static final int maxNumberOfNotifications = 49;

        private Constants() {
        }

        public final int getMaxNumberOfNotifications() {
            return maxNumberOfNotifications;
        }
    }

    Object clearOldestOverLimit(int i2, c<? super x> cVar);
}
