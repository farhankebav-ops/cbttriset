package c6;

import e6.p;
import java.util.Iterator;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements m6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4240b;

    public /* synthetic */ m(Object obj, int i2) {
        this.f4239a = i2;
        this.f4240b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [e6.p, x5.h] */
    @Override // m6.h
    public final Iterator iterator() {
        switch (this.f4239a) {
            case 0:
                return new l(this);
            case 1:
                return q.i0((x5.h) this.f4240b);
            case 2:
                return (Iterator) this.f4240b;
            case 3:
                return new n6.h((CharSequence) this.f4240b);
            default:
                return ((Iterable) this.f4240b).iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(p pVar) {
        this.f4239a = 1;
        this.f4240b = (x5.h) pVar;
    }
}
