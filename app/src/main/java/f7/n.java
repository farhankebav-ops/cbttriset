package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f11485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11486b;

    @Override // f7.f1
    public final Object a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f11485a, this.f11486b);
        kotlin.jvm.internal.k.d(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        char[] cArr = this.f11485a;
        if (cArr.length < i2) {
            int length = cArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i2);
            kotlin.jvm.internal.k.d(cArrCopyOf, "copyOf(...)");
            this.f11485a = cArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11486b;
    }
}
