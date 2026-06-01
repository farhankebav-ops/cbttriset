package a4;

import androidx.customview.widget.ViewDragHelper;
import com.bytedance.sdk.openadsdk.core.rp.tV.EO;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import g1.h;
import i4.f;
import i4.m;
import i4.n1;
import i4.v0;
import j4.a3;
import j4.g0;
import j4.g2;
import j4.i0;
import j4.i3;
import j4.j2;
import j4.k3;
import j4.k4;
import j4.m0;
import j4.m1;
import j4.m4;
import j4.n2;
import j4.p0;
import j4.p2;
import j4.q2;
import j4.r4;
import j4.s0;
import j4.t1;
import j4.y2;
import java.io.IOException;
import java.net.Socket;
import java.util.Set;
import java.util.logging.Level;
import k4.j;
import k4.n;
import l7.n0;
import q.e;
import q.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3222b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f3221a = i2;
        this.f3222b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3221a) {
            case 0:
                ((c4.c) this.f3222b).a(null);
                return;
            case 1:
                h hVar = (h) this.f3222b;
                hVar.f11573c = false;
                ViewDragHelper viewDragHelper = ((BottomSheetBehavior) hVar.e).O;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    hVar.a(hVar.f11572b);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) hVar.e;
                if (bottomSheetBehavior.N == 2) {
                    bottomSheetBehavior.l(hVar.f11572b);
                    return;
                }
                return;
            case 2:
                j4.c cVar = (j4.c) this.f3222b;
                try {
                    r4.b.c();
                    try {
                        r4.a aVar = r4.b.f13625a;
                        aVar.getClass();
                        a3 a3Var = cVar.f12134a;
                        if (!a3Var.isClosed()) {
                            a3Var.m += (long) 2;
                            a3Var.a();
                            break;
                        }
                        aVar.getClass();
                        return;
                    } finally {
                        try {
                            break;
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                    ((j) cVar).n(th2);
                    return;
                }
            case 3:
                ((m0) this.f3222b).f12309a.i();
                return;
            case 4:
                ((s0) this.f3222b).f12439a.o();
                return;
            case 5:
                t1 t1Var = (t1) ((i0) this.f3222b).f12249b;
                y2 y2Var = t1Var.f12466r;
                t1Var.f12465q = null;
                t1Var.f12466r = null;
                y2Var.d(n1.m.h("InternalSubchannel closed transport due to address change"));
                return;
            case 6:
                ((q2) ((g0) this.f3222b).f12200b).h();
                return;
            case 7:
                q2 q2Var = (q2) this.f3222b;
                if (q2Var.f12397x == null) {
                    return;
                }
                q2Var.k(true);
                p0 p0Var = q2Var.E;
                p0Var.g(null);
                q2Var.N.i(2, "Entering IDLE state");
                q2Var.f12391r.b(m.f11897d);
                m1 m1Var = q2Var.Y;
                Object[] objArr = {q2Var.C, p0Var};
                m1Var.getClass();
                for (int i2 = 0; i2 < 2; i2++) {
                    if (((Set) m1Var.f11225b).contains(objArr[i2])) {
                        q2Var.h();
                        return;
                    }
                }
                return;
            case 8:
                q2 q2Var2 = ((j2) this.f3222b).f12268b;
                q2Var2.m.d();
                if (q2Var2.f12396w) {
                    q2Var2.f12395v.j();
                    return;
                }
                return;
            case 9:
                ((n2) this.f3222b).f12334d.h();
                return;
            case 10:
                t1 t1Var2 = ((p2) this.f3222b).f12368i;
                t1Var2.k.execute(new i0(15, t1Var2, q2.f0));
                return;
            case 11:
                k3 k3Var = (k3) this.f3222b;
                k3Var.k = null;
                if (k3Var.h.b()) {
                    k3Var.e();
                    return;
                }
                return;
            case 12:
                ((f) ((i3) this.f3222b).f12260c).n();
                return;
            case 13:
                g2 g2Var = (g2) this.f3222b;
                if (g2Var.f12220z) {
                    return;
                }
                g2Var.f12216u.o();
                return;
            case 14:
                k4 k4Var = (k4) this.f3222b;
                g2 g2Var2 = (g2) k4Var.f12292c.f12230c;
                m4 m4Var = k4Var.f12291b;
                v0 v0Var = g2.E;
                g2Var2.p(m4Var);
                return;
            case 15:
                ((r4) this.f3222b).j();
                return;
            case 16:
                k4.c cVar2 = (k4.c) this.f3222b;
                n nVar = cVar2.f12620d;
                try {
                    n0 n0Var = cVar2.f12622i;
                    if (n0Var != null) {
                        l7.j jVar = cVar2.f12618b;
                        long j = jVar.f12868b;
                        if (j > 0) {
                            n0Var.write(jVar, j);
                        }
                    }
                } catch (IOException e) {
                    nVar.o(e);
                }
                try {
                    n0 n0Var2 = cVar2.f12622i;
                    if (n0Var2 != null) {
                        n0Var2.close();
                    }
                } catch (IOException e4) {
                    nVar.o(e4);
                }
                try {
                    Socket socket = cVar2.j;
                    if (socket != null) {
                        socket.close();
                        return;
                    }
                    return;
                } catch (IOException e8) {
                    nVar.o(e8);
                    return;
                }
            case 17:
                c0.b bVar = (c0.b) this.f3222b;
                long j3 = bVar.f4161a;
                long jMax = Math.max(2 * j3, j3);
                j4.f fVar = (j4.f) bVar.f4162b;
                if (fVar.f12182b.compareAndSet(j3, jMax)) {
                    j4.f.f12180c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{fVar.f12181a, Long.valueOf(jMax)});
                    return;
                }
                return;
            case 18:
                ((n) this.f3222b).getClass();
                n nVar2 = (n) this.f3222b;
                nVar2.f12666o.execute(nVar2.f12670t);
                synchronized (((n) this.f3222b).k) {
                    n nVar3 = (n) this.f3222b;
                    nVar3.C = Integer.MAX_VALUE;
                    nVar3.u();
                    break;
                }
                ((n) this.f3222b).getClass();
                return;
            case 19:
                try {
                    ((Runnable) this.f3222b).run();
                    return;
                } catch (Exception e9) {
                    a.a.w("Executor", "Background execution failure.", e9);
                    return;
                }
            case 20:
                g gVar = ((e) this.f3222b).f13349a;
                if (gVar.H) {
                    super/*android.app.Dialog*/.cancel();
                    return;
                } else {
                    gVar.dismiss();
                    return;
                }
            case 21:
                ((y3.a) this.f3222b).a(null);
                return;
            case 22:
                EO eo = (EO) this.f3222b;
                if (((z.n) eo).NV == null) {
                    return;
                }
                long jCl = eo.cl();
                if (jCl > 0 && eo.vCE() && ((z.n) eo).es != Long.MIN_VALUE) {
                    try {
                        if (((z.n) eo).es == jCl) {
                            if (!((z.n) eo).cl && ((z.n) eo).xF >= 400) {
                                eo.e(701);
                                ((z.n) eo).cl = true;
                            }
                            ((z.n) eo).xF += (long) ((z.n) eo).dY;
                        } else {
                            if (((z.n) eo).cl) {
                                ((z.n) eo).cL += ((z.n) eo).xF;
                                eo.e(702);
                                long unused = ((z.n) eo).cL;
                                int unused2 = ((z.n) eo).Bc;
                            }
                            ((z.n) eo).xF = 0L;
                            ((z.n) eo).cl = false;
                        }
                    } catch (Throwable th3) {
                        th3.getMessage();
                    }
                }
                if (eo.zPa() > 0) {
                    if (((z.n) eo).es != jCl) {
                        z.n.IlO(eo, jCl, eo.zPa());
                    }
                    ((z.n) eo).es = jCl;
                }
                if (eo.MY()) {
                    z.n.IlO(eo, eo.zPa(), eo.zPa());
                    return;
                } else {
                    if (((z.n) eo).zPa != null) {
                        ((z.n) eo).zPa.postDelayed(this, ((z.n) eo).dY);
                        return;
                    }
                    return;
                }
            default:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f3222b).f5453c.g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
        }
    }
}
