package com.onesignal.notifications.receivers;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.services.ADMMessageHandler;
import com.onesignal.notifications.services.ADMMessageHandlerJob;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ADMMessageReceiver extends com.amazon.device.messaging.ADMMessageReceiver {
    public static final Companion Companion = new Companion(null);
    private static final int JOB_ID = 123891;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public ADMMessageReceiver() {
        boolean z2;
        super(ADMMessageHandler.class);
        try {
            Class.forName("com.amazon.device.messaging.ADMMessageHandlerJobBase");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        if (z2) {
            registerJobServiceClass(ADMMessageHandlerJob.class, JOB_ID);
        }
        Logging.debug$default("ADM latest available: " + z2, null, 2, null);
    }
}
