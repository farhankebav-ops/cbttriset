package y6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f17872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f17873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f17874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f17875d;
    public static final /* synthetic */ i[] e;

    static {
        i iVar = new i("SUCCESSFUL", 0);
        f17872a = iVar;
        i iVar2 = new i("REREGISTER", 1);
        f17873b = iVar2;
        i iVar3 = new i("CANCELLED", 2);
        f17874c = iVar3;
        i iVar4 = new i("ALREADY_SELECTED", 3);
        f17875d = iVar4;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4};
        e = iVarArr;
        n7.b.n(iVarArr);
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) e.clone();
    }
}
