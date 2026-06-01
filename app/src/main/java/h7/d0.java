package h7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f11749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f11750d;
    public static final d0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f11751f;
    public static final /* synthetic */ d0[] g;
    public static final /* synthetic */ y5.b h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f11752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f11753b;

    static {
        d0 d0Var = new d0("OBJ", 0, '{', '}');
        f11749c = d0Var;
        d0 d0Var2 = new d0("LIST", 1, '[', ']');
        f11750d = d0Var2;
        d0 d0Var3 = new d0("MAP", 2, '{', '}');
        e = d0Var3;
        d0 d0Var4 = new d0("POLY_OBJ", 3, '[', ']');
        f11751f = d0Var4;
        d0[] d0VarArr = {d0Var, d0Var2, d0Var3, d0Var4};
        g = d0VarArr;
        h = n7.b.n(d0VarArr);
    }

    public d0(String str, int i2, char c7, char c8) {
        this.f11752a = c7;
        this.f11753b = c8;
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) g.clone();
    }
}
