package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UpgradeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        if (Build.VERSION.SDK_INT == 24) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "context.applicationContext");
        if (OneSignal.initWithContext(applicationContext)) {
            ((INotificationRestoreWorkManager) OneSignal.INSTANCE.getServices().getService(INotificationRestoreWorkManager.class)).beginEnqueueingWork(context, true);
        }
    }
}
