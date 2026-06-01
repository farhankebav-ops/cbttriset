package com.onesignal.inAppMessages.internal.backend;

import com.onesignal.inAppMessages.internal.InAppMessageContent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetIAMDataResponse {
    private final InAppMessageContent content;
    private final boolean shouldRetry;

    public GetIAMDataResponse(InAppMessageContent inAppMessageContent, boolean z2) {
        this.content = inAppMessageContent;
        this.shouldRetry = z2;
    }

    public final InAppMessageContent getContent() {
        return this.content;
    }

    public final boolean getShouldRetry() {
        return this.shouldRetry;
    }
}
