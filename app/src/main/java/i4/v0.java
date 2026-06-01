package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v0 extends x0 {
    public final w0 e;

    public v0(String str, w0 w0Var) {
        super(w0Var, str, false);
        if (str.endsWith("-bin")) {
            throw new IllegalArgumentException(a.a.K("ASCII header is named %s.  Only binary headers may end with %s", str, "-bin"));
        }
        r2.q.D(w0Var, "marshaller");
        this.e = w0Var;
    }

    @Override // i4.x0
    public final Object a(byte[] bArr) {
        return this.e.g(new String(bArr, e2.d.f11227a));
    }

    @Override // i4.x0
    public final byte[] b(Object obj) {
        String strC = this.e.c(obj);
        r2.q.D(strC, "null marshaller.toAsciiString()");
        return strC.getBytes(e2.d.f11227a);
    }
}
