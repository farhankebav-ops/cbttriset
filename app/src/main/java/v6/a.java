package v6;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q6.w1;
import q6.y;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2.f f17613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2.f f17614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f17615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.f f17616d;
    public static final androidx.camera.camera2.internal.compat.workaround.a e = new androidx.camera.camera2.internal.compat.workaround.a(9);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final androidx.camera.camera2.internal.compat.workaround.a f17617f = new androidx.camera.camera2.internal.compat.workaround.a(10);
    public static final androidx.camera.camera2.internal.compat.workaround.a g = new androidx.camera.camera2.internal.compat.workaround.a(11);

    static {
        int i2 = 5;
        boolean z2 = false;
        f17613a = new e2.f("CLOSED", i2, z2);
        f17614b = new e2.f("UNDEFINED", i2, z2);
        f17615c = new e2.f("REUSABLE_CLAIMED", i2, z2);
        f17616d = new e2.f("NO_THREAD_ELEMENTS", i2, z2);
    }

    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.g(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(s sVar, long j, e6.p pVar) {
        while (true) {
            if (sVar.f17648c >= j && !sVar.d()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f17618a;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            e2.f fVar = f17613a;
            if (obj == fVar) {
                return fVar;
            }
            s sVar2 = (s) ((b) obj);
            if (sVar2 == null) {
                sVar2 = (s) pVar.invoke(Long.valueOf(sVar.f17648c + 1), sVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                    if (atomicReferenceFieldUpdater.get(sVar) != null) {
                        break;
                    }
                }
                if (sVar.d()) {
                    sVar.e();
                }
            }
            sVar = sVar2;
        }
    }

    public static final s c(Object obj) {
        if (obj != f17613a) {
            return (s) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(v5.h hVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = d.f17621a.iterator();
        while (it.hasNext()) {
            try {
                ((y) it.next()).handleException(hVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    a.a.h(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            a.a.h(th, new e(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f17613a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(v5.h hVar, Object obj) {
        if (obj == f17616d) {
            return;
        }
        if (!(obj instanceof w)) {
            Object objFold = hVar.fold(null, f17617f);
            kotlin.jvm.internal.k.c(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            a0.l(objFold);
            throw null;
        }
        w wVar = (w) obj;
        w1[] w1VarArr = wVar.f17654b;
        int length = w1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        w1 w1Var = w1VarArr[length];
        kotlin.jvm.internal.k.b(null);
        Object obj2 = wVar.f17653a[length];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(java.lang.Object r9, v5.c r10) {
        /*
            boolean r0 = r10 instanceof v6.f
            if (r0 == 0) goto Lae
            v6.f r10 = (v6.f) r10
            q6.w r0 = r10.f17623d
            v5.c r1 = r10.e
            java.lang.Throwable r2 = q5.k.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            q6.u r3 = new q6.u
            r4 = 0
            r3.<init>(r4, r2)
        L18:
            v5.h r2 = r1.getContext()
            boolean r2 = r0.isDispatchNeeded(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f17624f = r3
            r10.f13559c = r4
            v5.h r9 = r1.getContext()
            r0.dispatch(r9, r10)
            return
        L2f:
            q6.w0 r0 = q6.x1.a()
            long r5 = r0.f13597a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r10.f17624f = r3
            r10.f13559c = r4
            r0.p(r10)
            goto La8
        L46:
            r0.r(r4)
            v5.h r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            q6.e1 r3 = q6.e1.f13546a     // Catch: java.lang.Throwable -> L69
            v5.f r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L69
            q6.f1 r2 = (q6.f1) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.isActive()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r9 = r2.g()     // Catch: java.lang.Throwable -> L69
            q5.j r9 = r2.q.M(r9)     // Catch: java.lang.Throwable -> L69
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r9 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r10.g     // Catch: java.lang.Throwable -> L69
            v5.h r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = l(r3, r2)     // Catch: java.lang.Throwable -> L69
            e2.f r5 = v6.a.f17616d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            q6.d2 r5 = q6.c0.G(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.resumeWith(r9)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r9 = r5.d0()     // Catch: java.lang.Throwable -> L69
            if (r9 == 0) goto L8d
        L8a:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r9 = r0.t()     // Catch: java.lang.Throwable -> L69
            if (r9 != 0) goto L8d
        L93:
            r0.o(r4)
            goto La8
        L97:
            r9 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.d0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r9     // Catch: java.lang.Throwable -> L69
        La4:
            r10.h(r9)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.o(r4)
            throw r9
        Lae:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.a.h(java.lang.Object, v5.c):void");
    }

    public static final long i(String str, long j, long j3, long j8) {
        String property;
        int i2 = u.f17650a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        Long lP0 = n6.t.p0(property);
        if (lP0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lP0.longValue();
        if (j3 <= jLongValue && jLongValue <= j8) {
            return jLongValue;
        }
        StringBuilder sb = new StringBuilder("System property '");
        sb.append(str);
        sb.append("' should be in range ");
        sb.append(j3);
        androidx.camera.core.processing.util.a.y(sb, "..", j8, ", but is '");
        sb.append(jLongValue);
        sb.append('\'');
        throw new IllegalStateException(sb.toString().toString());
    }

    public static int j(int i2, int i8, String str) {
        return (int) i(str, i2, 1, (i8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object k(v5.h hVar) {
        Object objFold = hVar.fold(0, e);
        kotlin.jvm.internal.k.b(objFold);
        return objFold;
    }

    public static final Object l(v5.h hVar, Object obj) {
        if (obj == null) {
            obj = k(hVar);
        }
        if (obj == 0) {
            return f17616d;
        }
        if (obj instanceof Integer) {
            return hVar.fold(new w(((Number) obj).intValue(), hVar), g);
        }
        a0.l(obj);
        throw null;
    }
}
