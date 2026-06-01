package f2;

import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11323c;

    public f(Object obj, Object obj2, Object obj3) {
        this.f11321a = obj;
        this.f11322b = obj2;
        this.f11323c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f11321a;
        sb.append(obj);
        sb.append(C2300e4.i.f8399b);
        sb.append(this.f11322b);
        sb.append(" and ");
        sb.append(obj);
        sb.append(C2300e4.i.f8399b);
        sb.append(this.f11323c);
        return new IllegalArgumentException(sb.toString());
    }
}
