package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatSetKt {
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);
    private static final float[] EmptyFloatArray = new float[0];

    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float f4) {
        int iFloatToIntBits = Float.floatToIntBits(f4) * ScatterMapKt.MurmurHashC1;
        return iFloatToIntBits ^ (iFloatToIntBits << 16);
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    public static final FloatSet floatSetOf(float f4) {
        return mutableFloatSetOf(f4);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f4) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f4);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float f4, float f8) {
        return mutableFloatSetOf(f4, f8);
    }

    public static final FloatSet floatSetOf(float f4, float f8, float f9) {
        return mutableFloatSetOf(f4, f8, f9);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f4, float f8) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f4);
        mutableFloatSet.plusAssign(f8);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float... elements) {
        k.e(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f4, float f8, float f9) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f4);
        mutableFloatSet.plusAssign(f8);
        mutableFloatSet.plusAssign(f9);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float... elements) {
        k.e(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }
}
