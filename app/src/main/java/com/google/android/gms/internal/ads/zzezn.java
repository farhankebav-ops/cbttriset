package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezn implements zzeya {
    final zzgus zza;

    public zzezn(zzbdi zzbdiVar, zzgus zzgusVar, Context context) {
        this.zza = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzezm
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzezo(new JSONObject());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 45;
    }
}
