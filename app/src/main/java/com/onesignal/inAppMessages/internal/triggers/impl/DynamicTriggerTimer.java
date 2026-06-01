package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.debug.internal.logging.Logging;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DynamicTriggerTimer {
    public static final DynamicTriggerTimer INSTANCE = new DynamicTriggerTimer();

    private DynamicTriggerTimer() {
    }

    public final void scheduleTrigger(TimerTask timerTask, String triggerId, long j) {
        k.e(triggerId, "triggerId");
        Logging.debug$default("scheduleTrigger: " + triggerId + " delay: " + j, null, 2, null);
        new Timer("trigger_timer:".concat(triggerId)).schedule(timerTask, j);
    }
}
