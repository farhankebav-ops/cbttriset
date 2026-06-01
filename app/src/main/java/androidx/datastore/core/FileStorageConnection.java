package androidx.datastore.core;

import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final e6.a onClose;
    private final Serializer<T> serializer;
    private final z6.a transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {101}, m = "readScope")
    public static final class AnonymousClass1<R> extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileStorageConnection<T> fileStorageConnection, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "writeScope")
    public static final class C03491 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03491(FileStorageConnection<T> fileStorageConnection, v5.c<? super C03491> cVar) {
            super(cVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, e6.a onClose) {
        k.e(file, "file");
        k.e(serializer, "serializer");
        k.e(coordinator, "coordinator");
        k.e(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = d.a();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x007b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x007b, blocks: (B:31:0x007a, B:40:0x008b, B:39:0x0088, B:36:0x0083), top: B:50:0x0020, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [e6.q] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <R> java.lang.Object readScope(e6.q r8, v5.c<? super R> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.FileStorageConnection.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r8 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            r2.q.z0(r9)     // Catch: java.lang.Throwable -> L32
            goto L6b
        L32:
            r9 = move-exception
            goto L83
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            r2.q.z0(r9)
            r7.checkNotClosed()
            z6.a r9 = r7.transactionMutex
            z6.c r9 = (z6.c) r9
            boolean r9 = r9.e(r4)
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch: java.lang.Throwable -> L8c
            java.io.File r5 = r7.file     // Catch: java.lang.Throwable -> L8c
            androidx.datastore.core.Serializer<T> r6 = r7.serializer     // Catch: java.lang.Throwable -> L8c
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8c
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7d
            if (r8 != r1) goto L66
            return r1
        L66:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L6b:
            r1.close()     // Catch: java.lang.Throwable -> L6f
            goto L70
        L6f:
            r4 = move-exception
        L70:
            if (r4 != 0) goto L7a
            if (r8 == 0) goto L79
            z6.a r8 = r0.transactionMutex
            z6.d.b(r8)
        L79:
            return r9
        L7a:
            throw r4     // Catch: java.lang.Throwable -> L7b
        L7b:
            r9 = move-exception
            goto L91
        L7d:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L83:
            r1.close()     // Catch: java.lang.Throwable -> L87
            goto L8b
        L87:
            r1 = move-exception
            a.a.h(r9, r1)     // Catch: java.lang.Throwable -> L7b
        L8b:
            throw r9     // Catch: java.lang.Throwable -> L7b
        L8c:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L91:
            if (r8 == 0) goto L98
            z6.a r8 = r0.transactionMutex
            z6.d.b(r8)
        L98:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(e6.q, v5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb A[Catch: all -> 0x00eb, IOException -> 0x00ed, TRY_ENTER, TryCatch #4 {all -> 0x00eb, blocks: (B:34:0x00bb, B:36:0x00c1, B:39:0x00ca, B:40:0x00ea, B:47:0x00f8, B:56:0x0107, B:58:0x010d, B:59:0x0110, B:54:0x0105, B:53:0x0102, B:24:0x007c, B:25:0x0098), top: B:70:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[Catch: all -> 0x00eb, IOException -> 0x00ed, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00eb, blocks: (B:34:0x00bb, B:36:0x00c1, B:39:0x00ca, B:40:0x00ea, B:47:0x00f8, B:56:0x0107, B:58:0x010d, B:59:0x0110, B:54:0x0105, B:53:0x0102, B:24:0x007c, B:25:0x0098), top: B:70:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeScope(e6.p r11, v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(e6.p, v5.c):java.lang.Object");
    }
}
