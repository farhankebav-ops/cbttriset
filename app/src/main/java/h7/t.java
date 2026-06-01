package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g7.e f11776f;
    public final int g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(g7.c json, g7.e eVar) {
        super(json, null);
        kotlin.jvm.internal.k.e(json, "json");
        this.f11776f = eVar;
        this.g = eVar.f11603a.size();
        this.h = -1;
    }

    @Override // h7.a
    public final g7.m c(String tag) {
        kotlin.jvm.internal.k.e(tag, "tag");
        return (g7.m) this.f11776f.f11603a.get(Integer.parseInt(tag));
    }

    @Override // e7.c
    public final int decodeElementIndex(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        int i2 = this.h;
        if (i2 >= this.g - 1) {
            return -1;
        }
        int i8 = i2 + 1;
        this.h = i8;
        return i8;
    }

    @Override // h7.a
    public final String o(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return String.valueOf(i2);
    }

    @Override // h7.a
    public final g7.m q() {
        return this.f11776f;
    }
}
