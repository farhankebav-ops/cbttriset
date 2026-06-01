package androidx.camera.core.impl;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface Observable<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Observer<T> {
        void onError(Throwable th);

        void onNewData(T t3);
    }

    void addObserver(Executor executor, Observer<? super T> observer);

    j2.q fetchData();

    void removeObserver(Observer<? super T> observer);
}
