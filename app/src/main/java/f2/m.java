package f2;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient h f11338d;
    public final transient Object[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f11339f;

    public m(h hVar, Object[] objArr, int i2) {
        this.f11338d = hVar;
        this.e = objArr;
        this.f11339f = i2;
    }

    @Override // f2.a
    public final int b(int i2, Object[] objArr) {
        return a().b(i2, objArr);
    }

    @Override // f2.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f11338d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // f2.a
    public final boolean f() {
        return true;
    }

    @Override // f2.i
    public final e i() {
        return new l(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final u iterator() {
        return a().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f11339f;
    }
}
