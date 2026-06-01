package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean z2, Callable<T> computeFunction, final String[] tableNames) {
        k.e(database, "database");
        k.e(container, "container");
        k.e(computeFunction, "computeFunction");
        k.e(tableNames, "tableNames");
        this.database = database;
        this.container = container;
        this.inTransaction = z2;
        this.computeFunction = computeFunction;
        this.observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables) {
                k.e(tables, "tables");
                ArchTaskExecutor.getInstance().executeOnMainThread(this.getInvalidationRunnable());
            }
        };
        this.invalid = new AtomicBoolean(true);
        final int i2 = 0;
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable(this) { // from class: androidx.room.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RoomTrackingLiveData f4078b;

            {
                this.f4078b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        RoomTrackingLiveData.refreshRunnable$lambda$0(this.f4078b);
                        break;
                    default:
                        RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f4078b);
                        break;
                }
            }
        };
        final int i8 = 1;
        this.invalidationRunnable = new Runnable(this) { // from class: androidx.room.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RoomTrackingLiveData f4078b;

            {
                this.f4078b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i8) {
                    case 0:
                        RoomTrackingLiveData.refreshRunnable$lambda$0(this.f4078b);
                        break;
                    default:
                        RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f4078b);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData this$0) {
        k.e(this$0, "this$0");
        boolean zHasActiveObservers = this$0.hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            this$0.getQueryExecutor().execute(this$0.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(RoomTrackingLiveData this$0) {
        boolean z2;
        k.e(this$0, "this$0");
        if (this$0.registeredObserver.compareAndSet(false, true)) {
            this$0.database.getInvalidationTracker().addWeakObserver(this$0.observer);
        }
        do {
            if (this$0.computing.compareAndSet(false, true)) {
                T tCall = null;
                z2 = false;
                while (this$0.invalid.compareAndSet(true, false)) {
                    try {
                        try {
                            tCall = this$0.computeFunction.call();
                            z2 = true;
                        } catch (Exception e) {
                            throw new RuntimeException("Exception while computing database live data.", e);
                        }
                    } finally {
                        this$0.computing.set(false);
                    }
                }
                if (z2) {
                    this$0.postValue(tCall);
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        } while (this$0.invalid.get());
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final Executor getQueryExecutor() {
        return this.inTransaction ? this.database.getTransactionExecutor() : this.database.getQueryExecutor();
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }
}
