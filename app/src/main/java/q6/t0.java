package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class t0 implements Runnable, Comparable, o0 {
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13589b = -1;

    public t0(long j) {
        this.f13588a = j;
    }

    public final v6.v b() {
        Object obj = this._heap;
        if (obj instanceof v6.v) {
            return (v6.v) obj;
        }
        return null;
    }

    public final int c(long j, u0 u0Var, v0 v0Var) {
        synchronized (this) {
            if (this._heap == c0.f13533b) {
                return 2;
            }
            synchronized (u0Var) {
                try {
                    t0[] t0VarArr = u0Var.f17652a;
                    t0 t0Var = t0VarArr != null ? t0VarArr[0] : null;
                    if (v0.g.get(v0Var) != 0) {
                        return 1;
                    }
                    if (t0Var == null) {
                        u0Var.f13592c = j;
                    } else {
                        long j3 = t0Var.f13588a;
                        if (j3 - j < 0) {
                            j = j3;
                        }
                        if (j - u0Var.f13592c > 0) {
                            u0Var.f13592c = j;
                        }
                    }
                    long j8 = this.f13588a;
                    long j9 = u0Var.f13592c;
                    if (j8 - j9 < 0) {
                        this.f13588a = j9;
                    }
                    u0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.f13588a - ((t0) obj).f13588a;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    public final void d(u0 u0Var) {
        if (this._heap == c0.f13533b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = u0Var;
    }

    @Override // q6.o0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                e2.f fVar = c0.f13533b;
                if (obj == fVar) {
                    return;
                }
                u0 u0Var = obj instanceof u0 ? (u0) obj : null;
                if (u0Var != null) {
                    u0Var.b(this);
                }
                this._heap = fVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f13588a + ']';
    }
}
