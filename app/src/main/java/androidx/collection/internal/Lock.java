package androidx.collection.internal;

import e6.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Lock {
    public final <T> T synchronizedImpl(a block) {
        T t3;
        k.e(block, "block");
        synchronized (this) {
            t3 = (T) block.invoke();
        }
        return t3;
    }
}
