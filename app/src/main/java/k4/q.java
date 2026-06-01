package k4;

import com.ironsource.Q6;
import j4.f1;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f12684c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4.k f12685a;

    static {
        q qVar;
        Logger logger = Logger.getLogger(q.class.getName());
        f12683b = logger;
        l4.k kVar = l4.k.f12807d;
        ClassLoader classLoader = q.class.getClassLoader();
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e4) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e4);
                qVar = new q(kVar);
            }
        }
        qVar = new p(kVar);
        f12684c = qVar;
    }

    public q(l4.k kVar) {
        r2.q.D(kVar, Q6.H);
        this.f12685a = kVar;
    }

    public static boolean c(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            r2.q.w(str, "Userinfo must not be present on authority: '%s'", f1.a(str).getAuthority().indexOf(64) == -1);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List list) {
        this.f12685a.c(sSLSocket, str, list);
    }

    public String b(SSLSocket sSLSocket) {
        return this.f12685a.d(sSLSocket);
    }

    public String d(SSLSocket sSLSocket, String str, List list) {
        l4.k kVar = this.f12685a;
        if (list != null) {
            a(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strB = b(sSLSocket);
            if (strB != null) {
                return strB;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            kVar.a(sSLSocket);
        }
    }
}
