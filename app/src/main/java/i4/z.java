package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f11979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f11980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f11981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ z[] f11982d;

    /* JADX INFO: Fake field, exist only in values array */
    z EF0;

    static {
        z zVar = new z("CT_UNKNOWN", 0);
        z zVar2 = new z("CT_INFO", 1);
        f11979a = zVar2;
        z zVar3 = new z("CT_WARNING", 2);
        f11980b = zVar3;
        z zVar4 = new z("CT_ERROR", 3);
        f11981c = zVar4;
        f11982d = new z[]{zVar, zVar2, zVar3, zVar4};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f11982d.clone();
    }
}
