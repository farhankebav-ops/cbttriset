package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(@NonNull T t3, int i2, int i8, @NonNull Options options) throws IOException;

    boolean handles(@NonNull T t3, @NonNull Options options) throws IOException;
}
