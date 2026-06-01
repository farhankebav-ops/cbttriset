package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends a implements Internal.IntList, RandomAccess, w1 {
    private static final p0 EMPTY_LIST = new p0(new int[0], 0, false);
    private int[] array;
    private int size;

    public p0() {
        this(new int[10], 0, true);
    }

    public static p0 emptyList() {
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

    @Override // com.google.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof p0)) {
            return super.addAll(collection);
        }
        p0 p0Var = (p0) collection;
        int i2 = p0Var.size;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.size;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        int[] iArr = this.array;
        if (i9 > iArr.length) {
            this.array = Arrays.copyOf(iArr, i9);
        }
        System.arraycopy(p0Var.array, 0, this.array, this.size, p0Var.size);
        this.size = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int i2) {
        ensureIsMutable();
        int i8 = this.size;
        int[] iArr = this.array;
        if (i8 == iArr.length) {
            int[] iArr2 = new int[androidx.camera.core.processing.util.a.a(i8, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i8);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i9 = this.size;
        this.size = i9 + 1;
        iArr3[i9] = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return super.equals(obj);
        }
        p0 p0Var = (p0) obj;
        if (this.size != p0Var.size) {
            return false;
        }
        int[] iArr = p0Var.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.array[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i2 = 1;
        for (int i8 = 0; i8 < this.size; i8++) {
            i2 = (i2 * 31) + this.array[i8];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.array[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i2, int i8) {
        ensureIsMutable();
        if (i8 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.array;
        System.arraycopy(iArr, i8, iArr, i2, this.size - i8);
        this.size -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int i2, int i8) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        int[] iArr = this.array;
        int i9 = iArr[i2];
        iArr[i2] = i8;
        return i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private p0(int[] iArr, int i2, boolean z2) {
        super(z2);
        this.array = iArr;
        this.size = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i2) {
        if (i2 >= this.size) {
            return new p0(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Integer remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        int[] iArr = this.array;
        int i8 = iArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i8);
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Integer set(int i2, Integer num) {
        return Integer.valueOf(setInt(i2, num.intValue()));
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public void add(int i2, Integer num) {
        addInt(i2, num.intValue());
    }

    private void addInt(int i2, int i8) {
        int i9;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i9 = this.size)) {
            int[] iArr = this.array;
            if (i9 < iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i9 - i2);
            } else {
                int[] iArr2 = new int[androidx.camera.core.processing.util.a.a(i9, 3, 2, 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                System.arraycopy(this.array, i2, iArr2, i2 + 1, this.size - i2);
                this.array = iArr2;
            }
            this.array[i2] = i8;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
