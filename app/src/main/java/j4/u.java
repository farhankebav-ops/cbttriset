package j4;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12485c;

    public /* synthetic */ u(Object obj, long j, int i2) {
        this.f12483a = i2;
        this.f12485c = obj;
        this.f12484b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f12483a;
        long j = this.f12484b;
        Object obj = this.f12485c;
        switch (i2) {
            case 0:
                l1 l1Var = new l1(0);
                v vVar = (v) obj;
                vVar.l.n(l1Var);
                long jAbs = Math.abs(j);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                long nanos = jAbs / timeUnit.toNanos(1L);
                long jAbs2 = Math.abs(j) % timeUnit.toNanos(1L);
                StringBuilder sb = new StringBuilder("deadline exceeded after ");
                if (j < 0) {
                    sb.append('-');
                }
                sb.append(nanos);
                Locale locale = Locale.US;
                sb.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
                sb.append("s. ");
                sb.append(String.format(locale, "Name resolution delay %.9f seconds. ", Double.valueOf(((Long) vVar.k.a(i4.i.f11873a)) == null ? 0.0d : r2.longValue() / v.f12494t)));
                sb.append(l1Var);
                vVar.l.d(i4.n1.h.b(sb.toString()));
                break;
            default:
                z.n nVar = (z.n) obj;
                if (nVar.zPa != null) {
                    nVar.zPa.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                }
                break;
        }
    }
}
