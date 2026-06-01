package u3;

import com.ironsource.mediationsdk.l;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f17532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f17533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f17534d;
    public static final /* synthetic */ d[] e;

    static {
        d dVar = new d("UNSPECIFIED", 0);
        f17531a = dVar;
        d dVar2 = new d("INTERSTITIAL", 1);
        f17532b = dVar2;
        d dVar3 = new d("REWARDED", 2);
        f17533c = dVar3;
        d dVar4 = new d(l.f9204a, 3);
        f17534d = dVar4;
        e = new d[]{dVar, dVar2, dVar3, dVar4};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) e.clone();
    }
}
