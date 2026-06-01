package h7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u extends s {
    public final g7.x j;
    public final List k;
    public final int l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(g7.c json, g7.x xVar) {
        super(json, xVar, (String) null, 12);
        kotlin.jvm.internal.k.e(json, "json");
        this.j = xVar;
        List listN1 = r5.l.n1(xVar.f11628a.keySet());
        this.k = listN1;
        this.l = listN1.size() * 2;
        this.m = -1;
    }

    @Override // h7.s, h7.a
    public final g7.m c(String tag) {
        kotlin.jvm.internal.k.e(tag, "tag");
        return this.m % 2 == 0 ? g7.n.b(tag) : (g7.m) r5.x.b0(this.j, tag);
    }

    @Override // h7.s, e7.c
    public final int decodeElementIndex(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        int i2 = this.m;
        if (i2 >= this.l - 1) {
            return -1;
        }
        int i8 = i2 + 1;
        this.m = i8;
        return i8;
    }

    @Override // h7.s, h7.a, e7.c
    public final void endStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
    }

    @Override // h7.s, h7.a
    public final String o(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return (String) this.k.get(i2 / 2);
    }

    @Override // h7.s, h7.a
    public final g7.m q() {
        return this.j;
    }

    @Override // h7.s
    /* JADX INFO: renamed from: v */
    public final g7.x q() {
        return this.j;
    }
}
