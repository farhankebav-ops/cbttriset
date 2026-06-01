package j4;

import androidx.exifinterface.media.ExifInterface;
import java.io.OutputStream;
import java.net.ProxySelector;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e3 implements w, c0, d0, b5, e2.n, i4.f0, i4.w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e3 f12176b = new e3(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e3 f12177c = new e3(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12178a;

    public /* synthetic */ e3(int i2) {
        this.f12178a = i2;
    }

    public static x0 q() {
        x0 x0Var = new x0();
        x0Var.f12542a = new Random();
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        x0Var.f12543b = TimeUnit.MINUTES.toNanos(2L);
        x0Var.f12544c = 1.6d;
        x0Var.f12545d = 0.2d;
        x0Var.e = nanos;
        return x0Var;
    }

    @Override // i4.z0
    /* JADX INFO: renamed from: c */
    public byte[] mo3445c(Object obj) {
        switch (this.f12178a) {
            case 13:
                return (byte[]) obj;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // j4.b5
    public void close(Object obj) {
        switch (this.f12178a) {
            case 10:
                ((ExecutorService) ((Executor) obj)).shutdown();
                break;
            default:
                ((ScheduledExecutorService) obj).shutdown();
                break;
        }
    }

    @Override // j4.b5
    public Object create() {
        switch (this.f12178a) {
            case 10:
                return Executors.newCachedThreadPool(f1.e("grpc-default-executor-%d"));
            default:
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, f1.e("grpc-timer-%d"));
                try {
                    scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
                    break;
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e4) {
                    throw new RuntimeException(e4);
                }
                return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    @Override // j4.d0
    public int f(e eVar, int i2, Object obj, int i8) {
        switch (this.f12178a) {
            case 4:
                break;
            case 5:
                eVar.p(i2);
                break;
            case 6:
                eVar.k((byte[]) obj, i8, i2);
                break;
            case 7:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + i2);
                eVar.j(byteBuffer);
                byteBuffer.limit(iLimit);
                break;
            default:
                eVar.i((OutputStream) obj, i2);
                break;
        }
        return 0;
    }

    @Override // i4.w0
    public Object g(String str) {
        r2.q.y(str.length() > 0, "empty timeout");
        r2.q.y(str.length() <= 9, "bad timeout format");
        long j = Long.parseLong(str.substring(0, str.length() - 1));
        char cCharAt = str.charAt(str.length() - 1);
        if (cCharAt == 'H') {
            return Long.valueOf(TimeUnit.HOURS.toNanos(j));
        }
        if (cCharAt == 'M') {
            return Long.valueOf(TimeUnit.MINUTES.toNanos(j));
        }
        if (cCharAt == 'S') {
            return Long.valueOf(TimeUnit.SECONDS.toNanos(j));
        }
        if (cCharAt == 'u') {
            return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j));
        }
        if (cCharAt == 'm') {
            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j));
        }
        if (cCharAt == 'n') {
            return Long.valueOf(j);
        }
        throw new IllegalArgumentException("Invalid timeout unit: " + cCharAt);
    }

    @Override // e2.n
    public Object get() {
        switch (this.f12178a) {
            case 12:
                return new e2.m();
            default:
                return ProxySelector.getDefault();
        }
    }

    @Override // j4.e5
    public boolean isReady() {
        return false;
    }

    @Override // j4.w
    public void n(l1 l1Var) {
        l1Var.f12300b.add("noop");
    }

    @Override // i4.z0
    public Object o(byte[] bArr) {
        switch (this.f12178a) {
            case 13:
                return bArr;
            default:
                if (bArr.length < 3) {
                    throw new NumberFormatException("Malformed status code ".concat(new String(bArr, i4.g0.f11865a)));
                }
                return Integer.valueOf((bArr[2] - 48) + ((bArr[1] - 48) * 10) + ((bArr[0] - 48) * 100));
        }
    }

    public long p() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public String toString() {
        switch (this.f12178a) {
            case 10:
                return "grpc-default-executor";
            default:
                return super.toString();
        }
    }

    public e3(m mVar) {
        this.f12178a = 2;
    }

    @Override // i4.w0
    public String c(Object obj) {
        Long l = (Long) obj;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (l.longValue() < 0) {
            throw new IllegalArgumentException("Timeout too small");
        }
        if (l.longValue() < 100000000) {
            return l + "n";
        }
        if (l.longValue() < 100000000000L) {
            return timeUnit.toMicros(l.longValue()) + "u";
        }
        if (l.longValue() < 100000000000000L) {
            return timeUnit.toMillis(l.longValue()) + "m";
        }
        if (l.longValue() < 100000000000000000L) {
            return timeUnit.toSeconds(l.longValue()) + ExifInterface.LATITUDE_SOUTH;
        }
        if (l.longValue() < 6000000000000000000L) {
            return timeUnit.toMinutes(l.longValue()) + "M";
        }
        return timeUnit.toHours(l.longValue()) + "H";
    }

    @Override // j4.e5
    public void flush() {
    }

    @Override // j4.e5
    public void j() {
    }

    @Override // j4.w
    public void l() {
    }

    @Override // j4.e5
    public void request() {
    }

    @Override // j4.w
    public void a(int i2) {
    }

    @Override // j4.e5
    public void b(i4.k kVar) {
    }

    @Override // j4.w
    public void d(i4.n1 n1Var) {
    }

    @Override // j4.e5
    public void e(o4.a aVar) {
    }

    @Override // j4.w
    public void h(i4.t tVar) {
    }

    @Override // j4.w
    public void i(int i2) {
    }

    @Override // j4.w
    public void k(i4.r rVar) {
    }

    @Override // j4.w
    public void m(y yVar) {
    }
}
