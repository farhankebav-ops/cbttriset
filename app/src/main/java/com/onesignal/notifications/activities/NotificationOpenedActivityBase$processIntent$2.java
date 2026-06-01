package com.onesignal.notifications.activities;

import com.onesignal.common.AndroidUtils;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationOpenedActivityBase$processIntent$2 extends l implements e6.a {
    final /* synthetic */ NotificationOpenedActivityBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationOpenedActivityBase$processIntent$2(NotificationOpenedActivityBase notificationOpenedActivityBase) {
        super(0);
        this.this$0 = notificationOpenedActivityBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m3161invoke$lambda0(NotificationOpenedActivityBase this$0) {
        k.e(this$0, "this$0");
        AndroidUtils.INSTANCE.finishSafely(this$0);
    }

    @Override // e6.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3162invoke();
        return x.f13520a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3162invoke() {
        final NotificationOpenedActivityBase notificationOpenedActivityBase = this.this$0;
        notificationOpenedActivityBase.runOnUiThread(new Runnable() { // from class: com.onesignal.notifications.activities.a
            @Override // java.lang.Runnable
            public final void run() {
                NotificationOpenedActivityBase$processIntent$2.m3161invoke$lambda0(notificationOpenedActivityBase);
            }
        });
    }
}
