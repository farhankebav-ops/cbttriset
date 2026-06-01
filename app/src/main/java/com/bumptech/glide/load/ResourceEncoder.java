package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ResourceEncoder<T> extends Encoder<Resource<T>> {
    @NonNull
    EncodeStrategy getEncodeStrategy(@NonNull Options options);
}
