package okhttp3.internal.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        k.e(routePlanner, "routePlanner");
        k.e(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult connectResultPoll;
        if (this.tcpConnectsInFlight.isEmpty() || (connectResultPoll = this.connectResults.poll(j, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(connectResultPoll.getPlan());
        return connectResultPoll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        k.d(it, "iterator(...)");
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.mo3601cancel();
            RoutePlanner.Plan planMo3603retry = next.mo3603retry();
            if (planMo3603retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(planMo3603retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() throws IOException {
        final RoutePlanner.Plan failedPlan;
        if (a.a(getRoutePlanner(), null, 1, null)) {
            try {
                failedPlan = getRoutePlanner().plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner.ConnectResult(failedPlan, null, null, 6, null);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).getResult();
            }
            this.tcpConnectsInFlight.add(failedPlan);
            TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(_UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact()) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder.launchTcpConnect.1
                {
                    int i2 = 2;
                    f fVar = null;
                    boolean z2 = false;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() throws InterruptedException {
                    RoutePlanner.ConnectResult connectResult;
                    try {
                        connectResult = failedPlan.mo3605connectTcp();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(failedPlan, null, th2, 2, null);
                    }
                    if (!this.tcpConnectsInFlight.contains(failedPlan)) {
                        return -1L;
                    }
                    this.connectResults.put(connectResult);
                    return -1L;
                }
            }, 0L, 2, null);
        }
        return null;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws IOException {
        RoutePlanner.ConnectResult connectResultLaunchTcpConnect;
        long j;
        IOException iOException = null;
        while (true) {
            try {
                if (this.tcpConnectsInFlight.isEmpty() && !a.a(getRoutePlanner(), null, 1, null)) {
                    cancelInFlightConnects();
                    k.b(iOException);
                    throw iOException;
                }
                if (getRoutePlanner().isCanceled()) {
                    throw new IOException("Canceled");
                }
                long jNanoTime = this.taskRunner.getBackend().nanoTime();
                long j3 = this.nextTcpConnectAtNanos - jNanoTime;
                if (this.tcpConnectsInFlight.isEmpty() || j3 <= 0) {
                    connectResultLaunchTcpConnect = launchTcpConnect();
                    j = this.connectDelayNanos;
                    this.nextTcpConnectAtNanos = jNanoTime + j;
                } else {
                    j = j3;
                    connectResultLaunchTcpConnect = null;
                }
                if (connectResultLaunchTcpConnect != null || (connectResultLaunchTcpConnect = awaitTcpConnect(j, TimeUnit.NANOSECONDS)) != null) {
                    if (connectResultLaunchTcpConnect.isSuccess()) {
                        cancelInFlightConnects();
                        if (!connectResultLaunchTcpConnect.getPlan().isReady()) {
                            connectResultLaunchTcpConnect = connectResultLaunchTcpConnect.getPlan().mo3606connectTlsEtc();
                        }
                        if (connectResultLaunchTcpConnect.isSuccess()) {
                            return connectResultLaunchTcpConnect.getPlan().mo3602handleSuccess();
                        }
                    }
                    Throwable throwable = connectResultLaunchTcpConnect.getThrowable();
                    if (throwable != null) {
                        if (!(throwable instanceof IOException)) {
                            throw throwable;
                        }
                        if (iOException == null) {
                            iOException = (IOException) throwable;
                        } else {
                            a.a.h(iOException, throwable);
                        }
                    }
                    RoutePlanner.Plan nextPlan = connectResultLaunchTcpConnect.getNextPlan();
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                }
            } finally {
                cancelInFlightConnects();
            }
        }
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
