package i4;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f11851d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11854c;

    public e0(String str, String str2, long j) {
        r2.q.D(str, "typeName");
        r2.q.y(!str.isEmpty(), "empty type");
        this.f11852a = str;
        this.f11853b = str2;
        this.f11854c = j;
    }

    public static e0 a(Class cls, String str) {
        String simpleName = cls.getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return new e0(simpleName, str, f11851d.incrementAndGet());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11852a + "<" + this.f11854c + ">");
        String str = this.f11853b;
        if (str != null) {
            sb.append(": (");
            sb.append(str);
            sb.append(')');
        }
        return sb.toString();
    }
}
