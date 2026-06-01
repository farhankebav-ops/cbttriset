package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final StatusLine get(Response response) {
            k.e(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws IOException {
            Protocol protocol;
            int i2;
            String strSubstring;
            k.e(statusLine, "statusLine");
            if (t.n0(statusLine, "HTTP/1.", false)) {
                i2 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (t.n0(statusLine, "ICY ", false)) {
                protocol = Protocol.HTTP_1_0;
                i2 = 4;
            } else {
                if (!t.n0(statusLine, "SOURCETABLE ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_1;
                i2 = 12;
            }
            int i8 = i2 + 3;
            if (statusLine.length() < i8) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            String strSubstring2 = statusLine.substring(i2, i8);
            k.d(strSubstring2, "substring(...)");
            Integer numO0 = t.o0(strSubstring2);
            if (numO0 == null) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iIntValue = numO0.intValue();
            if (statusLine.length() <= i8) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i2 + 4);
                k.d(strSubstring, "substring(...)");
            }
            return new StatusLine(protocol, iIntValue, strSubstring);
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i2, String message) {
        k.e(protocol, "protocol");
        k.e(message, "message");
        this.protocol = protocol;
        this.code = i2;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        return sb.toString();
    }
}
