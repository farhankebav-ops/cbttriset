package androidx.camera.core.processing;

import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    @Override // androidx.core.util.Consumer
    public void accept(T t3) {
        kotlin.jvm.internal.k.c(this.mListener, "Listener is not set.");
        this.mListener.accept(t3);
    }

    public void setListener(Consumer<T> consumer) {
        this.mListener = consumer;
    }
}
