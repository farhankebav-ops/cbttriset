package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfvp implements zzifh {
    private final zzifq zza;

    private zzfvp(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfvp zza(zzifq zzifqVar) {
        return new zzfvp(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = ((zzcjt) this.zza).zza();
        kotlin.jvm.internal.k.e(context, "context");
        DataStore dataStoreCreate$default = DataStoreFactory.create$default(DataStoreFactory.INSTANCE, zzfvn.zza, null, null, null, new e6.a() { // from class: com.google.android.gms.internal.ads.zzfvo
            @Override // e6.a
            public final /* synthetic */ Object invoke() {
                return DataStoreFile.dataStoreFile(context, "ad_quality_data.pb");
            }
        }, 14, null);
        zzifp.zzb(dataStoreCreate$default);
        return dataStoreCreate$default;
    }
}
