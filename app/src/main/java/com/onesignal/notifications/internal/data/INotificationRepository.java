package com.onesignal.notifications.internal.data;

import java.util.List;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationRepository {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object listNotificationsForOutstanding$default(INotificationRepository iNotificationRepository, List list, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listNotificationsForOutstanding");
            }
            if ((i2 & 1) != 0) {
                list = null;
            }
            return iNotificationRepository.listNotificationsForOutstanding(list, cVar);
        }

        public static /* synthetic */ Object markAsConsumed$default(INotificationRepository iNotificationRepository, int i2, boolean z2, String str, boolean z7, c cVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAsConsumed");
            }
            if ((i8 & 4) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i8 & 8) != 0) {
                z7 = true;
            }
            return iNotificationRepository.markAsConsumed(i2, z2, str2, z7, cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NotificationData {
        private final int androidId;
        private final long createdAt;
        private final String fullData;
        private final String id;
        private final String message;
        private final String title;

        public NotificationData(int i2, String id, String fullData, long j, String str, String str2) {
            k.e(id, "id");
            k.e(fullData, "fullData");
            this.androidId = i2;
            this.id = id;
            this.fullData = fullData;
            this.createdAt = j;
            this.title = str;
            this.message = str2;
        }

        public final int getAndroidId() {
            return this.androidId;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final String getFullData() {
            return this.fullData;
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    Object clearOldestOverLimitFallback(int i2, int i8, c<? super x> cVar);

    Object createNotification(String str, String str2, String str3, boolean z2, boolean z7, int i2, String str4, String str5, long j, String str6, c<? super x> cVar);

    Object createSummaryNotification(int i2, String str, c<? super x> cVar);

    Object deleteExpiredNotifications(c<? super x> cVar);

    Object doesNotificationExist(String str, c<? super Boolean> cVar);

    Object getAndroidIdForGroup(String str, boolean z2, c<? super Integer> cVar);

    Object getAndroidIdFromCollapseKey(String str, c<? super Integer> cVar);

    Object getGroupId(int i2, c<? super String> cVar);

    Object listNotificationsForGroup(String str, c<? super List<NotificationData>> cVar);

    Object listNotificationsForOutstanding(List<Integer> list, c<? super List<NotificationData>> cVar);

    Object markAsConsumed(int i2, boolean z2, String str, boolean z7, c<? super x> cVar);

    Object markAsDismissed(int i2, c<? super Boolean> cVar);

    Object markAsDismissedForGroup(String str, c<? super x> cVar);

    Object markAsDismissedForOutstanding(c<? super x> cVar);
}
