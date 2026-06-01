package j2;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class n implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ n[] f12087b;

    static {
        n nVar = new n("INSTANCE", 0);
        f12086a = nVar;
        f12087b = new n[]{nVar};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f12087b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
