package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v1 extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f11530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11531b;

    @Override // f7.f1
    public final Object a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f11530a, this.f11531b);
        kotlin.jvm.internal.k.d(iArrCopyOf, "copyOf(...)");
        return new q5.r(iArrCopyOf);
    }

    @Override // f7.f1
    public final void b(int i2) {
        int[] iArr = this.f11530a;
        if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
            kotlin.jvm.internal.k.d(iArrCopyOf, "copyOf(...)");
            this.f11530a = iArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11531b;
    }
}
