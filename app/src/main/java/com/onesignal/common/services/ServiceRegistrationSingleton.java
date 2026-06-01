package com.onesignal.common.services;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceRegistrationSingleton<T> extends ServiceRegistration<T> {
    private T obj;

    public ServiceRegistrationSingleton(T t3) {
        this.obj = t3;
    }

    @Override // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider provider) {
        k.e(provider, "provider");
        return this.obj;
    }
}
