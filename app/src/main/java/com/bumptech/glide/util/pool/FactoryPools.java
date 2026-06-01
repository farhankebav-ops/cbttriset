package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Factory<T> {
        T create();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.pool = pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.pool.acquire();
            if (tAcquire == null) {
                tAcquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof Poolable) {
                ((Poolable) tAcquire).getVerifier().setRecycled(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t3) {
            if (t3 instanceof Poolable) {
                ((Poolable) t3).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t3);
            return this.pool.release(t3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Resetter<T> {
        void reset(@NonNull T t3);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return build(pool, factory, emptyResetter());
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i2, @NonNull Factory<T> factory) {
        return build(new Pools.SimplePool(i2), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i2, @NonNull Factory<T> factory) {
        return build(new Pools.SynchronizedPool(i2), factory);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    private static <T> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i2, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return build(new Pools.SynchronizedPool(i2), factory, resetter);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i2) {
        return build(new Pools.SynchronizedPool(i2), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            @NonNull
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
