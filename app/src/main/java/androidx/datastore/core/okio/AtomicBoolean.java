package androidx.datastore.core.okio;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicBoolean {
    private final java.util.concurrent.atomic.AtomicBoolean delegate;

    public AtomicBoolean(boolean z2) {
        this.delegate = new java.util.concurrent.atomic.AtomicBoolean(z2);
    }

    public final boolean get() {
        return this.delegate.get();
    }

    public final void set(boolean z2) {
        this.delegate.set(z2);
    }
}
