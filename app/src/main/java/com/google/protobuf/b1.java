package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends a implements Internal.LongList, RandomAccess, w1 {
    private static final b1 EMPTY_LIST = new b1(new long[0], 0, false);
    private long[] array;
    private int size;

    public b1() {
        this(new long[10], 0, true);
    }

    public static b1 emptyList() {
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
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof b1)) {
            return super.addAll(collection);
        }
        b1 b1Var = (b1) collection;
        int i2 = b1Var.size;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.size;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        long[] jArr = this.array;
        if (i9 > jArr.length) {
            this.array = Arrays.copyOf(jArr, i9);
        }
        System.arraycopy(b1Var.array, 0, this.array, this.size, b1Var.size);
        this.size = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long j) {
        ensureIsMutable();
        int i2 = this.size;
        long[] jArr = this.array;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[androidx.camera.core.processing.util.a.a(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        jArr3[i8] = j;
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
        if (!(obj instanceof b1)) {
            return super.equals(obj);
        }
        b1 b1Var = (b1) obj;
        if (this.size != b1Var.size) {
            return false;
        }
        long[] jArr = b1Var.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.array[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(this.array[i2]);
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.array[i2] == jLongValue) {
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
        long[] jArr = this.array;
        System.arraycopy(jArr, i8, jArr, i2, this.size - i8);
        this.size -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int i2, long j) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        long[] jArr = this.array;
        long j3 = jArr[i2];
        jArr[i2] = j;
        return j3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private b1(long[] jArr, int i2, boolean z2) {
        super(z2);
        this.array = jArr;
        this.size = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i2) {
        return Long.valueOf(getLong(i2));
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i2) {
        if (i2 >= this.size) {
            return new b1(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Long remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        long[] jArr = this.array;
        long j = jArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Long set(int i2, Long l) {
        return Long.valueOf(setLong(i2, l.longValue()));
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long l) {
        addLong(l.longValue());
        return true;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public void add(int i2, Long l) {
        addLong(i2, l.longValue());
    }

    private void addLong(int i2, long j) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            long[] jArr = this.array;
            if (i8 < jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i8 - i2);
            } else {
                long[] jArr2 = new long[androidx.camera.core.processing.util.a.a(i8, 3, 2, 1)];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                System.arraycopy(this.array, i2, jArr2, i2 + 1, this.size - i2);
                this.array = jArr2;
            }
            this.array[i2] = j;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
