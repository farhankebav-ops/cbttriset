package androidx.collection;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i2 = this.head;
        int i8 = length - i2;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i9];
        j.f0(eArr, 0, eArr2, i2, length);
        j.f0(this.elements, i8, eArr2, 0, this.head);
        this.elements = eArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i9 - 1;
    }

    public final void addFirst(E e) {
        int i2 = (this.head - 1) & this.capacityBitmask;
        this.head = i2;
        this.elements[i2] = e;
        if (i2 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.elements;
        int i2 = this.tail;
        eArr[i2] = e;
        int i8 = this.capacityBitmask & (i2 + 1);
        this.tail = i8;
        if (i8 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[this.capacityBitmask & (this.head + i2)];
        k.b(e);
        return e;
    }

    public final E getFirst() {
        int i2 = this.head;
        if (i2 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[i2];
        k.b(e);
        return e;
    }

    public final E getLast() {
        int i2 = this.head;
        int i8 = this.tail;
        if (i2 == i8) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[(i8 - 1) & this.capacityBitmask];
        k.b(e);
        return e;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final E popFirst() {
        int i2 = this.head;
        if (i2 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.elements;
        E e = eArr[i2];
        eArr[i2] = null;
        this.head = (i2 + 1) & this.capacityBitmask;
        return e;
    }

    public final E popLast() {
        int i2 = this.head;
        int i8 = this.tail;
        if (i2 == i8) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = this.capacityBitmask & (i8 - 1);
        E[] eArr = this.elements;
        E e = eArr[i9];
        eArr[i9] = null;
        this.tail = i9;
        return e;
    }

    public final void removeFromEnd(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.tail;
        int i9 = i2 < i8 ? i8 - i2 : 0;
        for (int i10 = i9; i10 < i8; i10++) {
            this.elements[i10] = null;
        }
        int i11 = this.tail;
        int i12 = i11 - i9;
        int i13 = i2 - i12;
        this.tail = i11 - i12;
        if (i13 > 0) {
            int length = this.elements.length;
            this.tail = length;
            int i14 = length - i13;
            for (int i15 = i14; i15 < length; i15++) {
                this.elements[i15] = null;
            }
            this.tail = i14;
        }
    }

    public final void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.elements.length;
        int i8 = this.head;
        if (i2 < length - i8) {
            length = i8 + i2;
        }
        while (i8 < length) {
            this.elements[i8] = null;
            i8++;
        }
        int i9 = this.head;
        int i10 = length - i9;
        int i11 = i2 - i10;
        this.head = this.capacityBitmask & (i9 + i10);
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                this.elements[i12] = null;
            }
            this.head = i11;
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.capacityBitmask = i2 - 1;
        this.elements = (E[]) new Object[i2];
    }

    public /* synthetic */ CircularArray(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 8 : i2);
    }
}
