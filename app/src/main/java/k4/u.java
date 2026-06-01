package k4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.j f12688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12690c;

    public u(int i2, l7.j jVar) {
        this.f12688a = jVar;
        this.f12689b = i2;
    }

    public final void a(byte[] bArr, int i2, int i8) {
        this.f12688a.m3451write(bArr, i2, i8);
        this.f12689b -= i8;
        this.f12690c += i8;
    }
}
