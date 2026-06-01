package q6;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g1 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient n1 f13549a;

    public g1(String str, Throwable th, n1 n1Var) {
        super(str);
        this.f13549a = n1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return kotlin.jvm.internal.k.a(g1Var.getMessage(), getMessage()) && kotlin.jvm.internal.k.a(g1Var.f13549a, this.f13549a) && kotlin.jvm.internal.k.a(g1Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.k.b(message);
        int iHashCode = (this.f13549a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f13549a;
    }
}
