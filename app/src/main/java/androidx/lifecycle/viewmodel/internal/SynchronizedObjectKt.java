package androidx.lifecycle.viewmodel.internal;

import e6.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SynchronizedObjectKt {
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <T> T m79synchronized(SynchronizedObject lock, a action) {
        T t3;
        k.e(lock, "lock");
        k.e(action, "action");
        synchronized (lock) {
            t3 = (T) action.invoke();
        }
        return t3;
    }
}
