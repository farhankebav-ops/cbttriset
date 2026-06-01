package androidx.datastore.core;

import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t3, l block) throws Throwable {
        k.e(t3, "<this>");
        k.e(block, "block");
        try {
            R r7 = (R) block.invoke(t3);
            try {
                t3.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                return r7;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                t3.close();
            } catch (Throwable th3) {
                a.a.h(th2, th3);
            }
            throw th2;
        }
    }
}
