package androidx.savedstate.internal;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SynchronizedObject_jvmKt {
    public static final <T> T synchronizedImpl(SynchronizedObject lock, e6.a action) {
        T t3;
        k.e(lock, "lock");
        k.e(action, "action");
        synchronized (lock) {
            t3 = (T) action.invoke();
        }
        return t3;
    }
}
