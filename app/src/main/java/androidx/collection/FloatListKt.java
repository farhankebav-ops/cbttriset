package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatListKt {
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final FloatList floatListOf(float f4) {
        return mutableFloatListOf(f4);
    }

    public static final MutableFloatList mutableFloatListOf(float f4) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f4);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float f4, float f8) {
        return mutableFloatListOf(f4, f8);
    }

    public static final FloatList floatListOf(float f4, float f8, float f9) {
        return mutableFloatListOf(f4, f8, f9);
    }

    public static final MutableFloatList mutableFloatListOf(float f4, float f8) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f4);
        mutableFloatList.add(f8);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float... elements) {
        k.e(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f4, float f8, float f9) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f4);
        mutableFloatList.add(f8);
        mutableFloatList.add(f9);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float... elements) {
        k.e(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }
}
