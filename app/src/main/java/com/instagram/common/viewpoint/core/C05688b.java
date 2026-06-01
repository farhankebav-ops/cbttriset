package com.instagram.common.viewpoint.core;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05688b {
    public static void A00(AudioTrack audioTrack, C05567m c05567m) {
        LogSessionId logSessionIdA00 = c05567m.A00();
        LogSessionId logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        if (!logSessionIdA00.equals(logSessionId)) {
            audioTrack.setLogSessionId(logSessionIdA00);
        }
    }
}
