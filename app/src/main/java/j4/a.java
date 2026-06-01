package j4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i4.a1 f12095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d5 f12097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f12098d;
    public final /* synthetic */ d e;

    public a(d dVar, i4.a1 a1Var, d5 d5Var) {
        this.e = dVar;
        r2.q.D(a1Var, "headers");
        this.f12095a = a1Var;
        this.f12097c = d5Var;
    }

    @Override // j4.c1
    public final void c(o4.a aVar) {
        r2.q.H(this.f12098d == null, "writePayload should not be called multiple times");
        try {
            this.f12098d = g2.g.b(aVar);
            d5 d5Var = this.f12097c;
            i4.i[] iVarArr = d5Var.f12162a;
            i4.i[] iVarArr2 = d5Var.f12162a;
            for (i4.i iVar : iVarArr) {
                iVar.i(0);
            }
            byte[] bArr = this.f12098d;
            long length = bArr.length;
            long length2 = bArr.length;
            for (i4.i iVar2 : d5Var.f12162a) {
                iVar2.j(0, length, length2);
            }
            long length3 = this.f12098d.length;
            for (i4.i iVar3 : iVarArr2) {
                iVar3.k(length3);
            }
            long length4 = this.f12098d.length;
            for (i4.i iVar4 : iVarArr2) {
                iVar4.l(length4);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // j4.c1
    public final void close() {
        this.f12096b = true;
        r2.q.H(this.f12098d != null, "Lack of request message. GET request is only supported for unary requests");
        ((k4.k) this.e).f12653o.n(this.f12095a, this.f12098d);
        this.f12098d = null;
        this.f12095a = null;
    }

    @Override // j4.c1
    public final boolean isClosed() {
        return this.f12096b;
    }

    @Override // j4.c1
    public final void flush() {
    }

    @Override // j4.c1
    public final void a(int i2) {
    }

    @Override // j4.c1
    public final c1 b(i4.k kVar) {
        return this;
    }
}
