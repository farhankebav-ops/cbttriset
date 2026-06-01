package com.onesignal.common.services;

import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceRegistrationLambda<T> extends ServiceRegistration<T> {
    private final l create;
    private T obj;

    public ServiceRegistrationLambda(l create) {
        k.e(create, "create");
        this.create = create;
    }

    @Override // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider provider) {
        k.e(provider, "provider");
        T t3 = this.obj;
        if (t3 != null) {
            return t3;
        }
        T t7 = (T) this.create.invoke(provider);
        this.obj = t7;
        return t7;
    }
}
