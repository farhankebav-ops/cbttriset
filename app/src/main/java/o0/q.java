package o0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13161b;

    public q(byte[] bArr, byte[] bArr2) {
        this.f13160a = bArr;
        this.f13161b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            boolean z2 = d0Var instanceof q;
            q qVar = (q) d0Var;
            if (Arrays.equals(this.f13160a, z2 ? qVar.f13160a : qVar.f13160a)) {
                q qVar2 = (q) d0Var;
                if (Arrays.equals(this.f13161b, z2 ? qVar2.f13161b : qVar2.f13161b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f13160a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13161b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f13160a) + ", encryptedBlob=" + Arrays.toString(this.f13161b) + "}";
    }
}
