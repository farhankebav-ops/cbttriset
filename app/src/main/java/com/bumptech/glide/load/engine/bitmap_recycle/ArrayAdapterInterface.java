package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
interface ArrayAdapterInterface<T> {
    int getArrayLength(T t3);

    int getElementSizeInBytes();

    String getTag();

    T newArray(int i2);
}
