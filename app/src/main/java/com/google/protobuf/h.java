package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends a implements Internal.BooleanList, RandomAccess, w1 {
    private static final h EMPTY_LIST = new h(new boolean[0], 0, false);
    private boolean[] array;
    private int size;

    public h() {
        this(new boolean[10], 0, true);
    }

    public static h emptyList() {
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
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof h)) {
            return super.addAll(collection);
        }
        h hVar = (h) collection;
        int i2 = hVar.size;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.size;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        boolean[] zArr = this.array;
        if (i9 > zArr.length) {
            this.array = Arrays.copyOf(zArr, i9);
        }
        System.arraycopy(hVar.array, 0, this.array, this.size, hVar.size);
        this.size = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z2) {
        ensureIsMutable();
        int i2 = this.size;
        boolean[] zArr = this.array;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[androidx.camera.core.processing.util.a.a(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        zArr3[i8] = z2;
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
        if (!(obj instanceof h)) {
            return super.equals(obj);
        }
        h hVar = (h) obj;
        if (this.size != hVar.size) {
            return false;
        }
        boolean[] zArr = hVar.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.array[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            iHashBoolean = (iHashBoolean * 31) + Internal.hashBoolean(this.array[i2]);
        }
        return iHashBoolean;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.array[i2] == zBooleanValue) {
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
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i8, zArr, i2, this.size - i8);
        this.size -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i2, boolean z2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        boolean[] zArr = this.array;
        boolean z7 = zArr[i2];
        zArr[i2] = z2;
        return z7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private h(boolean[] zArr, int i2, boolean z2) {
        super(z2);
        this.array = zArr;
        this.size = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i2) {
        return Boolean.valueOf(getBoolean(i2));
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i2) {
        if (i2 >= this.size) {
            return new h(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Boolean remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        boolean[] zArr = this.array;
        boolean z2 = zArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public Boolean set(int i2, Boolean bool) {
        return Boolean.valueOf(setBoolean(i2, bool.booleanValue()));
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.a, java.util.AbstractList, java.util.List
    public void add(int i2, Boolean bool) {
        addBoolean(i2, bool.booleanValue());
    }

    private void addBoolean(int i2, boolean z2) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            boolean[] zArr = this.array;
            if (i8 < zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i8 - i2);
            } else {
                boolean[] zArr2 = new boolean[androidx.camera.core.processing.util.a.a(i8, 3, 2, 1)];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                System.arraycopy(this.array, i2, zArr2, i2 + 1, this.size - i2);
                this.array = zArr2;
            }
            this.array[i2] = z2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
