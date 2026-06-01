package l5;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Callable, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f12822b;

    static {
        a aVar = new a("INSTANCE", 0);
        f12821a = aVar;
        f12822b = new a[]{aVar};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f12822b.clone();
    }

    @Override // x4.c
    public final Object apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new ArrayList();
    }
}
