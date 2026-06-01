package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import j2.q;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class FutureChain<V> implements q {
    CallbackToFutureAdapter.Completer<V> mCompleter;
    private final q mDelegate;

    public FutureChain(q qVar) {
        this.mDelegate = (q) Preconditions.checkNotNull(qVar);
    }

    public static <V> FutureChain<V> from(q qVar) {
        return qVar instanceof FutureChain ? (FutureChain) qVar : new FutureChain<>(qVar);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    @Override // j2.q
    public void addListener(Runnable runnable, Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.mDelegate.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return (V) this.mDelegate.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public boolean set(V v2) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.set(v2);
        }
        return false;
    }

    public boolean setException(Throwable th) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.setException(th);
        }
        return false;
    }

    public final <T> FutureChain<T> transform(Function<? super V, T> function, Executor executor) {
        return (FutureChain) Futures.transform(this, function, executor);
    }

    public final <T> FutureChain<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FutureChain) Futures.transformAsync(this, asyncFunction, executor);
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (V) this.mDelegate.get(j, timeUnit);
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() { // from class: androidx.camera.core.impl.utils.futures.FutureChain.1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public Object attachCompleter(CallbackToFutureAdapter.Completer<V> completer) {
                Preconditions.checkState(FutureChain.this.mCompleter == null, "The result can only set once!");
                FutureChain.this.mCompleter = completer;
                return "FutureChain[" + FutureChain.this + C2300e4.i.e;
            }
        });
    }
}
