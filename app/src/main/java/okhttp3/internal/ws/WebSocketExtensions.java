package okhttp3.internal.ws;

import a1.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00bd A[PHI: r7 r9 r11
  0x00bd: PHI (r7v5 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v9 java.lang.Integer) binds: [B:52:0x00e8, B:34:0x00b4] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r9v8 java.lang.Integer) = (r9v6 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:52:0x00e8, B:34:0x00b4] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r11v16 boolean) = (r11v10 boolean), (r11v19 boolean) binds: [B:52:0x00e8, B:34:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r19) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }

        private Companion() {
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z2, Integer num, boolean z7, Integer num2, boolean z8, boolean z9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = webSocketExtensions.perMessageDeflate;
        }
        if ((i2 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i2 & 4) != 0) {
            z7 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i2 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i2 & 16) != 0) {
            z8 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i2 & 32) != 0) {
            z9 = webSocketExtensions.unknownValues;
        }
        boolean z10 = z8;
        boolean z11 = z9;
        return webSocketExtensions.copy(z2, num, z7, num2, z10, z11);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z2, Integer num, boolean z7, Integer num2, boolean z8, boolean z9) {
        return new WebSocketExtensions(z2, num, z7, num2, z8, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && k.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && k.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        int i2 = (this.perMessageDeflate ? 1231 : 1237) * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (((i2 + (num == null ? 0 : num.hashCode())) * 31) + (this.clientNoContextTakeover ? 1231 : 1237)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        return ((((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + (this.serverNoContextTakeover ? 1231 : 1237)) * 31) + (this.unknownValues ? 1231 : 1237);
    }

    public final boolean noContextTakeover(boolean z2) {
        return z2 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebSocketExtensions(perMessageDeflate=");
        sb.append(this.perMessageDeflate);
        sb.append(", clientMaxWindowBits=");
        sb.append(this.clientMaxWindowBits);
        sb.append(", clientNoContextTakeover=");
        sb.append(this.clientNoContextTakeover);
        sb.append(", serverMaxWindowBits=");
        sb.append(this.serverMaxWindowBits);
        sb.append(", serverNoContextTakeover=");
        sb.append(this.serverNoContextTakeover);
        sb.append(", unknownValues=");
        return a.t(sb, this.unknownValues, ')');
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z7, Integer num2, boolean z8, boolean z9) {
        this.perMessageDeflate = z2;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z7;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z8;
        this.unknownValues = z9;
    }

    public /* synthetic */ WebSocketExtensions(boolean z2, Integer num, boolean z7, Integer num2, boolean z8, boolean z9, int i2, f fVar) {
        this((i2 & 1) != 0 ? false : z2, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z7, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? false : z8, (i2 & 32) != 0 ? false : z9);
    }
}
