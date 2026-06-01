package com.google.firebase.crashlytics.internal.concurrency;

import androidx.camera.core.processing.h;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class CrashlyticsTasks {
    private static final Executor DIRECT = new androidx.arch.core.executor.a(2);

    private CrashlyticsTasks() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$race$0(TaskCompletionSource taskCompletionSource, AtomicBoolean atomicBoolean, CancellationTokenSource cancellationTokenSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else if (task.getException() != null) {
            taskCompletionSource.trySetException(task.getException());
        } else if (atomicBoolean.getAndSet(true)) {
            cancellationTokenSource.cancel();
        }
        return Tasks.forResult(null);
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        h hVar = new h(taskCompletionSource, new AtomicBoolean(false), cancellationTokenSource, 4);
        Executor executor = DIRECT;
        task.continueWithTask(executor, hVar);
        task2.continueWithTask(executor, hVar);
        return taskCompletionSource.getTask();
    }
}
