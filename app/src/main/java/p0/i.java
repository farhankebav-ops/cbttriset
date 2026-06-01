package p0;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f13281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f13282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f13283d;
    public Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f13284f;
    public Integer g;
    public String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f13285i;
    public byte[] j;

    public final void a(String str, String str2) {
        HashMap map = this.f13284f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public final j b() {
        String strC = this.f13280a == null ? " transportName" : "";
        if (this.f13282c == null) {
            strC = strC.concat(" encodedPayload");
        }
        if (this.f13283d == null) {
            strC = a1.a.C(strC, " eventMillis");
        }
        if (this.e == null) {
            strC = a1.a.C(strC, " uptimeMillis");
        }
        if (this.f13284f == null) {
            strC = a1.a.C(strC, " autoMetadata");
        }
        if (strC.isEmpty()) {
            return new j(this.f13280a, this.f13281b, this.f13282c, this.f13283d.longValue(), this.e.longValue(), this.f13284f, this.g, this.h, this.f13285i, this.j);
        }
        throw new IllegalStateException("Missing required properties:".concat(strC));
    }
}
