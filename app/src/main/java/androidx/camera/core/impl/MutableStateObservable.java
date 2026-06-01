package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MutableStateObservable<T> extends StateObservable<T> {
    private MutableStateObservable(Object obj, boolean z2) {
        super(obj, z2);
    }

    public static <T> MutableStateObservable<T> withInitialError(Throwable th) {
        return new MutableStateObservable<>(th, true);
    }

    public static <T> MutableStateObservable<T> withInitialState(T t3) {
        return new MutableStateObservable<>(t3, false);
    }

    public void setError(Throwable th) {
        updateStateAsError(th);
    }

    public void setState(T t3) {
        updateState(t3);
    }
}
