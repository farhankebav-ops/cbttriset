package androidx.lifecycle;

import androidx.annotation.MainThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner owner, final e6.l onChanged) {
        kotlin.jvm.internal.k.e(liveData, "<this>");
        kotlin.jvm.internal.k.e(owner, "owner");
        kotlin.jvm.internal.k.e(onChanged, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t3) {
                onChanged.invoke(t3);
            }
        };
        liveData.observe(owner, observer);
        return observer;
    }
}
