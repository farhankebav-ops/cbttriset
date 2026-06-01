package androidx.work.impl.constraints.trackers;

import a3.c;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        k.e(context, "context");
        k.e(taskExecutor, "taskExecutor");
        this.taskExecutor = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
        this.lock = new Object();
        this.listeners = new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List listenersList, ConstraintTracker this$0) {
        k.e(listenersList, "$listenersList");
        k.e(this$0, "this$0");
        Iterator<T> it = listenersList.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(this$0.currentState);
        }
    }

    public final void addListener(ConstraintListener<T> listener) {
        k.e(listener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.add(listener)) {
                    if (this.listeners.size() == 1) {
                        this.currentState = getInitialState();
                        Logger.get().debug(ConstraintTrackerKt.TAG, getClass().getSimpleName() + ": initial state = " + this.currentState);
                        startTracking();
                    }
                    listener.onConstraintChanged(this.currentState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public abstract T getInitialState();

    public final T getState() {
        T t3 = this.currentState;
        return t3 == null ? getInitialState() : t3;
    }

    public final void removeListener(ConstraintListener<T> listener) {
        k.e(listener, "listener");
        synchronized (this.lock) {
            if (this.listeners.remove(listener) && this.listeners.isEmpty()) {
                stopTracking();
            }
        }
    }

    public final void setState(T t3) {
        synchronized (this.lock) {
            T t7 = this.currentState;
            if (t7 == null || !t7.equals(t3)) {
                this.currentState = t3;
                this.taskExecutor.getMainThreadExecutor().execute(new c(15, l.n1(this.listeners), this));
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
