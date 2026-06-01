package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IntListKt {
    private static final IntList EmptyIntList = new MutableIntList(0);

    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    public static final IntList intListOf() {
        return EmptyIntList;
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final IntList intListOf(int i2) {
        return mutableIntListOf(i2);
    }

    public static final MutableIntList mutableIntListOf(int i2) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i2);
        return mutableIntList;
    }

    public static final IntList intListOf(int i2, int i8) {
        return mutableIntListOf(i2, i8);
    }

    public static final IntList intListOf(int i2, int i8, int i9) {
        return mutableIntListOf(i2, i8, i9);
    }

    public static final MutableIntList mutableIntListOf(int i2, int i8) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i2);
        mutableIntList.add(i8);
        return mutableIntList;
    }

    public static final IntList intListOf(int... elements) {
        k.e(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i2, int i8, int i9) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i2);
        mutableIntList.add(i8);
        mutableIntList.add(i9);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int... elements) {
        k.e(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }
}
