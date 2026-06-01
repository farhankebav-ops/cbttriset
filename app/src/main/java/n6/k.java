package n6;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends r5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e2.h f13102a;

    public k(e2.h hVar) {
        this.f13102a = hVar;
    }

    public final i a(int i2) {
        Matcher matcher = (Matcher) this.f13102a.f11231a;
        k6.d dVarD0 = r2.q.D0(matcher.start(i2), matcher.end(i2));
        if (dVarD0.f12709a < 0) {
            return null;
        }
        String strGroup = matcher.group(i2);
        kotlin.jvm.internal.k.d(strGroup, "group(...)");
        return new i(strGroup, dVarD0);
    }

    @Override // r5.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof i) {
            return super.contains((i) obj);
        }
        return false;
    }

    @Override // r5.a
    public final int getSize() {
        return ((Matcher) this.f13102a.f11231a).groupCount() + 1;
    }

    @Override // r5.a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new m6.n(m6.k.J0(r5.l.S0(new k6.d(0, size() - 1, 1)), new androidx.camera.core.impl.utils.a(this, 15)));
    }
}
