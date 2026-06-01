package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {

    /* JADX INFO: renamed from: androidx.datastore.core.FileWriteScope$writeData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.FileWriteScope", f = "FileStorage.kt", l = {201}, m = "writeData")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileWriteScope<T> fileWriteScope, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = fileWriteScope;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        k.e(file, "file");
        k.e(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeData(T r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.FileWriteScope.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L2f
            goto L60
        L2f:
            r6 = move-exception
            goto L70
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            r2.q.z0(r7)
            r5.checkNotClosed()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.getFile()
            r7.<init>(r2)
            androidx.datastore.core.Serializer r2 = r5.getSerializer()     // Catch: java.lang.Throwable -> L6e
            androidx.datastore.core.UncloseableOutputStream r4 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L6e
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L6e
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L6e
            r0.label = r3     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r6 = r2.writeTo(r6, r4, r0)     // Catch: java.lang.Throwable -> L6e
            if (r6 != r1) goto L5e
            return r1
        L5e:
            r6 = r7
            r0 = r6
        L60:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L2f
            r6.sync()     // Catch: java.lang.Throwable -> L2f
            r6 = 0
            r2.q.I(r0, r6)
            q5.x r6 = q5.x.f13520a
            return r6
        L6e:
            r6 = move-exception
            r0 = r7
        L70:
            throw r6     // Catch: java.lang.Throwable -> L71
        L71:
            r7 = move-exception
            r2.q.I(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, v5.c):java.lang.Object");
    }
}
