package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import s4.p;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"javax.inject.Named"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class SchedulerModule_ProvidesIOSchedulerFactory implements Factory<p> {
    private final SchedulerModule module;

    public SchedulerModule_ProvidesIOSchedulerFactory(SchedulerModule schedulerModule) {
        this.module = schedulerModule;
    }

    public static SchedulerModule_ProvidesIOSchedulerFactory create(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesIOSchedulerFactory(schedulerModule);
    }

    public static p providesIOScheduler(SchedulerModule schedulerModule) {
        return (p) Preconditions.checkNotNullFromProvides(schedulerModule.providesIOScheduler());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public p get() {
        return providesIOScheduler(this.module);
    }
}
