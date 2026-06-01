package com.bytedance.adsdk.MY;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
abstract class ea<K, V> {
    ea<K, V>.MY MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class IlO<T> implements Iterator<T> {
        int EO;
        final int IlO;
        int MY;
        boolean tV = false;

        public IlO(int i2) {
            this.IlO = i2;
            this.MY = ea.this.IlO();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.EO < this.MY;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t3 = (T) ea.this.IlO(this.EO, this.IlO);
            this.EO++;
            this.tV = true;
            return t3;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.tV) {
                throw new IllegalStateException();
            }
            int i2 = this.EO - 1;
            this.EO = i2;
            this.MY--;
            this.tV = false;
            ea.this.IlO(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class MY implements Set<K> {
        public MY() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            ea.this.EO();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return ea.this.IlO(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return ea.IlO(ea.this.MY(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return ea.IlO(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iIlO = ea.this.IlO() - 1; iIlO >= 0; iIlO--) {
                Object objIlO = ea.this.IlO(iIlO, 0);
                iHashCode += objIlO == null ? 0 : objIlO.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ea.this.IlO() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new IlO(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iIlO = ea.this.IlO(obj);
            if (iIlO < 0) {
                return false;
            }
            ea.this.IlO(iIlO);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return ea.MY(ea.this.MY(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return ea.EO(ea.this.MY(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ea.this.IlO();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return ea.this.MY(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ea.this.IlO(tArr, 0);
        }
    }

    public static <K, V> boolean EO(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean IlO(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean MY(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public abstract void EO();

    public abstract int IlO();

    public abstract int IlO(Object obj);

    public abstract Object IlO(int i2, int i8);

    public abstract void IlO(int i2);

    public abstract Map<K, V> MY();

    public Set<K> tV() {
        if (this.MY == null) {
            this.MY = new MY();
        }
        return this.MY;
    }

    public <T> T[] IlO(T[] tArr, int i2) {
        int iIlO = IlO();
        if (tArr.length < iIlO) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iIlO));
        }
        for (int i8 = 0; i8 < iIlO; i8++) {
            tArr[i8] = IlO(i8, i2);
        }
        if (tArr.length > iIlO) {
            tArr[iIlO] = null;
        }
        return tArr;
    }

    public Object[] MY(int i2) {
        int iIlO = IlO();
        Object[] objArr = new Object[iIlO];
        for (int i8 = 0; i8 < iIlO; i8++) {
            objArr[i8] = IlO(i8, i2);
        }
        return objArr;
    }

    public static <T> boolean IlO(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
