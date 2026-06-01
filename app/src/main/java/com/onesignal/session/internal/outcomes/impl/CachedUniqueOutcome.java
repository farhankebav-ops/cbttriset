package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceChannel;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CachedUniqueOutcome {
    private final InfluenceChannel channel;
    private final String influenceId;

    public CachedUniqueOutcome(String influenceId, InfluenceChannel channel) {
        k.e(influenceId, "influenceId");
        k.e(channel, "channel");
        this.influenceId = influenceId;
        this.channel = channel;
    }

    public final InfluenceChannel getChannel() {
        return this.channel;
    }

    public final String getInfluenceId() {
        return this.influenceId;
    }
}
