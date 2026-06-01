package q5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f13495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f13496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ g[] f13497d;

    static {
        g gVar = new g("SYNCHRONIZED", 0);
        f13494a = gVar;
        g gVar2 = new g("PUBLICATION", 1);
        f13495b = gVar2;
        g gVar3 = new g("NONE", 2);
        f13496c = gVar3;
        g[] gVarArr = {gVar, gVar2, gVar3};
        f13497d = gVarArr;
        n7.b.n(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f13497d.clone();
    }
}
