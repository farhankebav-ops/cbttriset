package com.bytedance.sdk.component.Cc.EO.IlO;

import com.ironsource.C2300e4;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO<K, V> {
    private int Bc;
    private int Cc;
    private int EO;
    private final LinkedHashMap<K, SoftReference<V>> IlO;
    private int MY;
    private int lEW;
    private int tV;
    private int vCE;

    public EO(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.EO = i2;
        this.IlO = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int EO(K k, V v2) {
        int iMY = MY(k, v2);
        if (iMY >= 0) {
            return iMY;
        }
        throw new IllegalStateException("Negative size: " + k + C2300e4.i.f8399b + v2);
    }

    public final V IlO(K k) {
        V v2;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.IlO.get(k);
                if (softReference != null) {
                    v2 = softReference.get();
                    if (v2 != null) {
                        this.Bc++;
                        return v2;
                    }
                    this.IlO.remove(k);
                } else {
                    v2 = null;
                }
                this.lEW++;
                V vMY = MY(k);
                if (vMY == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.Cc++;
                        SoftReference<V> softReferencePut = this.IlO.put(k, new SoftReference<>(vMY));
                        if (softReferencePut != null) {
                            v2 = softReferencePut.get();
                        }
                        if (v2 != null) {
                            this.IlO.put(k, softReferencePut);
                        } else {
                            this.MY += EO(k, vMY);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (v2 != null) {
                    return v2;
                }
                IlO(this.EO);
                return vMY;
            } finally {
            }
        }
    }

    public int MY(K k, V v2) {
        return 1;
    }

    public final synchronized String toString() {
        int i2;
        int i8;
        try {
            i2 = this.Bc;
            i8 = this.lEW + i2;
        } catch (Throwable th) {
            throw th;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.EO), Integer.valueOf(this.Bc), Integer.valueOf(this.lEW), Integer.valueOf(i8 != 0 ? (i2 * 100) / i8 : 0));
    }

    public V MY(K k) {
        return null;
    }

    public final V IlO(K k, V v2) {
        V v7;
        if (k != null && v2 != null) {
            synchronized (this) {
                try {
                    this.tV++;
                    this.MY += EO(k, v2);
                    SoftReference<V> softReferencePut = this.IlO.put(k, new SoftReference<>(v2));
                    if (softReferencePut != null) {
                        v7 = softReferencePut.get();
                        if (v7 != null) {
                            this.MY -= EO(k, v7);
                        }
                    } else {
                        v7 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            IlO(this.EO);
            return v7;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r3.MY + ", maxSize: " + r4);
        r3.MY = 0;
        r3.IlO.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.MY     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L54
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.IlO     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.MY     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            goto L54
        L12:
            r4 = move-exception
            goto L7b
        L14:
            int r0 = r3.MY     // Catch: java.lang.Throwable -> L12
            if (r0 > r4) goto L1a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L1a:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.IlO     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L2e
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L2e:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.IlO     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L12
            int r2 = r3.MY     // Catch: java.lang.Throwable -> L12
            int r0 = r3.EO(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.MY = r2     // Catch: java.lang.Throwable -> L12
        L4c:
            int r0 = r3.vCE     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.vCE = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L54:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.MY     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            r1.append(r4)     // Catch: java.lang.Throwable -> L12
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L12
            android.util.Log.e(r0, r4)     // Catch: java.lang.Throwable -> L12
            r4 = 0
            r3.MY = r4     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.IlO     // Catch: java.lang.Throwable -> L12
            r4.clear()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L7b:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Cc.EO.IlO.EO.IlO(int):void");
    }
}
