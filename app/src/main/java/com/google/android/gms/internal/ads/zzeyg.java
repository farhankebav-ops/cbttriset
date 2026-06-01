package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyg implements zzeya {
    private final Context zza;
    private final zzgus zzb;

    public zzeyg(Context context, zzgus zzgusVar) {
        this.zza = context;
        this.zzb = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return ((Boolean) zzbgm.zzb.zze()).booleanValue() ? this.zzb.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyf
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        }) : zzgui.zza(new zzeyh(-1, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 59;
    }

    public final /* synthetic */ zzeyh zzc() {
        Context context = this.zza;
        return new zzeyh(zzbef.zzc(context), zzbef.zzd(context));
    }
}
