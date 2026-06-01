package androidx.camera.core.internal.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface RingBuffer<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnRemoveCallback<T> {
        void onRemove(T t3);
    }

    T dequeue();

    void enqueue(T t3);

    int getMaxCapacity();

    boolean isEmpty();
}
