package l5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2.b f12823a = new j2.b("No further exceptions", 1);

    public static boolean a(AtomicReference atomicReference, Throwable th) {
        while (true) {
            Throwable th2 = (Throwable) atomicReference.get();
            if (th2 == f12823a) {
                return false;
            }
            Throwable bVar = th2 == null ? th : new v4.b(th2, th);
            while (!atomicReference.compareAndSet(th2, bVar)) {
                if (atomicReference.get() != th2) {
                    break;
                }
            }
            return true;
        }
    }

    public static Throwable b(AtomicReference atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        j2.b bVar = f12823a;
        return th != bVar ? (Throwable) atomicReference.getAndSet(bVar) : th;
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
