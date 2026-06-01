package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.pool = new Object[i2];
        }

        private final boolean isInPool(T t3) {
            int i2 = this.poolSize;
            for (int i8 = 0; i8 < i2; i8++) {
                if (this.pool[i8] == t3) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i2 = this.poolSize;
            if (i2 <= 0) {
                return null;
            }
            int i8 = i2 - 1;
            T t3 = (T) this.pool[i8];
            k.c(t3, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i8] = null;
            this.poolSize--;
            return t3;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            k.e(instance, "instance");
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i2 = this.poolSize;
            Object[] objArr = this.pool;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = instance;
            this.poolSize = i2 + 1;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        public SynchronizedPool(int i2) {
            super(i2);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t3;
            synchronized (this.lock) {
                t3 = (T) super.acquire();
            }
            return t3;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            boolean zRelease;
            k.e(instance, "instance");
            synchronized (this.lock) {
                zRelease = super.release(instance);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
