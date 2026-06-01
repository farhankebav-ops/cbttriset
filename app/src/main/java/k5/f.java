package k5;

import java.util.concurrent.atomic.AtomicReference;
import s6.s;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f[] f12708b;

    static {
        f fVar = new f("CANCELLED", 0);
        f12707a = fVar;
        f12708b = new f[]{fVar};
    }

    public static void a(AtomicReference atomicReference) {
        o7.b bVar;
        o7.b bVar2 = (o7.b) atomicReference.get();
        f fVar = f12707a;
        if (bVar2 == fVar || (bVar = (o7.b) atomicReference.getAndSet(fVar)) == fVar || bVar == null) {
            return;
        }
        bVar.cancel();
    }

    public static boolean b(AtomicReference atomicReference, o7.b bVar) {
        z4.b.a(bVar, "s is null");
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                bVar.cancel();
                if (atomicReference.get() == f12707a) {
                    return false;
                }
                n7.b.F(new s("Subscription already set!"));
                return false;
            }
        }
        return true;
    }

    public static boolean d(long j) {
        if (j > 0) {
            return true;
        }
        n7.b.F(new IllegalArgumentException(androidx.camera.core.processing.util.a.j("n > 0 required but it was ", j)));
        return false;
    }

    public static boolean e(o7.b bVar, o7.b bVar2) {
        if (bVar2 == null) {
            n7.b.F(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.cancel();
        n7.b.F(new s("Subscription already set!"));
        return false;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f12708b.clone();
    }

    @Override // o7.b
    public final void cancel() {
    }

    @Override // o7.b
    public final void c(long j) {
    }
}
