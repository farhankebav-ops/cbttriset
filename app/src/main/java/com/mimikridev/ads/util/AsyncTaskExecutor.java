package com.mimikridev.ads.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AsyncTaskExecutor<Params, Progress, Result> {
    ExecutorService executor = Executors.newSingleThreadExecutor(new b());
    private Handler handler;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$execute$3(Object obj) {
        getHandler().post(new a(this, doInBackground(obj), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$4(Object obj) {
        onPreExecute();
        this.executor.execute(new a(this, obj, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public abstract Result doInBackground(Params params);

    public void execute() {
        execute(null);
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public Handler getHandler() {
        if (this.handler == null) {
            synchronized (AsyncTaskExecutor.class) {
                this.handler = new Handler(Looper.getMainLooper());
            }
        }
        return this.handler;
    }

    public boolean isCancelled() {
        ExecutorService executorService = this.executor;
        return executorService == null || executorService.isTerminated() || this.executor.isShutdown();
    }

    /* JADX INFO: renamed from: onPostExecute, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$execute$2(Result result);

    public void publishProgress(@NonNull Progress progress) {
        getHandler().post(new a(this, progress, 3));
    }

    public void shutDown() {
        ExecutorService executorService = this.executor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    public void execute(Params params) {
        getHandler().post(new a(this, params, 0));
    }

    public void onPreExecute() {
    }

    /* JADX INFO: renamed from: onProgressUpdate, reason: merged with bridge method [inline-methods] */
    public void lambda$publishProgress$1(@NonNull Progress progress) {
    }
}
