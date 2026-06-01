package q6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f13526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f13527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f13528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f13529d;
    public static final /* synthetic */ b0[] e;

    static {
        b0 b0Var = new b0("DEFAULT", 0);
        f13526a = b0Var;
        b0 b0Var2 = new b0("LAZY", 1);
        f13527b = b0Var2;
        b0 b0Var3 = new b0("ATOMIC", 2);
        f13528c = b0Var3;
        b0 b0Var4 = new b0("UNDISPATCHED", 3);
        f13529d = b0Var4;
        b0[] b0VarArr = {b0Var, b0Var2, b0Var3, b0Var4};
        e = b0VarArr;
        n7.b.n(b0VarArr);
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) e.clone();
    }
}
