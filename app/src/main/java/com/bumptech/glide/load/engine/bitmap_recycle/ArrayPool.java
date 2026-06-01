package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int i2, Class<T> cls);

    <T> T getExact(int i2, Class<T> cls);

    <T> void put(T t3);

    @Deprecated
    <T> void put(T t3, Class<T> cls);

    void trimMemory(int i2);
}
