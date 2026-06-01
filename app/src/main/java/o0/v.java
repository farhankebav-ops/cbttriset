package o0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f13178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f13179d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f13180f;

    public v(long j, long j3, o oVar, Integer num, String str, ArrayList arrayList) {
        l0 l0Var = l0.f13149a;
        this.f13176a = j;
        this.f13177b = j3;
        this.f13178c = oVar;
        this.f13179d = num;
        this.e = str;
        this.f13180f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        v vVar = (v) ((h0) obj);
        Object obj2 = l0.f13149a;
        ArrayList arrayList = vVar.f13180f;
        String str = vVar.e;
        Integer num = vVar.f13179d;
        o oVar = vVar.f13178c;
        if (this.f13176a != vVar.f13176a || this.f13177b != vVar.f13177b || !this.f13178c.equals(oVar)) {
            return false;
        }
        Integer num2 = this.f13179d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.f13180f.equals(arrayList) && obj2.equals(obj2);
    }

    public final int hashCode() {
        long j = this.f13176a;
        long j3 = this.f13177b;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f13178c.hashCode()) * 1000003;
        Integer num = this.f13179d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f13180f.hashCode()) * 1000003) ^ l0.f13149a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f13176a + ", requestUptimeMs=" + this.f13177b + ", clientInfo=" + this.f13178c + ", logSource=" + this.f13179d + ", logSourceName=" + this.e + ", logEvents=" + this.f13180f + ", qosTier=" + l0.f13149a + "}";
    }
}
