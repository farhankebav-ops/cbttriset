package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageDidDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InAppMessageLifecycleEvent implements IInAppMessageWillDisplayEvent, IInAppMessageWillDismissEvent, IInAppMessageDidDisplayEvent, IInAppMessageDidDismissEvent {
    private final IInAppMessage message;

    public InAppMessageLifecycleEvent(IInAppMessage message) {
        k.e(message, "message");
        this.message = message;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent, com.onesignal.inAppMessages.IInAppMessageWillDismissEvent, com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent, com.onesignal.inAppMessages.IInAppMessageDidDismissEvent
    public IInAppMessage getMessage() {
        return this.message;
    }
}
