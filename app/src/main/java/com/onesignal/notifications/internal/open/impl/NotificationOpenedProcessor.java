package com.onesignal.notifications.internal.open.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import q5.x;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationOpenedProcessor implements INotificationOpenedProcessor {
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationSummaryManager _summaryManager;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor", f = "NotificationOpenedProcessor.kt", l = {179}, m = "addChildNotifications")
    public static final class AnonymousClass1 extends c {
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
            return NotificationOpenedProcessor.this.addChildNotifications(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor", f = "NotificationOpenedProcessor.kt", l = {191, 192}, m = "markNotificationsConsumed")
    public static final class C28031 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C28031(v5.c<? super C28031> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationOpenedProcessor.this.markNotificationsConsumed(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor", f = "NotificationOpenedProcessor.kt", l = {107, 113, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE}, m = "processIntent")
    public static final class C28041 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C28041(v5.c<? super C28041> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationOpenedProcessor.this.processIntent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor", f = "NotificationOpenedProcessor.kt", l = {150, 169}, m = "processToOpenIntent")
    public static final class C28051 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C28051(v5.c<? super C28051> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationOpenedProcessor.this.processToOpenIntent(null, null, null, this);
        }
    }

    public NotificationOpenedProcessor(INotificationSummaryManager _summaryManager, INotificationRepository _dataController, ConfigModelStore _configModelStore, INotificationLifecycleService _lifecycleService) {
        k.e(_summaryManager, "_summaryManager");
        k.e(_dataController, "_dataController");
        k.e(_configModelStore, "_configModelStore");
        k.e(_lifecycleService, "_lifecycleService");
        this._summaryManager = _summaryManager;
        this._dataController = _dataController;
        this._configModelStore = _configModelStore;
        this._lifecycleService = _lifecycleService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addChildNotifications(org.json.JSONArray r5, java.lang.String r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            r2.q.z0(r7)
            goto L43
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            r2.q.z0(r7)
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r4._dataController
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.listNotificationsForGroup(r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r6 = r7.iterator()
        L49:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L62
            java.lang.Object r7 = r6.next()
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r7 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r7
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r7 = r7.getFullData()
            r0.<init>(r7)
            r5.put(r0)
            goto L49
        L62:
            q5.x r5 = q5.x.f13520a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications(org.json.JSONArray, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clearStatusBarNotifications(Context context, String str, v5.c<? super x> cVar) {
        x xVar = x.f13520a;
        if (str != null) {
            Object objClearNotificationOnSummaryClick = this._summaryManager.clearNotificationOnSummaryClick(str, cVar);
            return objClearNotificationOnSummaryClick == a.f17774a ? objClearNotificationOnSummaryClick : xVar;
        }
        NotificationHelper notificationHelper = NotificationHelper.INSTANCE;
        if (notificationHelper.getGrouplessNotifsCount(context) < 1) {
            notificationHelper.getNotificationManager(context).cancel(NotificationHelper.GROUPLESS_SUMMARY_ID);
        }
        return xVar;
    }

    private final void handleDismissFromActionButtonPress(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            k.b(context);
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, 0));
            if (Build.VERSION.SDK_INT < 31) {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        }
    }

    private final boolean isOneSignalIntent(Intent intent) {
        return intent.hasExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA) || intent.hasExtra("summary") || intent.hasExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r8.markAsConsumed(r9, r3, r4, r5, r6) == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markNotificationsConsumed(android.content.Context r8, android.content.Intent r9, boolean r10, v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.C28031
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.C28031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            w5.a r0 = w5.a.f17774a
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            r2.q.z0(r11)
            goto L8c
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            boolean r10 = r6.Z$0
            java.lang.Object r8 = r6.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$1
            android.content.Intent r9 = (android.content.Intent) r9
            java.lang.Object r1 = r6.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r1 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r1
            r2.q.z0(r11)
            r4 = r8
        L46:
            r3 = r10
            goto L65
        L48:
            r2.q.z0(r11)
            java.lang.String r11 = "summary"
            java.lang.String r11 = r9.getStringExtra(r11)
            r6.L$0 = r7
            r6.L$1 = r9
            r6.L$2 = r11
            r6.Z$0 = r10
            r6.label = r3
            java.lang.Object r8 = r7.clearStatusBarNotifications(r8, r11, r6)
            if (r8 != r0) goto L62
            goto L8b
        L62:
            r1 = r7
            r4 = r11
            goto L46
        L65:
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r1._dataController
            java.lang.String r10 = "androidNotificationId"
            r11 = 0
            int r9 = r9.getIntExtra(r10, r11)
            com.onesignal.core.internal.config.ConfigModelStore r10 = r1._configModelStore
            com.onesignal.common.modeling.Model r10 = r10.getModel()
            com.onesignal.core.internal.config.ConfigModel r10 = (com.onesignal.core.internal.config.ConfigModel) r10
            boolean r5 = r10.getClearGroupOnSummaryClick()
            r10 = 0
            r6.L$0 = r10
            r6.L$1 = r10
            r6.L$2 = r10
            r6.label = r2
            r1 = r8
            r2 = r9
            java.lang.Object r8 = r1.markAsConsumed(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L8c
        L8b:
            return r0
        L8c:
            q5.x r8 = q5.x.f13520a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed(android.content.Context, android.content.Intent, boolean, v5.c):java.lang.Object");
    }

    private final ContentValues newContentValuesWithConsumed(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, false)) {
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, (Integer) 1);
            return contentValues;
        }
        contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, (Integer) 1);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processIntent(android.content.Context r13, android.content.Intent r14, v5.c<? super q5.x> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent(android.content.Context, android.content.Intent, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00db, code lost:
    
        if (r1.addChildNotifications(r11, r12, r2) == r3) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processToOpenIntent(android.content.Context r10, android.content.Intent r11, java.lang.String r12, v5.c<? super com.onesignal.notifications.internal.open.impl.NotificationIntentExtras> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent(android.content.Context, android.content.Intent, java.lang.String, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.open.INotificationOpenedProcessor
    public Object processFromContext(Context context, Intent intent, v5.c<? super x> cVar) throws Throwable {
        boolean zIsOneSignalIntent = isOneSignalIntent(intent);
        x xVar = x.f13520a;
        if (!zIsOneSignalIntent) {
            return xVar;
        }
        handleDismissFromActionButtonPress(context, intent);
        Object objProcessIntent = processIntent(context, intent, cVar);
        return objProcessIntent == a.f17774a ? objProcessIntent : xVar;
    }
}
