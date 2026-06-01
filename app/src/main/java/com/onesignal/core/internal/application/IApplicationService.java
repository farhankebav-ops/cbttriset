package com.onesignal.core.internal.application;

import android.app.Activity;
import android.content.Context;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IApplicationService {
    void addActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler);

    void addApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler);

    Context getAppContext();

    Activity getCurrent();

    AppEntryAction getEntryState();

    boolean isInForeground();

    void removeActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler);

    void removeApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler);

    void setEntryState(AppEntryAction appEntryAction);

    Object waitUntilActivityReady(c<? super Boolean> cVar);

    Object waitUntilSystemConditionsAvailable(c<? super Boolean> cVar);
}
