package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    public SimpleResource(@NonNull T t3) {
        this.data = (T) Preconditions.checkNotNull(t3);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        return this.data;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<T> getResourceClass() {
        return (Class<T>) this.data.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
