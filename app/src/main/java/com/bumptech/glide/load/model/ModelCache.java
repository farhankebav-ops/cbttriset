package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a8, int i2, int i8) {
            ModelKey<A> modelKey;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                modelKey = (ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.init(a8, i2, i8);
            return modelKey;
        }

        private void init(A a8, int i2, int i8) {
            this.model = a8;
            this.width = i2;
            this.height = i8;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a8, int i2, int i8) {
        ModelKey<A> modelKey = ModelKey.get(a8, i2, i8);
        B b8 = this.cache.get(modelKey);
        modelKey.release();
        return b8;
    }

    public void put(A a8, int i2, int i8, B b8) {
        this.cache.put(ModelKey.get(a8, i2, i8), b8);
    }

    public ModelCache(long j) {
        this.cache = new LruCache<ModelKey<A>, B>(j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // com.bumptech.glide.util.LruCache
            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b8) {
                modelKey.release();
            }
        };
    }
}
