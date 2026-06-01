package androidx.collection;

import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import e6.l;
import f6.a;
import f6.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import k6.d;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import m6.h;
import r2.q;
import r5.j;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list, int i2) {
            k.e(list, "list");
            this.list = list;
            this.prevIndex = i2 - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t3) {
            List<T> list = this.list;
            int i2 = this.prevIndex + 1;
            this.prevIndex = i2;
            list.add(i2, t3);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i2 = this.prevIndex + 1;
            this.prevIndex = i2;
            return list.get(i2);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i2 = this.prevIndex;
            this.prevIndex = i2 - 1;
            return list.get(i2);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t3) {
            this.list.set(this.prevIndex, t3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ObjectListMutableList<T> implements List<T>, c {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> objectList) {
            k.e(objectList, "objectList");
            this.objectList = objectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t3) {
            return this.objectList.add(t3);
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends T> elements) {
            k.e(elements, "elements");
            return this.objectList.addAll(i2, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            return this.objectList.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int i2) {
            ObjectListKt.checkIndex(this, i2);
            return this.objectList.get(i2);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i2) {
            return removeAt(i2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            return this.objectList.removeAll(elements);
        }

        public T removeAt(int i2) {
            ObjectListKt.checkIndex(this, i2);
            return this.objectList.removeAt(i2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            return this.objectList.retainAll((Collection<? extends T>) elements);
        }

        @Override // java.util.List
        public T set(int i2, T t3) {
            ObjectListKt.checkIndex(this, i2);
            return this.objectList.set(i2, t3);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i2, int i8) {
            ObjectListKt.checkSubIndex(this, i2, i8);
            return new SubList(this, i2, i8);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return k.m(this);
        }

        @Override // java.util.List
        public void add(int i2, T t3) {
            this.objectList.add(i2, t3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            k.e(elements, "elements");
            return this.objectList.addAll(elements);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i2) {
            return new MutableObjectListIterator(this, i2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            k.e(array, "array");
            return (T[]) k.n(this, array);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SubList<T> implements List<T>, c {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i2, int i8) {
            k.e(list, "list");
            this.list = list;
            this.start = i2;
            this.end = i8;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t3) {
            List<T> list = this.list;
            int i2 = this.end;
            this.end = i2 + 1;
            list.add(i2, t3);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends T> elements) {
            k.e(elements, "elements");
            this.list.addAll(i2 + this.start, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i2 = this.end - 1;
            int i8 = this.start;
            if (i8 <= i2) {
                while (true) {
                    this.list.remove(i2);
                    if (i2 == i8) {
                        break;
                    } else {
                        i2--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i2 = this.end;
            for (int i8 = this.start; i8 < i2; i8++) {
                if (k.a(this.list.get(i8), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i2) {
            ObjectListKt.checkIndex(this, i2);
            return this.list.get(i2 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i2 = this.end;
            for (int i8 = this.start; i8 < i2; i8++) {
                if (k.a(this.list.get(i8), obj)) {
                    return i8 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i2 = this.end - 1;
            int i8 = this.start;
            if (i8 > i2) {
                return -1;
            }
            while (!k.a(this.list.get(i2), obj)) {
                if (i2 == i8) {
                    return -1;
                }
                i2--;
            }
            return i2 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i2) {
            return removeAt(i2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            int i2 = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i2 != this.end;
        }

        public T removeAt(int i2) {
            ObjectListKt.checkIndex(this, i2);
            this.end--;
            return this.list.remove(i2 + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            int i2 = this.end;
            int i8 = i2 - 1;
            int i9 = this.start;
            if (i9 <= i8) {
                while (true) {
                    if (!elements.contains(this.list.get(i8))) {
                        this.list.remove(i8);
                        this.end--;
                    }
                    if (i8 == i9) {
                        break;
                    }
                    i8--;
                }
            }
            return i2 != this.end;
        }

        @Override // java.util.List
        public T set(int i2, T t3) {
            ObjectListKt.checkIndex(this, i2);
            return this.list.set(i2 + this.start, t3);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i2, int i8) {
            ObjectListKt.checkSubIndex(this, i2, i8);
            return new SubList(this, i2, i8);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return k.m(this);
        }

        @Override // java.util.List
        public void add(int i2, T t3) {
            this.list.add(i2 + this.start, t3);
            this.end++;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i2) {
            return new MutableObjectListIterator(this, i2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i2 = this.end;
            for (int i8 = this.start; i8 < i2; i8++) {
                if (k.a(this.list.get(i8), obj)) {
                    this.list.remove(i8);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            k.e(array, "array");
            return (T[]) k.n(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            k.e(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = mutableObjectList._size;
        }
        mutableObjectList.trim(i2);
    }

    public final boolean add(E e) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i2 = this._size;
        objArr[i2] = e;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, E[] elements) {
        int i8;
        k.e(elements, "elements");
        if (i2 < 0 || i2 > (i8 = this._size)) {
            StringBuilder sbV = a1.a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i8 + elements.length);
        Object[] objArr = this.content;
        int i9 = this._size;
        if (i2 != i9) {
            j.f0(objArr, elements.length + i2, objArr, i2, i9);
        }
        j.h0(elements, objArr, i2, 0, 0, 12);
        this._size += elements.length;
        return true;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        j.k0(null, this.content, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        Object[] objArr = this.content;
        if (objArr.length < i2) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, Math.max(i2, (objArr.length * 3) / 2));
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.content = objArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E e) {
        remove(e);
    }

    public final void plusAssign(ObjectList<E> elements) {
        k.e(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements._size);
        j.f0(elements.content, this._size, this.content, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean remove(E e) {
        int iIndexOf = indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(E[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        for (E e : elements) {
            remove(e);
        }
        return i2 != this._size;
    }

    public final E removeAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this._size)) {
            StringBuilder sbV = a1.a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        Object[] objArr = this.content;
        E e = (E) objArr[i2];
        if (i2 != i8 - 1) {
            j.f0(objArr, i2, objArr, i2 + 1, i8);
        }
        int i9 = this._size - 1;
        this._size = i9;
        objArr[i9] = null;
        return e;
    }

    public final void removeIf(l predicate) {
        k.e(predicate, "predicate");
        int i2 = this._size;
        Object[] objArr = this.content;
        int i8 = 0;
        d dVarD0 = q.D0(0, i2);
        int i9 = dVarD0.f12709a;
        int i10 = dVarD0.f12710b;
        if (i9 <= i10) {
            while (true) {
                objArr[i9 - i8] = objArr[i9];
                if (((Boolean) predicate.invoke(objArr[i9])).booleanValue()) {
                    i8++;
                }
                if (i9 == i10) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        j.k0(null, objArr, i2 - i8, i2);
        this._size -= i8;
    }

    public final void removeRange(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i8) {
        int i9;
        if (i2 < 0 || i2 > (i9 = this._size) || i8 < 0 || i8 > i9) {
            StringBuilder sbW = a1.a.w(i2, "Start (", ") and end (", i8, ") must be in 0..");
            sbW.append(this._size);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException("Start (" + i2 + ") is more than end (" + i8 + ')');
        }
        if (i8 != i2) {
            if (i8 < i9) {
                Object[] objArr = this.content;
                j.f0(objArr, i2, objArr, i8, i9);
            }
            int i10 = this._size;
            int i11 = i10 - (i8 - i2);
            j.k0(null, this.content, i11, i10);
            this._size = i11;
        }
    }

    public final boolean retainAll(E[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        Object[] objArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (j.q0(elements, objArr[i8]) < 0) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final E set(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, E e) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbV = a1.a.v(i2, "set index ", " must be between 0 .. ");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        Object[] objArr = this.content;
        E e4 = (E) objArr[i2];
        objArr[i2] = e;
        return e4;
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        Object[] objArr = this.content;
        if (objArr.length > iMax) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, iMax);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.content = objArrCopyOf;
        }
    }

    public /* synthetic */ MutableObjectList(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(List<? extends E> elements) {
        k.e(elements, "elements");
        int size = elements.size();
        for (int i2 = 0; i2 < size; i2++) {
            remove(elements.get(i2));
        }
    }

    public MutableObjectList(int i2) {
        super(i2, null);
    }

    public final void add(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, E e) {
        int i8;
        if (i2 >= 0 && i2 <= (i8 = this._size)) {
            ensureCapacity(i8 + 1);
            Object[] objArr = this.content;
            int i9 = this._size;
            if (i2 != i9) {
                j.f0(objArr, i2 + 1, objArr, i2, i9);
            }
            objArr[i2] = e;
            this._size++;
            return;
        }
        StringBuilder sbV = a1.a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final void minusAssign(E[] elements) {
        k.e(elements, "elements");
        for (E e : elements) {
            remove(e);
        }
    }

    public final boolean removeAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign((ObjectList) elements);
        return i2 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            remove(objArr[i8]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        Object[] objArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!elements.contains(objArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign((ScatterSet) elements);
        return i2 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        k.e(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(elements.getSize() + this._size);
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        add(objArr[(i2 << 3) + i9]);
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        remove(objArr[(i2 << 3) + i9]);
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final boolean removeAll(List<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign((List) elements);
        return i2 != this._size;
    }

    public final boolean retainAll(Collection<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        Object[] objArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!elements.contains(objArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign((Iterable) elements);
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, Collection<? extends E> elements) {
        k.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            int i8 = 0;
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(elements.size() + this._size);
            Object[] objArr = this.content;
            if (i2 != this._size) {
                j.f0(objArr, elements.size() + i2, objArr, i2, this._size);
            }
            for (Object obj : elements) {
                int i9 = i8 + 1;
                if (i8 >= 0) {
                    objArr[i8 + i2] = obj;
                    i8 = i9;
                } else {
                    m.K0();
                    throw null;
                }
            }
            this._size = elements.size() + this._size;
            return true;
        }
        StringBuilder sbV = a1.a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(E[] elements) {
        k.e(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        ensureCapacity(this._size + elements.length);
        j.h0(elements, this.content, this._size, 0, 0, 12);
        this._size += elements.length;
    }

    public final boolean removeAll(h elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign(elements);
        return i2 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(h elements) {
        k.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        Object[] objArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!r5.l.T0(elements, objArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final void plusAssign(List<? extends E> elements) {
        k.e(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i2 = this._size;
        ensureCapacity(elements.size() + i2);
        Object[] objArr = this.content;
        int size = elements.size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i8 + i2] = elements.get(i8);
        }
        this._size = elements.size() + this._size;
    }

    public final boolean retainAll(h elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        Object[] objArr = this.content;
        int i8 = i2 - 1;
        while (true) {
            int i9 = -1;
            if (-1 >= i8) {
                return i2 != this._size;
            }
            Object obj = objArr[i8];
            Iterator it = elements.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (i10 >= 0) {
                    if (k.a(obj, next)) {
                        i9 = i10;
                        break;
                    }
                    i10++;
                } else {
                    m.K0();
                    throw null;
                }
            }
            if (!(i9 >= 0)) {
                removeAt(i8);
            }
            i8--;
        }
    }

    public final void plusAssign(E e) {
        add(e);
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(h elements) {
        k.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, ObjectList<E> elements) {
        k.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            Object[] objArr = this.content;
            int i8 = this._size;
            if (i2 != i8) {
                j.f0(objArr, elements._size + i2, objArr, i2, i8);
            }
            j.f0(elements.content, i2, objArr, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbV = a1.a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final boolean addAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign((ObjectList) elements);
        return i2 != this._size;
    }

    public final boolean addAll(ScatterSet<E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign((ScatterSet) elements);
        return i2 != this._size;
    }

    public final boolean addAll(E[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign((Object[]) elements);
        return i2 != this._size;
    }

    public final boolean addAll(List<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign((List) elements);
        return i2 != this._size;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign((Iterable) elements);
        return i2 != this._size;
    }

    public final boolean addAll(h elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign(elements);
        return i2 != this._size;
    }
}
