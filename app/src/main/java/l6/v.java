package l6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ v[] f12833a;

    static {
        v[] vVarArr = {new v("PUBLIC", 0), new v("PROTECTED", 1), new v("INTERNAL", 2), new v("PRIVATE", 3)};
        f12833a = vVarArr;
        n7.b.n(vVarArr);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f12833a.clone();
    }
}
