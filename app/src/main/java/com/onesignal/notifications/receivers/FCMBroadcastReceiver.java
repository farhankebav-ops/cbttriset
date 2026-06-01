package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FCMBroadcastReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);
    private static final String FCM_RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
    private static final String FCM_TYPE = "gcm";
    private static final String MESSAGE_TYPE_EXTRA_KEY = "message_type";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isFCMMessage(Intent intent) {
            if (!FCMBroadcastReceiver.FCM_RECEIVE_ACTION.equals(intent.getAction())) {
                return false;
            }
            String stringExtra = intent.getStringExtra("message_type");
            return stringExtra == null || "gcm".equals(stringExtra);
        }

        private Companion() {
        }
    }

    private final void setAbort() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    private final void setSuccessfulResultCode() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null || "google.com/iid".equals(extras.getString("from"))) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "context.applicationContext");
        if (OneSignal.initWithContext(applicationContext)) {
            INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
            if (!Companion.isFCMMessage(intent)) {
                setSuccessfulResultCode();
                return;
            }
            INotificationBundleProcessor.ProcessedBundleResult processedBundleResultProcessBundleFromReceiver = iNotificationBundleProcessor.processBundleFromReceiver(context, extras);
            k.b(processedBundleResultProcessBundleFromReceiver);
            if (processedBundleResultProcessBundleFromReceiver.isWorkManagerProcessing()) {
                setAbort();
            } else {
                setSuccessfulResultCode();
            }
        }
    }
}
