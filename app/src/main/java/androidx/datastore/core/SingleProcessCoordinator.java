package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.k;
import t6.e;
import x5.c;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleProcessCoordinator implements InterProcessCoordinator {
    private final String filePath;
    private final z6.a mutex;
    private final e updateNotifications;
    private final AtomicInt version;

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 41}, m = "lock")
    public static final class AnonymousClass1<T> extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {50}, m = "tryLock")
    public static final class C03511<T> extends c {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03511(v5.c<? super C03511> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.tryLock(null, this);
        }
    }

    public SingleProcessCoordinator(String filePath) {
        k.e(filePath, "filePath");
        this.filePath = filePath;
        this.mutex = d.a();
        this.version = new AtomicInt(0);
        this.updateNotifications = new a4.a(new SingleProcessCoordinator$updateNotifications$1(null));
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public e getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(v5.c<? super Integer> cVar) {
        return new Integer(this.version.get());
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(v5.c<? super Integer> cVar) {
        return new Integer(this.version.incrementAndGet());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object lock(e6.l r8, v5.c<? super T> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessCoordinator.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$lock$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.L$0
            z6.a r8 = (z6.a) r8
            r2.q.z0(r9)     // Catch: java.lang.Throwable -> L2f
            goto L6b
        L2f:
            r9 = move-exception
            goto L75
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.L$1
            z6.a r8 = (z6.a) r8
            java.lang.Object r2 = r0.L$0
            e6.l r2 = (e6.l) r2
            r2.q.z0(r9)
            r9 = r8
            r8 = r2
            goto L5b
        L47:
            r2.q.z0(r9)
            z6.a r9 = r7.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            z6.c r9 = (z6.c) r9
            java.lang.Object r2 = r9.d(r0)
            if (r2 != r1) goto L5b
            goto L67
        L5b:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L71
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L71
            r0.label = r3     // Catch: java.lang.Throwable -> L71
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L71
            if (r8 != r1) goto L68
        L67:
            return r1
        L68:
            r6 = r9
            r9 = r8
            r8 = r6
        L6b:
            z6.c r8 = (z6.c) r8
            r8.f(r5)
            return r9
        L71:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L75:
            z6.c r8 = (z6.c) r8
            r8.f(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.lock(e6.l, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object tryLock(e6.p r7, v5.c<? super T> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessCoordinator.C03511
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator.C03511) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$tryLock$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            boolean r7 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            z6.a r0 = (z6.a) r0
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L2e
            goto L57
        L2e:
            r8 = move-exception
            goto L63
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            r2.q.z0(r8)
            z6.a r8 = r6.mutex
            z6.c r8 = (z6.c) r8
            boolean r2 = r8.e(r4)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L5f
            r0.Z$0 = r2     // Catch: java.lang.Throwable -> L5f
            r0.label = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L5f
            if (r7 != r1) goto L54
            return r1
        L54:
            r0 = r8
            r8 = r7
            r7 = r2
        L57:
            if (r7 == 0) goto L5e
            z6.c r0 = (z6.c) r0
            r0.f(r4)
        L5e:
            return r8
        L5f:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L63:
            if (r7 == 0) goto L6a
            z6.c r0 = (z6.c) r0
            r0.f(r4)
        L6a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.tryLock(e6.p, v5.c):java.lang.Object");
    }
}
