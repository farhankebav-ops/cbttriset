package sg.bigo.ads.common.utils;

import android.os.SystemClock;
import com.vungle.ads.internal.signals.SignalManager;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes6.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f16034a = new r() { // from class: sg.bigo.ads.common.utils.r.1
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i2) {
            return ((long) i2) * 1000;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f16035b = new r() { // from class: sg.bigo.ads.common.utils.r.2
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i2) {
            return ((long) i2) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f16036c = new r() { // from class: sg.bigo.ads.common.utils.r.3
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i2) {
            return ((long) i2) * 3600000;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f16037d = new r() { // from class: sg.bigo.ads.common.utils.r.4
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i2) {
            return ((long) i2) * SignalManager.TWENTY_FOUR_HOURS_MILLIS;
        }
    };
    private static a e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f16038f = 1619452800;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f16039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f16040b = SystemClock.elapsedRealtime();

        public a(long j) {
            this.f16039a = j;
        }

        public final long a() {
            return (SystemClock.elapsedRealtime() - this.f16040b) + this.f16039a;
        }
    }

    private r() {
    }

    public static long a() {
        long jCurrentTimeMillis = System.currentTimeMillis() - sg.bigo.ads.common.x.a.e();
        if (jCurrentTimeMillis > 0) {
            return jCurrentTimeMillis;
        }
        sg.bigo.ads.common.x.a.f();
        return System.currentTimeMillis();
    }

    public static long b() {
        a aVar = e;
        return aVar == null ? System.currentTimeMillis() : aVar.a();
    }

    public /* synthetic */ r(byte b8) {
        this();
    }

    public long a(int i2) {
        return i2;
    }

    public static void a(long j) {
        if (j < f16038f) {
            return;
        }
        a aVar = new a(j * 1000);
        if (e == null) {
            e = aVar;
        } else if (aVar.a() > e.a()) {
            e = aVar;
        }
    }
}
