package com.onesignal.notifications.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class NotificationOpenedActivityBase extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        processIntent$com_onesignal_notifications();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        k.e(intent, "intent");
        super.onNewIntent(intent);
        processIntent$com_onesignal_notifications();
    }

    public void processIntent$com_onesignal_notifications() {
        Context applicationContext = getApplicationContext();
        k.d(applicationContext, "applicationContext");
        if (OneSignal.initWithContext(applicationContext)) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationOpenedActivityBase$processIntent$1(this, null), new NotificationOpenedActivityBase$processIntent$2(this), 1, (Object) null);
        }
    }
}
