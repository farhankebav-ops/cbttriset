package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements f, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e6.a f13505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f13506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13507c;

    public m(e6.a initializer) {
        kotlin.jvm.internal.k.e(initializer, "initializer");
        this.f13505a = initializer;
        this.f13506b = u.f13517a;
        this.f13507c = this;
    }

    @Override // q5.f
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f13506b;
        u uVar = u.f13517a;
        if (obj != uVar) {
            return obj;
        }
        synchronized (this.f13507c) {
            objInvoke = this.f13506b;
            if (objInvoke == uVar) {
                e6.a aVar = this.f13505a;
                kotlin.jvm.internal.k.b(aVar);
                objInvoke = aVar.invoke();
                this.f13506b = objInvoke;
                this.f13505a = null;
            }
        }
        return objInvoke;
    }

    @Override // q5.f
    public final boolean isInitialized() {
        return this.f13506b != u.f13517a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
