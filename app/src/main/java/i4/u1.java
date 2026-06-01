package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f11968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u1 f11969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ u1[] f11970c;

    /* JADX INFO: Fake field, exist only in values array */
    u1 EF0;

    static {
        u1 u1Var = new u1("FAKE", 0);
        u1 u1Var2 = new u1("MTLS", 1);
        f11968a = u1Var2;
        u1 u1Var3 = new u1("CUSTOM_MANAGERS", 2);
        f11969b = u1Var3;
        f11970c = new u1[]{u1Var, u1Var2, u1Var3};
    }

    public static u1 valueOf(String str) {
        return (u1) Enum.valueOf(u1.class, str);
    }

    public static u1[] values() {
        return (u1[]) f11970c.clone();
    }
}
