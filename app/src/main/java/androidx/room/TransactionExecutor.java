package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(Executor executor) {
        k.e(executor, "executor");
        this.executor = executor;
        this.tasks = new ArrayDeque<>();
        this.syncLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$1$lambda$0(Runnable command, TransactionExecutor this$0) {
        k.e(command, "$command");
        k.e(this$0, "this$0");
        try {
            command.run();
        } finally {
            this$0.scheduleNext();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        k.e(command, "command");
        synchronized (this.syncLock) {
            this.tasks.offer(new a3.c(13, command, this));
            if (this.active == null) {
                scheduleNext();
            }
        }
    }

    public final void scheduleNext() {
        synchronized (this.syncLock) {
            Runnable runnablePoll = this.tasks.poll();
            Runnable runnable = runnablePoll;
            this.active = runnable;
            if (runnablePoll != null) {
                this.executor.execute(runnable);
            }
        }
    }
}
