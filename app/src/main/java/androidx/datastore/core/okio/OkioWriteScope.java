package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.t;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioWriteScope$writeData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", l = {Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE}, m = "writeData")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioWriteScope<T> okioWriteScope, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = okioWriteScope;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(t fileSystem, g0 path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        k.e(fileSystem, "fileSystem");
        k.e(path, "path");
        k.e(serializer, "serializer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: all -> 0x00a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:44:0x0096, B:52:0x00a4, B:19:0x0052), top: B:63:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4 A[Catch: all -> 0x00a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:44:0x0096, B:52:0x00a4, B:19:0x0052), top: B:63:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, l7.q] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [l7.q] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeData(T r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioWriteScope.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = (androidx.datastore.core.okio.OkioWriteScope.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = new androidx.datastore.core.okio.OkioWriteScope$writeData$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r9 = r0.L$2
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r1 = r0.L$1
            l7.q r1 = (l7.q) r1
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2.q.z0(r10)     // Catch: java.lang.Throwable -> L36
            goto L70
        L36:
            r10 = move-exception
            goto L83
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            r2.q.z0(r10)
            r8.checkClose()
            l7.t r10 = r8.getFileSystem()
            l7.g0 r2 = r8.getPath()
            l7.q r10 = r10.openReadWrite(r2)
            l7.o r2 = l7.q.j(r10)     // Catch: java.lang.Throwable -> La2
            l7.i0 r2 = l7.b.b(r2)     // Catch: java.lang.Throwable -> La2
            androidx.datastore.core.okio.OkioSerializer r6 = r8.getSerializer()     // Catch: java.lang.Throwable -> L7f
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L7f
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L7f
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7f
            r0.label = r4     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r9 = r6.writeTo(r9, r2, r0)     // Catch: java.lang.Throwable -> L7f
            if (r9 != r1) goto L6d
            return r1
        L6d:
            r0 = r10
            r1 = r0
            r9 = r2
        L70:
            r1.flush()     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L7b
            r9.close()     // Catch: java.lang.Throwable -> L79
            goto L7b
        L79:
            r9 = move-exception
            goto L7c
        L7b:
            r9 = r5
        L7c:
            r10 = r0
            r0 = r3
            goto L94
        L7f:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r2
        L83:
            if (r9 == 0) goto L91
            r9.close()     // Catch: java.lang.Throwable -> L89
            goto L91
        L89:
            r9 = move-exception
            a.a.h(r10, r9)     // Catch: java.lang.Throwable -> L8e
            goto L91
        L8e:
            r9 = move-exception
            r10 = r0
            goto La5
        L91:
            r9 = r10
            r10 = r0
            r0 = r5
        L94:
            if (r9 != 0) goto La4
            kotlin.jvm.internal.k.b(r0)     // Catch: java.lang.Throwable -> La2
            if (r10 == 0) goto La0
            r10.close()     // Catch: java.lang.Throwable -> L9f
            goto La0
        L9f:
            r5 = move-exception
        La0:
            r9 = r3
            goto Lb2
        La2:
            r9 = move-exception
            goto La5
        La4:
            throw r9     // Catch: java.lang.Throwable -> La2
        La5:
            if (r10 == 0) goto Laf
            r10.close()     // Catch: java.lang.Throwable -> Lab
            goto Laf
        Lab:
            r10 = move-exception
            a.a.h(r9, r10)
        Laf:
            r7 = r5
            r5 = r9
            r9 = r7
        Lb2:
            if (r5 != 0) goto Lb8
            kotlin.jvm.internal.k.b(r9)
            return r3
        Lb8:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.writeData(java.lang.Object, v5.c):java.lang.Object");
    }
}
