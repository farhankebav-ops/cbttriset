package com.unity3d.ads.core.data.datasource;

import androidx.constraintlayout.widget.ConstraintLayout;
import c6.k;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.GetFileExtensionFromUrl;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.io.File;
import java.io.FileOutputStream;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidRemoteCacheDataSource implements CacheDataSource {
    private final CreateFile createFile;
    private final GetFileExtensionFromUrl getFileExtensionFromUrl;
    private final HttpClient httpClient;
    private final w ioDispatcher;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource", f = "AndroidRemoteCacheDataSource.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "getFile")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidRemoteCacheDataSource.this.getFile(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$saveToCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$saveToCache$2", f = "AndroidRemoteCacheDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Object $body;
        final /* synthetic */ File $dest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, File file, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$body = obj;
            this.$dest = file;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$body, this.$dest, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            Object obj2 = this.$body;
            if (obj2 instanceof File) {
                k.b0((File) obj2, this.$dest);
                return Boolean.valueOf(((File) this.$body).delete());
            }
            boolean z2 = obj2 instanceof byte[];
            x xVar = x.f13520a;
            if (!z2) {
                if (obj2 instanceof String) {
                    this.$dest.createNewFile();
                    k.e0(this.$dest, (String) this.$body, n6.a.f13073a);
                    return xVar;
                }
                StringBuilder sb = new StringBuilder("Unknown body type ");
                Object obj3 = this.$body;
                sb.append(obj3 != null ? obj3.getClass().getSimpleName() : null);
                throw new IllegalStateException(sb.toString().toString());
            }
            this.$dest.createNewFile();
            File file = this.$dest;
            byte[] array = (byte[]) this.$body;
            kotlin.jvm.internal.k.e(file, "<this>");
            kotlin.jvm.internal.k.e(array, "array");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(array);
                fileOutputStream.close();
                return xVar;
            } finally {
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<Object> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidRemoteCacheDataSource(w ioDispatcher, CreateFile createFile, GetFileExtensionFromUrl getFileExtensionFromUrl, HttpClient httpClient) {
        kotlin.jvm.internal.k.e(ioDispatcher, "ioDispatcher");
        kotlin.jvm.internal.k.e(createFile, "createFile");
        kotlin.jvm.internal.k.e(getFileExtensionFromUrl, "getFileExtensionFromUrl");
        kotlin.jvm.internal.k.e(httpClient, "httpClient");
        this.ioDispatcher = ioDispatcher;
        this.createFile = createFile;
        this.getFileExtensionFromUrl = getFileExtensionFromUrl;
        this.httpClient = httpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(String str, Integer num, v5.c<? super HttpResponse> cVar) {
        return this.httpClient.execute(new HttpRequest(str, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, num != null ? num.intValue() : Integer.MAX_VALUE, 65534, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveToCache(File file, Object obj, v5.c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(obj, file, null), this.ioDispatcher, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // com.unity3d.ads.core.data.datasource.CacheDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getFile(java.io.File r13, java.lang.String r14, java.lang.String r15, java.lang.Integer r16, v5.c<? super com.unity3d.ads.core.data.model.CacheResult> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource.getFile(java.io.File, java.lang.String, java.lang.String, java.lang.Integer, v5.c):java.lang.Object");
    }
}
