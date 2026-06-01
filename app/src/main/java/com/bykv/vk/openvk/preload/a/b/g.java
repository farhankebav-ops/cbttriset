package com.bykv.vk.openvk.preload.a.b;

import com.ironsource.C2300e4;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Comparator<Comparable> f4812d = new Comparator<Comparable>() { // from class: com.bykv.vk.openvk.preload.a.b.g.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static /* synthetic */ boolean f4813i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d<K, V> f4816c;
    private Comparator<? super K> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d<K, V> f4817f;
    private g<K, V>.a g;
    private g<K, V>.b h;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractSet<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.a.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            d<K, V> dVarA;
            if (!(obj instanceof Map.Entry) || (dVarA = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.a((d) dVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f4814a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class b extends AbstractSet<K> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.b.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    return a().f4828f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return g.this.a(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f4814a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d<K, V> f4820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d<K, V> f4821b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4822c;

        public c() {
            this.f4820a = g.this.f4816c.f4827d;
            this.f4822c = g.this.f4815b;
        }

        public final d<K, V> a() {
            d<K, V> dVar = this.f4820a;
            g gVar = g.this;
            if (dVar == gVar.f4816c) {
                throw new NoSuchElementException();
            }
            if (gVar.f4815b != this.f4822c) {
                throw new ConcurrentModificationException();
            }
            this.f4820a = dVar.f4827d;
            this.f4821b = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4820a != g.this.f4816c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f4821b;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            g.this.a((d) dVar, true);
            this.f4821b = null;
            this.f4822c = g.this.f4815b;
        }
    }

    public g() {
        this(f4812d);
    }

    private d<K, V> a(K k, boolean z2) {
        int iCompareTo;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.e;
        d<K, V> dVar2 = this.f4817f;
        if (dVar2 != null) {
            Comparable comparable = comparator == f4812d ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(dVar2.f4828f) : comparator.compare(k, dVar2.f4828f);
                if (iCompareTo != 0) {
                    d<K, V> dVar3 = iCompareTo < 0 ? dVar2.f4825b : dVar2.f4826c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                } else {
                    return dVar2;
                }
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        d<K, V> dVar4 = this.f4816c;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            if (iCompareTo < 0) {
                dVar2.f4825b = dVar;
            } else {
                dVar2.f4826c = dVar;
            }
            b(dVar2, true);
        } else {
            if (comparator == f4812d && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName().concat(" is not Comparable"));
            }
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            this.f4817f = dVar;
        }
        this.f4814a++;
        this.f4815b++;
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d<K, V> b(Object obj) {
        if (obj != 0) {
            try {
                return a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f4817f = null;
        this.f4814a = 0;
        this.f4815b++;
        d<K, V> dVar = this.f4816c;
        dVar.e = dVar;
        dVar.f4827d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.a aVar = this.g;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.a aVar2 = new a();
        this.g = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            return dVarB.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        g<K, V>.b bVar = this.h;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v2) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> dVarA = a((Object) k, true);
        V v7 = dVarA.g;
        dVarA.g = v2;
        return v7;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            return dVarA.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4814a;
    }

    private g(Comparator<? super K> comparator) {
        this.f4814a = 0;
        this.f4815b = 0;
        this.f4816c = new d<>();
        this.e = comparator == null ? f4812d : comparator;
    }

    private void b(d<K, V> dVar, boolean z2) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f4825b;
            d<K, V> dVar3 = dVar.f4826c;
            int i2 = dVar2 != null ? dVar2.h : 0;
            int i8 = dVar3 != null ? dVar3.h : 0;
            int i9 = i2 - i8;
            if (i9 == -2) {
                d<K, V> dVar4 = dVar3.f4825b;
                d<K, V> dVar5 = dVar3.f4826c;
                int i10 = (dVar4 != null ? dVar4.h : 0) - (dVar5 != null ? dVar5.h : 0);
                if (i10 == -1 || (i10 == 0 && !z2)) {
                    a((d) dVar);
                } else {
                    if (!f4813i && i10 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z2) {
                    return;
                }
            } else if (i9 == 2) {
                d<K, V> dVar6 = dVar2.f4825b;
                d<K, V> dVar7 = dVar2.f4826c;
                int i11 = (dVar6 != null ? dVar6.h : 0) - (dVar7 != null ? dVar7.h : 0);
                if (i11 == 1 || (i11 == 0 && !z2)) {
                    b((d) dVar);
                } else {
                    if (!f4813i && i11 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z2) {
                    return;
                }
            } else if (i9 == 0) {
                dVar.h = i2 + 1;
                if (z2) {
                    return;
                }
            } else {
                if (!f4813i && i9 != -1 && i9 != 1) {
                    throw new AssertionError();
                }
                dVar.h = Math.max(i2, i8) + 1;
                if (!z2) {
                    return;
                }
            }
            dVar = dVar.f4824a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f4824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f4825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d<K, V> f4826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d<K, V> f4827d;
        d<K, V> e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f4828f;
        V g;
        int h;

        public d() {
            this.f4828f = null;
            this.e = this;
            this.f4827d = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f4828f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v2 = this.g;
                    if (v2 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v2.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f4828f;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k = this.f4828f;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v2 = this.g;
            return iHashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v2) {
            V v7 = this.g;
            this.g = v2;
            return v7;
        }

        public final String toString() {
            return this.f4828f + C2300e4.i.f8399b + this.g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f4824a = dVar;
            this.f4828f = k;
            this.h = 1;
            this.f4827d = dVar2;
            this.e = dVar3;
            dVar3.f4827d = this;
            dVar2.e = this;
        }
    }

    public final d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> dVarB = b(entry.getKey());
        if (dVarB == null) {
            return null;
        }
        V v2 = dVarB.g;
        Object value = entry.getValue();
        if (v2 == value || (v2 != null && v2.equals(value))) {
            return dVarB;
        }
        return null;
    }

    public final void a(d<K, V> dVar, boolean z2) {
        int i2;
        if (z2) {
            d<K, V> dVar2 = dVar.e;
            dVar2.f4827d = dVar.f4827d;
            dVar.f4827d.e = dVar2;
        }
        d<K, V> dVar3 = dVar.f4825b;
        d<K, V> dVar4 = dVar.f4826c;
        d<K, V> dVar5 = dVar.f4824a;
        int i8 = 0;
        if (dVar3 != null && dVar4 != null) {
            if (dVar3.h > dVar4.h) {
                d<K, V> dVar6 = dVar3.f4826c;
                while (true) {
                    d<K, V> dVar7 = dVar6;
                    dVar4 = dVar3;
                    dVar3 = dVar7;
                    if (dVar3 == null) {
                        break;
                    } else {
                        dVar6 = dVar3.f4826c;
                    }
                }
            } else {
                while (true) {
                    d<K, V> dVar8 = dVar4.f4825b;
                    if (dVar8 == null) {
                        break;
                    } else {
                        dVar4 = dVar8;
                    }
                }
            }
            a((d) dVar4, false);
            d<K, V> dVar9 = dVar.f4825b;
            if (dVar9 != null) {
                i2 = dVar9.h;
                dVar4.f4825b = dVar9;
                dVar9.f4824a = dVar4;
                dVar.f4825b = null;
            } else {
                i2 = 0;
            }
            d<K, V> dVar10 = dVar.f4826c;
            if (dVar10 != null) {
                i8 = dVar10.h;
                dVar4.f4826c = dVar10;
                dVar10.f4824a = dVar4;
                dVar.f4826c = null;
            }
            dVar4.h = Math.max(i2, i8) + 1;
            a(dVar, dVar4);
            return;
        }
        if (dVar3 != null) {
            a(dVar, dVar3);
            dVar.f4825b = null;
        } else if (dVar4 != null) {
            a(dVar, dVar4);
            dVar.f4826c = null;
        } else {
            a(dVar, (d) null);
        }
        b(dVar5, false);
        this.f4814a--;
        this.f4815b++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f4825b;
        d<K, V> dVar3 = dVar.f4826c;
        d<K, V> dVar4 = dVar2.f4825b;
        d<K, V> dVar5 = dVar2.f4826c;
        dVar.f4825b = dVar5;
        if (dVar5 != null) {
            dVar5.f4824a = dVar;
        }
        a(dVar, dVar2);
        dVar2.f4826c = dVar;
        dVar.f4824a = dVar2;
        int iMax = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        dVar.h = iMax;
        dVar2.h = Math.max(iMax, dVar4 != null ? dVar4.h : 0) + 1;
    }

    public final d<K, V> a(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            a((d) dVarB, true);
        }
        return dVarB;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f4824a;
        dVar.f4824a = null;
        if (dVar2 != null) {
            dVar2.f4824a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f4825b == dVar) {
                dVar3.f4825b = dVar2;
                return;
            } else {
                if (!f4813i && dVar3.f4826c != dVar) {
                    throw new AssertionError();
                }
                dVar3.f4826c = dVar2;
                return;
            }
        }
        this.f4817f = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f4825b;
        d<K, V> dVar3 = dVar.f4826c;
        d<K, V> dVar4 = dVar3.f4825b;
        d<K, V> dVar5 = dVar3.f4826c;
        dVar.f4826c = dVar4;
        if (dVar4 != null) {
            dVar4.f4824a = dVar;
        }
        a(dVar, dVar3);
        dVar3.f4825b = dVar;
        dVar.f4824a = dVar3;
        int iMax = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        dVar.h = iMax;
        dVar3.h = Math.max(iMax, dVar5 != null ? dVar5.h : 0) + 1;
    }
}
