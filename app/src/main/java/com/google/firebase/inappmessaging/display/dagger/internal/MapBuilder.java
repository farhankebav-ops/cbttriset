package com.google.firebase.inappmessaging.display.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i2) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i2);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i2) {
        return new MapBuilder<>(i2);
    }

    public Map<K, V> build() {
        return this.contributions.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.contributions);
    }

    public MapBuilder<K, V> put(K k, V v2) {
        this.contributions.put(k, v2);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
