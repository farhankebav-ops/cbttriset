package com.onesignal.inAppMessages.internal.display;

import com.onesignal.inAppMessages.internal.InAppMessage;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInAppDisplayer {
    void dismissCurrentInAppMessage();

    Object displayMessage(InAppMessage inAppMessage, c<? super Boolean> cVar);

    Object displayPreviewMessage(String str, c<? super Boolean> cVar);
}
