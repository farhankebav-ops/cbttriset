package p4;

import com.ironsource.C2300e4;
import e2.i;
import j2.l;
import j2.m;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends m {
    public final i4.f h;

    public a(i4.f fVar) {
        this.h = fVar;
    }

    public static void d(a aVar, boolean z2) {
        for (l lVarZ = m.g.z(aVar); lVarZ != null; lVarZ = lVarZ.f12080b) {
            Thread thread = lVarZ.f12079a;
            if (thread != null) {
                lVarZ.f12079a = null;
                LockSupport.unpark(thread);
            }
        }
        if (z2) {
            aVar.h.a("GrpcFuture was cancelled", null);
        }
        j2.d dVarY = m.g.y(aVar);
        j2.d dVar = null;
        while (dVarY != null) {
            j2.d dVar2 = dVarY.f12069c;
            dVarY.f12069c = dVar;
            dVar = dVarY;
            dVarY = dVar2;
        }
        while (dVar != null) {
            j2.d dVar3 = dVar.f12069c;
            Runnable runnable = dVar.f12067a;
            Objects.requireNonNull(runnable);
            Executor executor = dVar.f12068b;
            Objects.requireNonNull(executor);
            e(runnable, executor);
            dVar = dVar3;
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            m.e.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object f(Object obj) throws ExecutionException {
        if (obj instanceof j2.a) {
            Throwable th = ((j2.a) obj).f12063a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof j2.c) {
            throw new ExecutionException(((j2.c) obj).f12065a);
        }
        if (obj == m.f12081d) {
            return null;
        }
        return obj;
    }

    public static Object g(a aVar) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = aVar.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // j2.q
    public final void addListener(Runnable runnable, Executor executor) {
        j2.d dVar;
        j2.d dVar2 = j2.d.f12066d;
        q.D(runnable, "Runnable was null.");
        q.D(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f12084b) != dVar2) {
            j2.d dVar3 = new j2.d(runnable, executor);
            do {
                dVar3.f12069c = dVar;
                if (m.g.k(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f12084b;
                }
            } while (dVar != dVar2);
        }
        e(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            c(sb, objG);
            sb.append(C2300e4.i.e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(C2300e4.i.e);
        } catch (Exception e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        }
    }

    public final void c(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        j2.a aVar;
        Object obj = this.f12083a;
        if (obj != null) {
            return false;
        }
        if (m.f12082f) {
            aVar = new j2.a(z2, new CancellationException("Future.cancel() was called."));
        } else {
            aVar = z2 ? j2.a.f12061b : j2.a.f12062c;
            Objects.requireNonNull(aVar);
        }
        if (!m.g.l(this, obj, aVar)) {
            return false;
        }
        d(this, z2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x009e -> B:29:0x006b). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(long r18, java.util.concurrent.TimeUnit r20) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.a.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12083a instanceof j2.a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f12083a != null;
    }

    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.f12083a instanceof j2.a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            try {
                i iVarY = a.a.Y(this);
                iVarY.c(this.h, "clientCall");
                string = iVarY.toString();
                if (n7.b.R(string)) {
                    string = null;
                }
            } catch (Throwable th) {
                if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
                    throw th;
                }
                string = "Exception thrown from implementation: " + th.getClass();
            }
            if (string != null) {
                androidx.camera.core.processing.util.a.z(sb, ", info=[", string, C2300e4.i.e);
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                b(sb);
            }
        }
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        l lVar = l.f12078c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f12083a;
            if (obj2 != null) {
                return f(obj2);
            }
            l lVar2 = this.f12085c;
            if (lVar2 != lVar) {
                l lVar3 = new l();
                do {
                    a.a aVar = m.g;
                    aVar.Q(lVar3, lVar2);
                    if (aVar.m(this, lVar2, lVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f12083a;
                            } else {
                                a(lVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return f(obj);
                    }
                    lVar2 = this.f12085c;
                } while (lVar2 != lVar);
            }
            Object obj3 = this.f12083a;
            Objects.requireNonNull(obj3);
            return f(obj3);
        }
        throw new InterruptedException();
    }
}
