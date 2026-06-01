package w0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0.k f17661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0.j f17662c;

    public b(long j, p0.k kVar, p0.j jVar) {
        this.f17660a = j;
        this.f17661b = kVar;
        this.f17662c = jVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17660a == bVar.f17660a && this.f17661b.equals(bVar.f17661b) && this.f17662c.equals(bVar.f17662c);
    }

    public final int hashCode() {
        long j = this.f17660a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f17661b.hashCode()) * 1000003) ^ this.f17662c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f17660a + ", transportContext=" + this.f17661b + ", event=" + this.f17662c + "}";
    }
}
