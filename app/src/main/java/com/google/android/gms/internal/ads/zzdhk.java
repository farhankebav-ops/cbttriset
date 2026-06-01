package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdhk extends zzdem {
    public zzdhk(Set set) {
        super(set);
    }

    public final synchronized void zza(@Nullable final com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhj
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdhh) obj).zzd(zzbjVar);
            }
        });
    }

    public final synchronized void zzb(@Nullable final String str) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhi
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdhh) obj).zze(str);
            }
        });
    }
}
