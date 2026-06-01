package com.onesignal.inAppMessages;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInAppMessagesManager {
    /* JADX INFO: renamed from: addClickListener */
    void mo3146addClickListener(IInAppMessageClickListener iInAppMessageClickListener);

    /* JADX INFO: renamed from: addLifecycleListener */
    void mo3147addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener);

    /* JADX INFO: renamed from: addTrigger */
    void mo3148addTrigger(String str, String str2);

    /* JADX INFO: renamed from: addTriggers */
    void mo3149addTriggers(Map<String, String> map);

    /* JADX INFO: renamed from: clearTriggers */
    void mo3150clearTriggers();

    boolean getPaused();

    /* JADX INFO: renamed from: removeClickListener */
    void mo3151removeClickListener(IInAppMessageClickListener iInAppMessageClickListener);

    /* JADX INFO: renamed from: removeLifecycleListener */
    void mo3152removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener);

    /* JADX INFO: renamed from: removeTrigger */
    void mo3153removeTrigger(String str);

    /* JADX INFO: renamed from: removeTriggers */
    void mo3154removeTriggers(Collection<String> collection);

    void setPaused(boolean z2);
}
