package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import n5.f;
import s4.p;
import t4.b;
import t4.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class SchedulerModule {
    @Provides
    public p providesComputeScheduler() {
        return f.f13071a;
    }

    @Provides
    public p providesIOScheduler() {
        return f.f13072b;
    }

    @Provides
    public p providesMainThreadScheduler() {
        e eVar = b.f17403a;
        if (eVar != null) {
            return eVar;
        }
        throw new NullPointerException("scheduler == null");
    }
}
