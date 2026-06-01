package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 extends x0 {
    public final z0 e;

    public y0(String str, boolean z2, z0 z0Var) {
        super(z0Var, str, z2);
        if (str.endsWith("-bin")) {
            throw new IllegalArgumentException(a.a.K("ASCII header is named %s.  Only binary headers may end with %s", str, "-bin"));
        }
        this.e = z0Var;
    }

    @Override // i4.x0
    public final Object a(byte[] bArr) {
        return this.e.o(bArr);
    }

    @Override // i4.x0
    public final byte[] b(Object obj) {
        byte[] bArrMo3445c = this.e.mo3445c(obj);
        r2.q.D(bArrMo3445c, "null marshaller.toAsciiString()");
        return bArrMo3445c;
    }
}
