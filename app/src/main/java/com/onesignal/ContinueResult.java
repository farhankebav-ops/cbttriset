package com.onesignal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ContinueResult<R> {
    private final R data;
    private final boolean isSuccess;
    private final Throwable throwable;

    public ContinueResult(boolean z2, R r7, Throwable th) {
        this.isSuccess = z2;
        this.data = r7;
        this.throwable = th;
    }

    public final R getData() {
        return this.data;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
