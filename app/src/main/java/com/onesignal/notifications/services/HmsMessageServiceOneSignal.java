package com.onesignal.notifications.services;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.bridges.OneSignalHmsEventBridge;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HmsMessageServiceOneSignal extends HmsMessageService {
    /* JADX WARN: Multi-variable type inference failed */
    public void onMessageReceived(RemoteMessage message) {
        k.e(message, "message");
        OneSignalHmsEventBridge.INSTANCE.onMessageReceived((Context) this, message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewToken(String token, Bundle bundle) {
        k.e(token, "token");
        k.e(bundle, "bundle");
        Logging.debug$default("HmsMessageServiceOneSignal onNewToken refresh token:".concat(token), null, 2, null);
        OneSignalHmsEventBridge.INSTANCE.onNewToken((Context) this, token, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewToken(String token) {
        k.e(token, "token");
        Logging.debug$default("HmsMessageServiceOneSignal onNewToken refresh token:".concat(token), null, 2, null);
        OneSignalHmsEventBridge.INSTANCE.onNewToken((Context) this, token);
    }
}
