package com.onesignal.notifications.internal.restoration.impl;

import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import q5.x;
import q6.c0;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationRestoreProcessor implements INotificationRestoreProcessor {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final int DELAY_BETWEEN_NOTIFICATION_RESTORES_MS = 200;
    private final IApplicationService _applicationService;
    private final IBadgeCountUpdater _badgeCountUpdater;
    private final INotificationRepository _dataController;
    private final INotificationGenerationWorkManager _workManager;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor", f = "NotificationRestoreProcessor.kt", l = {25, 28}, m = "process")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRestoreProcessor.this.process(this);
        }
    }

    public NotificationRestoreProcessor(IApplicationService _applicationService, INotificationGenerationWorkManager _workManager, INotificationRepository _dataController, IBadgeCountUpdater _badgeCountUpdater) {
        k.e(_applicationService, "_applicationService");
        k.e(_workManager, "_workManager");
        k.e(_dataController, "_dataController");
        k.e(_badgeCountUpdater, "_badgeCountUpdater");
        this._applicationService = _applicationService;
        this._workManager = _workManager;
        this._dataController = _dataController;
        this._badgeCountUpdater = _badgeCountUpdater;
    }

    private final List<Integer> getVisibleNotifications() {
        StatusBarNotification[] activeNotifications = NotificationHelper.INSTANCE.getActiveNotifications(this._applicationService.getAppContext());
        if (activeNotifications.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            arrayList.add(Integer.valueOf(statusBarNotification.getId()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002e, B:28:0x0067, B:30:0x006d, B:33:0x0082, B:20:0x0040, B:27:0x005f, B:23:0x004d), top: B:38:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object process(v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1 r0 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1 r0 = new com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L44
            if (r2 == r3) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r0.L$0
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor r3 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor) r3
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L32
            goto L67
        L32:
            r7 = move-exception
            goto L88
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor r2 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor) r2
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L32
            goto L5f
        L44:
            r2.q.z0(r7)
            java.lang.String r7 = "Restoring notifications"
            r2 = 0
            com.onesignal.debug.internal.logging.Logging.info$default(r7, r2, r4, r2)
            java.util.List r7 = r6.getVisibleNotifications()     // Catch: java.lang.Throwable -> L32
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r6._dataController     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = r2.listNotificationsForOutstanding(r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r7 != r1) goto L5e
            goto L81
        L5e:
            r2 = r6
        L5f:
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L32
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L32
            r3 = r2
            r2 = r7
        L67:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto L82
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L32
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r7 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r7     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r3     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.Object r7 = r3.processNotification(r7, r5, r0)     // Catch: java.lang.Throwable -> L32
            if (r7 != r1) goto L67
        L81:
            return r1
        L82:
            com.onesignal.notifications.internal.badges.IBadgeCountUpdater r7 = r3._badgeCountUpdater     // Catch: java.lang.Throwable -> L32
            r7.update()     // Catch: java.lang.Throwable -> L32
            goto L8d
        L88:
            java.lang.String r0 = "Error restoring notification records! "
            com.onesignal.debug.internal.logging.Logging.error(r0, r7)
        L8d:
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.process(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor
    public Object processNotification(INotificationRepository.NotificationData notificationData, int i2, v5.c<? super x> cVar) {
        Object objK;
        this._workManager.beginEnqueueingWork(this._applicationService.getAppContext(), notificationData.getId(), notificationData.getAndroidId(), new JSONObject(notificationData.getFullData()), notificationData.getCreatedAt(), true, false);
        return (i2 <= 0 || (objK = c0.k((long) i2, cVar)) != a.f17774a) ? x.f13520a : objK;
    }
}
