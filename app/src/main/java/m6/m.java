package m6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements h, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f12991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12993c;

    public m(h sequence, int i2, int i8) {
        kotlin.jvm.internal.k.e(sequence, "sequence");
        this.f12991a = sequence;
        this.f12992b = i2;
        this.f12993c = i8;
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "startIndex should be non-negative, but is ").toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.g(i8, "endIndex should be non-negative, but is ").toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex should be not less than startIndex, but was ", i8, " < ", i2).toString());
        }
    }

    @Override // m6.d
    public final h a(int i2) {
        int i8 = this.f12993c;
        int i9 = this.f12992b;
        return i2 >= i8 - i9 ? e.f12977a : new m(this.f12991a, i9 + i2, i8);
    }

    @Override // m6.d
    public final h b(int i2) {
        int i8 = this.f12993c;
        int i9 = this.f12992b;
        return i2 >= i8 - i9 ? this : new m(this.f12991a, i9, i2 + i9);
    }

    @Override // m6.h
    public final Iterator iterator() {
        return new g(this);
    }
}
