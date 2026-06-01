package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class CrashlyticsWorkers$Companion$checkBackgroundThread$1 extends j implements e6.a {
    public CrashlyticsWorkers$Companion$checkBackgroundThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
    }

    @Override // e6.a
    public final Boolean invoke() {
        return Boolean.valueOf(((CrashlyticsWorkers.Companion) this.receiver).isBackgroundThread());
    }
}
