package r0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements p5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f13612c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f13613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f13614b;

    public static p5.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f13614b = f13612c;
        aVar.f13613a = bVar;
        return aVar;
    }

    @Override // p5.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f13614b;
        Object obj3 = f13612c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f13614b;
                if (obj == obj3) {
                    obj = this.f13613a.get();
                    Object obj4 = this.f13614b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f13614b = obj;
                    this.f13613a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
