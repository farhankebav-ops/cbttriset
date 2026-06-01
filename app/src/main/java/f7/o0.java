package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f11491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11492b;

    @Override // f7.f1
    public final Object a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f11491a, this.f11492b);
        kotlin.jvm.internal.k.d(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        long[] jArr = this.f11491a;
        if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
            kotlin.jvm.internal.k.d(jArrCopyOf, "copyOf(...)");
            this.f11491a = jArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11492b;
    }
}
