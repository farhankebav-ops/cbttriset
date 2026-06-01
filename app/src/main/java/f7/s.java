package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f11511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11512b;

    @Override // f7.f1
    public final Object a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f11511a, this.f11512b);
        kotlin.jvm.internal.k.d(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        double[] dArr = this.f11511a;
        if (dArr.length < i2) {
            int length = dArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i2);
            kotlin.jvm.internal.k.d(dArrCopyOf, "copyOf(...)");
            this.f11511a = dArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11512b;
    }
}
