package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11463b;

    @Override // f7.f1
    public final Object a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f11462a, this.f11463b);
        kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Override // f7.f1
    public final void b(int i2) {
        byte[] bArr = this.f11462a;
        if (bArr.length < i2) {
            int length = bArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
            kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(...)");
            this.f11462a = bArrCopyOf;
        }
    }

    @Override // f7.f1
    public final int d() {
        return this.f11463b;
    }
}
