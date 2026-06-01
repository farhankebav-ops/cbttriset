package n6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f13091d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f13093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f13094c;

    static {
        e eVar = e.f13088a;
        f fVar = f.f13089b;
        f13091d = new g(false, eVar, fVar);
        new g(true, eVar, fVar);
    }

    public g(boolean z2, e bytes, f number) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        kotlin.jvm.internal.k.e(number, "number");
        this.f13092a = z2;
        this.f13093b = bytes;
        this.f13094c = number;
    }

    public final String toString() {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("HexFormat(\n    upperCase = ");
        sbR.append(this.f13092a);
        sbR.append(",\n    bytes = BytesHexFormat(\n");
        this.f13093b.a(sbR, "        ");
        sbR.append('\n');
        sbR.append("    ),");
        sbR.append('\n');
        sbR.append("    number = NumberHexFormat(");
        sbR.append('\n');
        this.f13094c.a(sbR, "        ");
        sbR.append('\n');
        sbR.append("    )");
        sbR.append('\n');
        sbR.append(")");
        return sbR.toString();
    }
}
