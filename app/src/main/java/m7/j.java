package m7;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends l7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Socket f13020a;

    public j(Socket socket) {
        kotlin.jvm.internal.k.e(socket, "socket");
        this.f13020a = socket;
    }

    @Override // l7.f
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // l7.f
    public final void timedOut() {
        Socket socket = this.f13020a;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!n.a(e)) {
                throw e;
            }
            n.f13040a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e4) {
            n.f13040a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e4);
        }
    }
}
