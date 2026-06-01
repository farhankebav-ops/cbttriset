package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0, false);
    private E[] array;
    private int size;

    public ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    private static <E> E[] createArray(int i2) {
        return (E[]) new Object[i2];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
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

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        ensureIsMutable();
        int i2 = this.size;
        E[] eArr = this.array;
        if (i2 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        eArr2[i8] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        E[] eArr = this.array;
        E e = eArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (r2 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i2, E e) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        E[] eArr = this.array;
        E e4 = eArr[i2];
        eArr[i2] = e;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i2, boolean z2) {
        super(z2);
        this.array = eArr;
        this.size = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i2), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i2, E e) {
        int i8;
        ensureIsMutable();
        if (i2 >= 0 && i2 <= (i8 = this.size)) {
            E[] eArr = this.array;
            if (i8 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i8 - i2);
            } else {
                E[] eArr2 = (E[]) createArray(androidx.camera.core.processing.util.a.a(i8, 3, 2, 1));
                System.arraycopy(this.array, 0, eArr2, 0, i2);
                System.arraycopy(this.array, i2, eArr2, i2 + 1, this.size - i2);
                this.array = eArr2;
            }
            this.array[i2] = e;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
    }
}
