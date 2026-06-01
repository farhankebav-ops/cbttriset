package l4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f12782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f12783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12784d;

    public b(boolean z2) {
        this.f12781a = z2;
    }

    public final void a(a... aVarArr) {
        if (!this.f12781a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            strArr[i2] = aVarArr[i2].f12780a;
        }
        this.f12782b = strArr;
    }

    public final void b(m... mVarArr) {
        if (!this.f12781a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (mVarArr.length == 0) {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        }
        String[] strArr = new String[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            strArr[i2] = mVarArr[i2].f12818a;
        }
        this.f12783c = strArr;
    }

    public b(c cVar) {
        this.f12781a = cVar.f12785a;
        this.f12782b = cVar.f12786b;
        this.f12783c = cVar.f12787c;
        this.f12784d = cVar.f12788d;
    }
}
