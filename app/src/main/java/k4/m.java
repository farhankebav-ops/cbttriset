package k4;

import i4.n1;
import j4.a2;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.support.v4.media.g f12655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m4.h f12656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f12658d;

    public m(n nVar, m4.h hVar) {
        this.f12658d = nVar;
        Level level = Level.FINE;
        this.f12655a = new android.support.v4.media.g(15);
        this.f12657c = true;
        this.f12656b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n1 n1VarH;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.f12656b.a(this)) {
            try {
                a2 a2Var = this.f12658d.F;
                if (a2Var != null) {
                    a2Var.a();
                }
            } catch (Throwable th) {
                try {
                    n nVar = this.f12658d;
                    m4.a aVar = m4.a.PROTOCOL_ERROR;
                    n1 n1VarG = n1.l.h("error in frame handler").g(th);
                    Map map = n.P;
                    nVar.t(0, aVar, n1VarG);
                    try {
                        this.f12656b.close();
                    } catch (IOException e) {
                        e = e;
                        n.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                    } catch (RuntimeException e4) {
                        if (!"bio == null".equals(e4.getMessage())) {
                            throw e4;
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        this.f12656b.close();
                    } catch (IOException e8) {
                        n.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e8);
                    } catch (RuntimeException e9) {
                        if (!"bio == null".equals(e9.getMessage())) {
                            throw e9;
                        }
                    }
                    this.f12658d.h.d();
                    Thread.currentThread().setName(name);
                    throw th2;
                }
            }
        }
        synchronized (this.f12658d.k) {
            n1VarH = this.f12658d.f12672v;
        }
        if (n1VarH == null) {
            n1VarH = n1.m.h("End of stream or IOException");
        }
        this.f12658d.t(0, m4.a.INTERNAL_ERROR, n1VarH);
        try {
            this.f12656b.close();
        } catch (IOException e10) {
            e = e10;
            n.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
        } catch (RuntimeException e11) {
            if (!"bio == null".equals(e11.getMessage())) {
                throw e11;
            }
        }
        this.f12658d.h.d();
        Thread.currentThread().setName(name);
    }
}
