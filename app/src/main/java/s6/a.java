package s6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f13721d;

    static {
        a aVar = new a("SUSPEND", 0);
        f13718a = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f13719b = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f13720c = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f13721d = aVarArr;
        n7.b.n(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f13721d.clone();
    }
}
