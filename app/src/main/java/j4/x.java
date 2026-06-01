package j4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f12538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f12539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f12540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f12541d;
    public static final /* synthetic */ x[] e;

    static {
        x xVar = new x("PROCESSED", 0);
        f12538a = xVar;
        x xVar2 = new x("REFUSED", 1);
        f12539b = xVar2;
        x xVar3 = new x("DROPPED", 2);
        f12540c = xVar3;
        x xVar4 = new x("MISCARRIED", 3);
        f12541d = xVar4;
        e = new x[]{xVar, xVar2, xVar3, xVar4};
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) e.clone();
    }
}
