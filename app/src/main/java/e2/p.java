package e2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.mimikridev.utilmanager.config.b f11246d = new com.mimikridev.utilmanager.config.b(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11247a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile n f11248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11249c;

    public p(n nVar) {
        this.f11248b = nVar;
    }

    @Override // e2.n
    public final Object get() {
        n nVar = this.f11248b;
        com.mimikridev.utilmanager.config.b bVar = f11246d;
        if (nVar != bVar) {
            synchronized (this.f11247a) {
                try {
                    if (this.f11248b != bVar) {
                        Object obj = this.f11248b.get();
                        this.f11249c = obj;
                        this.f11248b = bVar;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f11249c;
    }

    public final String toString() {
        Object obj = this.f11248b;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == f11246d) {
            obj = "<supplier that returned " + this.f11249c + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
