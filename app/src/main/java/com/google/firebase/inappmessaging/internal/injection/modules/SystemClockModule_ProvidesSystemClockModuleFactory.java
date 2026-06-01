package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class SystemClockModule_ProvidesSystemClockModuleFactory implements Factory<Clock> {
    private final SystemClockModule module;

    public SystemClockModule_ProvidesSystemClockModuleFactory(SystemClockModule systemClockModule) {
        this.module = systemClockModule;
    }

    public static SystemClockModule_ProvidesSystemClockModuleFactory create(SystemClockModule systemClockModule) {
        return new SystemClockModule_ProvidesSystemClockModuleFactory(systemClockModule);
    }

    public static Clock providesSystemClockModule(SystemClockModule systemClockModule) {
        return (Clock) Preconditions.checkNotNullFromProvides(systemClockModule.providesSystemClockModule());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public Clock get() {
        return providesSystemClockModule(this.module);
    }
}
