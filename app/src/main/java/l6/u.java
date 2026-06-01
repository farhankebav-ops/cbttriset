package l6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f12831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ u[] f12832b;

    static {
        u uVar = new u("INVARIANT", 0);
        f12831a = uVar;
        u[] uVarArr = {uVar, new u("IN", 1), new u("OUT", 2)};
        f12832b = uVarArr;
        n7.b.n(uVarArr);
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f12832b.clone();
    }
}
