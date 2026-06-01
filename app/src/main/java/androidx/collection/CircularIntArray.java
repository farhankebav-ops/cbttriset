package androidx.collection;

import kotlin.jvm.internal.f;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i2 = this.head;
        int i8 = length - i2;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i9];
        j.c0(0, i2, length, iArr, iArr2);
        j.c0(i8, 0, this.head, this.elements, iArr2);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i9 - 1;
    }

    public final void addFirst(int i2) {
        int i8 = (this.head - 1) & this.capacityBitmask;
        this.head = i8;
        this.elements[i8] = i2;
        if (i8 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i2) {
        int[] iArr = this.elements;
        int i8 = this.tail;
        iArr[i8] = i2;
        int i9 = this.capacityBitmask & (i8 + 1);
        this.tail = i9;
        if (i9 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i2)];
    }

    public final int getFirst() {
        int i2 = this.head;
        if (i2 != this.tail) {
            return this.elements[i2];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i2 = this.head;
        int i8 = this.tail;
        if (i2 != i8) {
            return this.elements[(i8 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i2 = this.head;
        if (i2 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.elements[i2];
        this.head = (i2 + 1) & this.capacityBitmask;
        return i8;
    }

    public final int popLast() {
        int i2 = this.head;
        int i8 = this.tail;
        if (i2 == i8) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = this.capacityBitmask & (i8 - 1);
        int i10 = this.elements[i9];
        this.tail = i9;
        return i10;
    }

    public final void removeFromEnd(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i2);
    }

    public final void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i2);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.capacityBitmask = i2 - 1;
        this.elements = new int[i2];
    }

    public /* synthetic */ CircularIntArray(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 8 : i2);
    }
}
