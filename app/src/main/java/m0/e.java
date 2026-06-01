package m0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f12922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f12923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e[] f12924d;

    static {
        e eVar = new e("DEFAULT", 0);
        f12921a = eVar;
        e eVar2 = new e("VERY_LOW", 1);
        f12922b = eVar2;
        e eVar3 = new e("HIGHEST", 2);
        f12923c = eVar3;
        f12924d = new e[]{eVar, eVar2, eVar3};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f12924d.clone();
    }
}
