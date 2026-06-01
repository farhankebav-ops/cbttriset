package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11761c;

    public i(com.unity3d.scar.adapter.common.a aVar, boolean z2) {
        super(aVar);
        this.f11761c = z2;
    }

    @Override // h7.g
    public final void b(byte b8) {
        if (this.f11761c) {
            h(String.valueOf(b8 & 255));
        } else {
            f(String.valueOf(b8 & 255));
        }
    }

    @Override // h7.g
    public final void d(int i2) {
        if (this.f11761c) {
            h(Long.toString(4294967295L & ((long) i2), 10));
        } else {
            f(Long.toString(4294967295L & ((long) i2), 10));
        }
    }

    @Override // h7.g
    public final void e(long j) {
        int i2 = 63;
        String str = "0";
        if (this.f11761c) {
            if (j != 0) {
                if (j > 0) {
                    str = Long.toString(j, 10);
                } else {
                    char[] cArr = new char[64];
                    long j3 = (j >>> 1) / ((long) 5);
                    long j8 = 10;
                    cArr[63] = Character.forDigit((int) (j - (j3 * j8)), 10);
                    while (j3 > 0) {
                        i2--;
                        cArr[i2] = Character.forDigit((int) (j3 % j8), 10);
                        j3 /= j8;
                    }
                    str = new String(cArr, i2, 64 - i2);
                }
            }
            h(str);
            return;
        }
        if (j != 0) {
            if (j > 0) {
                str = Long.toString(j, 10);
            } else {
                char[] cArr2 = new char[64];
                long j9 = (j >>> 1) / ((long) 5);
                long j10 = 10;
                cArr2[63] = Character.forDigit((int) (j - (j9 * j10)), 10);
                while (j9 > 0) {
                    i2--;
                    cArr2[i2] = Character.forDigit((int) (j9 % j10), 10);
                    j9 /= j10;
                }
                str = new String(cArr2, i2, 64 - i2);
            }
        }
        f(str);
    }

    @Override // h7.g
    public final void g(short s7) {
        if (this.f11761c) {
            h(String.valueOf(s7 & 65535));
        } else {
            f(String.valueOf(s7 & 65535));
        }
    }
}
