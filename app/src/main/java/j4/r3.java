package j4;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r3 implements i4.i1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f12428d = Logger.getLogger(r3.class.getName());
    public static final e3 e = new e3(17);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e3 f12429f = new e3(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e2.n f12430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f12431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f12432c;

    public r3() {
        String str = System.getenv("GRPC_PROXY_EXP");
        e3 e3Var = f12429f;
        e3Var.getClass();
        this.f12430a = e3Var;
        e3 e3Var2 = e;
        e3Var2.getClass();
        this.f12431b = e3Var2;
        if (str == null) {
            this.f12432c = null;
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        int i2 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f12428d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        this.f12432c = new InetSocketAddress(strArrSplit[0], i2);
    }

    @Override // i4.i1
    public final i4.y a(InetSocketAddress inetSocketAddress) {
        URL url;
        i4.y yVar;
        if (com.ironsource.adqualitysdk.sdk.i.a0.p(inetSocketAddress)) {
            InetSocketAddress inetSocketAddress2 = this.f12432c;
            if (inetSocketAddress2 != null) {
                return new i4.y(inetSocketAddress2, inetSocketAddress, null, null);
            }
            Logger logger = f12428d;
            try {
                try {
                    URI uri = new URI("https", null, f1.d(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                    ProxySelector proxySelector = (ProxySelector) this.f12430a.get();
                    if (proxySelector == null) {
                        logger.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                        return null;
                    }
                    List<Proxy> listSelect = proxySelector.select(uri);
                    if (listSelect.size() > 1) {
                        logger.warning("More than 1 proxy detected, gRPC will select the first one");
                    }
                    Proxy proxy = listSelect.get(0);
                    if (proxy.type() != Proxy.Type.DIRECT) {
                        InetSocketAddress inetSocketAddress3 = (InetSocketAddress) proxy.address();
                        String strD = f1.d(inetSocketAddress3);
                        InetAddress address = inetSocketAddress3.getAddress();
                        int port = inetSocketAddress3.getPort();
                        this.f12431b.getClass();
                        try {
                            url = new URL("https", strD, port, "");
                        } catch (MalformedURLException unused) {
                            logger.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{"https", strD});
                            url = null;
                        }
                        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strD, address, port, "https", "", null, url, Authenticator.RequestorType.PROXY);
                        if (inetSocketAddress3.isUnresolved()) {
                            inetSocketAddress3 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress3.getHostName()), inetSocketAddress3.getPort());
                        }
                        int i2 = i4.y.e;
                        if (passwordAuthenticationRequestPasswordAuthentication == null) {
                            yVar = new i4.y(inetSocketAddress3, inetSocketAddress, null, null);
                        } else {
                            yVar = new i4.y(inetSocketAddress3, inetSocketAddress, passwordAuthenticationRequestPasswordAuthentication.getUserName(), passwordAuthenticationRequestPasswordAuthentication.getPassword() != null ? new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()) : null);
                        }
                        return yVar;
                    }
                } catch (URISyntaxException e4) {
                    logger.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e4);
                    return null;
                }
            } catch (Throwable th) {
                logger.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
                return null;
            }
        }
        return null;
    }
}
