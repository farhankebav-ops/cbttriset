package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import com.vungle.ads.internal.protos.Sdk;
import e6.a;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.t;
import x5.c;
import x5.e;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final t fileSystem;
    private final a onClose;
    private final g0 path;
    private final OkioSerializer<T> serializer;
    private final z6.a transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {113}, m = "readScope")
    public static final class AnonymousClass1<R> extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioStorageConnection<T> okioStorageConnection, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {236, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE}, m = "writeScope")
    public static final class C03531 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03531(OkioStorageConnection<T> okioStorageConnection, v5.c<? super C03531> cVar) {
            super(cVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public OkioStorageConnection(t fileSystem, g0 path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, a onClose) {
        k.e(fileSystem, "fileSystem");
        k.e(path, "path");
        k.e(serializer, "serializer");
        k.e(coordinator, "coordinator");
        k.e(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = d.a();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[Catch: all -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007d, blocks: (B:31:0x007c, B:40:0x008d, B:39:0x008a, B:36:0x0085), top: B:52:0x0020, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [e6.q] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <R> java.lang.Object readScope(e6.q r9, v5.c<? super R> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioStorageConnection.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r9 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            r2.q.z0(r10)     // Catch: java.lang.Throwable -> L32
            goto L6d
        L32:
            r10 = move-exception
            goto L85
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            r2.q.z0(r10)
            r8.checkNotClosed()
            z6.a r10 = r8.transactionMutex
            z6.c r10 = (z6.c) r10
            boolean r10 = r10.e(r4)
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch: java.lang.Throwable -> L8e
            l7.t r5 = r8.fileSystem     // Catch: java.lang.Throwable -> L8e
            l7.g0 r6 = r8.path     // Catch: java.lang.Throwable -> L8e
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r8.serializer     // Catch: java.lang.Throwable -> L8e
            r2.<init>(r5, r6, r7)     // Catch: java.lang.Throwable -> L8e
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L7f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7f
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7f
            r0.Z$0 = r10     // Catch: java.lang.Throwable -> L7f
            r0.label = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r9 = r9.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7f
            if (r9 != r1) goto L68
            return r1
        L68:
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L6d:
            r1.close()     // Catch: java.lang.Throwable -> L71
            goto L72
        L71:
            r4 = move-exception
        L72:
            if (r4 != 0) goto L7c
            if (r9 == 0) goto L7b
            z6.a r9 = r0.transactionMutex
            z6.d.b(r9)
        L7b:
            return r10
        L7c:
            throw r4     // Catch: java.lang.Throwable -> L7d
        L7d:
            r10 = move-exception
            goto L93
        L7f:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L85:
            r1.close()     // Catch: java.lang.Throwable -> L89
            goto L8d
        L89:
            r1 = move-exception
            a.a.h(r10, r1)     // Catch: java.lang.Throwable -> L7d
        L8d:
            throw r10     // Catch: java.lang.Throwable -> L7d
        L8e:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
        L93:
            if (r9 == 0) goto L9a
            z6.a r9 = r0.transactionMutex
            z6.d.b(r9)
        L9a:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(e6.q, v5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1 A[Catch: all -> 0x00d1, IOException -> 0x00d4, TRY_ENTER, TryCatch #9 {IOException -> 0x00d4, all -> 0x00d1, blocks: (B:36:0x00c1, B:38:0x00c9, B:46:0x00e0, B:53:0x00ee, B:52:0x00eb, B:49:0x00e6), top: B:80:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0 A[Catch: all -> 0x00d1, IOException -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00d4, all -> 0x00d1, blocks: (B:36:0x00c1, B:38:0x00c9, B:46:0x00e0, B:53:0x00ee, B:52:0x00eb, B:49:0x00e6), top: B:80:0x0024, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [l7.g0] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, l7.g0] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [l7.g0] */
    /* JADX WARN: Type inference failed for: r0v8, types: [l7.g0] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v18, types: [l7.t] */
    /* JADX WARN: Type inference failed for: r10v21, types: [l7.t] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v7, types: [e6.p] */
    /* JADX WARN: Type inference failed for: r11v12, types: [z6.c] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r1v12, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, java.lang.Object, x5.c] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [l7.t] */
    /* JADX WARN: Type inference failed for: r1v6, types: [l7.t] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, w5.a] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9, types: [z6.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [l7.t] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.datastore.core.okio.OkioStorageConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeScope(e6.p r10, v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(e6.p, v5.c):java.lang.Object");
    }
}
