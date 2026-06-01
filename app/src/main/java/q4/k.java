package q4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f13453a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f13456d;
    public int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile android.support.v4.media.g f13454b = new android.support.v4.media.g(21);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public android.support.v4.media.g f13455c = new android.support.v4.media.g(21);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f13457f = new HashSet();

    public k(o oVar) {
        this.f13453a = oVar;
    }

    public final void a(s sVar) {
        if (d() && !sVar.f13477f) {
            sVar.u();
        } else if (!d() && sVar.f13477f) {
            sVar.f13477f = false;
            i4.n nVar = sVar.g;
            if (nVar != null) {
                sVar.h.a(nVar);
                sVar.f13478i.j(2, "Subchannel unejected: {0}", sVar);
            }
        }
        sVar.e = this;
        this.f13457f.add(sVar);
    }

    public final void b(long j) {
        this.f13456d = Long.valueOf(j);
        this.e++;
        Iterator it = this.f13457f.iterator();
        while (it.hasNext()) {
            ((s) it.next()).u();
        }
    }

    public final long c() {
        return ((AtomicLong) this.f13455c.f3264c).get() + ((AtomicLong) this.f13455c.f3263b).get();
    }

    public final boolean d() {
        return this.f13456d != null;
    }

    public final void e() {
        r2.q.H(this.f13456d != null, "not currently ejected");
        this.f13456d = null;
        for (s sVar : this.f13457f) {
            sVar.f13477f = false;
            i4.n nVar = sVar.g;
            if (nVar != null) {
                sVar.h.a(nVar);
                sVar.f13478i.j(2, "Subchannel unejected: {0}", sVar);
            }
        }
    }

    public final String toString() {
        return "AddressTracker{subchannels=" + this.f13457f + '}';
    }
}
