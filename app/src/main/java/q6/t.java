package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f13585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e6.q f13586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13587d;
    public final Throwable e;

    public t(Object obj, i iVar, e6.q qVar, Object obj2, Throwable th) {
        this.f13584a = obj;
        this.f13585b = iVar;
        this.f13586c = qVar;
        this.f13587d = obj2;
        this.e = th;
    }

    public static t a(t tVar, i iVar, Throwable th, int i2) {
        Object obj = tVar.f13584a;
        if ((i2 & 2) != 0) {
            iVar = tVar.f13585b;
        }
        i iVar2 = iVar;
        e6.q qVar = tVar.f13586c;
        Object obj2 = tVar.f13587d;
        if ((i2 & 16) != 0) {
            th = tVar.e;
        }
        return new t(obj, iVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.k.a(this.f13584a, tVar.f13584a) && kotlin.jvm.internal.k.a(this.f13585b, tVar.f13585b) && kotlin.jvm.internal.k.a(this.f13586c, tVar.f13586c) && kotlin.jvm.internal.k.a(this.f13587d, tVar.f13587d) && kotlin.jvm.internal.k.a(this.e, tVar.e);
    }

    public final int hashCode() {
        Object obj = this.f13584a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f13585b;
        int iHashCode2 = (iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        e6.q qVar = this.f13586c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f13587d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f13584a + ", cancelHandler=" + this.f13585b + ", onCancellation=" + this.f13586c + ", idempotentResume=" + this.f13587d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ t(Object obj, i iVar, e6.q qVar, Throwable th, int i2) {
        this(obj, (i2 & 2) != 0 ? null : iVar, (i2 & 4) != 0 ? null : qVar, (Object) null, (i2 & 16) != 0 ? null : th);
    }
}
