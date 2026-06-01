package com.ironsource.environment.workerthread;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class WorkerResult<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Canceled<T> extends WorkerResult<T> {
        public Callable<T> callable;

        public Canceled(Callable<T> callable) {
            super(0);
            this.callable = callable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Completed<T> extends WorkerResult<T> {
        public T data;

        public Completed(T t3) {
            super(0);
            this.data = t3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Failed<T> extends WorkerResult<T> {
        public Callable<T> callable;
        public Exception exception;

        public Failed(Callable<T> callable, Exception exc) {
            super(0);
            this.callable = callable;
            this.exception = exc;
        }
    }

    public /* synthetic */ WorkerResult(int i2) {
        this();
    }

    private WorkerResult() {
    }
}
