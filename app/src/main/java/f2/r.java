package f2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11348a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f11350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Iterator f11351d;
    public final /* synthetic */ Set e;

    public r(Set set, Set set2) {
        this.e = set;
        this.f11350c = set.iterator();
        this.f11351d = set2.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i2 = this.f11348a;
        if (i2 == 4) {
            throw new IllegalStateException();
        }
        int iB = q0.c.b(i2);
        if (iB == 0) {
            return true;
        }
        if (iB == 2) {
            return false;
        }
        this.f11348a = 4;
        Iterator it = this.f11350c;
        if (!it.hasNext()) {
            while (true) {
                Iterator it2 = this.f11351d;
                if (!it2.hasNext()) {
                    this.f11348a = 3;
                    next = null;
                    break;
                }
                next = it2.next();
                if (!this.e.contains(next)) {
                    break;
                }
            }
        } else {
            next = it.next();
        }
        this.f11349b = next;
        if (this.f11348a == 3) {
            return false;
        }
        this.f11348a = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11348a = 2;
        Object obj = this.f11349b;
        this.f11349b = null;
        return obj;
    }
}
