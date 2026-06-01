package com.unity3d.services.core.di;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceKey {
    private final c instanceClass;
    private final String named;

    public ServiceKey(String named, c instanceClass) {
        k.e(named, "named");
        k.e(instanceClass, "instanceClass");
        this.named = named;
        this.instanceClass = instanceClass;
    }

    public static /* synthetic */ ServiceKey copy$default(ServiceKey serviceKey, String str, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serviceKey.named;
        }
        if ((i2 & 2) != 0) {
            cVar = serviceKey.instanceClass;
        }
        return serviceKey.copy(str, cVar);
    }

    public final String component1() {
        return this.named;
    }

    public final c component2() {
        return this.instanceClass;
    }

    public final ServiceKey copy(String named, c instanceClass) {
        k.e(named, "named");
        k.e(instanceClass, "instanceClass");
        return new ServiceKey(named, instanceClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceKey)) {
            return false;
        }
        ServiceKey serviceKey = (ServiceKey) obj;
        return k.a(this.named, serviceKey.named) && k.a(this.instanceClass, serviceKey.instanceClass);
    }

    public final c getInstanceClass() {
        return this.instanceClass;
    }

    public final String getNamed() {
        return this.named;
    }

    public int hashCode() {
        return this.instanceClass.hashCode() + (this.named.hashCode() * 31);
    }

    public String toString() {
        return "ServiceKey(named=" + this.named + ", instanceClass=" + this.instanceClass + ')';
    }

    public /* synthetic */ ServiceKey(String str, c cVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, cVar);
    }
}
