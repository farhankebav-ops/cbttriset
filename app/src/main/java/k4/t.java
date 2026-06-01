package k4;

import com.ironsource.C2300e4;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f12687a = Collections.unmodifiableList(Arrays.asList(l4.l.HTTP_2));

    public static SSLSocket a(SSLSocketFactory sSLSocketFactory, Socket socket, String str, int i2, l4.c cVar) throws IOException {
        l4.l lVar;
        r2.q.D(sSLSocketFactory, "sslSocketFactory");
        r2.q.D(socket, "socket");
        r2.q.D(cVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i2, true);
        String[] strArr = cVar.f12786b;
        String[] strArr2 = strArr != null ? (String[]) l4.n.a(strArr, sSLSocket.getEnabledCipherSuites()) : null;
        String[] strArr3 = (String[]) l4.n.a(cVar.f12787c, sSLSocket.getEnabledProtocols());
        l4.b bVar = new l4.b(cVar);
        if (!bVar.f12781a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr2 == null) {
            bVar.f12782b = null;
        } else {
            bVar.f12782b = (String[]) strArr2.clone();
        }
        if (!bVar.f12781a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr3 == null) {
            bVar.f12783c = null;
        } else {
            bVar.f12783c = (String[]) strArr3.clone();
        }
        l4.c cVar2 = new l4.c(bVar);
        sSLSocket.setEnabledProtocols(cVar2.f12787c);
        String[] strArr4 = cVar2.f12786b;
        if (strArr4 != null) {
            sSLSocket.setEnabledCipherSuites(strArr4);
        }
        q qVar = q.f12684c;
        boolean z2 = cVar.f12788d;
        List list = f12687a;
        String strD = qVar.d(sSLSocket, str, z2 ? list : null);
        if (strD.equals("http/1.0")) {
            lVar = l4.l.HTTP_1_0;
        } else if (strD.equals("http/1.1")) {
            lVar = l4.l.HTTP_1_1;
        } else if (strD.equals("h2")) {
            lVar = l4.l.HTTP_2;
        } else {
            if (!strD.equals("spdy/3.1")) {
                throw new IOException("Unexpected protocol: ".concat(strD));
            }
            lVar = l4.l.SPDY_3;
        }
        r2.q.G(strD, "Only " + list + " are supported, but negotiated protocol is %s", list.contains(lVar));
        if (l4.e.f12794a.verify((str.startsWith(C2300e4.i.f8403d) && str.endsWith(C2300e4.i.e)) ? str.substring(1, str.length() - 1) : str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(str));
    }
}
