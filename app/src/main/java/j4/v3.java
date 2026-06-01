package j4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v3 implements c2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12520b = Logger.getLogger(v3.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f12521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f12522d;
    public static final RuntimeException e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f12523f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12524a;

    static {
        Method method;
        Constructor<?> constructor;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                cls.getMethod("sum", null);
                Constructor<?>[] constructors = cls.getConstructors();
                int length = constructors.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        constructor = null;
                        break;
                    }
                    constructor = constructors[i2];
                    if (constructor.getParameterTypes().length == 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                th = null;
            } catch (Throwable th) {
                th = th;
                f12520b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                constructor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            method = null;
        }
        if (th != null || constructor == null) {
            f12521c = null;
            f12522d = null;
            e = new RuntimeException(th);
        } else {
            f12521c = constructor;
            f12522d = method;
            e = null;
        }
        f12523f = new Object[]{1L};
    }

    public v3() {
        RuntimeException runtimeException = e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f12524a = f12521c.newInstance(null);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e8) {
            throw new RuntimeException(e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // j4.c2
    public final void a() {
        try {
            f12522d.invoke(this.f12524a, f12523f);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }
}
