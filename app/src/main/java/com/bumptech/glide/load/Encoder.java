package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface Encoder<T> {
    boolean encode(@NonNull T t3, @NonNull File file, @NonNull Options options);
}
