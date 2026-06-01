package a4;

import android.support.v4.media.g;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c4.f;
import com.google.android.material.appbar.AppBarLayout;
import f2.e;
import i4.a1;
import i4.j;
import i4.j1;
import i4.n1;
import i4.o1;
import i4.r1;
import i4.s1;
import i4.x;
import i4.y;
import j4.f1;
import j4.j2;
import j4.m0;
import j4.m2;
import j4.q2;
import j4.z4;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k4.l;
import k4.m;
import k4.n;
import k4.t;
import l7.j0;
import m4.h;
import q4.k;
import q4.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3220d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i2) {
        this.f3217a = i2;
        this.f3219c = obj;
        this.f3220d = obj2;
        this.f3218b = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverScroller overScroller;
        n nVar;
        m mVar;
        Socket socketF;
        SSLSession session;
        Socket socket;
        f2.c cVar;
        int i2;
        q4.n nVar2;
        q4.m mVar2;
        int i8;
        int i9 = 0;
        int i10 = 1;
        switch (this.f3217a) {
            case 0:
                ((f) this.f3220d).a(new a(this, 0));
                return;
            case 1:
                ((f) this.f3220d).a(new a(this, 1));
                return;
            case 2:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f3220d;
                d1.d dVar = (d1.d) this.f3219c;
                View view = (View) this.f3218b;
                if (view == null || (overScroller = dVar.f11034d) == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    dVar.e(coordinatorLayout, view, dVar.f11034d.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) dVar).k(coordinatorLayout, appBarLayout);
                if (appBarLayout.k) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.h(coordinatorLayout)));
                    return;
                }
                return;
            case 3:
                ((s1) this.f3219c).execute((r1) this.f3220d);
                return;
            case 4:
                ((m2) this.f3219c).f12317i.q((x) this.f3220d, (a1) this.f3218b);
                return;
            case 5:
                ((m0) this.f3219c).f12309a.f((n1) this.f3220d, (a1) this.f3218b);
                return;
            case 6:
                i4.m mVar3 = (i4.m) this.f3218b;
                i4.m0 m0Var = (i4.m0) this.f3220d;
                j2 j2Var = (j2) this.f3219c;
                q2 q2Var = j2Var.f12268b;
                if (j2Var != q2Var.f12397x) {
                    return;
                }
                q2Var.y = m0Var;
                q2Var.E.g(m0Var);
                if (mVar3 != i4.m.e) {
                    j2Var.f12268b.N.j(2, "Entering {0} state with picker: {1}", mVar3, m0Var);
                    j2Var.f12268b.f12391r.b(mVar3);
                    return;
                }
                return;
            case 7:
                try {
                    ((CountDownLatch) this.f3220d).await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                j0 j0VarC = l7.b.c(new l());
                try {
                    try {
                        n nVar3 = (n) this.f3219c;
                        y yVar = nVar3.N;
                        if (yVar == null) {
                            socketF = nVar3.A.createSocket(nVar3.f12659a.getAddress(), ((n) this.f3219c).f12659a.getPort());
                        } else {
                            SocketAddress socketAddress = yVar.f11975a;
                            if (!(socketAddress instanceof InetSocketAddress)) {
                                throw new o1(n1.l.h("Unsupported SocketAddress implementation " + ((n) this.f3219c).N.f11975a.getClass()));
                            }
                            socketF = n.f(nVar3, yVar.f11976b, (InetSocketAddress) socketAddress, yVar.f11977c, yVar.f11978d);
                        }
                        n nVar4 = (n) this.f3219c;
                        SSLSocketFactory sSLSocketFactory = nVar4.B;
                        if (sSLSocketFactory != null) {
                            String host = nVar4.f12660b;
                            URI uriA = f1.a(host);
                            if (uriA.getHost() != null) {
                                host = uriA.getHost();
                            }
                            SSLSocket sSLSocketA = t.a(sSLSocketFactory, socketF, host, ((n) this.f3219c).j(), ((n) this.f3219c).E);
                            session = sSLSocketA.getSession();
                            socket = sSLSocketA;
                        } else {
                            session = null;
                            socket = socketF;
                        }
                        socket.setTcpNoDelay(true);
                        j0 j0VarC2 = l7.b.c(l7.b.k(socket));
                        ((k4.c) this.f3218b).a(l7.b.i(socket), socket);
                        n nVar5 = (n) this.f3219c;
                        i4.b bVar = nVar5.f12671u;
                        bVar.getClass();
                        g gVar = new g(bVar);
                        gVar.r(i4.f.f11857a, socket.getRemoteSocketAddress());
                        gVar.r(i4.f.f11858b, socket.getLocalSocketAddress());
                        gVar.r(i4.f.f11859c, session);
                        gVar.r(z4.f12572a, session == null ? j1.f11881a : j1.f11882b);
                        nVar5.f12671u = gVar.b();
                        n nVar6 = (n) this.f3219c;
                        nVar6.g.getClass();
                        nVar6.f12670t = new m(nVar6, new h(j0VarC2));
                        synchronized (((n) this.f3219c).k) {
                            if (session != null) {
                                try {
                                    new j(session);
                                } finally {
                                }
                            }
                            break;
                        }
                        return;
                    } catch (o1 e) {
                        ((n) this.f3219c).t(0, m4.a.INTERNAL_ERROR, e.f11926a);
                        nVar = (n) this.f3219c;
                        nVar.g.getClass();
                        mVar = new m(nVar, new h(j0VarC));
                        nVar.f12670t = mVar;
                        return;
                    } catch (Exception e4) {
                        ((n) this.f3219c).o(e4);
                        nVar = (n) this.f3219c;
                        nVar.g.getClass();
                        mVar = new m(nVar, new h(j0VarC));
                        nVar.f12670t = mVar;
                        return;
                    }
                } catch (Throwable th) {
                    n nVar7 = (n) this.f3219c;
                    nVar7.g.getClass();
                    nVar7.f12670t = new m(nVar7, new h(j0VarC));
                    throw th;
                }
                break;
            case 8:
                q4.t tVar = (q4.t) this.f3219c;
                tVar.l = Long.valueOf(tVar.f13481i.p());
                for (k kVar : ((q4.t) this.f3219c).f13480f.f13458a.values()) {
                    g gVar2 = kVar.f13455c;
                    ((AtomicLong) gVar2.f3263b).set(0L);
                    ((AtomicLong) gVar2.f3264c).set(0L);
                    g gVar3 = kVar.f13454b;
                    kVar.f13454b = kVar.f13455c;
                    kVar.f13455c = gVar3;
                }
                o oVar = (o) this.f3220d;
                i4.f fVar = (i4.f) this.f3218b;
                f2.c cVar2 = e.f11320b;
                f2.b bVar2 = new f2.b();
                if (oVar.e != null) {
                    bVar2.a(new q4.m(oVar, fVar, 1));
                }
                if (oVar.f13470f != null) {
                    bVar2.a(new q4.m(oVar, fVar, 0));
                }
                bVar2.f11313c = true;
                f2.c cVarListIterator = e.g(bVar2.f11312b, (Object[]) bVar2.f11314d).listIterator(0);
                while (cVarListIterator.hasNext()) {
                    q4.m mVar4 = (q4.m) cVarListIterator.next();
                    q4.t tVar2 = (q4.t) this.f3219c;
                    q4.l lVar = tVar2.f13480f;
                    long jLongValue = tVar2.l.longValue();
                    switch (mVar4.f13459a) {
                        case 0:
                            cVar = cVarListIterator;
                            i2 = i9;
                            int i11 = 2;
                            o oVar2 = mVar4.f13460b;
                            ArrayList arrayListH = q4.t.h(lVar, oVar2.f13470f.f13465d.intValue());
                            int size = arrayListH.size();
                            q4.n nVar8 = oVar2.f13470f;
                            if (size >= nVar8.f13464c.intValue() && arrayListH.size() != 0) {
                                int size2 = arrayListH.size();
                                int i12 = i2;
                                while (i12 < size2) {
                                    Object obj = arrayListH.get(i12);
                                    i12++;
                                    k kVar2 = (k) obj;
                                    if (lVar.a() >= oVar2.f13469d.intValue()) {
                                    }
                                    if (kVar2.c() >= nVar8.f13465d.intValue()) {
                                        q4.n nVar9 = nVar8;
                                        if (((AtomicLong) kVar2.f13455c.f3264c).get() / kVar2.c() > ((double) nVar8.f13462a.intValue()) / 100.0d) {
                                            i4.f fVar2 = mVar4.f13461c;
                                            Double dValueOf = Double.valueOf(((AtomicLong) kVar2.f13455c.f3264c).get() / kVar2.c());
                                            Object[] objArr = new Object[i11];
                                            objArr[i2] = kVar2;
                                            objArr[1] = dValueOf;
                                            fVar2.j(1, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", objArr);
                                            nVar2 = nVar9;
                                            if (new Random().nextInt(100) < nVar2.f13463b.intValue()) {
                                                kVar2.b(jLongValue);
                                            }
                                        } else {
                                            nVar2 = nVar9;
                                        }
                                        nVar8 = nVar2;
                                        i11 = 2;
                                    }
                                    break;
                                }
                            }
                            break;
                        default:
                            o oVar3 = mVar4.f13460b;
                            ArrayList arrayListH2 = q4.t.h(lVar, oVar3.e.f13465d.intValue());
                            int size3 = arrayListH2.size();
                            q4.n nVar10 = oVar3.e;
                            if (size3 < nVar10.f13464c.intValue() || arrayListH2.size() == 0) {
                                cVar = cVarListIterator;
                                i2 = i9;
                            } else {
                                ArrayList arrayList = new ArrayList();
                                int size4 = arrayListH2.size();
                                int i13 = i9;
                                while (i13 < size4) {
                                    Object obj2 = arrayListH2.get(i13);
                                    i13++;
                                    int i14 = i9;
                                    k kVar3 = (k) obj2;
                                    arrayList.add(Double.valueOf(((AtomicLong) kVar3.f13455c.f3263b).get() / kVar3.c()));
                                    i9 = i14;
                                    i10 = i10;
                                    mVar4 = mVar4;
                                }
                                i2 = i9;
                                int i15 = i10;
                                q4.m mVar5 = mVar4;
                                int size5 = arrayList.size();
                                int i16 = i2;
                                double dDoubleValue = 0.0d;
                                while (i16 < size5) {
                                    Object obj3 = arrayList.get(i16);
                                    i16++;
                                    dDoubleValue = ((Double) obj3).doubleValue() + dDoubleValue;
                                }
                                double size6 = dDoubleValue / ((double) arrayList.size());
                                int size7 = arrayList.size();
                                int i17 = i2;
                                double d8 = 0.0d;
                                while (i17 < size7) {
                                    Object obj4 = arrayList.get(i17);
                                    i17++;
                                    double dDoubleValue2 = ((Double) obj4).doubleValue() - size6;
                                    d8 = (dDoubleValue2 * dDoubleValue2) + d8;
                                }
                                double dSqrt = Math.sqrt(d8 / ((double) arrayList.size()));
                                double dIntValue = size6 - (((double) (nVar10.f13462a.intValue() / 1000.0f)) * dSqrt);
                                int size8 = arrayListH2.size();
                                int i18 = i2;
                                while (true) {
                                    if (i18 >= size8) {
                                        cVar = cVarListIterator;
                                    } else {
                                        int i19 = i18 + 1;
                                        k kVar4 = (k) arrayListH2.get(i18);
                                        cVar = cVarListIterator;
                                        double d9 = dSqrt;
                                        if (lVar.a() >= oVar3.f13469d.intValue()) {
                                        }
                                        if (((AtomicLong) kVar4.f13455c.f3263b).get() / kVar4.c() < dIntValue) {
                                            mVar2 = mVar5;
                                            i4.f fVar3 = mVar2.f13461c;
                                            i8 = size8;
                                            Double dValueOf2 = Double.valueOf(((AtomicLong) kVar4.f13455c.f3263b).get() / kVar4.c());
                                            Double dValueOf3 = Double.valueOf(size6);
                                            Double dValueOf4 = Double.valueOf(d9);
                                            Double dValueOf5 = Double.valueOf(dIntValue);
                                            Object[] objArr2 = new Object[5];
                                            objArr2[i2] = kVar4;
                                            objArr2[i15] = dValueOf2;
                                            objArr2[2] = dValueOf3;
                                            objArr2[3] = dValueOf4;
                                            objArr2[4] = dValueOf5;
                                            fVar3.j(i15, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", objArr2);
                                            if (new Random().nextInt(100) < nVar10.f13463b.intValue()) {
                                                kVar4.b(jLongValue);
                                            }
                                        } else {
                                            mVar2 = mVar5;
                                            i8 = size8;
                                        }
                                        size8 = i8;
                                        i18 = i19;
                                        dSqrt = d9;
                                        i15 = 1;
                                        mVar5 = mVar2;
                                        cVarListIterator = cVar;
                                    }
                                }
                            }
                            break;
                    }
                    i9 = i2;
                    cVarListIterator = cVar;
                    i10 = 1;
                }
                int i20 = i9;
                q4.t tVar3 = (q4.t) this.f3219c;
                q4.l lVar2 = tVar3.f13480f;
                Long l = tVar3.l;
                for (k kVar5 : lVar2.f13458a.values()) {
                    if (!kVar5.d()) {
                        int i21 = kVar5.e;
                        kVar5.e = i21 == 0 ? i20 : i21 - 1;
                    }
                    if (kVar5.d()) {
                        if (l.longValue() > Math.min(kVar5.f13453a.f13467b.longValue() * ((long) kVar5.e), Math.max(kVar5.f13453a.f13467b.longValue(), kVar5.f13453a.f13468c.longValue())) + kVar5.f13456d.longValue()) {
                            kVar5.e();
                        }
                    }
                }
                return;
            case 9:
                ((y3.c) this.f3220d).a(new w3.a(this, 0));
                return;
            default:
                ((y3.c) this.f3220d).a(new w3.a(this, 1));
                return;
        }
    }

    public String toString() {
        switch (this.f3217a) {
            case 3:
                return ((Runnable) this.f3218b).toString() + "(scheduled in SynchronizationContext)";
            default:
                return super.toString();
        }
    }
}
