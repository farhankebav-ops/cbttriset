package com.onesignal.notifications.internal.open.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.onesignal.common.JSONUtils;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationOpenedProcessorHMS implements INotificationOpenedProcessorHMS {
    private final INotificationLifecycleService _lifecycleService;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS", f = "NotificationOpenedProcessorHMS.kt", l = {62, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "handleProcessJsonOpenData")
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
            return NotificationOpenedProcessorHMS.this.handleProcessJsonOpenData(null, null, this);
        }
    }

    public NotificationOpenedProcessorHMS(INotificationLifecycleService _lifecycleService) {
        k.e(_lifecycleService, "_lifecycleService");
        this._lifecycleService = _lifecycleService;
    }

    private final JSONObject covertHMSOpenIntentToJson(Intent intent) {
        if (!NotificationFormatHelper.INSTANCE.isOneSignalIntent(intent)) {
            return null;
        }
        k.b(intent);
        Bundle extras = intent.getExtras();
        JSONUtils jSONUtils = JSONUtils.INSTANCE;
        k.b(extras);
        JSONObject jSONObjectBundleAsJSONObject = jSONUtils.bundleAsJSONObject(extras);
        reformatButtonClickAction(jSONObjectBundleAsJSONObject);
        return jSONObjectBundleAsJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleProcessJsonOpenData(android.app.Activity r7, org.json.JSONObject r8, v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            r2.q.z0(r9)
            goto L7b
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$2
            r8 = r7
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS r2 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS) r2
            r2.q.z0(r9)
            goto L5a
        L45:
            r2.q.z0(r9)
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r9 = r6._lifecycleService
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r5
            java.lang.Object r9 = r9.canOpenNotification(r7, r8, r0)
            if (r9 != r1) goto L59
            goto L7a
        L59:
            r2 = r6
        L5a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L63
            return r3
        L63:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r9 = r2._lifecycleService
            com.onesignal.common.JSONUtils r2 = com.onesignal.common.JSONUtils.INSTANCE
            org.json.JSONArray r8 = r2.wrapInJsonArray(r8)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r7 = r9.notificationOpened(r7, r8, r0)
            if (r7 != r1) goto L7b
        L7a:
            return r1
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.handleProcessJsonOpenData(android.app.Activity, org.json.JSONObject, v5.c):java.lang.Object");
    }

    private final void reformatButtonClickAction(JSONObject jSONObject) {
        try {
            String str = (String) NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject).remove(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID);
            if (str == null) {
                return;
            }
            jSONObject.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS
    public Object handleHMSNotificationOpenIntent(Activity activity, Intent intent, v5.c<? super x> cVar) {
        JSONObject jSONObjectCovertHMSOpenIntentToJson;
        Object objHandleProcessJsonOpenData;
        x xVar = x.f13520a;
        return (intent == null || (jSONObjectCovertHMSOpenIntentToJson = covertHMSOpenIntentToJson(intent)) == null || (objHandleProcessJsonOpenData = handleProcessJsonOpenData(activity, jSONObjectCovertHMSOpenIntentToJson, cVar)) != a.f17774a) ? xVar : objHandleProcessJsonOpenData;
    }
}
