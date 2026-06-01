package k4;

import androidx.core.location.LocationRequestCompat;
import i4.u1;
import j4.e3;
import j4.f1;
import j4.g5;
import j4.r2;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends i4.v {
    public static final l4.c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a4.a f12640n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2 f12641a;
    public SSLSocketFactory e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f12642b = g5.f12227d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.a f12643c = f12640n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a4.a f12644d = new a4.a(f1.f12191q, 19);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l4.c f12645f = m;
    public final int g = 1;
    public final long h = LocationRequestCompat.PASSIVE_INTERVAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f12646i = f1.l;
    public final int j = 65535;
    public final int k = 4194304;
    public final int l = Integer.MAX_VALUE;

    static {
        Logger.getLogger(h.class.getName());
        l4.b bVar = new l4.b(l4.c.e);
        int i2 = 2;
        bVar.a(l4.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, l4.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, l4.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, l4.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, l4.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, l4.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        bVar.b(l4.m.TLS_1_2);
        if (!bVar.f12781a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        bVar.f12784d = true;
        m = new l4.c(bVar);
        TimeUnit.DAYS.toNanos(1000L);
        f12640n = new a4.a(new r4.c(i2), 19);
        EnumSet.of(u1.f11968a, u1.f11969b);
    }

    public h(String str) {
        this.f12641a = new r2(str, new f(this), new f(this));
    }
}
