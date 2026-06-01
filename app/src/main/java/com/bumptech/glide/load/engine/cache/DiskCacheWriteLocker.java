package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class WriteLock {
        int interestedThreads;
        final Lock lock = new ReentrantLock();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool = new ArrayDeque();

        public WriteLock obtain() {
            WriteLock writeLockPoll;
            synchronized (this.pool) {
                writeLockPoll = this.pool.poll();
            }
            return writeLockPoll == null ? new WriteLock() : writeLockPoll;
        }

        public void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                try {
                    if (this.pool.size() < 10) {
                        this.pool.offer(writeLock);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void acquire(String str) {
        WriteLock writeLockObtain;
        synchronized (this) {
            try {
                writeLockObtain = this.locks.get(str);
                if (writeLockObtain == null) {
                    writeLockObtain = this.writeLockPool.obtain();
                    this.locks.put(str, writeLockObtain);
                }
                writeLockObtain.interestedThreads++;
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLockObtain.lock.lock();
    }

    public void release(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) Preconditions.checkNotNull(this.locks.get(str));
                int i2 = writeLock.interestedThreads;
                if (i2 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
                }
                int i8 = i2 - 1;
                writeLock.interestedThreads = i8;
                if (i8 == 0) {
                    WriteLock writeLockRemove = this.locks.remove(str);
                    if (!writeLockRemove.equals(writeLock)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLockRemove + ", safeKey: " + str);
                    }
                    this.writeLockPool.offer(writeLockRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.lock.unlock();
    }
}
