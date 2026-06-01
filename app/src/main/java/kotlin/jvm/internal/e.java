package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements l6.c, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f12720b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f12721a;

    static {
        int i2 = 0;
        List listH0 = r5.m.H0(e6.a.class, e6.l.class, e6.p.class, e6.q.class, e6.r.class, e6.s.class, e6.t.class, e6.u.class, e6.v.class, e6.w.class, e6.b.class, e6.c.class, e6.d.class, e6.e.class, e6.f.class, e6.g.class, e6.h.class, e6.i.class, e6.j.class, e6.k.class, e6.m.class, e6.n.class, e6.o.class);
        ArrayList arrayList = new ArrayList(r5.n.L0(listH0, 10));
        for (Object obj : listH0) {
            int i8 = i2 + 1;
            if (i2 < 0) {
                r5.m.K0();
                throw null;
            }
            arrayList.add(new q5.i((Class) obj, Integer.valueOf(i2)));
            i2 = i8;
        }
        f12720b = r5.x.m0(arrayList);
    }

    public e(Class jClass) {
        k.e(jClass, "jClass");
        this.f12721a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f12721a;
    }

    public final String e() {
        String strF;
        Class jClass = this.f12721a;
        k.e(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        if (!jClass.isArray()) {
            String strF2 = k.f(jClass.getName());
            return strF2 == null ? jClass.getCanonicalName() : strF2;
        }
        Class<?> componentType = jClass.getComponentType();
        if (componentType.isPrimitive() && (strF = k.f(componentType.getName())) != null) {
            strConcat = strF.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && a.a.C(this).equals(a.a.C((l6.c) obj));
    }

    public final String f() {
        String strJ;
        Class jClass = this.f12721a;
        k.e(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            if (!jClass.isArray()) {
                String strJ2 = k.j(jClass.getName());
                return strJ2 == null ? jClass.getSimpleName() : strJ2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (strJ = k.j(componentType.getName())) != null) {
                strConcat = strJ.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return n6.m.N0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return n6.m.M0('$', simpleName, simpleName);
        }
        return n6.m.N0(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean g(Object obj) {
        Class jClass = this.f12721a;
        k.e(jClass, "jClass");
        Map map = f12720b;
        k.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return d0.e(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = a.a.C(b0.a(jClass));
        }
        return jClass.isInstance(obj);
    }

    public final int hashCode() {
        return a.a.C(this).hashCode();
    }

    public final String toString() {
        return this.f12721a + " (Kotlin reflection is not available)";
    }
}
