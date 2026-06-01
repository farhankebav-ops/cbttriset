package c6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ j[] f4235b;

    static {
        j jVar = new j("TOP_DOWN", 0);
        f4234a = jVar;
        j[] jVarArr = {jVar, new j("BOTTOM_UP", 1)};
        f4235b = jVarArr;
        n7.b.n(jVarArr);
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f4235b.clone();
    }
}
