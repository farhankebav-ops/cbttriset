package p0;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public final k a(m0.e eVar) {
        k kVar = (k) this;
        String str = kVar.f13292a;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        if (eVar != null) {
            return new k(str, kVar.f13293b, eVar);
        }
        throw new NullPointerException("Null priority");
    }

    public final String toString() {
        k kVar = (k) this;
        byte[] bArr = kVar.f13293b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(kVar.f13292a);
        sb.append(", ");
        sb.append(kVar.f13294c);
        sb.append(", ");
        return a1.a.r(sb, strEncodeToString, ")");
    }
}
