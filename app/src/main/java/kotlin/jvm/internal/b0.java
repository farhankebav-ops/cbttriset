package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f12719a;

    static {
        c0 c0Var = null;
        try {
            c0Var = (c0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c0Var == null) {
            c0Var = new c0();
        }
        f12719a = c0Var;
    }

    public static e a(Class cls) {
        f12719a.getClass();
        return new e(cls);
    }

    public static f0 b(Class cls) {
        e eVarA = a(cls);
        List list = Collections.EMPTY_LIST;
        f12719a.getClass();
        return c0.b(eVarA, list);
    }
}
