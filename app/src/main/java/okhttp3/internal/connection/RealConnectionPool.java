package okhttp3.internal.connection;

import e6.q;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import q5.i;
import r5.s;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private static AtomicReferenceFieldUpdater<RealConnectionPool, Map<?, ?>> addressStatesUpdater = AtomicReferenceFieldUpdater.newUpdater(RealConnectionPool.class, Map.class, "addressStates");
    private volatile Map<Address, AddressState> addressStates;
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConnectionListener connectionListener;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final q exchangeFinderFactory;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final TaskRunner taskRunner;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AddressState {
        private final Address address;
        private int concurrentCallCapacity;
        private AddressPolicy policy;
        private final TaskQueue queue;

        public AddressState(Address address, TaskQueue queue, AddressPolicy policy) {
            k.e(address, "address");
            k.e(queue, "queue");
            k.e(policy, "policy");
            this.address = address;
            this.queue = queue;
            this.policy = policy;
        }

        public final Address getAddress() {
            return this.address;
        }

        public final int getConcurrentCallCapacity() {
            return this.concurrentCallCapacity;
        }

        public final AddressPolicy getPolicy() {
            return this.policy;
        }

        public final TaskQueue getQueue() {
            return this.queue;
        }

        public final void setConcurrentCallCapacity(int i2) {
            this.concurrentCallCapacity = i2;
        }

        public final void setPolicy(AddressPolicy addressPolicy) {
            k.e(addressPolicy, "<set-?>");
            this.policy = addressPolicy;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            k.e(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i2, long j, TimeUnit timeUnit, ConnectionListener connectionListener, q exchangeFinderFactory) {
        k.e(taskRunner, "taskRunner");
        k.e(timeUnit, "timeUnit");
        k.e(connectionListener, "connectionListener");
        k.e(exchangeFinderFactory, "exchangeFinderFactory");
        this.taskRunner = taskRunner;
        this.maxIdleConnections = i2;
        this.connectionListener = connectionListener;
        this.exchangeFinderFactory = exchangeFinderFactory;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.addressStates = s.f13639a;
        this.cleanupQueue = taskRunner.newQueue();
        final String strR = a1.a.r(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool connection closer");
        this.cleanupTask = new Task(strR) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            {
                int i8 = 2;
                f fVar = null;
                boolean z2 = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return this.this$0.closeConnections(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j <= 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("keepAliveDuration <= 0: ", j).toString());
        }
    }

    private final boolean isEvictable(Map<Address, AddressState> map, RealConnection realConnection) {
        AddressState addressState = map.get(realConnection.getRoute().address());
        return addressState == null || addressState.getConcurrentCallCapacity() - realConnection.getAllocationLimit$okhttp() >= addressState.getPolicy().minimumConcurrentCalls;
    }

    private final long jitterBy(long j, int i2) {
        return j + ((long) ThreadLocalRandom.current().nextInt(i2 * (-1), i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long openConnections(AddressState addressState) {
        if (addressState.getPolicy().minimumConcurrentCalls == 0) {
            return -1L;
        }
        Iterator<RealConnection> it = this.connections.iterator();
        k.d(it, "iterator(...)");
        int allocationLimit$okhttp = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            if (k.a(addressState.getAddress(), next.getRoute().address())) {
                synchronized (next) {
                    allocationLimit$okhttp += next.getAllocationLimit$okhttp();
                }
                if (allocationLimit$okhttp >= addressState.getPolicy().minimumConcurrentCalls) {
                    return -1L;
                }
            }
        }
        try {
            RealConnection realConnectionFind = ((ExchangeFinder) this.exchangeFinderFactory.invoke(this, addressState.getAddress(), PoolConnectionUser.INSTANCE)).find();
            if (this.connections.contains(realConnectionFind)) {
                return 0L;
            }
            synchronized (realConnectionFind) {
                put(realConnectionFind);
            }
            return 0L;
        } catch (IOException unused) {
            return jitterBy(addressState.getPolicy().backoffDelayMillis, addressState.getPolicy().backoffJitterMillis) * ((long) 1000000);
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i2 = 0;
        while (i2 < calls.size()) {
            Reference<RealCall> reference = calls.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i2);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs(j - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    private final void scheduleOpener(final AddressState addressState) {
        TaskQueue.schedule$default(addressState.getQueue(), new Task(a1.a.r(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool connection opener")) { // from class: okhttp3.internal.connection.RealConnectionPool.scheduleOpener.1
            {
                int i2 = 2;
                f fVar = null;
                boolean z2 = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.openConnections(addressState);
            }
        }, 0L, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:9:0x0029, B:14:0x0032, B:17:0x0039), top: B:38:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.RealConnection callAcquirePooledConnection(boolean r6, okhttp3.Address r7, okhttp3.internal.connection.ConnectionUser r8, java.util.List<okhttp3.Route> r9, boolean r10) {
        /*
            r5 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.k.e(r7, r0)
            java.lang.String r0 = "connectionUser"
            kotlin.jvm.internal.k.e(r8, r0)
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r0 = r5.connections
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "iterator(...)"
            kotlin.jvm.internal.k.d(r0, r1)
        L15:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r0.next()
            okhttp3.internal.connection.RealConnection r1 = (okhttp3.internal.connection.RealConnection) r1
            kotlin.jvm.internal.k.b(r1)
            monitor-enter(r1)
            r2 = 1
            r3 = 0
            if (r10 == 0) goto L32
            boolean r4 = r1.isMultiplexed$okhttp()     // Catch: java.lang.Throwable -> L30
            if (r4 != 0) goto L32
            goto L3d
        L30:
            r6 = move-exception
            goto L6a
        L32:
            boolean r4 = r1.isEligible$okhttp(r7, r9)     // Catch: java.lang.Throwable -> L30
            if (r4 != 0) goto L39
            goto L3d
        L39:
            r8.acquireConnectionNoEvents(r1)     // Catch: java.lang.Throwable -> L30
            r3 = r2
        L3d:
            monitor-exit(r1)
            if (r3 == 0) goto L15
            boolean r3 = r1.isHealthy(r6)
            if (r3 == 0) goto L47
            return r1
        L47:
            monitor-enter(r1)
            boolean r3 = r1.getNoNewExchanges()     // Catch: java.lang.Throwable -> L67
            r1.setNoNewExchanges(r2)     // Catch: java.lang.Throwable -> L67
            java.net.Socket r2 = r8.releaseConnectionNoEvents()     // Catch: java.lang.Throwable -> L67
            monitor-exit(r1)
            if (r2 == 0) goto L5f
            okhttp3.internal._UtilJvmKt.closeQuietly(r2)
            okhttp3.internal.connection.ConnectionListener r2 = r5.connectionListener
            r2.connectionClosed(r1)
            goto L15
        L5f:
            if (r3 != 0) goto L15
            okhttp3.internal.connection.ConnectionListener r2 = r5.connectionListener
            r2.noNewExchanges(r1)
            goto L15
        L67:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        L6a:
            monitor-exit(r1)
            throw r6
        L6c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.callAcquirePooledConnection(boolean, okhttp3.Address, okhttp3.internal.connection.ConnectionUser, java.util.List, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final long closeConnections(long j) {
        int i2;
        Map<Address, AddressState> map = this.addressStates;
        Iterator<AddressState> it = map.values().iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            it.next().setConcurrentCallCapacity(0);
        }
        Iterator<RealConnection> it2 = this.connections.iterator();
        k.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            RealConnection next = it2.next();
            AddressState addressState = map.get(next.getRoute().address());
            if (addressState != null) {
                synchronized (next) {
                    addressState.setConcurrentCallCapacity(addressState.getConcurrentCallCapacity() + next.getAllocationLimit$okhttp());
                }
            }
        }
        long j3 = (j - this.keepAliveDurationNs) + 1;
        Iterator<RealConnection> it3 = this.connections.iterator();
        k.d(it3, "iterator(...)");
        RealConnection realConnection = null;
        RealConnection realConnection2 = null;
        RealConnection realConnection3 = null;
        long j8 = Long.MAX_VALUE;
        int i8 = 0;
        while (it3.hasNext()) {
            RealConnection next2 = it3.next();
            k.b(next2);
            synchronized (next2) {
                if (pruneAndGetAllocationCount(next2, j) > 0) {
                    i8++;
                } else {
                    long idleAtNs = next2.getIdleAtNs();
                    if (idleAtNs < j3) {
                        realConnection2 = next2;
                        j3 = idleAtNs;
                    }
                    if (isEvictable(map, next2)) {
                        i2++;
                        if (idleAtNs < j8) {
                            realConnection3 = next2;
                            j8 = idleAtNs;
                        }
                    }
                }
            }
        }
        if (realConnection2 != null) {
            realConnection = realConnection2;
        } else if (i2 > this.maxIdleConnections) {
            j3 = j8;
            realConnection = realConnection3;
        } else {
            j3 = -1;
        }
        if (realConnection == null) {
            if (realConnection3 != null) {
                return (j8 + this.keepAliveDurationNs) - j;
            }
            if (i8 > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() != j3) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            AddressState addressState2 = map.get(realConnection.getRoute().address());
            if (addressState2 != null) {
                scheduleOpener(addressState2);
            }
            _UtilJvmKt.closeQuietly(realConnection.socket());
            this.connectionListener.connectionClosed(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        k.e(connection, "connection");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            scheduleCloser();
            return false;
        }
        connection.setNoNewExchanges(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        scheduleOpener(connection.getRoute().address());
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        k.d(it, "iterator(...)");
        while (it.hasNext()) {
            RealConnection next = it.next();
            k.b(next);
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
                this.connectionListener.connectionClosed(next);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        Iterator<AddressState> it2 = this.addressStates.values().iterator();
        while (it2.hasNext()) {
            scheduleOpener(it2.next());
        }
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final long getKeepAliveDurationNs$okhttp() {
        return this.keepAliveDurationNs;
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i2 = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection realConnection : concurrentLinkedQueue) {
            k.b(realConnection);
            synchronized (realConnection) {
                zIsEmpty = realConnection.getCalls().isEmpty();
            }
            if (zIsEmpty && (i2 = i2 + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    public final void put(RealConnection connection) {
        k.e(connection, "connection");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            scheduleCloser();
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
    }

    public final void scheduleCloser() {
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final void setPolicy(Address address, AddressPolicy policy) {
        Map<Address, AddressState> map;
        AddressPolicy policy2;
        k.e(address, "address");
        k.e(policy, "policy");
        AddressState addressState = new AddressState(address, this.taskRunner.newQueue(), policy);
        loop0: while (true) {
            map = this.addressStates;
            Map<?, ?> mapJ0 = x.j0(map, new i(address, addressState));
            AtomicReferenceFieldUpdater<RealConnectionPool, Map<?, ?>> atomicReferenceFieldUpdater = addressStatesUpdater;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, map, mapJ0)) {
                if (atomicReferenceFieldUpdater.get(this) != map) {
                    break;
                }
            }
        }
        AddressState addressState2 = map.get(address);
        int i2 = policy.minimumConcurrentCalls - ((addressState2 == null || (policy2 = addressState2.getPolicy()) == null) ? 0 : policy2.minimumConcurrentCalls);
        if (i2 > 0) {
            scheduleOpener(addressState);
        } else if (i2 < 0) {
            scheduleCloser();
        }
    }

    public final void scheduleOpener(Address address) {
        k.e(address, "address");
        AddressState addressState = this.addressStates.get(address);
        if (addressState != null) {
            scheduleOpener(addressState);
        }
    }
}
