package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        k.c(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        k.c(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j3, V v7) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j3, V v7) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8, long j9, V v9) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        mutableLongObjectMap.set(j9, v9);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8, long j9, V v9) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        mutableLongObjectMap.set(j9, v9);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8, long j9, V v9, long j10, V v10) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        mutableLongObjectMap.set(j9, v9);
        mutableLongObjectMap.set(j10, v10);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j3, V v7, long j8, V v8, long j9, V v9, long j10, V v10) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j3, v7);
        mutableLongObjectMap.set(j8, v8);
        mutableLongObjectMap.set(j9, v9);
        mutableLongObjectMap.set(j10, v10);
        return mutableLongObjectMap;
    }
}
