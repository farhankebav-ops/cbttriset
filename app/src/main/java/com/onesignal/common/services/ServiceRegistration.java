package com.onesignal.common.services;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ServiceRegistration<T> {
    private final Set<Class<?>> services = new LinkedHashSet();

    public final Set<Class<?>> getServices() {
        return this.services;
    }

    public final <TService> ServiceRegistration<T> provides(Class<TService> c7) {
        k.e(c7, "c");
        this.services.add(c7);
        return this;
    }

    public abstract Object resolve(IServiceProvider iServiceProvider);

    public final <TService> ServiceRegistration<T> provides() {
        k.k();
        throw null;
    }
}
