package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y implements f, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e6.a f13521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13522b;

    @Override // q5.f
    public final Object getValue() {
        if (this.f13522b == u.f13517a) {
            e6.a aVar = this.f13521a;
            kotlin.jvm.internal.k.b(aVar);
            this.f13522b = aVar.invoke();
            this.f13521a = null;
        }
        return this.f13522b;
    }

    @Override // q5.f
    public final boolean isInitialized() {
        return this.f13522b != u.f13517a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
