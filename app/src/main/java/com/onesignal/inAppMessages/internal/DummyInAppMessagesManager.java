package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DummyInAppMessagesManager implements IInAppMessagesManager {
    private boolean paused = true;

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addClickListener */
    public void mo3146addClickListener(IInAppMessageClickListener listener) {
        k.e(listener, "listener");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addLifecycleListener */
    public void mo3147addLifecycleListener(IInAppMessageLifecycleListener listener) {
        k.e(listener, "listener");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTrigger */
    public void mo3148addTrigger(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTriggers */
    public void mo3149addTriggers(Map<String, String> triggers) {
        k.e(triggers, "triggers");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        return this.paused;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeClickListener */
    public void mo3151removeClickListener(IInAppMessageClickListener listener) {
        k.e(listener, "listener");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeLifecycleListener */
    public void mo3152removeLifecycleListener(IInAppMessageLifecycleListener listener) {
        k.e(listener, "listener");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTrigger */
    public void mo3153removeTrigger(String key) {
        k.e(key, "key");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTriggers */
    public void mo3154removeTriggers(Collection<String> keys) {
        k.e(keys, "keys");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z2) {
        this.paused = z2;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: clearTriggers */
    public void mo3150clearTriggers() {
    }
}
