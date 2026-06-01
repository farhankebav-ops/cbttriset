package androidx.datastore;

import android.content.Context;
import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import l7.g0;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreSingletonDelegate$getValue$1$1 extends l implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    @Override // e6.a
    public final g0 invoke() {
        String str = g0.f12850b;
        Context applicationContext = this.$applicationContext;
        k.d(applicationContext, "applicationContext");
        String absolutePath = DataStoreFile.dataStoreFile(applicationContext, ((DataStoreSingletonDelegate) this.this$0).fileName).getAbsolutePath();
        k.d(absolutePath, "applicationContext.dataS…le(fileName).absolutePath");
        return f.d(absolutePath, false);
    }
}
