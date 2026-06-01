package l4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f12806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f12807d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f12808a;

    static {
        Provider provider;
        Provider provider2;
        k kVar;
        int i2;
        Logger logger = Logger.getLogger(k.class.getName());
        f12805b = logger;
        f12806c = new String[]{"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        int i8 = 0;
        loop0: while (true) {
            if (i8 >= length) {
                logger.log(Level.WARNING, "Unable to find Conscrypt");
                provider = null;
                break;
            }
            Provider provider3 = providers[i8];
            for (String str : f12806c) {
                if (str.equals(provider3.getClass().getName())) {
                    logger.log(Level.FINE, "Found registered provider {0}", str);
                    provider = provider3;
                    break loop0;
                }
            }
            i8++;
        }
        int i9 = 2;
        if (provider != null) {
            e2.h hVar = new e2.h((Class) null, "setUseSessionTickets", Boolean.TYPE);
            e2.h hVar2 = new e2.h((Class) null, "setHostname", String.class);
            e2.h hVar3 = new e2.h(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            e2.h hVar4 = new e2.h((Class) null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                cls.getMethod("tagSocket", Socket.class);
                cls.getMethod("untagSocket", Socket.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
            if (provider.getName().equals("GmsCore_OpenSSL") || provider.getName().equals("Conscrypt") || provider.getName().equals("Ssl_Guard")) {
                i2 = 1;
                kVar = new g(hVar, hVar2, hVar3, hVar4, provider, i2);
            } else {
                try {
                    k.class.getClassLoader().loadClass("android.net.Network");
                    i2 = 1;
                } catch (ClassNotFoundException e) {
                    logger.log(Level.FINE, "Can't find class", (Throwable) e);
                    try {
                        k.class.getClassLoader().loadClass("android.app.ActivityOptions");
                    } catch (ClassNotFoundException e4) {
                        logger.log(Level.FINE, "Can't find class", (Throwable) e4);
                        i9 = 3;
                    }
                    i2 = i9;
                }
                kVar = new g(hVar, hVar2, hVar3, hVar4, provider, i2);
            }
        } else {
            try {
                Provider provider4 = SSLContext.getDefault().getProvider();
                try {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS", provider4);
                        sSLContext.init(null, null, null);
                        ((Method) AccessController.doPrivileged(new f(0))).invoke(sSLContext.createSSLEngine(), null);
                        kVar = new h(provider4, (Method) AccessController.doPrivileged(new f(1)), (Method) AccessController.doPrivileged(new f(2)));
                    } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused2) {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        try {
                            kVar = new i(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider4);
                        } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                            provider2 = provider4;
                            kVar = new k(provider2);
                        }
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    provider2 = provider4;
                    kVar = new k(provider2);
                    f12807d = kVar;
                }
            } catch (NoSuchAlgorithmException e8) {
                throw new RuntimeException(e8);
            }
        }
        f12807d = kVar;
    }

    public k(Provider provider) {
        this.f12808a = provider;
    }

    public static byte[] b(List list) {
        l7.j jVar = new l7.j();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            if (lVar != l.HTTP_1_0) {
                jVar.x(lVar.f12813a.length());
                jVar.d0(lVar.f12813a);
            }
        }
        return jVar.o(jVar.f12868b);
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public int e() {
        return 3;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
