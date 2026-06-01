package com.onesignal.inAppMessages.internal.prompt.impl;

import a1.a;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class InAppMessagePrompt {
    private boolean prompted;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OSPromptActionCompletionCallback {
        void onCompleted(PromptActionResult promptActionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum PromptActionResult {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR
    }

    public abstract String getPromptKey();

    public abstract Object handlePrompt(c<? super PromptActionResult> cVar);

    public final boolean hasPrompted() {
        return this.prompted;
    }

    public final void setPrompted(boolean z2) {
        this.prompted = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OSInAppMessagePrompt{key=");
        sb.append(getPromptKey());
        sb.append(" prompted=");
        return a.t(sb, this.prompted, '}');
    }
}
