package p0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0.e f13294c;

    public k(String str, byte[] bArr, m0.e eVar) {
        this.f13292a = str;
        this.f13293b = bArr;
        this.f13294c = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            k kVar = (k) sVar;
            if (this.f13292a.equals(kVar.f13292a)) {
                if (Arrays.equals(this.f13293b, sVar instanceof k ? ((k) sVar).f13293b : kVar.f13293b) && this.f13294c.equals(kVar.f13294c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f13292a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13293b)) * 1000003) ^ this.f13294c.hashCode();
    }
}
