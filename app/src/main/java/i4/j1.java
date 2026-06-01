package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f11881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j1 f11882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ j1[] f11883c;

    static {
        j1 j1Var = new j1("NONE", 0);
        f11881a = j1Var;
        j1 j1Var2 = new j1("INTEGRITY", 1);
        j1 j1Var3 = new j1("PRIVACY_AND_INTEGRITY", 2);
        f11882b = j1Var3;
        f11883c = new j1[]{j1Var, j1Var2, j1Var3};
    }

    public static j1 valueOf(String str) {
        return (j1) Enum.valueOf(j1.class, str);
    }

    public static j1[] values() {
        return (j1[]) f11883c.clone();
    }
}
