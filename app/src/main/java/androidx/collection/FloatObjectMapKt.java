package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatObjectMapKt {
    private static final MutableFloatObjectMap EmptyFloatObjectMap = new MutableFloatObjectMap(0);

    public static final <V> FloatObjectMap<V> emptyFloatObjectMap() {
        MutableFloatObjectMap mutableFloatObjectMap = EmptyFloatObjectMap;
        k.c(mutableFloatObjectMap, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.emptyFloatObjectMap>");
        return mutableFloatObjectMap;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf() {
        MutableFloatObjectMap mutableFloatObjectMap = EmptyFloatObjectMap;
        k.c(mutableFloatObjectMap, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.floatObjectMapOf>");
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf() {
        return new MutableFloatObjectMap<>(0, 1, null);
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f4, V v2) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f4, V v2) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        return mutableFloatObjectMap;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f4, V v2, float f8, V v7) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f4, V v2, float f8, V v7) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        return mutableFloatObjectMap;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        return mutableFloatObjectMap;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8, float f10, V v9) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8, float f10, V v9) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        return mutableFloatObjectMap;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8, float f10, V v9, float f11, V v10) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        mutableFloatObjectMap.set(f11, v10);
        return mutableFloatObjectMap;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f4, V v2, float f8, V v7, float f9, V v8, float f10, V v9, float f11, V v10) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f4, v2);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        mutableFloatObjectMap.set(f11, v10);
        return mutableFloatObjectMap;
    }
}
