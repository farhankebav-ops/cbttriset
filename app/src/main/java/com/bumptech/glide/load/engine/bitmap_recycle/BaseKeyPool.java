package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T tPoll = this.keyPool.poll();
        return tPoll == null ? (T) create() : tPoll;
    }

    public void offer(T t3) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t3);
        }
    }
}
