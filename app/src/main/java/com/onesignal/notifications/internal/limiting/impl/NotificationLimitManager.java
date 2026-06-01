package com.onesignal.notifications.internal.limiting.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationLimitManager implements INotificationLimitManager {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationSummaryManager _notificationSummaryManager;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager", f = "NotificationLimitManager.kt", l = {21, 23, 30}, m = "clearOldestOverLimit")
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationLimitManager.this.clearOldestOverLimit(0, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager", f = "NotificationLimitManager.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE, 60}, m = "clearOldestOverLimitStandard")
    public static final class C28021 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28021(v5.c<? super C28021> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationLimitManager.this.clearOldestOverLimitStandard(0, this);
        }
    }

    public NotificationLimitManager(INotificationRepository _dataController, IApplicationService _applicationService, INotificationSummaryManager _notificationSummaryManager) {
        k.e(_dataController, "_dataController");
        k.e(_applicationService, "_applicationService");
        k.e(_notificationSummaryManager, "_notificationSummaryManager");
        this._dataController = _dataController;
        this._applicationService = _applicationService;
        this._notificationSummaryManager = _notificationSummaryManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[PHI: r1 r4 r9
  0x00aa: PHI (r1v12 java.util.Iterator) = (r1v5 java.util.Iterator), (r1v14 java.util.Iterator) binds: [B:25:0x00a1, B:41:0x0109] A[DONT_GENERATE, DONT_INLINE]
  0x00aa: PHI (r4v7 int) = (r4v5 int), (r4v9 int) binds: [B:25:0x00a1, B:41:0x0109] A[DONT_GENERATE, DONT_INLINE]
  0x00aa: PHI (r9v8 com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager) = 
  (r9v3 com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager)
  (r9v10 com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager)
 binds: [B:25:0x00a1, B:41:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0100 -> B:38:0x0102). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0105 -> B:40:0x0107). Please report as a decompilation issue!!! */
    @androidx.annotation.RequiresApi(api = 23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearOldestOverLimitStandard(int r18, v5.c<? super q5.x> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimitStandard(int, v5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (clearOldestOverLimitStandard(r6, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        if (r7.clearOldestOverLimitFallback(r6, r2, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.limiting.INotificationLimitManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object clearOldestOverLimit(int r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1 r0 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1 r0 = new com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L35
            r6 = 2
            if (r2 == r6) goto L35
            if (r2 != r3) goto L2d
            r2.q.z0(r7)
            goto L64
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager r2 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager) r2
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L50
            goto L64
        L3f:
            r2.q.z0(r7)
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L4f
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L4f
            r0.label = r4     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r6 = r5.clearOldestOverLimitStandard(r6, r0)     // Catch: java.lang.Throwable -> L4f
            if (r6 != r1) goto L64
            goto L63
        L4f:
            r2 = r5
        L50:
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r2._dataController
            com.onesignal.notifications.internal.limiting.INotificationLimitManager$Constants r2 = com.onesignal.notifications.internal.limiting.INotificationLimitManager.Constants.INSTANCE
            int r2 = r2.getMaxNumberOfNotifications()
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r7.clearOldestOverLimitFallback(r6, r2, r0)
            if (r6 != r1) goto L64
        L63:
            return r1
        L64:
            q5.x r6 = q5.x.f13520a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimit(int, v5.c):java.lang.Object");
    }
}
