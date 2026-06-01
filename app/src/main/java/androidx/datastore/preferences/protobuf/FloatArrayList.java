package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST = new FloatArrayList(new float[0], 0, false);
    private float[] array;
    private int size;

    public FloatArrayList() {
        this(new float[10], 0, true);
    }

    public static FloatArrayList emptyList() {
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

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i2 = floatArrayList.size;
        if (i2 == 0) {
            return false;
        }
        int i8 = this.size;
        if (Integer.MAX_VALUE - i8 < i2) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i2;
        float[] fArr = this.array;
        if (i9 > fArr.length) {
            this.array = Arrays.copyOf(fArr, i9);
        }
        System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
        this.size = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public void addFloat(float f4) {
        ensureIsMutable();
        int i2 = this.size;
        float[] fArr = this.array;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[androidx.camera.core.processing.util.a.a(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        fArr3[i8] = f4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Float.floatToIntBits(this.array[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public float getFloat(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.array[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.array[i2] == fFloatValue) {
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
        float[] fArr = this.array;
        System.arraycopy(fArr, i8, fArr, i2, this.size - i8);
        this.size -= i8 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public float setFloat(int i2, float f4) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        float[] fArr = this.array;
        float f8 = fArr[i2];
        fArr[i2] = f4;
        return f8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private FloatArrayList(float[] fArr, int i2, boolean z2) {
        super(z2);
        this.array = fArr;
        this.size = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i2) {
        return Float.valueOf(getFloat(i2));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i2) {
        if (i2 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        float[] fArr = this.array;
        float f4 = fArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int i2, Float f4) {
        return Float.valueOf(setFloat(i2, f4.floatValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Float f4) {
        addFloat(f4.floatValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i2, Float f4) {
        addFloat(i2, f4.floatValue());
    }

    private void addFloat(int i2, float f4) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            float[] fArr = this.array;
            if (i8 < fArr.length) {
                System.arraycopy(fArr, i2, fArr, i2 + 1, i8 - i2);
            } else {
                float[] fArr2 = new float[androidx.camera.core.processing.util.a.a(i8, 3, 2, 1)];
                System.arraycopy(fArr, 0, fArr2, 0, i2);
                System.arraycopy(this.array, i2, fArr2, i2 + 1, this.size - i2);
                this.array = fArr2;
            }
            this.array[i2] = f4;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
