package q5;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements f, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f13502c = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e6.a f13503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f13504b;

    @Override // q5.f
    public final Object getValue() {
        Object obj = this.f13504b;
        u uVar = u.f13517a;
        if (obj != uVar) {
            return obj;
        }
        e6.a aVar = this.f13503a;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13502c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != uVar) {
                }
            }
            this.f13503a = null;
            return objInvoke;
        }
        return this.f13504b;
    }

    @Override // q5.f
    public final boolean isInitialized() {
        return this.f13504b != u.f13517a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
