package z5;

import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f17985a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        k.b(methods);
        int length = methods.length;
        int i2 = 0;
        while (true) {
            method = null;
            if (i2 >= length) {
                break;
            }
            Method method2 = methods[i2];
            if (k.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                k.d(parameterTypes, "getParameterTypes(...)");
                if (k.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i2++;
        }
        f17985a = method;
        int length2 = methods.length;
        for (int i8 = 0; i8 < length2 && !k.a(methods[i8].getName(), "getSuppressed"); i8++) {
        }
    }
}
