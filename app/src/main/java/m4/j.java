package m4;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;
import l7.j0;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f12964a = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f12965b;

    static {
        m mVar = m.f12880d;
        f12965b = r4.c.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    public static int a(j0 j0Var) {
        return (j0Var.readByte() & 255) | ((j0Var.readByte() & 255) << 16) | ((j0Var.readByte() & 255) << 8);
    }

    public static int b(int i2, byte b8, short s7) throws IOException {
        if ((b8 & 8) != 0) {
            i2--;
        }
        if (s7 <= i2) {
            return (short) (i2 - s7);
        }
        c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s7), Integer.valueOf(i2));
        throw null;
    }

    public static void c(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
