package com.onesignal.common.services;

import e6.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceBuilder implements IServiceBuilder {
    private final List<ServiceRegistration<?>> registrations = new ArrayList();

    @Override // com.onesignal.common.services.IServiceBuilder
    public ServiceProvider build() {
        return new ServiceProvider(this.registrations);
    }

    @Override // com.onesignal.common.services.IServiceBuilder
    public <T> ServiceRegistration<T> register(Class<T> c7) {
        k.e(c7, "c");
        ServiceRegistrationReflection serviceRegistrationReflection = new ServiceRegistrationReflection(c7);
        this.registrations.add(serviceRegistrationReflection);
        return serviceRegistrationReflection;
    }

    @Override // com.onesignal.common.services.IServiceBuilder
    public <T> ServiceRegistration<T> register(l create) {
        k.e(create, "create");
        ServiceRegistrationLambda serviceRegistrationLambda = new ServiceRegistrationLambda(create);
        this.registrations.add(serviceRegistrationLambda);
        return serviceRegistrationLambda;
    }

    @Override // com.onesignal.common.services.IServiceBuilder
    public <T> ServiceRegistration<T> register(T t3) {
        ServiceRegistrationSingleton serviceRegistrationSingleton = new ServiceRegistrationSingleton(t3);
        this.registrations.add(serviceRegistrationSingleton);
        return serviceRegistrationSingleton;
    }

    public final <T> ServiceRegistration<T> register() {
        k.k();
        throw null;
    }
}
