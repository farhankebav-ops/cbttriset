package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f11420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11421b;

    @Override // f7.f1
    public final Object a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f11420a, this.f11421b);
        kotlin.jvm.internal.k.d(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        float[] fArr = this.f11420a;
        if (fArr.length < i2) {
            int length = fArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i2);
            kotlin.jvm.internal.k.d(fArrCopyOf, "copyOf(...)");
            this.f11420a = fArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11421b;
    }
}
