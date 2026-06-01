package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.events.IEventNotifier;
import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ITriggerController extends IEventNotifier<ITriggerHandler> {
    boolean evaluateMessageTriggers(InAppMessage inAppMessage);

    boolean isTriggerOnMessage(InAppMessage inAppMessage, Collection<String> collection);

    boolean messageHasOnlyDynamicTriggers(InAppMessage inAppMessage);
}
