package o6;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f13210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f13211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f13212d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f13213f;
    public static final c g;
    public static final /* synthetic */ c[] h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f13214a;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f13210b = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f13211c = cVar3;
        c cVar4 = new c("SECONDS", 3, TimeUnit.SECONDS);
        f13212d = cVar4;
        c cVar5 = new c("MINUTES", 4, TimeUnit.MINUTES);
        e = cVar5;
        c cVar6 = new c("HOURS", 5, TimeUnit.HOURS);
        f13213f = cVar6;
        c cVar7 = new c("DAYS", 6, TimeUnit.DAYS);
        g = cVar7;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
        h = cVarArr;
        n7.b.n(cVarArr);
    }

    public c(String str, int i2, TimeUnit timeUnit) {
        this.f13214a = timeUnit;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) h.clone();
    }
}
