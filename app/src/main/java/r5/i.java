package r5;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f13633d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f13635b = f13633d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13636c;

    @Override // r5.f
    public final int a() {
        return this.f13636c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        i();
        d(elements.size() + a());
        c(h(a() + this.f13634a), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        i();
        d(this.f13636c + 1);
        int length = this.f13634a;
        if (length == 0) {
            Object[] objArr = this.f13635b;
            kotlin.jvm.internal.k.e(objArr, "<this>");
            length = objArr.length;
        }
        int i2 = length - 1;
        this.f13634a = i2;
        this.f13635b[i2] = obj;
        this.f13636c++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.f13635b[h(a() + this.f13634a)] = obj;
        this.f13636c = a() + 1;
    }

    @Override // r5.f
    public final Object b(int i2) {
        b bVar = e.Companion;
        int i8 = this.f13636c;
        bVar.getClass();
        b.b(i2, i8);
        if (i2 == m.G0(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        i();
        int iH = h(this.f13634a + i2);
        Object[] objArr = this.f13635b;
        Object obj = objArr[iH];
        if (i2 < (this.f13636c >> 1)) {
            int i9 = this.f13634a;
            if (iH >= i9) {
                j.f0(objArr, i9 + 1, objArr, i9, iH);
            } else {
                j.f0(objArr, 1, objArr, 0, iH);
                Object[] objArr2 = this.f13635b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i10 = this.f13634a;
                j.f0(objArr2, i10 + 1, objArr2, i10, objArr2.length - 1);
            }
            Object[] objArr3 = this.f13635b;
            int i11 = this.f13634a;
            objArr3[i11] = null;
            this.f13634a = e(i11);
        } else {
            int iH2 = h(m.G0(this) + this.f13634a);
            if (iH <= iH2) {
                Object[] objArr4 = this.f13635b;
                j.f0(objArr4, iH, objArr4, iH + 1, iH2 + 1);
            } else {
                Object[] objArr5 = this.f13635b;
                j.f0(objArr5, iH, objArr5, iH + 1, objArr5.length);
                Object[] objArr6 = this.f13635b;
                objArr6[objArr6.length - 1] = objArr6[0];
                j.f0(objArr6, 0, objArr6, 1, iH2 + 1);
            }
            this.f13635b[iH2] = null;
        }
        this.f13636c--;
        return obj;
    }

    public final void c(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f13635b.length;
        while (i2 < length && it.hasNext()) {
            this.f13635b[i2] = it.next();
            i2++;
        }
        int i8 = this.f13634a;
        for (int i9 = 0; i9 < i8 && it.hasNext(); i9++) {
            this.f13635b[i9] = it.next();
        }
        this.f13636c = collection.size() + this.f13636c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.f13634a, h(a() + this.f13634a));
        }
        this.f13634a = 0;
        this.f13636c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f13635b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f13633d) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f13635b = new Object[i2];
            return;
        }
        b bVar = e.Companion;
        int length = objArr.length;
        bVar.getClass();
        Object[] objArr2 = new Object[b.e(length, i2)];
        Object[] objArr3 = this.f13635b;
        j.f0(objArr3, 0, objArr2, this.f13634a, objArr3.length);
        Object[] objArr4 = this.f13635b;
        int length2 = objArr4.length;
        int i8 = this.f13634a;
        j.f0(objArr4, length2 - i8, objArr2, 0, i8);
        this.f13634a = 0;
        this.f13635b = objArr2;
    }

    public final int e(int i2) {
        kotlin.jvm.internal.k.e(this.f13635b, "<this>");
        if (i2 == r0.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    public final int f(int i2) {
        return i2 < 0 ? i2 + this.f13635b.length : i2;
    }

    public final void g(int i2, int i8) {
        if (i2 < i8) {
            j.k0(null, this.f13635b, i2, i8);
            return;
        }
        Object[] objArr = this.f13635b;
        j.k0(null, objArr, i2, objArr.length);
        j.k0(null, this.f13635b, 0, i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        b bVar = e.Companion;
        int i8 = this.f13636c;
        bVar.getClass();
        b.b(i2, i8);
        return this.f13635b[h(this.f13634a + i2)];
    }

    public final int h(int i2) {
        Object[] objArr = this.f13635b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int iH = h(a() + this.f13634a);
        int length = this.f13634a;
        if (length < iH) {
            while (length < iH) {
                if (kotlin.jvm.internal.k.a(obj, this.f13635b[length])) {
                    i2 = this.f13634a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.f13635b.length;
        while (true) {
            if (length >= length2) {
                for (int i8 = 0; i8 < iH; i8++) {
                    if (kotlin.jvm.internal.k.a(obj, this.f13635b[i8])) {
                        length = i8 + this.f13635b.length;
                        i2 = this.f13634a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.k.a(obj, this.f13635b[length])) {
                i2 = this.f13634a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i2;
        int iH = h(this.f13636c + this.f13634a);
        int i8 = this.f13634a;
        if (i8 < iH) {
            length = iH - 1;
            if (i8 <= length) {
                while (!kotlin.jvm.internal.k.a(obj, this.f13635b[length])) {
                    if (length != i8) {
                        length--;
                    }
                }
                i2 = this.f13634a;
                return length - i2;
            }
            return -1;
        }
        if (i8 > iH) {
            int i9 = iH - 1;
            while (true) {
                if (-1 >= i9) {
                    Object[] objArr = this.f13635b;
                    kotlin.jvm.internal.k.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i10 = this.f13634a;
                    if (i10 <= length) {
                        while (!kotlin.jvm.internal.k.a(obj, this.f13635b[length])) {
                            if (length != i10) {
                                length--;
                            }
                        }
                        i2 = this.f13634a;
                    }
                } else {
                    if (kotlin.jvm.internal.k.a(obj, this.f13635b[i9])) {
                        length = i9 + this.f13635b.length;
                        i2 = this.f13634a;
                        break;
                    }
                    i9--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f13635b.length != 0) {
            int iH2 = h(a() + this.f13634a);
            int i2 = this.f13634a;
            if (i2 < iH2) {
                iH = i2;
                while (i2 < iH2) {
                    Object obj = this.f13635b[i2];
                    if (elements.contains(obj)) {
                        z2 = true;
                    } else {
                        this.f13635b[iH] = obj;
                        iH++;
                    }
                    i2++;
                }
                j.k0(null, this.f13635b, iH, iH2);
            } else {
                int length = this.f13635b.length;
                boolean z7 = false;
                int i8 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f13635b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        z7 = true;
                    } else {
                        this.f13635b[i8] = obj2;
                        i8++;
                    }
                    i2++;
                }
                iH = h(i8);
                for (int i9 = 0; i9 < iH2; i9++) {
                    Object[] objArr2 = this.f13635b;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        z7 = true;
                    } else {
                        this.f13635b[iH] = obj3;
                        iH = e(iH);
                    }
                }
                z2 = z7;
            }
            if (z2) {
                i();
                this.f13636c = f(iH - this.f13634a);
            }
        }
        return z2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        Object[] objArr = this.f13635b;
        int i2 = this.f13634a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f13634a = e(i2);
        this.f13636c = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        int iH = h(m.G0(this) + this.f13634a);
        Object[] objArr = this.f13635b;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.f13636c = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        b bVar = e.Companion;
        int i9 = this.f13636c;
        bVar.getClass();
        b.d(i2, i8, i9);
        int i10 = i8 - i2;
        if (i10 == 0) {
            return;
        }
        if (i10 == this.f13636c) {
            clear();
            return;
        }
        if (i10 == 1) {
            b(i2);
            return;
        }
        i();
        if (i2 < this.f13636c - i8) {
            int iH = h(this.f13634a + (i2 - 1));
            int iH2 = h(this.f13634a + (i8 - 1));
            while (i2 > 0) {
                int i11 = iH + 1;
                int iMin = Math.min(i2, Math.min(i11, iH2 + 1));
                Object[] objArr = this.f13635b;
                int i12 = iH2 - iMin;
                int i13 = iH - iMin;
                j.f0(objArr, i12 + 1, objArr, i13 + 1, i11);
                iH = f(i13);
                iH2 = f(i12);
                i2 -= iMin;
            }
            int iH3 = h(this.f13634a + i10);
            g(this.f13634a, iH3);
            this.f13634a = iH3;
        } else {
            int iH4 = h(this.f13634a + i8);
            int iH5 = h(this.f13634a + i2);
            int i14 = this.f13636c;
            while (true) {
                i14 -= i8;
                if (i14 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f13635b;
                i8 = Math.min(i14, Math.min(objArr2.length - iH4, objArr2.length - iH5));
                Object[] objArr3 = this.f13635b;
                int i15 = iH4 + i8;
                j.f0(objArr3, iH5, objArr3, iH4, i15);
                iH4 = h(i15);
                iH5 = h(iH5 + i8);
            }
            int iH6 = h(this.f13636c + this.f13634a);
            g(f(iH6 - i10), iH6);
        }
        this.f13636c -= i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f13635b.length != 0) {
            int iH2 = h(a() + this.f13634a);
            int i2 = this.f13634a;
            if (i2 < iH2) {
                iH = i2;
                while (i2 < iH2) {
                    Object obj = this.f13635b[i2];
                    if (elements.contains(obj)) {
                        this.f13635b[iH] = obj;
                        iH++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                j.k0(null, this.f13635b, iH, iH2);
            } else {
                int length = this.f13635b.length;
                boolean z7 = false;
                int i8 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f13635b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        this.f13635b[i8] = obj2;
                        i8++;
                    } else {
                        z7 = true;
                    }
                    i2++;
                }
                iH = h(i8);
                for (int i9 = 0; i9 < iH2; i9++) {
                    Object[] objArr2 = this.f13635b;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        this.f13635b[iH] = obj3;
                        iH = e(iH);
                    } else {
                        z7 = true;
                    }
                }
                z2 = z7;
            }
            if (z2) {
                i();
                this.f13636c = f(iH - this.f13634a);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b bVar = e.Companion;
        int i8 = this.f13636c;
        bVar.getClass();
        b.b(i2, i8);
        int iH = h(this.f13634a + i2);
        Object[] objArr = this.f13635b;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int length;
        b bVar = e.Companion;
        int i8 = this.f13636c;
        bVar.getClass();
        b.c(i2, i8);
        if (i2 == this.f13636c) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.f13636c + 1);
        int iH = h(this.f13634a + i2);
        int i9 = this.f13636c;
        if (i2 < ((i9 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr = this.f13635b;
                kotlin.jvm.internal.k.e(objArr, "<this>");
                iH = objArr.length;
            }
            int i10 = iH - 1;
            int i11 = this.f13634a;
            if (i11 == 0) {
                Object[] objArr2 = this.f13635b;
                kotlin.jvm.internal.k.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i11 - 1;
            }
            int i12 = this.f13634a;
            if (i10 >= i12) {
                Object[] objArr3 = this.f13635b;
                objArr3[length] = objArr3[i12];
                j.f0(objArr3, i12, objArr3, i12 + 1, i10 + 1);
            } else {
                Object[] objArr4 = this.f13635b;
                j.f0(objArr4, i12 - 1, objArr4, i12, objArr4.length);
                Object[] objArr5 = this.f13635b;
                objArr5[objArr5.length - 1] = objArr5[0];
                j.f0(objArr5, 0, objArr5, 1, i10 + 1);
            }
            this.f13635b[i10] = obj;
            this.f13634a = length;
        } else {
            int iH2 = h(i9 + this.f13634a);
            if (iH < iH2) {
                Object[] objArr6 = this.f13635b;
                j.f0(objArr6, iH + 1, objArr6, iH, iH2);
            } else {
                Object[] objArr7 = this.f13635b;
                j.f0(objArr7, 1, objArr7, 0, iH2);
                Object[] objArr8 = this.f13635b;
                objArr8[0] = objArr8[objArr8.length - 1];
                j.f0(objArr8, iH + 1, objArr8, iH, objArr8.length - 1);
            }
            this.f13635b[iH] = obj;
        }
        this.f13636c++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        int length = array.length;
        int i2 = this.f13636c;
        if (length < i2) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i2);
            kotlin.jvm.internal.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        Object[] objArr = array;
        int iH = h(this.f13636c + this.f13634a);
        int i8 = this.f13634a;
        if (i8 < iH) {
            j.h0(this.f13635b, objArr, 0, i8, iH, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f13635b;
            j.f0(objArr2, 0, objArr, this.f13634a, objArr2.length);
            Object[] objArr3 = this.f13635b;
            j.f0(objArr3, objArr3.length - this.f13634a, objArr, 0, iH);
        }
        int i9 = this.f13636c;
        if (i9 < objArr.length) {
            objArr[i9] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        b bVar = e.Companion;
        int i8 = this.f13636c;
        bVar.getClass();
        b.c(i2, i8);
        if (elements.isEmpty()) {
            return false;
        }
        if (i2 == this.f13636c) {
            return addAll(elements);
        }
        i();
        d(elements.size() + this.f13636c);
        int iH = h(this.f13636c + this.f13634a);
        int iH2 = h(this.f13634a + i2);
        int size = elements.size();
        if (i2 < ((this.f13636c + 1) >> 1)) {
            int i9 = this.f13634a;
            int length = i9 - size;
            if (iH2 < i9) {
                Object[] objArr = this.f13635b;
                j.f0(objArr, length, objArr, i9, objArr.length);
                if (size >= iH2) {
                    Object[] objArr2 = this.f13635b;
                    j.f0(objArr2, objArr2.length - size, objArr2, 0, iH2);
                } else {
                    Object[] objArr3 = this.f13635b;
                    j.f0(objArr3, objArr3.length - size, objArr3, 0, size);
                    Object[] objArr4 = this.f13635b;
                    j.f0(objArr4, 0, objArr4, size, iH2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f13635b;
                j.f0(objArr5, length, objArr5, i9, iH2);
            } else {
                Object[] objArr6 = this.f13635b;
                length += objArr6.length;
                int i10 = iH2 - i9;
                int length2 = objArr6.length - length;
                if (length2 >= i10) {
                    j.f0(objArr6, length, objArr6, i9, iH2);
                } else {
                    j.f0(objArr6, length, objArr6, i9, i9 + length2);
                    Object[] objArr7 = this.f13635b;
                    j.f0(objArr7, 0, objArr7, this.f13634a + length2, iH2);
                }
            }
            this.f13634a = length;
            c(f(iH2 - size), elements);
            return true;
        }
        int i11 = iH2 + size;
        if (iH2 < iH) {
            int i12 = size + iH;
            Object[] objArr8 = this.f13635b;
            if (i12 <= objArr8.length) {
                j.f0(objArr8, i11, objArr8, iH2, iH);
            } else if (i11 >= objArr8.length) {
                j.f0(objArr8, i11 - objArr8.length, objArr8, iH2, iH);
            } else {
                int length3 = iH - (i12 - objArr8.length);
                j.f0(objArr8, 0, objArr8, length3, iH);
                Object[] objArr9 = this.f13635b;
                j.f0(objArr9, i11, objArr9, iH2, length3);
            }
        } else {
            Object[] objArr10 = this.f13635b;
            j.f0(objArr10, size, objArr10, 0, iH);
            Object[] objArr11 = this.f13635b;
            if (i11 >= objArr11.length) {
                j.f0(objArr11, i11 - objArr11.length, objArr11, iH2, objArr11.length);
            } else {
                j.f0(objArr11, 0, objArr11, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.f13635b;
                j.f0(objArr12, i11, objArr12, iH2, objArr12.length - size);
            }
        }
        c(iH2, elements);
        return true;
    }
}
