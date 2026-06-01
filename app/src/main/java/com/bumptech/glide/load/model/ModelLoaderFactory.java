package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
