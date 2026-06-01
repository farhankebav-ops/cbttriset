package com.onesignal.inAppMessages.internal.prompt.impl;

import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.prompt.InAppMessagePromptTypes;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessagePromptFactory implements IInAppMessagePromptFactory {
    private final ILocationManager _locationManager;
    private final INotificationsManager _notificationsManager;

    public InAppMessagePromptFactory(INotificationsManager _notificationsManager, ILocationManager _locationManager) {
        k.e(_notificationsManager, "_notificationsManager");
        k.e(_locationManager, "_locationManager");
        this._notificationsManager = _notificationsManager;
        this._locationManager = _locationManager;
    }

    @Override // com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory
    public InAppMessagePrompt createPrompt(String promptType) {
        k.e(promptType, "promptType");
        if (promptType.equals(InAppMessagePromptTypes.PUSH_PROMPT_KEY)) {
            return new InAppMessagePushPrompt(this._notificationsManager);
        }
        if (promptType.equals("location")) {
            return new InAppMessageLocationPrompt(this._locationManager);
        }
        return null;
    }
}
