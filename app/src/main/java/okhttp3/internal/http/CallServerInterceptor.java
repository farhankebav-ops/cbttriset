package okhttp3.internal.http;

import okhttp3.Interceptor;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z2) {
        this.forWebSocket = z2;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i2, Exchange exchange) {
        if (i2 == 100) {
            return true;
        }
        return 102 <= i2 && i2 < 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:45:0x00de, B:47:0x00e4, B:49:0x00ed, B:50:0x00f0, B:51:0x0115, B:55:0x0120, B:57:0x013e, B:59:0x014c, B:66:0x0162, B:69:0x0171, B:70:0x0197, B:61:0x0157, B:56:0x0125), top: B:79:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:45:0x00de, B:47:0x00e4, B:49:0x00ed, B:50:0x00f0, B:51:0x0115, B:55:0x0120, B:57:0x013e, B:59:0x014c, B:66:0x0162, B:69:0x0171, B:70:0x0197, B:61:0x0157, B:56:0x0125), top: B:79:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0157 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:45:0x00de, B:47:0x00e4, B:49:0x00ed, B:50:0x00f0, B:51:0x0115, B:55:0x0120, B:57:0x013e, B:59:0x014c, B:66:0x0162, B:69:0x0171, B:70:0x0197, B:61:0x0157, B:56:0x0125), top: B:79:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
