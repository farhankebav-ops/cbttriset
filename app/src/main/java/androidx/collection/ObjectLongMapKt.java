package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectLongMapKt {
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = new MutableObjectLongMap<>(0);

    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        k.c(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, null);
    }

    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        k.c(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k8, long j3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k8, long j3) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k8, long j3, K k9, long j8) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k8, long j3, K k9, long j8) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k8, long j3, K k9, long j8, K k10, long j9) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        mutableObjectLongMap.set(k10, j9);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k8, long j3, K k9, long j8, K k10, long j9) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        mutableObjectLongMap.set(k10, j9);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k8, long j3, K k9, long j8, K k10, long j9, K k11, long j10) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        mutableObjectLongMap.set(k10, j9);
        mutableObjectLongMap.set(k11, j10);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k8, long j3, K k9, long j8, K k10, long j9, K k11, long j10) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k8, j3);
        mutableObjectLongMap.set(k9, j8);
        mutableObjectLongMap.set(k10, j9);
        mutableObjectLongMap.set(k11, j10);
        return mutableObjectLongMap;
    }
}
