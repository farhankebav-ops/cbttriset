package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealCall;
import r5.l;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        k.d(it, "iterator(...)");
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (k.a(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        k.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (k.a(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t3) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t3)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean promoteAndExecute() {
        int i2;
        boolean z2;
        _UtilJvmKt.assertLockNotHeld(this);
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                k.d(it, "iterator(...)");
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        next.getCallsPerHost().incrementAndGet();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                i2 = 0;
                z2 = runningCallsCount() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executorService().isShutdown()) {
            int size = arrayList.size();
            while (i2 < size) {
                RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) arrayList.get(i2);
                asyncCall.getCallsPerHost().decrementAndGet();
                synchronized (this) {
                    this.runningAsyncCalls.remove(asyncCall);
                }
                RealCall.AsyncCall.failRejected$okhttp$default(asyncCall, null, 1, null);
                i2++;
            }
            Runnable runnable = this.idleCallback;
            if (runnable != null) {
                runnable.run();
                return z2;
            }
        } else {
            int size2 = arrayList.size();
            while (i2 < size2) {
                ((RealCall.AsyncCall) arrayList.get(i2)).executeOn(executorService());
                i2++;
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m3499deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        try {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            k.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().getCall().cancel();
            }
            Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
            k.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                it2.next().getCall().cancel();
            }
            Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
            k.d(it3, "iterator(...)");
            while (it3.hasNext()) {
                it3.next().cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall call) {
        RealCall.AsyncCall asyncCallFindExistingCallWithHost;
        k.e(call, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.getCall().getForWebSocket() && (asyncCallFindExistingCallWithHost = findExistingCallWithHost(call.getHost())) != null) {
                call.reuseCallsPerHostFrom(asyncCallFindExistingCallWithHost);
            }
        }
        promoteAndExecute();
    }

    public final synchronized boolean executed$okhttp(RealCall call) {
        k.e(call, "call");
        return this.runningSyncCalls.add(call);
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            k.b(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(RealCall.AsyncCall call) {
        k.e(call, "call");
        call.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> listUnmodifiableList;
        try {
            ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
            ArrayList arrayList = new ArrayList(n.L0(arrayDeque, 10));
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            k.d(listUnmodifiableList, "unmodifiableList(...)");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> listUnmodifiableList;
        try {
            ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
            ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
            ArrayList arrayList = new ArrayList(n.L0(arrayDeque2, 10));
            Iterator<T> it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            listUnmodifiableList = Collections.unmodifiableList(l.f1(arrayList, arrayDeque));
            k.d(listUnmodifiableList, "unmodifiableList(...)");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.g(i2, "max < 1: ").toString());
        }
        synchronized (this) {
            this.maxRequests = i2;
        }
        promoteAndExecute();
    }

    public final void setMaxRequestsPerHost(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.g(i2, "max < 1: ").toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i2;
        }
        promoteAndExecute();
    }

    public final void finished$okhttp(RealCall call) {
        k.e(call, "call");
        finished(this.runningSyncCalls, call);
    }

    public Dispatcher(ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }
}
