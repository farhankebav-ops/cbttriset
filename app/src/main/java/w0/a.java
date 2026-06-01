package w0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f17655f = new a(200, 10000, 10485760, 604800000, 81920);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17659d;
    public final int e;

    public a(int i2, int i8, long j, long j3, int i9) {
        this.f17656a = j;
        this.f17657b = i2;
        this.f17658c = i8;
        this.f17659d = j3;
        this.e = i9;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f17656a == aVar.f17656a && this.f17657b == aVar.f17657b && this.f17658c == aVar.f17658c && this.f17659d == aVar.f17659d && this.e == aVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f17656a;
        int i2 = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f17657b) * 1000003) ^ this.f17658c) * 1000003;
        long j3 = this.f17659d;
        return ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f17656a);
        sb.append(", loadBatchSize=");
        sb.append(this.f17657b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f17658c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f17659d);
        sb.append(", maxBlobByteSizePerRow=");
        return a1.a.q(sb, "}", this.e);
    }
}
