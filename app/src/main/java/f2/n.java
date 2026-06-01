package f2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient h f11340d;
    public final transient o e;

    public n(h hVar, o oVar) {
        this.f11340d = hVar;
        this.e = oVar;
    }

    @Override // f2.i, f2.a
    public final e a() {
        return this.e;
    }

    @Override // f2.a
    public final int b(int i2, Object[] objArr) {
        return this.e.b(i2, objArr);
    }

    @Override // f2.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11340d.get(obj) != null;
    }

    @Override // f2.a
    public final boolean f() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final u iterator() {
        return this.e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((p) this.f11340d).f11344f;
    }
}
