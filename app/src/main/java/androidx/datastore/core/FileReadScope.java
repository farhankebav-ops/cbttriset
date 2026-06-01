package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class FileReadScope<T> implements ReadScope<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final File file;
    private final Serializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.FileReadScope$readData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", l = {169, 178}, m = "readData$suspendImpl")
    public static final class AnonymousClass1<T> extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileReadScope<T> fileReadScope, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = fileReadScope;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileReadScope.readData$suspendImpl(this.this$0, this);
        }
    }

    public FileReadScope(File file, Serializer<T> serializer) {
        k.e(file, "file");
        k.e(serializer, "serializer");
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r7, v5.c<? super T> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L30
            goto L9b
        L30:
            r8 = move-exception
            goto La3
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L47
            goto L69
        L47:
            r8 = move-exception
            goto L74
        L49:
            r2.q.z0(r8)
            r7.checkNotClosed()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7a
            java.io.File r2 = r7.file     // Catch: java.io.FileNotFoundException -> L7a
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7a
            androidx.datastore.core.Serializer<T> r2 = r7.serializer     // Catch: java.lang.Throwable -> L6f
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6f
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L6f
            r0.label = r4     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch: java.lang.Throwable -> L6f
            if (r2 != r1) goto L65
            goto L97
        L65:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L69:
            r2.q.I(r7, r5)     // Catch: java.io.FileNotFoundException -> L6d
            return r8
        L6d:
            r7 = r2
            goto L7a
        L6f:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L74:
            throw r8     // Catch: java.lang.Throwable -> L75
        L75:
            r4 = move-exception
            r2.q.I(r7, r8)     // Catch: java.io.FileNotFoundException -> L6d
            throw r4     // Catch: java.io.FileNotFoundException -> L6d
        L7a:
            java.io.File r8 = r7.file
            boolean r8 = r8.exists()
            if (r8 == 0) goto La9
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.file
            r8.<init>(r2)
            androidx.datastore.core.Serializer<T> r7 = r7.serializer     // Catch: java.lang.Throwable -> L9f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L9f
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L9f
            r0.label = r3     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch: java.lang.Throwable -> L9f
            if (r7 != r1) goto L98
        L97:
            return r1
        L98:
            r6 = r8
            r8 = r7
            r7 = r6
        L9b:
            r2.q.I(r7, r5)
            return r8
        L9f:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La3:
            throw r8     // Catch: java.lang.Throwable -> La4
        La4:
            r0 = move-exception
            r2.q.I(r7, r8)
            throw r0
        La9:
            androidx.datastore.core.Serializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, v5.c):java.lang.Object");
    }

    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final File getFile() {
        return this.file;
    }

    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(v5.c<? super T> cVar) {
        return readData$suspendImpl(this, cVar);
    }
}
