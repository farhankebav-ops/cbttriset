package i4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11857a = new a("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11858b = new a("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11859c = new a("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList] */
    public static List h(Class cls, Iterable iterable, ClassLoader classLoader, l1 l1Var) {
        ?? Load;
        try {
            Class.forName("android.app.Application", false, classLoader);
            Load = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Class cls2 = (Class) it.next();
                Object objNewInstance = null;
                try {
                    objNewInstance = cls2.asSubclass(cls).getConstructor(null).newInstance(null);
                } catch (ClassCastException unused) {
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
                }
                if (objNewInstance != null) {
                    Load.add(objNewInstance);
                }
            }
        } catch (Exception unused2) {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, classLoader);
            Load = !serviceLoaderLoad.iterator().hasNext() ? ServiceLoader.load(cls) : serviceLoaderLoad;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : Load) {
            if (l1Var.b(obj)) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new k1(l1Var)));
        return Collections.unmodifiableList(arrayList);
    }

    public abstract void a(String str, Throwable th);

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public i4.u b() {
        /*
            r4 = this;
            java.util.List r0 = r4.c()
            r1 = 0
            if (r0 == 0) goto Lf
            int r2 = r0.size()
            r3 = 1
            if (r2 != r3) goto Lf
            goto L10
        Lf:
            r3 = r1
        L10:
            java.lang.String r2 = "%s does not have exactly one group"
            r2.q.G(r0, r2, r3)
            java.lang.Object r0 = r0.get(r1)
            i4.u r0 = (i4.u) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.f.b():i4.u");
    }

    public abstract List c();

    public abstract b d();

    public abstract f e();

    public abstract Object f();

    public abstract void g();

    public abstract void i(int i2, String str);

    public abstract void j(int i2, String str, Object... objArr);

    public abstract void k(n1 n1Var);

    public abstract void l(f1 f1Var);

    public abstract void m();

    public abstract void n();

    public abstract void o(Object obj);

    public abstract void p();

    public abstract void q(x xVar, a1 a1Var);

    public abstract void r(n0 n0Var);

    public abstract void s(List list);
}
