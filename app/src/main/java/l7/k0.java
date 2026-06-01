package l7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12875d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k0 f12876f;
    public k0 g;

    public k0() {
        this.f12872a = new byte[8192];
        this.e = true;
        this.f12875d = false;
    }

    public final k0 a() {
        k0 k0Var = this.f12876f;
        if (k0Var == this) {
            k0Var = null;
        }
        k0 k0Var2 = this.g;
        kotlin.jvm.internal.k.b(k0Var2);
        k0Var2.f12876f = this.f12876f;
        k0 k0Var3 = this.f12876f;
        kotlin.jvm.internal.k.b(k0Var3);
        k0Var3.g = this.g;
        this.f12876f = null;
        this.g = null;
        return k0Var;
    }

    public final void b(k0 segment) {
        kotlin.jvm.internal.k.e(segment, "segment");
        segment.g = this;
        segment.f12876f = this.f12876f;
        k0 k0Var = this.f12876f;
        kotlin.jvm.internal.k.b(k0Var);
        k0Var.g = segment;
        this.f12876f = segment;
    }

    public final k0 c() {
        this.f12875d = true;
        return new k0(this.f12872a, this.f12873b, this.f12874c, true, false);
    }

    public final void d(k0 sink, int i2) {
        kotlin.jvm.internal.k.e(sink, "sink");
        byte[] bArr = sink.f12872a;
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i8 = sink.f12874c;
        int i9 = i8 + i2;
        if (i9 > 8192) {
            if (sink.f12875d) {
                throw new IllegalArgumentException();
            }
            int i10 = sink.f12873b;
            if (i9 - i10 > 8192) {
                throw new IllegalArgumentException();
            }
            r5.j.b0(0, i10, i8, bArr, bArr);
            sink.f12874c -= sink.f12873b;
            sink.f12873b = 0;
        }
        int i11 = sink.f12874c;
        int i12 = this.f12873b;
        r5.j.b0(i11, i12, i12 + i2, this.f12872a, bArr);
        sink.f12874c += i2;
        this.f12873b += i2;
    }

    public k0(byte[] data, int i2, int i8, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f12872a = data;
        this.f12873b = i2;
        this.f12874c = i8;
        this.f12875d = z2;
        this.e = z7;
    }
}
