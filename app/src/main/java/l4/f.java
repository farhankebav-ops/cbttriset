package l4;

import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements PrivilegedExceptionAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12796a;

    @Override // java.security.PrivilegedExceptionAction
    public final Object run() {
        switch (this.f12796a) {
            case 0:
                return SSLEngine.class.getMethod("getApplicationProtocol", null);
            case 1:
                return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            default:
                return SSLSocket.class.getMethod("getApplicationProtocol", null);
        }
    }
}
