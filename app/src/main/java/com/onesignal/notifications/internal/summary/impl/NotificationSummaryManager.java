package com.onesignal.notifications.internal.summary.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import q5.x;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationSummaryManager implements INotificationSummaryManager {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationRestoreProcessor _notificationRestoreProcessor;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;
    private final ITime _time;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", l = {99, 109, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "clearNotificationOnSummaryClick")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationSummaryManager.this.clearNotificationOnSummaryClick(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", l = {44, 48, Sdk.SDKMetric.SDKMetricType.AD_START_TO_BACKGROUND_DURATION_MS_VALUE, ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL, 81}, m = "internalUpdateSummaryNotificationAfterChildRemoved")
    public static final class C28141 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C28141(v5.c<? super C28141> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationSummaryManager.this.internalUpdateSummaryNotificationAfterChildRemoved(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", l = {88, 90}, m = "restoreSummary")
    public static final class C28151 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28151(v5.c<? super C28151> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationSummaryManager.this.restoreSummary(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", l = {25, 28}, m = "updatePossibleDependentSummaryOnDismiss")
    public static final class C28161 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28161(v5.c<? super C28161> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationSummaryManager.this.updatePossibleDependentSummaryOnDismiss(0, this);
        }
    }

    public NotificationSummaryManager(IApplicationService _applicationService, INotificationRepository _dataController, ISummaryNotificationDisplayer _summaryNotificationDisplayer, ConfigModelStore _configModelStore, INotificationRestoreProcessor _notificationRestoreProcessor, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_dataController, "_dataController");
        k.e(_summaryNotificationDisplayer, "_summaryNotificationDisplayer");
        k.e(_configModelStore, "_configModelStore");
        k.e(_notificationRestoreProcessor, "_notificationRestoreProcessor");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._dataController = _dataController;
        this._summaryNotificationDisplayer = _summaryNotificationDisplayer;
        this._configModelStore = _configModelStore;
        this._notificationRestoreProcessor = _notificationRestoreProcessor;
        this._time = _time;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (r13.updateSummaryNotification(r15, r6) == r0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object internalUpdateSummaryNotificationAfterChildRemoved(java.lang.String r13, boolean r14, v5.c<? super q5.x> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved(java.lang.String, boolean, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object restoreSummary(java.lang.String r11, v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.C28151
            if (r0 == 0) goto L13
            r0 = r12
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.C28151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r11 = r0.L$1
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r2 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r2
            r2.q.z0(r12)
            goto L5b
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            java.lang.Object r11 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r11 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r11
            r2.q.z0(r12)
            goto L53
        L42:
            r2.q.z0(r12)
            com.onesignal.notifications.internal.data.INotificationRepository r12 = r10._dataController
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r12 = r12.listNotificationsForGroup(r11, r0)
            if (r12 != r1) goto L52
            goto L7a
        L52:
            r11 = r10
        L53:
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r12 = r12.iterator()
            r2 = r11
            r11 = r12
        L5b:
            r7 = r0
        L5c:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L7b
            java.lang.Object r12 = r11.next()
            r5 = r12
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r5 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r5
            com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor r4 = r2._notificationRestoreProcessor
            r7.L$0 = r2
            r7.L$1 = r11
            r7.label = r3
            r6 = 0
            r8 = 2
            r9 = 0
            java.lang.Object r12 = com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.DefaultImpls.processNotification$default(r4, r5, r6, r7, r8, r9)
            if (r12 != r1) goto L5c
        L7a:
            return r1
        L7b:
            q5.x r11 = q5.x.f13520a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.restoreSummary(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object clearNotificationOnSummaryClick(java.lang.String r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.clearNotificationOnSummaryClick(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updatePossibleDependentSummaryOnDismiss(int r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.C28161
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.C28161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3c
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            r2.q.z0(r8)
            goto L5d
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r7 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r7
            r2.q.z0(r8)
            goto L4d
        L3c:
            r2.q.z0(r8)
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r6._dataController
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r8.getGroupId(r7, r0)
            if (r8 != r1) goto L4c
            goto L5c
        L4c:
            r7 = r6
        L4d:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L5d
            r2 = 0
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.internalUpdateSummaryNotificationAfterChildRemoved(r8, r5, r0)
            if (r7 != r1) goto L5d
        L5c:
            return r1
        L5d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss(int, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    public Object updateSummaryNotificationAfterChildRemoved(String str, boolean z2, v5.c<? super x> cVar) throws Throwable {
        Object objInternalUpdateSummaryNotificationAfterChildRemoved = internalUpdateSummaryNotificationAfterChildRemoved(str, z2, cVar);
        return objInternalUpdateSummaryNotificationAfterChildRemoved == a.f17774a ? objInternalUpdateSummaryNotificationAfterChildRemoved : x.f13520a;
    }
}
