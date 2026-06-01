package com.onesignal.inAppMessages.internal.lifecycle;

import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInAppLifecycleEventHandler {
    void onMessageActionOccurredOnMessage(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult);

    void onMessageActionOccurredOnPreview(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult);

    void onMessagePageChanged(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage);

    void onMessageWasDismissed(InAppMessage inAppMessage);

    void onMessageWasDisplayed(InAppMessage inAppMessage);

    void onMessageWillDismiss(InAppMessage inAppMessage);

    void onMessageWillDisplay(InAppMessage inAppMessage);
}
