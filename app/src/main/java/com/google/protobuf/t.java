package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends a implements Internal.DoubleList, RandomAccess, w1 {
    private static final t EMPTY_LIST = new t(new double[0], 0, false);
    private double[] array;
    private int size;

    public t() {
        this(new double[10], 0, true);
    }

    public static t emptyList() {
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
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i2 = tVar.size;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.size;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        double[] dArr = this.array;
        if (i9 > dArr.length) {
            this.array = Arrays.copyOf(dArr, i9);
        }
        System.arraycopy(tVar.array, 0, this.array, this.size, tVar.size);
        this.size = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d8) {
        ensureIsMutable();
        int i2 = this.size;
        double[] dArr = this.array;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[androidx.camera.core.processing.util.a.a(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        dArr3[i8] = d8;
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
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.size != tVar.size) {
            return false;
        }
        double[] dArr = tVar.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Double.doubleToLongBits(this.array[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i2]));
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.array[i2] == dDoubleValue) {
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
        double[] dArr = this.array;
        System.arraycopy(dArr, i8, dArr, i2, this.size - i8);
        this.size -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i2, double d8) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        double[] dArr = this.array;
        double d9 = dArr[i2];
        dArr[i2] = d8;
        return d9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private t(double[] dArr, int i2, boolean z2) {
        super(z2);
        this.array = dArr;
        this.size = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i2) {
        return Double.valueOf(getDouble(i2));
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int i2) {
        if (i2 >= this.size) {
            return new t(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Double remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        double[] dArr = this.array;
        double d8 = dArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Double set(int i2, Double d8) {
        return Double.valueOf(setDouble(i2, d8.doubleValue()));
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double d8) {
        addDouble(d8.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public void add(int i2, Double d8) {
        addDouble(i2, d8.doubleValue());
    }

    private void addDouble(int i2, double d8) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            double[] dArr = this.array;
            if (i8 < dArr.length) {
                System.arraycopy(dArr, i2, dArr, i2 + 1, i8 - i2);
            } else {
                double[] dArr2 = new double[androidx.camera.core.processing.util.a.a(i8, 3, 2, 1)];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                System.arraycopy(this.array, i2, dArr2, i2 + 1, this.size - i2);
                this.array = dArr2;
            }
            this.array[i2] = d8;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
