package x6;

import q6.w;
import v6.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f17812b;

    static {
        int i2 = k.f17820c;
        int i8 = k.f17821d;
        long j = k.e;
        String str = k.f17818a;
        e eVar = new e();
        eVar.f17814a = new c(i2, i8, str, j);
        f17812b = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // q6.w
    public final w limitedParallelism(int i2, String str) {
        v6.a.a(i2);
        return i2 >= k.f17820c ? str != null ? new o(this, str) : this : super.limitedParallelism(i2, str);
    }

    @Override // q6.w
    public final String toString() {
        return "Dispatchers.Default";
    }
}
