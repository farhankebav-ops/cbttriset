package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b2 extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f11423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11424b;

    @Override // f7.f1
    public final Object a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f11423a, this.f11424b);
        kotlin.jvm.internal.k.d(sArrCopyOf, "copyOf(...)");
        return new q5.w(sArrCopyOf);
    }

    @Override // f7.f1
    public final void b(int i2) {
        short[] sArr = this.f11423a;
        if (sArr.length < i2) {
            int length = sArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i2);
            kotlin.jvm.internal.k.d(sArrCopyOf, "copyOf(...)");
            this.f11423a = sArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11424b;
    }
}
