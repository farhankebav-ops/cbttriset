package o0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f13171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f13172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13173d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13174f;
    public final long g;
    public final k0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d0 f13175i;

    public u(long j, Integer num, c0 c0Var, long j3, byte[] bArr, String str, long j8, k0 k0Var, d0 d0Var) {
        this.f13170a = j;
        this.f13171b = num;
        this.f13172c = c0Var;
        this.f13173d = j3;
        this.e = bArr;
        this.f13174f = str;
        this.g = j8;
        this.h = k0Var;
        this.f13175i = d0Var;
    }

    public final boolean equals(Object obj) {
        Integer num;
        c0 c0Var;
        String str;
        k0 k0Var;
        d0 d0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            u uVar = (u) g0Var;
            d0 d0Var2 = uVar.f13175i;
            k0 k0Var2 = uVar.h;
            String str2 = uVar.f13174f;
            c0 c0Var2 = uVar.f13172c;
            Integer num2 = uVar.f13171b;
            if (this.f13170a == uVar.f13170a && ((num = this.f13171b) != null ? num.equals(num2) : num2 == null) && ((c0Var = this.f13172c) != null ? c0Var.equals(c0Var2) : c0Var2 == null) && this.f13173d == uVar.f13173d) {
                if (Arrays.equals(this.e, g0Var instanceof u ? ((u) g0Var).e : uVar.e) && ((str = this.f13174f) != null ? str.equals(str2) : str2 == null) && this.g == uVar.g && ((k0Var = this.h) != null ? k0Var.equals(k0Var2) : k0Var2 == null) && ((d0Var = this.f13175i) != null ? d0Var.equals(d0Var2) : d0Var2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f13170a;
        int i2 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f13171b;
        int iHashCode = (i2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        c0 c0Var = this.f13172c;
        int iHashCode2 = (iHashCode ^ (c0Var == null ? 0 : c0Var.hashCode())) * 1000003;
        long j3 = this.f13173d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.e)) * 1000003;
        String str = this.f13174f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j8 = this.g;
        int i8 = (iHashCode4 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        k0 k0Var = this.h;
        int iHashCode5 = (i8 ^ (k0Var == null ? 0 : k0Var.hashCode())) * 1000003;
        d0 d0Var = this.f13175i;
        return iHashCode5 ^ (d0Var != null ? d0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f13170a + ", eventCode=" + this.f13171b + ", complianceData=" + this.f13172c + ", eventUptimeMs=" + this.f13173d + ", sourceExtension=" + Arrays.toString(this.e) + ", sourceExtensionJsonProto3=" + this.f13174f + ", timezoneOffsetSeconds=" + this.g + ", networkConnectionInfo=" + this.h + ", experimentIds=" + this.f13175i + "}";
    }
}
