package q0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0.a f13370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y0.a f13371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13372d;

    public b(Context context, y0.a aVar, y0.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f13369a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f13370b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f13371c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f13372d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            b bVar = (b) ((d) obj);
            if (this.f13369a.equals(bVar.f13369a) && this.f13370b.equals(bVar.f13370b) && this.f13371c.equals(bVar.f13371c) && this.f13372d.equals(bVar.f13372d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f13369a.hashCode() ^ 1000003) * 1000003) ^ this.f13370b.hashCode()) * 1000003) ^ this.f13371c.hashCode()) * 1000003) ^ this.f13372d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f13369a);
        sb.append(", wallClock=");
        sb.append(this.f13370b);
        sb.append(", monotonicClock=");
        sb.append(this.f13371c);
        sb.append(", backendName=");
        return a1.a.r(sb, this.f13372d, "}");
    }
}
