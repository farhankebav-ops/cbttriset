package f2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends a implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f11320b = new c(k.e, 0);

    public static k g(int i2, Object[] objArr) {
        return i2 == 0 ? k.e : new k(objArr, i2);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // f2.a
    public int b(int i2, Object[] objArr) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i2 + i8] = get(i8);
        }
        return i2 + size;
    }

    @Override // f2.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator it = iterator();
                        Iterator it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && Objects.equals(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        if (Objects.equals(get(i2), list.get(i2))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final c listIterator(int i2) {
        r2.q.E(i2, size());
        return isEmpty() ? f11320b : new c(this, i2);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i8 = 0; i8 < size; i8++) {
            i2 = ~(~(get(i8).hashCode() + (i2 * 31)));
        }
        return i2;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: i */
    public e subList(int i2, int i8) {
        r2.q.F(i2, i8, size());
        int i9 = i8 - i2;
        return i9 == size() ? this : i9 == 0 ? k.e : new d(this, i2, i9);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // f2.a
    public final e a() {
        return this;
    }
}
