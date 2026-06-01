package androidx.collection;

import f6.a;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, a {
    private final K key;
    private final V value;

    public MapEntry(K k, V v2) {
        this.key = k;
        this.value = v2;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
