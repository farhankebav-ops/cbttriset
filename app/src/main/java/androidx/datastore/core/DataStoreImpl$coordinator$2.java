package androidx.datastore.core;

import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$coordinator$2 extends l implements e6.a {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$coordinator$2(DataStoreImpl<T> dataStoreImpl) {
        super(0);
        this.this$0 = dataStoreImpl;
    }

    @Override // e6.a
    public final InterProcessCoordinator invoke() {
        return this.this$0.getStorageConnection$datastore_core_release().getCoordinator();
    }
}
