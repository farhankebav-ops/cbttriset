package sg.bigo.ads.common.y;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f16254a = new AtomicInteger();

    public static int a() {
        return f16254a.incrementAndGet();
    }

    public static void a(int i2) {
        f16254a.set(i2);
    }
}
