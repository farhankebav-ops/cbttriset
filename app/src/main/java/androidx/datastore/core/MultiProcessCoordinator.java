package androidx.datastore.core;

import e6.p;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.k;
import n7.b;
import okhttp3.internal.ws.RealWebSocket;
import q5.f;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import t6.e;
import v5.h;
import x5.c;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final h context;
    private final File file;
    private final z6.a inMemoryMutex;
    private final f lazySharedCounter;
    private final f lockFile$delegate;
    private final e updateNotifications;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0078 -> B:27:0x007b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r13, v5.c<? super java.nio.channels.FileLock> r14) throws java.lang.Throwable {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L36
                if (r2 != r3) goto L2e
                long r4 = r0.J$0
                java.lang.Object r13 = r0.L$0
                java.io.FileOutputStream r13 = (java.io.FileOutputStream) r13
                r2.q.z0(r14)
                r14 = r0
                goto L7b
            L2e:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L36:
                r2.q.z0(r14)
                long r4 = androidx.datastore.core.MultiProcessCoordinator.access$getINITIAL_WAIT_MILLIS$cp()
                r14 = r0
            L3e:
                long r6 = androidx.datastore.core.MultiProcessCoordinator.access$getMAX_WAIT_MILLIS$cp()
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            */
            //  java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
            /*
                if (r0 > 0) goto L80
                java.nio.channels.FileChannel r6 = r13.getChannel()     // Catch: java.io.IOException -> L5c
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                r7 = 0
                java.nio.channels.FileLock r0 = r6.lock(r7, r9, r11)     // Catch: java.io.IOException -> L5c
                kotlin.jvm.internal.k.d(r0, r2)     // Catch: java.io.IOException -> L5c
                return r0
            L5c:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L7f
                java.lang.String r6 = androidx.datastore.core.MultiProcessCoordinator.access$getDEADLOCK_ERROR_MESSAGE$cp()
                r7 = 0
                boolean r2 = n6.m.q0(r2, r6, r7)
                if (r2 != r3) goto L7f
                r14.L$0 = r13
                r14.J$0 = r4
                r14.label = r3
                java.lang.Object r0 = q6.c0.k(r4, r14)
                if (r0 != r1) goto L7b
                return r1
            L7b:
                r0 = 2
                long r6 = (long) r0
                long r4 = r4 * r6
                goto L3e
            L7f:
                throw r0
            L80:
                java.nio.channels.FileChannel r6 = r13.getChannel()
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                r7 = 0
                java.nio.channels.FileLock r13 = r6.lock(r7, r9, r11)
                kotlin.jvm.internal.k.d(r13, r2)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, v5.c):java.lang.Object");
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {211, 47, 48}, m = "lock")
    public static final class AnonymousClass1<T> extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {62, 87}, m = "tryLock")
    public static final class C03501<T> extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03501(v5.c<? super C03501> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.tryLock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", l = {163}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $block;
        int label;
        final /* synthetic */ MultiProcessCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, MultiProcessCoordinator multiProcessCoordinator, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$block = pVar;
            this.this$0 = multiProcessCoordinator;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$block, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            p pVar = this.$block;
            SharedCounter sharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object objInvoke = pVar.invoke(sharedCounter, this);
            return objInvoke == aVar ? aVar : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this.this$0.getSharedCounter(), this);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super T> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public MultiProcessCoordinator(h context, File file) {
        k.e(context, "context");
        k.e(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = d.a();
        this.lockFile$delegate = b.C(new MultiProcessCoordinator$lockFile$2(this));
        this.lazySharedCounter = b.C(new MultiProcessCoordinator$lazySharedCounter$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) throws IOException {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            throw new IOException("Unable to create parent directories of " + file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return (SharedCounter) this.lazySharedCounter.getValue();
    }

    private final <T> Object withLazyCounter(p pVar, v5.c<? super T> cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return pVar.invoke(getSharedCounter(), cVar);
        }
        return c0.H(new AnonymousClass2(pVar, this, null), this.context, cVar);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public e getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(v5.c<? super Integer> cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().getValue());
        }
        return c0.H(new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), this.context, cVar);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(v5.c<? super Integer> cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().incrementAndGetValue());
        }
        return c0.H(new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), this.context, cVar);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: all -> 0x00bf, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bf, blocks: (B:42:0x00bb, B:56:0x00db, B:57:0x00de), top: B:78:0x0022, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #7 {all -> 0x00bf, blocks: (B:42:0x00bb, B:56:0x00db, B:57:0x00de), top: B:78:0x0022, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object, w5.a] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object lock(e6.l r9, v5.c<? super T> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.lock(e6.l, v5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7 A[Catch: all -> 0x00eb, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00eb, blocks: (B:60:0x00e7, B:72:0x0104, B:73:0x0107), top: B:91:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0104 A[Catch: all -> 0x00eb, TRY_ENTER, TryCatch #7 {all -> 0x00eb, blocks: (B:60:0x00e7, B:72:0x0104, B:73:0x0107), top: B:91:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0113  */
    /* JADX WARN: Type inference failed for: r2v0, types: [e6.p] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int, java.io.Closeable] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object tryLock(e6.p r19, v5.c<? super T> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.tryLock(e6.p, v5.c):java.lang.Object");
    }
}
