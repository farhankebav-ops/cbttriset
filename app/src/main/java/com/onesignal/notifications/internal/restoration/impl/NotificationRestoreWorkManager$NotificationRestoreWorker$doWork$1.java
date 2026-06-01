package com.onesignal.notifications.internal.restoration.impl;

import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager;
import com.vungle.ads.internal.protos.Sdk;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker", f = "NotificationRestoreWorkManager.kt", l = {Sdk.SDKMetric.SDKMetricType.APP_BACKGROUND_DURING_AD_LOAD_VALUE}, m = "doWork")
public final class NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRestoreWorkManager.NotificationRestoreWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1(NotificationRestoreWorkManager.NotificationRestoreWorker notificationRestoreWorker, v5.c<? super NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1> cVar) {
        super(cVar);
        this.this$0 = notificationRestoreWorker;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
