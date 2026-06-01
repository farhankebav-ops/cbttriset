package androidx.collection.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LruHashMap<K, V> {
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        this(0, 0.0f, 3, null);
    }

    public final V get(K key) {
        k.e(key, "key");
        return this.map.get(key);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> setEntrySet = this.map.entrySet();
        k.d(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final V put(K key, V value) {
        k.e(key, "key");
        k.e(value, "value");
        return this.map.put(key, value);
    }

    public final V remove(K key) {
        k.e(key, "key");
        return this.map.remove(key);
    }

    public LruHashMap(int i2, float f4) {
        this.map = new LinkedHashMap<>(i2, f4, true);
    }

    public /* synthetic */ LruHashMap(int i2, float f4, int i8, f fVar) {
        this((i8 & 1) != 0 ? 16 : i2, (i8 & 2) != 0 ? 0.75f : f4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruHashMap(LruHashMap<? extends K, V> original) {
        this(0, 0.0f, 3, null);
        k.e(original, "original");
        for (Map.Entry<? extends K, V> entry : original.getEntries()) {
            put(entry.getKey(), entry.getValue());
        }
    }
}
