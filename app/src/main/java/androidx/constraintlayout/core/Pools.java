package androidx.constraintlayout.core;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t3);

        void releaseAll(T[] tArr, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i2];
        }

        private boolean isInPool(T t3) {
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (this.mPool[i2] == t3) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i2 = this.mPoolSize;
            if (i2 <= 0) {
                return null;
            }
            int i8 = i2 - 1;
            Object[] objArr = this.mPool;
            T t3 = (T) objArr[i8];
            objArr[i8] = null;
            this.mPoolSize = i2 - 1;
            return t3;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t3) {
            int i2 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t3;
            this.mPoolSize = i2 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i8 = 0; i8 < i2; i8++) {
                T t3 = tArr[i8];
                int i9 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i9 < objArr.length) {
                    objArr[i9] = t3;
                    this.mPoolSize = i9 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
