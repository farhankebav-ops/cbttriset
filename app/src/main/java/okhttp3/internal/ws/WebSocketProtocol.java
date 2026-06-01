package okhttp3.internal.ws;

import a1.a;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import kotlin.jvm.internal.k;
import l7.h;
import l7.j;
import l7.m;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        k.e(key, "key");
        m mVar = m.f12880d;
        return c.e(key.concat(ACCEPT_MAGIC)).c(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1).a();
    }

    public final String closeCodeExceptionMessage(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return a.g(i2, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i2 || i2 >= 1007) && (1015 > i2 || i2 >= 3000)) {
            return null;
        }
        return a.h(i2, "Code ", " is reserved and may not be used.");
    }

    public final void toggleMask(h cursor, byte[] key) {
        long j;
        k.e(cursor, "cursor");
        k.e(key, "key");
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.e;
            int i8 = cursor.f12856f;
            int i9 = cursor.g;
            if (bArr != null) {
                while (i8 < i9) {
                    int i10 = i2 % length;
                    bArr[i8] = (byte) (bArr[i8] ^ key[i10]);
                    i8++;
                    i2 = i10 + 1;
                }
            }
            long j3 = cursor.f12855d;
            j jVar = cursor.f12852a;
            k.b(jVar);
            if (j3 == jVar.f12868b) {
                throw new IllegalStateException("no more bytes");
            }
            j = cursor.f12855d;
        } while (cursor.b(j == -1 ? 0L : j + ((long) (cursor.g - cursor.f12856f))) != -1);
    }

    public final void validateCloseCode(int i2) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i2);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        k.b(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
