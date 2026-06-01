package com.bytedance.adsdk.MY;

import com.ironsource.C2300e4;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL<K, V> {
    private int Bc;
    private int Cc;
    private int EO;
    private final LinkedHashMap<K, V> IlO;
    private int MY;
    private int lEW;
    private int tV;
    private int vCE;

    public bWL(int i2) {
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
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v2 = this.IlO.get(k);
                if (v2 != null) {
                    this.Bc++;
                    return v2;
                }
                this.lEW++;
                V vMY = MY(k);
                if (vMY == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.Cc++;
                        vPut = this.IlO.put(k, vMY);
                        if (vPut != null) {
                            this.IlO.put(k, vPut);
                        } else {
                            this.MY += EO(k, vMY);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (vPut != null) {
                    return vPut;
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
        try {
            int i8 = this.Bc;
            int i9 = this.lEW + i8;
            i2 = i9 != 0 ? (i8 * 100) / i9 : 0;
            Locale locale = Locale.US;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + this.EO + ",hits=" + this.Bc + ",misses=" + this.lEW + ",hitRate=" + i2 + "%]";
    }

    public V MY(K k) {
        return null;
    }

    public final V IlO(K k, V v2) {
        V vPut;
        if (k != null && v2 != null) {
            synchronized (this) {
                try {
                    this.tV++;
                    this.MY += EO(k, v2);
                    vPut = this.IlO.put(k, v2);
                    if (vPut != null) {
                        this.MY -= EO(k, vPut);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            IlO(this.EO);
            return vPut;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
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
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<K, V> r0 = r3.IlO     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.MY     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L51
            goto L14
        L12:
            r4 = move-exception
            goto L70
        L14:
            int r0 = r3.MY     // Catch: java.lang.Throwable -> L12
            if (r0 <= r4) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.IlO     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L4f
        L21:
            java.util.LinkedHashMap<K, V> r0 = r3.IlO     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, V> r2 = r3.IlO     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.MY     // Catch: java.lang.Throwable -> L12
            int r0 = r3.EO(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.MY = r2     // Catch: java.lang.Throwable -> L12
            int r0 = r3.vCE     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.vCE = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L51:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r4     // Catch: java.lang.Throwable -> L12
        L70:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.bWL.IlO(int):void");
    }
}
