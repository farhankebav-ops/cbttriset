package com.onesignal.notifications.internal.bundle;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationBundleProcessor {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ProcessedBundleResult {
        private boolean isDeniedByLifecycleCallback;
        private boolean isOneSignalPayload;
        private boolean isWorkManagerProcessing;

        public final boolean isProcessed() {
            return !this.isOneSignalPayload || this.isDeniedByLifecycleCallback || this.isWorkManagerProcessing;
        }

        public final boolean isWorkManagerProcessing() {
            return this.isWorkManagerProcessing;
        }

        public final void setDeniedByLifecycleCallback(boolean z2) {
            this.isDeniedByLifecycleCallback = z2;
        }

        public final void setOneSignalPayload(boolean z2) {
            this.isOneSignalPayload = z2;
        }

        public final void setWorkManagerProcessing(boolean z2) {
            this.isWorkManagerProcessing = z2;
        }
    }

    ProcessedBundleResult processBundleFromReceiver(Context context, Bundle bundle);
}
