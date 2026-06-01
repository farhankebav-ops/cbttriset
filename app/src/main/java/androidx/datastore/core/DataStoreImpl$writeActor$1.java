package androidx.datastore.core;

import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$writeActor$1 extends l implements e6.l {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeActor$1(DataStoreImpl<T> dataStoreImpl) {
        super(1);
        this.this$0 = dataStoreImpl;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f13520a;
    }

    public final void invoke(Throwable th) {
        if (th != null) {
            ((DataStoreImpl) this.this$0).inMemoryCache.tryUpdate(new Final(th));
        }
        if (((DataStoreImpl) this.this$0).storageConnectionDelegate.isInitialized()) {
            this.this$0.getStorageConnection$datastore_core_release().close();
        }
    }
}
