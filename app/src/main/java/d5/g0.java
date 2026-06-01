package d5;

import androidx.core.location.LocationRequestCompat;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 implements x4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f11093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ g0[] f11094b;

    static {
        g0 g0Var = new g0("INSTANCE", 0);
        f11093a = g0Var;
        f11094b = new g0[]{g0Var};
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f11094b.clone();
    }

    @Override // x4.b
    public final void accept(Object obj) {
        ((o7.b) obj).c(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
