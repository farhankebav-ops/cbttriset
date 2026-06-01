package j4;

import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s1 extends i4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i4.e0 f12442d;

    @Override // i4.f
    public final void i(int i2, String str) {
        i4.e0 e0Var = this.f12442d;
        Level levelU = o.u(i2);
        if (q.f12371c.isLoggable(levelU)) {
            q.a(e0Var, levelU, str);
        }
    }

    @Override // i4.f
    public final void j(int i2, String str, Object... objArr) {
        i4.e0 e0Var = this.f12442d;
        Level levelU = o.u(i2);
        if (q.f12371c.isLoggable(levelU)) {
            q.a(e0Var, levelU, MessageFormat.format(str, objArr));
        }
    }
}
