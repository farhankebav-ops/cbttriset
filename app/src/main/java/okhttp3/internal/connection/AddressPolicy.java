package okhttp3.internal.connection;

import kotlin.jvm.internal.f;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AddressPolicy {
    public final long backoffDelayMillis;
    public final int backoffJitterMillis;
    public final int minimumConcurrentCalls;

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }

    public AddressPolicy(int i2, long j, int i8) {
        this.minimumConcurrentCalls = i2;
        this.backoffDelayMillis = j;
        this.backoffJitterMillis = i8;
    }

    public /* synthetic */ AddressPolicy(int i2, long j, int i8, int i9, f fVar) {
        this((i9 & 1) != 0 ? 0 : i2, (i9 & 2) != 0 ? RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS : j, (i9 & 4) != 0 ? 100 : i8);
    }
}
