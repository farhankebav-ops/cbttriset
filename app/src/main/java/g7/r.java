package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d7.g f11622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11623c;

    public r(Object body, boolean z2, d7.g gVar) {
        kotlin.jvm.internal.k.e(body, "body");
        this.f11621a = z2;
        this.f11622b = gVar;
        this.f11623c = body.toString();
        if (gVar != null && !gVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override // g7.b0
    public final String a() {
        return this.f11623c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f11621a == rVar.f11621a && kotlin.jvm.internal.k.a(this.f11623c, rVar.f11623c);
    }

    public final int hashCode() {
        return this.f11623c.hashCode() + ((this.f11621a ? 1231 : 1237) * 31);
    }

    @Override // g7.b0
    public final String toString() {
        boolean z2 = this.f11621a;
        String str = this.f11623c;
        if (!z2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        h7.c0.a(sb, str);
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }
}
