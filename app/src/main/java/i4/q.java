package i4;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11931a = Logger.getLogger(q.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f11932b = new q();

    public static q b() {
        ((t1) o.f11921a).getClass();
        q qVar = (q) t1.f11959b.get();
        q qVar2 = f11932b;
        if (qVar == null) {
            qVar = qVar2;
        }
        return qVar == null ? qVar2 : qVar;
    }

    public final q a() {
        ((t1) o.f11921a).getClass();
        ThreadLocal threadLocal = t1.f11959b;
        q qVar = (q) threadLocal.get();
        q qVar2 = f11932b;
        if (qVar == null) {
            qVar = qVar2;
        }
        threadLocal.set(this);
        return qVar == null ? qVar2 : qVar;
    }

    public final void c(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("toAttach");
        }
        t1 t1Var = (t1) o.f11921a;
        ThreadLocal threadLocal = t1.f11959b;
        t1Var.getClass();
        q qVar2 = (q) threadLocal.get();
        q qVar3 = f11932b;
        if (qVar2 == null) {
            qVar2 = qVar3;
        }
        if (qVar2 != this) {
            t1.f11958a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (qVar != qVar3) {
            threadLocal.set(qVar);
        } else {
            threadLocal.set(null);
        }
    }
}
