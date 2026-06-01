package m6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements h, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12976c;

    public c(h sequence, int i2, int i8) {
        this.f12974a = i8;
        switch (i8) {
            case 1:
                this.f12975b = sequence;
                this.f12976c = i2;
                if (i2 >= 0) {
                    return;
                }
                throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
            default:
                kotlin.jvm.internal.k.e(sequence, "sequence");
                this.f12975b = sequence;
                this.f12976c = i2;
                if (i2 >= 0) {
                    return;
                }
                throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
        }
    }

    @Override // m6.d
    public final h a(int i2) {
        switch (this.f12974a) {
            case 0:
                int i8 = this.f12976c + i2;
                return i8 < 0 ? new c(this, i2, 0) : new c(this.f12975b, i8, 0);
            default:
                int i9 = this.f12976c;
                return i2 >= i9 ? e.f12977a : new m(this.f12975b, i2, i9);
        }
    }

    @Override // m6.d
    public final h b(int i2) {
        switch (this.f12974a) {
            case 0:
                int i8 = this.f12976c;
                int i9 = i8 + i2;
                return i9 < 0 ? new c(this, i2, 1) : new m(this.f12975b, i8, i9);
            default:
                return i2 >= this.f12976c ? this : new c(this.f12975b, i2, 1);
        }
    }

    @Override // m6.h
    public final Iterator iterator() {
        switch (this.f12974a) {
            case 0:
                return new b(this);
            default:
                return new b(this, (byte) 0);
        }
    }
}
