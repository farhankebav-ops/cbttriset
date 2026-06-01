package com.onesignal.notifications.internal.display.impl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;
import com.onesignal.notifications.activities.NotificationOpenedActivity;
import com.onesignal.notifications.activities.NotificationOpenedActivityAndroid22AndOlder;
import com.onesignal.notifications.internal.common.NotificationConstants;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IntentGeneratorForAttachingToNotifications {
    private final Context context;
    private final Class<?> notificationOpenedClassAndroid22AndOlder;
    private final Class<?> notificationOpenedClassAndroid23Plus;

    public IntentGeneratorForAttachingToNotifications(Context context) {
        k.e(context, "context");
        this.context = context;
        this.notificationOpenedClassAndroid23Plus = NotificationOpenedActivity.class;
        this.notificationOpenedClassAndroid22AndOlder = NotificationOpenedActivityAndroid22AndOlder.class;
    }

    private final Intent getNewBaseIntentAndroidAPI22AndOlder() {
        Intent intent = new Intent(this.context, this.notificationOpenedClassAndroid22AndOlder);
        intent.addFlags(403177472);
        return intent;
    }

    @RequiresApi(23)
    private final Intent getNewBaseIntentAndroidAPI23Plus() {
        return new Intent(this.context, this.notificationOpenedClassAndroid23Plus);
    }

    public final Context getContext() {
        return this.context;
    }

    public final PendingIntent getNewActionPendingIntent(int i2, Intent oneSignalIntent) {
        k.e(oneSignalIntent, "oneSignalIntent");
        return PendingIntent.getActivity(this.context, i2, oneSignalIntent, 201326592);
    }

    public final Intent getNewBaseIntent(int i2) {
        Intent intentAddFlags = getNewBaseIntentAndroidAPI23Plus().putExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, i2).addFlags(603979776);
        k.d(intentAddFlags, "intent\n            .putE…_CLEAR_TOP,\n            )");
        return intentAddFlags;
    }
}
