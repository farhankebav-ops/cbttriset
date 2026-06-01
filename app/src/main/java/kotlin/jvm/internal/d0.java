package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d0 {
    public static Collection a(Collection collection) {
        if (!(collection instanceof f6.a) || (collection instanceof f6.b)) {
            return collection;
        }
        h(collection, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static List b(List list) {
        if (!(list instanceof f6.a) || (list instanceof f6.c)) {
            return list;
        }
        h(list, "kotlin.collections.MutableList");
        throw null;
    }

    public static Map c(Object obj) {
        if ((obj instanceof f6.a) && !(obj instanceof f6.e)) {
            h(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            k.i(e, d0.class.getName());
            throw e;
        }
    }

    public static void d(int i2, Object obj) {
        if (obj == null || e(i2, obj)) {
            return;
        }
        h(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static boolean e(int i2, Object obj) {
        if (obj instanceof q5.c) {
            if ((obj instanceof h ? ((h) obj).getArity() : obj instanceof e6.a ? 0 : obj instanceof e6.l ? 1 : obj instanceof e6.p ? 2 : obj instanceof e6.q ? 3 : obj instanceof e6.r ? 4 : obj instanceof e6.t ? 6 : -1) == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Object obj) {
        if (obj instanceof Map.Entry) {
            return !(obj instanceof f6.a) || (obj instanceof f6.d);
        }
        return false;
    }

    public static final d7.i g(Object[] array) {
        k.e(array, "array");
        return new d7.i(array);
    }

    public static void h(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a1.a.D(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        k.i(classCastException, d0.class.getName());
        throw classCastException;
    }
}
