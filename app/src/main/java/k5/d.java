package k5;

import s4.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements a5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d[] f12704b;

    static {
        d dVar = new d("INSTANCE", 0);
        f12703a = dVar;
        f12704b = new d[]{dVar};
    }

    public static void a(g gVar) {
        gVar.f(f12703a);
        gVar.onComplete();
    }

    public static void b(Throwable th, g gVar) {
        gVar.f(f12703a);
        gVar.onError(th);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f12704b.clone();
    }

    @Override // o7.b
    public final void c(long j) {
        f.d(j);
    }

    @Override // a5.d
    public final int d(int i2) {
        return 2;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return true;
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // a5.h
    public final Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "EmptySubscription";
    }

    @Override // o7.b
    public final void cancel() {
    }

    @Override // a5.h
    public final void clear() {
    }
}
