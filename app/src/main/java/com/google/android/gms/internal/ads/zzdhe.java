package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdhe extends zzdem implements zzbmp {
    public zzdhe(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final synchronized void zza() {
        zzs(zzdhd.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzb(@Nullable final zzbyh zzbyhVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhb
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzbmp) obj).zzb(zzbyhVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzc() {
        zzs(zzdhc.zza);
    }
}
