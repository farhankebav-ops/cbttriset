package androidx.core.util;

import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(v5.c<? super x> cVar) {
        return new ContinuationRunnable(cVar);
    }
}
