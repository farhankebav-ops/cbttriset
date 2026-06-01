package androidx.lifecycle;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public AtomicReference(V v2) {
        this.base = new java.util.concurrent.atomic.AtomicReference<>(v2);
    }

    public final boolean compareAndSet(V v2, V v7) {
        java.util.concurrent.atomic.AtomicReference<V> atomicReference = this.base;
        while (!atomicReference.compareAndSet(v2, v7)) {
            if (atomicReference.get() != v2) {
                return false;
            }
        }
        return true;
    }

    public final V get() {
        return this.base.get();
    }
}
