package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.k;
import okhttp3.internal.connection.RoutePlanner;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        k.e(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws Throwable {
        RoutePlanner.Plan plan;
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                plan = getRoutePlanner().plan();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    a.a.h(iOException, e);
                }
                if (!a.a(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!plan.isReady()) {
                RoutePlanner.ConnectResult connectResultMo3605connectTcp = plan.mo3605connectTcp();
                if (connectResultMo3605connectTcp.isSuccess()) {
                    connectResultMo3605connectTcp = plan.mo3606connectTlsEtc();
                }
                RoutePlanner.Plan planComponent2 = connectResultMo3605connectTcp.component2();
                Throwable thComponent3 = connectResultMo3605connectTcp.component3();
                if (thComponent3 != null) {
                    throw thComponent3;
                }
                if (planComponent2 != null) {
                    getRoutePlanner().getDeferredPlans().addFirst(planComponent2);
                }
            }
            return plan.mo3602handleSuccess();
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
