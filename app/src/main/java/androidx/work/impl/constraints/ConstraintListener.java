package androidx.work.impl.constraints;

import androidx.annotation.MainThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface ConstraintListener<T> {
    @MainThread
    void onConstraintChanged(T t3);
}
