package androidx.datastore.core;

import kotlin.jvm.internal.k;
import t6.d1;
import t6.e;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreInMemoryCache<T> {
    private final q0 cachedValue;

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.INSTANCE;
        k.c(unInitialized, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.cachedValue = x0.c(unInitialized);
    }

    public final State<T> getCurrentState() {
        return (State) ((d1) this.cachedValue).getValue();
    }

    public final e getFlow() {
        return this.cachedValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.datastore.core.State<T> tryUpdate(androidx.datastore.core.State<T> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.k.e(r7, r0)
            t6.q0 r0 = r6.cachedValue
        L7:
            r1 = r0
            t6.d1 r1 = (t6.d1) r1
            java.lang.Object r2 = r1.getValue()
            r3 = r2
            androidx.datastore.core.State r3 = (androidx.datastore.core.State) r3
            boolean r4 = r3 instanceof androidx.datastore.core.ReadException
            if (r4 == 0) goto L17
            r4 = 1
            goto L1d
        L17:
            androidx.datastore.core.UnInitialized r4 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r4 = kotlin.jvm.internal.k.a(r3, r4)
        L1d:
            if (r4 == 0) goto L20
            goto L2e
        L20:
            boolean r4 = r3 instanceof androidx.datastore.core.Data
            if (r4 == 0) goto L30
            int r4 = r7.getVersion()
            int r5 = r3.getVersion()
            if (r4 <= r5) goto L34
        L2e:
            r3 = r7
            goto L34
        L30:
            boolean r4 = r3 instanceof androidx.datastore.core.Final
            if (r4 == 0) goto L3b
        L34:
            boolean r1 = r1.g(r2, r3)
            if (r1 == 0) goto L7
            return r3
        L3b:
            e2.s r7 = new e2.s
            r0 = 3
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreInMemoryCache.tryUpdate(androidx.datastore.core.State):androidx.datastore.core.State");
    }

    private static /* synthetic */ void getCachedValue$annotations() {
    }
}
