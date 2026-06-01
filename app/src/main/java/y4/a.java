package y4;

import java.util.concurrent.atomic.AtomicReference;
import s6.s;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f17848b;

    static {
        a aVar = new a("DISPOSED", 0);
        f17847a = aVar;
        f17848b = new a[]{aVar};
    }

    public static void a(AtomicReference atomicReference) {
        u4.b bVar;
        u4.b bVar2 = (u4.b) atomicReference.get();
        a aVar = f17847a;
        if (bVar2 == aVar || (bVar = (u4.b) atomicReference.getAndSet(aVar)) == aVar || bVar == null) {
            return;
        }
        bVar.dispose();
    }

    public static boolean b(u4.b bVar) {
        return bVar == f17847a;
    }

    public static boolean c(AtomicReference atomicReference, u4.b bVar) {
        while (true) {
            u4.b bVar2 = (u4.b) atomicReference.get();
            if (bVar2 == f17847a) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
            while (!atomicReference.compareAndSet(bVar2, bVar)) {
                if (atomicReference.get() != bVar2) {
                    break;
                }
            }
            return true;
        }
    }

    public static void d() {
        n7.b.F(new s("Disposable already set!"));
    }

    public static boolean e(AtomicReference atomicReference, u4.b bVar) {
        z4.b.a(bVar, "d is null");
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                bVar.dispose();
                if (atomicReference.get() == f17847a) {
                    return false;
                }
                d();
                return false;
            }
        }
        return true;
    }

    public static boolean f(u4.b bVar, u4.b bVar2) {
        if (bVar2 == null) {
            n7.b.F(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        d();
        return false;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f17848b.clone();
    }

    @Override // u4.b
    public final void dispose() {
    }
}
