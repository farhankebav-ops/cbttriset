package o0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f13184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ z[] f13185b;

    /* JADX INFO: Fake field, exist only in values array */
    z EF0;

    static {
        z zVar = new z("UNKNOWN", 0);
        z zVar2 = new z("ANDROID_FIREBASE", 1);
        f13184a = zVar2;
        f13185b = new z[]{zVar, zVar2};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f13185b.clone();
    }
}
