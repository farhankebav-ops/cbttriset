package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f11439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11440b;

    @Override // f7.f1
    public final Object a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f11439a, this.f11440b);
        kotlin.jvm.internal.k.d(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        boolean[] zArr = this.f11439a;
        if (zArr.length < i2) {
            int length = zArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i2);
            kotlin.jvm.internal.k.d(zArrCopyOf, "copyOf(...)");
            this.f11439a = zArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11440b;
    }
}
