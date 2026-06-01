package p6;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import n6.t;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Comparable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13338c = new a(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13340b;

    public a(long j, long j3) {
        this.f13339a = j;
        this.f13340b = j3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a other = (a) obj;
        k.e(other, "other");
        long j = other.f13339a;
        long j3 = this.f13339a;
        if (j3 != j) {
            return Long.compare(j3 ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        }
        return Long.compare(this.f13340b ^ Long.MIN_VALUE, other.f13340b ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13339a == aVar.f13339a && this.f13340b == aVar.f13340b;
    }

    public final int hashCode() {
        long j = this.f13339a ^ this.f13340b;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        q.T(this.f13339a, bArr, 0, 0, 4);
        bArr[8] = 45;
        q.T(this.f13339a, bArr, 9, 4, 6);
        bArr[13] = 45;
        q.T(this.f13339a, bArr, 14, 6, 8);
        bArr[18] = 45;
        q.T(this.f13340b, bArr, 19, 0, 2);
        bArr[23] = 45;
        q.T(this.f13340b, bArr, 24, 2, 8);
        return t.e0(bArr);
    }
}
