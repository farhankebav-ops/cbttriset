package m6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e6.l f12980c;

    public f(h sequence, e6.l predicate, int i2) {
        this.f12978a = i2;
        switch (i2) {
            case 1:
                kotlin.jvm.internal.k.e(predicate, "predicate");
                this.f12979b = sequence;
                this.f12980c = predicate;
                break;
            case 2:
                kotlin.jvm.internal.k.e(sequence, "sequence");
                this.f12979b = sequence;
                this.f12980c = predicate;
                break;
            default:
                kotlin.jvm.internal.k.e(predicate, "predicate");
                this.f12979b = sequence;
                this.f12980c = predicate;
                break;
        }
    }

    @Override // m6.h
    public final Iterator iterator() {
        switch (this.f12978a) {
            case 0:
                return new c6.g(this);
            case 1:
                return new c6.g(this, (byte) 0);
            default:
                return new n(this);
        }
    }
}
