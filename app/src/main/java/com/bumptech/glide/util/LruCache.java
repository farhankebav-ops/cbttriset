package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Entry<Y> {
        final int size;
        final Y value;

        public Entry(Y y, int i2) {
            this.value = y;
            this.size = i2;
        }
    }

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t3) {
        return this.cache.containsKey(t3);
    }

    @Nullable
    public synchronized Y get(@NonNull T t3) {
        Entry<Y> entry;
        entry = this.cache.get(t3);
        return entry != null ? entry.value : null;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y) {
        return 1;
    }

    @Nullable
    public synchronized Y put(@NonNull T t3, @Nullable Y y) {
        int size = getSize(y);
        long j = size;
        if (j >= this.maxSize) {
            onItemEvicted(t3, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j;
        }
        Entry<Y> entryPut = this.cache.put(t3, y == null ? null : new Entry<>(y, size));
        if (entryPut != null) {
            this.currentSize -= (long) entryPut.size;
            if (!entryPut.value.equals(y)) {
                onItemEvicted(t3, entryPut.value);
            }
        }
        evict();
        return entryPut != null ? entryPut.value : null;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t3) {
        Entry<Y> entryRemove = this.cache.remove(t3);
        if (entryRemove == null) {
            return null;
        }
        this.currentSize -= (long) entryRemove.size;
        return entryRemove.value;
    }

    public synchronized void setSizeMultiplier(float f4) {
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f4);
        evict();
    }

    public synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Entry<Y>> next = it.next();
            Entry<Y> value = next.getValue();
            this.currentSize -= (long) value.size;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.value);
        }
    }

    public void onItemEvicted(@NonNull T t3, @Nullable Y y) {
    }
}
