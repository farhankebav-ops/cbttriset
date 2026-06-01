package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import com.google.protobuf.ByteString;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
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
public final class UniversalRequestDataSource {
    private final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestStore;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$get$2", f = "UniversalRequestDataSource.kt", l = {16}, m = "invokeSuspend")
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
                UniversalRequestStoreOuterClass.UniversalRequestStore defaultInstance = UniversalRequestStoreOuterClass.UniversalRequestStore.getDefaultInstance();
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

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2", f = "UniversalRequestDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class C28792 extends i implements p {
        final /* synthetic */ String $key;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28792(String str, c<? super C28792> cVar) {
            super(2, cVar);
            this.$key = str;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            C28792 c28792 = new C28792(this.$key, cVar);
            c28792.L$0 = obj;
            return c28792;
        }

        @Override // e6.p
        public final Object invoke(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, c<? super UniversalRequestStoreOuterClass.UniversalRequestStore> cVar) {
            return ((C28792) create(universalRequestStore, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = ((UniversalRequestStoreOuterClass.UniversalRequestStore) this.L$0).toBuilder();
            builder.removeUniversalRequestMap(this.$key);
            UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStoreBuild = builder.build();
            k.d(universalRequestStoreBuild, "dataBuilder.build()");
            return universalRequestStoreBuild;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$set$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$set$2", f = "UniversalRequestDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class C28802 extends i implements p {
        final /* synthetic */ ByteString $data;
        final /* synthetic */ String $key;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28802(String str, ByteString byteString, c<? super C28802> cVar) {
            super(2, cVar);
            this.$key = str;
            this.$data = byteString;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            C28802 c28802 = new C28802(this.$key, this.$data, cVar);
            c28802.L$0 = obj;
            return c28802;
        }

        @Override // e6.p
        public final Object invoke(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, c<? super UniversalRequestStoreOuterClass.UniversalRequestStore> cVar) {
            return ((C28802) create(universalRequestStore, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = ((UniversalRequestStoreOuterClass.UniversalRequestStore) this.L$0).toBuilder();
            builder.putUniversalRequestMap(this.$key, this.$data);
            UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStoreBuild = builder.build();
            k.d(universalRequestStoreBuild, "dataBuilder.build()");
            return universalRequestStoreBuild;
        }
    }

    public UniversalRequestDataSource(DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestStore) {
        k.e(universalRequestStore, "universalRequestStore");
        this.universalRequestStore = universalRequestStore;
    }

    public final Object get(c<? super UniversalRequestStoreOuterClass.UniversalRequestStore> cVar) {
        return x0.l(new s(this.universalRequestStore.getData(), new AnonymousClass2(null)), cVar);
    }

    public final Object remove(String str, c<? super x> cVar) {
        Object objUpdateData = this.universalRequestStore.updateData(new C28792(str, null), cVar);
        return objUpdateData == a.f17774a ? objUpdateData : x.f13520a;
    }

    public final Object set(String str, ByteString byteString, c<? super x> cVar) {
        Object objUpdateData = this.universalRequestStore.updateData(new C28802(str, byteString, null), cVar);
        return objUpdateData == a.f17774a ? objUpdateData : x.f13520a;
    }
}
