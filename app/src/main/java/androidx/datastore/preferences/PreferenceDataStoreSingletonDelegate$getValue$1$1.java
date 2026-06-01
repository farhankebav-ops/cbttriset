package androidx.datastore.preferences;

import android.content.Context;
import e6.a;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends l implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    @Override // e6.a
    public final File invoke() {
        Context applicationContext = this.$applicationContext;
        k.d(applicationContext, "applicationContext");
        return PreferenceDataStoreFile.preferencesDataStoreFile(applicationContext, this.this$0.name);
    }
}
