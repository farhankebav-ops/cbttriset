package com.onesignal.inAppMessages.internal.state;

import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppStateService {
    private InAppMessagePrompt currentPrompt;
    private String inAppMessageIdShowing;
    private Long lastTimeInAppDismissed;
    private boolean paused;

    public final InAppMessagePrompt getCurrentPrompt() {
        return this.currentPrompt;
    }

    public final String getInAppMessageIdShowing() {
        return this.inAppMessageIdShowing;
    }

    public final Long getLastTimeInAppDismissed() {
        return this.lastTimeInAppDismissed;
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final void setCurrentPrompt(InAppMessagePrompt inAppMessagePrompt) {
        this.currentPrompt = inAppMessagePrompt;
    }

    public final void setInAppMessageIdShowing(String str) {
        this.inAppMessageIdShowing = str;
    }

    public final void setLastTimeInAppDismissed(Long l) {
        this.lastTimeInAppDismissed = l;
    }

    public final void setPaused(boolean z2) {
        this.paused = z2;
    }
}
