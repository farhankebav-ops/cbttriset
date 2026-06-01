package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeru implements zzeya {
    private final zzgus zza;
    private final VersionInfoParcel zzb;

    public zzeru(VersionInfoParcel versionInfoParcel, zzgus zzgusVar) {
        this.zzb = versionInfoParcel;
        this.zza = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzert
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 54;
    }

    public final /* synthetic */ zzerv zzc() {
        return zzerv.zzc(this.zzb);
    }
}
