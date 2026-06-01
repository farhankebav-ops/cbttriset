package j4;

import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends i4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f12341d;
    public final e3 e;

    public o(q qVar, e3 e3Var) {
        this.f12341d = qVar;
        r2.q.D(e3Var, InfluenceConstants.TIME);
        this.e = e3Var;
    }

    public static Level u(int i2) {
        int iB = q0.c.b(i2);
        return iB != 1 ? (iB == 2 || iB == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    @Override // i4.f
    public final void i(int i2, String str) {
        q qVar = this.f12341d;
        i4.e0 e0Var = qVar.f12373b;
        Level levelU = u(i2);
        if (q.f12371c.isLoggable(levelU)) {
            q.a(e0Var, levelU, str);
        }
        if (!t(i2) || i2 == 1) {
            return;
        }
        int iB = q0.c.b(i2);
        i4.z zVar = iB != 2 ? iB != 3 ? i4.z.f11979a : i4.z.f11981c : i4.z.f11980b;
        long jP = this.e.p();
        r2.q.D(str, "description");
        new i4.a0(str, zVar, jP, null);
        synchronized (qVar.f12372a) {
        }
    }

    @Override // i4.f
    public final void j(int i2, String str, Object... objArr) {
        i(i2, (t(i2) || q.f12371c.isLoggable(u(i2))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean t(int i2) {
        if (i2 == 1) {
            return false;
        }
        synchronized (this.f12341d.f12372a) {
        }
        return false;
    }
}
