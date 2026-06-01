package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class y1 extends a implements RandomAccess {
    private static final y1 EMPTY_LIST = new y1(new Object[0], 0, false);
    private Object[] array;
    private int size;

    public y1() {
        this(new Object[10], 0, true);
    }

    private static <E> E[] createArray(int i2) {
        return (E[]) new Object[i2];
    }

    public static <E> y1 emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i2) {
        StringBuilder sbV = a1.a.v(i2, "Index:", ", Size:");
        sbV.append(this.size);
        return sbV.toString();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ensureIsMutable();
        int i2 = this.size;
        Object[] objArr = this.array;
        if (i2 == objArr.length) {
            this.array = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        objArr2[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Object remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        Object[] objArr = this.array;
        Object obj = objArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        Object[] objArr = this.array;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private y1(Object[] objArr, int i2, boolean z2) {
        super(z2);
        this.array = objArr;
        this.size = i2;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public y1 mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new y1(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            Object[] objArr = this.array;
            if (i8 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i8 - i2);
            } else {
                Object[] objArrCreateArray = createArray(androidx.camera.core.processing.util.a.a(i8, 3, 2, 1));
                System.arraycopy(this.array, 0, objArrCreateArray, 0, i2);
                System.arraycopy(this.array, i2, objArrCreateArray, i2 + 1, this.size - i2);
                this.array = objArrCreateArray;
            }
            this.array[i2] = obj;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
