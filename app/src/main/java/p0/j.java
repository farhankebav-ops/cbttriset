package p0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f13287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f13288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13289d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f13290f;
    public final Integer g;
    public final String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f13291i;
    public final byte[] j;

    public j(String str, Integer num, n nVar, long j, long j3, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f13286a = str;
        this.f13287b = num;
        this.f13288c = nVar;
        this.f13289d = j;
        this.e = j3;
        this.f13290f = map;
        this.g = num2;
        this.h = str2;
        this.f13291i = bArr;
        this.j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f13290f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f13290f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final i c() {
        i iVar = new i();
        String str = this.f13286a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        iVar.f13280a = str;
        iVar.f13281b = this.f13287b;
        iVar.g = this.g;
        iVar.h = this.h;
        iVar.f13285i = this.f13291i;
        iVar.j = this.j;
        n nVar = this.f13288c;
        if (nVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        iVar.f13282c = nVar;
        iVar.f13283d = Long.valueOf(this.f13289d);
        iVar.e = Long.valueOf(this.e);
        iVar.f13284f = new HashMap(this.f13290f);
        return iVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            String str2 = jVar.h;
            Integer num3 = jVar.g;
            Integer num4 = jVar.f13287b;
            if (this.f13286a.equals(jVar.f13286a) && ((num = this.f13287b) != null ? num.equals(num4) : num4 == null) && this.f13288c.equals(jVar.f13288c) && this.f13289d == jVar.f13289d && this.e == jVar.e && this.f13290f.equals(jVar.f13290f) && ((num2 = this.g) != null ? num2.equals(num3) : num3 == null) && ((str = this.h) != null ? str.equals(str2) : str2 == null) && Arrays.equals(this.f13291i, jVar.f13291i) && Arrays.equals(this.j, jVar.j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f13286a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f13287b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f13288c.hashCode()) * 1000003;
        long j = this.f13289d;
        int i2 = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j3 = this.e;
        int iHashCode3 = (((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f13290f.hashCode()) * 1000003;
        Integer num2 = this.g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f13291i)) * 1000003) ^ Arrays.hashCode(this.j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f13286a + ", code=" + this.f13287b + ", encodedPayload=" + this.f13288c + ", eventMillis=" + this.f13289d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f13290f + ", productId=" + this.g + ", pseudonymousId=" + this.h + ", experimentIdsClear=" + Arrays.toString(this.f13291i) + ", experimentIdsEncrypted=" + Arrays.toString(this.j) + "}";
    }
}
