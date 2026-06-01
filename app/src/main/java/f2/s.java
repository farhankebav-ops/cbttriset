package f2;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f11352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f11353b;

    public s(Set set, Set set2) {
        this.f11352a = set;
        this.f11353b = set2;
    }

    public final int a() {
        Set set = this.f11352a;
        int iA = set instanceof s ? ((s) set).a() : set.size();
        Set set2 = this.f11353b;
        return r2.q.p0(((long) iA) + ((long) (set2 instanceof s ? ((s) set2).a() : set2.size())));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final int b() {
        Set set = this.f11352a;
        int iB = set instanceof s ? ((s) set).b() : set.size();
        Set set2 = this.f11353b;
        return Math.max(iB, set2 instanceof s ? ((s) set2).b() : set2.size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f11352a.contains(obj) || this.f11353b.contains(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                boolean z2 = set instanceof s;
                int iA = z2 ? ((s) set).a() : set.size();
                if (b() <= iA) {
                    int iB = z2 ? ((s) set).b() : set.size();
                    if (a() >= iB) {
                        r rVar = new r(this.f11352a, this.f11353b);
                        int i2 = 0;
                        while (true) {
                            if (rVar.hasNext()) {
                                try {
                                    if (!set.contains(rVar.next())) {
                                        break;
                                    }
                                    i2++;
                                } catch (ClassCastException | NullPointerException unused) {
                                }
                            } else if (i2 != iA) {
                                if (i2 >= iB) {
                                    Iterator it = set.iterator();
                                    int i8 = 0;
                                    while (it.hasNext()) {
                                        it.next();
                                        i8++;
                                        if (i8 > i2) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f11352a.isEmpty() && this.f11353b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new r(this.f11352a, this.f11353b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set set = this.f11352a;
        int size = set.size();
        Iterator it = this.f11353b.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                size++;
            }
        }
        return size;
    }
}
