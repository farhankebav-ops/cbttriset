package p0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0.c f13300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13301b;

    public n(m0.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f13300a = cVar;
        this.f13301b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f13300a.equals(nVar.f13300a)) {
            return Arrays.equals(this.f13301b, nVar.f13301b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f13300a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13301b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f13300a + ", bytes=[...]}";
    }
}
