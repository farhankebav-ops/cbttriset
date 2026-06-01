package h7;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends r {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11777i;
    public boolean j;

    @Override // h7.r
    public final g7.m g() {
        return new g7.x((LinkedHashMap) this.h);
    }

    @Override // h7.r
    public final void j(g7.m element, String key) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(element, "element");
        if (!this.j) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.h;
            String str = this.f11777i;
            if (str == null) {
                kotlin.jvm.internal.k.l("tag");
                throw null;
            }
            linkedHashMap.put(str, element);
            this.j = true;
            return;
        }
        if (element instanceof g7.b0) {
            this.f11777i = ((g7.b0) element).a();
            this.j = false;
        } else {
            if (element instanceof g7.x) {
                throw o.b(g7.z.f11633b);
            }
            if (!(element instanceof g7.e)) {
                throw new e2.s(3);
            }
            throw o.b(g7.g.f11608b);
        }
    }
}
