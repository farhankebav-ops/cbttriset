package androidx.lifecycle;

import q5.x;
import q6.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface LiveDataScope<T> {
    Object emit(T t3, v5.c<? super x> cVar);

    Object emitSource(LiveData<T> liveData, v5.c<? super o0> cVar);

    T getLatestValue();
}
