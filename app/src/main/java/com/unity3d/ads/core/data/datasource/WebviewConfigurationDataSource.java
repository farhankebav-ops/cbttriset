package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import e6.p;
import e6.q;
import kotlin.jvm.internal.k;
import q5.x;
import t6.f;
import t6.s;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebviewConfigurationDataSource {
    private final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webviewConfigurationStore;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$get$2", f = "WebviewConfigurationDataSource.kt", l = {15}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements q {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(3, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                f fVar = (f) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (!(th instanceof CorruptionException)) {
                    throw th;
                }
                WebviewConfigurationStore.WebViewConfigurationStore defaultInstance = WebviewConfigurationStore.WebViewConfigurationStore.getDefaultInstance();
                k.d(defaultInstance, "getDefaultInstance()");
                this.L$0 = null;
                this.label = 1;
                if (fVar.emit(defaultInstance, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.q
        public final Object invoke(f fVar, Throwable th, c<? super x> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = fVar;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$set$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$set$2", f = "WebviewConfigurationDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class C28812 extends i implements p {
        final /* synthetic */ WebviewConfigurationStore.WebViewConfigurationStore $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28812(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, c<? super C28812> cVar) {
            super(2, cVar);
            this.$data = webViewConfigurationStore;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C28812(this.$data, cVar);
        }

        @Override // e6.p
        public final Object invoke(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, c<? super WebviewConfigurationStore.WebViewConfigurationStore> cVar) {
            return ((C28812) create(webViewConfigurationStore, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return this.$data;
        }
    }

    public WebviewConfigurationDataSource(DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webviewConfigurationStore) {
        k.e(webviewConfigurationStore, "webviewConfigurationStore");
        this.webviewConfigurationStore = webviewConfigurationStore;
    }

    public final Object get(c<? super WebviewConfigurationStore.WebViewConfigurationStore> cVar) {
        return x0.l(new s(this.webviewConfigurationStore.getData(), new AnonymousClass2(null)), cVar);
    }

    public final Object set(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, c<? super x> cVar) {
        Object objUpdateData = this.webviewConfigurationStore.updateData(new C28812(webViewConfigurationStore, null), cVar);
        return objUpdateData == a.f17774a ? objUpdateData : x.f13520a;
    }
}
