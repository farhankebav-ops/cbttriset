package f2;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f11337c;

    public l(m mVar) {
        this.f11337c = mVar;
    }

    @Override // f2.a
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        m mVar = this.f11337c;
        r2.q.A(i2, mVar.f11339f);
        Object[] objArr = mVar.e;
        int i8 = i2 * 2;
        Object obj = objArr[i8];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i8 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11337c.f11339f;
    }
}
