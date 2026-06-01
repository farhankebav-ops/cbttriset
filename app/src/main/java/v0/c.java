package v0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f17572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f17573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c[] f17574d;

    static {
        c cVar = new c("NETWORK_UNMETERED", 0);
        f17571a = cVar;
        c cVar2 = new c("DEVICE_IDLE", 1);
        f17572b = cVar2;
        c cVar3 = new c("DEVICE_CHARGING", 2);
        f17573c = cVar3;
        f17574d = new c[]{cVar, cVar2, cVar3};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f17574d.clone();
    }
}
