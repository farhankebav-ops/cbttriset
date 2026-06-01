package com.ironsource;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L f7071a = new L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f7072b = new HashMap<>();

    private L() {
    }

    public final HashMap<String, Long> a() {
        return f7072b;
    }

    public final long b(String instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        Long l = f7072b.get(instance);
        if (l != null) {
            return System.currentTimeMillis() - l.longValue();
        }
        return -1L;
    }

    public final long c(String instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        Long l = f7072b.get(instance);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    public final boolean a(String instance, long j) {
        kotlin.jvm.internal.k.e(instance, "instance");
        if (instance.length() == 0) {
            return false;
        }
        HashMap<String, Long> map = f7072b;
        if (map.containsKey(instance)) {
            return false;
        }
        map.put(instance, Long.valueOf(j));
        return true;
    }

    public final boolean a(String instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        HashMap<String, Long> map = f7072b;
        if (map.get(instance) == null) {
            return false;
        }
        map.remove(instance);
        return true;
    }
}
