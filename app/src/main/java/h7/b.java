package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends e7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11737a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f11738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11740d;

    public b(r rVar, String str) {
        this.f11738b = rVar;
        this.f11739c = str;
        this.f11740d = rVar.f11770b.f11599b;
    }

    public void c(String s7) {
        kotlin.jvm.internal.k.e(s7, "s");
        this.f11738b.j(new g7.r(s7, false, null), this.f11739c);
    }

    @Override // e7.b, e7.f
    public void encodeByte(byte b8) {
        switch (this.f11737a) {
            case 1:
                c(String.valueOf(b8 & 255));
                break;
            default:
                super.encodeByte(b8);
                break;
        }
    }

    @Override // e7.b, e7.f
    public void encodeInt(int i2) {
        switch (this.f11737a) {
            case 1:
                c(Long.toString(((long) i2) & 4294967295L, 10));
                break;
            default:
                super.encodeInt(i2);
                break;
        }
    }

    @Override // e7.b, e7.f
    public void encodeLong(long j) {
        String str;
        switch (this.f11737a) {
            case 1:
                if (j == 0) {
                    str = "0";
                } else if (j > 0) {
                    str = Long.toString(j, 10);
                } else {
                    char[] cArr = new char[64];
                    long j3 = (j >>> 1) / ((long) 5);
                    long j8 = 10;
                    int i2 = 63;
                    cArr[63] = Character.forDigit((int) (j - (j3 * j8)), 10);
                    while (j3 > 0) {
                        i2--;
                        cArr[i2] = Character.forDigit((int) (j3 % j8), 10);
                        j3 /= j8;
                    }
                    str = new String(cArr, i2, 64 - i2);
                }
                c(str);
                break;
            default:
                super.encodeLong(j);
                break;
        }
    }

    @Override // e7.b, e7.f
    public void encodeShort(short s7) {
        switch (this.f11737a) {
            case 1:
                c(String.valueOf(s7 & 65535));
                break;
            default:
                super.encodeShort(s7);
                break;
        }
    }

    @Override // e7.b, e7.f
    public void encodeString(String value) {
        switch (this.f11737a) {
            case 0:
                kotlin.jvm.internal.k.e(value, "value");
                this.f11738b.j(new g7.r(value, false, (d7.g) this.f11740d), this.f11739c);
                break;
            default:
                super.encodeString(value);
                break;
        }
    }

    @Override // e7.f
    public final i7.f getSerializersModule() {
        switch (this.f11737a) {
            case 0:
                return this.f11738b.f11770b.f11599b;
            default:
                return (i7.f) this.f11740d;
        }
    }

    public b(r rVar, String str, d7.g gVar) {
        this.f11738b = rVar;
        this.f11739c = str;
        this.f11740d = gVar;
    }
}
