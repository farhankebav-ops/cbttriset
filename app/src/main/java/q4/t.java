package q4;

import i4.l0;
import i4.n1;
import i4.o0;
import i4.q1;
import i4.r1;
import i4.s1;
import j4.e3;
import j4.y4;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends o0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i4.a f13479n = new i4.a("addressTrackerKey");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f13480f;
    public final s1 g;
    public final e h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e3 f13481i;
    public final ScheduledExecutorService j;
    public android.support.v4.media.g k;
    public Long l;
    public final i4.f m;

    public t(i4.x xVar) {
        e3 e3Var = e3.f12177c;
        i4.f fVarB = xVar.b();
        this.m = fVarB;
        this.h = new e(new d(this, xVar));
        this.f13480f = new l();
        s1 s1VarE = xVar.e();
        r2.q.D(s1VarE, "syncContext");
        this.g = s1VarE;
        ScheduledExecutorService scheduledExecutorServiceC = xVar.c();
        r2.q.D(scheduledExecutorServiceC, "timeService");
        this.j = scheduledExecutorServiceC;
        this.f13481i = e3Var;
        fVarB.i(1, "OutlierDetection lb created.");
    }

    public static boolean g(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((i4.u) it.next()).f11961a.size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList h(l lVar, int i2) {
        ArrayList arrayList = new ArrayList();
        for (k kVar : lVar.f13458a.values()) {
            if (kVar.c() >= i2) {
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    @Override // i4.o0
    public final n1 a(l0 l0Var) {
        e eVar = this.h;
        l lVar = this.f13480f;
        i4.f fVar = this.m;
        fVar.j(1, "Received resolution result: {0}", l0Var);
        o oVar = (o) l0Var.f11893c;
        ArrayList arrayList = new ArrayList();
        Iterator it = l0Var.f11891a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((i4.u) it.next()).f11961a);
        }
        lVar.f13458a.keySet().retainAll(arrayList);
        Iterator it2 = lVar.f13458a.values().iterator();
        while (it2.hasNext()) {
            ((k) it2.next()).f13453a = oVar;
        }
        HashMap map = lVar.f13458a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            SocketAddress socketAddress = (SocketAddress) obj;
            if (!map.containsKey(socketAddress)) {
                map.put(socketAddress, new k(oVar));
            }
        }
        y4 y4Var = oVar.g;
        Long l = oVar.f13466a;
        eVar.i(y4Var.f12558a);
        if (oVar.e == null && oVar.f13470f == null) {
            android.support.v4.media.g gVar = this.k;
            if (gVar != null) {
                gVar.c();
                this.l = null;
                for (k kVar : lVar.f13458a.values()) {
                    if (kVar.d()) {
                        kVar.e();
                    }
                    kVar.e = 0;
                }
            }
        } else {
            Long lValueOf = this.l == null ? l : Long.valueOf(Math.max(0L, l.longValue() - (this.f13481i.p() - this.l.longValue())));
            android.support.v4.media.g gVar2 = this.k;
            if (gVar2 != null) {
                gVar2.c();
                for (k kVar2 : lVar.f13458a.values()) {
                    android.support.v4.media.g gVar3 = kVar2.f13454b;
                    ((AtomicLong) gVar3.f3263b).set(0L);
                    ((AtomicLong) gVar3.f3264c).set(0L);
                    android.support.v4.media.g gVar4 = kVar2.f13455c;
                    ((AtomicLong) gVar4.f3263b).set(0L);
                    ((AtomicLong) gVar4.f3264c).set(0L);
                }
            }
            s1 s1Var = this.g;
            a4.b bVar = new a4.b(this, oVar, fVar, 8);
            long jLongValue = lValueOf.longValue();
            long jLongValue2 = l.longValue();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            ScheduledExecutorService scheduledExecutorService = this.j;
            s1Var.getClass();
            r1 r1Var = new r1(bVar);
            this.k = new android.support.v4.media.g(r1Var, scheduledExecutorService.scheduleWithFixedDelay(new q1(s1Var, r1Var, bVar, jLongValue2), jLongValue, jLongValue2, timeUnit));
        }
        i4.b bVar2 = i4.b.f11821b;
        eVar.d(new l0(l0Var.f11891a, l0Var.f11892b, oVar.g.f12559b));
        return n1.e;
    }

    @Override // i4.o0
    public final void c(n1 n1Var) {
        this.h.c(n1Var);
    }

    @Override // i4.o0
    public final void f() {
        this.h.f();
    }
}
