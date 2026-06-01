package com.bytedance.sdk.component.Cc.tV.EO.IlO;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO<K, V> {
    private final LinkedHashMap<K, SoftReference<V>> IlO = new LinkedHashMap<>(0, 0.75f, true);
    private int MY;

    public EO(int i2) {
        this.MY = i2;
    }

    public synchronized V IlO(K k) {
        V v2 = null;
        if (k == null) {
            return null;
        }
        if (this.MY <= 0) {
            return null;
        }
        SoftReference<V> softReference = this.IlO.get(k);
        if (softReference != null) {
            v2 = softReference.get();
            if (v2 != null) {
                return v2;
            }
            this.IlO.remove(k);
        }
        return v2;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxCount=%d,size=%d]", Integer.valueOf(this.MY), Integer.valueOf(this.IlO.size()));
    }

    public synchronized void IlO(K k, V v2) {
        if (this.MY <= 0) {
            return;
        }
        if (k == null || v2 == null) {
            return;
        }
        this.IlO.put(k, new SoftReference<>(v2));
        int size = this.IlO.size();
        int i2 = this.MY;
        if (size > i2) {
            IlO((int) (((double) i2) * 0.7d));
        }
    }

    public synchronized void IlO(int i2) {
        int size = this.IlO.size() - i2;
        if (size > 0) {
            Iterator<Map.Entry<K, SoftReference<V>>> it = this.IlO.entrySet().iterator();
            for (int i8 = 0; i8 < size; i8++) {
                it.next();
                it.remove();
            }
        }
        if (i2 == 0) {
            return;
        }
        Iterator<Map.Entry<K, SoftReference<V>>> it2 = this.IlO.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue().get() == null) {
                it2.remove();
            }
        }
    }
}
