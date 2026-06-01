package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IntObjectMapKt {
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    public static final <V> IntObjectMap<V> emptyIntObjectMap() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        k.c(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.emptyIntObjectMap>");
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        k.c(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, null);
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i2, V v2) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i2, V v2) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i2, V v2, int i8, V v7) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i2, V v2, int i8, V v7) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8, int i10, V v9) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8, int i10, V v9) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8, int i10, V v9, int i11, V v10) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        mutableIntObjectMap.set(i11, v10);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i2, V v2, int i8, V v7, int i9, V v8, int i10, V v9, int i11, V v10) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i2, v2);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        mutableIntObjectMap.set(i11, v10);
        return mutableIntObjectMap;
    }
}
