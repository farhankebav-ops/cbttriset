package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.t;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final t fileSystem;
    private final g0 path;
    private final OkioSerializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioReadScope$readData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {180, 187}, m = "readData$suspendImpl")
    public static final class AnonymousClass1<T> extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioReadScope<T> okioReadScope, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = okioReadScope;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkioReadScope.readData$suspendImpl(this.this$0, this);
        }
    }

    public OkioReadScope(t fileSystem, g0 path, OkioSerializer<T> serializer) {
        k.e(fileSystem, "fileSystem");
        k.e(path, "path");
        k.e(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e A[Catch: FileNotFoundException -> 0x0088, TryCatch #8 {FileNotFoundException -> 0x0088, blocks: (B:46:0x008e, B:47:0x0092, B:42:0x0084, B:39:0x007f), top: B:80:0x007f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092 A[Catch: FileNotFoundException -> 0x0088, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x0088, blocks: (B:46:0x008e, B:47:0x0092, B:42:0x0084, B:39:0x007f), top: B:80:0x007f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r7, v5.c<? super T> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, v5.c):java.lang.Object");
    }

    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final t getFileSystem() {
        return this.fileSystem;
    }

    public final g0 getPath() {
        return this.path;
    }

    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(v5.c<? super T> cVar) {
        return readData$suspendImpl(this, cVar);
    }
}
