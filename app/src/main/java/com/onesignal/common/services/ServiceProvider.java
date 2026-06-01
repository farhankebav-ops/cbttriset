package com.onesignal.common.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceProvider implements IServiceProvider {
    public static final Companion Companion = new Companion(null);
    private static String indent = "";
    private final Map<Class<?>, List<ServiceRegistration<?>>> serviceMap;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getIndent() {
            return ServiceProvider.indent;
        }

        public final void setIndent(String str) {
            k.e(str, "<set-?>");
            ServiceProvider.indent = str;
        }

        private Companion() {
        }
    }

    public ServiceProvider(List<? extends ServiceRegistration<?>> registrations) {
        k.e(registrations, "registrations");
        this.serviceMap = new LinkedHashMap();
        for (ServiceRegistration<?> serviceRegistration : registrations) {
            for (Class<?> cls : serviceRegistration.getServices()) {
                if (this.serviceMap.containsKey(cls)) {
                    List<ServiceRegistration<?>> list = this.serviceMap.get(cls);
                    k.b(list);
                    list.add(serviceRegistration);
                } else {
                    this.serviceMap.put(cls, m.I0(serviceRegistration));
                }
            }
        }
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> List<T> getAllServices(Class<T> c7) {
        ArrayList arrayList;
        k.e(c7, "c");
        synchronized (this.serviceMap) {
            try {
                arrayList = new ArrayList();
                if (this.serviceMap.containsKey(c7)) {
                    Map<Class<?>, List<ServiceRegistration<?>>> map = this.serviceMap;
                    k.b(map);
                    List<ServiceRegistration<?>> list = map.get(c7);
                    k.b(list);
                    for (ServiceRegistration<?> serviceRegistration : list) {
                        Object objResolve = serviceRegistration.resolve(this);
                        if (objResolve == null) {
                            throw new Exception("Could not instantiate service: " + serviceRegistration);
                        }
                        arrayList.add(objResolve);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final <T> List<T> getAllServices$com_onesignal_core() {
        k.k();
        throw null;
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getService(Class<T> c7) throws Exception {
        k.e(c7, "c");
        T t3 = (T) getServiceOrNull(c7);
        if (t3 != null) {
            return t3;
        }
        throw new Exception("Service " + c7 + " could not be instantiated");
    }

    public final <T> T getService$com_onesignal_core() {
        k.k();
        throw null;
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getServiceOrNull(Class<T> c7) {
        T t3;
        ServiceRegistration serviceRegistration;
        k.e(c7, "c");
        synchronized (this.serviceMap) {
            List<ServiceRegistration<?>> list = this.serviceMap.get(c7);
            t3 = (list == null || (serviceRegistration = (ServiceRegistration) l.d1(list)) == null) ? null : (T) serviceRegistration.resolve(this);
        }
        return t3;
    }

    public final <T> T getServiceOrNull$com_onesignal_core() {
        k.k();
        throw null;
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> boolean hasService(Class<T> c7) {
        boolean zContainsKey;
        k.e(c7, "c");
        synchronized (this.serviceMap) {
            zContainsKey = this.serviceMap.containsKey(c7);
        }
        return zContainsKey;
    }

    public final <T> boolean hasService$com_onesignal_core() {
        k.k();
        throw null;
    }
}
