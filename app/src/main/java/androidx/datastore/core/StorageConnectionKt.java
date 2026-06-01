package androidx.datastore.core;

import e6.p;
import e6.q;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageConnectionKt {

    /* JADX INFO: renamed from: androidx.datastore.core.StorageConnectionKt$readData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements q {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(3, cVar);
        }

        public final Object invoke(ReadScope<T> readScope, boolean z2, c<? super T> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = readScope;
            return anonymousClass2.invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return obj;
            }
            r2.q.z0(obj);
            ReadScope readScope = (ReadScope) this.L$0;
            this.label = 1;
            Object data = readScope.readData(this);
            return data == aVar ? aVar : data;
        }

        @Override // e6.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (c) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.StorageConnectionKt$writeData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", l = {77}, m = "invokeSuspend")
    public static final class C03522 extends i implements p {
        final /* synthetic */ T $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03522(T t3, c<? super C03522> cVar) {
            super(2, cVar);
            this.$value = t3;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            C03522 c03522 = new C03522(this.$value, cVar);
            c03522.L$0 = obj;
            return c03522;
        }

        @Override // e6.p
        public final Object invoke(WriteScope<T> writeScope, c<? super x> cVar) {
            return ((C03522) create(writeScope, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                WriteScope writeScope = (WriteScope) this.L$0;
                T t3 = this.$value;
                this.label = 1;
                if (writeScope.writeData(t3, this) == aVar) {
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object readData(StorageConnection<T> storageConnection, c<? super T> cVar) {
        return storageConnection.readScope(new AnonymousClass2(null), cVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t3, c<? super x> cVar) {
        Object objWriteScope = storageConnection.writeScope(new C03522(t3, null), cVar);
        return objWriteScope == w5.a.f17774a ? objWriteScope : x.f13520a;
    }
}
