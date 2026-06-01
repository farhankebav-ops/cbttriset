package e2;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o implements n, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f11242a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f11243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile transient boolean f11244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Object f11245d;

    public o(n nVar) {
        this.f11243b = nVar;
    }

    @Override // e2.n
    public final Object get() {
        if (!this.f11244c) {
            synchronized (this.f11242a) {
                try {
                    if (!this.f11244c) {
                        Object obj = this.f11243b.get();
                        this.f11245d = obj;
                        this.f11244c = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f11245d;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.f11244c) {
            obj = "<supplier that returned " + this.f11245d + ">";
        } else {
            obj = this.f11243b;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
