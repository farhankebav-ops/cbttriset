package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i2) {
        int i8 = i2 * ScatterMapKt.MurmurHashC1;
        return i8 ^ (i8 << 16);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final IntSet intSetOf(int i2) {
        return mutableIntSetOf(i2);
    }

    public static final MutableIntSet mutableIntSetOf(int i2) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i2);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i2, int i8) {
        return mutableIntSetOf(i2, i8);
    }

    public static final IntSet intSetOf(int i2, int i8, int i9) {
        return mutableIntSetOf(i2, i8, i9);
    }

    public static final MutableIntSet mutableIntSetOf(int i2, int i8) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i8);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int... elements) {
        k.e(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i2, int i8, int i9) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i8);
        mutableIntSet.plusAssign(i9);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int... elements) {
        k.e(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
