package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f11895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f11896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f11897d;
    public static final m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ m[] f11898f;

    static {
        m mVar = new m("CONNECTING", 0);
        f11894a = mVar;
        m mVar2 = new m("READY", 1);
        f11895b = mVar2;
        m mVar3 = new m("TRANSIENT_FAILURE", 2);
        f11896c = mVar3;
        m mVar4 = new m("IDLE", 3);
        f11897d = mVar4;
        m mVar5 = new m("SHUTDOWN", 4);
        e = mVar5;
        f11898f = new m[]{mVar, mVar2, mVar3, mVar4, mVar5};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f11898f.clone();
    }
}
