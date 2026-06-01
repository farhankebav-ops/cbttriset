package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.ironsource.G5;
import e6.p;
import f6.a;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import r5.j;
import r5.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {
    private static final Object DELETED = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C03261<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C03261(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return longSparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        int i2 = longSparseArray.size;
        if (i2 != 0 && j <= longSparseArray.keys[i2 - 1]) {
            longSparseArray.put(j, e);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i2 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i8 = 0;
                for (int i9 = 0; i9 < i2; i9++) {
                    Object obj = objArr[i9];
                    if (obj != DELETED) {
                        if (i9 != i8) {
                            jArr[i8] = jArr[i9];
                            objArr[i8] = obj;
                            objArr[i9] = null;
                        }
                        i8++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i8;
            }
        }
        int i10 = longSparseArray.size;
        if (i10 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i10 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.values = objArrCopyOf;
        }
        longSparseArray.keys[i10] = j;
        longSparseArray.values[i10] = e;
        longSparseArray.size = i10 + 1;
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        k.e(longSparseArray, "<this>");
        int i2 = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i8 = 0; i8 < i2; i8++) {
            objArr[i8] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(e) >= 0;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        k.e(longSparseArray, "<this>");
        int i2 = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            Object obj = objArr[i9];
            if (obj != DELETED) {
                if (i9 != i8) {
                    jArr[i8] = jArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i8;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j) {
        k.e(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[iBinarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> longSparseArray, long j, T t3) {
        k.e(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? t3 : (T) longSparseArray.values[iBinarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j) {
        k.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i2 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e) {
        k.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i2 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        int i10 = longSparseArray.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (longSparseArray.values[i11] == e) {
                return i11;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i2) {
        int i8;
        k.e(longSparseArray, "<this>");
        if (i2 < 0 || i2 >= (i8 = longSparseArray.size)) {
            throw new IllegalArgumentException(a1.a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i9;
        }
        return longSparseArray.keys[i2];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (iBinarySearch >= 0) {
            longSparseArray.values[iBinarySearch] = e;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < longSparseArray.size && longSparseArray.values[i2] == DELETED) {
            longSparseArray.keys[i2] = j;
            longSparseArray.values[i2] = e;
            return;
        }
        if (longSparseArray.garbage) {
            int i8 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i8 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i9 = 0;
                for (int i10 = 0; i10 < i8; i10++) {
                    Object obj = objArr[i10];
                    if (obj != DELETED) {
                        if (i10 != i9) {
                            jArr[i9] = jArr[i10];
                            objArr[i9] = obj;
                            objArr[i10] = null;
                        }
                        i9++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i9;
                i2 = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i9, j);
            }
        }
        int i11 = longSparseArray.size;
        if (i11 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i11 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.values = objArrCopyOf;
        }
        int i12 = longSparseArray.size;
        if (i12 - i2 != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i13 = i2 + 1;
            j.e0(jArr2, jArr2, i13, i2, i12);
            Object[] objArr2 = longSparseArray.values;
            j.f0(objArr2, i13, objArr2, i2, longSparseArray.size);
        }
        longSparseArray.keys[i2] = j;
        longSparseArray.values[i2] = e;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> other) {
        k.e(longSparseArray, "<this>");
        k.e(other, "other");
        int size = other.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.put(other.keyAt(i2), other.valueAt(i2));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        E e4 = longSparseArray.get(j);
        if (e4 == null) {
            longSparseArray.put(j, e);
        }
        return e4;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j) {
        k.e(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[iBinarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i2) {
        k.e(longSparseArray, "<this>");
        if (longSparseArray.values[i2] != DELETED) {
            longSparseArray.values[i2] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e4 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e4;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i2, E e) {
        int i8;
        k.e(longSparseArray, "<this>");
        if (i2 < 0 || i2 >= (i8 = longSparseArray.size)) {
            throw new IllegalArgumentException(a1.a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i9;
        }
        longSparseArray.values[i2] = e;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        k.e(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i2 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i8;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        k.e(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i2 = longSparseArray.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i8));
            sb.append(G5.T);
            E eValueAt = longSparseArray.valueAt(i8);
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return androidx.camera.core.processing.util.a.g('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i2) {
        int i8;
        k.e(longSparseArray, "<this>");
        if (i2 < 0 || i2 >= (i8 = longSparseArray.size)) {
            throw new IllegalArgumentException(a1.a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i9;
        }
        return (E) longSparseArray.values[i2];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p action) {
        k.e(longSparseArray, "<this>");
        k.e(action, "action");
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t3) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.get(j, t3);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, e6.a defaultValue) {
        k.e(longSparseArray, "<this>");
        k.e(defaultValue, "defaultValue");
        T t3 = longSparseArray.get(j);
        return t3 == null ? (T) defaultValue.invoke() : t3;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        k.e(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    public static final <T> w keyIterator(final LongSparseArray<T> longSparseArray) {
        k.e(longSparseArray, "<this>");
        return new w() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // r5.w
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> other) {
        k.e(longSparseArray, "<this>");
        k.e(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(other.size() + longSparseArray.size());
        longSparseArray2.putAll(longSparseArray);
        longSparseArray2.putAll(other);
        return longSparseArray2;
    }

    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j, Object obj) {
        k.e(longSparseArray, "<this>");
        return longSparseArray.remove(j, obj);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t3) {
        k.e(longSparseArray, "<this>");
        longSparseArray.put(j, t3);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        k.e(longSparseArray, "<this>");
        return new C03261(longSparseArray);
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? e : (E) longSparseArray.values[iBinarySearch];
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j, E e, E e4) {
        k.e(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !k.a(longSparseArray.values[iIndexOfKey], e)) {
            return false;
        }
        longSparseArray.values[iIndexOfKey] = e4;
        return true;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j, E e) {
        k.e(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !k.a(e, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }
}
