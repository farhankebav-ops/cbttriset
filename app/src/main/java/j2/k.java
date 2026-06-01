package j2;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Unsafe f12074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f12075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f12076d;
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f12077f;
    public static final long g;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new j());
            }
            try {
                f12076d = unsafe.objectFieldOffset(m.class.getDeclaredField("c"));
                f12075c = unsafe.objectFieldOffset(m.class.getDeclaredField("b"));
                e = unsafe.objectFieldOffset(m.class.getDeclaredField("a"));
                f12077f = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                g = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                f12074b = unsafe;
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException(e4);
            }
        } catch (PrivilegedActionException e8) {
            throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
        }
    }

    public static /* synthetic */ Unsafe b0() throws IllegalAccessException {
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }

    @Override // a.a
    public final void Q(l lVar, l lVar2) {
        f12074b.putObject(lVar, g, lVar2);
    }

    @Override // a.a
    public final void R(l lVar, Thread thread) {
        f12074b.putObject(lVar, f12077f, thread);
    }

    @Override // a.a
    public final boolean k(p4.a aVar, d dVar, d dVar2) {
        return g.a(f12074b, aVar, f12075c, dVar, dVar2);
    }

    @Override // a.a
    public final boolean l(m mVar, Object obj, Object obj2) {
        return h.a(f12074b, mVar, e, obj, obj2);
    }

    @Override // a.a
    public final boolean m(m mVar, l lVar, l lVar2) {
        return i.a(f12074b, mVar, f12076d, lVar, lVar2);
    }

    @Override // a.a
    public final d y(p4.a aVar) {
        d dVar;
        d dVar2 = d.f12066d;
        do {
            dVar = aVar.f12084b;
            if (dVar2 == dVar) {
                break;
            }
        } while (!k(aVar, dVar, dVar2));
        return dVar;
    }

    @Override // a.a
    public final l z(p4.a aVar) {
        l lVar;
        l lVar2 = l.f12078c;
        do {
            lVar = aVar.f12085c;
            if (lVar2 == lVar) {
                break;
            }
        } while (!m(aVar, lVar, lVar2));
        return lVar;
    }
}
