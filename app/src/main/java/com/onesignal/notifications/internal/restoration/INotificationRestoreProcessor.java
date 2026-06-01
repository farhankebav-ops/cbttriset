package com.onesignal.notifications.internal.restoration;

import com.onesignal.notifications.internal.data.INotificationRepository;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationRestoreProcessor {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object processNotification$default(INotificationRestoreProcessor iNotificationRestoreProcessor, INotificationRepository.NotificationData notificationData, int i2, c cVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processNotification");
            }
            if ((i8 & 2) != 0) {
                i2 = 0;
            }
            return iNotificationRestoreProcessor.processNotification(notificationData, i2, cVar);
        }
    }

    Object process(c<? super x> cVar);

    Object processNotification(INotificationRepository.NotificationData notificationData, int i2, c<? super x> cVar);
}
