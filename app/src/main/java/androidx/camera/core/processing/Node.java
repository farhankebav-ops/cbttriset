package androidx.camera.core.processing;

import androidx.annotation.MainThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface Node<I, O> {
    void release();

    @MainThread
    O transform(I i2);
}
