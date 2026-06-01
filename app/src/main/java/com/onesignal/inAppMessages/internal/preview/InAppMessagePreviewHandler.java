package com.onesignal.inAppMessages.internal.preview;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessagePreviewHandler implements IBootstrapService, INotificationLifecycleCallback {
    private final IApplicationService _applicationService;
    private final IInAppDisplayer _iamDisplayer;
    private final INotificationActivityOpener _notificationActivityOpener;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationLifecycleService _notificationLifeCycle;
    private final InAppStateService _state;
    private final ITime _time;

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler", f = "InAppMessagePreviewHandler.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE, Sdk.SDKMetric.SDKMetricType.APP_BACKGROUND_DURING_AD_LOAD_VALUE}, m = "canOpenNotification")
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
            return InAppMessagePreviewHandler.this.canOpenNotification(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler", f = "InAppMessagePreviewHandler.kt", l = {40, 46}, m = "canReceiveNotification")
    public static final class C27521 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27521(v5.c<? super C27521> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagePreviewHandler.this.canReceiveNotification(null, this);
        }
    }

    public InAppMessagePreviewHandler(IInAppDisplayer _iamDisplayer, IApplicationService _applicationService, INotificationDisplayer _notificationDisplayer, INotificationActivityOpener _notificationActivityOpener, INotificationLifecycleService _notificationLifeCycle, InAppStateService _state, ITime _time) {
        k.e(_iamDisplayer, "_iamDisplayer");
        k.e(_applicationService, "_applicationService");
        k.e(_notificationDisplayer, "_notificationDisplayer");
        k.e(_notificationActivityOpener, "_notificationActivityOpener");
        k.e(_notificationLifeCycle, "_notificationLifeCycle");
        k.e(_state, "_state");
        k.e(_time, "_time");
        this._iamDisplayer = _iamDisplayer;
        this._applicationService = _applicationService;
        this._notificationDisplayer = _notificationDisplayer;
        this._notificationActivityOpener = _notificationActivityOpener;
        this._notificationLifeCycle = _notificationLifeCycle;
        this._state = _state;
        this._time = _time;
    }

    private final String inAppPreviewPushUUID(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject customJSONObject = NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject);
            if (customJSONObject.has("a") && (jSONObjectOptJSONObject = customJSONObject.optJSONObject("a")) != null && jSONObjectOptJSONObject.has(NotificationConstants.IAM_PREVIEW_KEY)) {
                return jSONObjectOptJSONObject.optString(NotificationConstants.IAM_PREVIEW_KEY);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    @Override // com.onesignal.core.internal.startup.IBootstrapService
    public void bootstrap() {
        this._notificationLifeCycle.setInternalNotificationLifecycleCallback(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (r10 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canOpenNotification(android.app.Activity r8, org.json.JSONObject r9, v5.c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1 r0 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1 r0 = new com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r8 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r8 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r8
            r2.q.z0(r10)
            goto L83
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r9 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r9
            r2.q.z0(r10)
            r10 = r8
            r8 = r9
            goto L6f
        L45:
            r2.q.z0(r10)
            java.lang.String r10 = r7.inAppPreviewPushUUID(r9)
            if (r10 != 0) goto L51
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L51:
            com.onesignal.notifications.internal.INotificationActivityOpener r2 = r7._notificationActivityOpener
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            org.json.JSONArray r9 = r6.put(r9)
            java.lang.String r6 = "JSONArray().put(jsonData)"
            kotlin.jvm.internal.k.d(r9, r6)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r8 = r2.openDestinationActivity(r8, r9, r0)
            if (r8 != r1) goto L6e
            goto L82
        L6e:
            r8 = r7
        L6f:
            com.onesignal.inAppMessages.internal.state.InAppStateService r9 = r8._state
            r9.setInAppMessageIdShowing(r10)
            com.onesignal.inAppMessages.internal.display.IInAppDisplayer r9 = r8._iamDisplayer
            r0.L$0 = r8
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r10 = r9.displayPreviewMessage(r10, r0)
            if (r10 != r1) goto L83
        L82:
            return r1
        L83:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r9 = r10.booleanValue()
            if (r9 != 0) goto L90
            com.onesignal.inAppMessages.internal.state.InAppStateService r8 = r8._state
            r8.setInAppMessageIdShowing(r3)
        L90:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canOpenNotification(android.app.Activity, org.json.JSONObject, v5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r6.displayNotification(r7, r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canReceiveNotification(org.json.JSONObject r6, v5.c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.C27521
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1 r0 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.C27521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1 r0 = new com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            r2.q.z0(r7)
            goto L82
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r6 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r6
            r2.q.z0(r7)
            goto L61
        L3a:
            r2.q.z0(r7)
            java.lang.String r7 = r5.inAppPreviewPushUUID(r6)
            if (r7 != 0) goto L46
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        L46:
            com.onesignal.core.internal.application.IApplicationService r2 = r5._applicationService
            boolean r2 = r2.isInForeground()
            if (r2 == 0) goto L70
            com.onesignal.inAppMessages.internal.state.InAppStateService r6 = r5._state
            r6.setInAppMessageIdShowing(r7)
            com.onesignal.inAppMessages.internal.display.IInAppDisplayer r6 = r5._iamDisplayer
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r6.displayPreviewMessage(r7, r0)
            if (r7 != r1) goto L60
            goto L81
        L60:
            r6 = r5
        L61:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L82
            com.onesignal.inAppMessages.internal.state.InAppStateService r6 = r6._state
            r7 = 0
            r6.setInAppMessageIdShowing(r7)
            goto L82
        L70:
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = new com.onesignal.notifications.internal.common.NotificationGenerationJob
            com.onesignal.core.internal.time.ITime r2 = r5._time
            r7.<init>(r6, r2)
            com.onesignal.notifications.internal.display.INotificationDisplayer r6 = r5._notificationDisplayer
            r0.label = r3
            java.lang.Object r6 = r6.displayNotification(r7, r0)
            if (r6 != r1) goto L82
        L81:
            return r1
        L82:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canReceiveNotification(org.json.JSONObject, v5.c):java.lang.Object");
    }
}
