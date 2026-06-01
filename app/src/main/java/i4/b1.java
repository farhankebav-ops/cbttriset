package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f11827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b1 f11828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ b1[] f11829c;

    static {
        b1 b1Var = new b1("UNARY", 0);
        f11827a = b1Var;
        b1 b1Var2 = new b1("CLIENT_STREAMING", 1);
        b1 b1Var3 = new b1("SERVER_STREAMING", 2);
        f11828b = b1Var3;
        f11829c = new b1[]{b1Var, b1Var2, b1Var3, new b1("BIDI_STREAMING", 3), new b1("UNKNOWN", 4)};
    }

    public static b1 valueOf(String str) {
        return (b1) Enum.valueOf(b1.class, str);
    }

    public static b1[] values() {
        return (b1[]) f11829c.clone();
    }
}
