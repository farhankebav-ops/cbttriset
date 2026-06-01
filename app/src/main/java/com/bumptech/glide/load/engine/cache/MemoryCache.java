package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCache {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ResourceRemovedListener {
        void onResourceRemoved(@NonNull Resource<?> resource);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    @Nullable
    Resource<?> put(@NonNull Key key, @Nullable Resource<?> resource);

    @Nullable
    Resource<?> remove(@NonNull Key key);

    void setResourceRemovedListener(@NonNull ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f4);

    void trimMemory(int i2);
}
