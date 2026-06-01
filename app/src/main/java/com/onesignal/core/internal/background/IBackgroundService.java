package com.onesignal.core.internal.background;

import androidx.annotation.WorkerThread;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IBackgroundService {
    @WorkerThread
    Object backgroundRun(c<? super x> cVar);

    Long getScheduleBackgroundRunIn();
}
