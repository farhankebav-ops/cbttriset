package m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f12917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12918c;

    public a(Object obj, e eVar, b bVar) {
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f12916a = obj;
        this.f12917b = eVar;
        this.f12918c = bVar;
    }

    public final boolean equals(Object obj) {
        b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            a aVar = (a) ((d) obj);
            b bVar2 = aVar.f12918c;
            if (this.f12916a.equals(aVar.f12916a) && this.f12917b.equals(aVar.f12917b) && ((bVar = this.f12918c) != null ? bVar.equals(bVar2) : bVar2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f12916a.hashCode()) * 1000003) ^ this.f12917b.hashCode()) * 1000003;
        b bVar = this.f12918c;
        return (iHashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f12916a + ", priority=" + this.f12917b + ", productData=" + this.f12918c + ", eventContext=null}";
    }
}
