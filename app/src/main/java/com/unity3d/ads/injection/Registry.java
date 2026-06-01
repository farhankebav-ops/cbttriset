package com.unity3d.ads.injection;

import e6.a;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.f;
import q5.i;
import r5.s;
import r5.x;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Registry {
    private final q0 _services = x0.c(s.f13639a);

    public static EntryKey factory$default(Registry registry, String named, a instance, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        k.e(named, "named");
        k.e(instance, "instance");
        k.k();
        throw null;
    }

    public static Object get$default(Registry registry, String named, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        k.e(named, "named");
        k.k();
        throw null;
    }

    public static Object getOrNull$default(Registry registry, String named, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        k.e(named, "named");
        k.k();
        throw null;
    }

    public static EntryKey single$default(Registry registry, String named, a instance, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        k.e(named, "named");
        k.e(instance, "instance");
        k.k();
        throw null;
    }

    public final <T> void add(EntryKey key, f instance) {
        d1 d1Var;
        Object value;
        k.e(key, "key");
        k.e(instance, "instance");
        if (getServices().containsKey(key)) {
            throw new IllegalStateException("Cannot have identical entries.");
        }
        q0 q0Var = this._services;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, x.i0((Map) value, x.e0(new i(key, instance)))));
    }

    public final <T> EntryKey factory(String named, a instance) {
        k.e(named, "named");
        k.e(instance, "instance");
        k.k();
        throw null;
    }

    public final <T> T get(String named) {
        k.e(named, "named");
        k.k();
        throw null;
    }

    public final <T> T getOrNull(String named) {
        k.e(named, "named");
        k.k();
        throw null;
    }

    public final Map<EntryKey, f> getServices() {
        return (Map) ((d1) this._services).getValue();
    }

    public final <T> EntryKey single(String named, a instance) {
        k.e(named, "named");
        k.e(instance, "instance");
        k.k();
        throw null;
    }
}
