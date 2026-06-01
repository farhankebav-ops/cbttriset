package okhttp3.internal.connection;

import kotlin.jvm.internal.k;
import okhttp3.internal.connection.RoutePlanner;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ReusePlan implements RoutePlanner.Plan {
    private final RealConnection connection;
    private final boolean isReady;

    public ReusePlan(RealConnection connection) {
        k.e(connection, "connection");
        this.connection = connection;
        this.isReady = true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTcp, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo3605connectTcp() {
        return (RoutePlanner.ConnectResult) connectTcp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTlsEtc, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo3606connectTlsEtc() {
        return (RoutePlanner.ConnectResult) connectTlsEtc();
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: handleSuccess */
    public RealConnection mo3602handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.isReady;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: retry */
    public /* bridge */ /* synthetic */ RoutePlanner.Plan mo3603retry() {
        return (RoutePlanner.Plan) retry();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* JADX INFO: renamed from: cancel, reason: merged with bridge method [inline-methods] */
    public Void mo3601cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    public Void connectTcp() {
        throw new IllegalStateException("already connected");
    }

    public Void connectTlsEtc() {
        throw new IllegalStateException("already connected");
    }

    public Void retry() {
        throw new IllegalStateException("unexpected retry");
    }
}
