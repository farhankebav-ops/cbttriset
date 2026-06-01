package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends e7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f11762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i7.f f11763b;

    public j(b0 b0Var, g7.c json) {
        kotlin.jvm.internal.k.e(json, "json");
        this.f11762a = b0Var;
        this.f11763b = json.f11599b;
    }

    @Override // e7.a, e7.e
    public final byte decodeByte() {
        q5.o oVar;
        b0 b0Var = this.f11762a;
        String strJ = b0Var.j();
        try {
            kotlin.jvm.internal.k.e(strJ, "<this>");
            q5.q qVarS = n7.b.S(strJ);
            if (qVarS != null) {
                int i2 = qVarS.f13513a;
                oVar = Integer.compare(Integer.MIN_VALUE ^ i2, -2147483393) > 0 ? null : new q5.o((byte) i2);
            }
            if (oVar != null) {
                return oVar.f13511a;
            }
            n6.t.i0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'UByte' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    @Override // e7.c
    public final int decodeElementIndex(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // e7.a, e7.e
    public final int decodeInt() {
        b0 b0Var = this.f11762a;
        String strJ = b0Var.j();
        try {
            kotlin.jvm.internal.k.e(strJ, "<this>");
            q5.q qVarS = n7.b.S(strJ);
            if (qVarS != null) {
                return qVarS.f13513a;
            }
            n6.t.i0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'UInt' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    @Override // e7.a, e7.e
    public final long decodeLong() {
        b0 b0Var = this.f11762a;
        String strJ = b0Var.j();
        try {
            kotlin.jvm.internal.k.e(strJ, "<this>");
            q5.s sVarT = n7.b.T(strJ);
            if (sVarT != null) {
                return sVarT.f13515a;
            }
            n6.t.i0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'ULong' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    @Override // e7.a, e7.e
    public final short decodeShort() {
        q5.v vVar;
        b0 b0Var = this.f11762a;
        String strJ = b0Var.j();
        try {
            kotlin.jvm.internal.k.e(strJ, "<this>");
            q5.q qVarS = n7.b.S(strJ);
            if (qVarS != null) {
                int i2 = qVarS.f13513a;
                vVar = Integer.compare(Integer.MIN_VALUE ^ i2, -2147418113) > 0 ? null : new q5.v((short) i2);
            }
            if (vVar != null) {
                return vVar.f13518a;
            }
            n6.t.i0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'UShort' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    @Override // e7.e, e7.c
    public final i7.f getSerializersModule() {
        return this.f11763b;
    }
}
