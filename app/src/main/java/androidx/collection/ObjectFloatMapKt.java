package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectFloatMapKt {
    private static final MutableObjectFloatMap<Object> EmptyObjectFloatMap = new MutableObjectFloatMap<>(0);

    public static final <K> ObjectFloatMap<K> emptyObjectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        k.c(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap<>(0, 1, null);
    }

    public static final <K> ObjectFloatMap<K> objectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        k.c(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f4) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f4) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f4, K k8, float f8) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f4, K k8, float f8) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9, K k10, float f10) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9, K k10, float f10) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9, K k10, float f10, K k11, float f11) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        mutableObjectFloatMap.set(k11, f11);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f4, K k8, float f8, K k9, float f9, K k10, float f10, K k11, float f11) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f4);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        mutableObjectFloatMap.set(k11, f11);
        return mutableObjectFloatMap;
    }
}
