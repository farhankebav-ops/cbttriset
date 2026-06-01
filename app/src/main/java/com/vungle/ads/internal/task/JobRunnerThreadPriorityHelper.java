package com.vungle.ads.internal.task;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JobRunnerThreadPriorityHelper implements ThreadPriorityHelper {
    @Override // com.vungle.ads.internal.task.ThreadPriorityHelper
    public int makeAndroidThreadPriority(JobInfo jobInfo) {
        k.e(jobInfo, "jobInfo");
        return Math.min(19, Math.abs(Math.min(0, jobInfo.getPriority() - 2)) + 10);
    }
}
