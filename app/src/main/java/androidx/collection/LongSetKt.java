package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSetKt {
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);
    private static final long[] EmptyLongArray = new long[0];

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j) {
        int i2 = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        return i2 ^ (i2 << 16);
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final LongSet longSetOf(long j) {
        return mutableLongSetOf(j);
    }

    public static final MutableLongSet mutableLongSetOf(long j) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long j, long j3) {
        return mutableLongSetOf(j, j3);
    }

    public static final LongSet longSetOf(long j, long j3, long j8) {
        return mutableLongSetOf(j, j3, j8);
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j3) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j3);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long... elements) {
        k.e(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j3, long j8) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j3);
        mutableLongSet.plusAssign(j8);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long... elements) {
        k.e(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }
}
