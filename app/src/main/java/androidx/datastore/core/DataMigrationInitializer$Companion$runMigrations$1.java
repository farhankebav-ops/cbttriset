package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import com.vungle.ads.internal.protos.Sdk;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE}, m = "runMigrations")
public final class DataMigrationInitializer$Companion$runMigrations$1<T> extends c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataMigrationInitializer.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, v5.c<? super DataMigrationInitializer$Companion$runMigrations$1> cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runMigrations(null, null, this);
    }
}
